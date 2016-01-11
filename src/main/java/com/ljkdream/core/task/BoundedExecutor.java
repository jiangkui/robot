package com.ljkdream.core.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

/**
 * 有界的执行者
 * Created by ljk on 16-1-2.
 */
public class BoundedExecutor {

    private final ExecutorService executorService;
    private final Semaphore semaphore; //用来控制线程池中可排队的任务数量
    private Logger logger = LoggerFactory.getLogger(BoundedExecutor.class);

    /**
     * 构造方法
     *
     * @param executor 执行者
     * @param bound    可排队的任务数量，满了之后将会阻塞
     */
    public BoundedExecutor(ExecutorService executor, int bound) {
        this.executorService = executor;
        this.semaphore = new Semaphore(bound);
    }

    public void submitTask(final ITask task) throws InterruptedException {
        semaphore.acquire();

        try {
            if (executorService.isShutdown()) {
                logger.warn("线程池已经关闭！将抛弃任务：" + task.toString());
                return;
            }

            executorService.execute(new Runnable() {
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
