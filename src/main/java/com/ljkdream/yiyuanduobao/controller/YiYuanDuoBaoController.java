package com.ljkdream.yiyuanduobao.controller;

import com.ljkdream.core.entity.UnifiedResponse;
import com.ljkdream.proxy.service.ProxyServiceIpAddressService;
import com.ljkdream.yiyuanduobao.model.GrabBuyRecord;
import com.ljkdream.yiyuanduobao.model.RelationGoodsPeriod;
import com.ljkdream.yiyuanduobao.schedule.PeriodWinnerSchedule;
import com.ljkdream.yiyuanduobao.service.GrabBuyRecordService;
import com.ljkdream.yiyuanduobao.service.PeriodWinnerService;
import com.ljkdream.yiyuanduobao.service.RelationGoodsPeriodService;
import com.ljkdream.yiyuanduobao.task.AllGoodsTask;
import com.ljkdream.yiyuanduobao.task.PeriodWinnerBackwardTask;
import com.ljkdream.core.task.TaskExecutorFactory;
import com.ljkdream.yiyuanduobao.task.PeriodWinnerForwardTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 测试
 * Created by ljk on 16-1-3.
 */
@Controller
@RequestMapping("yiyuanduobao")
public class YiYuanDuoBaoController {

    @Autowired
    private RelationGoodsPeriodService relationGoodsPeriodService;

    @Autowired
    private ProxyServiceIpAddressService proxyServiceIpAddressService;

    @Autowired
    private PeriodWinnerService periodWinnerService;

    @Autowired
    private PeriodWinnerSchedule periodWinnerSchedule;

    @Autowired
    private GrabBuyRecordService grabBuyRecordService;


    @ResponseBody
    @RequestMapping("forward")
    public UnifiedResponse forward(Long period, Long gid) {
        PeriodWinnerForwardTask periodWinnerTask = new PeriodWinnerForwardTask(period, gid, yiYuanDuoBaoService, proxyServiceIpAddressService);
        try {
            TaskExecutorFactory.getInstance().submitTask(periodWinnerTask);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new UnifiedResponse();
    }

    @ResponseBody
    @RequestMapping("backward")
    public UnifiedResponse backward(Long period, Long gid) {
        PeriodWinnerBackwardTask periodWinnerTask = new PeriodWinnerBackwardTask(period, gid, yiYuanDuoBaoService, proxyServiceIpAddressService);
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
    @RequestMapping("forwardAll")
    public UnifiedResponse forwardAll() {
        periodWinnerSchedule.execute();
        return new UnifiedResponse();
    }

    @ResponseBody
    @RequestMapping("backwardAll")
    public UnifiedResponse backwardAll() {
        List<RelationGoodsPeriod> list = yiYuanDuoBaoService.queryAllRelationGoodsPeriod();
        for (RelationGoodsPeriod relationGoodsPeriod : list) {
            PeriodWinnerBackwardTask periodWinnerBackwardTask = new PeriodWinnerBackwardTask(relationGoodsPeriod.getGid(),
                    yiYuanDuoBaoService, proxyServiceIpAddressService);
            try {
                TaskExecutorFactory.getInstance().submitTask(periodWinnerBackwardTask);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return new UnifiedResponse();
    }

    @ResponseBody
    @RequestMapping("grabBuyRecord")
    public UnifiedResponse grabBuyRecord() {
        GrabBuyRecord grabBuyRecord = grabBuyRecordService.queryByMax();
        if (grabBuyRecord == null) {
//            periodWinnerService
        }
        return new UnifiedResponse();
    }
}
