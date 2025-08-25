// --- Seção 1: Código de Usuário e Imports ---
package com.github.josue2oliveira.ele.parser;

import java_cup.runtime.Symbol;

%%
// --- Seção 2: Diretivas e Opções ---
%cup
%line
%column
%class Lexer

%%
// --- Seção 3: Regras Léxicas ---
[ \t\r\n]+ { /* Ignorar espaços em branco */ }
. { System.err.println("Caractere inválido: " + yytext()); }
