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
 * 向前抓取 已开奖数据
 * Created by ljk on 16-1-11.
 */
public class PeriodWinnerForwardTask extends BasePeriodWinnerTask {

    private static Logger logger = LoggerFactory.getLogger(PeriodWinnerForwardTask.class);

    public PeriodWinnerForwardTask(Long gid, RelationGoodsPeriodService yiYuanDuoBaoService,
                                   ProxyServiceIpAddressService proxyServiceIpAddressService) {
        this(-1L, gid, yiYuanDuoBaoService, proxyServiceIpAddressService);
    }

    public PeriodWinnerForwardTask(Long period, Long gid, RelationGoodsPeriodService yiYuanDuoBaoService,
                                   ProxyServiceIpAddressService proxyServiceIpAddressService) {
        this(period, gid, yiYuanDuoBaoService, proxyServiceIpAddressService, Integer.MAX_VALUE);
    }

    public PeriodWinnerForwardTask(Long period, Long gid, RelationGoodsPeriodService yiYuanDuoBaoService,
                                   ProxyServiceIpAddressService proxyServiceIpAddressService, Integer executeNum) {
        this.period = period;
        this.gid = gid;
        this.executeNum = executeNum;
        this.yiYuanDuoBaoService = yiYuanDuoBaoService;
        this.proxyServiceIpAddressService = proxyServiceIpAddressService;
    }

    @Override
    public void execute() {
        //如果数据库中已经有该商品的开奖记录了，则从改期开始向前抓取，如果没有，则使用传入的旗号。
        PeriodWinner winner = yiYuanDuoBaoService.queryNewPeriodWinnerByGid(gid);
        if (period != null) {
            period = winner.getPeriod();
        }

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
                    logger.warn("code = " + code);
                    if (((Integer) code) == -16) {
                        logger.info("抓取完毕！");
                        return;
                    }

                    if (changeProxyRetry()) { //更换http 代理，重试
                        continue;
                    } else {
                        logger.error("任务停止于： gid:" +gid + " period:" + period);
                        return;
                    }
                } else {
                    retryNum = 0;
                }

                //未开奖
                if (!hasPeriodWinner(jsonObject)) {
                    logger.error("未开奖！任务停止于： gid:" +gid + " period:" + period);
                    return;
                }

                //获取 gid 和 periodId
                GidAndPeriodId gidAndPeriodId = analysisJson(jsonObject);

                //存储数据
                saveDate(jsonObject);

                //设置下一次请求的数据
                setNextRequestDate(gidAndPeriodId);
            } catch (Exception e) {
                changeProxyRetry();
                e.printStackTrace();
            }
        }

        proxyServiceIpAddressService.clearProxy();
    }

    public String obtainUrl() {
        StringBuilder sb = new StringBuilder();
        //&navigation=-1 表示旧一期  =1 表示新一期
        sb.append(BASE_URL).append("gid=").append(gid).append("&period=").append(period).append("&navigation=1");

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
