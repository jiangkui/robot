package com.ljkdream.task.yiyuanduobao;

import com.ljkdream.model.Goods;
import com.ljkdream.model.PeriodWinner;
import com.ljkdream.model.User;
import com.ljkdream.service.YiYuanDuoBaoService;
import com.ljkdream.task.base.AbstractBaseTask;
import com.ljkdream.util.HttpClientUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 单个商品开奖结果数据抓取任务
 * <p/>
 * 指定某一个商品 id 和期号，从这个商品的设置期号开始向后抓取数据。
 * 如果请求失败，将更换 http代理，重新尝试抓取。
 * <p/>
 * 遇到一下情况会放弃任务：
 * - 当前抓取的期数，之前已经抓去过了
 * - 全部抓取完毕或尝试次数超过 DEFAULT_RETRY_NUM 为止。
 * <p/>
 * Created by ljk on 16-1-3.
 */
public class PeriodWinnerTask extends AbstractBaseTask {

    //http://1.163.com/goods/getPeriod.do?gid=898&period=212310462
    public static final String BASE_URL = "http://1.163.com/goods/getPeriod.do?";
    private static Logger logger = LoggerFactory.getLogger(PeriodWinnerTask.class);

    private Long period;
    private Long gid;
    private YiYuanDuoBaoService yiYuanDuoBaoService;
    private Integer executeNum; //该任务执行次数

    private static Random random = new Random();
    private int retryNum = 0; //更换代理重试请求的次数
    public static final int DEFAULT_RETRY_NUM = 2; //超过重试次数就放弃

    public PeriodWinnerTask(Long period, Long gid, YiYuanDuoBaoService yiYuanDuoBaoService) {
        this(period, gid, yiYuanDuoBaoService, Integer.MAX_VALUE);
    }

    public PeriodWinnerTask(Long period, Long gid, YiYuanDuoBaoService yiYuanDuoBaoService, Integer executeNum) {
        this.period = period;
        this.gid = gid;
        this.executeNum = executeNum;
        this.yiYuanDuoBaoService = yiYuanDuoBaoService;
    }

    @Override
    public void execute() {
        //如果该 period 已经抓去过，则获取该商品最早的期数，尝试继续抓取
        PeriodWinner periodWinner = yiYuanDuoBaoService.queryPeriodWinnerByPeriod(period);
        if (periodWinner != null) {
            logger.info("改期已经抓取完毕！ 期号：" + period);
            PeriodWinner oldDate = yiYuanDuoBaoService.queryOldPeriodWinnerByGid(gid);
            period = oldDate.getPeriod();
        }

        for (int i = 0; i < executeNum; i++) {
            try {
                String url = obtainUrl();
                String resultStr = HttpClientUtil.executeUrl(url);
                JSONObject jsonObject = JSONObject.fromObject(resultStr);

                Object code = jsonObject.get("code");

                //目标服务器返回结果异常
                if (code == null || ((Integer) code) != 0) {
                    if (changeProxyRetry()) { //更换http 代理，重试
                        continue;
                    } else {
                        return;
                    }
                } else {
                    retryNum = 0;
                }

                //解析json 存储数据
                GidAndPeriodId gidAndPeriodId = analysisJsonAndSaveDate(jsonObject);

                //设置下一次请求的数据
                setNextRequestDate(gidAndPeriodId);

                //沉睡一段时间
                sleep();

            } catch (Exception e) {
                logger.error("报错了" + e.getMessage());
            }
        }
    }

    /**
     * 设置下次请求的数据
     *
     * @param gidAndPeriodId gid 和 periodId
     */
    private void setNextRequestDate(GidAndPeriodId gidAndPeriodId) {
        this.setGid(gidAndPeriodId.getGid());
        this.setPeriod(gidAndPeriodId.getPeriod());
    }

    /**
     * 更换代理重试
     *
     * @return true 可以继续 false 超过重试次数
     */
    private boolean changeProxyRetry() {
        //被屏蔽了，切换代理
        retryNum++;
        logger.error("被屏蔽了或被限制，重试次数：" + retryNum);
        if (retryNum >= DEFAULT_RETRY_NUM) {
            logger.error("被屏蔽！ ");
            return false;
        }
        return true;
    }

    /**
     * 暂停一段时间
     */
    private void sleep() {
        try {
            int sleep = random.nextInt(500) + 1000;
            logger.info("沉睡：" + sleep + "毫秒");
            TimeUnit.MILLISECONDS.sleep(sleep);
        } catch (InterruptedException ignored) {
        }
    }

    private GidAndPeriodId analysisJsonAndSaveDate(JSONObject jsonObject) {
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

        yiYuanDuoBaoService.savePeriodWinnerByNotExist(periodWinner);
        yiYuanDuoBaoService.saveUserByNotExist(user);
        yiYuanDuoBaoService.saveGoodsByNotExist(goods);
        return new GidAndPeriodId(gid, period);
    }

    private Goods createGoods(JSONObject json) {
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

    private PeriodWinner cratePeriodWinner(JSONObject json) {
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

    public String obtainUrl() {
        StringBuilder sb = new StringBuilder();
        //&navigation=-1 表示前一期 =1 表示后一期
        sb.append(BASE_URL).append("gid=").append(gid).append("&period=").append(period).append("&navigation=-1");

        logger.info("请求地址：" + sb.toString());
        return sb.toString();
    }

    @Override
    public String toString() {
        return "单商品抓取任务{" +
                "gid=" + gid +
                ", period=" + period +
                '}';
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

/**
 * gid 和 periodId 的一个包装对象。用来传递 这俩id数据
 */
class GidAndPeriodId {
    private long gid;
    private long period;

    public GidAndPeriodId(long gid, long period) {
        this.gid = gid;
        this.period = period;
    }

    public long getGid() {
        return gid;
    }

    public void setGid(long gid) {
        this.gid = gid;
    }

    public long getPeriod() {
        return period;
    }

    public void setPeriod(long period) {
        this.period = period;
    }
}