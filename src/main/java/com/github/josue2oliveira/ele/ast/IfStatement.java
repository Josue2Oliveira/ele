package com.github.josue2oliveira.ele.ast;

import com.github.josue2oliveira.ele.semantic.SymbolTable;
import com.github.josue2oliveira.ele.interpreter.Interpreter;

/**
 * Representa um comando if-else
 */
public class IfStatement implements ASTNode {
    private Expression condition;
    private ASTNode thenBlock;
    private ASTNode elseBlock;
    
    public IfStatement(Expression condition, ASTNode thenBlock, ASTNode elseBlock) {
        this.condition = condition;
        this.thenBlock = thenBlock;
        this.elseBlock = elseBlock;
    }
    
    public IfStatement(Expression condition, ASTNode thenBlock) {
        this(condition, thenBlock, null);
    }
    
    @Override
    public void execute(SymbolTable symbolTable, Interpreter interpreter) {
        Object condValue = condition.evaluate(symbolTable, interpreter);
        boolean condBool = toBoolean(condValue);
        
        if (condBool) {
            thenBlock.execute(symbolTable, interpreter);
        } else if (elseBlock != null) {
            elseBlock.execute(symbolTable, interpreter);
        }
    }
    
    private boolean toBoolean(Object value) {
        if (value instanceof Boolean) {
            return (Boolean) value;
        }
        if (value instanceof Number) {
            return ((Number) value).doubleValue() != 0;
        }
        return value != null;
    }
}

