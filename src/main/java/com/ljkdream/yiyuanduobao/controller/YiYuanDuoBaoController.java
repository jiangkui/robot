package com.ljkdream.yiyuanduobao.controller;

import com.ljkdream.core.entity.UnifiedResponse;
import com.ljkdream.proxy.service.ProxyServiceIpAddressService;
import com.ljkdream.yiyuanduobao.service.YiYuanDuoBaoService;
import com.ljkdream.yiyuanduobao.task.AllGoodsTask;
import com.ljkdream.yiyuanduobao.task.AllPeriodWinnerTask;
import com.ljkdream.yiyuanduobao.task.PeriodWinnerTask;
import com.ljkdream.core.task.TaskExecutorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试
 * Created by ljk on 16-1-3.
 */
@Controller
@RequestMapping("yiyuanduobao")
public class YiYuanDuoBaoController {

    @Autowired
    private YiYuanDuoBaoService yiYuanDuoBaoService;
    @Autowired
    private ProxyServiceIpAddressService proxyServiceIpAddressService;

    @ResponseBody
    @RequestMapping("grab-period-winner")
    public UnifiedResponse grabPeriodWinner(Long period, Long gid) {
        PeriodWinnerTask periodWinnerTask = new PeriodWinnerTask(period, gid, yiYuanDuoBaoService, proxyServiceIpAddressService);

        try {
            TaskExecutorFactory.getInstance().submitTask(periodWinnerTask);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new UnifiedResponse();
    }

    @ResponseBody
    @RequestMapping("grab-all-goods")
    public UnifiedResponse grabAllGoods(int page) {

        AllGoodsTask allGoodsTask = new AllGoodsTask(yiYuanDuoBaoService, page);

        try {
            TaskExecutorFactory.getInstance().submitTask(allGoodsTask);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new UnifiedResponse();
    }

    @ResponseBody
    @RequestMapping("grab-all-period-winner")
    public UnifiedResponse grabAllPeriodGoods() {
        AllPeriodWinnerTask allPeriodWinnerTask = new AllPeriodWinnerTask(yiYuanDuoBaoService, proxyServiceIpAddressService);

        try {
            TaskExecutorFactory.getInstance().submitTask(allPeriodWinnerTask);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new UnifiedResponse();
    }
}
