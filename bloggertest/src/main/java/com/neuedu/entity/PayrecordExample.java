package com.neuedu.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class PayrecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PayrecordExample() {
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

        public Criteria andRecordidIsNull() {
            addCriterion("recordid is null");
            return (Criteria) this;
        }

        public Criteria andRecordidIsNotNull() {
            addCriterion("recordid is not null");
            return (Criteria) this;
        }

        public Criteria andRecordidEqualTo(Integer value) {
            addCriterion("recordid =", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidNotEqualTo(Integer value) {
            addCriterion("recordid <>", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidGreaterThan(Integer value) {
            addCriterion("recordid >", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidGreaterThanOrEqualTo(Integer value) {
            addCriterion("recordid >=", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidLessThan(Integer value) {
            addCriterion("recordid <", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidLessThanOrEqualTo(Integer value) {
            addCriterion("recordid <=", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidIn(List<Integer> values) {
            addCriterion("recordid in", values, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidNotIn(List<Integer> values) {
            addCriterion("recordid not in", values, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidBetween(Integer value1, Integer value2) {
            addCriterion("recordid between", value1, value2, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidNotBetween(Integer value1, Integer value2) {
            addCriterion("recordid not between", value1, value2, "recordid");
            return (Criteria) this;
        }

        public Criteria andBuyidIsNull() {
            addCriterion("buyid is null");
            return (Criteria) this;
        }

        public Criteria andBuyidIsNotNull() {
            addCriterion("buyid is not null");
            return (Criteria) this;
        }

        public Criteria andBuyidEqualTo(Integer value) {
            addCriterion("buyid =", value, "buyid");
            return (Criteria) this;
        }

        public Criteria andBuyidNotEqualTo(Integer value) {
            addCriterion("buyid <>", value, "buyid");
            return (Criteria) this;
        }

        public Criteria andBuyidGreaterThan(Integer value) {
            addCriterion("buyid >", value, "buyid");
            return (Criteria) this;
        }

        public Criteria andBuyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("buyid >=", value, "buyid");
            return (Criteria) this;
        }

        public Criteria andBuyidLessThan(Integer value) {
            addCriterion("buyid <", value, "buyid");
            return (Criteria) this;
        }

        public Criteria andBuyidLessThanOrEqualTo(Integer value) {
            addCriterion("buyid <=", value, "buyid");
            return (Criteria) this;
        }

        public Criteria andBuyidIn(List<Integer> values) {
            addCriterion("buyid in", values, "buyid");
            return (Criteria) this;
        }

        public Criteria andBuyidNotIn(List<Integer> values) {
            addCriterion("buyid not in", values, "buyid");
            return (Criteria) this;
        }

        public Criteria andBuyidBetween(Integer value1, Integer value2) {
            addCriterion("buyid between", value1, value2, "buyid");
            return (Criteria) this;
        }

        public Criteria andBuyidNotBetween(Integer value1, Integer value2) {
            addCriterion("buyid not between", value1, value2, "buyid");
            return (Criteria) this;
        }

        public Criteria andNewpaperidIsNull() {
            addCriterion("newpaperid is null");
            return (Criteria) this;
        }

        public Criteria andNewpaperidIsNotNull() {
            addCriterion("newpaperid is not null");
            return (Criteria) this;
        }

        public Criteria andNewpaperidEqualTo(Integer value) {
            addCriterion("newpaperid =", value, "newpaperid");
            return (Criteria) this;
        }

        public Criteria andNewpaperidNotEqualTo(Integer value) {
            addCriterion("newpaperid <>", value, "newpaperid");
            return (Criteria) this;
        }

        public Criteria andNewpaperidGreaterThan(Integer value) {
            addCriterion("newpaperid >", value, "newpaperid");
            return (Criteria) this;
        }

        public Criteria andNewpaperidGreaterThanOrEqualTo(Integer value) {
            addCriterion("newpaperid >=", value, "newpaperid");
            return (Criteria) this;
        }

        public Criteria andNewpaperidLessThan(Integer value) {
            addCriterion("newpaperid <", value, "newpaperid");
            return (Criteria) this;
        }

        public Criteria andNewpaperidLessThanOrEqualTo(Integer value) {
            addCriterion("newpaperid <=", value, "newpaperid");
            return (Criteria) this;
        }

        public Criteria andNewpaperidIn(List<Integer> values) {
            addCriterion("newpaperid in", values, "newpaperid");
            return (Criteria) this;
        }

        public Criteria andNewpaperidNotIn(List<Integer> values) {
            addCriterion("newpaperid not in", values, "newpaperid");
            return (Criteria) this;
        }

        public Criteria andNewpaperidBetween(Integer value1, Integer value2) {
            addCriterion("newpaperid between", value1, value2, "newpaperid");
            return (Criteria) this;
        }

        public Criteria andNewpaperidNotBetween(Integer value1, Integer value2) {
            addCriterion("newpaperid not between", value1, value2, "newpaperid");
            return (Criteria) this;
        }

        public Criteria andNewbankidIsNull() {
            addCriterion("newbankid is null");
            return (Criteria) this;
        }

        public Criteria andNewbankidIsNotNull() {
            addCriterion("newbankid is not null");
            return (Criteria) this;
        }

        public Criteria andNewbankidEqualTo(Integer value) {
            addCriterion("newbankid =", value, "newbankid");
            return (Criteria) this;
        }

        public Criteria andNewbankidNotEqualTo(Integer value) {
            addCriterion("newbankid <>", value, "newbankid");
            return (Criteria) this;
        }

        public Criteria andNewbankidGreaterThan(Integer value) {
            addCriterion("newbankid >", value, "newbankid");
            return (Criteria) this;
        }

        public Criteria andNewbankidGreaterThanOrEqualTo(Integer value) {
            addCriterion("newbankid >=", value, "newbankid");
            return (Criteria) this;
        }

        public Criteria andNewbankidLessThan(Integer value) {
            addCriterion("newbankid <", value, "newbankid");
            return (Criteria) this;
        }

        public Criteria andNewbankidLessThanOrEqualTo(Integer value) {
            addCriterion("newbankid <=", value, "newbankid");
            return (Criteria) this;
        }

        public Criteria andNewbankidIn(List<Integer> values) {
            addCriterion("newbankid in", values, "newbankid");
            return (Criteria) this;
        }

        public Criteria andNewbankidNotIn(List<Integer> values) {
            addCriterion("newbankid not in", values, "newbankid");
            return (Criteria) this;
        }

        public Criteria andNewbankidBetween(Integer value1, Integer value2) {
            addCriterion("newbankid between", value1, value2, "newbankid");
            return (Criteria) this;
        }

        public Criteria andNewbankidNotBetween(Integer value1, Integer value2) {
            addCriterion("newbankid not between", value1, value2, "newbankid");
            return (Criteria) this;
        }

        public Criteria andPaperidIsNull() {
            addCriterion("paperid is null");
            return (Criteria) this;
        }

        public Criteria andPaperidIsNotNull() {
            addCriterion("paperid is not null");
            return (Criteria) this;
        }

        public Criteria andPaperidEqualTo(Integer value) {
            addCriterion("paperid =", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidNotEqualTo(Integer value) {
            addCriterion("paperid <>", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidGreaterThan(Integer value) {
            addCriterion("paperid >", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidGreaterThanOrEqualTo(Integer value) {
            addCriterion("paperid >=", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidLessThan(Integer value) {
            addCriterion("paperid <", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidLessThanOrEqualTo(Integer value) {
            addCriterion("paperid <=", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidIn(List<Integer> values) {
            addCriterion("paperid in", values, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidNotIn(List<Integer> values) {
            addCriterion("paperid not in", values, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidBetween(Integer value1, Integer value2) {
            addCriterion("paperid between", value1, value2, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidNotBetween(Integer value1, Integer value2) {
            addCriterion("paperid not between", value1, value2, "paperid");
            return (Criteria) this;
        }

        public Criteria andBankidIsNull() {
            addCriterion("bankid is null");
            return (Criteria) this;
        }

        public Criteria andBankidIsNotNull() {
            addCriterion("bankid is not null");
            return (Criteria) this;
        }

        public Criteria andBankidEqualTo(Integer value) {
            addCriterion("bankid =", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidNotEqualTo(Integer value) {
            addCriterion("bankid <>", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidGreaterThan(Integer value) {
            addCriterion("bankid >", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidGreaterThanOrEqualTo(Integer value) {
            addCriterion("bankid >=", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidLessThan(Integer value) {
            addCriterion("bankid <", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidLessThanOrEqualTo(Integer value) {
            addCriterion("bankid <=", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidIn(List<Integer> values) {
            addCriterion("bankid in", values, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidNotIn(List<Integer> values) {
            addCriterion("bankid not in", values, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidBetween(Integer value1, Integer value2) {
            addCriterion("bankid between", value1, value2, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidNotBetween(Integer value1, Integer value2) {
            addCriterion("bankid not between", value1, value2, "bankid");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andSolderidIsNull() {
            addCriterion("solderid is null");
            return (Criteria) this;
        }

        public Criteria andSolderidIsNotNull() {
            addCriterion("solderid is not null");
            return (Criteria) this;
        }

        public Criteria andSolderidEqualTo(Integer value) {
            addCriterion("solderid =", value, "solderid");
            return (Criteria) this;
        }

        public Criteria andSolderidNotEqualTo(Integer value) {
            addCriterion("solderid <>", value, "solderid");
            return (Criteria) this;
        }

        public Criteria andSolderidGreaterThan(Integer value) {
            addCriterion("solderid >", value, "solderid");
            return (Criteria) this;
        }

        public Criteria andSolderidGreaterThanOrEqualTo(Integer value) {
            addCriterion("solderid >=", value, "solderid");
            return (Criteria) this;
        }

        public Criteria andSolderidLessThan(Integer value) {
            addCriterion("solderid <", value, "solderid");
            return (Criteria) this;
        }

        public Criteria andSolderidLessThanOrEqualTo(Integer value) {
            addCriterion("solderid <=", value, "solderid");
            return (Criteria) this;
        }

        public Criteria andSolderidIn(List<Integer> values) {
            addCriterion("solderid in", values, "solderid");
            return (Criteria) this;
        }

        public Criteria andSolderidNotIn(List<Integer> values) {
            addCriterion("solderid not in", values, "solderid");
            return (Criteria) this;
        }

        public Criteria andSolderidBetween(Integer value1, Integer value2) {
            addCriterion("solderid between", value1, value2, "solderid");
            return (Criteria) this;
        }

        public Criteria andSolderidNotBetween(Integer value1, Integer value2) {
            addCriterion("solderid not between", value1, value2, "solderid");
            return (Criteria) this;
        }

        public Criteria andIntegralIsNull() {
            addCriterion("integral is null");
            return (Criteria) this;
        }

        public Criteria andIntegralIsNotNull() {
            addCriterion("integral is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralEqualTo(Integer value) {
            addCriterion("integral =", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotEqualTo(Integer value) {
            addCriterion("integral <>", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralGreaterThan(Integer value) {
            addCriterion("integral >", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralGreaterThanOrEqualTo(Integer value) {
            addCriterion("integral >=", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralLessThan(Integer value) {
            addCriterion("integral <", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralLessThanOrEqualTo(Integer value) {
            addCriterion("integral <=", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralIn(List<Integer> values) {
            addCriterion("integral in", values, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotIn(List<Integer> values) {
            addCriterion("integral not in", values, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralBetween(Integer value1, Integer value2) {
            addCriterion("integral between", value1, value2, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotBetween(Integer value1, Integer value2) {
            addCriterion("integral not between", value1, value2, "integral");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andCommentscoreIsNull() {
            addCriterion("commentscore is null");
            return (Criteria) this;
        }

        public Criteria andCommentscoreIsNotNull() {
            addCriterion("commentscore is not null");
            return (Criteria) this;
        }

        public Criteria andCommentscoreEqualTo(Integer value) {
            addCriterion("commentscore =", value, "commentscore");
            return (Criteria) this;
        }

        public Criteria andCommentscoreNotEqualTo(Integer value) {
            addCriterion("commentscore <>", value, "commentscore");
            return (Criteria) this;
        }

        public Criteria andCommentscoreGreaterThan(Integer value) {
            addCriterion("commentscore >", value, "commentscore");
            return (Criteria) this;
        }

        public Criteria andCommentscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("commentscore >=", value, "commentscore");
            return (Criteria) this;
        }

        public Criteria andCommentscoreLessThan(Integer value) {
            addCriterion("commentscore <", value, "commentscore");
            return (Criteria) this;
        }

        public Criteria andCommentscoreLessThanOrEqualTo(Integer value) {
            addCriterion("commentscore <=", value, "commentscore");
            return (Criteria) this;
        }

        public Criteria andCommentscoreIn(List<Integer> values) {
            addCriterion("commentscore in", values, "commentscore");
            return (Criteria) this;
        }

        public Criteria andCommentscoreNotIn(List<Integer> values) {
            addCriterion("commentscore not in", values, "commentscore");
            return (Criteria) this;
        }

        public Criteria andCommentscoreBetween(Integer value1, Integer value2) {
            addCriterion("commentscore between", value1, value2, "commentscore");
            return (Criteria) this;
        }

        public Criteria andCommentscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("commentscore not between", value1, value2, "commentscore");
            return (Criteria) this;
        }

        public Criteria andCommenttimeIsNull() {
            addCriterion("commenttime is null");
            return (Criteria) this;
        }

        public Criteria andCommenttimeIsNotNull() {
            addCriterion("commenttime is not null");
            return (Criteria) this;
        }

        public Criteria andCommenttimeEqualTo(Date value) {
            addCriterion("commenttime =", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeNotEqualTo(Date value) {
            addCriterion("commenttime <>", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeGreaterThan(Date value) {
            addCriterion("commenttime >", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("commenttime >=", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeLessThan(Date value) {
            addCriterion("commenttime <", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeLessThanOrEqualTo(Date value) {
            addCriterion("commenttime <=", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeIn(List<Date> values) {
            addCriterion("commenttime in", values, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeNotIn(List<Date> values) {
            addCriterion("commenttime not in", values, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeBetween(Date value1, Date value2) {
            addCriterion("commenttime between", value1, value2, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeNotBetween(Date value1, Date value2) {
            addCriterion("commenttime not between", value1, value2, "commenttime");
            return (Criteria) this;
        }

        public Criteria andC1IsNull() {
            addCriterion("c1 is null");
            return (Criteria) this;
        }

        public Criteria andC1IsNotNull() {
            addCriterion("c1 is not null");
            return (Criteria) this;
        }

        public Criteria andC1EqualTo(Integer value) {
            addCriterion("c1 =", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1NotEqualTo(Integer value) {
            addCriterion("c1 <>", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1GreaterThan(Integer value) {
            addCriterion("c1 >", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1GreaterThanOrEqualTo(Integer value) {
            addCriterion("c1 >=", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1LessThan(Integer value) {
            addCriterion("c1 <", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1LessThanOrEqualTo(Integer value) {
            addCriterion("c1 <=", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1In(List<Integer> values) {
            addCriterion("c1 in", values, "c1");
            return (Criteria) this;
        }

        public Criteria andC1NotIn(List<Integer> values) {
            addCriterion("c1 not in", values, "c1");
            return (Criteria) this;
        }

        public Criteria andC1Between(Integer value1, Integer value2) {
            addCriterion("c1 between", value1, value2, "c1");
            return (Criteria) this;
        }

        public Criteria andC1NotBetween(Integer value1, Integer value2) {
            addCriterion("c1 not between", value1, value2, "c1");
            return (Criteria) this;
        }

        public Criteria andC2IsNull() {
            addCriterion("c2 is null");
            return (Criteria) this;
        }

        public Criteria andC2IsNotNull() {
            addCriterion("c2 is not null");
            return (Criteria) this;
        }

        public Criteria andC2EqualTo(Integer value) {
            addCriterion("c2 =", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2NotEqualTo(Integer value) {
            addCriterion("c2 <>", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2GreaterThan(Integer value) {
            addCriterion("c2 >", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2GreaterThanOrEqualTo(Integer value) {
            addCriterion("c2 >=", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2LessThan(Integer value) {
            addCriterion("c2 <", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2LessThanOrEqualTo(Integer value) {
            addCriterion("c2 <=", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2In(List<Integer> values) {
            addCriterion("c2 in", values, "c2");
            return (Criteria) this;
        }

        public Criteria andC2NotIn(List<Integer> values) {
            addCriterion("c2 not in", values, "c2");
            return (Criteria) this;
        }

        public Criteria andC2Between(Integer value1, Integer value2) {
            addCriterion("c2 between", value1, value2, "c2");
            return (Criteria) this;
        }

        public Criteria andC2NotBetween(Integer value1, Integer value2) {
            addCriterion("c2 not between", value1, value2, "c2");
            return (Criteria) this;
        }

        public Criteria andC3IsNull() {
            addCriterion("c3 is null");
            return (Criteria) this;
        }

        public Criteria andC3IsNotNull() {
            addCriterion("c3 is not null");
            return (Criteria) this;
        }

        public Criteria andC3EqualTo(String value) {
            addCriterion("c3 =", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3NotEqualTo(String value) {
            addCriterion("c3 <>", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3GreaterThan(String value) {
            addCriterion("c3 >", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3GreaterThanOrEqualTo(String value) {
            addCriterion("c3 >=", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3LessThan(String value) {
            addCriterion("c3 <", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3LessThanOrEqualTo(String value) {
            addCriterion("c3 <=", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3Like(String value) {
            addCriterion("c3 like", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3NotLike(String value) {
            addCriterion("c3 not like", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3In(List<String> values) {
            addCriterion("c3 in", values, "c3");
            return (Criteria) this;
        }

        public Criteria andC3NotIn(List<String> values) {
            addCriterion("c3 not in", values, "c3");
            return (Criteria) this;
        }

        public Criteria andC3Between(String value1, String value2) {
            addCriterion("c3 between", value1, value2, "c3");
            return (Criteria) this;
        }

        public Criteria andC3NotBetween(String value1, String value2) {
            addCriterion("c3 not between", value1, value2, "c3");
            return (Criteria) this;
        }

        public Criteria andC4IsNull() {
            addCriterion("c4 is null");
            return (Criteria) this;
        }

        public Criteria andC4IsNotNull() {
            addCriterion("c4 is not null");
            return (Criteria) this;
        }

        public Criteria andC4EqualTo(String value) {
            addCriterion("c4 =", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4NotEqualTo(String value) {
            addCriterion("c4 <>", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4GreaterThan(String value) {
            addCriterion("c4 >", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4GreaterThanOrEqualTo(String value) {
            addCriterion("c4 >=", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4LessThan(String value) {
            addCriterion("c4 <", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4LessThanOrEqualTo(String value) {
            addCriterion("c4 <=", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4Like(String value) {
            addCriterion("c4 like", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4NotLike(String value) {
            addCriterion("c4 not like", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4In(List<String> values) {
            addCriterion("c4 in", values, "c4");
            return (Criteria) this;
        }

        public Criteria andC4NotIn(List<String> values) {
            addCriterion("c4 not in", values, "c4");
            return (Criteria) this;
        }

        public Criteria andC4Between(String value1, String value2) {
            addCriterion("c4 between", value1, value2, "c4");
            return (Criteria) this;
        }

        public Criteria andC4NotBetween(String value1, String value2) {
            addCriterion("c4 not between", value1, value2, "c4");
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