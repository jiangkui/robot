package com.ljkdream.task.ProxyService;

import com.ljkdream.exception.HttpException;
import com.ljkdream.exception.HttpStatusException;
import com.ljkdream.model.CountryDomain;
import com.ljkdream.model.ProxyServerIpAddress;
import com.ljkdream.service.ProxyServiceIpAddressService;
import com.ljkdream.task.base.AbstractBaseTask;
import com.ljkdream.util.HttpClientUtil;
import com.ljkdream.util.RegexUtil;
import org.apache.commons.lang.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 抓取 http://cn-proxy.com/ 中,国内代理服务器数据任务
 * <p/>
 * Created by ljk on 16-1-9.
 */
public class CnProxyComTask extends AbstractBaseTask {

    public static final String REQUEST_CN_URL = "http://cn-proxy.com/"; //国内代理
    public static final String REQUEST_INTERNATIONAL_URL = "http://cn-proxy.com/archives/218"; //国际代理
    public static final List<CountryDomain> proxyCountryDomainList = new ArrayList<>();
    private Logger logger = LoggerFactory.getLogger(CnProxyComTask.class);

    private String requestUrl = "";
    private ProxyServiceIpAddressService proxyService;

    static {
        CountryDomain hk = new CountryDomain("HK");
        CountryDomain us = new CountryDomain("US");
        CountryDomain tw = new CountryDomain("TW");
        proxyCountryDomainList.add(hk);
        proxyCountryDomainList.add(us);
        proxyCountryDomainList.add(tw);
    }

    public CnProxyComTask(String requestUrl, ProxyServiceIpAddressService proxyService) {
        this.requestUrl = requestUrl;
        this.proxyService = proxyService;
    }

    @Override
    public void execute() {
        try {
            String result = HttpClientUtil.execute(requestUrl, proxyCountryDomainList);

            List<ProxyServerIpAddress> proxyList = resolve(result);

            proxyService.saveOrUpdate(proxyList);
        } catch (HttpException | HttpStatusException e) {
            logger.error("http 请求失败！");
            e.printStackTrace();
        }
    }

    private List<ProxyServerIpAddress> resolve(String result) {
        List<ProxyServerIpAddress> proxyList = new ArrayList<>();

        Document document = new Document(result);
        Elements elementsByClass = document.getElementsByClass("table-container");

        for (Element element : elementsByClass) {
            Elements trs = element.getElementsByTag("tr");
            if (trs == null) {
                continue;
            }
            for (Element tr : trs) {
                Elements tds = tr.getElementsByTag("td");
                if (tds == null || tds.size() < 5) {
                    continue;
                }

                String ip = tds.get(0).html();
                if (RegexUtil.isIpAddress(ip)) {
                    ProxyServerIpAddress proxyServerIpAddress = createProxyServerIpAddress(tds);
                    if (proxyServerIpAddress != null) {
                        proxyList.add(proxyServerIpAddress);
                    }
                }
            }
        }

        return proxyList;
    }

    private ProxyServerIpAddress createProxyServerIpAddress(Elements elements) {
        ProxyServerIpAddress proxyServerIpAddress = new ProxyServerIpAddress();

        try {
            String ip = elements.get(0).html();
            int port = Integer.parseInt(elements.get(1).html());
            String address = elements.get(2).html();
            int speed = Integer.parseInt(elements.get(3).html());

            String domain = this.obtainCountryDomain(address);
            Date date = new Date();

            proxyServerIpAddress.setIp(ip);
            proxyServerIpAddress.setPort(port);
            proxyServerIpAddress.setCountryDomain(domain);
            proxyServerIpAddress.setStatus(ProxyServerIpAddress.STATUS_NORMAL);
            proxyServerIpAddress.setAddress(address);
            proxyServerIpAddress.setSpeed(speed);
            proxyServerIpAddress.setSpeedLevel(ProxyServerIpAddress.level(speed));
            proxyServerIpAddress.setProxyIdentityType(ProxyServerIpAddress.TYPE_THREE);
            proxyServerIpAddress.setCreateTime(date);
            proxyServerIpAddress.setModifyTime(date);
        } catch (Exception e) {
            return null;
        }

        return proxyServerIpAddress;
    }

    public String obtainCountryDomain(String address) {
        if (StringUtils.isEmpty(address) || address.length() < 2) {
            return "NN"; //未知
        }

        boolean zh = RegexUtil.containZhSimple(address);
        if (zh) {
            return "CN";
        } else {
            int length = address.length();
            return address.substring(length - 2, length);
        }
    }

    @Override
    public String toString() {
        return "抓取代理IP任务：http://cn-proxy.com/";
    }
}
