package com.ljkdream.proxy.model;

import java.util.ArrayList;
import java.util.List;

public class CountryDomainExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CountryDomainExample() {
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

        public Criteria andCountryDomainIsNull() {
            addCriterion("country_domain is null");
            return (Criteria) this;
        }

        public Criteria andCountryDomainIsNotNull() {
            addCriterion("country_domain is not null");
            return (Criteria) this;
        }

        public Criteria andCountryDomainEqualTo(String value) {
            addCriterion("country_domain =", value, "countryDomain");
            return (Criteria) this;
        }

        public Criteria andCountryDomainNotEqualTo(String value) {
            addCriterion("country_domain <>", value, "countryDomain");
            return (Criteria) this;
        }

        public Criteria andCountryDomainGreaterThan(String value) {
            addCriterion("country_domain >", value, "countryDomain");
            return (Criteria) this;
        }

        public Criteria andCountryDomainGreaterThanOrEqualTo(String value) {
            addCriterion("country_domain >=", value, "countryDomain");
            return (Criteria) this;
        }

        public Criteria andCountryDomainLessThan(String value) {
            addCriterion("country_domain <", value, "countryDomain");
            return (Criteria) this;
        }

        public Criteria andCountryDomainLessThanOrEqualTo(String value) {
            addCriterion("country_domain <=", value, "countryDomain");
            return (Criteria) this;
        }

        public Criteria andCountryDomainLike(String value) {
            addCriterion("country_domain like", value, "countryDomain");
            return (Criteria) this;
        }

        public Criteria andCountryDomainNotLike(String value) {
            addCriterion("country_domain not like", value, "countryDomain");
            return (Criteria) this;
        }

        public Criteria andCountryDomainIn(List<String> values) {
            addCriterion("country_domain in", values, "countryDomain");
            return (Criteria) this;
        }

        public Criteria andCountryDomainNotIn(List<String> values) {
            addCriterion("country_domain not in", values, "countryDomain");
            return (Criteria) this;
        }

        public Criteria andCountryDomainBetween(String value1, String value2) {
            addCriterion("country_domain between", value1, value2, "countryDomain");
            return (Criteria) this;
        }

        public Criteria andCountryDomainNotBetween(String value1, String value2) {
            addCriterion("country_domain not between", value1, value2, "countryDomain");
            return (Criteria) this;
        }

        public Criteria andCountryRegionZhIsNull() {
            addCriterion("country_region_zh is null");
            return (Criteria) this;
        }

        public Criteria andCountryRegionZhIsNotNull() {
            addCriterion("country_region_zh is not null");
            return (Criteria) this;
        }

        public Criteria andCountryRegionZhEqualTo(String value) {
            addCriterion("country_region_zh =", value, "countryRegionZh");
            return (Criteria) this;
        }

        public Criteria andCountryRegionZhNotEqualTo(String value) {
            addCriterion("country_region_zh <>", value, "countryRegionZh");
            return (Criteria) this;
        }

        public Criteria andCountryRegionZhGreaterThan(String value) {
            addCriterion("country_region_zh >", value, "countryRegionZh");
            return (Criteria) this;
        }

        public Criteria andCountryRegionZhGreaterThanOrEqualTo(String value) {
            addCriterion("country_region_zh >=", value, "countryRegionZh");
            return (Criteria) this;
        }

        public Criteria andCountryRegionZhLessThan(String value) {
            addCriterion("country_region_zh <", value, "countryRegionZh");
            return (Criteria) this;
        }

        public Criteria andCountryRegionZhLessThanOrEqualTo(String value) {
            addCriterion("country_region_zh <=", value, "countryRegionZh");
            return (Criteria) this;
        }

        public Criteria andCountryRegionZhLike(String value) {
            addCriterion("country_region_zh like", value, "countryRegionZh");
            return (Criteria) this;
        }

        public Criteria andCountryRegionZhNotLike(String value) {
            addCriterion("country_region_zh not like", value, "countryRegionZh");
            return (Criteria) this;
        }

        public Criteria andCountryRegionZhIn(List<String> values) {
            addCriterion("country_region_zh in", values, "countryRegionZh");
            return (Criteria) this;
        }

        public Criteria andCountryRegionZhNotIn(List<String> values) {
            addCriterion("country_region_zh not in", values, "countryRegionZh");
            return (Criteria) this;
        }

        public Criteria andCountryRegionZhBetween(String value1, String value2) {
            addCriterion("country_region_zh between", value1, value2, "countryRegionZh");
            return (Criteria) this;
        }

        public Criteria andCountryRegionZhNotBetween(String value1, String value2) {
            addCriterion("country_region_zh not between", value1, value2, "countryRegionZh");
            return (Criteria) this;
        }

        public Criteria andCountryRegionEnIsNull() {
            addCriterion("country_region_en is null");
            return (Criteria) this;
        }

        public Criteria andCountryRegionEnIsNotNull() {
            addCriterion("country_region_en is not null");
            return (Criteria) this;
        }

        public Criteria andCountryRegionEnEqualTo(String value) {
            addCriterion("country_region_en =", value, "countryRegionEn");
            return (Criteria) this;
        }

        public Criteria andCountryRegionEnNotEqualTo(String value) {
            addCriterion("country_region_en <>", value, "countryRegionEn");
            return (Criteria) this;
        }

        public Criteria andCountryRegionEnGreaterThan(String value) {
            addCriterion("country_region_en >", value, "countryRegionEn");
            return (Criteria) this;
        }

        public Criteria andCountryRegionEnGreaterThanOrEqualTo(String value) {
            addCriterion("country_region_en >=", value, "countryRegionEn");
            return (Criteria) this;
        }

        public Criteria andCountryRegionEnLessThan(String value) {
            addCriterion("country_region_en <", value, "countryRegionEn");
            return (Criteria) this;
        }

        public Criteria andCountryRegionEnLessThanOrEqualTo(String value) {
            addCriterion("country_region_en <=", value, "countryRegionEn");
            return (Criteria) this;
        }

        public Criteria andCountryRegionEnLike(String value) {
            addCriterion("country_region_en like", value, "countryRegionEn");
            return (Criteria) this;
        }

        public Criteria andCountryRegionEnNotLike(String value) {
            addCriterion("country_region_en not like", value, "countryRegionEn");
            return (Criteria) this;
        }

        public Criteria andCountryRegionEnIn(List<String> values) {
            addCriterion("country_region_en in", values, "countryRegionEn");
            return (Criteria) this;
        }

        public Criteria andCountryRegionEnNotIn(List<String> values) {
            addCriterion("country_region_en not in", values, "countryRegionEn");
            return (Criteria) this;
        }

        public Criteria andCountryRegionEnBetween(String value1, String value2) {
            addCriterion("country_region_en between", value1, value2, "countryRegionEn");
            return (Criteria) this;
        }

        public Criteria andCountryRegionEnNotBetween(String value1, String value2) {
            addCriterion("country_region_en not between", value1, value2, "countryRegionEn");
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