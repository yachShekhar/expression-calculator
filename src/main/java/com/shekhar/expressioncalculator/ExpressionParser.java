package com.shekhar.expressioncalculator;

import java.util.Stack;


public class ExpressionParser {
    private static final String LITERAL_PATTERN = "[0-9a-zA-z\\.]+";
    private ExpressionParser(){
    }


    public static Expression init(String expression){
        return new ExpressionParser().parse(expression);
    }

    /**
     * parse the arithmetic operations
     * @param expression
     * @return
     */
    private Expression parse(String expression){
        char[] tokens = expression.toCharArray();
        Stack<Expression> values = new Stack<>();
        Stack<Character> ops = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ' ')
                continue;

            if (String.valueOf(tokens[i]).matches(LITERAL_PATTERN)) {
                StringBuilder literals = new StringBuilder();
                while (i < tokens.length && String.valueOf(tokens[i]).matches(LITERAL_PATTERN))
                    literals.append(tokens[i++]);
                //to avoid the last increment in while loop
                i--;
                values.push(new Literal(Operator.LITERAL, literals.toString()));
            }

            else if (tokens[i] == '(')
                ops.push(tokens[i]);

            else if (tokens[i] == ')') {
                while (ops.peek() != '(')
                    values.push(applyOperator(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }

            else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/' || tokens[i] == '='){
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                    values.push(applyOperator(ops.pop(), values.pop(), values.pop()));
                ops.push(tokens[i]);
            }
        }

        while (!ops.empty())
            values.push(applyOperator(ops.pop(), values.pop(), values.pop()));

        return values.pop();
    }

    /**
     * this will give you respective operations
     * @param ops
     * @param left
     * @param right
     * @return
     */
    private Expression applyOperator(char ops, Expression right, Expression left){
        return Operator.of(String.valueOf(ops)).create(left, right);
    }

    /**
     * This will return the precedence order of operations
     * @param op1
     * @param op2
     * @return
     */
    private boolean hasPrecedence(char op1, char op2) {
        if (op2 == '=')
            return false;
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
}
