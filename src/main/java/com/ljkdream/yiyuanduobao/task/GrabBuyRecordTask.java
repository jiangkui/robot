package com.ljkdream.yiyuanduobao.task;

import com.ljkdream.core.task.TaskExecutorFactory;
import com.ljkdream.core.util.SpringUtil;
import com.ljkdream.proxy.service.ProxyServiceIpAddressService;
import com.ljkdream.yiyuanduobao.entity.GrabBuyRecordSub;
import com.ljkdream.yiyuanduobao.model.GrabBuyRecord;
import com.ljkdream.yiyuanduobao.model.PeriodWinner;
import com.ljkdream.yiyuanduobao.service.GrabBuyRecordService;
import com.ljkdream.yiyuanduobao.service.PeriodWinnerService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 抓取购买记录 Task
 * Created by ljk on 16-2-2.
 */
public class GrabBuyRecordTask extends YiYuanDuoBaoBaseTask {

    private static Logger logger = LoggerFactory.getLogger(GrabBuyRecordTask.class);
    public static final int DEFAULT_PAGE_SIZE = 100;//默认每页条数

    private static GrabBuyRecordService grabBuyRecordService;
    private static PeriodWinnerService periodWinnerService;

    private int num;

    public GrabBuyRecordTask(int num) {
        this.num = num;
    }

    @Override
    public void initService() {
        if (grabBuyRecordService == null) {
            grabBuyRecordService = SpringUtil.getBean(GrabBuyRecordService.class);
        }
        if (periodWinnerService == null) {
            periodWinnerService = SpringUtil.getBean(PeriodWinnerService.class);
        }
        if (proxyServiceIpAddressService == null) {
            proxyServiceIpAddressService = SpringUtil.getBean(ProxyServiceIpAddressService.class);
        }
    }

    @Override
    public void execute() {
        try {
            for (int i = 0; i < num; i++) {
                boolean success = executeTask();
                if (!success) break;
            }

            logger.info("任务执行完毕！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean executeTask() throws IOException, InterruptedException {
        GrabBuyRecord grabBuyRecord = grabBuyRecordService.obtainGrabTask();
        if (grabBuyRecord == null) {
            logger.error("没有下一个抓取任务了！");
            return false;
        }

        logger.info("执行抓取参与记录任务：" + grabBuyRecord);

        JSONObject jsonObject = this.obtainDate(grabBuyRecord.getUrl());
        if (jsonObject == null) {
            return false;
        }

        Object totalCntObj = jsonObject.getJSONObject("result").get("totalCnt");
        if (totalCntObj == null || (int) totalCntObj < 1) {
            logger.error("totalCnt 异常;" + grabBuyRecord.getUrl());
            return false;
        }

        //生成多个小任务，使用 countDownLatch 进行同步。
        int totalCnt = (int) totalCntObj;
        grabBuyRecord.setTotalCnt(totalCnt);
        int subTaskNum = obtainSubTaskNum(totalCnt);

        //插入 grabBuyRecord 记录
        if (grabBuyRecord.getId() == null) {
            boolean success = grabBuyRecordService.insertAndTry(grabBuyRecord);
            if (!success) return false;
        }

        //提交多个任务
        CountDownLatch countDownLatch = new CountDownLatch(subTaskNum);
        List<GrabBuyRecordSubTask> subTaskList = createSubTask(grabBuyRecord, countDownLatch, subTaskNum);

        for (GrabBuyRecordSubTask grabBuyRecordSubTask : subTaskList) {
            TaskExecutorFactory.getInstance().submitTask(grabBuyRecordSubTask);
        }

        assert subTaskList.size() == subTaskNum;

        //线程同步
        countDownLatch.await();

        //更新抓取成功
        grabBuyRecordService.updateStatusById(grabBuyRecord.getId(), GrabBuyRecord.STATUS_SUCCESS);
        return true;
    }

    private int obtainSubTaskNum(int totalCnt) {
        int num = totalCnt / DEFAULT_PAGE_SIZE;

        if (totalCnt % DEFAULT_PAGE_SIZE > 0) {
            num++;
        }

        return num;
    }

    private List<GrabBuyRecordSubTask> createSubTask(GrabBuyRecord grabBuyRecord, CountDownLatch countDownLatch, int subTaskNum) {
        List<GrabBuyRecordSubTask> list = new ArrayList<>();
        Integer totalCnt = grabBuyRecord.getTotalCnt();
        Long gid = grabBuyRecord.getGid();
        Long period = grabBuyRecord.getPeriod();

        for (int pageNum = 1; pageNum <= subTaskNum; pageNum++) {
            GrabBuyRecordSub grabBuyRecordSub = new GrabBuyRecordSub(pageNum, DEFAULT_PAGE_SIZE, totalCnt, gid, period);
            GrabBuyRecordSubTask grabBuyRecordSubTask = new GrabBuyRecordSubTask(grabBuyRecordSub, countDownLatch);
            list.add(grabBuyRecordSubTask);
        }

        return list;
    }

    public static GrabBuyRecord createGrabBuyRecord(PeriodWinner periodWinner) {
        String url = generateUrl(periodWinner.getGid(), periodWinner.getPeriod(), 1, 1, 0);
        GrabBuyRecord grabBuyRecord = new GrabBuyRecord();
        grabBuyRecord.setGid(periodWinner.getGid());
        grabBuyRecord.setPeriod(periodWinner.getPeriod());
        grabBuyRecord.setUrl(url);
        grabBuyRecord.setStatus(GrabBuyRecord.STATUS_DEFAULT);
        grabBuyRecord.setCreateTime(new Date());
        return grabBuyRecord;
    }

    public static String generateUrl(Long gid, Long period, int pageNum, int pageSize, int totalCnt) {
        //http://1.163.com/record/getDuobaoRecord.do?pageNum=1&pageSize=1&totalCnt=0&gid=896&period=302032116

        String url = "http://1.163.com/record/getDuobaoRecord.do?" +
                "pageNum=" + pageNum +
                "&pageSize=" + pageSize +
                "&totalCnt=" + totalCnt +
                "&gid=" + gid +
                "&period=" + period;

        return url;
    }
}
