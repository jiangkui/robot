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
import java.util.ListIterator;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 开奖任务
 * Created by ljk on 16-1-3.
 */
public class PeriodWinnerTask extends AbstractBaseTask {

    //http://1.163.com/goods/getPeriod.do?gid=898&period=212310462
    public static final String BASE_URL = "http://1.163.com/goods/getPeriod.do?";
    private static Logger logger = LoggerFactory.getLogger(PeriodWinnerTask.class);

    private YiYuanDuoBaoService yiYuanDuoBaoService;
    private Long perid;
    private Long gid;

    public PeriodWinnerTask(Long perid, Long gid, YiYuanDuoBaoService yiYuanDuoBaoService) {
        this.perid = perid;
        this.gid = gid;
        this.yiYuanDuoBaoService = yiYuanDuoBaoService;
    }

    @Override
    public void execute() {
        //继续抓取
        PeriodWinner periodWinner = yiYuanDuoBaoService.queryOldPeriodWinnerByGid(gid);
        if (periodWinner != null) {
            perid = periodWinner.getPeriod();
        }

        Random random = new Random();
        int exist = 0;
        while (true) {
//        for (int i = 0; i < 1; i++) {

            String url = obtainUrl();
            try {
                String resultStr = HttpClientUtil.executeUrl(url);

                JSONObject jsonObject = JSONObject.fromObject(resultStr);

                Object code = jsonObject.get("code");

                if (code == null) {
                    logger.error("code = null");
                    continue;
                }

                Integer codeInt = (Integer) code;

                if (codeInt != 0) {
                    //被屏蔽了，切换代理
                    exist++;
                    logger.error("code != 0 次数：" + exist);
                    if (exist > 10) {
                        break;
                    }
                    continue;
                }

                analysisJsonAndSaveDate(jsonObject, this);

                int sleep = random.nextInt(100);
                logger.info("沉睡：" + sleep + "毫秒");
                TimeUnit.MILLISECONDS.sleep(sleep);
            } catch (Exception e) {
                logger.error("报错了" + e.getMessage());
//                e.printStackTrace();
            }
        }
    }

    private void analysisJsonAndSaveDate(JSONObject jsonObject, PeriodWinnerTask periodWinnerTask) {
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

            //设置本次的数据
            periodWinnerTask.setGid(gid);
            periodWinnerTask.setPerid(period);
            return;
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

        //设置本次的数据
        periodWinnerTask.setGid(periodWinner.getGid());
        periodWinnerTask.setPerid(periodWinner.getPeriod());

        yiYuanDuoBaoService.savePeriodWinnerByNotExist(periodWinner);
        yiYuanDuoBaoService.saveUserByNotExist(user);
        yiYuanDuoBaoService.saveGoodsByNotExist(goods);
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
        sb.append(BASE_URL).append("gid=").append(gid).append("&period=").append(perid).append("&navigation=-1");

        logger.info("请求地址：" + sb.toString());
        return sb.toString();
    }

    public Long getPerid() {
        return perid;
    }

    public void setPerid(Long perid) {
        this.perid = perid;
    }

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }
}
