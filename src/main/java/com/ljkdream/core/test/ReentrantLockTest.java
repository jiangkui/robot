package com.ljkdream.core.test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * test
 * Created by LJK on 2015/10/12.
 */
public class ReentrantLockTest implements Runnable{

    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        get();
    }

    public void get() {
        lock.lock();
        System.out.println(Thread.currentThread().getId());
        set();
        lock.unlock();
    }

    public void set() {
        lock.lock();
        System.out.println(Thread.currentThread().getId());
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();

        new Thread(reentrantLockTest).start();
        new Thread(reentrantLockTest).start();
        new Thread(reentrantLockTest).start();
    }
}
