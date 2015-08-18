package com.ljkdream.exception;

import org.apache.http.Header;
import org.apache.http.StatusLine;

/**
 * Http 响应状态异常 不是200
 * <p/>
 * 自行使用
 * <p/>
 * Created by LJK on 2015/6/24.
 */
public class HttpStatusException extends Exception {

    private StatusLine statusLine; //响应状态码
    private Header[] headers; //响应头信息。

    public HttpStatusException() {
    }

    public HttpStatusException(StatusLine statusLine, Header[] allHeaders) {
        this.statusLine = statusLine;
        this.headers = allHeaders;
    }

    public HttpStatusException(String message) {
        super(message);
    }

    public HttpStatusException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpStatusException(Throwable cause) {
        super(cause);
    }

    public HttpStatusException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public StatusLine getStatusLine() {
        return statusLine;
    }

    public void setStatusLine(StatusLine statusLine) {
        this.statusLine = statusLine;
    }

    public Header[] getHeaders() {
        return headers;
    }

    public void setHeaders(Header[] headers) {
        this.headers = headers;
    }
}
