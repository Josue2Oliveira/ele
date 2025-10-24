package com.github.josue2oliveira.ele.ast;

import com.github.josue2oliveira.ele.semantic.SymbolTable;
import com.github.josue2oliveira.ele.interpreter.Interpreter;

/**
 * Representa uma atribuição
 */
public class AssignStatement implements ASTNode {
    private String identifier;
    private Expression valueExpr;
    
    public AssignStatement(String identifier, Expression valueExpr) {
        this.identifier = identifier;
        this.valueExpr = valueExpr;
    }
    
    @Override
    public void execute(SymbolTable symbolTable, Interpreter interpreter) {
        Object value = valueExpr.evaluate(symbolTable, interpreter);
        symbolTable.assign(identifier, value);
    }
}

