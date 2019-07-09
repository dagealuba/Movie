package Entity;

import java.util.ArrayList;
import java.util.List;

public class MovieExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MovieExample() {
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

        public Criteria andMovieidIsNull() {
            addCriterion("movieId is null");
            return (Criteria) this;
        }

        public Criteria andMovieidIsNotNull() {
            addCriterion("movieId is not null");
            return (Criteria) this;
        }

        public Criteria andMovieidEqualTo(String value) {
            addCriterion("movieId =", value, "movieid");
            return (Criteria) this;
        }

        public Criteria andMovieidNotEqualTo(String value) {
            addCriterion("movieId <>", value, "movieid");
            return (Criteria) this;
        }

        public Criteria andMovieidGreaterThan(String value) {
            addCriterion("movieId >", value, "movieid");
            return (Criteria) this;
        }

        public Criteria andMovieidGreaterThanOrEqualTo(String value) {
            addCriterion("movieId >=", value, "movieid");
            return (Criteria) this;
        }

        public Criteria andMovieidLessThan(String value) {
            addCriterion("movieId <", value, "movieid");
            return (Criteria) this;
        }

        public Criteria andMovieidLessThanOrEqualTo(String value) {
            addCriterion("movieId <=", value, "movieid");
            return (Criteria) this;
        }

        public Criteria andMovieidLike(String value) {
            addCriterion("movieId like", value, "movieid");
            return (Criteria) this;
        }

        public Criteria andMovieidNotLike(String value) {
            addCriterion("movieId not like", value, "movieid");
            return (Criteria) this;
        }

        public Criteria andMovieidIn(List<String> values) {
            addCriterion("movieId in", values, "movieid");
            return (Criteria) this;
        }

        public Criteria andMovieidNotIn(List<String> values) {
            addCriterion("movieId not in", values, "movieid");
            return (Criteria) this;
        }

        public Criteria andMovieidBetween(String value1, String value2) {
            addCriterion("movieId between", value1, value2, "movieid");
            return (Criteria) this;
        }

        public Criteria andMovieidNotBetween(String value1, String value2) {
            addCriterion("movieId not between", value1, value2, "movieid");
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

        public Criteria andLeadingCreatorIsNull() {
            addCriterion("leading_creator is null");
            return (Criteria) this;
        }

        public Criteria andLeadingCreatorIsNotNull() {
            addCriterion("leading_creator is not null");
            return (Criteria) this;
        }

        public Criteria andLeadingCreatorEqualTo(String value) {
            addCriterion("leading_creator =", value, "leadingCreator");
            return (Criteria) this;
        }

        public Criteria andLeadingCreatorNotEqualTo(String value) {
            addCriterion("leading_creator <>", value, "leadingCreator");
            return (Criteria) this;
        }

        public Criteria andLeadingCreatorGreaterThan(String value) {
            addCriterion("leading_creator >", value, "leadingCreator");
            return (Criteria) this;
        }

        public Criteria andLeadingCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("leading_creator >=", value, "leadingCreator");
            return (Criteria) this;
        }

        public Criteria andLeadingCreatorLessThan(String value) {
            addCriterion("leading_creator <", value, "leadingCreator");
            return (Criteria) this;
        }

        public Criteria andLeadingCreatorLessThanOrEqualTo(String value) {
            addCriterion("leading_creator <=", value, "leadingCreator");
            return (Criteria) this;
        }

        public Criteria andLeadingCreatorLike(String value) {
            addCriterion("leading_creator like", value, "leadingCreator");
            return (Criteria) this;
        }

        public Criteria andLeadingCreatorNotLike(String value) {
            addCriterion("leading_creator not like", value, "leadingCreator");
            return (Criteria) this;
        }

        public Criteria andLeadingCreatorIn(List<String> values) {
            addCriterion("leading_creator in", values, "leadingCreator");
            return (Criteria) this;
        }

        public Criteria andLeadingCreatorNotIn(List<String> values) {
            addCriterion("leading_creator not in", values, "leadingCreator");
            return (Criteria) this;
        }

        public Criteria andLeadingCreatorBetween(String value1, String value2) {
            addCriterion("leading_creator between", value1, value2, "leadingCreator");
            return (Criteria) this;
        }

        public Criteria andLeadingCreatorNotBetween(String value1, String value2) {
            addCriterion("leading_creator not between", value1, value2, "leadingCreator");
            return (Criteria) this;
        }

        public Criteria andCoverIsNull() {
            addCriterion("cover is null");
            return (Criteria) this;
        }

        public Criteria andCoverIsNotNull() {
            addCriterion("cover is not null");
            return (Criteria) this;
        }

        public Criteria andCoverEqualTo(String value) {
            addCriterion("cover =", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotEqualTo(String value) {
            addCriterion("cover <>", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverGreaterThan(String value) {
            addCriterion("cover >", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverGreaterThanOrEqualTo(String value) {
            addCriterion("cover >=", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverLessThan(String value) {
            addCriterion("cover <", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverLessThanOrEqualTo(String value) {
            addCriterion("cover <=", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverLike(String value) {
            addCriterion("cover like", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotLike(String value) {
            addCriterion("cover not like", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverIn(List<String> values) {
            addCriterion("cover in", values, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotIn(List<String> values) {
            addCriterion("cover not in", values, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverBetween(String value1, String value2) {
            addCriterion("cover between", value1, value2, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotBetween(String value1, String value2) {
            addCriterion("cover not between", value1, value2, "cover");
            return (Criteria) this;
        }

        public Criteria andStillsIsNull() {
            addCriterion("stills is null");
            return (Criteria) this;
        }

        public Criteria andStillsIsNotNull() {
            addCriterion("stills is not null");
            return (Criteria) this;
        }

        public Criteria andStillsEqualTo(String value) {
            addCriterion("stills =", value, "stills");
            return (Criteria) this;
        }

        public Criteria andStillsNotEqualTo(String value) {
            addCriterion("stills <>", value, "stills");
            return (Criteria) this;
        }

        public Criteria andStillsGreaterThan(String value) {
            addCriterion("stills >", value, "stills");
            return (Criteria) this;
        }

        public Criteria andStillsGreaterThanOrEqualTo(String value) {
            addCriterion("stills >=", value, "stills");
            return (Criteria) this;
        }

        public Criteria andStillsLessThan(String value) {
            addCriterion("stills <", value, "stills");
            return (Criteria) this;
        }

        public Criteria andStillsLessThanOrEqualTo(String value) {
            addCriterion("stills <=", value, "stills");
            return (Criteria) this;
        }

        public Criteria andStillsLike(String value) {
            addCriterion("stills like", value, "stills");
            return (Criteria) this;
        }

        public Criteria andStillsNotLike(String value) {
            addCriterion("stills not like", value, "stills");
            return (Criteria) this;
        }

        public Criteria andStillsIn(List<String> values) {
            addCriterion("stills in", values, "stills");
            return (Criteria) this;
        }

        public Criteria andStillsNotIn(List<String> values) {
            addCriterion("stills not in", values, "stills");
            return (Criteria) this;
        }

        public Criteria andStillsBetween(String value1, String value2) {
            addCriterion("stills between", value1, value2, "stills");
            return (Criteria) this;
        }

        public Criteria andStillsNotBetween(String value1, String value2) {
            addCriterion("stills not between", value1, value2, "stills");
            return (Criteria) this;
        }

        public Criteria andReleaseDateIsNull() {
            addCriterion("release_date is null");
            return (Criteria) this;
        }

        public Criteria andReleaseDateIsNotNull() {
            addCriterion("release_date is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseDateEqualTo(String value) {
            addCriterion("release_date =", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateNotEqualTo(String value) {
            addCriterion("release_date <>", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateGreaterThan(String value) {
            addCriterion("release_date >", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateGreaterThanOrEqualTo(String value) {
            addCriterion("release_date >=", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateLessThan(String value) {
            addCriterion("release_date <", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateLessThanOrEqualTo(String value) {
            addCriterion("release_date <=", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateLike(String value) {
            addCriterion("release_date like", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateNotLike(String value) {
            addCriterion("release_date not like", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateIn(List<String> values) {
            addCriterion("release_date in", values, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateNotIn(List<String> values) {
            addCriterion("release_date not in", values, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateBetween(String value1, String value2) {
            addCriterion("release_date between", value1, value2, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateNotBetween(String value1, String value2) {
            addCriterion("release_date not between", value1, value2, "releaseDate");
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

        public Criteria andTimeEqualTo(String value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(String value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(String value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(String value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(String value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(String value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLike(String value) {
            addCriterion("time like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotLike(String value) {
            addCriterion("time not like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<String> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<String> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(String value1, String value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(String value1, String value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(Float value) {
            addCriterion("grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(Float value) {
            addCriterion("grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(Float value) {
            addCriterion("grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(Float value) {
            addCriterion("grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(Float value) {
            addCriterion("grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(Float value) {
            addCriterion("grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<Float> values) {
            addCriterion("grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<Float> values) {
            addCriterion("grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(Float value1, Float value2) {
            addCriterion("grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(Float value1, Float value2) {
            addCriterion("grade not between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradenumIsNull() {
            addCriterion("gradeNum is null");
            return (Criteria) this;
        }

        public Criteria andGradenumIsNotNull() {
            addCriterion("gradeNum is not null");
            return (Criteria) this;
        }

        public Criteria andGradenumEqualTo(Integer value) {
            addCriterion("gradeNum =", value, "gradenum");
            return (Criteria) this;
        }

        public Criteria andGradenumNotEqualTo(Integer value) {
            addCriterion("gradeNum <>", value, "gradenum");
            return (Criteria) this;
        }

        public Criteria andGradenumGreaterThan(Integer value) {
            addCriterion("gradeNum >", value, "gradenum");
            return (Criteria) this;
        }

        public Criteria andGradenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("gradeNum >=", value, "gradenum");
            return (Criteria) this;
        }

        public Criteria andGradenumLessThan(Integer value) {
            addCriterion("gradeNum <", value, "gradenum");
            return (Criteria) this;
        }

        public Criteria andGradenumLessThanOrEqualTo(Integer value) {
            addCriterion("gradeNum <=", value, "gradenum");
            return (Criteria) this;
        }

        public Criteria andGradenumIn(List<Integer> values) {
            addCriterion("gradeNum in", values, "gradenum");
            return (Criteria) this;
        }

        public Criteria andGradenumNotIn(List<Integer> values) {
            addCriterion("gradeNum not in", values, "gradenum");
            return (Criteria) this;
        }

        public Criteria andGradenumBetween(Integer value1, Integer value2) {
            addCriterion("gradeNum between", value1, value2, "gradenum");
            return (Criteria) this;
        }

        public Criteria andGradenumNotBetween(Integer value1, Integer value2) {
            addCriterion("gradeNum not between", value1, value2, "gradenum");
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