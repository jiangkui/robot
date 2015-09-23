package com.ljkdream.controller;

import com.ljkdream.entiry.UnifiedResponse;
import com.ljkdream.schedule.SiteAutoLaud;
import com.ljkdream.schedule.TimedTask;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.rmi.server.UnicastRemoteObject;

/**
 * 测试任务计划
 * Created by LJK on 2015/8/18.
 */
@Controller
public class TestScheduleController {

    @ResponseBody
    @RequestMapping("testSiteAutoLaud")
    public UnifiedResponse testSiteAutoLaud(@RequestParam(required = false, defaultValue = "0",value = "num") int num) {
        TimedTask.siteAutoLaudstart(num);

        return new UnifiedResponse();
    }

    public static void main(String[] args) {
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("D:\\project\\robot\\src\\main\\webapp\\WEB-INF\\mvc-dispatcher-servlet.xml"));
        TestScheduleController obj = (TestScheduleController) factory.getBean("testScheduleController");

    }
}
