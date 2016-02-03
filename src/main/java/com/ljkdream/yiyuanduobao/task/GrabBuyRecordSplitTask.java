package com.ljkdream.yiyuanduobao.task;

import com.ljkdream.core.task.AbstractBaseTask;
import com.ljkdream.yiyuanduobao.model.GrabBuyRecord;

/**
 * 抓取参与记录的拆分task
 * <p/>
 * Created by jiangkui on 16-2-3.
 */
public class GrabBuyRecordSplitTask extends AbstractBaseTask {

    private GrabBuyRecord grabBuyRecord;

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
