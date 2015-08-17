package com.ljkdream.schedule.producerConsumer;

/**
 * 最后一个任务，用来标识 任务执行完毕，关闭线程池使用的
 * <p/>
 * Created by LJK on 2015/7/24.
 */
public class LastOneSchedule extends AbstractSchedule {
    @Override
    public void execute() {

    }

    @Override
    public boolean isLastOne() {
        return true; //标识最后一个任务
    }
}
