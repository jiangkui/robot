package com.ljkdream.study.jconsole;

import com.ljkdream.core.entity.UnifiedResponse;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 线程等待代码
 * Created by ljk on 16-1-17.
 */
@Controller
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

//    @ResponseBody
//    @RequestMapping("waitThread")
//    public UnifiedResponse waitThread() throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        br.readLine();
//        createBusyThread();
//        br.readLine();
//        createLockThread(new Object());
//        return new UnifiedResponse();
//    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        createBusyThread();
        br.readLine();
        createLockThread(new Object());
    }
}

