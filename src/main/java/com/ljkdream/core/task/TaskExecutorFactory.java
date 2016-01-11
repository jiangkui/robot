package com.ljkdream.core.task;

/**
 * 任务执行者工厂
 * Created by ljk on 16-1-3.
 */
public class TaskExecutorFactory {

    private static BoundedExecutor executor;

    public static void registerTaskExecutor(BoundedExecutor boundedExecutor) {
        executor = boundedExecutor;
    }

    public static BoundedExecutor getInstance() {
        return executor;
    }
}
