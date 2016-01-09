package com.ljkdream.service;

import com.ljkdream.dao.ProxyServerIpAddressMapper;
import com.ljkdream.model.ProxyServerIpAddress;
import com.ljkdream.model.ProxyServerIpAddressExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 代理服务ip地址 service
 * Created by ljk on 16-1-9.
 */
@Service
public class ProxyServiceIpAddressService {

    @Autowired
    private ProxyServerIpAddressMapper proxyMapper;

    private ProxyServerIpAddress selectByIp(String ip) {
        ProxyServerIpAddressExample example = new ProxyServerIpAddressExample();
        example.createCriteria().andIpEqualTo(ip);

        List<ProxyServerIpAddress> list = proxyMapper.selectByExample(example);
        if (list.size() > 0) {
            return list.get(0);
        }

        return null;
    }

    public void saveOrUpdate(List<ProxyServerIpAddress> proxyList) {
        for (ProxyServerIpAddress proxyServerIpAddress : proxyList) {
            ProxyServerIpAddress proxy = this.selectByIp(proxyServerIpAddress.getIp());
            if (proxy == null) {
                proxyMapper.insert(proxyServerIpAddress);
            } else {
                proxyServerIpAddress.setId(proxy.getId());
                proxyMapper.updateByPrimaryKeySelective(proxyServerIpAddress);
            }
        }
    }

}
