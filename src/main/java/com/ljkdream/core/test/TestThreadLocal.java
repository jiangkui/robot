package com.ljkdream.core.test;

/**
 * ThreadLocal 的测试代码
 * Created by LJK on 2015/10/15.
 */
public class TestThreadLocal {
    private ThreadLocal<Long> longLocal = new ThreadLocal<>();
    private ThreadLocal<String> stringLocal = new ThreadLocal<>();

    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public void print() {
        System.out.println(longLocal.get());
        System.out.println(stringLocal.get());
    }

    public static void main(String[] args) throws InterruptedException {
        final TestThreadLocal testThreadLocal = new TestThreadLocal();
        testThreadLocal.set();
        testThreadLocal.print();

        Thread thread = new Thread() {
            public void run() {
                TestThreadLocal testThreadLocal1 = new TestThreadLocal();
                testThreadLocal1.set();
                testThreadLocal1.print();
            }
        };

        thread.start();
        thread.join();

        testThreadLocal.print();

    }
}
