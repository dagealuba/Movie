package Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageExample() {
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

        public Criteria andMessageidIsNull() {
            addCriterion("messageId is null");
            return (Criteria) this;
        }

        public Criteria andMessageidIsNotNull() {
            addCriterion("messageId is not null");
            return (Criteria) this;
        }

        public Criteria andMessageidEqualTo(String value) {
            addCriterion("messageId =", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidNotEqualTo(String value) {
            addCriterion("messageId <>", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidGreaterThan(String value) {
            addCriterion("messageId >", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidGreaterThanOrEqualTo(String value) {
            addCriterion("messageId >=", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidLessThan(String value) {
            addCriterion("messageId <", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidLessThanOrEqualTo(String value) {
            addCriterion("messageId <=", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidLike(String value) {
            addCriterion("messageId like", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidNotLike(String value) {
            addCriterion("messageId not like", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidIn(List<String> values) {
            addCriterion("messageId in", values, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidNotIn(List<String> values) {
            addCriterion("messageId not in", values, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidBetween(String value1, String value2) {
            addCriterion("messageId between", value1, value2, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidNotBetween(String value1, String value2) {
            addCriterion("messageId not between", value1, value2, "messageid");
            return (Criteria) this;
        }

        public Criteria andSenderidIsNull() {
            addCriterion("senderId is null");
            return (Criteria) this;
        }

        public Criteria andSenderidIsNotNull() {
            addCriterion("senderId is not null");
            return (Criteria) this;
        }

        public Criteria andSenderidEqualTo(String value) {
            addCriterion("senderId =", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidNotEqualTo(String value) {
            addCriterion("senderId <>", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidGreaterThan(String value) {
            addCriterion("senderId >", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidGreaterThanOrEqualTo(String value) {
            addCriterion("senderId >=", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidLessThan(String value) {
            addCriterion("senderId <", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidLessThanOrEqualTo(String value) {
            addCriterion("senderId <=", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidLike(String value) {
            addCriterion("senderId like", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidNotLike(String value) {
            addCriterion("senderId not like", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidIn(List<String> values) {
            addCriterion("senderId in", values, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidNotIn(List<String> values) {
            addCriterion("senderId not in", values, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidBetween(String value1, String value2) {
            addCriterion("senderId between", value1, value2, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidNotBetween(String value1, String value2) {
            addCriterion("senderId not between", value1, value2, "senderid");
            return (Criteria) this;
        }

        public Criteria andReceiveridIsNull() {
            addCriterion("receiverId is null");
            return (Criteria) this;
        }

        public Criteria andReceiveridIsNotNull() {
            addCriterion("receiverId is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveridEqualTo(String value) {
            addCriterion("receiverId =", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridNotEqualTo(String value) {
            addCriterion("receiverId <>", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridGreaterThan(String value) {
            addCriterion("receiverId >", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridGreaterThanOrEqualTo(String value) {
            addCriterion("receiverId >=", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridLessThan(String value) {
            addCriterion("receiverId <", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridLessThanOrEqualTo(String value) {
            addCriterion("receiverId <=", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridLike(String value) {
            addCriterion("receiverId like", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridNotLike(String value) {
            addCriterion("receiverId not like", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridIn(List<String> values) {
            addCriterion("receiverId in", values, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridNotIn(List<String> values) {
            addCriterion("receiverId not in", values, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridBetween(String value1, String value2) {
            addCriterion("receiverId between", value1, value2, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridNotBetween(String value1, String value2) {
            addCriterion("receiverId not between", value1, value2, "receiverid");
            return (Criteria) this;
        }

        public Criteria andMessagetextIsNull() {
            addCriterion("messageText is null");
            return (Criteria) this;
        }

        public Criteria andMessagetextIsNotNull() {
            addCriterion("messageText is not null");
            return (Criteria) this;
        }

        public Criteria andMessagetextEqualTo(String value) {
            addCriterion("messageText =", value, "messagetext");
            return (Criteria) this;
        }

        public Criteria andMessagetextNotEqualTo(String value) {
            addCriterion("messageText <>", value, "messagetext");
            return (Criteria) this;
        }

        public Criteria andMessagetextGreaterThan(String value) {
            addCriterion("messageText >", value, "messagetext");
            return (Criteria) this;
        }

        public Criteria andMessagetextGreaterThanOrEqualTo(String value) {
            addCriterion("messageText >=", value, "messagetext");
            return (Criteria) this;
        }

        public Criteria andMessagetextLessThan(String value) {
            addCriterion("messageText <", value, "messagetext");
            return (Criteria) this;
        }

        public Criteria andMessagetextLessThanOrEqualTo(String value) {
            addCriterion("messageText <=", value, "messagetext");
            return (Criteria) this;
        }

        public Criteria andMessagetextLike(String value) {
            addCriterion("messageText like", value, "messagetext");
            return (Criteria) this;
        }

        public Criteria andMessagetextNotLike(String value) {
            addCriterion("messageText not like", value, "messagetext");
            return (Criteria) this;
        }

        public Criteria andMessagetextIn(List<String> values) {
            addCriterion("messageText in", values, "messagetext");
            return (Criteria) this;
        }

        public Criteria andMessagetextNotIn(List<String> values) {
            addCriterion("messageText not in", values, "messagetext");
            return (Criteria) this;
        }

        public Criteria andMessagetextBetween(String value1, String value2) {
            addCriterion("messageText between", value1, value2, "messagetext");
            return (Criteria) this;
        }

        public Criteria andMessagetextNotBetween(String value1, String value2) {
            addCriterion("messageText not between", value1, value2, "messagetext");
            return (Criteria) this;
        }

        public Criteria andMessagedateIsNull() {
            addCriterion("messageDate is null");
            return (Criteria) this;
        }

        public Criteria andMessagedateIsNotNull() {
            addCriterion("messageDate is not null");
            return (Criteria) this;
        }

        public Criteria andMessagedateEqualTo(Date value) {
            addCriterion("messageDate =", value, "messagedate");
            return (Criteria) this;
        }

        public Criteria andMessagedateNotEqualTo(Date value) {
            addCriterion("messageDate <>", value, "messagedate");
            return (Criteria) this;
        }

        public Criteria andMessagedateGreaterThan(Date value) {
            addCriterion("messageDate >", value, "messagedate");
            return (Criteria) this;
        }

        public Criteria andMessagedateGreaterThanOrEqualTo(Date value) {
            addCriterion("messageDate >=", value, "messagedate");
            return (Criteria) this;
        }

        public Criteria andMessagedateLessThan(Date value) {
            addCriterion("messageDate <", value, "messagedate");
            return (Criteria) this;
        }

        public Criteria andMessagedateLessThanOrEqualTo(Date value) {
            addCriterion("messageDate <=", value, "messagedate");
            return (Criteria) this;
        }

        public Criteria andMessagedateIn(List<Date> values) {
            addCriterion("messageDate in", values, "messagedate");
            return (Criteria) this;
        }

        public Criteria andMessagedateNotIn(List<Date> values) {
            addCriterion("messageDate not in", values, "messagedate");
            return (Criteria) this;
        }

        public Criteria andMessagedateBetween(Date value1, Date value2) {
            addCriterion("messageDate between", value1, value2, "messagedate");
            return (Criteria) this;
        }

        public Criteria andMessagedateNotBetween(Date value1, Date value2) {
            addCriterion("messageDate not between", value1, value2, "messagedate");
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