package com.ljkdream.task.ProxyService;

import com.ljkdream.exception.HttpException;
import com.ljkdream.exception.HttpStatusException;
import com.ljkdream.model.CountryDomain;
import com.ljkdream.model.ProxyServerIpAddress;
import com.ljkdream.service.CountryDomainService;
import com.ljkdream.service.ProxyServiceIpAddressService;
import com.ljkdream.task.base.AbstractBaseTask;
import com.ljkdream.util.HttpClientUtil;
import com.ljkdream.util.RegexUtil;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * 抓取 http://cn-proxy.com/ 中,国内代理服务器数据任务
 * <p/>
 * Created by ljk on 16-1-9.
 */
public class CnProxyComTask extends AbstractBaseTask {

    public static final String REQUEST_CN_URL = "http://cn-proxy.com/"; //国内代理
    public static final String REQUEST_INTERNATIONAL_URL = "http://cn-proxy.com/archives/218"; //国际代理
    public static final List<String> proxyStrList = new ArrayList<>();
    private Logger logger = LoggerFactory.getLogger(CnProxyComTask.class);

    private String requestUrl = "";
    private ProxyServiceIpAddressService proxyService;

    static {
        proxyStrList.add("HK");
        proxyStrList.add("US");
        proxyStrList.add("TW");
    }

    public CnProxyComTask(String requestUrl, ProxyServiceIpAddressService proxyService) {
        this.requestUrl = requestUrl;
        this.proxyService = proxyService;
    }

    @Override
    public void execute() {
        for (int i = 0; i < 5; i++) {
            try {
                ProxyServerIpAddress proxyServerIpAddress = proxyService.obtainProxy(proxyStrList);

                String result = HttpClientUtil.executeByProxy(requestUrl, proxyServerIpAddress);

                List<ProxyServerIpAddress> proxyList = resolve(result);

                if (proxyList.size() > 0) {
                    logger.info("成功抓取："+proxyList.size() + "条数据");
                }
                proxyService.saveOrUpdate(proxyList);
                break;
            } catch (Exception e) {
                logger.error("http 请求失败！ 切换代理重试：第" + i + "次");
                proxyService.changeProxy(proxyStrList);
                e.printStackTrace();
            }
        }
        proxyService.clearProxy();
    }

    private List<ProxyServerIpAddress> resolve(String result) {
        List<ProxyServerIpAddress> proxyList = new ArrayList<>();

        Document document = Jsoup.parse(result);

        Elements elementsByClass;
        if (this.requestUrl.equals(REQUEST_CN_URL)) {
            elementsByClass = document.getElementsByClass("table-container");
        } else {
            elementsByClass = document.getElementsByClass("sortable");
        }

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
                    ProxyServerIpAddress proxyServerIpAddress;
                    if (this.requestUrl.equals(REQUEST_CN_URL)) {
                        proxyServerIpAddress = createProxyServerIpAddressByCN(tds);
                    } else {
                        proxyServerIpAddress = createProxyServerIpAddressByINTERNATIONAL(tds);
                    }
                    if (proxyServerIpAddress != null) {
                        proxyList.add(proxyServerIpAddress);
                    }
                }
            }
        }

        return proxyList;
    }

    private ProxyServerIpAddress createProxyServerIpAddressByCN(Elements elements) {
        ProxyServerIpAddress proxyServerIpAddress = new ProxyServerIpAddress();

        try {
            String ip = elements.get(0).html();
            int port = Integer.parseInt(elements.get(1).html());
            String address = elements.get(2).html();
            int speed = 0;
            Elements strong = elements.get(3).getElementsByTag("strong");
            String str = strong.toString();
            int width = str.indexOf("width")+ 6;
            int bai = str.indexOf("%");
            String speedStr = str.substring(width, bai).trim();
            speed = Integer.parseInt(speedStr);

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

    private ProxyServerIpAddress createProxyServerIpAddressByINTERNATIONAL(Elements elements) {
        ProxyServerIpAddress proxyServerIpAddress = new ProxyServerIpAddress();

        try {
            String ip = elements.get(0).html();
            int port = Integer.parseInt(elements.get(1).html());
            String address = elements.get(3).html();
            int speed = 0;
            String html = elements.get(4).html();
            String s = html.split("毫秒")[0].trim();
            speed = Integer.parseInt(s);

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

    public static void main(String[] args) {
        String str = "<strong class=\"bar\" style=\"width: 91%; background:#00dd00;\"><span></span></strong>";
        int width = str.indexOf("width")+ 6;
        int bai = str.indexOf("%");
        String substring = str.substring(width, bai).trim();

        System.out.println("substring = " + substring);
    }
}
