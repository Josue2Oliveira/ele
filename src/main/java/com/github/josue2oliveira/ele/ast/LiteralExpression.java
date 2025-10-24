package com.github.josue2oliveira.ele.ast;

import com.github.josue2oliveira.ele.semantic.SymbolTable;
import com.github.josue2oliveira.ele.interpreter.Interpreter;

/**
 * Expressão literal (número, string, boolean)
 */
public class LiteralExpression implements Expression {
    private Object value;
    
    public LiteralExpression(Object value) {
        this.value = value;
    }
    
    @Override
    public Object evaluate(SymbolTable symbolTable, Interpreter interpreter) {
        return value;
    }
}

