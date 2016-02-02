package com.ljkdream.yiyuanduobao.task;

import com.ljkdream.core.util.HttpClientUtil;
import com.ljkdream.proxy.model.ProxyServerIpAddress;
import com.ljkdream.proxy.service.ProxyServiceIpAddressService;
import com.ljkdream.yiyuanduobao.entity.GidAndPeriodId;
import com.ljkdream.yiyuanduobao.model.PeriodWinner;
import com.ljkdream.yiyuanduobao.service.RelationGoodsPeriodService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
public class PeriodWinnerBackwardTask extends BasePeriodWinnerTask {

    private static Logger logger = LoggerFactory.getLogger(PeriodWinnerBackwardTask.class);

    public PeriodWinnerBackwardTask(Long gid, RelationGoodsPeriodService yiYuanDuoBaoService,
                                    ProxyServiceIpAddressService proxyServiceIpAddressService) {
        this(-1L, gid, yiYuanDuoBaoService, proxyServiceIpAddressService);
    }


    public PeriodWinnerBackwardTask(Long period, Long gid, RelationGoodsPeriodService yiYuanDuoBaoService,
                                    ProxyServiceIpAddressService proxyServiceIpAddressService) {
        this(period, gid, yiYuanDuoBaoService, proxyServiceIpAddressService, Integer.MAX_VALUE);
    }

    public PeriodWinnerBackwardTask(Long period, Long gid, RelationGoodsPeriodService yiYuanDuoBaoService,
                                    ProxyServiceIpAddressService proxyServiceIpAddressService, Integer executeNum) {
        this.period = period;
        this.gid = gid;
        this.executeNum = executeNum;
        this.yiYuanDuoBaoService = yiYuanDuoBaoService;
        this.proxyServiceIpAddressService = proxyServiceIpAddressService;
    }

    @Override
    public void execute() {
        if (period < 0) {
            PeriodWinner winner = periodWinnerService.queryNewPeriodWinnerByGid(gid);
            period = winner.getPeriod();
        }
        int successNum = 0;
        for (int i = 0; i < executeNum; i++) {
            try {
                //沉睡一段时间
                sleep();

                String url = obtainUrl();
                ProxyServerIpAddress proxy = proxyServiceIpAddressService.obtainProxy(proxyStrList);
                String resultStr = HttpClientUtil.executeByProxy(url, proxy);
                JSONObject jsonObject = JSONObject.fromObject(resultStr);

                Object code = jsonObject.get("code");

                //目标服务器返回结果异常
                if (code == null || ((Integer) code) != 0) {
                    if (((Integer) code) == -16) {
                        logger.info("抓取完毕！");
                        return;
                    }

                    logger.warn("code = " + code);
                    if (changeProxyRetry()) { //更换http 代理，重试
                        continue;
                    } else {
                        logger.error("任务停止于： gid:" + gid + " period:" + period);
                        return;
                    }
                } else {
                    retryNum = 0;
                }

                //未开奖
                if (!hasPeriodWinner(jsonObject)) {
                    logger.error("未开奖！任务停止于： gid:" + gid + " period:" + period);
                    return;
                }

                //获取 gid 和 periodId
                GidAndPeriodId gidAndPeriodId = analysisJson(jsonObject);

                //存储数据
                saveDate(jsonObject);

                //设置下一次请求的数据
                setNextRequestDate(gidAndPeriodId);
                successNum++;
            } catch (Exception e) {
                changeProxyRetry();
                e.printStackTrace();
            }
        }

        proxyServiceIpAddressService.clearProxy();
        logger.error("向后抓取:  gid:" + gid + " period:" + period +
                "，共完成：" + successNum + "个任务！");
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
}
