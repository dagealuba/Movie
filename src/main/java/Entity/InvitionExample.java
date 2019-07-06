package Entity;

import java.util.ArrayList;
import java.util.List;

public class InvitionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InvitionExample() {
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

        public Criteria andInviterIsNull() {
            addCriterion("inviter is null");
            return (Criteria) this;
        }

        public Criteria andInviterIsNotNull() {
            addCriterion("inviter is not null");
            return (Criteria) this;
        }

        public Criteria andInviterEqualTo(String value) {
            addCriterion("inviter =", value, "inviter");
            return (Criteria) this;
        }

        public Criteria andInviterNotEqualTo(String value) {
            addCriterion("inviter <>", value, "inviter");
            return (Criteria) this;
        }

        public Criteria andInviterGreaterThan(String value) {
            addCriterion("inviter >", value, "inviter");
            return (Criteria) this;
        }

        public Criteria andInviterGreaterThanOrEqualTo(String value) {
            addCriterion("inviter >=", value, "inviter");
            return (Criteria) this;
        }

        public Criteria andInviterLessThan(String value) {
            addCriterion("inviter <", value, "inviter");
            return (Criteria) this;
        }

        public Criteria andInviterLessThanOrEqualTo(String value) {
            addCriterion("inviter <=", value, "inviter");
            return (Criteria) this;
        }

        public Criteria andInviterLike(String value) {
            addCriterion("inviter like", value, "inviter");
            return (Criteria) this;
        }

        public Criteria andInviterNotLike(String value) {
            addCriterion("inviter not like", value, "inviter");
            return (Criteria) this;
        }

        public Criteria andInviterIn(List<String> values) {
            addCriterion("inviter in", values, "inviter");
            return (Criteria) this;
        }

        public Criteria andInviterNotIn(List<String> values) {
            addCriterion("inviter not in", values, "inviter");
            return (Criteria) this;
        }

        public Criteria andInviterBetween(String value1, String value2) {
            addCriterion("inviter between", value1, value2, "inviter");
            return (Criteria) this;
        }

        public Criteria andInviterNotBetween(String value1, String value2) {
            addCriterion("inviter not between", value1, value2, "inviter");
            return (Criteria) this;
        }

        public Criteria andInviteeIsNull() {
            addCriterion("invitee is null");
            return (Criteria) this;
        }

        public Criteria andInviteeIsNotNull() {
            addCriterion("invitee is not null");
            return (Criteria) this;
        }

        public Criteria andInviteeEqualTo(String value) {
            addCriterion("invitee =", value, "invitee");
            return (Criteria) this;
        }

        public Criteria andInviteeNotEqualTo(String value) {
            addCriterion("invitee <>", value, "invitee");
            return (Criteria) this;
        }

        public Criteria andInviteeGreaterThan(String value) {
            addCriterion("invitee >", value, "invitee");
            return (Criteria) this;
        }

        public Criteria andInviteeGreaterThanOrEqualTo(String value) {
            addCriterion("invitee >=", value, "invitee");
            return (Criteria) this;
        }

        public Criteria andInviteeLessThan(String value) {
            addCriterion("invitee <", value, "invitee");
            return (Criteria) this;
        }

        public Criteria andInviteeLessThanOrEqualTo(String value) {
            addCriterion("invitee <=", value, "invitee");
            return (Criteria) this;
        }

        public Criteria andInviteeLike(String value) {
            addCriterion("invitee like", value, "invitee");
            return (Criteria) this;
        }

        public Criteria andInviteeNotLike(String value) {
            addCriterion("invitee not like", value, "invitee");
            return (Criteria) this;
        }

        public Criteria andInviteeIn(List<String> values) {
            addCriterion("invitee in", values, "invitee");
            return (Criteria) this;
        }

        public Criteria andInviteeNotIn(List<String> values) {
            addCriterion("invitee not in", values, "invitee");
            return (Criteria) this;
        }

        public Criteria andInviteeBetween(String value1, String value2) {
            addCriterion("invitee between", value1, value2, "invitee");
            return (Criteria) this;
        }

        public Criteria andInviteeNotBetween(String value1, String value2) {
            addCriterion("invitee not between", value1, value2, "invitee");
            return (Criteria) this;
        }

        public Criteria andSpaceidIsNull() {
            addCriterion("spaceId is null");
            return (Criteria) this;
        }

        public Criteria andSpaceidIsNotNull() {
            addCriterion("spaceId is not null");
            return (Criteria) this;
        }

        public Criteria andSpaceidEqualTo(String value) {
            addCriterion("spaceId =", value, "spaceid");
            return (Criteria) this;
        }

        public Criteria andSpaceidNotEqualTo(String value) {
            addCriterion("spaceId <>", value, "spaceid");
            return (Criteria) this;
        }

        public Criteria andSpaceidGreaterThan(String value) {
            addCriterion("spaceId >", value, "spaceid");
            return (Criteria) this;
        }

        public Criteria andSpaceidGreaterThanOrEqualTo(String value) {
            addCriterion("spaceId >=", value, "spaceid");
            return (Criteria) this;
        }

        public Criteria andSpaceidLessThan(String value) {
            addCriterion("spaceId <", value, "spaceid");
            return (Criteria) this;
        }

        public Criteria andSpaceidLessThanOrEqualTo(String value) {
            addCriterion("spaceId <=", value, "spaceid");
            return (Criteria) this;
        }

        public Criteria andSpaceidLike(String value) {
            addCriterion("spaceId like", value, "spaceid");
            return (Criteria) this;
        }

        public Criteria andSpaceidNotLike(String value) {
            addCriterion("spaceId not like", value, "spaceid");
            return (Criteria) this;
        }

        public Criteria andSpaceidIn(List<String> values) {
            addCriterion("spaceId in", values, "spaceid");
            return (Criteria) this;
        }

        public Criteria andSpaceidNotIn(List<String> values) {
            addCriterion("spaceId not in", values, "spaceid");
            return (Criteria) this;
        }

        public Criteria andSpaceidBetween(String value1, String value2) {
            addCriterion("spaceId between", value1, value2, "spaceid");
            return (Criteria) this;
        }

        public Criteria andSpaceidNotBetween(String value1, String value2) {
            addCriterion("spaceId not between", value1, value2, "spaceid");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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