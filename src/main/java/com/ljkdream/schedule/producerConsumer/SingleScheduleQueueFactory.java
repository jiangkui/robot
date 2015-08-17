package com.ljkdream.schedule.producerConsumer;

/**
 * 单例任务队列工厂
 * Created by LJK on 2015/7/24.
 */
public class SingleScheduleQueueFactory {

    /**
     * 工作任务队列
     */
    private static ScheduleQueue<Schedule> scheduleQueue;

    static {
        scheduleQueue = new ScheduleQueue<>();
    }

    public static ScheduleQueue<Schedule> getScheduleQueue() {
        return scheduleQueue;
    }
}
