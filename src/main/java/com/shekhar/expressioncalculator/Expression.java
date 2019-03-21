package com.shekhar.expressioncalculator;

import java.math.BigDecimal;
import java.util.Map;

public abstract class Expression {
    protected Expression left;
    protected Expression right;
    protected Operator operator;
    protected String key;
    protected BigDecimal data;

    protected Expression(Operator operator, String key){
        this.operator = operator;
        this.key = key;
    }

    protected Expression(Expression left, Operator operator, Expression right){
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    abstract void setData(Map<String, Object> data);

    public BigDecimal getData(){
        return data;
    }

    public Expression evaluate(Map<String, Object> data){
        evaluate(this, data);
        return this;
    }

    private void evaluate(Expression expression, Map<String, Object> data){
        if(expression.left != null){
            evaluate(expression.left, data);
        }
        if(expression.right != null){
            evaluate(expression.right, data);
        }
        expression.setData(data);
    }
}
