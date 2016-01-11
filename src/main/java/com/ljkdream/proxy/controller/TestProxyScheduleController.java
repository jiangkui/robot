package com.ljkdream.proxy.controller;

import com.ljkdream.core.entity.UnifiedResponse;
import com.ljkdream.core.task.TaskExecutorFactory;
import com.ljkdream.proxy.schedule.CheckProxyValidity;
import com.ljkdream.proxy.service.ProxyServiceIpAddressService;
import com.ljkdream.proxy.task.CnProxyComTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试任务计划
 * Created by LJK on 2015/8/18.
 */
@Controller
@RequestMapping("proxy")
public class TestProxyScheduleController {

    @Autowired
    private ProxyServiceIpAddressService proxyServiceIpAddressService;

    @Autowired
    private CheckProxyValidity checkProxyValidity;

    @ResponseBody
    @RequestMapping("cnProxyComTask")
    public UnifiedResponse cnProxyComTask() {
        CnProxyComTask cnProxyComTask = new CnProxyComTask(CnProxyComTask.REQUEST_INTERNATIONAL_URL, proxyServiceIpAddressService);

        try {
            TaskExecutorFactory.getInstance().submitTask(cnProxyComTask);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new UnifiedResponse();
    }


    @ResponseBody
    @RequestMapping("checkProxyValidity")
    public UnifiedResponse checkProxyValidity() {
        try {
            checkProxyValidity.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new UnifiedResponse();
    }
}
