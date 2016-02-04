package com.ljkdream.yiyuanduobao.task;

import com.ljkdream.core.task.AbstractBaseTask;
import com.ljkdream.core.util.HttpClientUtil;
import com.ljkdream.proxy.model.ProxyServerIpAddress;
import com.ljkdream.proxy.service.ProxyServiceIpAddressService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 一元夺宝基础 task
 * Created by jiangkui on 16-2-4.
 */
public abstract class YiYuanDuoBaoBaseTask extends AbstractBaseTask {

    protected static ProxyServiceIpAddressService proxyServiceIpAddressService;
    private static Logger logger = LoggerFactory.getLogger(YiYuanDuoBaoBaseTask.class);
    private int retryNum = 0;
    public static final int MAX_RETRY_NUM = 10;//重试次数
    protected static List<String> proxyStrList = new ArrayList<>();

    static {
        proxyStrList.add("CN");
    }

    public JSONObject obtainDate(String url) throws InterruptedException, IOException {
        ProxyServerIpAddress proxy = proxyServiceIpAddressService.obtainProxy(proxyStrList);
        String resultStr = HttpClientUtil.executeByProxy(url, proxy);
        JSONObject jsonObject = JSONObject.fromObject(resultStr);
        Object code = jsonObject.get("code");

        //目标服务器返回结果异常
        if (code == null || ((Integer) code) == -16) {

            if (code != null) {
                logger.info("抓取完毕！" + url);
                return null;
            }

            if (retryNum++ >= MAX_RETRY_NUM) {
                logger.error("重试次数：" + retryNum + "过多;" + url);
            }
            TimeUnit.MILLISECONDS.sleep(random.nextInt(100));
        } else {
            retryNum = 0;
        }

        JSONObject result = jsonObject.getJSONObject("result");
        if (result.isEmpty()) {
            logger.error("没有获取到result;" + url);
            return null;
        }

        //切换代理
//        proxyServiceIpAddressService.changeProxy(proxyStrList);
        return jsonObject;
    }
}
