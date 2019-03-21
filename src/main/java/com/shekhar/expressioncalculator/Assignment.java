package com.shekhar.expressioncalculator;

import java.util.Map;

class Assignment extends Expression {
    Assignment(Expression left, Operator operator, Expression right) {
        super(left, operator, right);
    }

    @Override
    void setData(Map<String, Object> data) {
        this.data = right.data;
        data.put(left.key, this.data);
    }
}
