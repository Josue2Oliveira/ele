package com.github.josue2oliveira.ele.parser;

import java_cup.runtime.Symbol;
import static com.github.josue2oliveira.ele.parser.sym.*;

%%

%public
%class Lexer
%unicode
%cup
%line
%column

%{
  StringBuilder string = new StringBuilder();

  private Symbol symbol(int type) {
    return new Symbol(type, yyline + 1, yycolumn + 1);
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline + 1, yycolumn + 1, value);
  }

  private long parseLong(int start, int end, int radix) {
    long result = 0;
    long digit;
    for (int i = start; i < end; i++) {
      digit  = Character.digit(yycharat(i), radix);
      result = result * radix + digit;
    }
    return result;
  }
%}

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]

Identifier = [:jletter:][:jletterdigit:]*
DecIntegerLiteral = 0 | [1-9][0-9]*
FloatLiteral = [0-9]+(\.[0-9]+)?
StringCharacter = [^\r\n\"\\]
SingleCharacter = [^\r\n\'\\]

%state STRING, CHARLITERAL

%%

<YYINITIAL> {

  /* Palavras-chave do ELE */
  "where"        { return symbol(WHERE); }
  "until"        { return symbol(UNTIL); }
  "begin"        { return symbol(BEGIN); }
  "end"          { return symbol(END); }
  "X"            { return symbol(X); }
  "Y"            { return symbol(Y); }
  "Print"        { return symbol(PRINT); }

  /* Palavras reservadas padrão Java (mantidas para compatibilidade) */
  "if"           { return symbol(IF); }
  "else"         { return symbol(ELSE); }
  "for"          { return symbol(FOR); }
  "while"        { return symbol(WHILE); }
  "do"           { return symbol(DO); }
  "class"        { return symbol(CLASS); }
  "public"       { return symbol(PUBLIC); }
  "private"      { return symbol(PRIVATE); }
  "protected"    { return symbol(PROTECTED); }
  "int"          { return symbol(INT); }
  "float"        { return symbol(FLOAT); }
  "boolean"      { return symbol(BOOLEAN); }
  "return"       { return symbol(RETURN); }
  "void"         { return symbol(VOID); }

  /* Booleanos e null */
  "true"         { return symbol(BOOLEAN_LITERAL, true); }
  "false"        { return symbol(BOOLEAN_LITERAL, false); }
  "null"         { return symbol(NULL_LITERAL); }

  /* Separadores */
  "("            { return symbol(LPAREN); }
  ")"            { return symbol(RPAREN); }
  "{"            { return symbol(LBRACE); }
  "}"            { return symbol(RBRACE); }
  "["            { return symbol(LBRACK); }
  "]"            { return symbol(RBRACK); }
  ";"            { return symbol(SEMICOLON); }
  ","            { return symbol(COMMA); }
  "."            { return symbol(DOT); }
  ":"            { return symbol(COLON); }

  /* Operadores */
  "="            { return symbol(EQ); }
  "=="           { return symbol(EQEQ); }
  "!="           { return symbol(NOTEQ); }
  "<"            { return symbol(LT); }
  ">"            { return symbol(GT); }
  "<="           { return symbol(LTEQ); }
  ">="           { return symbol(GTEQ); }
  "+"            { return symbol(PLUS); }
  "-"            { return symbol(MINUS); }
  "*"            { return symbol(MULT); }
  "/"            { return symbol(DIV); }
  "%"            { return symbol(MOD); }
  "&&"           { return symbol(ANDAND); }
  "||"           { return symbol(OROR); }
  "!"            { return symbol(NOT); }

  /* Literais numéricos */
  {DecIntegerLiteral}  { return symbol(INTEGER_LITERAL, Integer.parseInt(yytext())); }
  {FloatLiteral}       { return symbol(FLOATING_POINT_LITERAL, Double.parseDouble(yytext())); }

  /* Identificadores */
  {Identifier}         { return symbol(IDENTIFIER, yytext()); }

  /* Strings */
  \"                   { yybegin(STRING); string.setLength(0); }
  
  /* Espaço em branco */
  {WhiteSpace}         { /* ignorar */ }

  /* Comentários */
  "//" [^\n]*          { /* ignorar */ }
}

<STRING> {
  \"                   { yybegin(YYINITIAL); return symbol(STRING_LITERAL, string.toString()); }
  {StringCharacter}+   { string.append(yytext()); }
  "\\n"                { string.append('\n'); }
  "\\t"                { string.append('\t'); }
  "\\\""               { string.append('\"'); }
  "\\\\"               { string.append('\\'); }
  {LineTerminator}     { throw new RuntimeException("String não terminada"); }
}

[^]                    { throw new RuntimeException("Caractere inválido: " + yytext()); }
<<EOF>>                { return symbol(EOF); }