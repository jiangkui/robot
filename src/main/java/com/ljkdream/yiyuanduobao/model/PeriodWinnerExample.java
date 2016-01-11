package com.ljkdream.yiyuanduobao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PeriodWinnerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PeriodWinnerExample() {
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

        public Criteria andPeriodIsNull() {
            addCriterion("period is null");
            return (Criteria) this;
        }

        public Criteria andPeriodIsNotNull() {
            addCriterion("period is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodEqualTo(Long value) {
            addCriterion("period =", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotEqualTo(Long value) {
            addCriterion("period <>", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodGreaterThan(Long value) {
            addCriterion("period >", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodGreaterThanOrEqualTo(Long value) {
            addCriterion("period >=", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodLessThan(Long value) {
            addCriterion("period <", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodLessThanOrEqualTo(Long value) {
            addCriterion("period <=", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodIn(List<Long> values) {
            addCriterion("period in", values, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotIn(List<Long> values) {
            addCriterion("period not in", values, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodBetween(Long value1, Long value2) {
            addCriterion("period between", value1, value2, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotBetween(Long value1, Long value2) {
            addCriterion("period not between", value1, value2, "period");
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

        public Criteria andOwnerCostIsNull() {
            addCriterion("owner_cost is null");
            return (Criteria) this;
        }

        public Criteria andOwnerCostIsNotNull() {
            addCriterion("owner_cost is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerCostEqualTo(String value) {
            addCriterion("owner_cost =", value, "ownerCost");
            return (Criteria) this;
        }

        public Criteria andOwnerCostNotEqualTo(String value) {
            addCriterion("owner_cost <>", value, "ownerCost");
            return (Criteria) this;
        }

        public Criteria andOwnerCostGreaterThan(String value) {
            addCriterion("owner_cost >", value, "ownerCost");
            return (Criteria) this;
        }

        public Criteria andOwnerCostGreaterThanOrEqualTo(String value) {
            addCriterion("owner_cost >=", value, "ownerCost");
            return (Criteria) this;
        }

        public Criteria andOwnerCostLessThan(String value) {
            addCriterion("owner_cost <", value, "ownerCost");
            return (Criteria) this;
        }

        public Criteria andOwnerCostLessThanOrEqualTo(String value) {
            addCriterion("owner_cost <=", value, "ownerCost");
            return (Criteria) this;
        }

        public Criteria andOwnerCostLike(String value) {
            addCriterion("owner_cost like", value, "ownerCost");
            return (Criteria) this;
        }

        public Criteria andOwnerCostNotLike(String value) {
            addCriterion("owner_cost not like", value, "ownerCost");
            return (Criteria) this;
        }

        public Criteria andOwnerCostIn(List<String> values) {
            addCriterion("owner_cost in", values, "ownerCost");
            return (Criteria) this;
        }

        public Criteria andOwnerCostNotIn(List<String> values) {
            addCriterion("owner_cost not in", values, "ownerCost");
            return (Criteria) this;
        }

        public Criteria andOwnerCostBetween(String value1, String value2) {
            addCriterion("owner_cost between", value1, value2, "ownerCost");
            return (Criteria) this;
        }

        public Criteria andOwnerCostNotBetween(String value1, String value2) {
            addCriterion("owner_cost not between", value1, value2, "ownerCost");
            return (Criteria) this;
        }

        public Criteria andLuckyCodeIsNull() {
            addCriterion("lucky_code is null");
            return (Criteria) this;
        }

        public Criteria andLuckyCodeIsNotNull() {
            addCriterion("lucky_code is not null");
            return (Criteria) this;
        }

        public Criteria andLuckyCodeEqualTo(String value) {
            addCriterion("lucky_code =", value, "luckyCode");
            return (Criteria) this;
        }

        public Criteria andLuckyCodeNotEqualTo(String value) {
            addCriterion("lucky_code <>", value, "luckyCode");
            return (Criteria) this;
        }

        public Criteria andLuckyCodeGreaterThan(String value) {
            addCriterion("lucky_code >", value, "luckyCode");
            return (Criteria) this;
        }

        public Criteria andLuckyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("lucky_code >=", value, "luckyCode");
            return (Criteria) this;
        }

        public Criteria andLuckyCodeLessThan(String value) {
            addCriterion("lucky_code <", value, "luckyCode");
            return (Criteria) this;
        }

        public Criteria andLuckyCodeLessThanOrEqualTo(String value) {
            addCriterion("lucky_code <=", value, "luckyCode");
            return (Criteria) this;
        }

        public Criteria andLuckyCodeLike(String value) {
            addCriterion("lucky_code like", value, "luckyCode");
            return (Criteria) this;
        }

        public Criteria andLuckyCodeNotLike(String value) {
            addCriterion("lucky_code not like", value, "luckyCode");
            return (Criteria) this;
        }

        public Criteria andLuckyCodeIn(List<String> values) {
            addCriterion("lucky_code in", values, "luckyCode");
            return (Criteria) this;
        }

        public Criteria andLuckyCodeNotIn(List<String> values) {
            addCriterion("lucky_code not in", values, "luckyCode");
            return (Criteria) this;
        }

        public Criteria andLuckyCodeBetween(String value1, String value2) {
            addCriterion("lucky_code between", value1, value2, "luckyCode");
            return (Criteria) this;
        }

        public Criteria andLuckyCodeNotBetween(String value1, String value2) {
            addCriterion("lucky_code not between", value1, value2, "luckyCode");
            return (Criteria) this;
        }

        public Criteria andDuobaoTimeIsNull() {
            addCriterion("duobao_time is null");
            return (Criteria) this;
        }

        public Criteria andDuobaoTimeIsNotNull() {
            addCriterion("duobao_time is not null");
            return (Criteria) this;
        }

        public Criteria andDuobaoTimeEqualTo(Date value) {
            addCriterion("duobao_time =", value, "duobaoTime");
            return (Criteria) this;
        }

        public Criteria andDuobaoTimeNotEqualTo(Date value) {
            addCriterion("duobao_time <>", value, "duobaoTime");
            return (Criteria) this;
        }

        public Criteria andDuobaoTimeGreaterThan(Date value) {
            addCriterion("duobao_time >", value, "duobaoTime");
            return (Criteria) this;
        }

        public Criteria andDuobaoTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("duobao_time >=", value, "duobaoTime");
            return (Criteria) this;
        }

        public Criteria andDuobaoTimeLessThan(Date value) {
            addCriterion("duobao_time <", value, "duobaoTime");
            return (Criteria) this;
        }

        public Criteria andDuobaoTimeLessThanOrEqualTo(Date value) {
            addCriterion("duobao_time <=", value, "duobaoTime");
            return (Criteria) this;
        }

        public Criteria andDuobaoTimeIn(List<Date> values) {
            addCriterion("duobao_time in", values, "duobaoTime");
            return (Criteria) this;
        }

        public Criteria andDuobaoTimeNotIn(List<Date> values) {
            addCriterion("duobao_time not in", values, "duobaoTime");
            return (Criteria) this;
        }

        public Criteria andDuobaoTimeBetween(Date value1, Date value2) {
            addCriterion("duobao_time between", value1, value2, "duobaoTime");
            return (Criteria) this;
        }

        public Criteria andDuobaoTimeNotBetween(Date value1, Date value2) {
            addCriterion("duobao_time not between", value1, value2, "duobaoTime");
            return (Criteria) this;
        }

        public Criteria andCalcTimeIsNull() {
            addCriterion("calc_time is null");
            return (Criteria) this;
        }

        public Criteria andCalcTimeIsNotNull() {
            addCriterion("calc_time is not null");
            return (Criteria) this;
        }

        public Criteria andCalcTimeEqualTo(Date value) {
            addCriterion("calc_time =", value, "calcTime");
            return (Criteria) this;
        }

        public Criteria andCalcTimeNotEqualTo(Date value) {
            addCriterion("calc_time <>", value, "calcTime");
            return (Criteria) this;
        }

        public Criteria andCalcTimeGreaterThan(Date value) {
            addCriterion("calc_time >", value, "calcTime");
            return (Criteria) this;
        }

        public Criteria andCalcTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("calc_time >=", value, "calcTime");
            return (Criteria) this;
        }

        public Criteria andCalcTimeLessThan(Date value) {
            addCriterion("calc_time <", value, "calcTime");
            return (Criteria) this;
        }

        public Criteria andCalcTimeLessThanOrEqualTo(Date value) {
            addCriterion("calc_time <=", value, "calcTime");
            return (Criteria) this;
        }

        public Criteria andCalcTimeIn(List<Date> values) {
            addCriterion("calc_time in", values, "calcTime");
            return (Criteria) this;
        }

        public Criteria andCalcTimeNotIn(List<Date> values) {
            addCriterion("calc_time not in", values, "calcTime");
            return (Criteria) this;
        }

        public Criteria andCalcTimeBetween(Date value1, Date value2) {
            addCriterion("calc_time between", value1, value2, "calcTime");
            return (Criteria) this;
        }

        public Criteria andCalcTimeNotBetween(Date value1, Date value2) {
            addCriterion("calc_time not between", value1, value2, "calcTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCostIsNull() {
            addCriterion("cost is null");
            return (Criteria) this;
        }

        public Criteria andCostIsNotNull() {
            addCriterion("cost is not null");
            return (Criteria) this;
        }

        public Criteria andCostEqualTo(String value) {
            addCriterion("cost =", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotEqualTo(String value) {
            addCriterion("cost <>", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThan(String value) {
            addCriterion("cost >", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThanOrEqualTo(String value) {
            addCriterion("cost >=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThan(String value) {
            addCriterion("cost <", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThanOrEqualTo(String value) {
            addCriterion("cost <=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLike(String value) {
            addCriterion("cost like", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotLike(String value) {
            addCriterion("cost not like", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostIn(List<String> values) {
            addCriterion("cost in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotIn(List<String> values) {
            addCriterion("cost not in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostBetween(String value1, String value2) {
            addCriterion("cost between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotBetween(String value1, String value2) {
            addCriterion("cost not between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andDuobaoTimeStrIsNull() {
            addCriterion("duobao_time_str is null");
            return (Criteria) this;
        }

        public Criteria andDuobaoTimeStrIsNotNull() {
            addCriterion("duobao_time_str is not null");
            return (Criteria) this;
        }

        public Criteria andDuobaoTimeStrEqualTo(String value) {
            addCriterion("duobao_time_str =", value, "duobaoTimeStr");
            return (Criteria) this;
        }

        public Criteria andDuobaoTimeStrNotEqualTo(String value) {
            addCriterion("duobao_time_str <>", value, "duobaoTimeStr");
            return (Criteria) this;
        }

        public Criteria andDuobaoTimeStrGreaterThan(String value) {
            addCriterion("duobao_time_str >", value, "duobaoTimeStr");
            return (Criteria) this;
        }

        public Criteria andDuobaoTimeStrGreaterThanOrEqualTo(String value) {
            addCriterion("duobao_time_str >=", value, "duobaoTimeStr");
            return (Criteria) this;
        }

        public Criteria andDuobaoTimeStrLessThan(String value) {
            addCriterion("duobao_time_str <", value, "duobaoTimeStr");
            return (Criteria) this;
        }

        public Criteria andDuobaoTimeStrLessThanOrEqualTo(String value) {
            addCriterion("duobao_time_str <=", value, "duobaoTimeStr");
            return (Criteria) this;
        }

        public Criteria andDuobaoTimeStrLike(String value) {
            addCriterion("duobao_time_str like", value, "duobaoTimeStr");
            return (Criteria) this;
        }

        public Criteria andDuobaoTimeStrNotLike(String value) {
            addCriterion("duobao_time_str not like", value, "duobaoTimeStr");
            return (Criteria) this;
        }

        public Criteria andDuobaoTimeStrIn(List<String> values) {
            addCriterion("duobao_time_str in", values, "duobaoTimeStr");
            return (Criteria) this;
        }

        public Criteria andDuobaoTimeStrNotIn(List<String> values) {
            addCriterion("duobao_time_str not in", values, "duobaoTimeStr");
            return (Criteria) this;
        }

        public Criteria andDuobaoTimeStrBetween(String value1, String value2) {
            addCriterion("duobao_time_str between", value1, value2, "duobaoTimeStr");
            return (Criteria) this;
        }

        public Criteria andDuobaoTimeStrNotBetween(String value1, String value2) {
            addCriterion("duobao_time_str not between", value1, value2, "duobaoTimeStr");
            return (Criteria) this;
        }

        public Criteria andCalcTimeStrIsNull() {
            addCriterion("calc_time_str is null");
            return (Criteria) this;
        }

        public Criteria andCalcTimeStrIsNotNull() {
            addCriterion("calc_time_str is not null");
            return (Criteria) this;
        }

        public Criteria andCalcTimeStrEqualTo(String value) {
            addCriterion("calc_time_str =", value, "calcTimeStr");
            return (Criteria) this;
        }

        public Criteria andCalcTimeStrNotEqualTo(String value) {
            addCriterion("calc_time_str <>", value, "calcTimeStr");
            return (Criteria) this;
        }

        public Criteria andCalcTimeStrGreaterThan(String value) {
            addCriterion("calc_time_str >", value, "calcTimeStr");
            return (Criteria) this;
        }

        public Criteria andCalcTimeStrGreaterThanOrEqualTo(String value) {
            addCriterion("calc_time_str >=", value, "calcTimeStr");
            return (Criteria) this;
        }

        public Criteria andCalcTimeStrLessThan(String value) {
            addCriterion("calc_time_str <", value, "calcTimeStr");
            return (Criteria) this;
        }

        public Criteria andCalcTimeStrLessThanOrEqualTo(String value) {
            addCriterion("calc_time_str <=", value, "calcTimeStr");
            return (Criteria) this;
        }

        public Criteria andCalcTimeStrLike(String value) {
            addCriterion("calc_time_str like", value, "calcTimeStr");
            return (Criteria) this;
        }

        public Criteria andCalcTimeStrNotLike(String value) {
            addCriterion("calc_time_str not like", value, "calcTimeStr");
            return (Criteria) this;
        }

        public Criteria andCalcTimeStrIn(List<String> values) {
            addCriterion("calc_time_str in", values, "calcTimeStr");
            return (Criteria) this;
        }

        public Criteria andCalcTimeStrNotIn(List<String> values) {
            addCriterion("calc_time_str not in", values, "calcTimeStr");
            return (Criteria) this;
        }

        public Criteria andCalcTimeStrBetween(String value1, String value2) {
            addCriterion("calc_time_str between", value1, value2, "calcTimeStr");
            return (Criteria) this;
        }

        public Criteria andCalcTimeStrNotBetween(String value1, String value2) {
            addCriterion("calc_time_str not between", value1, value2, "calcTimeStr");
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