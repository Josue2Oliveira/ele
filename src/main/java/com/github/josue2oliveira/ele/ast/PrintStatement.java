package com.github.josue2oliveira.ele.ast;

import com.github.josue2oliveira.ele.semantic.SymbolTable;
import com.github.josue2oliveira.ele.interpreter.Interpreter;

/**
 * Representa um comando Print
 */
public class PrintStatement implements ASTNode {
    private Expression valueExpr;
    
    public PrintStatement(Expression valueExpr) {
        this.valueExpr = valueExpr;
    }
    
    @Override
    public void execute(SymbolTable symbolTable, Interpreter interpreter) {
        Object value = valueExpr.evaluate(symbolTable, interpreter);
        interpreter.executePrint(value);
    }
}

