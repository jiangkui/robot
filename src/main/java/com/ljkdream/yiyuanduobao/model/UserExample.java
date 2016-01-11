package com.ljkdream.yiyuanduobao.model;

import java.util.ArrayList;
import java.util.Date;
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

        public Criteria andIPAddressIsNull() {
            addCriterion("IP_address is null");
            return (Criteria) this;
        }

        public Criteria andIPAddressIsNotNull() {
            addCriterion("IP_address is not null");
            return (Criteria) this;
        }

        public Criteria andIPAddressEqualTo(String value) {
            addCriterion("IP_address =", value, "IPAddress");
            return (Criteria) this;
        }

        public Criteria andIPAddressNotEqualTo(String value) {
            addCriterion("IP_address <>", value, "IPAddress");
            return (Criteria) this;
        }

        public Criteria andIPAddressGreaterThan(String value) {
            addCriterion("IP_address >", value, "IPAddress");
            return (Criteria) this;
        }

        public Criteria andIPAddressGreaterThanOrEqualTo(String value) {
            addCriterion("IP_address >=", value, "IPAddress");
            return (Criteria) this;
        }

        public Criteria andIPAddressLessThan(String value) {
            addCriterion("IP_address <", value, "IPAddress");
            return (Criteria) this;
        }

        public Criteria andIPAddressLessThanOrEqualTo(String value) {
            addCriterion("IP_address <=", value, "IPAddress");
            return (Criteria) this;
        }

        public Criteria andIPAddressLike(String value) {
            addCriterion("IP_address like", value, "IPAddress");
            return (Criteria) this;
        }

        public Criteria andIPAddressNotLike(String value) {
            addCriterion("IP_address not like", value, "IPAddress");
            return (Criteria) this;
        }

        public Criteria andIPAddressIn(List<String> values) {
            addCriterion("IP_address in", values, "IPAddress");
            return (Criteria) this;
        }

        public Criteria andIPAddressNotIn(List<String> values) {
            addCriterion("IP_address not in", values, "IPAddress");
            return (Criteria) this;
        }

        public Criteria andIPAddressBetween(String value1, String value2) {
            addCriterion("IP_address between", value1, value2, "IPAddress");
            return (Criteria) this;
        }

        public Criteria andIPAddressNotBetween(String value1, String value2) {
            addCriterion("IP_address not between", value1, value2, "IPAddress");
            return (Criteria) this;
        }

        public Criteria andAvatarNameIsNull() {
            addCriterion("avatar_name is null");
            return (Criteria) this;
        }

        public Criteria andAvatarNameIsNotNull() {
            addCriterion("avatar_name is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarNameEqualTo(String value) {
            addCriterion("avatar_name =", value, "avatarName");
            return (Criteria) this;
        }

        public Criteria andAvatarNameNotEqualTo(String value) {
            addCriterion("avatar_name <>", value, "avatarName");
            return (Criteria) this;
        }

        public Criteria andAvatarNameGreaterThan(String value) {
            addCriterion("avatar_name >", value, "avatarName");
            return (Criteria) this;
        }

        public Criteria andAvatarNameGreaterThanOrEqualTo(String value) {
            addCriterion("avatar_name >=", value, "avatarName");
            return (Criteria) this;
        }

        public Criteria andAvatarNameLessThan(String value) {
            addCriterion("avatar_name <", value, "avatarName");
            return (Criteria) this;
        }

        public Criteria andAvatarNameLessThanOrEqualTo(String value) {
            addCriterion("avatar_name <=", value, "avatarName");
            return (Criteria) this;
        }

        public Criteria andAvatarNameLike(String value) {
            addCriterion("avatar_name like", value, "avatarName");
            return (Criteria) this;
        }

        public Criteria andAvatarNameNotLike(String value) {
            addCriterion("avatar_name not like", value, "avatarName");
            return (Criteria) this;
        }

        public Criteria andAvatarNameIn(List<String> values) {
            addCriterion("avatar_name in", values, "avatarName");
            return (Criteria) this;
        }

        public Criteria andAvatarNameNotIn(List<String> values) {
            addCriterion("avatar_name not in", values, "avatarName");
            return (Criteria) this;
        }

        public Criteria andAvatarNameBetween(String value1, String value2) {
            addCriterion("avatar_name between", value1, value2, "avatarName");
            return (Criteria) this;
        }

        public Criteria andAvatarNameNotBetween(String value1, String value2) {
            addCriterion("avatar_name not between", value1, value2, "avatarName");
            return (Criteria) this;
        }

        public Criteria andAvatarPrefixIsNull() {
            addCriterion("avatar_prefix is null");
            return (Criteria) this;
        }

        public Criteria andAvatarPrefixIsNotNull() {
            addCriterion("avatar_prefix is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarPrefixEqualTo(String value) {
            addCriterion("avatar_prefix =", value, "avatarPrefix");
            return (Criteria) this;
        }

        public Criteria andAvatarPrefixNotEqualTo(String value) {
            addCriterion("avatar_prefix <>", value, "avatarPrefix");
            return (Criteria) this;
        }

        public Criteria andAvatarPrefixGreaterThan(String value) {
            addCriterion("avatar_prefix >", value, "avatarPrefix");
            return (Criteria) this;
        }

        public Criteria andAvatarPrefixGreaterThanOrEqualTo(String value) {
            addCriterion("avatar_prefix >=", value, "avatarPrefix");
            return (Criteria) this;
        }

        public Criteria andAvatarPrefixLessThan(String value) {
            addCriterion("avatar_prefix <", value, "avatarPrefix");
            return (Criteria) this;
        }

        public Criteria andAvatarPrefixLessThanOrEqualTo(String value) {
            addCriterion("avatar_prefix <=", value, "avatarPrefix");
            return (Criteria) this;
        }

        public Criteria andAvatarPrefixLike(String value) {
            addCriterion("avatar_prefix like", value, "avatarPrefix");
            return (Criteria) this;
        }

        public Criteria andAvatarPrefixNotLike(String value) {
            addCriterion("avatar_prefix not like", value, "avatarPrefix");
            return (Criteria) this;
        }

        public Criteria andAvatarPrefixIn(List<String> values) {
            addCriterion("avatar_prefix in", values, "avatarPrefix");
            return (Criteria) this;
        }

        public Criteria andAvatarPrefixNotIn(List<String> values) {
            addCriterion("avatar_prefix not in", values, "avatarPrefix");
            return (Criteria) this;
        }

        public Criteria andAvatarPrefixBetween(String value1, String value2) {
            addCriterion("avatar_prefix between", value1, value2, "avatarPrefix");
            return (Criteria) this;
        }

        public Criteria andAvatarPrefixNotBetween(String value1, String value2) {
            addCriterion("avatar_prefix not between", value1, value2, "avatarPrefix");
            return (Criteria) this;
        }

        public Criteria andIPIsNull() {
            addCriterion("IP is null");
            return (Criteria) this;
        }

        public Criteria andIPIsNotNull() {
            addCriterion("IP is not null");
            return (Criteria) this;
        }

        public Criteria andIPEqualTo(String value) {
            addCriterion("IP =", value, "IP");
            return (Criteria) this;
        }

        public Criteria andIPNotEqualTo(String value) {
            addCriterion("IP <>", value, "IP");
            return (Criteria) this;
        }

        public Criteria andIPGreaterThan(String value) {
            addCriterion("IP >", value, "IP");
            return (Criteria) this;
        }

        public Criteria andIPGreaterThanOrEqualTo(String value) {
            addCriterion("IP >=", value, "IP");
            return (Criteria) this;
        }

        public Criteria andIPLessThan(String value) {
            addCriterion("IP <", value, "IP");
            return (Criteria) this;
        }

        public Criteria andIPLessThanOrEqualTo(String value) {
            addCriterion("IP <=", value, "IP");
            return (Criteria) this;
        }

        public Criteria andIPLike(String value) {
            addCriterion("IP like", value, "IP");
            return (Criteria) this;
        }

        public Criteria andIPNotLike(String value) {
            addCriterion("IP not like", value, "IP");
            return (Criteria) this;
        }

        public Criteria andIPIn(List<String> values) {
            addCriterion("IP in", values, "IP");
            return (Criteria) this;
        }

        public Criteria andIPNotIn(List<String> values) {
            addCriterion("IP not in", values, "IP");
            return (Criteria) this;
        }

        public Criteria andIPBetween(String value1, String value2) {
            addCriterion("IP between", value1, value2, "IP");
            return (Criteria) this;
        }

        public Criteria andIPNotBetween(String value1, String value2) {
            addCriterion("IP not between", value1, value2, "IP");
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

        public Criteria andFreeCoinIsNull() {
            addCriterion("free_coin is null");
            return (Criteria) this;
        }

        public Criteria andFreeCoinIsNotNull() {
            addCriterion("free_coin is not null");
            return (Criteria) this;
        }

        public Criteria andFreeCoinEqualTo(String value) {
            addCriterion("free_coin =", value, "freeCoin");
            return (Criteria) this;
        }

        public Criteria andFreeCoinNotEqualTo(String value) {
            addCriterion("free_coin <>", value, "freeCoin");
            return (Criteria) this;
        }

        public Criteria andFreeCoinGreaterThan(String value) {
            addCriterion("free_coin >", value, "freeCoin");
            return (Criteria) this;
        }

        public Criteria andFreeCoinGreaterThanOrEqualTo(String value) {
            addCriterion("free_coin >=", value, "freeCoin");
            return (Criteria) this;
        }

        public Criteria andFreeCoinLessThan(String value) {
            addCriterion("free_coin <", value, "freeCoin");
            return (Criteria) this;
        }

        public Criteria andFreeCoinLessThanOrEqualTo(String value) {
            addCriterion("free_coin <=", value, "freeCoin");
            return (Criteria) this;
        }

        public Criteria andFreeCoinLike(String value) {
            addCriterion("free_coin like", value, "freeCoin");
            return (Criteria) this;
        }

        public Criteria andFreeCoinNotLike(String value) {
            addCriterion("free_coin not like", value, "freeCoin");
            return (Criteria) this;
        }

        public Criteria andFreeCoinIn(List<String> values) {
            addCriterion("free_coin in", values, "freeCoin");
            return (Criteria) this;
        }

        public Criteria andFreeCoinNotIn(List<String> values) {
            addCriterion("free_coin not in", values, "freeCoin");
            return (Criteria) this;
        }

        public Criteria andFreeCoinBetween(String value1, String value2) {
            addCriterion("free_coin between", value1, value2, "freeCoin");
            return (Criteria) this;
        }

        public Criteria andFreeCoinNotBetween(String value1, String value2) {
            addCriterion("free_coin not between", value1, value2, "freeCoin");
            return (Criteria) this;
        }

        public Criteria andIsFirstLoginIsNull() {
            addCriterion("is_first_login is null");
            return (Criteria) this;
        }

        public Criteria andIsFirstLoginIsNotNull() {
            addCriterion("is_first_login is not null");
            return (Criteria) this;
        }

        public Criteria andIsFirstLoginEqualTo(String value) {
            addCriterion("is_first_login =", value, "isFirstLogin");
            return (Criteria) this;
        }

        public Criteria andIsFirstLoginNotEqualTo(String value) {
            addCriterion("is_first_login <>", value, "isFirstLogin");
            return (Criteria) this;
        }

        public Criteria andIsFirstLoginGreaterThan(String value) {
            addCriterion("is_first_login >", value, "isFirstLogin");
            return (Criteria) this;
        }

        public Criteria andIsFirstLoginGreaterThanOrEqualTo(String value) {
            addCriterion("is_first_login >=", value, "isFirstLogin");
            return (Criteria) this;
        }

        public Criteria andIsFirstLoginLessThan(String value) {
            addCriterion("is_first_login <", value, "isFirstLogin");
            return (Criteria) this;
        }

        public Criteria andIsFirstLoginLessThanOrEqualTo(String value) {
            addCriterion("is_first_login <=", value, "isFirstLogin");
            return (Criteria) this;
        }

        public Criteria andIsFirstLoginLike(String value) {
            addCriterion("is_first_login like", value, "isFirstLogin");
            return (Criteria) this;
        }

        public Criteria andIsFirstLoginNotLike(String value) {
            addCriterion("is_first_login not like", value, "isFirstLogin");
            return (Criteria) this;
        }

        public Criteria andIsFirstLoginIn(List<String> values) {
            addCriterion("is_first_login in", values, "isFirstLogin");
            return (Criteria) this;
        }

        public Criteria andIsFirstLoginNotIn(List<String> values) {
            addCriterion("is_first_login not in", values, "isFirstLogin");
            return (Criteria) this;
        }

        public Criteria andIsFirstLoginBetween(String value1, String value2) {
            addCriterion("is_first_login between", value1, value2, "isFirstLogin");
            return (Criteria) this;
        }

        public Criteria andIsFirstLoginNotBetween(String value1, String value2) {
            addCriterion("is_first_login not between", value1, value2, "isFirstLogin");
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

        public Criteria andBonusNumIsNull() {
            addCriterion("bonus_num is null");
            return (Criteria) this;
        }

        public Criteria andBonusNumIsNotNull() {
            addCriterion("bonus_num is not null");
            return (Criteria) this;
        }

        public Criteria andBonusNumEqualTo(String value) {
            addCriterion("bonus_num =", value, "bonusNum");
            return (Criteria) this;
        }

        public Criteria andBonusNumNotEqualTo(String value) {
            addCriterion("bonus_num <>", value, "bonusNum");
            return (Criteria) this;
        }

        public Criteria andBonusNumGreaterThan(String value) {
            addCriterion("bonus_num >", value, "bonusNum");
            return (Criteria) this;
        }

        public Criteria andBonusNumGreaterThanOrEqualTo(String value) {
            addCriterion("bonus_num >=", value, "bonusNum");
            return (Criteria) this;
        }

        public Criteria andBonusNumLessThan(String value) {
            addCriterion("bonus_num <", value, "bonusNum");
            return (Criteria) this;
        }

        public Criteria andBonusNumLessThanOrEqualTo(String value) {
            addCriterion("bonus_num <=", value, "bonusNum");
            return (Criteria) this;
        }

        public Criteria andBonusNumLike(String value) {
            addCriterion("bonus_num like", value, "bonusNum");
            return (Criteria) this;
        }

        public Criteria andBonusNumNotLike(String value) {
            addCriterion("bonus_num not like", value, "bonusNum");
            return (Criteria) this;
        }

        public Criteria andBonusNumIn(List<String> values) {
            addCriterion("bonus_num in", values, "bonusNum");
            return (Criteria) this;
        }

        public Criteria andBonusNumNotIn(List<String> values) {
            addCriterion("bonus_num not in", values, "bonusNum");
            return (Criteria) this;
        }

        public Criteria andBonusNumBetween(String value1, String value2) {
            addCriterion("bonus_num between", value1, value2, "bonusNum");
            return (Criteria) this;
        }

        public Criteria andBonusNumNotBetween(String value1, String value2) {
            addCriterion("bonus_num not between", value1, value2, "bonusNum");
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