//package com.ljkdream.yiyuanduobao.task;
//
//import com.ljkdream.yiyuanduobao.model.RelationGoodsPeriod;
//import com.ljkdream.proxy.service.ProxyServiceIpAddressService;
//import com.ljkdream.yiyuanduobao.service.YiYuanDuoBaoService;
//import com.ljkdream.core.task.AbstractBaseTask;
//import com.ljkdream.core.task.TaskExecutorFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.List;
//
///**
// * 抓取所有商品的所有开奖数据
// * <p/>
// * Created by ljk on 16-1-5.
// */
//public class AllPeriodWinnerTask extends AbstractBaseTask {
//
//    private static Logger logger = LoggerFactory.getLogger(AllPeriodWinnerTask.class);
//
//    private YiYuanDuoBaoService yiYuanDuoBaoService;
//    private ProxyServiceIpAddressService proxyServiceIpAddressService;
//
//    public AllPeriodWinnerTask(YiYuanDuoBaoService yiYuanDuoBaoService, ProxyServiceIpAddressService proxyServiceIpAddressService) {
//        this.yiYuanDuoBaoService = yiYuanDuoBaoService;
//        this.proxyServiceIpAddressService = proxyServiceIpAddressService;
//    }
//
//    @Override
//    public void execute() {
//        List<RelationGoodsPeriod> list = yiYuanDuoBaoService.queryAllRelationGoodsPeriod();
//
//        for (RelationGoodsPeriod relationGoodsPeriod : list) {
//
//            PeriodWinnerBackwardTask periodWinnerTask = new PeriodWinnerBackwardTask(relationGoodsPeriod.getPeriod(),
//                    relationGoodsPeriod.getGid(), yiYuanDuoBaoService, proxyServiceIpAddressService);
//
//            try {
//                logger.info("【提交抓取任务】" + periodWinnerTask);
//                TaskExecutorFactory.getInstance().submitTask(periodWinnerTask);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
