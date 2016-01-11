package com.ljkdream.core.task;

/**
 * 抽象任务基类
 * Created by ljk on 16-1-2.
 */
public abstract class AbstractBaseTask implements ITask{

    /**
     * 是否事毒丸对象，提供一个默认 否的实现
     * @return false no
     */
    @Override
    public boolean isPoisonPill() {
        return false;
    }
}
