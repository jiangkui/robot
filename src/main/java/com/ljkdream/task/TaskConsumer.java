package com.ljkdream.task;

import com.ljkdream.schedule.producerConsumer.Schedule;
import org.apache.log4j.Logger;

/**
 * 任务消费者
 * Created by ljk on 16-1-2.
 */
public class TaskConsumer implements Runnable {

    private static TaskQueue<ITask> taskQueue;
    private Logger logger = Logger.getLogger(TaskConsumer.class);

    /**
     * 注册任务队列
     *
     * @param taskQueue 任务队列
     */
    public void registScheduleQueue(TaskQueue<ITask> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                ITask take = taskQueue.take();
                if (take.isPoisonPill()) {
                    logger.info(Thread.currentThread().getName() + "发现最后一个任务！关闭消费者队列");
                    return;
                }

                logger.info(Thread.currentThread().getName() + " 执行任务：" + take.toString());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
