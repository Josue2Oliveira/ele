package com.github.josue2oliveira.ele.ast;

import com.github.josue2oliveira.ele.semantic.SymbolTable;
import com.github.josue2oliveira.ele.interpreter.Interpreter;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa um programa (lista de comandos)
 */
public class Program implements ASTNode {
    private List<ASTNode> statements;
    
    public Program() {
        this.statements = new ArrayList<>();
    }
    
    public void addStatement(ASTNode stmt) {
        statements.add(stmt);
    }
    
    @Override
    public void execute(SymbolTable symbolTable, Interpreter interpreter) {
        for (ASTNode stmt : statements) {
            stmt.execute(symbolTable, interpreter);
        }
    }
}

