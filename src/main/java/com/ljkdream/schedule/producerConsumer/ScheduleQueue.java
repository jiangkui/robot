package com.ljkdream.schedule.producerConsumer;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 任务队列
 * Created by LJK on 2015/7/24.
 */
public class ScheduleQueue<T> extends ArrayBlockingQueue<T> {

    public static final int DEFAULT_SIZE = 3; //队列默认大小3 个

    public ScheduleQueue(int capacity) {
        super(capacity);
    }

    public ScheduleQueue() {
        super(DEFAULT_SIZE);
    }
}
