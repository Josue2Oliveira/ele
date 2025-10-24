package com.github.josue2oliveira.ele.ast;

import com.github.josue2oliveira.ele.semantic.SymbolTable;
import com.github.josue2oliveira.ele.interpreter.Interpreter;

/**
 * Expressão binária (a + b, a < b, etc.)
 */
public class BinaryExpression implements Expression {
    private Expression left;
    private String operator;
    private Expression right;
    
    public BinaryExpression(Expression left, String operator, Expression right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }
    
    @Override
    public Object evaluate(SymbolTable symbolTable, Interpreter interpreter) {
        Object leftValue = left.evaluate(symbolTable, interpreter);
        Object rightValue = right.evaluate(symbolTable, interpreter);
        return interpreter.evaluateBinary(leftValue, operator, rightValue);
    }
}

