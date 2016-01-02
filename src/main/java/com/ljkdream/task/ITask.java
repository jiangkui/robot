package com.ljkdream.task;

/**
 * 任务接口
 *
 * 所有任务需实现该接口，方可在生产/消费者队列中进行处理。
 *
 * Created by ljk on 16-1-2.
 */
public interface ITask {

    /**
     * 执行任务
     */
    void execute();

    /**
     * 是否是毒丸
     *
     * 在 FIFO 队列中的一个对象。
     *
     * 如果是，则说明 要关闭生产者/消费者服务了。
     *
     * @return true 是毒丸。
     */
    boolean isPoisonPill();
}
