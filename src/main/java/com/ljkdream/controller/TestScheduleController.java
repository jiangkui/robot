package com.ljkdream.controller;

import com.ljkdream.entity.UnifiedResponse;
import com.ljkdream.schedule.TimedTask;
import com.ljkdream.service.ProxyServiceIpAddressService;
import com.ljkdream.task.ProxyService.CnProxyComTask;
import com.ljkdream.task.base.TaskExecutorFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试任务计划
 * Created by LJK on 2015/8/18.
 */
@Controller
public class TestScheduleController {

    @Autowired
    private ProxyServiceIpAddressService proxyServiceIpAddressService;

    @ResponseBody
    @RequestMapping("testSiteAutoLaud")
    public UnifiedResponse testSiteAutoLaud(@RequestParam(required = false, defaultValue = "0", value = "num") int num) {
        TimedTask.siteAutoLaudstart(num);

        return new UnifiedResponse();
    }

    public static void main(String[] args) {
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("D:\\project\\robot\\src\\main\\webapp\\WEB-INF\\mvc-dispatcher-servlet.xml"));
        TestScheduleController obj = (TestScheduleController) factory.getBean("testScheduleController");

    }

    @ResponseBody
    @RequestMapping("proxy")
    public UnifiedResponse proxy() {
        CnProxyComTask cnProxyComTask = new CnProxyComTask(CnProxyComTask.REQUEST_INTERNATIONAL_URL, proxyServiceIpAddressService);

        try {
            TaskExecutorFactory.getInstance().submitTask(cnProxyComTask);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new UnifiedResponse();
    }
}
