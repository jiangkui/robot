//package com.ljkdream.task;
//
//import java.util.concurrent.ArrayBlockingQueue;
//
///**
// * 任务队列
// * Created by ljk on 16-1-2.
// */
//public class TaskQueue<ITask> extends ArrayBlockingQueue<ITask> {
//
//    public static final int DEFAULT_SIZE = 100; //队列默认大小
//
//    private static TaskQueue taskQueue = new TaskQueue<>();
//
//    private TaskQueue() {
//        super(DEFAULT_SIZE);
//    }
//
//    public static TaskQueue getInstance() {
//        return taskQueue;
//    }
//}
