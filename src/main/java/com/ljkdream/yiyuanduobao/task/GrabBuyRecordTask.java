package com.ljkdream.yiyuanduobao.task;

import com.ljkdream.core.task.AbstractBaseTask;
import com.ljkdream.core.task.TaskExecutorFactory;
import com.ljkdream.core.util.HttpClientUtil;
import com.ljkdream.core.util.SpringUtil;
import com.ljkdream.proxy.model.ProxyServerIpAddress;
import com.ljkdream.proxy.service.ProxyServiceIpAddressService;
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
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * 抓取购买记录 Task
 * Created by ljk on 16-2-2.
 */
public class GrabBuyRecordTask extends AbstractBaseTask {

    private static Logger logger = LoggerFactory.getLogger(GrabBuyRecordTask.class);
    protected static List<String> proxyStrList = new ArrayList<>();
    public static final int DEFAULT_PAGE_SIZE = 100;//默认每页条数

    private static GrabBuyRecordService grabBuyRecordService;
    private static PeriodWinnerService periodWinnerService;
    protected static ProxyServiceIpAddressService proxyServiceIpAddressService;

    static {
        proxyStrList.add("CN");
    }

    private int retryNum = 0;
    public static final int MAX_RETRY_NUM = 10;//重试次数

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
            for (int i = 0; i < 1; i++) {
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
            logger.error("grabBuyRecord 为空！");
            return false;
        }

        JSONObject jsonObject = this.obtainJsonObject(grabBuyRecord);
        if (jsonObject == null) {
            return false;
        }

        JSONObject result = jsonObject.getJSONObject("result");
        if (result.isEmpty()) {
            logger.error("没有获取到result" + grabBuyRecord);
            return false;
        }

        Object totalCntObj = jsonObject.get("totalCnt");
        if (totalCntObj == null || (int) totalCntObj < 1) {
            logger.error("totalCnt 异常：" + grabBuyRecord);
            return false;
        }

        //生成多个小任务，使用某种方式进行同步。
        int totalCnt = (int) totalCntObj;
        grabBuyRecord.setTotalCnt(totalCnt);
        int subTaskNum = obtainSubTaskNum(totalCnt);

        //插入 grabBuyRecord 记录
        boolean success = grabBuyRecordService.insertAndTry(grabBuyRecord);
        if (!success) return false;

        CountDownLatch countDownLatch = new CountDownLatch(subTaskNum);
        List<GrabBuyRecordSubTask> subTaskList = createSubTask(grabBuyRecord, countDownLatch, subTaskNum);

        //提交多个任务
        for (GrabBuyRecordSubTask grabBuyRecordSubTask : subTaskList) {
            TaskExecutorFactory.getInstance().submitTask(grabBuyRecordSubTask);
        }

        countDownLatch.await();
        return true;
    }

    private JSONObject obtainJsonObject(GrabBuyRecord grabBuyRecord) throws InterruptedException, IOException {
        ProxyServerIpAddress proxy = proxyServiceIpAddressService.obtainProxy(proxyStrList);
        String resultStr = HttpClientUtil.executeByProxy(grabBuyRecord.getUrl(), proxy);
        JSONObject jsonObject = JSONObject.fromObject(resultStr);
        Object code = jsonObject.get("code");

        //目标服务器返回结果异常
        if (code == null || ((Integer) code) != 0) {
            assert code != null;
            if (((Integer) code) == -16) {
                logger.info("抓取完毕！");
                return null;
            }

            if (retryNum++ >= MAX_RETRY_NUM) {
                logger.error("重试次数：" + retryNum + "过多。" + grabBuyRecord);
            }
            TimeUnit.MILLISECONDS.sleep(random.nextInt(100));
        } else {
            retryNum = 0;
        }
        return jsonObject;
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
        for (int i = 0; i < subTaskNum; i++) {
            GrabBuyRecordSubTask grabBuyRecordSubTask = new GrabBuyRecordSubTask(i, DEFAULT_PAGE_SIZE, grabBuyRecord, countDownLatch);
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
        grabBuyRecord.setStatus(GrabBuyRecord.STATUS_SUCCESS);
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
