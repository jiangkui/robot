package com.ljkdream.test;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 一个可重入的 自旋锁实现
 * Created by LJK on 2015/10/12.
 */
public class SpinLock {

    private AtomicReference owner = new AtomicReference();

    private int count = 0;

    private void lock() {
        Thread current = Thread.currentThread();

        if (current == owner.get()) {
            count++;
            return;
        }

        while (!owner.compareAndSet(null, current)) {
        }
    }

    private void unlock() {
        Thread current = Thread.currentThread();

        if (current == owner.get()) {
            if (count != 0) {
                count--;
            } else {
                owner.compareAndSet(current, null);
            }
        }
    }
}
