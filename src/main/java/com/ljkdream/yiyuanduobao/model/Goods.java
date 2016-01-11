package com.ljkdream.yiyuanduobao.model;

import java.util.Date;

public class Goods {
    private Long id;

    private Long gid;

    private String gname;

    private String price;

    private String desc;

    private String gpic;

    private String showPicNum;

    private String buyUnit;

    private String priceBase;

    private String tag;

    private String priceType;

    private String property;

    private String priceUnit;

    private String regularBuyMax;

    private String buyable;

    private String brand;

    private String wishSetable;

    private String typeId;

    private String goodsType;

    private Date createTime;

    private Date modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public String getGpic() {
        return gpic;
    }

    public void setGpic(String gpic) {
        this.gpic = gpic == null ? null : gpic.trim();
    }

    public String getShowPicNum() {
        return showPicNum;
    }

    public void setShowPicNum(String showPicNum) {
        this.showPicNum = showPicNum == null ? null : showPicNum.trim();
    }

    public String getBuyUnit() {
        return buyUnit;
    }

    public void setBuyUnit(String buyUnit) {
        this.buyUnit = buyUnit == null ? null : buyUnit.trim();
    }

    public String getPriceBase() {
        return priceBase;
    }

    public void setPriceBase(String priceBase) {
        this.priceBase = priceBase == null ? null : priceBase.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType == null ? null : priceType.trim();
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property == null ? null : property.trim();
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit == null ? null : priceUnit.trim();
    }

    public String getRegularBuyMax() {
        return regularBuyMax;
    }

    public void setRegularBuyMax(String regularBuyMax) {
        this.regularBuyMax = regularBuyMax == null ? null : regularBuyMax.trim();
    }

    public String getBuyable() {
        return buyable;
    }

    public void setBuyable(String buyable) {
        this.buyable = buyable == null ? null : buyable.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getWishSetable() {
        return wishSetable;
    }

    public void setWishSetable(String wishSetable) {
        this.wishSetable = wishSetable == null ? null : wishSetable.trim();
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType == null ? null : goodsType.trim();
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