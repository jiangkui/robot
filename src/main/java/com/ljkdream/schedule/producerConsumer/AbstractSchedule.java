package com.ljkdream.schedule.producerConsumer;

import org.apache.log4j.Logger;

/**
 * 任务计划抽象类
 * Created by LJK on 2015/7/24.
 */
public abstract class AbstractSchedule implements Schedule {

    public static Logger logger = Logger.getLogger(AbstractSchedule.class);

    /**
     * 执行任务计划
     */
    public abstract void execute();

    /**
     * 是否是最后一个
     *
     * @return true 是最后一个。
     */
    public boolean isLastOne() {
        return false;
    }
}
