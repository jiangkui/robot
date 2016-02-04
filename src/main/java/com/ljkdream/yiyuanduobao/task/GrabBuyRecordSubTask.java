package com.ljkdream.yiyuanduobao.task;

import com.ljkdream.core.util.SpringUtil;
import com.ljkdream.proxy.service.ProxyServiceIpAddressService;
import com.ljkdream.yiyuanduobao.entity.GrabBuyRecordSub;
import com.ljkdream.yiyuanduobao.model.BuyRecord;
import com.ljkdream.yiyuanduobao.model.User;
import com.ljkdream.yiyuanduobao.service.BuyRecordService;
import com.ljkdream.yiyuanduobao.service.UserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 抓取参与记录的子任务
 * <p/>
 * Created by jiangkui on 16-2-3.
 */
public class GrabBuyRecordSubTask extends YiYuanDuoBaoBaseTask {

    private static Logger logger = LoggerFactory.getLogger(GrabBuyRecordTask.class);

    private static UserService userService;
    private static BuyRecordService buyRecordService;

    private GrabBuyRecordSub grabBuyRecordSub;
    private CountDownLatch countDownLatch;

    public GrabBuyRecordSubTask(GrabBuyRecordSub grabBuyRecordSub, CountDownLatch countDownLatch) {
        this.grabBuyRecordSub = grabBuyRecordSub;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void execute() {
        try {
            String url = grabBuyRecordSub.getUrl();
            logger.info("抓取参与记录子任务：" + url);

            JSONObject jsonObject = obtainDate(url);
            JSONArray jsonArray = jsonObject.getJSONObject("result").getJSONArray("list");
            if (jsonArray.isEmpty()) {
                logger.error("list 异常;" + url);
                return;
            }

            List<BuyRecord> buyRecordList = new ArrayList<>();
            List<User> userList = new ArrayList<>();

            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject grabJsonDate = jsonArray.getJSONObject(i);
                User user = this.obtainUserDate(grabJsonDate);
                if (user == null) {
                    continue;
                }

                BuyRecord buyRecord = this.obtainBuyRecord(grabJsonDate, grabBuyRecordSub, user);
                buyRecordList.add(buyRecord);
                userList.add(user);
            }

            //存储数据
            userService.insertByList(userList);
            buyRecordService.insertByList(buyRecordList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }

    private User obtainUserDate(JSONObject grabJsonDate) {
        JSONObject user = grabJsonDate.getJSONObject("user");
        if (user.isEmpty()) {
            logger.error("抓取参与记录时用户为空！");
            return null;
        }
        User result = (User) JSONObject.toBean(user, User.class);
        return result;
    }

    private BuyRecord obtainBuyRecord(JSONObject grabJsonDate, GrabBuyRecordSub grabBuyRecordSub, User user) {
        int num = grabJsonDate.getInt("num");
        String time = grabJsonDate.getString("time");
        int rid = grabJsonDate.getInt("rid");
        String device = grabJsonDate.getString("device");
        int regularBuy = grabJsonDate.getInt("regularBuy");

        BuyRecord buyRecord = new BuyRecord();
        buyRecord.setGid(grabBuyRecordSub.getGid());
        buyRecord.setPeriod(grabBuyRecordSub.getPeriod());
        buyRecord.setNum(num);
        buyRecord.setTime(time);
        buyRecord.setCid(user.getCid());
        buyRecord.setUid(user.getUid());
        buyRecord.setNickname(user.getNickname());
        buyRecord.setIpAddress(user.getIPAddress());
        buyRecord.setIp(user.getIP());
        buyRecord.setRid(rid);
        buyRecord.setDevice(device);
        buyRecord.setRegularBuy(regularBuy);
        buyRecord.setCreateTime(new Date());

        return buyRecord;
    }

    @Override
    public void initService() {
        if (proxyServiceIpAddressService == null) {
            proxyServiceIpAddressService = SpringUtil.getBean(ProxyServiceIpAddressService.class);
        }
        if (userService == null) {
            userService = SpringUtil.getBean(UserService.class);
        }
        if (buyRecordService == null) {
            buyRecordService = SpringUtil.getBean(BuyRecordService.class);
        }
    }


}
