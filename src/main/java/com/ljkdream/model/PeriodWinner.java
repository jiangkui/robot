package com.ljkdream.model;

import java.util.Date;

public class PeriodWinner {
    private Long id;

    private Long period;

    private Long cid;

    private Long gid;

    private String ownerCost;

    private String luckyCode;

    private Date duobaoTime;

    private Date calcTime;

    private String status;

    private String cost;

    private String duobaoTimeStr;

    private String calcTimeStr;

    private Date createTime;

    private Date modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPeriod() {
        return period;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public String getOwnerCost() {
        return ownerCost;
    }

    public void setOwnerCost(String ownerCost) {
        this.ownerCost = ownerCost == null ? null : ownerCost.trim();
    }

    public String getLuckyCode() {
        return luckyCode;
    }

    public void setLuckyCode(String luckyCode) {
        this.luckyCode = luckyCode == null ? null : luckyCode.trim();
    }

    public Date getDuobaoTime() {
        return duobaoTime;
    }

    public void setDuobaoTime(Date duobaoTime) {
        this.duobaoTime = duobaoTime;
    }

    public Date getCalcTime() {
        return calcTime;
    }

    public void setCalcTime(Date calcTime) {
        this.calcTime = calcTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost == null ? null : cost.trim();
    }

    public String getDuobaoTimeStr() {
        return duobaoTimeStr;
    }

    public void setDuobaoTimeStr(String duobaoTimeStr) {
        this.duobaoTimeStr = duobaoTimeStr == null ? null : duobaoTimeStr.trim();
    }

    public String getCalcTimeStr() {
        return calcTimeStr;
    }

    public void setCalcTimeStr(String calcTimeStr) {
        this.calcTimeStr = calcTimeStr == null ? null : calcTimeStr.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}