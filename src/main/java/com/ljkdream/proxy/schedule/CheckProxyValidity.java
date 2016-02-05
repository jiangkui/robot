package com.ljkdream.proxy.schedule;

import com.ljkdream.core.util.HttpClientUtil;
import com.ljkdream.proxy.model.ProxyServerIpAddress;
import com.ljkdream.proxy.service.ProxyServiceIpAddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * 定期检查代理的有效性
 * Created by jiangkui on 16-1-11.
 */
@Component
public class CheckProxyValidity {

    @Autowired
    private ProxyServiceIpAddressService proxyService;

    private Logger logger = LoggerFactory.getLogger(CheckProxyValidity.class);

    public static final String DEFAULT_CHECK_URL = "http://www.baidu.com";

    /**
     * 每个一段时间就维护一次
     * 目前只维护国内的代理
     * 代理暂不维护
     */
//    @Scheduled(cron = "0 0 0 * * ?")
    public void execute() {
        List<ProxyServerIpAddress> proxyList = proxyService.queryAllByDoman("CN");

        for (ProxyServerIpAddress proxyServerIpAddress : proxyList) {
            try {
                long startTime = System.currentTimeMillis();
                HttpClientUtil.executeByProxy(DEFAULT_CHECK_URL, proxyServerIpAddress);

                long useTime = System.currentTimeMillis() - startTime;

                int level = ProxyServerIpAddress.level((int) useTime);

                proxyServerIpAddress.setSpeed((int) useTime);
                proxyServerIpAddress.setSpeedLevel(level);
            } catch (Exception e) {
                logger.warn(e.getMessage());
                proxyServerIpAddress.setStatus(ProxyServerIpAddress.STATUS_CAN_NOT_USED);
            }

            proxyServerIpAddress.setModifyTime(new Date());
            proxyService.updateByPrimaryKeySelective(proxyServerIpAddress);
        }
    }
}
