package com.ljkdream.task;

/**
 * 毒丸任务
 *
 * 用于停止生产者/消费者服务
 * Created by ljk on 16-1-2.
 */
public class PoisonPillTask extends AbstractBaseTask {

    @Override
    public void execute() {

    }

    @Override
    public boolean isPoisonPill() {
        return true;
    }

    @Override
    public void run() {

    }
}
