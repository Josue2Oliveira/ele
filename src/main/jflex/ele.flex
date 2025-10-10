/* -------- SEÇÃO 1: cabeçalhos Java -------- */
package com.github.josue2oliveira.ele.parser;

import java_cup.runtime.Symbol;

/* -------- SEÇÃO 2: declarações JFlex -------- */
%%
%class Lexer
%unicode
%cup
%public

WhiteSpace = [ \t\n\r]+

/* -------- SEÇÃO 3: regras -------- */
%%

{WhiteSpace}            { /* ignora espaços */ }

"escreva"               { return new Symbol(sym.T_ESCREVA); }

\"([^\"\\]|\\.)*\"      {
                          String s = yytext();
                          s = s.substring(1, s.length()-1);
                          return new Symbol(sym.LITERAL_TEXTO, s);
                        }

"("                     { return new Symbol(sym.ABRE_PARENTESES); }
")"                     { return new Symbol(sym.FECHA_PARENTESES); }
";"                     { return new Symbol(sym.PONTO_VIRGULA); }

.                       { System.err.println("Caractere inválido: " + yytext()); }