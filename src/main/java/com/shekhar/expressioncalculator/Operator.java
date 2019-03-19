package com.shekhar.expressioncalculator;

import java.util.HashMap;
import java.util.Map;

enum Operator {
    NULL(null),

    LITERAL(""),

    NOT("!"),

    OPEN_BRACKET("("),

    CLOSE_BRACKET(")"),

    AND("&&"),

    OR("||"),

    ADD("+"),

    SUBTRACT("-"),

    MULTIPLY("*"),

    DIVIDE("/"),

    ASSIGN("="),

    LESS_THAN("<"),

    LESS_THAN_OR_EQUALS("<="),

    EQUALS("=="),

    NOT_EQUALS("!="),

    GREATER_THAN(">"),

    GREATER_THAN_OR_EQUALS(">="),

    POWER ("^"),

    MODULUS ("%");


    private final String value;


    Operator(String value) {
        this.value = value;
    }


    public String getValue() {
        if (this.equals(Operator.NULL)) {
            return "[null]";
        }
        if (this.equals(Operator.LITERAL)) {
            return "[literal]";
        }
        return this.value;
    }


    private static final Map<String, Operator> backRef = new HashMap<>();

    public static Operator of(String word) {
        if (word == null) {
            return Operator.NULL;
        }
        if (backRef.isEmpty()) {
            for (int w = 0;
                 w< Operator.values().length;
                 w++) {
                Operator type = Operator.values()[w];
                if (type != Operator.NULL) {
                    backRef.put (type.value ,type);
                }
            }
        }
        Operator type = backRef.get(word);
        if (type == null) {
            return Operator.LITERAL;
        }
        return type;
    }
}
