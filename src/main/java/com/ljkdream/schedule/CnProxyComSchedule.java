package com.ljkdream.schedule;

import com.ljkdream.service.ProxyServiceIpAddressService;
import com.ljkdream.task.ProxyService.CnProxyComTask;
import com.ljkdream.task.base.TaskExecutorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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
    @Scheduled(cron = "0 0 * * * ?")
    public void execute() {
        CnProxyComTask cn = new CnProxyComTask(CnProxyComTask.REQUEST_CN_URL, proxyServiceIpAddressService);
        CnProxyComTask other = new CnProxyComTask(CnProxyComTask.REQUEST_INTERNATIONAL_URL, proxyServiceIpAddressService);

        try {
            TaskExecutorFactory.getInstance().submitTask(cn);
            TaskExecutorFactory.getInstance().submitTask(other);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
