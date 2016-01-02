package com.ljkdream.task;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 任务队列
 * Created by ljk on 16-1-2.
 */
public class TaskQueue<T> extends ArrayBlockingQueue<T> {

    public static final int DEFAULT_SIZE = 100; //队列默认大小

    public TaskQueue() {
        super(DEFAULT_SIZE);
    }

    public TaskQueue(int capacity) {
        super(capacity);
    }
}
