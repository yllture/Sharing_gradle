package com.neuedu.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class Garbage_bankfolderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Garbage_bankfolderExample() {
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

        public Criteria andFolderidIsNull() {
            addCriterion("folderid is null");
            return (Criteria) this;
        }

        public Criteria andFolderidIsNotNull() {
            addCriterion("folderid is not null");
            return (Criteria) this;
        }

        public Criteria andFolderidEqualTo(Integer value) {
            addCriterion("folderid =", value, "folderid");
            return (Criteria) this;
        }

        public Criteria andFolderidNotEqualTo(Integer value) {
            addCriterion("folderid <>", value, "folderid");
            return (Criteria) this;
        }

        public Criteria andFolderidGreaterThan(Integer value) {
            addCriterion("folderid >", value, "folderid");
            return (Criteria) this;
        }

        public Criteria andFolderidGreaterThanOrEqualTo(Integer value) {
            addCriterion("folderid >=", value, "folderid");
            return (Criteria) this;
        }

        public Criteria andFolderidLessThan(Integer value) {
            addCriterion("folderid <", value, "folderid");
            return (Criteria) this;
        }

        public Criteria andFolderidLessThanOrEqualTo(Integer value) {
            addCriterion("folderid <=", value, "folderid");
            return (Criteria) this;
        }

        public Criteria andFolderidIn(List<Integer> values) {
            addCriterion("folderid in", values, "folderid");
            return (Criteria) this;
        }

        public Criteria andFolderidNotIn(List<Integer> values) {
            addCriterion("folderid not in", values, "folderid");
            return (Criteria) this;
        }

        public Criteria andFolderidBetween(Integer value1, Integer value2) {
            addCriterion("folderid between", value1, value2, "folderid");
            return (Criteria) this;
        }

        public Criteria andFolderidNotBetween(Integer value1, Integer value2) {
            addCriterion("folderid not between", value1, value2, "folderid");
            return (Criteria) this;
        }

        public Criteria andFoldernameIsNull() {
            addCriterion("foldername is null");
            return (Criteria) this;
        }

        public Criteria andFoldernameIsNotNull() {
            addCriterion("foldername is not null");
            return (Criteria) this;
        }

        public Criteria andFoldernameEqualTo(String value) {
            addCriterion("foldername =", value, "foldername");
            return (Criteria) this;
        }

        public Criteria andFoldernameNotEqualTo(String value) {
            addCriterion("foldername <>", value, "foldername");
            return (Criteria) this;
        }

        public Criteria andFoldernameGreaterThan(String value) {
            addCriterion("foldername >", value, "foldername");
            return (Criteria) this;
        }

        public Criteria andFoldernameGreaterThanOrEqualTo(String value) {
            addCriterion("foldername >=", value, "foldername");
            return (Criteria) this;
        }

        public Criteria andFoldernameLessThan(String value) {
            addCriterion("foldername <", value, "foldername");
            return (Criteria) this;
        }

        public Criteria andFoldernameLessThanOrEqualTo(String value) {
            addCriterion("foldername <=", value, "foldername");
            return (Criteria) this;
        }

        public Criteria andFoldernameLike(String value) {
            addCriterion("foldername like", value, "foldername");
            return (Criteria) this;
        }

        public Criteria andFoldernameNotLike(String value) {
            addCriterion("foldername not like", value, "foldername");
            return (Criteria) this;
        }

        public Criteria andFoldernameIn(List<String> values) {
            addCriterion("foldername in", values, "foldername");
            return (Criteria) this;
        }

        public Criteria andFoldernameNotIn(List<String> values) {
            addCriterion("foldername not in", values, "foldername");
            return (Criteria) this;
        }

        public Criteria andFoldernameBetween(String value1, String value2) {
            addCriterion("foldername between", value1, value2, "foldername");
            return (Criteria) this;
        }

        public Criteria andFoldernameNotBetween(String value1, String value2) {
            addCriterion("foldername not between", value1, value2, "foldername");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andBanknumIsNull() {
            addCriterion("banknum is null");
            return (Criteria) this;
        }

        public Criteria andBanknumIsNotNull() {
            addCriterion("banknum is not null");
            return (Criteria) this;
        }

        public Criteria andBanknumEqualTo(Integer value) {
            addCriterion("banknum =", value, "banknum");
            return (Criteria) this;
        }

        public Criteria andBanknumNotEqualTo(Integer value) {
            addCriterion("banknum <>", value, "banknum");
            return (Criteria) this;
        }

        public Criteria andBanknumGreaterThan(Integer value) {
            addCriterion("banknum >", value, "banknum");
            return (Criteria) this;
        }

        public Criteria andBanknumGreaterThanOrEqualTo(Integer value) {
            addCriterion("banknum >=", value, "banknum");
            return (Criteria) this;
        }

        public Criteria andBanknumLessThan(Integer value) {
            addCriterion("banknum <", value, "banknum");
            return (Criteria) this;
        }

        public Criteria andBanknumLessThanOrEqualTo(Integer value) {
            addCriterion("banknum <=", value, "banknum");
            return (Criteria) this;
        }

        public Criteria andBanknumIn(List<Integer> values) {
            addCriterion("banknum in", values, "banknum");
            return (Criteria) this;
        }

        public Criteria andBanknumNotIn(List<Integer> values) {
            addCriterion("banknum not in", values, "banknum");
            return (Criteria) this;
        }

        public Criteria andBanknumBetween(Integer value1, Integer value2) {
            addCriterion("banknum between", value1, value2, "banknum");
            return (Criteria) this;
        }

        public Criteria andBanknumNotBetween(Integer value1, Integer value2) {
            addCriterion("banknum not between", value1, value2, "banknum");
            return (Criteria) this;
        }

        public Criteria andFoldermappingIsNull() {
            addCriterion("foldermapping is null");
            return (Criteria) this;
        }

        public Criteria andFoldermappingIsNotNull() {
            addCriterion("foldermapping is not null");
            return (Criteria) this;
        }

        public Criteria andFoldermappingEqualTo(Integer value) {
            addCriterion("foldermapping =", value, "foldermapping");
            return (Criteria) this;
        }

        public Criteria andFoldermappingNotEqualTo(Integer value) {
            addCriterion("foldermapping <>", value, "foldermapping");
            return (Criteria) this;
        }

        public Criteria andFoldermappingGreaterThan(Integer value) {
            addCriterion("foldermapping >", value, "foldermapping");
            return (Criteria) this;
        }

        public Criteria andFoldermappingGreaterThanOrEqualTo(Integer value) {
            addCriterion("foldermapping >=", value, "foldermapping");
            return (Criteria) this;
        }

        public Criteria andFoldermappingLessThan(Integer value) {
            addCriterion("foldermapping <", value, "foldermapping");
            return (Criteria) this;
        }

        public Criteria andFoldermappingLessThanOrEqualTo(Integer value) {
            addCriterion("foldermapping <=", value, "foldermapping");
            return (Criteria) this;
        }

        public Criteria andFoldermappingIn(List<Integer> values) {
            addCriterion("foldermapping in", values, "foldermapping");
            return (Criteria) this;
        }

        public Criteria andFoldermappingNotIn(List<Integer> values) {
            addCriterion("foldermapping not in", values, "foldermapping");
            return (Criteria) this;
        }

        public Criteria andFoldermappingBetween(Integer value1, Integer value2) {
            addCriterion("foldermapping between", value1, value2, "foldermapping");
            return (Criteria) this;
        }

        public Criteria andFoldermappingNotBetween(Integer value1, Integer value2) {
            addCriterion("foldermapping not between", value1, value2, "foldermapping");
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

        public Criteria andC1EqualTo(String value) {
            addCriterion("c1 =", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1NotEqualTo(String value) {
            addCriterion("c1 <>", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1GreaterThan(String value) {
            addCriterion("c1 >", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1GreaterThanOrEqualTo(String value) {
            addCriterion("c1 >=", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1LessThan(String value) {
            addCriterion("c1 <", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1LessThanOrEqualTo(String value) {
            addCriterion("c1 <=", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1Like(String value) {
            addCriterion("c1 like", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1NotLike(String value) {
            addCriterion("c1 not like", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1In(List<String> values) {
            addCriterion("c1 in", values, "c1");
            return (Criteria) this;
        }

        public Criteria andC1NotIn(List<String> values) {
            addCriterion("c1 not in", values, "c1");
            return (Criteria) this;
        }

        public Criteria andC1Between(String value1, String value2) {
            addCriterion("c1 between", value1, value2, "c1");
            return (Criteria) this;
        }

        public Criteria andC1NotBetween(String value1, String value2) {
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

        public Criteria andC2EqualTo(String value) {
            addCriterion("c2 =", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2NotEqualTo(String value) {
            addCriterion("c2 <>", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2GreaterThan(String value) {
            addCriterion("c2 >", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2GreaterThanOrEqualTo(String value) {
            addCriterion("c2 >=", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2LessThan(String value) {
            addCriterion("c2 <", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2LessThanOrEqualTo(String value) {
            addCriterion("c2 <=", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2Like(String value) {
            addCriterion("c2 like", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2NotLike(String value) {
            addCriterion("c2 not like", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2In(List<String> values) {
            addCriterion("c2 in", values, "c2");
            return (Criteria) this;
        }

        public Criteria andC2NotIn(List<String> values) {
            addCriterion("c2 not in", values, "c2");
            return (Criteria) this;
        }

        public Criteria andC2Between(String value1, String value2) {
            addCriterion("c2 between", value1, value2, "c2");
            return (Criteria) this;
        }

        public Criteria andC2NotBetween(String value1, String value2) {
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

        public Criteria andC3EqualTo(Integer value) {
            addCriterion("c3 =", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3NotEqualTo(Integer value) {
            addCriterion("c3 <>", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3GreaterThan(Integer value) {
            addCriterion("c3 >", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3GreaterThanOrEqualTo(Integer value) {
            addCriterion("c3 >=", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3LessThan(Integer value) {
            addCriterion("c3 <", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3LessThanOrEqualTo(Integer value) {
            addCriterion("c3 <=", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3In(List<Integer> values) {
            addCriterion("c3 in", values, "c3");
            return (Criteria) this;
        }

        public Criteria andC3NotIn(List<Integer> values) {
            addCriterion("c3 not in", values, "c3");
            return (Criteria) this;
        }

        public Criteria andC3Between(Integer value1, Integer value2) {
            addCriterion("c3 between", value1, value2, "c3");
            return (Criteria) this;
        }

        public Criteria andC3NotBetween(Integer value1, Integer value2) {
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

        public Criteria andC4EqualTo(Integer value) {
            addCriterion("c4 =", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4NotEqualTo(Integer value) {
            addCriterion("c4 <>", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4GreaterThan(Integer value) {
            addCriterion("c4 >", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4GreaterThanOrEqualTo(Integer value) {
            addCriterion("c4 >=", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4LessThan(Integer value) {
            addCriterion("c4 <", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4LessThanOrEqualTo(Integer value) {
            addCriterion("c4 <=", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4In(List<Integer> values) {
            addCriterion("c4 in", values, "c4");
            return (Criteria) this;
        }

        public Criteria andC4NotIn(List<Integer> values) {
            addCriterion("c4 not in", values, "c4");
            return (Criteria) this;
        }

        public Criteria andC4Between(Integer value1, Integer value2) {
            addCriterion("c4 between", value1, value2, "c4");
            return (Criteria) this;
        }

        public Criteria andC4NotBetween(Integer value1, Integer value2) {
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