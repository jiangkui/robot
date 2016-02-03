package com.ljkdream.yiyuanduobao.task;

import com.ljkdream.core.task.AbstractBaseTask;
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
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 抓取购买记录 Task
 * Created by ljk on 16-2-2.
 */
public class GrabBuyRecordTask extends AbstractBaseTask {

    private static Logger logger = LoggerFactory.getLogger(GrabBuyRecordTask.class);
    protected static List<String> proxyStrList = new ArrayList<>();

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
            GrabBuyRecord grabBuyRecord = grabBuyRecordService.queryByMax();
            if (grabBuyRecord == null) {
                PeriodWinner periodWinner = periodWinnerService.queryByMin();
                if (periodWinner == null) {
                    logger.warn("没有 periodWinner 记录");
                    return;
                }

                grabBuyRecord = this.createGrabBuyRecord(periodWinner);
            }

            ProxyServerIpAddress proxy = proxyServiceIpAddressService.obtainProxy(proxyStrList);
            String resultStr = HttpClientUtil.executeByProxy(grabBuyRecord.getUrl(), proxy);
            JSONObject jsonObject = JSONObject.fromObject(resultStr);
            Object code = jsonObject.get("code");

            //目标服务器返回结果异常
            if (code == null || ((Integer) code) != 0) {
                if (((Integer) code) == -16) {
                    logger.info("抓取完毕！");
                    return;
                }

                if (retryNum++ >= MAX_RETRY_NUM) {
                    logger.error("重试次数：" + retryNum + "过多。" + grabBuyRecord);
                }
                TimeUnit.MILLISECONDS.sleep(random.nextInt(100));
            } else {
                retryNum = 0;
            }

            JSONObject result = jsonObject.getJSONObject("result");
            if (result.isEmpty()) {
                logger.error("没有获取到result" + grabBuyRecord);
            }

            Object totalCnt = jsonObject.get("totalCnt");
            if (totalCnt == null || ((Integer) code) < 1) {
                logger.error("totalCnt 异常：" + grabBuyRecord);
            }

            //生成多个小任务，使用某种方式进行同步。

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private GrabBuyRecord createGrabBuyRecord(PeriodWinner periodWinner) {
        //http://1.163.com/record/getDuobaoRecord.do?pageNum=1&pageSize=1&totalCnt=0&gid=896&period=302032116

        return null;
    }
}
