package com.ljkdream.service;

import com.ljkdream.dao.ProxyServerIpAddressMapper;
import com.ljkdream.model.ProxyServerIpAddress;
import com.ljkdream.model.ProxyServerIpAddressExample;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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


    private ThreadLocal<ProxyServerIpAddress> threadLocal = new ThreadLocal<>();

    //map结构 <proxyDomain, <proxyId, proxy>>
    private Map<String, Map<Long, ProxyServerIpAddress>> cacheProxy = new HashedMap();

    /**
     * 刷新代理队列缓存
     */
    public void refreshCache() {
        ProxyServerIpAddressExample example = new ProxyServerIpAddressExample();

        List<ProxyServerIpAddress> list = proxyMapper.selectByExample(example);

        for (ProxyServerIpAddress proxy : list) {
            String countryDomain = proxy.getCountryDomain();
            Map<Long, ProxyServerIpAddress> proxyIdMap = cacheProxy.get(countryDomain);
            if (proxyIdMap == null) {
                proxyIdMap = new TreeMap<>();
                proxyIdMap.put(proxy.getId(), proxy);
                cacheProxy.put(countryDomain, proxyIdMap);
            } else {
                proxyIdMap.put(proxy.getId(), proxy);
            }
        }
    }

    /**
     * 获取代理
     *
     * @param proxyStrList 代理名称list
     * @return 代理
     */
    public ProxyServerIpAddress obtainProxy(List<String> proxyStrList) {
        ProxyServerIpAddress proxyServerIpAddress = threadLocal.get();

        if (proxyServerIpAddress == null) {
            if (proxyStrList.size() == 1 && "CN".equals(proxyStrList.get(0))) {
                return null; //如果是 CN，则首次不适用代理。
            }

            if (cacheProxy.size() == 0) {
                refreshCache();
            }
            ProxyServerIpAddress ipAddress = changeProxy(proxyStrList);
            return ipAddress;
        }
        return proxyServerIpAddress;
    }


    /**
     * 切换代理
     * @param proxyStrList 代理域名列表
     * @return proxy
     */
    public ProxyServerIpAddress changeProxy(List<String> proxyStrList) {
        ProxyServerIpAddress proxy = obtainNextProxy(proxyStrList);
        threadLocal.set(proxy);
        return proxy;
    }

    /**
     * 切换代理，获取下一个代理
     * @param proxyStrList 当前任务支持的 域名列表
     * @return proxy
     */
    private ProxyServerIpAddress obtainNextProxy(List<String> proxyStrList) {
        if (cacheProxy.size() == 0) {
            refreshCache();
        }
        ProxyServerIpAddress proxyServerIpAddress = threadLocal.get();
        if (proxyServerIpAddress == null) {
            if (proxyStrList == null) {
                return null;
            }

            //threadLocal 中没有，择取第一个
            return obtainProxyByFirst(proxyStrList);
        } else {
            Map<Long, ProxyServerIpAddress> proxyIdMap = cacheProxy.get(proxyServerIpAddress.getCountryDomain());

            //返回该国家域名队列代理中的下一个代理
            if (MapUtils.isNotEmpty(proxyIdMap)) {
                ProxyServerIpAddress ipAddress = obtainNextProxyByMapAndId(proxyIdMap, proxyServerIpAddress.getId());

                if (ipAddress != null) {
                    return ipAddress;
                }
            }

            //从下一个国家域名队列中获取代理
            int index = proxyStrList.indexOf(proxyServerIpAddress.getCountryDomain());

            for (int i = index + 1; i < proxyStrList.size(); i++) {
                String proxyDomain = proxyStrList.get(i);
                Map<Long, ProxyServerIpAddress> proxyIdMap2 = cacheProxy.get(proxyDomain);
                if (MapUtils.isNotEmpty(proxyIdMap2)) {
                    for (Map.Entry<Long, ProxyServerIpAddress> entry : proxyIdMap2.entrySet()) {
                        if (entry.getValue() != null) {
                            return entry.getValue();
                        }
                    }
                }
            }

            //threadLocal 中没有，择取第一个
            return obtainProxyByFirst(proxyStrList);
        }
    }

    private ProxyServerIpAddress obtainNextProxyByMapAndId(Map<Long, ProxyServerIpAddress> proxyIdMap, Long id) {
        for (Map.Entry<Long, ProxyServerIpAddress> entry : proxyIdMap.entrySet()) {
            if (entry.getKey() <= id) {
                continue;
            }

            if (entry.getValue() != null) {
                return entry.getValue();
            }
        }

        for (Map.Entry<Long, ProxyServerIpAddress> entry : proxyIdMap.entrySet()) {
            if (entry.getValue() != null) {
                return entry.getValue();
            }
        }

        return null;
    }

    private ProxyServerIpAddress obtainProxyByFirst(List<String> proxyStrList) {
        for (String str : proxyStrList) {
            Map<Long, ProxyServerIpAddress> proxyIdMap = cacheProxy.get(str);
            if (MapUtils.isNotEmpty(proxyIdMap)) {
                for (Map.Entry<Long, ProxyServerIpAddress> entry : proxyIdMap.entrySet()) {
                    ProxyServerIpAddress value = entry.getValue();
                    if (value != null) {
                        return value;
                    }
                }
            }
        }
        return null;
    }

    public void clearProxy() {
        threadLocal.remove();
    }
}
