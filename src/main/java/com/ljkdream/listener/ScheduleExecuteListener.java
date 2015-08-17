package com.ljkdream.listener;

import com.ljkdream.schedule.producerConsumer.LastOneSchedule;
import com.ljkdream.schedule.producerConsumer.ScheduleConsumer;
import com.ljkdream.schedule.producerConsumer.SingleScheduleQueueFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 处理工作任务
 * Created by LJK on 2015/7/24.
 */
public class ScheduleExecuteListener implements ServletContextListener {

    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    private Logger logger = Logger.getLogger(ScheduleExecuteListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ScheduleConsumer scheduleConsumer = new ScheduleConsumer();
        scheduleConsumer.registScheduleQueue(SingleScheduleQueueFactory.getScheduleQueue());

        executorService.execute(scheduleConsumer);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //加入 “终结任务标识”
        SingleScheduleQueueFactory.getScheduleQueue().add(new LastOneSchedule());

        System.out.println("任务线程关闭！");
        executorService.shutdownNow();
    }
}
