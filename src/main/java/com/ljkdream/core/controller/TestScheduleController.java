package com.ljkdream.core.controller;

import com.ljkdream.core.entity.UnifiedResponse;
import com.ljkdream.proxy.service.ProxyServiceIpAddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 测试任务计划
 * Created by LJK on 2015/8/18.
 */
@Controller
public class TestScheduleController {

    private Logger logger = LoggerFactory.getLogger(TestScheduleController.class);

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

    @ResponseBody
    @RequestMapping("fillHeap")
    public UnifiedResponse fillHeap() throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            TimeUnit.MILLISECONDS.sleep(50);
            list.add(new OOMObject());
            logger.info("fill heap..." + i);
        }
        System.gc();
        logger.info("内存回收完毕！");
        return new UnifiedResponse();
    }
}

class OOMObject {
    public byte[] placeholder = new byte[64 * 1024];
}
