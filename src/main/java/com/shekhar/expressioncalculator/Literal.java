package com.shekhar.expressioncalculator;

import java.math.BigDecimal;
import java.util.Map;

class Literal extends Expression {
    Literal(Operator operator, String key) {
        super(operator, key);
    }

    @Override
    void setData(Map<String, BigDecimal> data) {
        BigDecimal rawKey = number(this.key);
        this.data = rawKey == null ? data.get(key) : rawKey;
    }


    private BigDecimal number(String str) {
        try {
            return new BigDecimal(str);
        } catch(NumberFormatException e){
            return null;
        }
    }
}
