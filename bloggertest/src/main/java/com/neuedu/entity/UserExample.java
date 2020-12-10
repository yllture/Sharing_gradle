package com.neuedu.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
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

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUseraccountIsNull() {
            addCriterion("useraccount is null");
            return (Criteria) this;
        }

        public Criteria andUseraccountIsNotNull() {
            addCriterion("useraccount is not null");
            return (Criteria) this;
        }

        public Criteria andUseraccountEqualTo(String value) {
            addCriterion("useraccount =", value, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUseraccountNotEqualTo(String value) {
            addCriterion("useraccount <>", value, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUseraccountGreaterThan(String value) {
            addCriterion("useraccount >", value, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUseraccountGreaterThanOrEqualTo(String value) {
            addCriterion("useraccount >=", value, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUseraccountLessThan(String value) {
            addCriterion("useraccount <", value, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUseraccountLessThanOrEqualTo(String value) {
            addCriterion("useraccount <=", value, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUseraccountLike(String value) {
            addCriterion("useraccount like", value, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUseraccountNotLike(String value) {
            addCriterion("useraccount not like", value, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUseraccountIn(List<String> values) {
            addCriterion("useraccount in", values, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUseraccountNotIn(List<String> values) {
            addCriterion("useraccount not in", values, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUseraccountBetween(String value1, String value2) {
            addCriterion("useraccount between", value1, value2, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUseraccountNotBetween(String value1, String value2) {
            addCriterion("useraccount not between", value1, value2, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUsermailIsNull() {
            addCriterion("usermail is null");
            return (Criteria) this;
        }

        public Criteria andUsermailIsNotNull() {
            addCriterion("usermail is not null");
            return (Criteria) this;
        }

        public Criteria andUsermailEqualTo(String value) {
            addCriterion("usermail =", value, "usermail");
            return (Criteria) this;
        }

        public Criteria andUsermailNotEqualTo(String value) {
            addCriterion("usermail <>", value, "usermail");
            return (Criteria) this;
        }

        public Criteria andUsermailGreaterThan(String value) {
            addCriterion("usermail >", value, "usermail");
            return (Criteria) this;
        }

        public Criteria andUsermailGreaterThanOrEqualTo(String value) {
            addCriterion("usermail >=", value, "usermail");
            return (Criteria) this;
        }

        public Criteria andUsermailLessThan(String value) {
            addCriterion("usermail <", value, "usermail");
            return (Criteria) this;
        }

        public Criteria andUsermailLessThanOrEqualTo(String value) {
            addCriterion("usermail <=", value, "usermail");
            return (Criteria) this;
        }

        public Criteria andUsermailLike(String value) {
            addCriterion("usermail like", value, "usermail");
            return (Criteria) this;
        }

        public Criteria andUsermailNotLike(String value) {
            addCriterion("usermail not like", value, "usermail");
            return (Criteria) this;
        }

        public Criteria andUsermailIn(List<String> values) {
            addCriterion("usermail in", values, "usermail");
            return (Criteria) this;
        }

        public Criteria andUsermailNotIn(List<String> values) {
            addCriterion("usermail not in", values, "usermail");
            return (Criteria) this;
        }

        public Criteria andUsermailBetween(String value1, String value2) {
            addCriterion("usermail between", value1, value2, "usermail");
            return (Criteria) this;
        }

        public Criteria andUsermailNotBetween(String value1, String value2) {
            addCriterion("usermail not between", value1, value2, "usermail");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andUserpositionIsNull() {
            addCriterion("userposition is null");
            return (Criteria) this;
        }

        public Criteria andUserpositionIsNotNull() {
            addCriterion("userposition is not null");
            return (Criteria) this;
        }

        public Criteria andUserpositionEqualTo(String value) {
            addCriterion("userposition =", value, "userposition");
            return (Criteria) this;
        }

        public Criteria andUserpositionNotEqualTo(String value) {
            addCriterion("userposition <>", value, "userposition");
            return (Criteria) this;
        }

        public Criteria andUserpositionGreaterThan(String value) {
            addCriterion("userposition >", value, "userposition");
            return (Criteria) this;
        }

        public Criteria andUserpositionGreaterThanOrEqualTo(String value) {
            addCriterion("userposition >=", value, "userposition");
            return (Criteria) this;
        }

        public Criteria andUserpositionLessThan(String value) {
            addCriterion("userposition <", value, "userposition");
            return (Criteria) this;
        }

        public Criteria andUserpositionLessThanOrEqualTo(String value) {
            addCriterion("userposition <=", value, "userposition");
            return (Criteria) this;
        }

        public Criteria andUserpositionLike(String value) {
            addCriterion("userposition like", value, "userposition");
            return (Criteria) this;
        }

        public Criteria andUserpositionNotLike(String value) {
            addCriterion("userposition not like", value, "userposition");
            return (Criteria) this;
        }

        public Criteria andUserpositionIn(List<String> values) {
            addCriterion("userposition in", values, "userposition");
            return (Criteria) this;
        }

        public Criteria andUserpositionNotIn(List<String> values) {
            addCriterion("userposition not in", values, "userposition");
            return (Criteria) this;
        }

        public Criteria andUserpositionBetween(String value1, String value2) {
            addCriterion("userposition between", value1, value2, "userposition");
            return (Criteria) this;
        }

        public Criteria andUserpositionNotBetween(String value1, String value2) {
            addCriterion("userposition not between", value1, value2, "userposition");
            return (Criteria) this;
        }

        public Criteria andUsercompanyIsNull() {
            addCriterion("usercompany is null");
            return (Criteria) this;
        }

        public Criteria andUsercompanyIsNotNull() {
            addCriterion("usercompany is not null");
            return (Criteria) this;
        }

        public Criteria andUsercompanyEqualTo(String value) {
            addCriterion("usercompany =", value, "usercompany");
            return (Criteria) this;
        }

        public Criteria andUsercompanyNotEqualTo(String value) {
            addCriterion("usercompany <>", value, "usercompany");
            return (Criteria) this;
        }

        public Criteria andUsercompanyGreaterThan(String value) {
            addCriterion("usercompany >", value, "usercompany");
            return (Criteria) this;
        }

        public Criteria andUsercompanyGreaterThanOrEqualTo(String value) {
            addCriterion("usercompany >=", value, "usercompany");
            return (Criteria) this;
        }

        public Criteria andUsercompanyLessThan(String value) {
            addCriterion("usercompany <", value, "usercompany");
            return (Criteria) this;
        }

        public Criteria andUsercompanyLessThanOrEqualTo(String value) {
            addCriterion("usercompany <=", value, "usercompany");
            return (Criteria) this;
        }

        public Criteria andUsercompanyLike(String value) {
            addCriterion("usercompany like", value, "usercompany");
            return (Criteria) this;
        }

        public Criteria andUsercompanyNotLike(String value) {
            addCriterion("usercompany not like", value, "usercompany");
            return (Criteria) this;
        }

        public Criteria andUsercompanyIn(List<String> values) {
            addCriterion("usercompany in", values, "usercompany");
            return (Criteria) this;
        }

        public Criteria andUsercompanyNotIn(List<String> values) {
            addCriterion("usercompany not in", values, "usercompany");
            return (Criteria) this;
        }

        public Criteria andUsercompanyBetween(String value1, String value2) {
            addCriterion("usercompany between", value1, value2, "usercompany");
            return (Criteria) this;
        }

        public Criteria andUsercompanyNotBetween(String value1, String value2) {
            addCriterion("usercompany not between", value1, value2, "usercompany");
            return (Criteria) this;
        }

        public Criteria andUsercompanylogoIsNull() {
            addCriterion("usercompanylogo is null");
            return (Criteria) this;
        }

        public Criteria andUsercompanylogoIsNotNull() {
            addCriterion("usercompanylogo is not null");
            return (Criteria) this;
        }

        public Criteria andUsercompanylogoEqualTo(String value) {
            addCriterion("usercompanylogo =", value, "usercompanylogo");
            return (Criteria) this;
        }

        public Criteria andUsercompanylogoNotEqualTo(String value) {
            addCriterion("usercompanylogo <>", value, "usercompanylogo");
            return (Criteria) this;
        }

        public Criteria andUsercompanylogoGreaterThan(String value) {
            addCriterion("usercompanylogo >", value, "usercompanylogo");
            return (Criteria) this;
        }

        public Criteria andUsercompanylogoGreaterThanOrEqualTo(String value) {
            addCriterion("usercompanylogo >=", value, "usercompanylogo");
            return (Criteria) this;
        }

        public Criteria andUsercompanylogoLessThan(String value) {
            addCriterion("usercompanylogo <", value, "usercompanylogo");
            return (Criteria) this;
        }

        public Criteria andUsercompanylogoLessThanOrEqualTo(String value) {
            addCriterion("usercompanylogo <=", value, "usercompanylogo");
            return (Criteria) this;
        }

        public Criteria andUsercompanylogoLike(String value) {
            addCriterion("usercompanylogo like", value, "usercompanylogo");
            return (Criteria) this;
        }

        public Criteria andUsercompanylogoNotLike(String value) {
            addCriterion("usercompanylogo not like", value, "usercompanylogo");
            return (Criteria) this;
        }

        public Criteria andUsercompanylogoIn(List<String> values) {
            addCriterion("usercompanylogo in", values, "usercompanylogo");
            return (Criteria) this;
        }

        public Criteria andUsercompanylogoNotIn(List<String> values) {
            addCriterion("usercompanylogo not in", values, "usercompanylogo");
            return (Criteria) this;
        }

        public Criteria andUsercompanylogoBetween(String value1, String value2) {
            addCriterion("usercompanylogo between", value1, value2, "usercompanylogo");
            return (Criteria) this;
        }

        public Criteria andUsercompanylogoNotBetween(String value1, String value2) {
            addCriterion("usercompanylogo not between", value1, value2, "usercompanylogo");
            return (Criteria) this;
        }

        public Criteria andUsertypeIsNull() {
            addCriterion("usertype is null");
            return (Criteria) this;
        }

        public Criteria andUsertypeIsNotNull() {
            addCriterion("usertype is not null");
            return (Criteria) this;
        }

        public Criteria andUsertypeEqualTo(Integer value) {
            addCriterion("usertype =", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotEqualTo(Integer value) {
            addCriterion("usertype <>", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThan(Integer value) {
            addCriterion("usertype >", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("usertype >=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThan(Integer value) {
            addCriterion("usertype <", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThanOrEqualTo(Integer value) {
            addCriterion("usertype <=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeIn(List<Integer> values) {
            addCriterion("usertype in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotIn(List<Integer> values) {
            addCriterion("usertype not in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeBetween(Integer value1, Integer value2) {
            addCriterion("usertype between", value1, value2, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotBetween(Integer value1, Integer value2) {
            addCriterion("usertype not between", value1, value2, "usertype");
            return (Criteria) this;
        }

        public Criteria andUserpasswordIsNull() {
            addCriterion("userpassword is null");
            return (Criteria) this;
        }

        public Criteria andUserpasswordIsNotNull() {
            addCriterion("userpassword is not null");
            return (Criteria) this;
        }

        public Criteria andUserpasswordEqualTo(String value) {
            addCriterion("userpassword =", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordNotEqualTo(String value) {
            addCriterion("userpassword <>", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordGreaterThan(String value) {
            addCriterion("userpassword >", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordGreaterThanOrEqualTo(String value) {
            addCriterion("userpassword >=", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordLessThan(String value) {
            addCriterion("userpassword <", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordLessThanOrEqualTo(String value) {
            addCriterion("userpassword <=", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordLike(String value) {
            addCriterion("userpassword like", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordNotLike(String value) {
            addCriterion("userpassword not like", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordIn(List<String> values) {
            addCriterion("userpassword in", values, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordNotIn(List<String> values) {
            addCriterion("userpassword not in", values, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordBetween(String value1, String value2) {
            addCriterion("userpassword between", value1, value2, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordNotBetween(String value1, String value2) {
            addCriterion("userpassword not between", value1, value2, "userpassword");
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

        public Criteria andIconIsNull() {
            addCriterion("icon is null");
            return (Criteria) this;
        }

        public Criteria andIconIsNotNull() {
            addCriterion("icon is not null");
            return (Criteria) this;
        }

        public Criteria andIconEqualTo(String value) {
            addCriterion("icon =", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotEqualTo(String value) {
            addCriterion("icon <>", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThan(String value) {
            addCriterion("icon >", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThanOrEqualTo(String value) {
            addCriterion("icon >=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThan(String value) {
            addCriterion("icon <", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThanOrEqualTo(String value) {
            addCriterion("icon <=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLike(String value) {
            addCriterion("icon like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotLike(String value) {
            addCriterion("icon not like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconIn(List<String> values) {
            addCriterion("icon in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotIn(List<String> values) {
            addCriterion("icon not in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconBetween(String value1, String value2) {
            addCriterion("icon between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotBetween(String value1, String value2) {
            addCriterion("icon not between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andOutundonenumIsNull() {
            addCriterion("outundonenum is null");
            return (Criteria) this;
        }

        public Criteria andOutundonenumIsNotNull() {
            addCriterion("outundonenum is not null");
            return (Criteria) this;
        }

        public Criteria andOutundonenumEqualTo(Integer value) {
            addCriterion("outundonenum =", value, "outundonenum");
            return (Criteria) this;
        }

        public Criteria andOutundonenumNotEqualTo(Integer value) {
            addCriterion("outundonenum <>", value, "outundonenum");
            return (Criteria) this;
        }

        public Criteria andOutundonenumGreaterThan(Integer value) {
            addCriterion("outundonenum >", value, "outundonenum");
            return (Criteria) this;
        }

        public Criteria andOutundonenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("outundonenum >=", value, "outundonenum");
            return (Criteria) this;
        }

        public Criteria andOutundonenumLessThan(Integer value) {
            addCriterion("outundonenum <", value, "outundonenum");
            return (Criteria) this;
        }

        public Criteria andOutundonenumLessThanOrEqualTo(Integer value) {
            addCriterion("outundonenum <=", value, "outundonenum");
            return (Criteria) this;
        }

        public Criteria andOutundonenumIn(List<Integer> values) {
            addCriterion("outundonenum in", values, "outundonenum");
            return (Criteria) this;
        }

        public Criteria andOutundonenumNotIn(List<Integer> values) {
            addCriterion("outundonenum not in", values, "outundonenum");
            return (Criteria) this;
        }

        public Criteria andOutundonenumBetween(Integer value1, Integer value2) {
            addCriterion("outundonenum between", value1, value2, "outundonenum");
            return (Criteria) this;
        }

        public Criteria andOutundonenumNotBetween(Integer value1, Integer value2) {
            addCriterion("outundonenum not between", value1, value2, "outundonenum");
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

        public Criteria andInundomenumIsNull() {
            addCriterion("inundomenum is null");
            return (Criteria) this;
        }

        public Criteria andInundomenumIsNotNull() {
            addCriterion("inundomenum is not null");
            return (Criteria) this;
        }

        public Criteria andInundomenumEqualTo(Integer value) {
            addCriterion("inundomenum =", value, "inundomenum");
            return (Criteria) this;
        }

        public Criteria andInundomenumNotEqualTo(Integer value) {
            addCriterion("inundomenum <>", value, "inundomenum");
            return (Criteria) this;
        }

        public Criteria andInundomenumGreaterThan(Integer value) {
            addCriterion("inundomenum >", value, "inundomenum");
            return (Criteria) this;
        }

        public Criteria andInundomenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("inundomenum >=", value, "inundomenum");
            return (Criteria) this;
        }

        public Criteria andInundomenumLessThan(Integer value) {
            addCriterion("inundomenum <", value, "inundomenum");
            return (Criteria) this;
        }

        public Criteria andInundomenumLessThanOrEqualTo(Integer value) {
            addCriterion("inundomenum <=", value, "inundomenum");
            return (Criteria) this;
        }

        public Criteria andInundomenumIn(List<Integer> values) {
            addCriterion("inundomenum in", values, "inundomenum");
            return (Criteria) this;
        }

        public Criteria andInundomenumNotIn(List<Integer> values) {
            addCriterion("inundomenum not in", values, "inundomenum");
            return (Criteria) this;
        }

        public Criteria andInundomenumBetween(Integer value1, Integer value2) {
            addCriterion("inundomenum between", value1, value2, "inundomenum");
            return (Criteria) this;
        }

        public Criteria andInundomenumNotBetween(Integer value1, Integer value2) {
            addCriterion("inundomenum not between", value1, value2, "inundomenum");
            return (Criteria) this;
        }

        public Criteria andFuturenumIsNull() {
            addCriterion("futurenum is null");
            return (Criteria) this;
        }

        public Criteria andFuturenumIsNotNull() {
            addCriterion("futurenum is not null");
            return (Criteria) this;
        }

        public Criteria andFuturenumEqualTo(Integer value) {
            addCriterion("futurenum =", value, "futurenum");
            return (Criteria) this;
        }

        public Criteria andFuturenumNotEqualTo(Integer value) {
            addCriterion("futurenum <>", value, "futurenum");
            return (Criteria) this;
        }

        public Criteria andFuturenumGreaterThan(Integer value) {
            addCriterion("futurenum >", value, "futurenum");
            return (Criteria) this;
        }

        public Criteria andFuturenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("futurenum >=", value, "futurenum");
            return (Criteria) this;
        }

        public Criteria andFuturenumLessThan(Integer value) {
            addCriterion("futurenum <", value, "futurenum");
            return (Criteria) this;
        }

        public Criteria andFuturenumLessThanOrEqualTo(Integer value) {
            addCriterion("futurenum <=", value, "futurenum");
            return (Criteria) this;
        }

        public Criteria andFuturenumIn(List<Integer> values) {
            addCriterion("futurenum in", values, "futurenum");
            return (Criteria) this;
        }

        public Criteria andFuturenumNotIn(List<Integer> values) {
            addCriterion("futurenum not in", values, "futurenum");
            return (Criteria) this;
        }

        public Criteria andFuturenumBetween(Integer value1, Integer value2) {
            addCriterion("futurenum between", value1, value2, "futurenum");
            return (Criteria) this;
        }

        public Criteria andFuturenumNotBetween(Integer value1, Integer value2) {
            addCriterion("futurenum not between", value1, value2, "futurenum");
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