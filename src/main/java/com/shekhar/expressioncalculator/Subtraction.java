package com.shekhar.expressioncalculator;

import java.util.Map;

class Subtraction extends Expression{
    Subtraction(Expression left, Operator operator, Expression right) {
        super(left, operator, right);
    }

    @Override
    void setData(Map<String, Object> data) {
        this.data = left.data.subtract(right.data);
    }
}
