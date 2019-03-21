package com.shekhar.expressioncalculator;

import java.math.RoundingMode;
import java.util.Map;

class Division extends Expression{

    Division(Expression left, Operator operator, Expression right) {
        super(left, operator, right);
    }

    @Override
    void setData(Map<String, Object> data) {
        this.data = left.data.divide(right.data, RoundingMode.HALF_UP);
    }
}
