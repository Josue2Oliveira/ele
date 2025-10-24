package com.github.josue2oliveira.ele.ast;

import com.github.josue2oliveira.ele.semantic.SymbolTable;
import com.github.josue2oliveira.ele.interpreter.Interpreter;

/**
 * Representa uma declaração de variável
 */
public class DeclStatement implements ASTNode {
    private String type;
    private String identifier;
    private Expression initialValueExpr;
    
    public DeclStatement(String type, String identifier, Expression initialValueExpr) {
        this.type = type;
        this.identifier = identifier;
        this.initialValueExpr = initialValueExpr;
    }
    
    public DeclStatement(String type, String identifier) {
        this(type, identifier, null);
    }
    
    @Override
    public void execute(SymbolTable symbolTable, Interpreter interpreter) {
        symbolTable.declare(identifier, type);
        if (initialValueExpr != null) {
            Object value = initialValueExpr.evaluate(symbolTable, interpreter);
            symbolTable.assign(identifier, value);
        }
    }
}

