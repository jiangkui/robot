package com.ljkdream.model;

import java.util.Date;

public class ProxyServerIpAddress {
    public static final int STATUS_NORMAL = 1;//正常状态

    public static final int TYPE_ONE = 1;//透明代理
    public static final int TYPE_TWO = 2;//高度匿名
    public static final int TYPE_THREE = 3;//普通匿名

    public static final int LEVEL_ONE = 1;//速读等级 0~500 ms
    public static final int LEVEL_TWO = 2;//速读等级 500~1000 ms
    public static final int LEVEL_THREE = 3;//速读等级 1~5 s
    public static final int LEVEL_FORE = 4;//速读等级 >5 s

    public static int level(int speed) {
        if (speed < 500) {
            return LEVEL_ONE;
        }

        if (speed < 1000) {
            return LEVEL_TWO;
        }

        if (speed < 5000) {
            return LEVEL_THREE;
        }

        return LEVEL_FORE;
    }

    private Long id;

    private String ip;

    private Integer port;

    private String countryDomain;

    private Integer status;

    private String address;

    private Integer speed;

    private Integer speedLevel;

    private Integer proxyIdentityType;

    private Date createTime;

    private Date modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getCountryDomain() {
        return countryDomain;
    }

    public void setCountryDomain(String countryDomain) {
        this.countryDomain = countryDomain == null ? null : countryDomain.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getSpeedLevel() {
        return speedLevel;
    }

    public void setSpeedLevel(Integer speedLevel) {
        this.speedLevel = speedLevel;
    }

    public Integer getProxyIdentityType() {
        return proxyIdentityType;
    }

    public void setProxyIdentityType(Integer proxyIdentityType) {
        this.proxyIdentityType = proxyIdentityType;
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