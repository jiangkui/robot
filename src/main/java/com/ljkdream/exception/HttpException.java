package com.ljkdream.exception;

/**
 * Http 连接异常
 * <p/>
 * Created by LJK on 2015/6/24.
 */
public class HttpException extends Exception {

    private String url; //请求的url
    private Exception exception; //异常错误信息

    public HttpException(String url, Exception exception) {
        this.url = url;
        this.exception = exception;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
