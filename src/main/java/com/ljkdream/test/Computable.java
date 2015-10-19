package com.ljkdream.test;

/**
 * 任务计算接口
 *
 * Created by LJK on 2015/10/19.
 */
public interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}
