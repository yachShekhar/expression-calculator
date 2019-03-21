package com.shekhar.expressioncalculator;

import java.math.BigDecimal;
import java.util.Map;

class Literal extends Expression {
    Literal(Operator operator, String key) {
        super(operator, key);
    }

    @Override
    void setData(Map<String, Object> data) {
        BigDecimal rawKey = number(this.key);
        this.data = rawKey == null ? newBigDecimal(data.get(key)) : rawKey;
    }

    private BigDecimal newBigDecimal(Object data){
        try {
            return data == null ? BigDecimal.ZERO : new BigDecimal(data.toString());
        } catch(NumberFormatException e){
            return BigDecimal.ZERO;
        }
    }

    private BigDecimal number(String str) {
        try {
            return new BigDecimal(str);
        } catch(NumberFormatException e){
            return null;
        }
    }
}
