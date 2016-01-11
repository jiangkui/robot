package com.ljkdream.core.util;

import com.ljkdream.core.exception.HttpException;
import com.ljkdream.core.exception.HttpStatusException;
import com.ljkdream.proxy.model.CountryDomain;
import com.ljkdream.proxy.model.ProxyServerIpAddress;
import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 一个粗糙的 HttpClient 工具
 * <p/>
 * Created by LJK on 2015/7/15.
 */
public class HttpClientUtil {

    private static Logger log = Logger.getLogger(HttpClientUtil.class);

    private static ThreadLocal<CountryDomain> countryDomainThreadLocal = new ThreadLocal<>();

    private static RequestConfig baseRequestConfig = RequestConfig.custom()
            .setSocketTimeout(5000)
            .setConnectTimeout(5000)
            .setConnectionRequestTimeout(5000)
            .build();

    private static CloseableHttpClient httpClient = HttpClients.createDefault();

    /**
     * 执行url 请求
     * <p/>
     *
     * @param url url
     * @return 实体内容的字符串
     */
    public static String executeUrl(String url) throws IOException {
        String entityString = "";

        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(baseRequestConfig);

        log.debug("执行HTTP 请求：" + url);

        entityString = execute(httpPost);

        return entityString;
    }

    private static String execute(HttpPost httpPost) throws IOException {
        String url = httpPost.getURI().toString();
        String result = "";
        CloseableHttpResponse response = httpClient.execute(httpPost);
        StatusLine statusLine = response.getStatusLine();

        if (statusLine.getStatusCode() == 200) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }
        } else {
            Header[] allHeaders = response.getAllHeaders();
            HttpEntity entity = response.getEntity();

            StringBuilder sb = new StringBuilder();
            sb.append("【status = ").append(statusLine.getStatusCode()).append("】").append("【").append(Arrays.toString(allHeaders)).append("】");
            if (entity == null) {
                sb.append("【").append("entity is null").append("】");
            } else {
                sb.append("【").append(EntityUtils.toString(entity)).append("】");
            }

            log.error(sb.toString());
        }
        return result;
    }

    /**
     * post 方式，待参数
     *
     * @param url    请求地址
     * @param params 参数列表
     * @return entity
     */
    public static String executeByParams(String url, List<NameValuePair> params) throws IOException {
        String entityString = "";

        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(baseRequestConfig);
        httpPost.setEntity(new UrlEncodedFormEntity(params, Consts.UTF_8));

        log.debug("执行HTTP 请求：" + url);

        entityString = execute(httpPost);

        return entityString;
    }

    /**
     * 执行请求
     *
     * @param requestUrl   请求地址
     * @param proxyAddress 代理
     */
    public static String executeByProxy(String requestUrl, ProxyServerIpAddress proxyAddress) throws IOException {
        HttpPost httpPost = new HttpPost(requestUrl);

        if (proxyAddress != null) {
            HttpHost proxy = new HttpHost(proxyAddress.getIp(), proxyAddress.getPort(), "http");
            log.info("使用代理：" + proxyAddress + " 请求：" + requestUrl);
            RequestConfig requestConfig = RequestConfig.copy(baseRequestConfig).setProxy(proxy).build();
            httpPost.setConfig(requestConfig);
        } else {
//            log.warn("没有找到代理！");
        }

        String result = execute(httpPost);
        return result;
    }

    public static void main(String[] args) {
//        // 创建HttpClientBuilder
//        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
//        // HttpClient
//        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
//        // 依次是目标请求地址，端口号,协议类型
//        HttpHost target = new HttpHost("http://www.google.com", 80, "http");
//        // 依次是代理地址，代理端口号，协议类型
//        HttpHost proxy = new HttpHost("121.120.80.215", 80, "http");
//        RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
//
//        // 请求地址
//        HttpPost httpPost = new HttpPost("http://www.google.com");
//
//        httpPost.setConfig(config);
//        // 创建参数队列
//        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
//        // 参数名为pid，值是2
////        formparams.add(new BasicNameValuePair("wd", "%E5%85%8D%E8%B4%B9%E4%BB%A3%E7%90%86%E6%9C%8D%E5%8A%A1%E5%99%A8"));
//
//        UrlEncodedFormEntity entity;
//        try {
//            entity = new UrlEncodedFormEntity(formparams, "UTF-8");
//            httpPost.setEntity(entity);
//            CloseableHttpResponse response = closeableHttpClient.execute(target, httpPost);
//            // getEntity()
//            HttpEntity httpEntity = response.getEntity();
//            if (httpEntity != null) {
//                // 打印响应内容
//                System.out.println("response:"
//                        + EntityUtils.toString(httpEntity, "UTF-8"));
//            }
//            // 释放资源
//            closeableHttpClient.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

}

