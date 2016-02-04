package com.ljkdream.yiyuanduobao.task;

import com.ljkdream.core.task.AbstractBaseTask;
import com.ljkdream.core.util.HttpClientUtil;
import com.ljkdream.core.util.SpringUtil;
import com.ljkdream.proxy.model.ProxyServerIpAddress;
import com.ljkdream.proxy.service.ProxyServiceIpAddressService;
import com.ljkdream.yiyuanduobao.entity.GrabBuyRecordSub;
import com.ljkdream.yiyuanduobao.model.BuyRecord;
import com.ljkdream.yiyuanduobao.model.GrabBuyRecord;
import com.ljkdream.yiyuanduobao.model.User;
import com.ljkdream.yiyuanduobao.service.GrabBuyRecordService;
import com.ljkdream.yiyuanduobao.service.PeriodWinnerService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 抓取参与记录的子任务
 * <p/>
 * Created by jiangkui on 16-2-3.
 */
public class GrabBuyRecordSubTask extends YiYuanDuoBaoBaseTask {

    private static Logger logger = LoggerFactory.getLogger(GrabBuyRecordTask.class);

    private static GrabBuyRecordService grabBuyRecordService;
    private static PeriodWinnerService periodWinnerService;
    private static ProxyServiceIpAddressService proxyServiceIpAddressService;

    private GrabBuyRecordSub grabBuyRecordSub;
    private CountDownLatch countDownLatch;

    public GrabBuyRecordSubTask(GrabBuyRecordSub grabBuyRecordSub, CountDownLatch countDownLatch) {
        this.grabBuyRecordSub = grabBuyRecordSub;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void execute() {
        try {
            JSONObject jsonObject = obtainDate(grabBuyRecordSub.getUrl());
            JSONArray jsonArray = jsonObject.getJSONObject("result").getJSONArray("list");
            if (jsonArray.isEmpty()) {
                logger.error("list 异常;" + grabBuyRecordSub.getUrl());
                return;
            }

            List<BuyRecord> buyRecordList = new ArrayList<>();
            List<User> userList = new ArrayList<>();

            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject grabJsonDate = jsonArray.getJSONObject(i);
                BuyRecord buyRecord = this.obtainBuyRecord(grabJsonDate, grabBuyRecordSub);
                User user = this.obtainUserDate(grabJsonDate);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }

    }

    private User obtainUserDate(JSONObject grabJsonDate) {
        return null;
    }

    private BuyRecord obtainBuyRecord(JSONObject grabJsonDate, GrabBuyRecordSub grabBuyRecordSub) {
        return null;
    }

    @Override
    public void initService() {
        if (proxyServiceIpAddressService == null) {
            proxyServiceIpAddressService = SpringUtil.getBean(ProxyServiceIpAddressService.class);
        }
    }


}
