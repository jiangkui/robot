package com.ljkdream.proxy.schedule;

import com.ljkdream.proxy.service.ProxyServiceIpAddressService;
import com.ljkdream.proxy.task.CnProxyComTask;
import com.ljkdream.core.task.TaskExecutorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 自动抓取 http://cn-proxy.com/ 中,国内代理服务器数据任务
 * Created by ljk on 16-1-9.
 */
@Component
public class CnProxyComSchedule {

    @Autowired
    private ProxyServiceIpAddressService proxyServiceIpAddressService;

    /**
     * 每小时请求一次
     */
//    @Scheduled(cron = "0 */30 * * * ?")
    public void execute() {
        CnProxyComTask cn = new CnProxyComTask(CnProxyComTask.REQUEST_CN_URL);
        CnProxyComTask other = new CnProxyComTask(CnProxyComTask.REQUEST_INTERNATIONAL_URL);

        try {
            TaskExecutorFactory.getInstance().submitTask(cn);
            TaskExecutorFactory.getInstance().submitTask(other);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
