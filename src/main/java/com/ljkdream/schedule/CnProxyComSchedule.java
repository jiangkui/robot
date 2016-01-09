package com.ljkdream.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 自动抓取 http://cn-proxy.com/ 中,国内代理服务器数据任务
 * Created by ljk on 16-1-9.
 */
@Component
public class CnProxyComSchedule {

    @Scheduled(cron = "0 30 9 * * ?")
    public void execute() {

    }
}
