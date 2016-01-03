//package com.ljkdream.task;
//
//import java.util.concurrent.ArrayBlockingQueue;
//
///**
// * 任务队列工厂
// * Created by ljk on 16-1-2.
// */
//public class SingleTaskQueueFactory {
//
//    public static final int DEFAULT_SIZE = 100; //队列默认大小
//
//    private static TaskQueue<ITask> taskQueue = new TaskQueue<>(DEFAULT_SIZE);
//
//    public static TaskQueue<ITask> getInstance() {
//        return taskQueue;
//    }
//}
//
//class TaskQueue<ITask> extends ArrayBlockingQueue<ITask> {
//
//    protected TaskQueue(int capacity) {
//        super(capacity);
//    }
//}