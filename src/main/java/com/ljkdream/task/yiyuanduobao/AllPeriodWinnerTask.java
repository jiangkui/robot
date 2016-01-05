package com.ljkdream.task.yiyuanduobao;

import com.ljkdream.model.RelationGoodsPeriod;
import com.ljkdream.service.YiYuanDuoBaoService;
import com.ljkdream.task.base.AbstractBaseTask;
import com.ljkdream.task.base.TaskExecutorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 抓取所有商品的所有开奖数据
 * <p/>
 * Created by ljk on 16-1-5.
 */
public class AllPeriodWinnerTask extends AbstractBaseTask {

    private static Logger logger = LoggerFactory.getLogger(AllPeriodWinnerTask.class);

    private YiYuanDuoBaoService yiYuanDuoBaoService;

    public AllPeriodWinnerTask(YiYuanDuoBaoService yiYuanDuoBaoService) {
        this.yiYuanDuoBaoService = yiYuanDuoBaoService;
    }

    @Override
    public void execute() {
        List<RelationGoodsPeriod> list = yiYuanDuoBaoService.queryAllRelationGoodsPeriod();

        for (RelationGoodsPeriod relationGoodsPeriod : list) {

            PeriodWinnerTask periodWinnerTask = new PeriodWinnerTask(relationGoodsPeriod.getPeriod(),
                    relationGoodsPeriod.getGid(), yiYuanDuoBaoService);

            try {
                logger.info("【提交抓取任务】" + periodWinnerTask);
                TaskExecutorFactory.getInstance().submitTask(periodWinnerTask);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
