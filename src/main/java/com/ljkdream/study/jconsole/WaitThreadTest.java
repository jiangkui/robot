package com.ljkdream.study.jconsole;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 线程等待代码
 * Created by ljk on 16-1-17.
 */
public class WaitThreadTest {

    /**
     * 线程死循环等待
     */
    public static void createBusyThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                }
            }
        }, "testBusyThread");

        thread.start();
    }

    /**
     * 线程锁等待
     * @param lock lock
     */
    public static void createLockThread(final Object lock) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "testLockThread");
        thread.start();
    }

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        br.readLine();
//        createBusyThread();
//        br.readLine();
//        createLockThread(new Object());

        //java.lang.Runtime.availableProcessors() 方法返回到Java虚拟机的可用的处理器数量。此值可能会改变在一个特定的虚拟机调用。应用程序可用处理器的数量是敏感的，因此偶尔查询该属性，并适当地调整自己的资源使用情况.
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println("i = " + i);
    }
}

