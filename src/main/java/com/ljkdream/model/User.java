package com.ljkdream.model;

public class User {
    private Long id;

    private Long cid;

    private String uid;

    private String nickname;

    private String ipaddress;

    private String avatarname;

    private String avatarprefix;

    private String ip;

    private String mobile;

    private String freecoin;

    private String isfirstlogin;

    private String coin;

    private String bonusnum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress == null ? null : ipaddress.trim();
    }

    public String getAvatarname() {
        return avatarname;
    }

    public void setAvatarname(String avatarname) {
        this.avatarname = avatarname == null ? null : avatarname.trim();
    }

    public String getAvatarprefix() {
        return avatarprefix;
    }

    public void setAvatarprefix(String avatarprefix) {
        this.avatarprefix = avatarprefix == null ? null : avatarprefix.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getFreecoin() {
        return freecoin;
    }

    public void setFreecoin(String freecoin) {
        this.freecoin = freecoin == null ? null : freecoin.trim();
    }

    public String getIsfirstlogin() {
        return isfirstlogin;
    }

    public void setIsfirstlogin(String isfirstlogin) {
        this.isfirstlogin = isfirstlogin == null ? null : isfirstlogin.trim();
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin == null ? null : coin.trim();
    }

    public String getBonusnum() {
        return bonusnum;
    }

    public void setBonusnum(String bonusnum) {
        this.bonusnum = bonusnum == null ? null : bonusnum.trim();
    }
}