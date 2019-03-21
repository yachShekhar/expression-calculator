package com.shekhar.expressioncalculator;

interface Operable {
    Expression create(Expression left, Expression right);
}
