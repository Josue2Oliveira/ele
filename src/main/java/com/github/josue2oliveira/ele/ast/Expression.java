package com.github.josue2oliveira.ele.ast;

import com.github.josue2oliveira.ele.semantic.SymbolTable;
import com.github.josue2oliveira.ele.interpreter.Interpreter;

/**
 * Interface para expressões que podem ser avaliadas
 */
public interface Expression {
    Object evaluate(SymbolTable symbolTable, Interpreter interpreter);
}

