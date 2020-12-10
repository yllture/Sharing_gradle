package com.neuedu.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Bank_multipleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Bank_multipleExample() {
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

        public Criteria andQIdIsNull() {
            addCriterion("Q_id is null");
            return (Criteria) this;
        }

        public Criteria andQIdIsNotNull() {
            addCriterion("Q_id is not null");
            return (Criteria) this;
        }

        public Criteria andQIdEqualTo(Integer value) {
            addCriterion("Q_id =", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdNotEqualTo(Integer value) {
            addCriterion("Q_id <>", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdGreaterThan(Integer value) {
            addCriterion("Q_id >", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Q_id >=", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdLessThan(Integer value) {
            addCriterion("Q_id <", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdLessThanOrEqualTo(Integer value) {
            addCriterion("Q_id <=", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdIn(List<Integer> values) {
            addCriterion("Q_id in", values, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdNotIn(List<Integer> values) {
            addCriterion("Q_id not in", values, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdBetween(Integer value1, Integer value2) {
            addCriterion("Q_id between", value1, value2, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Q_id not between", value1, value2, "qId");
            return (Criteria) this;
        }

        public Criteria andQTitleIsNull() {
            addCriterion("Q_title is null");
            return (Criteria) this;
        }

        public Criteria andQTitleIsNotNull() {
            addCriterion("Q_title is not null");
            return (Criteria) this;
        }

        public Criteria andQTitleEqualTo(String value) {
            addCriterion("Q_title =", value, "qTitle");
            return (Criteria) this;
        }

        public Criteria andQTitleNotEqualTo(String value) {
            addCriterion("Q_title <>", value, "qTitle");
            return (Criteria) this;
        }

        public Criteria andQTitleGreaterThan(String value) {
            addCriterion("Q_title >", value, "qTitle");
            return (Criteria) this;
        }

        public Criteria andQTitleGreaterThanOrEqualTo(String value) {
            addCriterion("Q_title >=", value, "qTitle");
            return (Criteria) this;
        }

        public Criteria andQTitleLessThan(String value) {
            addCriterion("Q_title <", value, "qTitle");
            return (Criteria) this;
        }

        public Criteria andQTitleLessThanOrEqualTo(String value) {
            addCriterion("Q_title <=", value, "qTitle");
            return (Criteria) this;
        }

        public Criteria andQTitleLike(String value) {
            addCriterion("Q_title like", value, "qTitle");
            return (Criteria) this;
        }

        public Criteria andQTitleNotLike(String value) {
            addCriterion("Q_title not like", value, "qTitle");
            return (Criteria) this;
        }

        public Criteria andQTitleIn(List<String> values) {
            addCriterion("Q_title in", values, "qTitle");
            return (Criteria) this;
        }

        public Criteria andQTitleNotIn(List<String> values) {
            addCriterion("Q_title not in", values, "qTitle");
            return (Criteria) this;
        }

        public Criteria andQTitleBetween(String value1, String value2) {
            addCriterion("Q_title between", value1, value2, "qTitle");
            return (Criteria) this;
        }

        public Criteria andQTitleNotBetween(String value1, String value2) {
            addCriterion("Q_title not between", value1, value2, "qTitle");
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

        public Criteria andQKnowledgeIsNull() {
            addCriterion("Q_knowledge is null");
            return (Criteria) this;
        }

        public Criteria andQKnowledgeIsNotNull() {
            addCriterion("Q_knowledge is not null");
            return (Criteria) this;
        }

        public Criteria andQKnowledgeEqualTo(String value) {
            addCriterion("Q_knowledge =", value, "qKnowledge");
            return (Criteria) this;
        }

        public Criteria andQKnowledgeNotEqualTo(String value) {
            addCriterion("Q_knowledge <>", value, "qKnowledge");
            return (Criteria) this;
        }

        public Criteria andQKnowledgeGreaterThan(String value) {
            addCriterion("Q_knowledge >", value, "qKnowledge");
            return (Criteria) this;
        }

        public Criteria andQKnowledgeGreaterThanOrEqualTo(String value) {
            addCriterion("Q_knowledge >=", value, "qKnowledge");
            return (Criteria) this;
        }

        public Criteria andQKnowledgeLessThan(String value) {
            addCriterion("Q_knowledge <", value, "qKnowledge");
            return (Criteria) this;
        }

        public Criteria andQKnowledgeLessThanOrEqualTo(String value) {
            addCriterion("Q_knowledge <=", value, "qKnowledge");
            return (Criteria) this;
        }

        public Criteria andQKnowledgeLike(String value) {
            addCriterion("Q_knowledge like", value, "qKnowledge");
            return (Criteria) this;
        }

        public Criteria andQKnowledgeNotLike(String value) {
            addCriterion("Q_knowledge not like", value, "qKnowledge");
            return (Criteria) this;
        }

        public Criteria andQKnowledgeIn(List<String> values) {
            addCriterion("Q_knowledge in", values, "qKnowledge");
            return (Criteria) this;
        }

        public Criteria andQKnowledgeNotIn(List<String> values) {
            addCriterion("Q_knowledge not in", values, "qKnowledge");
            return (Criteria) this;
        }

        public Criteria andQKnowledgeBetween(String value1, String value2) {
            addCriterion("Q_knowledge between", value1, value2, "qKnowledge");
            return (Criteria) this;
        }

        public Criteria andQKnowledgeNotBetween(String value1, String value2) {
            addCriterion("Q_knowledge not between", value1, value2, "qKnowledge");
            return (Criteria) this;
        }

        public Criteria andQAnalysisIsNull() {
            addCriterion("Q_analysis is null");
            return (Criteria) this;
        }

        public Criteria andQAnalysisIsNotNull() {
            addCriterion("Q_analysis is not null");
            return (Criteria) this;
        }

        public Criteria andQAnalysisEqualTo(String value) {
            addCriterion("Q_analysis =", value, "qAnalysis");
            return (Criteria) this;
        }

        public Criteria andQAnalysisNotEqualTo(String value) {
            addCriterion("Q_analysis <>", value, "qAnalysis");
            return (Criteria) this;
        }

        public Criteria andQAnalysisGreaterThan(String value) {
            addCriterion("Q_analysis >", value, "qAnalysis");
            return (Criteria) this;
        }

        public Criteria andQAnalysisGreaterThanOrEqualTo(String value) {
            addCriterion("Q_analysis >=", value, "qAnalysis");
            return (Criteria) this;
        }

        public Criteria andQAnalysisLessThan(String value) {
            addCriterion("Q_analysis <", value, "qAnalysis");
            return (Criteria) this;
        }

        public Criteria andQAnalysisLessThanOrEqualTo(String value) {
            addCriterion("Q_analysis <=", value, "qAnalysis");
            return (Criteria) this;
        }

        public Criteria andQAnalysisLike(String value) {
            addCriterion("Q_analysis like", value, "qAnalysis");
            return (Criteria) this;
        }

        public Criteria andQAnalysisNotLike(String value) {
            addCriterion("Q_analysis not like", value, "qAnalysis");
            return (Criteria) this;
        }

        public Criteria andQAnalysisIn(List<String> values) {
            addCriterion("Q_analysis in", values, "qAnalysis");
            return (Criteria) this;
        }

        public Criteria andQAnalysisNotIn(List<String> values) {
            addCriterion("Q_analysis not in", values, "qAnalysis");
            return (Criteria) this;
        }

        public Criteria andQAnalysisBetween(String value1, String value2) {
            addCriterion("Q_analysis between", value1, value2, "qAnalysis");
            return (Criteria) this;
        }

        public Criteria andQAnalysisNotBetween(String value1, String value2) {
            addCriterion("Q_analysis not between", value1, value2, "qAnalysis");
            return (Criteria) this;
        }

        public Criteria andQDifficultyIsNull() {
            addCriterion("Q_difficulty is null");
            return (Criteria) this;
        }

        public Criteria andQDifficultyIsNotNull() {
            addCriterion("Q_difficulty is not null");
            return (Criteria) this;
        }

        public Criteria andQDifficultyEqualTo(Integer value) {
            addCriterion("Q_difficulty =", value, "qDifficulty");
            return (Criteria) this;
        }

        public Criteria andQDifficultyNotEqualTo(Integer value) {
            addCriterion("Q_difficulty <>", value, "qDifficulty");
            return (Criteria) this;
        }

        public Criteria andQDifficultyGreaterThan(Integer value) {
            addCriterion("Q_difficulty >", value, "qDifficulty");
            return (Criteria) this;
        }

        public Criteria andQDifficultyGreaterThanOrEqualTo(Integer value) {
            addCriterion("Q_difficulty >=", value, "qDifficulty");
            return (Criteria) this;
        }

        public Criteria andQDifficultyLessThan(Integer value) {
            addCriterion("Q_difficulty <", value, "qDifficulty");
            return (Criteria) this;
        }

        public Criteria andQDifficultyLessThanOrEqualTo(Integer value) {
            addCriterion("Q_difficulty <=", value, "qDifficulty");
            return (Criteria) this;
        }

        public Criteria andQDifficultyIn(List<Integer> values) {
            addCriterion("Q_difficulty in", values, "qDifficulty");
            return (Criteria) this;
        }

        public Criteria andQDifficultyNotIn(List<Integer> values) {
            addCriterion("Q_difficulty not in", values, "qDifficulty");
            return (Criteria) this;
        }

        public Criteria andQDifficultyBetween(Integer value1, Integer value2) {
            addCriterion("Q_difficulty between", value1, value2, "qDifficulty");
            return (Criteria) this;
        }

        public Criteria andQDifficultyNotBetween(Integer value1, Integer value2) {
            addCriterion("Q_difficulty not between", value1, value2, "qDifficulty");
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