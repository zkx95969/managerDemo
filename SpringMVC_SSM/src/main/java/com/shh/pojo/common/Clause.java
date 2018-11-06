package com.shh.pojo.common;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :         wujun
 * @version :        1.0
 * @description :
 * @date :     2018/11/6 10:10
 */
@Repository("clause")
public class Clause implements Serializable {

    public Clause(){}
    public Clause(Page page){
        int index = page.getPageIndex()>0?page.getPageIndex():1;
        int size = page.getPageSize()>0?page.getPageSize():10;

        if(page!=null){
            this.limit = "limit "+ (index-1)*size+","+size;
        }
    }

    private static final long serialVersionUID = -7674861624566697790L;
    protected String whereClause;
    protected String orderByClause;
    protected List<Criteria> oredCriteria;
    private String colClause;
    private String colName;
    private String colValue;
    private String colValue2;
    private String limit;

    public void andWhereClause(String whereClause) {
        if (StringUtils.isBlank(this.whereClause)){
            this.whereClause = whereClause;
            oredCriteria = new ArrayList<Criteria>();
            this.getAndCriteria().addCriterion(whereClause);
        }else{
            this.whereClause += " AND " + whereClause;
            this.getAndCriteria().addCriterion(whereClause);
        }
    }

    public void orWhereClause(String whereClause) {
        if (StringUtils.isBlank(this.whereClause)){
            throw new RuntimeException("or子句不可加入空WhereClause");
        }else{
            this.whereClause += " OR " + whereClause;
            this.getOrCriteria().addCriterion(whereClause);
        }
    }

    public void andWhereClause(String condition, Object value) {
        if (StringUtils.isBlank(this.whereClause)){
            this.whereClause = condition + value;
            oredCriteria = new ArrayList<Criteria>();
            this.getAndCriteria().addCriterion(condition,value,null);
        }else{
            this.whereClause += " AND " + whereClause;
            this.getAndCriteria().addCriterion(condition,value,null);
        }
    }

    public void andWhereClause(String condition, Object value1, Object value2) {
        if (StringUtils.isBlank(this.whereClause)){
            this.whereClause = condition + value1 + " and "+value2;
            oredCriteria = new ArrayList<Criteria>();
            this.getAndCriteria().addCriterion(condition,value1,value2,null);
        }else{
            this.whereClause += " AND " + whereClause;
            this.getAndCriteria().addCriterion(condition,value1,value2,null);
        }
    }

    protected Criteria getAndCriteria() {
        if (oredCriteria.size() == 0) {
            Criteria criteria = new Criteria();
            oredCriteria.add(criteria);
            return criteria;
        }else{
            return oredCriteria.get(0);
        }
    }

    protected Criteria getOrCriteria() {
        Criteria criteria = new Criteria();
        oredCriteria.add(criteria);
        return criteria;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public void setOrderByClause(String orderField,String orderType,String orderDefault) {
        if (StringUtils.isNotBlank(orderField)){
            if (StringUtils.isNotBlank(orderType)){
                this.orderByClause = orderField +" "+orderType;
            }else{
                this.orderByClause = orderField;
            }
        }else{
            this.orderByClause = orderDefault;
        }
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /*  public void or(Criteria criteria) {
            oredCriteria.add(criteria);
        }

        public Criteria or() {
            Criteria criteria = createCriteriaInternal();
            oredCriteria.add(criteria);
            return criteria;
        }

        protected Criteria createCriteria() {
            Criteria criteria = new Criteria();
            if (oredCriteria.size() == 0) {
                oredCriteria.add(criteria);
            }
            return criteria;
        }

        protected Criteria createCriteriaInternal() {
            Criteria criteria = new Criteria();
            return criteria;
        }
    */
    public void clear() {
        if(oredCriteria!=null){
            oredCriteria.clear();
        }
        orderByClause = null;
        whereClause = null;
        colClause = null;
        colName = null;
        colValue = null;
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
                throw new RuntimeException("参数不可为空");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("参数不可为空");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
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

    //======================
    public String getWhereClause() {
        return whereClause;
    }
    public String getColName() {
        return colName;
    }
    public void setColName(String colName) {
        this.colName = colName;
    }
    public String getColValue() {
        return colValue;
    }
    public void setColValue(String colValue) {
        this.colValue = colValue;
    }
    public String getColClause() {
        return colClause;
    }
    public void setColClause(String colClause) {
        this.colClause = colClause;
    }

    public String getColValue2() {
        return colValue2;
    }

    public void setColValue2(String colValue2) {
        this.colValue2 = colValue2;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }
}
