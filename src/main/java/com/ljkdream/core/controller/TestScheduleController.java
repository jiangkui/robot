package com.ljkdream.core.controller;

import com.ljkdream.proxy.service.ProxyServiceIpAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 测试任务计划
 * Created by LJK on 2015/8/18.
 */
@Controller
public class TestScheduleController {

    @Autowired
    private ProxyServiceIpAddressService proxyServiceIpAddressService;

//    @ResponseBody
//    @RequestMapping("proxy")
//    public UnifiedResponse proxy() {
//        CnProxyComTask cnProxyComTask = new CnProxyComTask(CnProxyComTask.REQUEST_INTERNATIONAL_URL, proxyServiceIpAddressService);
//
//        try {
//            TaskExecutorFactory.getInstance().submitTask(cnProxyComTask);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        return new UnifiedResponse();
//    }
}
