package com.ljkdream.yiyuanduobao.entity;

/**
 * gid 和 periodId 的一个包装对象。用来传递 这俩id数据
 * Created by jiangkui on 16-1-11.
 */
public class GidAndPeriodId {
    private long gid;
    private long period;

    public GidAndPeriodId(long gid, long period) {
        this.gid = gid;
        this.period = period;
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
}
