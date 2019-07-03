package Entity;

import java.util.ArrayList;
import java.util.List;

public class LoveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LoveExample() {
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

        public Criteria andLoveidIsNull() {
            addCriterion("loveId is null");
            return (Criteria) this;
        }

        public Criteria andLoveidIsNotNull() {
            addCriterion("loveId is not null");
            return (Criteria) this;
        }

        public Criteria andLoveidEqualTo(String value) {
            addCriterion("loveId =", value, "loveid");
            return (Criteria) this;
        }

        public Criteria andLoveidNotEqualTo(String value) {
            addCriterion("loveId <>", value, "loveid");
            return (Criteria) this;
        }

        public Criteria andLoveidGreaterThan(String value) {
            addCriterion("loveId >", value, "loveid");
            return (Criteria) this;
        }

        public Criteria andLoveidGreaterThanOrEqualTo(String value) {
            addCriterion("loveId >=", value, "loveid");
            return (Criteria) this;
        }

        public Criteria andLoveidLessThan(String value) {
            addCriterion("loveId <", value, "loveid");
            return (Criteria) this;
        }

        public Criteria andLoveidLessThanOrEqualTo(String value) {
            addCriterion("loveId <=", value, "loveid");
            return (Criteria) this;
        }

        public Criteria andLoveidLike(String value) {
            addCriterion("loveId like", value, "loveid");
            return (Criteria) this;
        }

        public Criteria andLoveidNotLike(String value) {
            addCriterion("loveId not like", value, "loveid");
            return (Criteria) this;
        }

        public Criteria andLoveidIn(List<String> values) {
            addCriterion("loveId in", values, "loveid");
            return (Criteria) this;
        }

        public Criteria andLoveidNotIn(List<String> values) {
            addCriterion("loveId not in", values, "loveid");
            return (Criteria) this;
        }

        public Criteria andLoveidBetween(String value1, String value2) {
            addCriterion("loveId between", value1, value2, "loveid");
            return (Criteria) this;
        }

        public Criteria andLoveidNotBetween(String value1, String value2) {
            addCriterion("loveId not between", value1, value2, "loveid");
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

        public Criteria andMoviesIsNull() {
            addCriterion("movies is null");
            return (Criteria) this;
        }

        public Criteria andMoviesIsNotNull() {
            addCriterion("movies is not null");
            return (Criteria) this;
        }

        public Criteria andMoviesEqualTo(String value) {
            addCriterion("movies =", value, "movies");
            return (Criteria) this;
        }

        public Criteria andMoviesNotEqualTo(String value) {
            addCriterion("movies <>", value, "movies");
            return (Criteria) this;
        }

        public Criteria andMoviesGreaterThan(String value) {
            addCriterion("movies >", value, "movies");
            return (Criteria) this;
        }

        public Criteria andMoviesGreaterThanOrEqualTo(String value) {
            addCriterion("movies >=", value, "movies");
            return (Criteria) this;
        }

        public Criteria andMoviesLessThan(String value) {
            addCriterion("movies <", value, "movies");
            return (Criteria) this;
        }

        public Criteria andMoviesLessThanOrEqualTo(String value) {
            addCriterion("movies <=", value, "movies");
            return (Criteria) this;
        }

        public Criteria andMoviesLike(String value) {
            addCriterion("movies like", value, "movies");
            return (Criteria) this;
        }

        public Criteria andMoviesNotLike(String value) {
            addCriterion("movies not like", value, "movies");
            return (Criteria) this;
        }

        public Criteria andMoviesIn(List<String> values) {
            addCriterion("movies in", values, "movies");
            return (Criteria) this;
        }

        public Criteria andMoviesNotIn(List<String> values) {
            addCriterion("movies not in", values, "movies");
            return (Criteria) this;
        }

        public Criteria andMoviesBetween(String value1, String value2) {
            addCriterion("movies between", value1, value2, "movies");
            return (Criteria) this;
        }

        public Criteria andMoviesNotBetween(String value1, String value2) {
            addCriterion("movies not between", value1, value2, "movies");
            return (Criteria) this;
        }

        public Criteria andUserIsNull() {
            addCriterion("user is null");
            return (Criteria) this;
        }

        public Criteria andUserIsNotNull() {
            addCriterion("user is not null");
            return (Criteria) this;
        }

        public Criteria andUserEqualTo(String value) {
            addCriterion("user =", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotEqualTo(String value) {
            addCriterion("user <>", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserGreaterThan(String value) {
            addCriterion("user >", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserGreaterThanOrEqualTo(String value) {
            addCriterion("user >=", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLessThan(String value) {
            addCriterion("user <", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLessThanOrEqualTo(String value) {
            addCriterion("user <=", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLike(String value) {
            addCriterion("user like", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotLike(String value) {
            addCriterion("user not like", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserIn(List<String> values) {
            addCriterion("user in", values, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotIn(List<String> values) {
            addCriterion("user not in", values, "user");
            return (Criteria) this;
        }

        public Criteria andUserBetween(String value1, String value2) {
            addCriterion("user between", value1, value2, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotBetween(String value1, String value2) {
            addCriterion("user not between", value1, value2, "user");
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