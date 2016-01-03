package com.ljkdream.listener;

import com.ljkdream.task.BoundedExecutor;
import com.ljkdream.task.TaskExecutorFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 任务监听器
 * Created by ljk on 16-1-2.
 */
public class TaskListener implements ServletContextListener {

    private ExecutorService executor;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        executor = Executors.newFixedThreadPool(4);
        BoundedExecutor boundedExecutor = new BoundedExecutor(executor, 100);

        TaskExecutorFactory.registerTaskExecutor(boundedExecutor);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("任务线程关闭！");
        executor.shutdownNow(); //不在接收新任务
    }
}
