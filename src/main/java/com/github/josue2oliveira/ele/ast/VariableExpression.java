package com.github.josue2oliveira.ele.ast;

import com.github.josue2oliveira.ele.semantic.SymbolTable;
import com.github.josue2oliveira.ele.interpreter.Interpreter;

/**
 * Expressão de variável (identificador)
 */
public class VariableExpression implements Expression {
    private String name;
    
    public VariableExpression(String name) {
        this.name = name;
    }
    
    @Override
    public Object evaluate(SymbolTable symbolTable, Interpreter interpreter) {
        return symbolTable.getValue(name);
    }
}

