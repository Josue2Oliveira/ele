package com.github.josue2oliveira.ele.ast;

import com.github.josue2oliveira.ele.semantic.SymbolTable;
import com.github.josue2oliveira.ele.interpreter.Interpreter;

/**
 * Nó base da Árvore Sintática Abstrata (AST)
 */
public interface ASTNode {
    void execute(SymbolTable symbolTable, Interpreter interpreter);
}

