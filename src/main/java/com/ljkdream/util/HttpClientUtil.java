package com.ljkdream.util;

import com.ljkdream.exception.HttpException;
import com.ljkdream.exception.HttpStatusException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 一个粗糙的 HttpClient 工具
 * <p/>
 * Created by LJK on 2015/7/15.
 */
public class HttpClientUtil {

    private static Logger log = Logger.getLogger(HttpClientUtil.class);

    private static RequestConfig requestConfig = RequestConfig.custom()
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
     * @throws HttpStatusException 状态不为200 的时候会抛出异常
     * @throws HttpException       其他错误
     */
    public static String executeUrl(String url) throws HttpStatusException, HttpException {
        String entityString = "";

        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);

        log.debug("执行HTTP 请求：" + url);

        try {
            CloseableHttpResponse response = httpClient.execute(httpPost);
            StatusLine statusLine = response.getStatusLine();
            Header[] allHeaders = response.getAllHeaders();

            if (statusLine.getStatusCode() == 200) {
                log.debug(statusLine + Arrays.toString(allHeaders));

                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    entityString = EntityUtils.toString(entity);
                }

            } else {
                log.error("【状态：" + statusLine + "】【响应头：" + Arrays.toString(allHeaders) + "】");
                throw new HttpStatusException(statusLine, allHeaders);
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error("网络请求模块，出错！【" + url + "】");
            throw new HttpException(url, e);
        }

        return entityString;
    }

    /**
     * post 方式，待参数
     *
     * @param url    请求地址
     * @param params 参数列表
     * @return entity
     * @throws HttpStatusException
     * @throws HttpException
     * @throws java.io.UnsupportedEncodingException
     */
    public static String execute(String url, List<NameValuePair> params) throws HttpStatusException, HttpException, UnsupportedEncodingException {
        String entityString = "";

        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

        log.debug("执行HTTP 请求：" + url);

        try {
            CloseableHttpResponse response = httpClient.execute(httpPost);
            StatusLine statusLine = response.getStatusLine();
            Header[] allHeaders = response.getAllHeaders();

            if (statusLine.getStatusCode() == 200) {
                log.debug(statusLine + Arrays.toString(allHeaders));

                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    entityString = EntityUtils.toString(entity);
                }

            } else {
                log.error("【状态：" + statusLine + "】【响应头：" + Arrays.toString(allHeaders) + "】");
                throw new HttpStatusException(statusLine, allHeaders);
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error("网络请求模块，出错！【" + url + "】");
            throw new HttpException(url, e);
        }

        return entityString;
    }

    public static final String CHECK_REGISTER_EXIST_URL = "http://www.letou360.com/promotion/checkUser";

    public static void main(String[] args) {
        try {

            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("params", "{'mobile':'18600363402'}"));

            String ss = HttpClientUtil.execute(CHECK_REGISTER_EXIST_URL, params);


            JSONObject jsonObject = new JSONObject(ss);
            String message = "";
            if (jsonObject.get("message") != null) {
                message = (String) jsonObject.get("message");
                if ("exists".equals(message)) {
                    System.out.println("用户已注册");
                } else {
                    System.out.println("用户没注册");
                }
            }

            System.out.println(jsonObject.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
