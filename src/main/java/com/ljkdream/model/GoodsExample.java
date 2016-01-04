package com.ljkdream.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGidIsNull() {
            addCriterion("gid is null");
            return (Criteria) this;
        }

        public Criteria andGidIsNotNull() {
            addCriterion("gid is not null");
            return (Criteria) this;
        }

        public Criteria andGidEqualTo(Long value) {
            addCriterion("gid =", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotEqualTo(Long value) {
            addCriterion("gid <>", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThan(Long value) {
            addCriterion("gid >", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThanOrEqualTo(Long value) {
            addCriterion("gid >=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThan(Long value) {
            addCriterion("gid <", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThanOrEqualTo(Long value) {
            addCriterion("gid <=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidIn(List<Long> values) {
            addCriterion("gid in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotIn(List<Long> values) {
            addCriterion("gid not in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidBetween(Long value1, Long value2) {
            addCriterion("gid between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotBetween(Long value1, Long value2) {
            addCriterion("gid not between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andGnameIsNull() {
            addCriterion("gname is null");
            return (Criteria) this;
        }

        public Criteria andGnameIsNotNull() {
            addCriterion("gname is not null");
            return (Criteria) this;
        }

        public Criteria andGnameEqualTo(String value) {
            addCriterion("gname =", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotEqualTo(String value) {
            addCriterion("gname <>", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameGreaterThan(String value) {
            addCriterion("gname >", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameGreaterThanOrEqualTo(String value) {
            addCriterion("gname >=", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLessThan(String value) {
            addCriterion("gname <", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLessThanOrEqualTo(String value) {
            addCriterion("gname <=", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLike(String value) {
            addCriterion("gname like", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotLike(String value) {
            addCriterion("gname not like", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameIn(List<String> values) {
            addCriterion("gname in", values, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotIn(List<String> values) {
            addCriterion("gname not in", values, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameBetween(String value1, String value2) {
            addCriterion("gname between", value1, value2, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotBetween(String value1, String value2) {
            addCriterion("gname not between", value1, value2, "gname");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(String value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(String value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(String value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(String value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(String value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(String value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLike(String value) {
            addCriterion("price like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotLike(String value) {
            addCriterion("price not like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<String> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<String> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(String value1, String value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(String value1, String value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andDescIsNull() {
            addCriterion("desc_str is null");
            return (Criteria) this;
        }

        public Criteria andDescIsNotNull() {
            addCriterion("desc_str is not null");
            return (Criteria) this;
        }

        public Criteria andDescEqualTo(String value) {
            addCriterion("desc_str =", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotEqualTo(String value) {
            addCriterion("desc_str <>", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescGreaterThan(String value) {
            addCriterion("desc_str >", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescGreaterThanOrEqualTo(String value) {
            addCriterion("desc_str >=", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLessThan(String value) {
            addCriterion("desc_str <", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLessThanOrEqualTo(String value) {
            addCriterion("desc_str <=", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLike(String value) {
            addCriterion("desc_str like", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotLike(String value) {
            addCriterion("desc_str not like", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescIn(List<String> values) {
            addCriterion("desc_str in", values, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotIn(List<String> values) {
            addCriterion("desc_str not in", values, "desc");
            return (Criteria) this;
        }

        public Criteria andDescBetween(String value1, String value2) {
            addCriterion("desc_str between", value1, value2, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotBetween(String value1, String value2) {
            addCriterion("desc_str not between", value1, value2, "desc");
            return (Criteria) this;
        }

        public Criteria andGpicIsNull() {
            addCriterion("gpic is null");
            return (Criteria) this;
        }

        public Criteria andGpicIsNotNull() {
            addCriterion("gpic is not null");
            return (Criteria) this;
        }

        public Criteria andGpicEqualTo(String value) {
            addCriterion("gpic =", value, "gpic");
            return (Criteria) this;
        }

        public Criteria andGpicNotEqualTo(String value) {
            addCriterion("gpic <>", value, "gpic");
            return (Criteria) this;
        }

        public Criteria andGpicGreaterThan(String value) {
            addCriterion("gpic >", value, "gpic");
            return (Criteria) this;
        }

        public Criteria andGpicGreaterThanOrEqualTo(String value) {
            addCriterion("gpic >=", value, "gpic");
            return (Criteria) this;
        }

        public Criteria andGpicLessThan(String value) {
            addCriterion("gpic <", value, "gpic");
            return (Criteria) this;
        }

        public Criteria andGpicLessThanOrEqualTo(String value) {
            addCriterion("gpic <=", value, "gpic");
            return (Criteria) this;
        }

        public Criteria andGpicLike(String value) {
            addCriterion("gpic like", value, "gpic");
            return (Criteria) this;
        }

        public Criteria andGpicNotLike(String value) {
            addCriterion("gpic not like", value, "gpic");
            return (Criteria) this;
        }

        public Criteria andGpicIn(List<String> values) {
            addCriterion("gpic in", values, "gpic");
            return (Criteria) this;
        }

        public Criteria andGpicNotIn(List<String> values) {
            addCriterion("gpic not in", values, "gpic");
            return (Criteria) this;
        }

        public Criteria andGpicBetween(String value1, String value2) {
            addCriterion("gpic between", value1, value2, "gpic");
            return (Criteria) this;
        }

        public Criteria andGpicNotBetween(String value1, String value2) {
            addCriterion("gpic not between", value1, value2, "gpic");
            return (Criteria) this;
        }

        public Criteria andShowPicNumIsNull() {
            addCriterion("show_pic_num is null");
            return (Criteria) this;
        }

        public Criteria andShowPicNumIsNotNull() {
            addCriterion("show_pic_num is not null");
            return (Criteria) this;
        }

        public Criteria andShowPicNumEqualTo(String value) {
            addCriterion("show_pic_num =", value, "showPicNum");
            return (Criteria) this;
        }

        public Criteria andShowPicNumNotEqualTo(String value) {
            addCriterion("show_pic_num <>", value, "showPicNum");
            return (Criteria) this;
        }

        public Criteria andShowPicNumGreaterThan(String value) {
            addCriterion("show_pic_num >", value, "showPicNum");
            return (Criteria) this;
        }

        public Criteria andShowPicNumGreaterThanOrEqualTo(String value) {
            addCriterion("show_pic_num >=", value, "showPicNum");
            return (Criteria) this;
        }

        public Criteria andShowPicNumLessThan(String value) {
            addCriterion("show_pic_num <", value, "showPicNum");
            return (Criteria) this;
        }

        public Criteria andShowPicNumLessThanOrEqualTo(String value) {
            addCriterion("show_pic_num <=", value, "showPicNum");
            return (Criteria) this;
        }

        public Criteria andShowPicNumLike(String value) {
            addCriterion("show_pic_num like", value, "showPicNum");
            return (Criteria) this;
        }

        public Criteria andShowPicNumNotLike(String value) {
            addCriterion("show_pic_num not like", value, "showPicNum");
            return (Criteria) this;
        }

        public Criteria andShowPicNumIn(List<String> values) {
            addCriterion("show_pic_num in", values, "showPicNum");
            return (Criteria) this;
        }

        public Criteria andShowPicNumNotIn(List<String> values) {
            addCriterion("show_pic_num not in", values, "showPicNum");
            return (Criteria) this;
        }

        public Criteria andShowPicNumBetween(String value1, String value2) {
            addCriterion("show_pic_num between", value1, value2, "showPicNum");
            return (Criteria) this;
        }

        public Criteria andShowPicNumNotBetween(String value1, String value2) {
            addCriterion("show_pic_num not between", value1, value2, "showPicNum");
            return (Criteria) this;
        }

        public Criteria andBuyUnitIsNull() {
            addCriterion("buy_unit is null");
            return (Criteria) this;
        }

        public Criteria andBuyUnitIsNotNull() {
            addCriterion("buy_unit is not null");
            return (Criteria) this;
        }

        public Criteria andBuyUnitEqualTo(String value) {
            addCriterion("buy_unit =", value, "buyUnit");
            return (Criteria) this;
        }

        public Criteria andBuyUnitNotEqualTo(String value) {
            addCriterion("buy_unit <>", value, "buyUnit");
            return (Criteria) this;
        }

        public Criteria andBuyUnitGreaterThan(String value) {
            addCriterion("buy_unit >", value, "buyUnit");
            return (Criteria) this;
        }

        public Criteria andBuyUnitGreaterThanOrEqualTo(String value) {
            addCriterion("buy_unit >=", value, "buyUnit");
            return (Criteria) this;
        }

        public Criteria andBuyUnitLessThan(String value) {
            addCriterion("buy_unit <", value, "buyUnit");
            return (Criteria) this;
        }

        public Criteria andBuyUnitLessThanOrEqualTo(String value) {
            addCriterion("buy_unit <=", value, "buyUnit");
            return (Criteria) this;
        }

        public Criteria andBuyUnitLike(String value) {
            addCriterion("buy_unit like", value, "buyUnit");
            return (Criteria) this;
        }

        public Criteria andBuyUnitNotLike(String value) {
            addCriterion("buy_unit not like", value, "buyUnit");
            return (Criteria) this;
        }

        public Criteria andBuyUnitIn(List<String> values) {
            addCriterion("buy_unit in", values, "buyUnit");
            return (Criteria) this;
        }

        public Criteria andBuyUnitNotIn(List<String> values) {
            addCriterion("buy_unit not in", values, "buyUnit");
            return (Criteria) this;
        }

        public Criteria andBuyUnitBetween(String value1, String value2) {
            addCriterion("buy_unit between", value1, value2, "buyUnit");
            return (Criteria) this;
        }

        public Criteria andBuyUnitNotBetween(String value1, String value2) {
            addCriterion("buy_unit not between", value1, value2, "buyUnit");
            return (Criteria) this;
        }

        public Criteria andPriceBaseIsNull() {
            addCriterion("price_base is null");
            return (Criteria) this;
        }

        public Criteria andPriceBaseIsNotNull() {
            addCriterion("price_base is not null");
            return (Criteria) this;
        }

        public Criteria andPriceBaseEqualTo(String value) {
            addCriterion("price_base =", value, "priceBase");
            return (Criteria) this;
        }

        public Criteria andPriceBaseNotEqualTo(String value) {
            addCriterion("price_base <>", value, "priceBase");
            return (Criteria) this;
        }

        public Criteria andPriceBaseGreaterThan(String value) {
            addCriterion("price_base >", value, "priceBase");
            return (Criteria) this;
        }

        public Criteria andPriceBaseGreaterThanOrEqualTo(String value) {
            addCriterion("price_base >=", value, "priceBase");
            return (Criteria) this;
        }

        public Criteria andPriceBaseLessThan(String value) {
            addCriterion("price_base <", value, "priceBase");
            return (Criteria) this;
        }

        public Criteria andPriceBaseLessThanOrEqualTo(String value) {
            addCriterion("price_base <=", value, "priceBase");
            return (Criteria) this;
        }

        public Criteria andPriceBaseLike(String value) {
            addCriterion("price_base like", value, "priceBase");
            return (Criteria) this;
        }

        public Criteria andPriceBaseNotLike(String value) {
            addCriterion("price_base not like", value, "priceBase");
            return (Criteria) this;
        }

        public Criteria andPriceBaseIn(List<String> values) {
            addCriterion("price_base in", values, "priceBase");
            return (Criteria) this;
        }

        public Criteria andPriceBaseNotIn(List<String> values) {
            addCriterion("price_base not in", values, "priceBase");
            return (Criteria) this;
        }

        public Criteria andPriceBaseBetween(String value1, String value2) {
            addCriterion("price_base between", value1, value2, "priceBase");
            return (Criteria) this;
        }

        public Criteria andPriceBaseNotBetween(String value1, String value2) {
            addCriterion("price_base not between", value1, value2, "priceBase");
            return (Criteria) this;
        }

        public Criteria andTagIsNull() {
            addCriterion("tag is null");
            return (Criteria) this;
        }

        public Criteria andTagIsNotNull() {
            addCriterion("tag is not null");
            return (Criteria) this;
        }

        public Criteria andTagEqualTo(String value) {
            addCriterion("tag =", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotEqualTo(String value) {
            addCriterion("tag <>", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThan(String value) {
            addCriterion("tag >", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThanOrEqualTo(String value) {
            addCriterion("tag >=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThan(String value) {
            addCriterion("tag <", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThanOrEqualTo(String value) {
            addCriterion("tag <=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLike(String value) {
            addCriterion("tag like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotLike(String value) {
            addCriterion("tag not like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagIn(List<String> values) {
            addCriterion("tag in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotIn(List<String> values) {
            addCriterion("tag not in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagBetween(String value1, String value2) {
            addCriterion("tag between", value1, value2, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotBetween(String value1, String value2) {
            addCriterion("tag not between", value1, value2, "tag");
            return (Criteria) this;
        }

        public Criteria andPriceTypeIsNull() {
            addCriterion("price_type is null");
            return (Criteria) this;
        }

        public Criteria andPriceTypeIsNotNull() {
            addCriterion("price_type is not null");
            return (Criteria) this;
        }

        public Criteria andPriceTypeEqualTo(String value) {
            addCriterion("price_type =", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeNotEqualTo(String value) {
            addCriterion("price_type <>", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeGreaterThan(String value) {
            addCriterion("price_type >", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("price_type >=", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeLessThan(String value) {
            addCriterion("price_type <", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeLessThanOrEqualTo(String value) {
            addCriterion("price_type <=", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeLike(String value) {
            addCriterion("price_type like", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeNotLike(String value) {
            addCriterion("price_type not like", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeIn(List<String> values) {
            addCriterion("price_type in", values, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeNotIn(List<String> values) {
            addCriterion("price_type not in", values, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeBetween(String value1, String value2) {
            addCriterion("price_type between", value1, value2, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeNotBetween(String value1, String value2) {
            addCriterion("price_type not between", value1, value2, "priceType");
            return (Criteria) this;
        }

        public Criteria andPropertyIsNull() {
            addCriterion("property is null");
            return (Criteria) this;
        }

        public Criteria andPropertyIsNotNull() {
            addCriterion("property is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyEqualTo(String value) {
            addCriterion("property =", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotEqualTo(String value) {
            addCriterion("property <>", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyGreaterThan(String value) {
            addCriterion("property >", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyGreaterThanOrEqualTo(String value) {
            addCriterion("property >=", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyLessThan(String value) {
            addCriterion("property <", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyLessThanOrEqualTo(String value) {
            addCriterion("property <=", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyLike(String value) {
            addCriterion("property like", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotLike(String value) {
            addCriterion("property not like", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyIn(List<String> values) {
            addCriterion("property in", values, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotIn(List<String> values) {
            addCriterion("property not in", values, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyBetween(String value1, String value2) {
            addCriterion("property between", value1, value2, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotBetween(String value1, String value2) {
            addCriterion("property not between", value1, value2, "property");
            return (Criteria) this;
        }

        public Criteria andPriceUnitIsNull() {
            addCriterion("price_unit is null");
            return (Criteria) this;
        }

        public Criteria andPriceUnitIsNotNull() {
            addCriterion("price_unit is not null");
            return (Criteria) this;
        }

        public Criteria andPriceUnitEqualTo(String value) {
            addCriterion("price_unit =", value, "priceUnit");
            return (Criteria) this;
        }

        public Criteria andPriceUnitNotEqualTo(String value) {
            addCriterion("price_unit <>", value, "priceUnit");
            return (Criteria) this;
        }

        public Criteria andPriceUnitGreaterThan(String value) {
            addCriterion("price_unit >", value, "priceUnit");
            return (Criteria) this;
        }

        public Criteria andPriceUnitGreaterThanOrEqualTo(String value) {
            addCriterion("price_unit >=", value, "priceUnit");
            return (Criteria) this;
        }

        public Criteria andPriceUnitLessThan(String value) {
            addCriterion("price_unit <", value, "priceUnit");
            return (Criteria) this;
        }

        public Criteria andPriceUnitLessThanOrEqualTo(String value) {
            addCriterion("price_unit <=", value, "priceUnit");
            return (Criteria) this;
        }

        public Criteria andPriceUnitLike(String value) {
            addCriterion("price_unit like", value, "priceUnit");
            return (Criteria) this;
        }

        public Criteria andPriceUnitNotLike(String value) {
            addCriterion("price_unit not like", value, "priceUnit");
            return (Criteria) this;
        }

        public Criteria andPriceUnitIn(List<String> values) {
            addCriterion("price_unit in", values, "priceUnit");
            return (Criteria) this;
        }

        public Criteria andPriceUnitNotIn(List<String> values) {
            addCriterion("price_unit not in", values, "priceUnit");
            return (Criteria) this;
        }

        public Criteria andPriceUnitBetween(String value1, String value2) {
            addCriterion("price_unit between", value1, value2, "priceUnit");
            return (Criteria) this;
        }

        public Criteria andPriceUnitNotBetween(String value1, String value2) {
            addCriterion("price_unit not between", value1, value2, "priceUnit");
            return (Criteria) this;
        }

        public Criteria andRegularBuyMaxIsNull() {
            addCriterion("regular_buy_max is null");
            return (Criteria) this;
        }

        public Criteria andRegularBuyMaxIsNotNull() {
            addCriterion("regular_buy_max is not null");
            return (Criteria) this;
        }

        public Criteria andRegularBuyMaxEqualTo(String value) {
            addCriterion("regular_buy_max =", value, "regularBuyMax");
            return (Criteria) this;
        }

        public Criteria andRegularBuyMaxNotEqualTo(String value) {
            addCriterion("regular_buy_max <>", value, "regularBuyMax");
            return (Criteria) this;
        }

        public Criteria andRegularBuyMaxGreaterThan(String value) {
            addCriterion("regular_buy_max >", value, "regularBuyMax");
            return (Criteria) this;
        }

        public Criteria andRegularBuyMaxGreaterThanOrEqualTo(String value) {
            addCriterion("regular_buy_max >=", value, "regularBuyMax");
            return (Criteria) this;
        }

        public Criteria andRegularBuyMaxLessThan(String value) {
            addCriterion("regular_buy_max <", value, "regularBuyMax");
            return (Criteria) this;
        }

        public Criteria andRegularBuyMaxLessThanOrEqualTo(String value) {
            addCriterion("regular_buy_max <=", value, "regularBuyMax");
            return (Criteria) this;
        }

        public Criteria andRegularBuyMaxLike(String value) {
            addCriterion("regular_buy_max like", value, "regularBuyMax");
            return (Criteria) this;
        }

        public Criteria andRegularBuyMaxNotLike(String value) {
            addCriterion("regular_buy_max not like", value, "regularBuyMax");
            return (Criteria) this;
        }

        public Criteria andRegularBuyMaxIn(List<String> values) {
            addCriterion("regular_buy_max in", values, "regularBuyMax");
            return (Criteria) this;
        }

        public Criteria andRegularBuyMaxNotIn(List<String> values) {
            addCriterion("regular_buy_max not in", values, "regularBuyMax");
            return (Criteria) this;
        }

        public Criteria andRegularBuyMaxBetween(String value1, String value2) {
            addCriterion("regular_buy_max between", value1, value2, "regularBuyMax");
            return (Criteria) this;
        }

        public Criteria andRegularBuyMaxNotBetween(String value1, String value2) {
            addCriterion("regular_buy_max not between", value1, value2, "regularBuyMax");
            return (Criteria) this;
        }

        public Criteria andBuyableIsNull() {
            addCriterion("buyable is null");
            return (Criteria) this;
        }

        public Criteria andBuyableIsNotNull() {
            addCriterion("buyable is not null");
            return (Criteria) this;
        }

        public Criteria andBuyableEqualTo(String value) {
            addCriterion("buyable =", value, "buyable");
            return (Criteria) this;
        }

        public Criteria andBuyableNotEqualTo(String value) {
            addCriterion("buyable <>", value, "buyable");
            return (Criteria) this;
        }

        public Criteria andBuyableGreaterThan(String value) {
            addCriterion("buyable >", value, "buyable");
            return (Criteria) this;
        }

        public Criteria andBuyableGreaterThanOrEqualTo(String value) {
            addCriterion("buyable >=", value, "buyable");
            return (Criteria) this;
        }

        public Criteria andBuyableLessThan(String value) {
            addCriterion("buyable <", value, "buyable");
            return (Criteria) this;
        }

        public Criteria andBuyableLessThanOrEqualTo(String value) {
            addCriterion("buyable <=", value, "buyable");
            return (Criteria) this;
        }

        public Criteria andBuyableLike(String value) {
            addCriterion("buyable like", value, "buyable");
            return (Criteria) this;
        }

        public Criteria andBuyableNotLike(String value) {
            addCriterion("buyable not like", value, "buyable");
            return (Criteria) this;
        }

        public Criteria andBuyableIn(List<String> values) {
            addCriterion("buyable in", values, "buyable");
            return (Criteria) this;
        }

        public Criteria andBuyableNotIn(List<String> values) {
            addCriterion("buyable not in", values, "buyable");
            return (Criteria) this;
        }

        public Criteria andBuyableBetween(String value1, String value2) {
            addCriterion("buyable between", value1, value2, "buyable");
            return (Criteria) this;
        }

        public Criteria andBuyableNotBetween(String value1, String value2) {
            addCriterion("buyable not between", value1, value2, "buyable");
            return (Criteria) this;
        }

        public Criteria andBrandIsNull() {
            addCriterion("brand is null");
            return (Criteria) this;
        }

        public Criteria andBrandIsNotNull() {
            addCriterion("brand is not null");
            return (Criteria) this;
        }

        public Criteria andBrandEqualTo(String value) {
            addCriterion("brand =", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotEqualTo(String value) {
            addCriterion("brand <>", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThan(String value) {
            addCriterion("brand >", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThanOrEqualTo(String value) {
            addCriterion("brand >=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThan(String value) {
            addCriterion("brand <", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThanOrEqualTo(String value) {
            addCriterion("brand <=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLike(String value) {
            addCriterion("brand like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotLike(String value) {
            addCriterion("brand not like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandIn(List<String> values) {
            addCriterion("brand in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotIn(List<String> values) {
            addCriterion("brand not in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandBetween(String value1, String value2) {
            addCriterion("brand between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotBetween(String value1, String value2) {
            addCriterion("brand not between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andWishSetableIsNull() {
            addCriterion("wish_setable is null");
            return (Criteria) this;
        }

        public Criteria andWishSetableIsNotNull() {
            addCriterion("wish_setable is not null");
            return (Criteria) this;
        }

        public Criteria andWishSetableEqualTo(String value) {
            addCriterion("wish_setable =", value, "wishSetable");
            return (Criteria) this;
        }

        public Criteria andWishSetableNotEqualTo(String value) {
            addCriterion("wish_setable <>", value, "wishSetable");
            return (Criteria) this;
        }

        public Criteria andWishSetableGreaterThan(String value) {
            addCriterion("wish_setable >", value, "wishSetable");
            return (Criteria) this;
        }

        public Criteria andWishSetableGreaterThanOrEqualTo(String value) {
            addCriterion("wish_setable >=", value, "wishSetable");
            return (Criteria) this;
        }

        public Criteria andWishSetableLessThan(String value) {
            addCriterion("wish_setable <", value, "wishSetable");
            return (Criteria) this;
        }

        public Criteria andWishSetableLessThanOrEqualTo(String value) {
            addCriterion("wish_setable <=", value, "wishSetable");
            return (Criteria) this;
        }

        public Criteria andWishSetableLike(String value) {
            addCriterion("wish_setable like", value, "wishSetable");
            return (Criteria) this;
        }

        public Criteria andWishSetableNotLike(String value) {
            addCriterion("wish_setable not like", value, "wishSetable");
            return (Criteria) this;
        }

        public Criteria andWishSetableIn(List<String> values) {
            addCriterion("wish_setable in", values, "wishSetable");
            return (Criteria) this;
        }

        public Criteria andWishSetableNotIn(List<String> values) {
            addCriterion("wish_setable not in", values, "wishSetable");
            return (Criteria) this;
        }

        public Criteria andWishSetableBetween(String value1, String value2) {
            addCriterion("wish_setable between", value1, value2, "wishSetable");
            return (Criteria) this;
        }

        public Criteria andWishSetableNotBetween(String value1, String value2) {
            addCriterion("wish_setable not between", value1, value2, "wishSetable");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(String value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(String value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(String value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(String value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(String value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLike(String value) {
            addCriterion("type_id like", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotLike(String value) {
            addCriterion("type_id not like", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<String> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<String> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(String value1, String value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(String value1, String value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIsNull() {
            addCriterion("goods_type is null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIsNotNull() {
            addCriterion("goods_type is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeEqualTo(String value) {
            addCriterion("goods_type =", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotEqualTo(String value) {
            addCriterion("goods_type <>", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeGreaterThan(String value) {
            addCriterion("goods_type >", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeGreaterThanOrEqualTo(String value) {
            addCriterion("goods_type >=", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLessThan(String value) {
            addCriterion("goods_type <", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLessThanOrEqualTo(String value) {
            addCriterion("goods_type <=", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLike(String value) {
            addCriterion("goods_type like", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotLike(String value) {
            addCriterion("goods_type not like", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIn(List<String> values) {
            addCriterion("goods_type in", values, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotIn(List<String> values) {
            addCriterion("goods_type not in", values, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeBetween(String value1, String value2) {
            addCriterion("goods_type between", value1, value2, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotBetween(String value1, String value2) {
            addCriterion("goods_type not between", value1, value2, "goodsType");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}