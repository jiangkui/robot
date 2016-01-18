package com.ljkdream.core.listener;

import com.ljkdream.core.task.BoundedExecutor;
import com.ljkdream.core.task.TaskExecutorFactory;

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
        executor = Executors.newFixedThreadPool(5);
        BoundedExecutor boundedExecutor = new BoundedExecutor(executor, 7);

        TaskExecutorFactory.registerTaskExecutor(boundedExecutor);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("任务线程关闭！");
        executor.shutdownNow(); //不在接收新任务
    }
}
