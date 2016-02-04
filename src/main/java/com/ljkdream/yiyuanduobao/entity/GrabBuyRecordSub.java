package com.ljkdream.yiyuanduobao.entity;

import com.ljkdream.yiyuanduobao.model.GrabBuyRecord;
import com.ljkdream.yiyuanduobao.task.GrabBuyRecordTask;

/**
 * 抓取参与记录子对象
 * Created by jiangkui on 16-2-4.
 */
public class GrabBuyRecordSub {

    private int pageNum;
    private int pageSize;
    private long gid;
    private long period;
    private int totalCnt;
    private String url;

    public GrabBuyRecordSub(int pageNum, int pageSize, int totalCnt, long gid, long period) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalCnt = totalCnt;
        this.gid = gid;
        this.period = period;

        url = GrabBuyRecordTask.generateUrl(gid, period, pageNum, pageSize, totalCnt);
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getGid() {
        return gid;
    }

    public void setGid(long gid) {
        this.gid = gid;
    }

    public long getPeriod() {
        return period;
    }

    public void setPeriod(long period) {
        this.period = period;
    }

    public int getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(int totalCnt) {
        this.totalCnt = totalCnt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
