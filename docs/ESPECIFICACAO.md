# Especificação da Linguagem "éle"

**Versão:** 2.0 (Implementação Completa)  
**Data:** Outubro de 2025  
**Autor:** Josué Oliveira e João Colombo
**Status:** ✅ Implementado e Testado

---

## 1. Introdução

### 1.1. Objetivo

Este documento especifica os requisitos, a sintaxe e a semântica da linguagem de programação "éle". Ele serve como guia técnico para a implementação do compilador e como referência para os programadores da linguagem.

### 1.2. Escopo e Paradigma

"éle" é uma linguagem de programação de propósito geral, **imperativa**, **estruturada** e com **tipagem estática**, inspirada na sintaxe de Java e C. A versão 2.0 implementa todas as funcionalidades do MVP (Minimum Viable Product), incluindo análise léxica, sintática, semântica e execução/interpretação.

### 1.3. Definições e Termos

- **Comando:** Uma instrução que realiza uma ação (ex: atribuição, chamada de função).
- **Expressão:** Uma combinação de valores, variáveis e operadores que resulta em um único valor.
- **Token:** A menor unidade léxica da linguagem (ex: palavra-chave, identificador, número).
- **AST:** *Abstract Syntax Tree* (Árvore Sintática Abstrata), a representação estruturada do código-fonte.
- **Tabela de Símbolos:** Estrutura de dados que armazena informações sobre variáveis declaradas.

---

## 2. Análise Léxica (Tokens)

A linguagem "éle" é composta pelos seguintes tokens:

### 2.1. Palavras-chave

| Categoria | Palavras-chave |
|-----------|----------------|
| **Tipos** | `inteiro`, `texto`, `booleano` |
| **Controle de Fluxo** | `se`, `senao` |
| **Função de Saída** | `escreva` |
| **Valores Booleanos** | `verdadeiro`, `falso` |

**Nota:** As palavras-chave são case-sensitive e devem ser escritas em minúsculas.

### 2.2. Identificadores

**Regras:**
- Devem começar com uma letra (`a-z`, `A-Z`)
- Podem ser seguidos por letras ou números (`0-9`)
- Case-sensitive: `minhaVariavel` ≠ `minhavariavel`

**Exemplos válidos:**
```
minhaVariavel
a1
resultado
contador
valorTotal
```

**Exemplos inválidos:**
```
1variavel    // Começa com número
minha-var    // Contém hífen
var@nome     // Contém caractere especial
```

### 2.3. Literais

#### 2.3.1. Números Inteiros

**Formato:** Sequência de um ou mais dígitos (0-9)

**Exemplos:**
```
0
42
123
1000
```

**Nota:** Números negativos são tratados como expressão unária (operador `-` + número positivo).

#### 2.3.2. Literais de Texto

**Formato:** Sequência de caracteres entre aspas duplas (`"..."`)

**Exemplos:**
```
"Olá, mundo!"
"Compiladores"
"O valor é: "
""  // String vazia
```

**Caracteres especiais suportados:**
- Espaços
- Pontuação
- Números dentro de strings

**Nota:** Não há suporte a escape sequences na versão atual.

#### 2.3.3. Valores Booleanos

**Valores:** `verdadeiro`, `falso`

**Exemplo:**
```java
booleano ativo;
ativo = verdadeiro;

booleano inativo;
inativo = falso;
```

### 2.4. Operadores

#### 2.4.1. Operadores Aritméticos

| Operador | Descrição | Exemplo | Resultado |
|----------|-----------|---------|-----------|
| `+` | Adição | `5 + 3` | `8` |
| `-` | Subtração | `5 - 3` | `2` |
| `*` | Multiplicação | `5 * 3` | `15` |
| `/` | Divisão inteira | `5 / 2` | `2` |

**Precedência:** `*`, `/` > `+`, `-`

#### 2.4.2. Operadores Relacionais

| Operador | Descrição | Exemplo | Resultado |
|----------|-----------|---------|-----------|
| `==` | Igual a | `5 == 5` | `verdadeiro` |
| `!=` | Diferente de | `5 != 3` | `verdadeiro` |
| `>` | Maior que | `5 > 3` | `verdadeiro` |
| `<` | Menor que | `5 < 3` | `falso` |

**Resultado:** Sempre retorna um valor `booleano`

#### 2.4.3. Operador de Atribuição

| Operador | Descrição | Exemplo |
|----------|-----------|---------|
| `=` | Atribuição | `x = 10;` |

**Nota:** Não é um operador de comparação. Use `==` para comparação.

### 2.5. Delimitadores e Pontuação

| Símbolo | Nome | Uso |
|---------|------|-----|
| `(` `)` | Parênteses | Agrupamento de expressões, parâmetros |
| `{` `}` | Chaves | Delimitação de blocos de código |
| `;` | Ponto e vírgula | Terminador de comando |
| `,` | Vírgula | Separador de argumentos |

### 2.6. Comentários

**Formato:** Começam com `//` e vão até o final da linha

**Exemplos:**
```java
// Este é um comentário de linha única

inteiro x;  // Comentário após código

// Comentários são ignorados pelo compilador
// e não afetam a execução do programa
```

**Nota:** Comentários de múltiplas linhas (`/* ... */`) não são suportados na versão atual.

---

## 3. Sintaxe da Linguagem (Gramática EBNF)

Esta seção define a estrutura formal da linguagem usando a notação EBNF (Extended Backus-Naur Form).

```ebnf
(* Gramática EBNF para a linguagem "éle" - v2.0 *)

programa            = { comando };

comando             = declaracao_variavel
                    | comando_atribuicao
                    | comando_se
                    | comando_escreva
                    | bloco_comandos;

bloco_comandos      = "{", { comando }, "}";

declaracao_variavel = tipo, IDENTIFICADOR, ";";

tipo                = "inteiro" | "texto" | "booleano";

comando_atribuicao  = IDENTIFICADOR, "=", expressao, ";";

comando_escreva     = "escreva", "(", expressao, { ",", expressao }, ")", ";";

comando_se          = "se", "(", expressao_logica, ")", comando, [ "senao", comando ];

expressao_logica    = expressao, ( "==" | "!=" | ">" | "<" ), expressao
                    | "verdadeiro"
                    | "falso";

expressao           = termo, { ("+" | "-"), termo };

termo               = fator, { ("*" | "/"), fator };

fator               = NUMERO_INTEIRO
                    | LITERAL_TEXTO
                    | IDENTIFICADOR
                    | "(", expressao, ")";

IDENTIFICADOR       = LETRA, { LETRA | DIGITO };
NUMERO_INTEIRO      = DIGITO, { DIGITO };
LITERAL_TEXTO       = '"', { CARACTERE }, '"';

LETRA               = "a" | "b" | ... | "z" | "A" | "B" | ... | "Z";
DIGITO              = "0" | "1" | "2" | "3" | "4" | "5" | "6" | "7" | "8" | "9";
CARACTERE           = (* qualquer caractere exceto aspas duplas *);
```

---

## 4. Semântica

### 4.1. Tipos de Dados

#### 4.1.1. Tipo `inteiro`

**Descrição:** Representa números inteiros de 32 bits com sinal.

**Faixa:** -2.147.483.648 a 2.147.483.647

**Operações suportadas:**
- Aritméticas: `+`, `-`, `*`, `/`
- Relacionais: `==`, `!=`, `>`, `<`

**Exemplo:**
```java
inteiro idade;
idade = 25;

inteiro resultado;
resultado = (10 + 5) * 2;  // resultado = 30
```

#### 4.1.2. Tipo `texto`

**Descrição:** Representa uma sequência de caracteres imutável.

**Operações suportadas:**
- Atribuição
- Comparação de igualdade (`==`, `!=`)
- Saída via `escreva`

**Exemplo:**
```java
texto nome;
nome = "João Silva";

texto saudacao;
saudacao = "Olá, mundo!";

escreva(saudacao);
```

**Nota:** Concatenação de strings não é suportada na versão atual.

#### 4.1.3. Tipo `booleano`

**Descrição:** Representa os valores lógicos `verdadeiro` ou `falso`.

**Valores:** `verdadeiro`, `falso`

**Operações suportadas:**
- Atribuição
- Comparação de igualdade (`==`, `!=`)
- Uso em condicionais

**Exemplo:**
```java
booleano ativo;
ativo = verdadeiro;

booleano maiorDeIdade;
maiorDeIdade = (idade > 18);
```

### 4.2. Regras de Tipo

#### 4.2.1. Operadores Aritméticos

**Regra:** Os operadores `+`, `-`, `*`, `/` só podem ser aplicados entre duas expressões do tipo `inteiro`.

**Tipo de retorno:** `inteiro`

**Exemplo válido:**
```java
inteiro a;
a = 10;

inteiro b;
b = 5;

inteiro soma;
soma = a + b;  // OK: inteiro + inteiro = inteiro
```

**Exemplo inválido:**
```java
texto nome;
nome = "João";

inteiro resultado;
resultado = nome + 10;  // ERRO: texto + inteiro
```

#### 4.2.2. Operadores Relacionais

**Regra:** Os operadores `==`, `!=`, `>`, `<` só podem ser aplicados entre duas expressões do tipo `inteiro`.

**Tipo de retorno:** `booleano`

**Exemplo válido:**
```java
inteiro x;
x = 10;

inteiro y;
y = 20;

booleano maior;
maior = (x > y);  // OK: retorna falso
```

**Exemplo inválido:**
```java
texto a;
a = "abc";

texto b;
b = "def";

booleano igual;
igual = (a > b);  // ERRO: > não suportado para texto
```

#### 4.2.3. Atribuição

**Regra:** O operador de atribuição (`=`) exige que a expressão à direita tenha o mesmo tipo da variável declarada à esquerda.

**Exemplos válidos:**
```java
inteiro x;
x = 10;  // OK: inteiro = inteiro

texto nome;
nome = "João";  // OK: texto = texto

booleano ativo;
ativo = verdadeiro;  // OK: booleano = booleano
```

**Exemplos inválidos:**
```java
inteiro x;
x = "texto";  // ERRO: inteiro = texto

texto nome;
nome = 42;  // ERRO: texto = inteiro

booleano ativo;
ativo = 10;  // ERRO: booleano = inteiro
```

#### 4.2.4. Condicionais

**Regra:** A expressão dentro de um comando `se` deve resultar em um valor do tipo `booleano`.

**Exemplo válido:**
```java
inteiro idade;
idade = 18;

se (idade > 18) {  // OK: > retorna booleano
    escreva("Maior de idade");
}

booleano ativo;
ativo = verdadeiro;

se (ativo) {  // OK: ativo é booleano
    escreva("Está ativo");
}
```

**Exemplo inválido:**
```java
inteiro x;
x = 10;

se (x) {  // ERRO: x é inteiro, não booleano
    escreva("Teste");
}

se (x + 5) {  // ERRO: x + 5 é inteiro, não booleano
    escreva("Teste");
}
```

### 4.3. Escopo

**Regra:** Uma variável é válida apenas dentro do bloco (`{...}`) em que foi declarada.

**Escopo global:**
```java
inteiro x;  // Variável global
x = 10;

se (x > 5) {
    inteiro y;  // Variável local ao bloco if
    y = 20;
    escreva(x, y);  // OK: x e y são visíveis aqui
}

escreva(x);  // OK: x ainda é visível
escreva(y);  // ERRO: y não é mais visível
```

**Nota:** A versão atual não suporta escopos aninhados complexos (funções, blocos múltiplos).

### 4.4. Declaração e Inicialização

**Declaração:** Variáveis devem ser declaradas antes de serem usadas.

**Inicialização:** Variáveis podem ser declaradas sem valor inicial.

**Valor padrão:**
- `inteiro`: `0`
- `texto`: `""` (string vazia)
- `booleano`: `falso`

**Exemplo:**
```java
inteiro x;  // x = 0 (valor padrão)
escreva(x);  // Mostra: 0

x = 10;
escreva(x);  // Mostra: 10
```

---

## 5. Comandos da Linguagem

### 5.1. Declaração de Variáveis

**Sintaxe:**
```
tipo IDENTIFICADOR;
```

**Exemplos:**
```java
inteiro idade;
texto nome;
booleano ativo;
```

**Regras:**
- Uma variável só pode ser declarada uma vez no mesmo escopo
- O tipo deve ser especificado na declaração
- O identificador deve seguir as regras de nomenclatura

### 5.2. Comando de Atribuição

**Sintaxe:**
```
IDENTIFICADOR = expressao;
```

**Exemplos:**
```java
idade = 25;
nome = "Maria";
ativo = verdadeiro;
resultado = (a + b) * 2;
```

**Regras:**
- A variável deve ter sido declarada previamente
- O tipo da expressão deve ser compatível com o tipo da variável

### 5.3. Comando Condicional (`se`/`senao`)

**Sintaxe:**
```
se (expressao_logica) comando

se (expressao_logica) comando senao comando
```

**Exemplos:**

**If simples:**
```java
se (idade > 18) {
    escreva("Maior de idade");
}
```

**If-else:**
```java
se (x > y) {
    escreva("x é maior");
} senao {
    escreva("x não é maior");
}
```

**If-else aninhado:**
```java
se (nota > 90) {
    escreva("Excelente");
} senao {
    se (nota > 70) {
        escreva("Bom");
    } senao {
        escreva("Regular");
    }
}
```

**Regras:**
- A expressão condicional deve ser do tipo `booleano`
- Blocos de comandos devem ser delimitados por `{` e `}`
- O `senao` é opcional

### 5.4. Comando de Saída (`escreva`)

**Sintaxe:**
```
escreva(expressao [, expressao, ...]);
```

**Exemplos:**

**Saída simples:**
```java
escreva("Olá, mundo!");
```

**Saída de variável:**
```java
inteiro x;
x = 42;
escreva(x);  // Mostra: 42
```

**Saída múltipla:**
```java
inteiro a;
a = 10;

inteiro b;
b = 20;

escreva("a = ", a, ", b = ", b);
// Mostra: a = 10, b = 20
```

**Regras:**
- Aceita múltiplas expressões separadas por vírgula
- Cada expressão é avaliada e impressa sequencialmente
- Não adiciona espaços automaticamente entre os valores
- Adiciona quebra de linha ao final

---

## 6. Expressões

### 6.1. Expressões Aritméticas

**Operadores:** `+`, `-`, `*`, `/`

**Precedência:**
1. `*`, `/` (maior precedência)
2. `+`, `-` (menor precedência)

**Associatividade:** Esquerda para direita

**Exemplos:**
```java
inteiro resultado;

resultado = 2 + 3;        // 5
resultado = 10 - 4;       // 6
resultado = 5 * 3;        // 15
resultado = 20 / 4;       // 5

resultado = 2 + 3 * 4;    // 14 (não 20)
resultado = (2 + 3) * 4;  // 20
resultado = 10 / 3;       // 3 (divisão inteira)
```

### 6.2. Expressões Relacionais

**Operadores:** `==`, `!=`, `>`, `<`

**Tipo de retorno:** `booleano`

**Exemplos:**
```java
booleano resultado;

resultado = (5 == 5);   // verdadeiro
resultado = (5 != 3);   // verdadeiro
resultado = (5 > 3);    // verdadeiro
resultado = (5 < 3);    // falso
resultado = (10 == 20); // falso
```

### 6.3. Precedência Completa de Operadores

| Precedência | Operadores | Associatividade |
|-------------|------------|-----------------|
| 1 (maior) | `(` `)` | N/A |
| 2 | `*` `/` | Esquerda |
| 3 | `+` `-` | Esquerda |
| 4 (menor) | `==` `!=` `>` `<` | Esquerda |

---

## 7. Exemplos de Programas Completos

### 7.1. Programa Básico

```java
// Meu primeiro programa em éle

inteiro numero;
numero = 42;

escreva("O número é: ", numero);
```

**Saída:**
```
O número é: 42
```

### 7.2. Calculadora Simples

```java
// Calculadora simples

inteiro a;
a = 10;

inteiro b;
b = (a + 5) * 2;

escreva("a = ", a);
escreva("b = ", b);
escreva("a + b = ", a + b);
escreva("a * b = ", a * b);
```

**Saída:**
```
a = 10
b = 30
a + b = 40
a * b = 300
```

### 7.3. Estrutura Condicional

```java
// Verificação de maioridade

inteiro idade;
idade = 18;

se (idade > 18) {
    escreva("Maior de idade");
} senao {
    se (idade == 18) {
        escreva("Acabou de completar 18 anos");
    } senao {
        escreva("Menor de idade");
    }
}
```

**Saída:**
```
Acabou de completar 18 anos
```

### 7.4. Comparação de Números

```java
// Comparação de números

inteiro x;
x = 15;

inteiro y;
y = 20;

se (x < y) {
    escreva("x é menor que y");
}

se (x == y) {
    escreva("x é igual a y");
}

se (x > y) {
    escreva("x é maior que y");
}

inteiro diferenca;
diferenca = y - x;
escreva("Diferença: ", diferenca);
```

**Saída:**
```
x é menor que y
Diferença: 5
```

### 7.5. Uso de Booleanos

```java
// Uso de variáveis booleanas

inteiro idade;
idade = 25;

booleano maiorDeIdade;
maiorDeIdade = (idade > 18);

se (maiorDeIdade) {
    escreva("Pode votar");
} senao {
    escreva("Não pode votar");
}

booleano ativo;
ativo = verdadeiro;

se (ativo) {
    escreva("Status: Ativo");
} senao {
    escreva("Status: Inativo");
}
```

**Saída:**
```
Pode votar
Status: Ativo
```

---

## 8. Mensagens de Erro

### 8.1. Erros Léxicos

**Erro:** Token não reconhecido

**Exemplo:**
```java
inteiro x@y;  // @ não é um token válido
```

**Mensagem:**
```
Erro léxico: Caractere inválido '@' na linha 1
```

### 8.2. Erros Sintáticos

**Erro:** Falta de ponto e vírgula

**Exemplo:**
```java
inteiro x
x = 10;
```

**Mensagem:**
```
Erro de sintaxe: Esperado ';' após declaração
```

**Erro:** Parênteses não balanceados

**Exemplo:**
```java
se (x > 5 {
    escreva("Maior");
}
```

**Mensagem:**
```
Erro de sintaxe: Esperado ')' após expressão
```

### 8.3. Erros Semânticos

**Erro:** Variável não declarada

**Exemplo:**
```java
escreva(z);  // z não foi declarada
```

**Mensagem:**
```
Erro semântico: Variável 'z' não foi declarada!
```

**Erro:** Declaração duplicada

**Exemplo:**
```java
inteiro x;
inteiro x;  // x já foi declarada
```

**Mensagem:**
```
Erro semântico: Variável 'x' já foi declarada!
```

**Erro:** Tipo incompatível

**Exemplo:**
```java
inteiro x;
x = "texto";  // tipo incompatível
```

**Mensagem:**
```
Erro semântico: Tipo incompatível para variável 'x'
```

### 8.4. Erros de Execução

**Erro:** Divisão por zero

**Exemplo:**
```java
inteiro x;
x = 10;

inteiro y;
y = 0;

inteiro z;
z = x / y;  // divisão por zero
```

**Mensagem:**
```
Erro de execução: Divisão por zero!
```

---

## 9. Limitações Conhecidas

### 9.1. Funcionalidades Não Implementadas

1. **Estruturas de Repetição:** Não há suporte a `enquanto`, `para` ou `repita`
2. **Funções:** Não é possível definir funções customizadas
3. **Arrays:** Não há suporte a vetores ou matrizes
4. **Operadores Lógicos:** `e`, `ou`, `nao` não estão implementados
5. **Concatenação de Strings:** Não é possível concatenar textos
6. **Escape Sequences:** `\n`, `\t` não são suportados em strings
7. **Comentários de Bloco:** Apenas `//` é suportado, não `/* */`
8. **Números de Ponto Flutuante:** Apenas inteiros são suportados
9. **Entrada do Usuário:** Não há comando `leia` ou similar
10. **Módulos/Imports:** Não há sistema de módulos

### 9.2. Restrições de Escopo

- Apenas escopo global é totalmente suportado
- Variáveis locais a blocos têm suporte limitado
- Não há suporte a funções com escopo local

### 9.3. Restrições de Tipos

- Conversão automática de tipos não é suportada
- Não há casting explícito
- Operações mistas entre tipos não são permitidas

---

## 10. Referências

### 10.1. Documentação Técnica

- **JFlex Manual:** https://jflex.de/manual.html
- **CUP Manual:** http://www2.cs.tum.edu/projects/cup/
- **EBNF Standard:** ISO/IEC 14977

### 10.2. Livros de Referência

- AHO, Alfred V. et al. **Compiladores: Princípios, Técnicas e Ferramentas**. 2. ed. 2008.
- APPEL, Andrew W. **Modern Compiler Implementation in Java**. 2. ed. 2002.
- COOPER, Keith D.; TORCZON, Linda. **Engineering a Compiler**. 2. ed. 2011.

---

## 11. Histórico de Versões

| Versão | Data | Mudanças |
|--------|------|----------|
| 0.1 | Agosto 2025 | Especificação inicial (MVP) |
| 1.0 | Setembro 2025 | Implementação de análise léxica e sintática |
| 2.0 | Outubro 2025 | Implementação completa com análise semântica e interpretação |

---

**Fim da Especificação**

Para mais informações, consulte a documentação do projeto ou entre em contato com os desenvolvedores.

