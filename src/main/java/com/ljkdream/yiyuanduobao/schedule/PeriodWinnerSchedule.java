package com.ljkdream.yiyuanduobao.schedule;

import com.ljkdream.core.task.TaskExecutorFactory;
import com.ljkdream.proxy.service.ProxyServiceIpAddressService;
import com.ljkdream.proxy.task.CnProxyComTask;
import com.ljkdream.yiyuanduobao.model.RelationGoodsPeriod;
import com.ljkdream.yiyuanduobao.service.YiYuanDuoBaoService;
import com.ljkdream.yiyuanduobao.task.PeriodWinnerBackwardTask;
import com.ljkdream.yiyuanduobao.task.PeriodWinnerForwardTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 开奖数据抓取job
 * Created by ljk on 16-1-11.
 */
@Component
public class PeriodWinnerSchedule {

    @Autowired
    private YiYuanDuoBaoService yiYuanDuoBaoService;

    @Autowired
    private ProxyServiceIpAddressService proxyServiceIpAddressService;

    /**
     * 向前抓取最近的开奖数据。
     */
    @Scheduled(cron = "0 0 * * * ?")
    public void execute() {
        List<RelationGoodsPeriod> list = yiYuanDuoBaoService.queryAllRelationGoodsPeriod();

        for (RelationGoodsPeriod relationGoodsPeriod : list) {

            PeriodWinnerForwardTask periodWinnerForwardTask = new PeriodWinnerForwardTask(relationGoodsPeriod.getGid(),
                    yiYuanDuoBaoService, proxyServiceIpAddressService);

            try {
                TaskExecutorFactory.getInstance().submitTask(periodWinnerForwardTask);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
