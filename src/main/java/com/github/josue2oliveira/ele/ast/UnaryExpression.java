package com.github.josue2oliveira.ele.ast;

import com.github.josue2oliveira.ele.semantic.SymbolTable;
import com.github.josue2oliveira.ele.interpreter.Interpreter;

/**
 * Expressão unária (!a, -a)
 */
public class UnaryExpression implements Expression {
    private String operator;
    private Expression operand;
    
    public UnaryExpression(String operator, Expression operand) {
        this.operator = operator;
        this.operand = operand;
    }
    
    @Override
    public Object evaluate(SymbolTable symbolTable, Interpreter interpreter) {
        Object value = operand.evaluate(symbolTable, interpreter);
        return interpreter.evaluateUnary(operator, value);
    }
}

