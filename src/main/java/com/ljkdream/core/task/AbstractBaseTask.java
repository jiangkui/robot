package com.ljkdream.core.task;

import com.ljkdream.core.util.HttpClientUtil;
import com.ljkdream.proxy.model.ProxyServerIpAddress;
import com.ljkdream.yiyuanduobao.model.GrabBuyRecord;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 抽象任务基类
 * Created by ljk on 16-1-2.
 */
public abstract class AbstractBaseTask implements ITask{

    protected static Random random = new Random();

    /**
     * 是否事毒丸对象，提供一个默认 否的实现
     * @return false no
     */
    @Override
    public boolean isPoisonPill() {
        return false;
    }

}
