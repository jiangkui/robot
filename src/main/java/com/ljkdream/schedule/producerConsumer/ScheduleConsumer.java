package com.ljkdream.schedule.producerConsumer;

import org.apache.log4j.Logger;

/**
 * 从任务队列中消费任务
 * Created by LJK on 2015/7/24.
 */
public class ScheduleConsumer implements Runnable {

    private ScheduleQueue<Schedule> scheduleQueue;

    private Logger logger = Logger.getLogger(ScheduleConsumer.class);

    /**
     * 注册任务队列
     *
     * @param scheduleQueue 任务队列
     */
    public void registScheduleQueue(ScheduleQueue<Schedule> scheduleQueue) {
        this.scheduleQueue = scheduleQueue;
    }

    /**
     * 消费任务
     */
    @Override
    public void run() {
        if (scheduleQueue != null) {
            while (true) {
                try {
                    Schedule schedule = scheduleQueue.take();
                    if (!schedule.isLastOne()) {
                        logger.info(Thread.currentThread().getName() + " 执行任务：" + schedule.toString());
                        schedule.execute();
                        continue;
                    } else {
                        logger.info(Thread.currentThread().getName() + "发现最后一个任务！关闭消费者队列");
                        return;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
