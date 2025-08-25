# Especificação da Linguagem "éle"

**Versão:** 0.1 (MVP)
**Data:** 25 de agosto de 2025
**Autor:** Josué Oliveira

---

## 1. Introdução

### 1.1. Objetivo

Este documento especifica os requisitos, a sintaxe e a semântica da linguagem de programação "éle". Ele serve como guia técnico para a implementação do compilador e como referência para os programadores da linguagem.

### 1.2. Escopo e Paradigma

"éle" é uma linguagem de programação de propósito geral, **imperativa**, **estruturada** e com **tipagem estática**, inspirada na sintaxe de Java e C. O objetivo do MVP (Minimum Viable Product) é suportar a criação de programas simples com lógica condicional, manipulação de variáveis e operações aritméticas básicas.

### 1.3. Definições e Termos

-   **Comando:** Uma instrução que realiza uma ação (ex: atribuição, chamada de função).
-   **Expressão:** Uma combinação de valores, variáveis e operadores que resulta em um único valor.
-   **Token:** A menor unidade léxica da linguagem (ex: palavra-chave, identificador, número).
-   **AST:** *Abstract Syntax Tree* (Árvore Sintática Abstrata), a representação estruturada do código-fonte.

---

## 2. Análise Léxica (Tokens)

A linguagem "éle" é composta pelos seguintes tokens:

-   **Palavras-chave:**
    -   `inteiro`, `texto`, `booleano` (Tipos)
    -   `se`, `senao` (Controle de Fluxo)
    -   `escreva` (Função de Saída)
    -   `verdadeiro`, `falso` (Valores Booleanos)
-   **Identificadores (Nomes de variáveis):** Devem começar com uma letra (`a-z`, `A-Z`) e podem ser seguidos por letras ou números (`0-9`). Ex: `minhaVariavel`, `a1`, `resultado`.
-   **Literais:**
    -   `NUMERO_INTEIRO`: Sequência de um ou mais dígitos. Ex: `123`, `42`, `0`.
    -   `LITERAL_TEXTO`: Sequência de caracteres entre aspas duplas. Ex: `"Olá, mundo!"`.
-   **Operadores:**
    -   Aritméticos: `+`, `-`, `*`, `/`
    -   Atribuição: `=`
    -   Relacionais: `==`, `!=`, `>`, `<`
-   **Delimitadores e Pontuação:** `(`, `)`, `{`, `}`, `;`, `,`.
-   **Comentários:** Começam com `//` e vão até o final da linha. Devem ser ignorados pelo compilador.

---

## 3. Sintaxe da Linguagem (Gramática EBNF)

Esta seção define a estrutura formal da linguagem usando a notação EBNF (Extended Backus-Naur Form).

```ebnf
(* Gramática EBNF para a linguagem "éle" - MVP v0.1 *)

programa        = { comando };

comando         = declaracao_variavel | comando_atribuicao | comando_se | comando_escreva | bloco_comandos;

bloco_comandos  = "{", { comando }, "}";

declaracao_variavel = tipo, IDENTIFICADOR, ";";
tipo            = "inteiro" | "texto" | "booleano";

comando_atribuicao = IDENTIFICADOR, "=", expressao, ";";
comando_escreva  = "escreva", "(", expressao, { ",", expressao }, ")", ";";
comando_se      = "se", "(", expressao_logica, ")", comando, [ "senao", comando ];

expressao_logica = expressao, ( "==" | "!=" | ">" | "<" ), expressao | "verdadeiro" | "falso";

expressao       = termo, { ("+" | "-"), termo };
termo           = fator, { ("*" | "/"), fator };
fator           = NUMERO_INTEIRO | LITERAL_TEXTO | IDENTIFICADOR | "(", expressao, ")";

---

## 4. Semântica

### 4.1. Tipos de Dados

-   **`inteiro`**: Representa números inteiros de 32 bits.
-   **`texto`**: Representa uma sequência de caracteres imutável.
-   **`booleano`**: Representa os valores lógicos `verdadeiro` ou `falso`.

### 4.2. Regras de Tipo

-   **Operadores Aritméticos:** Os operadores `+`, `-`, `*`, `/` só podem ser aplicados entre duas expressões do tipo `inteiro`.
-   **Operadores Relacionais:** Os operadores `==`, `!=`, `>`, `<` só podem ser aplicados entre duas expressões do tipo `inteiro`. O resultado é sempre um `booleano`.
-   **Atribuição:** O operador de atribuição (`=`) exige que a expressão à direita tenha o mesmo tipo da variável declarada à esquerda.
-   **Condicionais:** A expressão dentro de um comando `se` deve resultar em um valor do tipo `booleano`.
-   **Escopo:** Uma variável é válida apenas dentro do bloco (`{...}`) em que foi declarada.

---

## 5. Código de Exemplo

Um programa de exemplo que demonstra os recursos do MVP:

```java
// Meu primeiro programa em éle

// Declaração de variáveis
inteiro a;
a = 10;

inteiro b;
b = (a + 5) * 2; // b terá o valor 30

// Uso de condicional e da função de saída
se (b > 20) {
  escreva("O valor de b (", b, ") é maior que 20.");
} senao {
  escreva("O valor de b não é maior que 20.");
}

// Exemplo de texto
texto saudacao;
saudacao = "Fim do programa.";
escreva(saudacao);
