package com.shekhar.expressioncalculator;

import java.util.Map;

class Multiplication extends Expression {
    Multiplication(Expression left, Operator operator, Expression right) {
        super(left, operator, right);
    }

    @Override
    void setData(Map<String, Object> data) {
        this.data = left.data.multiply(right.data);
    }
}
