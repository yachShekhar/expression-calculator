package com.shekhar.expressioncalculator;

import java.math.BigDecimal;
import java.util.Map;

class Multiplication extends Expression {
    Multiplication(Expression left, Operator operator, Expression right) {
        super(left, operator, right);
    }

    @Override
    void setData(Map<String, BigDecimal> data) {
        this.data = left.data.multiply(right.data);
    }
}
