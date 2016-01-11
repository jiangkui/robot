package com.ljkdream.core.test;

/**
 * 测试
 * Created by LJK on 2015/10/12.
 */
public class Test implements Runnable{
    public synchronized void get() {
        System.out.println(Thread.currentThread().getId());
        set();
    }

    public synchronized void set() {
        System.out.println(Thread.currentThread().getId());
    }


    public static void main(String[] args) {
        Test test = new Test();

        new Thread(test).start();
        new Thread(test).start();
        new Thread(test).start();

    }

    @Override
    public void run() {
        get();
    }
}
