package com.ljkdream.yiyuanduobao.task;

import com.ljkdream.core.task.AbstractBaseTask;
import com.ljkdream.proxy.service.ProxyServiceIpAddressService;
import com.ljkdream.yiyuanduobao.entity.GidAndPeriodId;
import com.ljkdream.yiyuanduobao.model.Goods;
import com.ljkdream.yiyuanduobao.model.GrabBuyRecord;
import com.ljkdream.yiyuanduobao.model.PeriodWinner;
import com.ljkdream.yiyuanduobao.model.User;
import com.ljkdream.yiyuanduobao.service.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * periodWinner Task 的基类，提供一些公用的方法
 * Created by ljk on 16-1-11.
 */
public abstract class BasePeriodWinnerTask extends AbstractBaseTask {

    private static Logger logger = LoggerFactory.getLogger(BasePeriodWinnerTask.class);

    //http://1.163.com/goods/getPeriod.do?gid=898&period=212310462
    public static final String BASE_URL = "http://1.163.com/goods/getPeriod.do?";
    public static final int DEFAULT_RETRY_NUM = 3; //超过重试次数就放弃
    protected static List<String> proxyStrList = new ArrayList<>();
    protected static Random random = new Random();

    static {
        proxyStrList.add("CN");
    }

    protected Long period;
    protected Long gid;
    protected Integer executeNum; //该任务执行次数
    protected volatile int retryNum = 0; //更换代理重试请求的次数

    protected static RelationGoodsPeriodService relationGoodsPeriodService;
    protected static PeriodWinnerService periodWinnerService;
    protected static GoodsService goodsService;
    protected static GrabBuyRecordService grabBuyRecordService;
    protected static UserService userService;
    protected static ProxyServiceIpAddressService proxyServiceIpAddressService;


    /**
     * 是否已经开奖
     *
     * @param jsonObject json
     * @return true 已开奖 false 未开奖
     */
    protected boolean hasPeriodWinner(JSONObject jsonObject) {
        JSONObject result = jsonObject.getJSONObject("result");
        JSONObject periodWinnerJson = result.getJSONObject("periodWinner");
        if (periodWinnerJson.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 解析 json
     * @param jsonObject json
     * @return gidAndPeriodId
     */
    protected GidAndPeriodId analysisJson(JSONObject jsonObject) {
        JSONObject result = jsonObject.getJSONObject("result");
        JSONObject periodWinnerJson = result.getJSONObject("periodWinner");
        if (periodWinnerJson.size() == 0) {
            JSONObject periodIng = result.getJSONObject("periodIng");
            JSONObject periodWillReveal = result.getJSONObject("periodWillReveal");
            long period = 0;
            long gid = 0;

            if (periodIng.size() != 0) {
                period = periodIng.getLong("period");
                gid = periodIng.getJSONObject("goods").getLong("gid");
                logger.info("正在投注! period:" + period + " gid:" + gid);
            } else {
                period = periodWillReveal.getLong("period");
                gid = periodWillReveal.getJSONObject("goods").getLong("gid");
                logger.info("等待开奖! period:" + period + " gid:" + gid);
            }

            return new GidAndPeriodId(gid, period);
        }

        PeriodWinner periodWinner = cratePeriodWinner(periodWinnerJson);

        return new GidAndPeriodId(periodWinner.getGid(), periodWinner.getPeriod());
    }

    /**
     * 设置下次请求的数据
     *
     * @param gidAndPeriodId gid 和 periodId
     */
    protected void setNextRequestDate(GidAndPeriodId gidAndPeriodId) {
        this.setGid(gidAndPeriodId.getGid());
        this.setPeriod(gidAndPeriodId.getPeriod());
    }

    /**
     * 更换代理重试
     *
     * @return true 可以继续 false 超过重试次数
     */
    protected boolean changeProxyRetry() {
        //被屏蔽了，切换代理
        retryNum++;
        logger.warn("更换代理重试：" + retryNum);
        if (retryNum >= DEFAULT_RETRY_NUM) {
            logger.error("重试次数超过" + retryNum + "，放弃该任务！");
            return false;
        }

        proxyServiceIpAddressService.changeProxy(proxyStrList);
        return true;
    }

    /**
     * 暂停一段时间
     */
    protected void sleep() {
        try {
            int sleep = random.nextInt(100);
//            logger.info("沉睡：" + sleep + "毫秒");
            TimeUnit.MILLISECONDS.sleep(sleep);
        } catch (InterruptedException ignored) {
        }
    }

    protected void saveDate(JSONObject jsonObject) {
        JSONObject result = jsonObject.getJSONObject("result");
        JSONObject periodWinnerJson = result.getJSONObject("periodWinner");

        JSONObject owner = periodWinnerJson.getJSONObject("owner");
        JSONObject goodsJson = periodWinnerJson.getJSONObject("goods");

        User user = (User) JSONObject.toBean(owner, User.class);
        Goods goods = createGoods(goodsJson);
        PeriodWinner periodWinner = cratePeriodWinner(periodWinnerJson);

        Date now = new Date();
        user.setCreateTime(now);
        user.setModifyTime(now);
        periodWinner.setCreateTime(now);
        periodWinner.setModifyTime(now);
        goods.setCreateTime(now);
        goods.setModifyTime(now);

        periodWinnerService.savePeriodWinnerByNotExist(periodWinner);
        userService.saveUserByNotExist(user);
        goodsService.saveGoodsByNotExist(goods);
    }

    protected Goods createGoods(JSONObject json) {
        JSONArray gpic = json.getJSONArray("gpic");
        StringBuilder sb = new StringBuilder();

        if (gpic != null && gpic.size() > 0) {
            for (int i = 0; i < gpic.size(); i++) {
                String pic = gpic.getString(i);
                sb.append(pic).append(",");
            }
        }

        json.put("gpic", sb.toString());

        Object o = JSONObject.toBean(json, Goods.class);
        Goods goods = (Goods) o;
        return goods;
    }

    protected PeriodWinner cratePeriodWinner(JSONObject json) {
        JSONObject owner = json.getJSONObject("owner");
        String cidStr = owner.getString("cid");
        Long cid = Long.parseLong(cidStr);

        JSONObject goods = json.getJSONObject("goods");
        long gid = goods.getLong("gid");

        long period = json.getLong("period");
        String ownerCost = json.getString("ownerCost");
        String luckyCode = json.getString("luckyCode");
        String status = json.getString("status");
        String cost = json.getString("cost");

        String duobaoTimeStr = json.getString("duobaoTime");
        String calcTimeStr = json.getString("calcTime");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date duobaoTime = null;
        Date calcTime = null;
        try {
            duobaoTime = simpleDateFormat.parse(duobaoTimeStr);
            calcTime = simpleDateFormat.parse(calcTimeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        PeriodWinner periodWinner = new PeriodWinner();
        periodWinner.setPeriod(period);
        periodWinner.setCid(cid);
        periodWinner.setGid(gid);
        periodWinner.setDuobaoTime(duobaoTime);
        periodWinner.setCalcTime(calcTime);
        periodWinner.setOwnerCost(ownerCost);
        periodWinner.setLuckyCode(luckyCode);
        periodWinner.setStatus(status);
        periodWinner.setCost(cost);
        periodWinner.setDuobaoTimeStr(duobaoTimeStr);
        periodWinner.setCalcTimeStr(calcTimeStr);
        return periodWinner;
    }

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public Long getPeriod() {
        return period;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }
}
