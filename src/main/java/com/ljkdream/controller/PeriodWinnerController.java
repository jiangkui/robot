package com.ljkdream.controller;

import com.ljkdream.entity.UnifiedResponse;
import com.ljkdream.model.PeriodWinner;
import com.ljkdream.service.PeriodWinnerService;
import com.ljkdream.task.PeriodWinnerTask;
import com.ljkdream.task.base.TaskExecutorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试
 * Created by ljk on 16-1-3.
 */
@Controller
@RequestMapping("period-winner")
public class PeriodWinnerController {

    @Autowired
    private PeriodWinnerService periodWinnerService;

    @ResponseBody
    @RequestMapping("test")
    public UnifiedResponse test(Long perid, Long gid) {
        PeriodWinnerTask periodWinnerTask = new PeriodWinnerTask(perid, gid, periodWinnerService);

        try {
            TaskExecutorFactory.getInstance().submitTask(periodWinnerTask);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new UnifiedResponse();
    }
}
