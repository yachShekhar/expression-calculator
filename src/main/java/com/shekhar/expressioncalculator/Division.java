package com.shekhar.expressioncalculator;

import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Map;

class Division extends Expression{
    private static final MathContext MATH_CONTEXT = new MathContext(2, RoundingMode.HALF_UP);
    Division(Expression left, Operator operator, Expression right) {
        super(left, operator, right);
    }

    @Override
    void setData(Map<String, Object> data) {
        this.data = left.data.divide(right.data, MATH_CONTEXT);
    }
}
