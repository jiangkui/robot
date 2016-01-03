package com.ljkdream.task.base;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

/**
 * 有界的执行者
 * Created by ljk on 16-1-2.
 */
public class BoundedExecutor {

    private final Executor executor;
    private final Semaphore semaphore; //用来控制线程池中可排队的任务数量

    /**
     * 构造方法
     *
     * @param executor 执行者
     * @param bound    可排队的任务数量，满了之后将会阻塞
     */
    public BoundedExecutor(Executor executor, int bound) {
        this.executor = executor;
        this.semaphore = new Semaphore(bound);
    }

    public void submitTask(final ITask task) throws InterruptedException {
        semaphore.acquire();

        try {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        task.execute();
                    } finally {
                        semaphore.release();
                    }
                }
            });

        } catch (RejectedExecutionException e) {
            semaphore.release();
        }
    }
}
