package com.ljkdream.yiyuanduobao.task;

import com.ljkdream.core.task.AbstractBaseTask;
import com.ljkdream.yiyuanduobao.model.GrabBuyRecord;

import java.util.concurrent.CountDownLatch;

/**
 * 抓取参与记录的子任务
 * <p/>
 * Created by jiangkui on 16-2-3.
 */
public class GrabBuyRecordSubTask extends AbstractBaseTask {

    private int pageNum;
    private int pageSize;
    private GrabBuyRecord grabBuyRecord;
    private CountDownLatch countDownLatch;

    public GrabBuyRecordSubTask(int pageNum, int pageSize, GrabBuyRecord grabBuyRecord, CountDownLatch countDownLatch) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.grabBuyRecord = grabBuyRecord;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void execute() {
        //请求 url
        //存储 数据 存储失败暂不处理
        //同步数量减1
    }

    @Override
    public void initService() {

    }


}
