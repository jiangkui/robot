package com.ljkdream.yiyuanduobao.task;

import com.ljkdream.core.task.AbstractBaseTask;
import com.ljkdream.yiyuanduobao.model.GrabBuyRecord;

/**
 * 抓取购买记录 Task
 * Created by ljk on 16-2-2.
 */
public class GrabBuyRecordTask extends AbstractBaseTask {

    private GrabBuyRecord grabBuyRecord;

    public GrabBuyRecordTask(GrabBuyRecord grabBuyRecord) {
        this.grabBuyRecord = grabBuyRecord;
    }

    @Override
    public void execute() {

    }
}
