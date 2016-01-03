package com.ljkdream.model;

import java.util.ArrayList;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Long value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Long value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Long value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Long value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Long value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Long value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Long> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Long> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Long value1, Long value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Long value1, Long value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(String value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(String value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(String value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(String value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(String value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(String value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLike(String value) {
            addCriterion("uid like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotLike(String value) {
            addCriterion("uid not like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<String> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<String> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(String value1, String value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(String value1, String value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull() {
            addCriterion("nickname is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickname is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickname =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickname <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickname >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickname >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickname <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickname <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("nickname like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickname not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickname in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickname not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickname between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickname not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andIpaddressIsNull() {
            addCriterion("IPAddress is null");
            return (Criteria) this;
        }

        public Criteria andIpaddressIsNotNull() {
            addCriterion("IPAddress is not null");
            return (Criteria) this;
        }

        public Criteria andIpaddressEqualTo(String value) {
            addCriterion("IPAddress =", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressNotEqualTo(String value) {
            addCriterion("IPAddress <>", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressGreaterThan(String value) {
            addCriterion("IPAddress >", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressGreaterThanOrEqualTo(String value) {
            addCriterion("IPAddress >=", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressLessThan(String value) {
            addCriterion("IPAddress <", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressLessThanOrEqualTo(String value) {
            addCriterion("IPAddress <=", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressLike(String value) {
            addCriterion("IPAddress like", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressNotLike(String value) {
            addCriterion("IPAddress not like", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressIn(List<String> values) {
            addCriterion("IPAddress in", values, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressNotIn(List<String> values) {
            addCriterion("IPAddress not in", values, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressBetween(String value1, String value2) {
            addCriterion("IPAddress between", value1, value2, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressNotBetween(String value1, String value2) {
            addCriterion("IPAddress not between", value1, value2, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andAvatarnameIsNull() {
            addCriterion("avatarName is null");
            return (Criteria) this;
        }

        public Criteria andAvatarnameIsNotNull() {
            addCriterion("avatarName is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarnameEqualTo(String value) {
            addCriterion("avatarName =", value, "avatarname");
            return (Criteria) this;
        }

        public Criteria andAvatarnameNotEqualTo(String value) {
            addCriterion("avatarName <>", value, "avatarname");
            return (Criteria) this;
        }

        public Criteria andAvatarnameGreaterThan(String value) {
            addCriterion("avatarName >", value, "avatarname");
            return (Criteria) this;
        }

        public Criteria andAvatarnameGreaterThanOrEqualTo(String value) {
            addCriterion("avatarName >=", value, "avatarname");
            return (Criteria) this;
        }

        public Criteria andAvatarnameLessThan(String value) {
            addCriterion("avatarName <", value, "avatarname");
            return (Criteria) this;
        }

        public Criteria andAvatarnameLessThanOrEqualTo(String value) {
            addCriterion("avatarName <=", value, "avatarname");
            return (Criteria) this;
        }

        public Criteria andAvatarnameLike(String value) {
            addCriterion("avatarName like", value, "avatarname");
            return (Criteria) this;
        }

        public Criteria andAvatarnameNotLike(String value) {
            addCriterion("avatarName not like", value, "avatarname");
            return (Criteria) this;
        }

        public Criteria andAvatarnameIn(List<String> values) {
            addCriterion("avatarName in", values, "avatarname");
            return (Criteria) this;
        }

        public Criteria andAvatarnameNotIn(List<String> values) {
            addCriterion("avatarName not in", values, "avatarname");
            return (Criteria) this;
        }

        public Criteria andAvatarnameBetween(String value1, String value2) {
            addCriterion("avatarName between", value1, value2, "avatarname");
            return (Criteria) this;
        }

        public Criteria andAvatarnameNotBetween(String value1, String value2) {
            addCriterion("avatarName not between", value1, value2, "avatarname");
            return (Criteria) this;
        }

        public Criteria andAvatarprefixIsNull() {
            addCriterion("avatarPrefix is null");
            return (Criteria) this;
        }

        public Criteria andAvatarprefixIsNotNull() {
            addCriterion("avatarPrefix is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarprefixEqualTo(String value) {
            addCriterion("avatarPrefix =", value, "avatarprefix");
            return (Criteria) this;
        }

        public Criteria andAvatarprefixNotEqualTo(String value) {
            addCriterion("avatarPrefix <>", value, "avatarprefix");
            return (Criteria) this;
        }

        public Criteria andAvatarprefixGreaterThan(String value) {
            addCriterion("avatarPrefix >", value, "avatarprefix");
            return (Criteria) this;
        }

        public Criteria andAvatarprefixGreaterThanOrEqualTo(String value) {
            addCriterion("avatarPrefix >=", value, "avatarprefix");
            return (Criteria) this;
        }

        public Criteria andAvatarprefixLessThan(String value) {
            addCriterion("avatarPrefix <", value, "avatarprefix");
            return (Criteria) this;
        }

        public Criteria andAvatarprefixLessThanOrEqualTo(String value) {
            addCriterion("avatarPrefix <=", value, "avatarprefix");
            return (Criteria) this;
        }

        public Criteria andAvatarprefixLike(String value) {
            addCriterion("avatarPrefix like", value, "avatarprefix");
            return (Criteria) this;
        }

        public Criteria andAvatarprefixNotLike(String value) {
            addCriterion("avatarPrefix not like", value, "avatarprefix");
            return (Criteria) this;
        }

        public Criteria andAvatarprefixIn(List<String> values) {
            addCriterion("avatarPrefix in", values, "avatarprefix");
            return (Criteria) this;
        }

        public Criteria andAvatarprefixNotIn(List<String> values) {
            addCriterion("avatarPrefix not in", values, "avatarprefix");
            return (Criteria) this;
        }

        public Criteria andAvatarprefixBetween(String value1, String value2) {
            addCriterion("avatarPrefix between", value1, value2, "avatarprefix");
            return (Criteria) this;
        }

        public Criteria andAvatarprefixNotBetween(String value1, String value2) {
            addCriterion("avatarPrefix not between", value1, value2, "avatarprefix");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("IP is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("IP is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("IP =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("IP <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("IP >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("IP >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("IP <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("IP <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("IP like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("IP not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("IP in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("IP not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("IP between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("IP not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andFreecoinIsNull() {
            addCriterion("freeCoin is null");
            return (Criteria) this;
        }

        public Criteria andFreecoinIsNotNull() {
            addCriterion("freeCoin is not null");
            return (Criteria) this;
        }

        public Criteria andFreecoinEqualTo(String value) {
            addCriterion("freeCoin =", value, "freecoin");
            return (Criteria) this;
        }

        public Criteria andFreecoinNotEqualTo(String value) {
            addCriterion("freeCoin <>", value, "freecoin");
            return (Criteria) this;
        }

        public Criteria andFreecoinGreaterThan(String value) {
            addCriterion("freeCoin >", value, "freecoin");
            return (Criteria) this;
        }

        public Criteria andFreecoinGreaterThanOrEqualTo(String value) {
            addCriterion("freeCoin >=", value, "freecoin");
            return (Criteria) this;
        }

        public Criteria andFreecoinLessThan(String value) {
            addCriterion("freeCoin <", value, "freecoin");
            return (Criteria) this;
        }

        public Criteria andFreecoinLessThanOrEqualTo(String value) {
            addCriterion("freeCoin <=", value, "freecoin");
            return (Criteria) this;
        }

        public Criteria andFreecoinLike(String value) {
            addCriterion("freeCoin like", value, "freecoin");
            return (Criteria) this;
        }

        public Criteria andFreecoinNotLike(String value) {
            addCriterion("freeCoin not like", value, "freecoin");
            return (Criteria) this;
        }

        public Criteria andFreecoinIn(List<String> values) {
            addCriterion("freeCoin in", values, "freecoin");
            return (Criteria) this;
        }

        public Criteria andFreecoinNotIn(List<String> values) {
            addCriterion("freeCoin not in", values, "freecoin");
            return (Criteria) this;
        }

        public Criteria andFreecoinBetween(String value1, String value2) {
            addCriterion("freeCoin between", value1, value2, "freecoin");
            return (Criteria) this;
        }

        public Criteria andFreecoinNotBetween(String value1, String value2) {
            addCriterion("freeCoin not between", value1, value2, "freecoin");
            return (Criteria) this;
        }

        public Criteria andIsfirstloginIsNull() {
            addCriterion("isFirstLogin is null");
            return (Criteria) this;
        }

        public Criteria andIsfirstloginIsNotNull() {
            addCriterion("isFirstLogin is not null");
            return (Criteria) this;
        }

        public Criteria andIsfirstloginEqualTo(String value) {
            addCriterion("isFirstLogin =", value, "isfirstlogin");
            return (Criteria) this;
        }

        public Criteria andIsfirstloginNotEqualTo(String value) {
            addCriterion("isFirstLogin <>", value, "isfirstlogin");
            return (Criteria) this;
        }

        public Criteria andIsfirstloginGreaterThan(String value) {
            addCriterion("isFirstLogin >", value, "isfirstlogin");
            return (Criteria) this;
        }

        public Criteria andIsfirstloginGreaterThanOrEqualTo(String value) {
            addCriterion("isFirstLogin >=", value, "isfirstlogin");
            return (Criteria) this;
        }

        public Criteria andIsfirstloginLessThan(String value) {
            addCriterion("isFirstLogin <", value, "isfirstlogin");
            return (Criteria) this;
        }

        public Criteria andIsfirstloginLessThanOrEqualTo(String value) {
            addCriterion("isFirstLogin <=", value, "isfirstlogin");
            return (Criteria) this;
        }

        public Criteria andIsfirstloginLike(String value) {
            addCriterion("isFirstLogin like", value, "isfirstlogin");
            return (Criteria) this;
        }

        public Criteria andIsfirstloginNotLike(String value) {
            addCriterion("isFirstLogin not like", value, "isfirstlogin");
            return (Criteria) this;
        }

        public Criteria andIsfirstloginIn(List<String> values) {
            addCriterion("isFirstLogin in", values, "isfirstlogin");
            return (Criteria) this;
        }

        public Criteria andIsfirstloginNotIn(List<String> values) {
            addCriterion("isFirstLogin not in", values, "isfirstlogin");
            return (Criteria) this;
        }

        public Criteria andIsfirstloginBetween(String value1, String value2) {
            addCriterion("isFirstLogin between", value1, value2, "isfirstlogin");
            return (Criteria) this;
        }

        public Criteria andIsfirstloginNotBetween(String value1, String value2) {
            addCriterion("isFirstLogin not between", value1, value2, "isfirstlogin");
            return (Criteria) this;
        }

        public Criteria andCoinIsNull() {
            addCriterion("coin is null");
            return (Criteria) this;
        }

        public Criteria andCoinIsNotNull() {
            addCriterion("coin is not null");
            return (Criteria) this;
        }

        public Criteria andCoinEqualTo(String value) {
            addCriterion("coin =", value, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinNotEqualTo(String value) {
            addCriterion("coin <>", value, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinGreaterThan(String value) {
            addCriterion("coin >", value, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinGreaterThanOrEqualTo(String value) {
            addCriterion("coin >=", value, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinLessThan(String value) {
            addCriterion("coin <", value, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinLessThanOrEqualTo(String value) {
            addCriterion("coin <=", value, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinLike(String value) {
            addCriterion("coin like", value, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinNotLike(String value) {
            addCriterion("coin not like", value, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinIn(List<String> values) {
            addCriterion("coin in", values, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinNotIn(List<String> values) {
            addCriterion("coin not in", values, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinBetween(String value1, String value2) {
            addCriterion("coin between", value1, value2, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinNotBetween(String value1, String value2) {
            addCriterion("coin not between", value1, value2, "coin");
            return (Criteria) this;
        }

        public Criteria andBonusnumIsNull() {
            addCriterion("bonusNum is null");
            return (Criteria) this;
        }

        public Criteria andBonusnumIsNotNull() {
            addCriterion("bonusNum is not null");
            return (Criteria) this;
        }

        public Criteria andBonusnumEqualTo(String value) {
            addCriterion("bonusNum =", value, "bonusnum");
            return (Criteria) this;
        }

        public Criteria andBonusnumNotEqualTo(String value) {
            addCriterion("bonusNum <>", value, "bonusnum");
            return (Criteria) this;
        }

        public Criteria andBonusnumGreaterThan(String value) {
            addCriterion("bonusNum >", value, "bonusnum");
            return (Criteria) this;
        }

        public Criteria andBonusnumGreaterThanOrEqualTo(String value) {
            addCriterion("bonusNum >=", value, "bonusnum");
            return (Criteria) this;
        }

        public Criteria andBonusnumLessThan(String value) {
            addCriterion("bonusNum <", value, "bonusnum");
            return (Criteria) this;
        }

        public Criteria andBonusnumLessThanOrEqualTo(String value) {
            addCriterion("bonusNum <=", value, "bonusnum");
            return (Criteria) this;
        }

        public Criteria andBonusnumLike(String value) {
            addCriterion("bonusNum like", value, "bonusnum");
            return (Criteria) this;
        }

        public Criteria andBonusnumNotLike(String value) {
            addCriterion("bonusNum not like", value, "bonusnum");
            return (Criteria) this;
        }

        public Criteria andBonusnumIn(List<String> values) {
            addCriterion("bonusNum in", values, "bonusnum");
            return (Criteria) this;
        }

        public Criteria andBonusnumNotIn(List<String> values) {
            addCriterion("bonusNum not in", values, "bonusnum");
            return (Criteria) this;
        }

        public Criteria andBonusnumBetween(String value1, String value2) {
            addCriterion("bonusNum between", value1, value2, "bonusnum");
            return (Criteria) this;
        }

        public Criteria andBonusnumNotBetween(String value1, String value2) {
            addCriterion("bonusNum not between", value1, value2, "bonusnum");
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