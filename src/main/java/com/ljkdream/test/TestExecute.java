package com.ljkdream.test;

import java.util.concurrent.*;

/**
 * 测试线程池的拒绝策略
 * Created by ljk on 16-1-2.
 */
public class TestExecute {

    private static BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(1);
    private static ExecutorService executorService = new ThreadPoolExecutor(1, 10, 0, TimeUnit.MICROSECONDS, queue);

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            executorService.execute(new TestRun(i));
        }

        executorService.shutdown();
    }
}

class TestRun implements Runnable {

    int id = 0;

    public TestRun(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println(id);
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
