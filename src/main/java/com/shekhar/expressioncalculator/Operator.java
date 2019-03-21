package com.shekhar.expressioncalculator;

import java.util.HashMap;
import java.util.Map;

//TODO support modulus and power
enum Operator implements Operable{
    LITERAL("\"[0-9a-zA-z\\\\.]+\""){
        @Override
        public Expression create(Expression left, Expression right) {
            return null;
        }
    },
    ADD("+"){
        @Override
        public Expression create(Expression left, Expression right) {
            return new Addition(left, this, right);
        }
    },

    SUBTRACT("-"){
        @Override
        public Expression create(Expression left, Expression right) {
            return new Subtraction(left, this, right);
        }
    },

    MULTIPLY("*"){
        @Override
        public Expression create(Expression left, Expression right) {
            return new Multiplication(left, this, right);
        }
    },

    DIVIDE("/"){
        @Override
        public Expression create(Expression left, Expression right) {
            return new Division(left, this, right);
        }
    },

    ASSIGN("="){
        @Override
        public Expression create(Expression left, Expression right) {
            return new Assignment(left, this, right);
        }
    };


    private final String value;


    Operator(String value) {
        this.value = value;
    }


    public String getValue() {
        return this.value;
    }


    private static final Map<String, Operator> backRef = new HashMap<>();

    public static Operator of(String word) {
        if (backRef.isEmpty()) {
            for (int w = 0; w< Operator.values().length; w++) {
                Operator type = Operator.values()[w];
                backRef.put(type.getValue(), type);
            }
        }
        return backRef.get(word);
    }

}
