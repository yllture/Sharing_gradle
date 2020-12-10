package com.neuedu.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PaperExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PaperExample() {
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

        public Criteria andPapernameIsNull() {
            addCriterion("papername is null");
            return (Criteria) this;
        }

        public Criteria andPapernameIsNotNull() {
            addCriterion("papername is not null");
            return (Criteria) this;
        }

        public Criteria andPapernameEqualTo(String value) {
            addCriterion("papername =", value, "papername");
            return (Criteria) this;
        }

        public Criteria andPapernameNotEqualTo(String value) {
            addCriterion("papername <>", value, "papername");
            return (Criteria) this;
        }

        public Criteria andPapernameGreaterThan(String value) {
            addCriterion("papername >", value, "papername");
            return (Criteria) this;
        }

        public Criteria andPapernameGreaterThanOrEqualTo(String value) {
            addCriterion("papername >=", value, "papername");
            return (Criteria) this;
        }

        public Criteria andPapernameLessThan(String value) {
            addCriterion("papername <", value, "papername");
            return (Criteria) this;
        }

        public Criteria andPapernameLessThanOrEqualTo(String value) {
            addCriterion("papername <=", value, "papername");
            return (Criteria) this;
        }

        public Criteria andPapernameLike(String value) {
            addCriterion("papername like", value, "papername");
            return (Criteria) this;
        }

        public Criteria andPapernameNotLike(String value) {
            addCriterion("papername not like", value, "papername");
            return (Criteria) this;
        }

        public Criteria andPapernameIn(List<String> values) {
            addCriterion("papername in", values, "papername");
            return (Criteria) this;
        }

        public Criteria andPapernameNotIn(List<String> values) {
            addCriterion("papername not in", values, "papername");
            return (Criteria) this;
        }

        public Criteria andPapernameBetween(String value1, String value2) {
            addCriterion("papername between", value1, value2, "papername");
            return (Criteria) this;
        }

        public Criteria andPapernameNotBetween(String value1, String value2) {
            addCriterion("papername not between", value1, value2, "papername");
            return (Criteria) this;
        }

        public Criteria andPaperlabelIsNull() {
            addCriterion("paperlabel is null");
            return (Criteria) this;
        }

        public Criteria andPaperlabelIsNotNull() {
            addCriterion("paperlabel is not null");
            return (Criteria) this;
        }

        public Criteria andPaperlabelEqualTo(String value) {
            addCriterion("paperlabel =", value, "paperlabel");
            return (Criteria) this;
        }

        public Criteria andPaperlabelNotEqualTo(String value) {
            addCriterion("paperlabel <>", value, "paperlabel");
            return (Criteria) this;
        }

        public Criteria andPaperlabelGreaterThan(String value) {
            addCriterion("paperlabel >", value, "paperlabel");
            return (Criteria) this;
        }

        public Criteria andPaperlabelGreaterThanOrEqualTo(String value) {
            addCriterion("paperlabel >=", value, "paperlabel");
            return (Criteria) this;
        }

        public Criteria andPaperlabelLessThan(String value) {
            addCriterion("paperlabel <", value, "paperlabel");
            return (Criteria) this;
        }

        public Criteria andPaperlabelLessThanOrEqualTo(String value) {
            addCriterion("paperlabel <=", value, "paperlabel");
            return (Criteria) this;
        }

        public Criteria andPaperlabelLike(String value) {
            addCriterion("paperlabel like", value, "paperlabel");
            return (Criteria) this;
        }

        public Criteria andPaperlabelNotLike(String value) {
            addCriterion("paperlabel not like", value, "paperlabel");
            return (Criteria) this;
        }

        public Criteria andPaperlabelIn(List<String> values) {
            addCriterion("paperlabel in", values, "paperlabel");
            return (Criteria) this;
        }

        public Criteria andPaperlabelNotIn(List<String> values) {
            addCriterion("paperlabel not in", values, "paperlabel");
            return (Criteria) this;
        }

        public Criteria andPaperlabelBetween(String value1, String value2) {
            addCriterion("paperlabel between", value1, value2, "paperlabel");
            return (Criteria) this;
        }

        public Criteria andPaperlabelNotBetween(String value1, String value2) {
            addCriterion("paperlabel not between", value1, value2, "paperlabel");
            return (Criteria) this;
        }

        public Criteria andInvitationcodeIsNull() {
            addCriterion("invitationcode is null");
            return (Criteria) this;
        }

        public Criteria andInvitationcodeIsNotNull() {
            addCriterion("invitationcode is not null");
            return (Criteria) this;
        }

        public Criteria andInvitationcodeEqualTo(String value) {
            addCriterion("invitationcode =", value, "invitationcode");
            return (Criteria) this;
        }

        public Criteria andInvitationcodeNotEqualTo(String value) {
            addCriterion("invitationcode <>", value, "invitationcode");
            return (Criteria) this;
        }

        public Criteria andInvitationcodeGreaterThan(String value) {
            addCriterion("invitationcode >", value, "invitationcode");
            return (Criteria) this;
        }

        public Criteria andInvitationcodeGreaterThanOrEqualTo(String value) {
            addCriterion("invitationcode >=", value, "invitationcode");
            return (Criteria) this;
        }

        public Criteria andInvitationcodeLessThan(String value) {
            addCriterion("invitationcode <", value, "invitationcode");
            return (Criteria) this;
        }

        public Criteria andInvitationcodeLessThanOrEqualTo(String value) {
            addCriterion("invitationcode <=", value, "invitationcode");
            return (Criteria) this;
        }

        public Criteria andInvitationcodeLike(String value) {
            addCriterion("invitationcode like", value, "invitationcode");
            return (Criteria) this;
        }

        public Criteria andInvitationcodeNotLike(String value) {
            addCriterion("invitationcode not like", value, "invitationcode");
            return (Criteria) this;
        }

        public Criteria andInvitationcodeIn(List<String> values) {
            addCriterion("invitationcode in", values, "invitationcode");
            return (Criteria) this;
        }

        public Criteria andInvitationcodeNotIn(List<String> values) {
            addCriterion("invitationcode not in", values, "invitationcode");
            return (Criteria) this;
        }

        public Criteria andInvitationcodeBetween(String value1, String value2) {
            addCriterion("invitationcode between", value1, value2, "invitationcode");
            return (Criteria) this;
        }

        public Criteria andInvitationcodeNotBetween(String value1, String value2) {
            addCriterion("invitationcode not between", value1, value2, "invitationcode");
            return (Criteria) this;
        }

        public Criteria andQuestionnumIsNull() {
            addCriterion("questionnum is null");
            return (Criteria) this;
        }

        public Criteria andQuestionnumIsNotNull() {
            addCriterion("questionnum is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionnumEqualTo(Integer value) {
            addCriterion("questionnum =", value, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumNotEqualTo(Integer value) {
            addCriterion("questionnum <>", value, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumGreaterThan(Integer value) {
            addCriterion("questionnum >", value, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("questionnum >=", value, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumLessThan(Integer value) {
            addCriterion("questionnum <", value, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumLessThanOrEqualTo(Integer value) {
            addCriterion("questionnum <=", value, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumIn(List<Integer> values) {
            addCriterion("questionnum in", values, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumNotIn(List<Integer> values) {
            addCriterion("questionnum not in", values, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumBetween(Integer value1, Integer value2) {
            addCriterion("questionnum between", value1, value2, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumNotBetween(Integer value1, Integer value2) {
            addCriterion("questionnum not between", value1, value2, "questionnum");
            return (Criteria) this;
        }

        public Criteria andSinglenumIsNull() {
            addCriterion("singlenum is null");
            return (Criteria) this;
        }

        public Criteria andSinglenumIsNotNull() {
            addCriterion("singlenum is not null");
            return (Criteria) this;
        }

        public Criteria andSinglenumEqualTo(Integer value) {
            addCriterion("singlenum =", value, "singlenum");
            return (Criteria) this;
        }

        public Criteria andSinglenumNotEqualTo(Integer value) {
            addCriterion("singlenum <>", value, "singlenum");
            return (Criteria) this;
        }

        public Criteria andSinglenumGreaterThan(Integer value) {
            addCriterion("singlenum >", value, "singlenum");
            return (Criteria) this;
        }

        public Criteria andSinglenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("singlenum >=", value, "singlenum");
            return (Criteria) this;
        }

        public Criteria andSinglenumLessThan(Integer value) {
            addCriterion("singlenum <", value, "singlenum");
            return (Criteria) this;
        }

        public Criteria andSinglenumLessThanOrEqualTo(Integer value) {
            addCriterion("singlenum <=", value, "singlenum");
            return (Criteria) this;
        }

        public Criteria andSinglenumIn(List<Integer> values) {
            addCriterion("singlenum in", values, "singlenum");
            return (Criteria) this;
        }

        public Criteria andSinglenumNotIn(List<Integer> values) {
            addCriterion("singlenum not in", values, "singlenum");
            return (Criteria) this;
        }

        public Criteria andSinglenumBetween(Integer value1, Integer value2) {
            addCriterion("singlenum between", value1, value2, "singlenum");
            return (Criteria) this;
        }

        public Criteria andSinglenumNotBetween(Integer value1, Integer value2) {
            addCriterion("singlenum not between", value1, value2, "singlenum");
            return (Criteria) this;
        }

        public Criteria andJudgenumIsNull() {
            addCriterion("judgenum is null");
            return (Criteria) this;
        }

        public Criteria andJudgenumIsNotNull() {
            addCriterion("judgenum is not null");
            return (Criteria) this;
        }

        public Criteria andJudgenumEqualTo(Integer value) {
            addCriterion("judgenum =", value, "judgenum");
            return (Criteria) this;
        }

        public Criteria andJudgenumNotEqualTo(Integer value) {
            addCriterion("judgenum <>", value, "judgenum");
            return (Criteria) this;
        }

        public Criteria andJudgenumGreaterThan(Integer value) {
            addCriterion("judgenum >", value, "judgenum");
            return (Criteria) this;
        }

        public Criteria andJudgenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("judgenum >=", value, "judgenum");
            return (Criteria) this;
        }

        public Criteria andJudgenumLessThan(Integer value) {
            addCriterion("judgenum <", value, "judgenum");
            return (Criteria) this;
        }

        public Criteria andJudgenumLessThanOrEqualTo(Integer value) {
            addCriterion("judgenum <=", value, "judgenum");
            return (Criteria) this;
        }

        public Criteria andJudgenumIn(List<Integer> values) {
            addCriterion("judgenum in", values, "judgenum");
            return (Criteria) this;
        }

        public Criteria andJudgenumNotIn(List<Integer> values) {
            addCriterion("judgenum not in", values, "judgenum");
            return (Criteria) this;
        }

        public Criteria andJudgenumBetween(Integer value1, Integer value2) {
            addCriterion("judgenum between", value1, value2, "judgenum");
            return (Criteria) this;
        }

        public Criteria andJudgenumNotBetween(Integer value1, Integer value2) {
            addCriterion("judgenum not between", value1, value2, "judgenum");
            return (Criteria) this;
        }

        public Criteria andMultiplenumIsNull() {
            addCriterion("multiplenum is null");
            return (Criteria) this;
        }

        public Criteria andMultiplenumIsNotNull() {
            addCriterion("multiplenum is not null");
            return (Criteria) this;
        }

        public Criteria andMultiplenumEqualTo(Integer value) {
            addCriterion("multiplenum =", value, "multiplenum");
            return (Criteria) this;
        }

        public Criteria andMultiplenumNotEqualTo(Integer value) {
            addCriterion("multiplenum <>", value, "multiplenum");
            return (Criteria) this;
        }

        public Criteria andMultiplenumGreaterThan(Integer value) {
            addCriterion("multiplenum >", value, "multiplenum");
            return (Criteria) this;
        }

        public Criteria andMultiplenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("multiplenum >=", value, "multiplenum");
            return (Criteria) this;
        }

        public Criteria andMultiplenumLessThan(Integer value) {
            addCriterion("multiplenum <", value, "multiplenum");
            return (Criteria) this;
        }

        public Criteria andMultiplenumLessThanOrEqualTo(Integer value) {
            addCriterion("multiplenum <=", value, "multiplenum");
            return (Criteria) this;
        }

        public Criteria andMultiplenumIn(List<Integer> values) {
            addCriterion("multiplenum in", values, "multiplenum");
            return (Criteria) this;
        }

        public Criteria andMultiplenumNotIn(List<Integer> values) {
            addCriterion("multiplenum not in", values, "multiplenum");
            return (Criteria) this;
        }

        public Criteria andMultiplenumBetween(Integer value1, Integer value2) {
            addCriterion("multiplenum between", value1, value2, "multiplenum");
            return (Criteria) this;
        }

        public Criteria andMultiplenumNotBetween(Integer value1, Integer value2) {
            addCriterion("multiplenum not between", value1, value2, "multiplenum");
            return (Criteria) this;
        }

        public Criteria andFillnumIsNull() {
            addCriterion("fillnum is null");
            return (Criteria) this;
        }

        public Criteria andFillnumIsNotNull() {
            addCriterion("fillnum is not null");
            return (Criteria) this;
        }

        public Criteria andFillnumEqualTo(Integer value) {
            addCriterion("fillnum =", value, "fillnum");
            return (Criteria) this;
        }

        public Criteria andFillnumNotEqualTo(Integer value) {
            addCriterion("fillnum <>", value, "fillnum");
            return (Criteria) this;
        }

        public Criteria andFillnumGreaterThan(Integer value) {
            addCriterion("fillnum >", value, "fillnum");
            return (Criteria) this;
        }

        public Criteria andFillnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("fillnum >=", value, "fillnum");
            return (Criteria) this;
        }

        public Criteria andFillnumLessThan(Integer value) {
            addCriterion("fillnum <", value, "fillnum");
            return (Criteria) this;
        }

        public Criteria andFillnumLessThanOrEqualTo(Integer value) {
            addCriterion("fillnum <=", value, "fillnum");
            return (Criteria) this;
        }

        public Criteria andFillnumIn(List<Integer> values) {
            addCriterion("fillnum in", values, "fillnum");
            return (Criteria) this;
        }

        public Criteria andFillnumNotIn(List<Integer> values) {
            addCriterion("fillnum not in", values, "fillnum");
            return (Criteria) this;
        }

        public Criteria andFillnumBetween(Integer value1, Integer value2) {
            addCriterion("fillnum between", value1, value2, "fillnum");
            return (Criteria) this;
        }

        public Criteria andFillnumNotBetween(Integer value1, Integer value2) {
            addCriterion("fillnum not between", value1, value2, "fillnum");
            return (Criteria) this;
        }

        public Criteria andShortanswernumIsNull() {
            addCriterion("shortanswernum is null");
            return (Criteria) this;
        }

        public Criteria andShortanswernumIsNotNull() {
            addCriterion("shortanswernum is not null");
            return (Criteria) this;
        }

        public Criteria andShortanswernumEqualTo(Integer value) {
            addCriterion("shortanswernum =", value, "shortanswernum");
            return (Criteria) this;
        }

        public Criteria andShortanswernumNotEqualTo(Integer value) {
            addCriterion("shortanswernum <>", value, "shortanswernum");
            return (Criteria) this;
        }

        public Criteria andShortanswernumGreaterThan(Integer value) {
            addCriterion("shortanswernum >", value, "shortanswernum");
            return (Criteria) this;
        }

        public Criteria andShortanswernumGreaterThanOrEqualTo(Integer value) {
            addCriterion("shortanswernum >=", value, "shortanswernum");
            return (Criteria) this;
        }

        public Criteria andShortanswernumLessThan(Integer value) {
            addCriterion("shortanswernum <", value, "shortanswernum");
            return (Criteria) this;
        }

        public Criteria andShortanswernumLessThanOrEqualTo(Integer value) {
            addCriterion("shortanswernum <=", value, "shortanswernum");
            return (Criteria) this;
        }

        public Criteria andShortanswernumIn(List<Integer> values) {
            addCriterion("shortanswernum in", values, "shortanswernum");
            return (Criteria) this;
        }

        public Criteria andShortanswernumNotIn(List<Integer> values) {
            addCriterion("shortanswernum not in", values, "shortanswernum");
            return (Criteria) this;
        }

        public Criteria andShortanswernumBetween(Integer value1, Integer value2) {
            addCriterion("shortanswernum between", value1, value2, "shortanswernum");
            return (Criteria) this;
        }

        public Criteria andShortanswernumNotBetween(Integer value1, Integer value2) {
            addCriterion("shortanswernum not between", value1, value2, "shortanswernum");
            return (Criteria) this;
        }

        public Criteria andQuestionscoreIsNull() {
            addCriterion("questionscore is null");
            return (Criteria) this;
        }

        public Criteria andQuestionscoreIsNotNull() {
            addCriterion("questionscore is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionscoreEqualTo(Integer value) {
            addCriterion("questionscore =", value, "questionscore");
            return (Criteria) this;
        }

        public Criteria andQuestionscoreNotEqualTo(Integer value) {
            addCriterion("questionscore <>", value, "questionscore");
            return (Criteria) this;
        }

        public Criteria andQuestionscoreGreaterThan(Integer value) {
            addCriterion("questionscore >", value, "questionscore");
            return (Criteria) this;
        }

        public Criteria andQuestionscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("questionscore >=", value, "questionscore");
            return (Criteria) this;
        }

        public Criteria andQuestionscoreLessThan(Integer value) {
            addCriterion("questionscore <", value, "questionscore");
            return (Criteria) this;
        }

        public Criteria andQuestionscoreLessThanOrEqualTo(Integer value) {
            addCriterion("questionscore <=", value, "questionscore");
            return (Criteria) this;
        }

        public Criteria andQuestionscoreIn(List<Integer> values) {
            addCriterion("questionscore in", values, "questionscore");
            return (Criteria) this;
        }

        public Criteria andQuestionscoreNotIn(List<Integer> values) {
            addCriterion("questionscore not in", values, "questionscore");
            return (Criteria) this;
        }

        public Criteria andQuestionscoreBetween(Integer value1, Integer value2) {
            addCriterion("questionscore between", value1, value2, "questionscore");
            return (Criteria) this;
        }

        public Criteria andQuestionscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("questionscore not between", value1, value2, "questionscore");
            return (Criteria) this;
        }

        public Criteria andSignlescoreIsNull() {
            addCriterion("signlescore is null");
            return (Criteria) this;
        }

        public Criteria andSignlescoreIsNotNull() {
            addCriterion("signlescore is not null");
            return (Criteria) this;
        }

        public Criteria andSignlescoreEqualTo(Integer value) {
            addCriterion("signlescore =", value, "signlescore");
            return (Criteria) this;
        }

        public Criteria andSignlescoreNotEqualTo(Integer value) {
            addCriterion("signlescore <>", value, "signlescore");
            return (Criteria) this;
        }

        public Criteria andSignlescoreGreaterThan(Integer value) {
            addCriterion("signlescore >", value, "signlescore");
            return (Criteria) this;
        }

        public Criteria andSignlescoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("signlescore >=", value, "signlescore");
            return (Criteria) this;
        }

        public Criteria andSignlescoreLessThan(Integer value) {
            addCriterion("signlescore <", value, "signlescore");
            return (Criteria) this;
        }

        public Criteria andSignlescoreLessThanOrEqualTo(Integer value) {
            addCriterion("signlescore <=", value, "signlescore");
            return (Criteria) this;
        }

        public Criteria andSignlescoreIn(List<Integer> values) {
            addCriterion("signlescore in", values, "signlescore");
            return (Criteria) this;
        }

        public Criteria andSignlescoreNotIn(List<Integer> values) {
            addCriterion("signlescore not in", values, "signlescore");
            return (Criteria) this;
        }

        public Criteria andSignlescoreBetween(Integer value1, Integer value2) {
            addCriterion("signlescore between", value1, value2, "signlescore");
            return (Criteria) this;
        }

        public Criteria andSignlescoreNotBetween(Integer value1, Integer value2) {
            addCriterion("signlescore not between", value1, value2, "signlescore");
            return (Criteria) this;
        }

        public Criteria andJudgescoreIsNull() {
            addCriterion("judgescore is null");
            return (Criteria) this;
        }

        public Criteria andJudgescoreIsNotNull() {
            addCriterion("judgescore is not null");
            return (Criteria) this;
        }

        public Criteria andJudgescoreEqualTo(Integer value) {
            addCriterion("judgescore =", value, "judgescore");
            return (Criteria) this;
        }

        public Criteria andJudgescoreNotEqualTo(Integer value) {
            addCriterion("judgescore <>", value, "judgescore");
            return (Criteria) this;
        }

        public Criteria andJudgescoreGreaterThan(Integer value) {
            addCriterion("judgescore >", value, "judgescore");
            return (Criteria) this;
        }

        public Criteria andJudgescoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("judgescore >=", value, "judgescore");
            return (Criteria) this;
        }

        public Criteria andJudgescoreLessThan(Integer value) {
            addCriterion("judgescore <", value, "judgescore");
            return (Criteria) this;
        }

        public Criteria andJudgescoreLessThanOrEqualTo(Integer value) {
            addCriterion("judgescore <=", value, "judgescore");
            return (Criteria) this;
        }

        public Criteria andJudgescoreIn(List<Integer> values) {
            addCriterion("judgescore in", values, "judgescore");
            return (Criteria) this;
        }

        public Criteria andJudgescoreNotIn(List<Integer> values) {
            addCriterion("judgescore not in", values, "judgescore");
            return (Criteria) this;
        }

        public Criteria andJudgescoreBetween(Integer value1, Integer value2) {
            addCriterion("judgescore between", value1, value2, "judgescore");
            return (Criteria) this;
        }

        public Criteria andJudgescoreNotBetween(Integer value1, Integer value2) {
            addCriterion("judgescore not between", value1, value2, "judgescore");
            return (Criteria) this;
        }

        public Criteria andMultiplescoreIsNull() {
            addCriterion("multiplescore is null");
            return (Criteria) this;
        }

        public Criteria andMultiplescoreIsNotNull() {
            addCriterion("multiplescore is not null");
            return (Criteria) this;
        }

        public Criteria andMultiplescoreEqualTo(Integer value) {
            addCriterion("multiplescore =", value, "multiplescore");
            return (Criteria) this;
        }

        public Criteria andMultiplescoreNotEqualTo(Integer value) {
            addCriterion("multiplescore <>", value, "multiplescore");
            return (Criteria) this;
        }

        public Criteria andMultiplescoreGreaterThan(Integer value) {
            addCriterion("multiplescore >", value, "multiplescore");
            return (Criteria) this;
        }

        public Criteria andMultiplescoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("multiplescore >=", value, "multiplescore");
            return (Criteria) this;
        }

        public Criteria andMultiplescoreLessThan(Integer value) {
            addCriterion("multiplescore <", value, "multiplescore");
            return (Criteria) this;
        }

        public Criteria andMultiplescoreLessThanOrEqualTo(Integer value) {
            addCriterion("multiplescore <=", value, "multiplescore");
            return (Criteria) this;
        }

        public Criteria andMultiplescoreIn(List<Integer> values) {
            addCriterion("multiplescore in", values, "multiplescore");
            return (Criteria) this;
        }

        public Criteria andMultiplescoreNotIn(List<Integer> values) {
            addCriterion("multiplescore not in", values, "multiplescore");
            return (Criteria) this;
        }

        public Criteria andMultiplescoreBetween(Integer value1, Integer value2) {
            addCriterion("multiplescore between", value1, value2, "multiplescore");
            return (Criteria) this;
        }

        public Criteria andMultiplescoreNotBetween(Integer value1, Integer value2) {
            addCriterion("multiplescore not between", value1, value2, "multiplescore");
            return (Criteria) this;
        }

        public Criteria andFillscoreIsNull() {
            addCriterion("fillscore is null");
            return (Criteria) this;
        }

        public Criteria andFillscoreIsNotNull() {
            addCriterion("fillscore is not null");
            return (Criteria) this;
        }

        public Criteria andFillscoreEqualTo(Integer value) {
            addCriterion("fillscore =", value, "fillscore");
            return (Criteria) this;
        }

        public Criteria andFillscoreNotEqualTo(Integer value) {
            addCriterion("fillscore <>", value, "fillscore");
            return (Criteria) this;
        }

        public Criteria andFillscoreGreaterThan(Integer value) {
            addCriterion("fillscore >", value, "fillscore");
            return (Criteria) this;
        }

        public Criteria andFillscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("fillscore >=", value, "fillscore");
            return (Criteria) this;
        }

        public Criteria andFillscoreLessThan(Integer value) {
            addCriterion("fillscore <", value, "fillscore");
            return (Criteria) this;
        }

        public Criteria andFillscoreLessThanOrEqualTo(Integer value) {
            addCriterion("fillscore <=", value, "fillscore");
            return (Criteria) this;
        }

        public Criteria andFillscoreIn(List<Integer> values) {
            addCriterion("fillscore in", values, "fillscore");
            return (Criteria) this;
        }

        public Criteria andFillscoreNotIn(List<Integer> values) {
            addCriterion("fillscore not in", values, "fillscore");
            return (Criteria) this;
        }

        public Criteria andFillscoreBetween(Integer value1, Integer value2) {
            addCriterion("fillscore between", value1, value2, "fillscore");
            return (Criteria) this;
        }

        public Criteria andFillscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("fillscore not between", value1, value2, "fillscore");
            return (Criteria) this;
        }

        public Criteria andShortanswerscoreIsNull() {
            addCriterion("shortanswerscore is null");
            return (Criteria) this;
        }

        public Criteria andShortanswerscoreIsNotNull() {
            addCriterion("shortanswerscore is not null");
            return (Criteria) this;
        }

        public Criteria andShortanswerscoreEqualTo(Integer value) {
            addCriterion("shortanswerscore =", value, "shortanswerscore");
            return (Criteria) this;
        }

        public Criteria andShortanswerscoreNotEqualTo(Integer value) {
            addCriterion("shortanswerscore <>", value, "shortanswerscore");
            return (Criteria) this;
        }

        public Criteria andShortanswerscoreGreaterThan(Integer value) {
            addCriterion("shortanswerscore >", value, "shortanswerscore");
            return (Criteria) this;
        }

        public Criteria andShortanswerscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("shortanswerscore >=", value, "shortanswerscore");
            return (Criteria) this;
        }

        public Criteria andShortanswerscoreLessThan(Integer value) {
            addCriterion("shortanswerscore <", value, "shortanswerscore");
            return (Criteria) this;
        }

        public Criteria andShortanswerscoreLessThanOrEqualTo(Integer value) {
            addCriterion("shortanswerscore <=", value, "shortanswerscore");
            return (Criteria) this;
        }

        public Criteria andShortanswerscoreIn(List<Integer> values) {
            addCriterion("shortanswerscore in", values, "shortanswerscore");
            return (Criteria) this;
        }

        public Criteria andShortanswerscoreNotIn(List<Integer> values) {
            addCriterion("shortanswerscore not in", values, "shortanswerscore");
            return (Criteria) this;
        }

        public Criteria andShortanswerscoreBetween(Integer value1, Integer value2) {
            addCriterion("shortanswerscore between", value1, value2, "shortanswerscore");
            return (Criteria) this;
        }

        public Criteria andShortanswerscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("shortanswerscore not between", value1, value2, "shortanswerscore");
            return (Criteria) this;
        }

        public Criteria andWinderIsNull() {
            addCriterion("winder is null");
            return (Criteria) this;
        }

        public Criteria andWinderIsNotNull() {
            addCriterion("winder is not null");
            return (Criteria) this;
        }

        public Criteria andWinderEqualTo(Integer value) {
            addCriterion("winder =", value, "winder");
            return (Criteria) this;
        }

        public Criteria andWinderNotEqualTo(Integer value) {
            addCriterion("winder <>", value, "winder");
            return (Criteria) this;
        }

        public Criteria andWinderGreaterThan(Integer value) {
            addCriterion("winder >", value, "winder");
            return (Criteria) this;
        }

        public Criteria andWinderGreaterThanOrEqualTo(Integer value) {
            addCriterion("winder >=", value, "winder");
            return (Criteria) this;
        }

        public Criteria andWinderLessThan(Integer value) {
            addCriterion("winder <", value, "winder");
            return (Criteria) this;
        }

        public Criteria andWinderLessThanOrEqualTo(Integer value) {
            addCriterion("winder <=", value, "winder");
            return (Criteria) this;
        }

        public Criteria andWinderIn(List<Integer> values) {
            addCriterion("winder in", values, "winder");
            return (Criteria) this;
        }

        public Criteria andWinderNotIn(List<Integer> values) {
            addCriterion("winder not in", values, "winder");
            return (Criteria) this;
        }

        public Criteria andWinderBetween(Integer value1, Integer value2) {
            addCriterion("winder between", value1, value2, "winder");
            return (Criteria) this;
        }

        public Criteria andWinderNotBetween(Integer value1, Integer value2) {
            addCriterion("winder not between", value1, value2, "winder");
            return (Criteria) this;
        }

        public Criteria andExamineeIsNull() {
            addCriterion("examinee is null");
            return (Criteria) this;
        }

        public Criteria andExamineeIsNotNull() {
            addCriterion("examinee is not null");
            return (Criteria) this;
        }

        public Criteria andExamineeEqualTo(Integer value) {
            addCriterion("examinee =", value, "examinee");
            return (Criteria) this;
        }

        public Criteria andExamineeNotEqualTo(Integer value) {
            addCriterion("examinee <>", value, "examinee");
            return (Criteria) this;
        }

        public Criteria andExamineeGreaterThan(Integer value) {
            addCriterion("examinee >", value, "examinee");
            return (Criteria) this;
        }

        public Criteria andExamineeGreaterThanOrEqualTo(Integer value) {
            addCriterion("examinee >=", value, "examinee");
            return (Criteria) this;
        }

        public Criteria andExamineeLessThan(Integer value) {
            addCriterion("examinee <", value, "examinee");
            return (Criteria) this;
        }

        public Criteria andExamineeLessThanOrEqualTo(Integer value) {
            addCriterion("examinee <=", value, "examinee");
            return (Criteria) this;
        }

        public Criteria andExamineeIn(List<Integer> values) {
            addCriterion("examinee in", values, "examinee");
            return (Criteria) this;
        }

        public Criteria andExamineeNotIn(List<Integer> values) {
            addCriterion("examinee not in", values, "examinee");
            return (Criteria) this;
        }

        public Criteria andExamineeBetween(Integer value1, Integer value2) {
            addCriterion("examinee between", value1, value2, "examinee");
            return (Criteria) this;
        }

        public Criteria andExamineeNotBetween(Integer value1, Integer value2) {
            addCriterion("examinee not between", value1, value2, "examinee");
            return (Criteria) this;
        }

        public Criteria andBegintimeIsNull() {
            addCriterion("begintime is null");
            return (Criteria) this;
        }

        public Criteria andBegintimeIsNotNull() {
            addCriterion("begintime is not null");
            return (Criteria) this;
        }

        public Criteria andBegintimeEqualTo(Date value) {
            addCriterion("begintime =", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeNotEqualTo(Date value) {
            addCriterion("begintime <>", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeGreaterThan(Date value) {
            addCriterion("begintime >", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeGreaterThanOrEqualTo(Date value) {
            addCriterion("begintime >=", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeLessThan(Date value) {
            addCriterion("begintime <", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeLessThanOrEqualTo(Date value) {
            addCriterion("begintime <=", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeIn(List<Date> values) {
            addCriterion("begintime in", values, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeNotIn(List<Date> values) {
            addCriterion("begintime not in", values, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeBetween(Date value1, Date value2) {
            addCriterion("begintime between", value1, value2, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeNotBetween(Date value1, Date value2) {
            addCriterion("begintime not between", value1, value2, "begintime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endtime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endtime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterion("endtime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterion("endtime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterion("endtime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("endtime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterion("endtime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("endtime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterion("endtime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterion("endtime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterion("endtime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("endtime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andDurationIsNull() {
            addCriterion("duration is null");
            return (Criteria) this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("duration is not null");
            return (Criteria) this;
        }

        public Criteria andDurationEqualTo(String value) {
            addCriterion("duration =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(String value) {
            addCriterion("duration <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(String value) {
            addCriterion("duration >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(String value) {
            addCriterion("duration >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(String value) {
            addCriterion("duration <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(String value) {
            addCriterion("duration <=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLike(String value) {
            addCriterion("duration like", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotLike(String value) {
            addCriterion("duration not like", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationIn(List<String> values) {
            addCriterion("duration in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<String> values) {
            addCriterion("duration not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(String value1, String value2) {
            addCriterion("duration between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(String value1, String value2) {
            addCriterion("duration not between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andType1IsNull() {
            addCriterion("type1 is null");
            return (Criteria) this;
        }

        public Criteria andType1IsNotNull() {
            addCriterion("type1 is not null");
            return (Criteria) this;
        }

        public Criteria andType1EqualTo(Integer value) {
            addCriterion("type1 =", value, "type1");
            return (Criteria) this;
        }

        public Criteria andType1NotEqualTo(Integer value) {
            addCriterion("type1 <>", value, "type1");
            return (Criteria) this;
        }

        public Criteria andType1GreaterThan(Integer value) {
            addCriterion("type1 >", value, "type1");
            return (Criteria) this;
        }

        public Criteria andType1GreaterThanOrEqualTo(Integer value) {
            addCriterion("type1 >=", value, "type1");
            return (Criteria) this;
        }

        public Criteria andType1LessThan(Integer value) {
            addCriterion("type1 <", value, "type1");
            return (Criteria) this;
        }

        public Criteria andType1LessThanOrEqualTo(Integer value) {
            addCriterion("type1 <=", value, "type1");
            return (Criteria) this;
        }

        public Criteria andType1In(List<Integer> values) {
            addCriterion("type1 in", values, "type1");
            return (Criteria) this;
        }

        public Criteria andType1NotIn(List<Integer> values) {
            addCriterion("type1 not in", values, "type1");
            return (Criteria) this;
        }

        public Criteria andType1Between(Integer value1, Integer value2) {
            addCriterion("type1 between", value1, value2, "type1");
            return (Criteria) this;
        }

        public Criteria andType1NotBetween(Integer value1, Integer value2) {
            addCriterion("type1 not between", value1, value2, "type1");
            return (Criteria) this;
        }

        public Criteria andTimeoutIsNull() {
            addCriterion("timeout is null");
            return (Criteria) this;
        }

        public Criteria andTimeoutIsNotNull() {
            addCriterion("timeout is not null");
            return (Criteria) this;
        }

        public Criteria andTimeoutEqualTo(Integer value) {
            addCriterion("timeout =", value, "timeout");
            return (Criteria) this;
        }

        public Criteria andTimeoutNotEqualTo(Integer value) {
            addCriterion("timeout <>", value, "timeout");
            return (Criteria) this;
        }

        public Criteria andTimeoutGreaterThan(Integer value) {
            addCriterion("timeout >", value, "timeout");
            return (Criteria) this;
        }

        public Criteria andTimeoutGreaterThanOrEqualTo(Integer value) {
            addCriterion("timeout >=", value, "timeout");
            return (Criteria) this;
        }

        public Criteria andTimeoutLessThan(Integer value) {
            addCriterion("timeout <", value, "timeout");
            return (Criteria) this;
        }

        public Criteria andTimeoutLessThanOrEqualTo(Integer value) {
            addCriterion("timeout <=", value, "timeout");
            return (Criteria) this;
        }

        public Criteria andTimeoutIn(List<Integer> values) {
            addCriterion("timeout in", values, "timeout");
            return (Criteria) this;
        }

        public Criteria andTimeoutNotIn(List<Integer> values) {
            addCriterion("timeout not in", values, "timeout");
            return (Criteria) this;
        }

        public Criteria andTimeoutBetween(Integer value1, Integer value2) {
            addCriterion("timeout between", value1, value2, "timeout");
            return (Criteria) this;
        }

        public Criteria andTimeoutNotBetween(Integer value1, Integer value2) {
            addCriterion("timeout not between", value1, value2, "timeout");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("location is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("location is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("location =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("location <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("location >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("location >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("location <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("location <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("location like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("location not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("location in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("location not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("location between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("location not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andFinscoreIsNull() {
            addCriterion("finscore is null");
            return (Criteria) this;
        }

        public Criteria andFinscoreIsNotNull() {
            addCriterion("finscore is not null");
            return (Criteria) this;
        }

        public Criteria andFinscoreEqualTo(Integer value) {
            addCriterion("finscore =", value, "finscore");
            return (Criteria) this;
        }

        public Criteria andFinscoreNotEqualTo(Integer value) {
            addCriterion("finscore <>", value, "finscore");
            return (Criteria) this;
        }

        public Criteria andFinscoreGreaterThan(Integer value) {
            addCriterion("finscore >", value, "finscore");
            return (Criteria) this;
        }

        public Criteria andFinscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("finscore >=", value, "finscore");
            return (Criteria) this;
        }

        public Criteria andFinscoreLessThan(Integer value) {
            addCriterion("finscore <", value, "finscore");
            return (Criteria) this;
        }

        public Criteria andFinscoreLessThanOrEqualTo(Integer value) {
            addCriterion("finscore <=", value, "finscore");
            return (Criteria) this;
        }

        public Criteria andFinscoreIn(List<Integer> values) {
            addCriterion("finscore in", values, "finscore");
            return (Criteria) this;
        }

        public Criteria andFinscoreNotIn(List<Integer> values) {
            addCriterion("finscore not in", values, "finscore");
            return (Criteria) this;
        }

        public Criteria andFinscoreBetween(Integer value1, Integer value2) {
            addCriterion("finscore between", value1, value2, "finscore");
            return (Criteria) this;
        }

        public Criteria andFinscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("finscore not between", value1, value2, "finscore");
            return (Criteria) this;
        }

        public Criteria andOutnumIsNull() {
            addCriterion("outnum is null");
            return (Criteria) this;
        }

        public Criteria andOutnumIsNotNull() {
            addCriterion("outnum is not null");
            return (Criteria) this;
        }

        public Criteria andOutnumEqualTo(Integer value) {
            addCriterion("outnum =", value, "outnum");
            return (Criteria) this;
        }

        public Criteria andOutnumNotEqualTo(Integer value) {
            addCriterion("outnum <>", value, "outnum");
            return (Criteria) this;
        }

        public Criteria andOutnumGreaterThan(Integer value) {
            addCriterion("outnum >", value, "outnum");
            return (Criteria) this;
        }

        public Criteria andOutnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("outnum >=", value, "outnum");
            return (Criteria) this;
        }

        public Criteria andOutnumLessThan(Integer value) {
            addCriterion("outnum <", value, "outnum");
            return (Criteria) this;
        }

        public Criteria andOutnumLessThanOrEqualTo(Integer value) {
            addCriterion("outnum <=", value, "outnum");
            return (Criteria) this;
        }

        public Criteria andOutnumIn(List<Integer> values) {
            addCriterion("outnum in", values, "outnum");
            return (Criteria) this;
        }

        public Criteria andOutnumNotIn(List<Integer> values) {
            addCriterion("outnum not in", values, "outnum");
            return (Criteria) this;
        }

        public Criteria andOutnumBetween(Integer value1, Integer value2) {
            addCriterion("outnum between", value1, value2, "outnum");
            return (Criteria) this;
        }

        public Criteria andOutnumNotBetween(Integer value1, Integer value2) {
            addCriterion("outnum not between", value1, value2, "outnum");
            return (Criteria) this;
        }

        public Criteria andJudgerIsNull() {
            addCriterion("judger is null");
            return (Criteria) this;
        }

        public Criteria andJudgerIsNotNull() {
            addCriterion("judger is not null");
            return (Criteria) this;
        }

        public Criteria andJudgerEqualTo(Integer value) {
            addCriterion("judger =", value, "judger");
            return (Criteria) this;
        }

        public Criteria andJudgerNotEqualTo(Integer value) {
            addCriterion("judger <>", value, "judger");
            return (Criteria) this;
        }

        public Criteria andJudgerGreaterThan(Integer value) {
            addCriterion("judger >", value, "judger");
            return (Criteria) this;
        }

        public Criteria andJudgerGreaterThanOrEqualTo(Integer value) {
            addCriterion("judger >=", value, "judger");
            return (Criteria) this;
        }

        public Criteria andJudgerLessThan(Integer value) {
            addCriterion("judger <", value, "judger");
            return (Criteria) this;
        }

        public Criteria andJudgerLessThanOrEqualTo(Integer value) {
            addCriterion("judger <=", value, "judger");
            return (Criteria) this;
        }

        public Criteria andJudgerIn(List<Integer> values) {
            addCriterion("judger in", values, "judger");
            return (Criteria) this;
        }

        public Criteria andJudgerNotIn(List<Integer> values) {
            addCriterion("judger not in", values, "judger");
            return (Criteria) this;
        }

        public Criteria andJudgerBetween(Integer value1, Integer value2) {
            addCriterion("judger between", value1, value2, "judger");
            return (Criteria) this;
        }

        public Criteria andJudgerNotBetween(Integer value1, Integer value2) {
            addCriterion("judger not between", value1, value2, "judger");
            return (Criteria) this;
        }

        public Criteria andResourceIsNull() {
            addCriterion("resource is null");
            return (Criteria) this;
        }

        public Criteria andResourceIsNotNull() {
            addCriterion("resource is not null");
            return (Criteria) this;
        }

        public Criteria andResourceEqualTo(String value) {
            addCriterion("resource =", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceNotEqualTo(String value) {
            addCriterion("resource <>", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceGreaterThan(String value) {
            addCriterion("resource >", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceGreaterThanOrEqualTo(String value) {
            addCriterion("resource >=", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceLessThan(String value) {
            addCriterion("resource <", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceLessThanOrEqualTo(String value) {
            addCriterion("resource <=", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceLike(String value) {
            addCriterion("resource like", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceNotLike(String value) {
            addCriterion("resource not like", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceIn(List<String> values) {
            addCriterion("resource in", values, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceNotIn(List<String> values) {
            addCriterion("resource not in", values, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceBetween(String value1, String value2) {
            addCriterion("resource between", value1, value2, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceNotBetween(String value1, String value2) {
            addCriterion("resource not between", value1, value2, "resource");
            return (Criteria) this;
        }

        public Criteria andOrderflagIsNull() {
            addCriterion("orderflag is null");
            return (Criteria) this;
        }

        public Criteria andOrderflagIsNotNull() {
            addCriterion("orderflag is not null");
            return (Criteria) this;
        }

        public Criteria andOrderflagEqualTo(Integer value) {
            addCriterion("orderflag =", value, "orderflag");
            return (Criteria) this;
        }

        public Criteria andOrderflagNotEqualTo(Integer value) {
            addCriterion("orderflag <>", value, "orderflag");
            return (Criteria) this;
        }

        public Criteria andOrderflagGreaterThan(Integer value) {
            addCriterion("orderflag >", value, "orderflag");
            return (Criteria) this;
        }

        public Criteria andOrderflagGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderflag >=", value, "orderflag");
            return (Criteria) this;
        }

        public Criteria andOrderflagLessThan(Integer value) {
            addCriterion("orderflag <", value, "orderflag");
            return (Criteria) this;
        }

        public Criteria andOrderflagLessThanOrEqualTo(Integer value) {
            addCriterion("orderflag <=", value, "orderflag");
            return (Criteria) this;
        }

        public Criteria andOrderflagIn(List<Integer> values) {
            addCriterion("orderflag in", values, "orderflag");
            return (Criteria) this;
        }

        public Criteria andOrderflagNotIn(List<Integer> values) {
            addCriterion("orderflag not in", values, "orderflag");
            return (Criteria) this;
        }

        public Criteria andOrderflagBetween(Integer value1, Integer value2) {
            addCriterion("orderflag between", value1, value2, "orderflag");
            return (Criteria) this;
        }

        public Criteria andOrderflagNotBetween(Integer value1, Integer value2) {
            addCriterion("orderflag not between", value1, value2, "orderflag");
            return (Criteria) this;
        }

        public Criteria andUndonenumIsNull() {
            addCriterion("undonenum is null");
            return (Criteria) this;
        }

        public Criteria andUndonenumIsNotNull() {
            addCriterion("undonenum is not null");
            return (Criteria) this;
        }

        public Criteria andUndonenumEqualTo(Integer value) {
            addCriterion("undonenum =", value, "undonenum");
            return (Criteria) this;
        }

        public Criteria andUndonenumNotEqualTo(Integer value) {
            addCriterion("undonenum <>", value, "undonenum");
            return (Criteria) this;
        }

        public Criteria andUndonenumGreaterThan(Integer value) {
            addCriterion("undonenum >", value, "undonenum");
            return (Criteria) this;
        }

        public Criteria andUndonenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("undonenum >=", value, "undonenum");
            return (Criteria) this;
        }

        public Criteria andUndonenumLessThan(Integer value) {
            addCriterion("undonenum <", value, "undonenum");
            return (Criteria) this;
        }

        public Criteria andUndonenumLessThanOrEqualTo(Integer value) {
            addCriterion("undonenum <=", value, "undonenum");
            return (Criteria) this;
        }

        public Criteria andUndonenumIn(List<Integer> values) {
            addCriterion("undonenum in", values, "undonenum");
            return (Criteria) this;
        }

        public Criteria andUndonenumNotIn(List<Integer> values) {
            addCriterion("undonenum not in", values, "undonenum");
            return (Criteria) this;
        }

        public Criteria andUndonenumBetween(Integer value1, Integer value2) {
            addCriterion("undonenum between", value1, value2, "undonenum");
            return (Criteria) this;
        }

        public Criteria andUndonenumNotBetween(Integer value1, Integer value2) {
            addCriterion("undonenum not between", value1, value2, "undonenum");
            return (Criteria) this;
        }

        public Criteria andDoingnumIsNull() {
            addCriterion("doingnum is null");
            return (Criteria) this;
        }

        public Criteria andDoingnumIsNotNull() {
            addCriterion("doingnum is not null");
            return (Criteria) this;
        }

        public Criteria andDoingnumEqualTo(Integer value) {
            addCriterion("doingnum =", value, "doingnum");
            return (Criteria) this;
        }

        public Criteria andDoingnumNotEqualTo(Integer value) {
            addCriterion("doingnum <>", value, "doingnum");
            return (Criteria) this;
        }

        public Criteria andDoingnumGreaterThan(Integer value) {
            addCriterion("doingnum >", value, "doingnum");
            return (Criteria) this;
        }

        public Criteria andDoingnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("doingnum >=", value, "doingnum");
            return (Criteria) this;
        }

        public Criteria andDoingnumLessThan(Integer value) {
            addCriterion("doingnum <", value, "doingnum");
            return (Criteria) this;
        }

        public Criteria andDoingnumLessThanOrEqualTo(Integer value) {
            addCriterion("doingnum <=", value, "doingnum");
            return (Criteria) this;
        }

        public Criteria andDoingnumIn(List<Integer> values) {
            addCriterion("doingnum in", values, "doingnum");
            return (Criteria) this;
        }

        public Criteria andDoingnumNotIn(List<Integer> values) {
            addCriterion("doingnum not in", values, "doingnum");
            return (Criteria) this;
        }

        public Criteria andDoingnumBetween(Integer value1, Integer value2) {
            addCriterion("doingnum between", value1, value2, "doingnum");
            return (Criteria) this;
        }

        public Criteria andDoingnumNotBetween(Integer value1, Integer value2) {
            addCriterion("doingnum not between", value1, value2, "doingnum");
            return (Criteria) this;
        }

        public Criteria andDonenumIsNull() {
            addCriterion("donenum is null");
            return (Criteria) this;
        }

        public Criteria andDonenumIsNotNull() {
            addCriterion("donenum is not null");
            return (Criteria) this;
        }

        public Criteria andDonenumEqualTo(Integer value) {
            addCriterion("donenum =", value, "donenum");
            return (Criteria) this;
        }

        public Criteria andDonenumNotEqualTo(Integer value) {
            addCriterion("donenum <>", value, "donenum");
            return (Criteria) this;
        }

        public Criteria andDonenumGreaterThan(Integer value) {
            addCriterion("donenum >", value, "donenum");
            return (Criteria) this;
        }

        public Criteria andDonenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("donenum >=", value, "donenum");
            return (Criteria) this;
        }

        public Criteria andDonenumLessThan(Integer value) {
            addCriterion("donenum <", value, "donenum");
            return (Criteria) this;
        }

        public Criteria andDonenumLessThanOrEqualTo(Integer value) {
            addCriterion("donenum <=", value, "donenum");
            return (Criteria) this;
        }

        public Criteria andDonenumIn(List<Integer> values) {
            addCriterion("donenum in", values, "donenum");
            return (Criteria) this;
        }

        public Criteria andDonenumNotIn(List<Integer> values) {
            addCriterion("donenum not in", values, "donenum");
            return (Criteria) this;
        }

        public Criteria andDonenumBetween(Integer value1, Integer value2) {
            addCriterion("donenum between", value1, value2, "donenum");
            return (Criteria) this;
        }

        public Criteria andDonenumNotBetween(Integer value1, Integer value2) {
            addCriterion("donenum not between", value1, value2, "donenum");
            return (Criteria) this;
        }

        public Criteria andDoflagIsNull() {
            addCriterion("doflag is null");
            return (Criteria) this;
        }

        public Criteria andDoflagIsNotNull() {
            addCriterion("doflag is not null");
            return (Criteria) this;
        }

        public Criteria andDoflagEqualTo(Integer value) {
            addCriterion("doflag =", value, "doflag");
            return (Criteria) this;
        }

        public Criteria andDoflagNotEqualTo(Integer value) {
            addCriterion("doflag <>", value, "doflag");
            return (Criteria) this;
        }

        public Criteria andDoflagGreaterThan(Integer value) {
            addCriterion("doflag >", value, "doflag");
            return (Criteria) this;
        }

        public Criteria andDoflagGreaterThanOrEqualTo(Integer value) {
            addCriterion("doflag >=", value, "doflag");
            return (Criteria) this;
        }

        public Criteria andDoflagLessThan(Integer value) {
            addCriterion("doflag <", value, "doflag");
            return (Criteria) this;
        }

        public Criteria andDoflagLessThanOrEqualTo(Integer value) {
            addCriterion("doflag <=", value, "doflag");
            return (Criteria) this;
        }

        public Criteria andDoflagIn(List<Integer> values) {
            addCriterion("doflag in", values, "doflag");
            return (Criteria) this;
        }

        public Criteria andDoflagNotIn(List<Integer> values) {
            addCriterion("doflag not in", values, "doflag");
            return (Criteria) this;
        }

        public Criteria andDoflagBetween(Integer value1, Integer value2) {
            addCriterion("doflag between", value1, value2, "doflag");
            return (Criteria) this;
        }

        public Criteria andDoflagNotBetween(Integer value1, Integer value2) {
            addCriterion("doflag not between", value1, value2, "doflag");
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