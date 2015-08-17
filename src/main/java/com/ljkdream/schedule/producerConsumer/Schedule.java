package com.ljkdream.schedule.producerConsumer;

/**
 * 任务计划接口
 * <p/>
 * 继承 AbstractSchedule 比较方便。
 * <p/>
 * Created by LJK on 2015/7/24.
 */
public interface Schedule {

    /**
     * 执行任务计划
     */
    void execute();

    /**
     * 是否是最后一个，用来标识 是否要关闭 ExecuteService 的。普通任务请返回false。
     *
     * @return true 是最后一个。
     */
    boolean isLastOne();
}
