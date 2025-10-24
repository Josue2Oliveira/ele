# Exemplos de Código - Linguagem "éle"

Este documento contém exemplos práticos de programas escritos na linguagem "éle", seguindo a especificação oficial.

---

## 📚 Índice

1. [Exemplos Básicos](#exemplos-básicos)
2. [Expressões Aritméticas](#expressões-aritméticas)
3. [Estruturas Condicionais](#estruturas-condicionais)
4. [Uso de Booleanos](#uso-de-booleanos)
5. [Exemplos Avançados](#exemplos-avançados)
6. [Exemplos de Erros](#exemplos-de-erros)

---

## Exemplos Básicos

### Exemplo 1: Olá, Mundo!

```java
// Primeiro programa em éle
texto mensagem;
mensagem = "Olá, mundo!";
escreva(mensagem);
```

**Saída:**
```
Olá, mundo!
```

---

### Exemplo 2: Declaração e Atribuição

```java
// Declaração de variáveis
inteiro idade;
idade = 25;

texto nome;
nome = "João Silva";

booleano ativo;
ativo = verdadeiro;

escreva("Nome: ", nome);
escreva("Idade: ", idade);
escreva("Ativo: ", ativo);
```

**Saída:**
```
Nome: João Silva
Idade: 25
Ativo: verdadeiro
```

---

### Exemplo 3: Valores Padrão

```java
// Variáveis têm valores padrão
inteiro x;  // x = 0
escreva("Valor padrão de x: ", x);

x = 42;
escreva("Novo valor de x: ", x);
```

**Saída:**
```
Valor padrão de x: 0
Novo valor de x: 42
```

---

## Expressões Aritméticas

### Exemplo 4: Operações Básicas

```java
// Operações aritméticas básicas
inteiro a;
a = 10;

inteiro b;
b = 5;

inteiro soma;
soma = a + b;

inteiro subtracao;
subtracao = a - b;

inteiro multiplicacao;
multiplicacao = a * b;

inteiro divisao;
divisao = a / b;

escreva("a = ", a);
escreva("b = ", b);
escreva("Soma: ", soma);
escreva("Subtração: ", subtracao);
escreva("Multiplicação: ", multiplicacao);
escreva("Divisão: ", divisao);
```

**Saída:**
```
a = 10
b = 5
Soma: 15
Subtração: 5
Multiplicação: 50
Divisão: 2
```

---

### Exemplo 5: Precedência de Operadores

```java
// Demonstração de precedência
inteiro resultado1;
resultado1 = 2 + 3 * 4;  // * tem precedência sobre +

inteiro resultado2;
resultado2 = (2 + 3) * 4;  // Parênteses forçam ordem

escreva("2 + 3 * 4 = ", resultado1);
escreva("(2 + 3) * 4 = ", resultado2);
```

**Saída:**
```
2 + 3 * 4 = 14
(2 + 3) * 4 = 20
```

---

### Exemplo 6: Expressões Complexas

```java
// Expressões aritméticas complexas
inteiro x;
x = 10;

inteiro y;
y = 5;

inteiro z;
z = (x + y) * (x - y);

escreva("x = ", x);
escreva("y = ", y);
escreva("(x + y) * (x - y) = ", z);
```

**Saída:**
```
x = 10
y = 5
(x + y) * (x - y) = 75
```

---

## Estruturas Condicionais

### Exemplo 7: If Simples

```java
// Estrutura condicional simples
inteiro idade;
idade = 20;

se (idade > 18) {
    escreva("Maior de idade");
}
```

**Saída:**
```
Maior de idade
```

---

### Exemplo 8: If-Else

```java
// Estrutura if-else
inteiro numero;
numero = 15;

se (numero > 10) {
    escreva("O número é maior que 10");
} senao {
    escreva("O número é menor ou igual a 10");
}
```

**Saída:**
```
O número é maior que 10
```

---

### Exemplo 9: If-Else Aninhado

```java
// Estruturas condicionais aninhadas
inteiro nota;
nota = 85;

se (nota > 90) {
    escreva("Conceito: Excelente");
} senao {
    se (nota > 70) {
        escreva("Conceito: Bom");
    } senao {
        se (nota > 50) {
            escreva("Conceito: Regular");
        } senao {
            escreva("Conceito: Insuficiente");
        }
    }
}
```

**Saída:**
```
Conceito: Bom
```

---

### Exemplo 10: Múltiplas Condições

```java
// Verificação de múltiplas condições
inteiro x;
x = 10;

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
```

**Saída:**
```
x é menor que y
```

---

## Uso de Booleanos

### Exemplo 11: Variáveis Booleanas

```java
// Uso de variáveis booleanas
booleano ativo;
ativo = verdadeiro;

booleano inativo;
inativo = falso;

se (ativo) {
    escreva("Sistema ativo");
}

se (inativo) {
    escreva("Sistema inativo");
} senao {
    escreva("Sistema não está inativo");
}
```

**Saída:**
```
Sistema ativo
Sistema não está inativo
```

---

### Exemplo 12: Expressões Relacionais

```java
// Expressões relacionais retornam booleanos
inteiro a;
a = 15;

inteiro b;
b = 20;

booleano maior;
maior = (a > b);

booleano menor;
menor = (a < b);

booleano igual;
igual = (a == b);

booleano diferente;
diferente = (a != b);

escreva("a > b: ", maior);
escreva("a < b: ", menor);
escreva("a == b: ", igual);
escreva("a != b: ", diferente);
```

**Saída:**
```
a > b: falso
a < b: verdadeiro
a == b: falso
a != b: verdadeiro
```

---

## Exemplos Avançados

### Exemplo 13: Calculadora Completa

```java
// Calculadora com múltiplas operações
inteiro num1;
num1 = 25;

inteiro num2;
num2 = 5;

escreva("=== CALCULADORA ===");
escreva("Número 1: ", num1);
escreva("Número 2: ", num2);
escreva("");

inteiro soma;
soma = num1 + num2;
escreva("Soma: ", soma);

inteiro subtracao;
subtracao = num1 - num2;
escreva("Subtração: ", subtracao);

inteiro multiplicacao;
multiplicacao = num1 * num2;
escreva("Multiplicação: ", multiplicacao);

inteiro divisao;
divisao = num1 / num2;
escreva("Divisão: ", divisao);
```

**Saída:**
```
=== CALCULADORA ===
Número 1: 25
Número 2: 5

Soma: 30
Subtração: 20
Multiplicação: 125
Divisão: 5
```

---

### Exemplo 14: Verificação de Paridade

```java
// Verifica se número é par ou ímpar
inteiro numero;
numero = 17;

inteiro resto;
resto = numero / 2;

inteiro dobro;
dobro = resto * 2;

booleano par;
par = (dobro == numero);

se (par) {
    escreva(numero, " é par");
} senao {
    escreva(numero, " é ímpar");
}
```

**Saída:**
```
17 é ímpar
```

---

### Exemplo 15: Comparador de Três Números

```java
// Encontra o maior de três números
inteiro a;
a = 15;

inteiro b;
b = 23;

inteiro c;
c = 18;

escreva("Números: ", a, ", ", b, ", ", c);

inteiro maior;
maior = a;

se (b > maior) {
    maior = b;
}

se (c > maior) {
    maior = c;
}

escreva("O maior número é: ", maior);
```

**Saída:**
```
Números: 15, 23, 18
O maior número é: 23
```

---

### Exemplo 16: Faixa de Valores

```java
// Verifica se número está em uma faixa
inteiro valor;
valor = 75;

inteiro minimo;
minimo = 50;

inteiro maximo;
maximo = 100;

booleano dentroFaixa;
dentroFaixa = (valor > minimo);

se (dentroFaixa) {
    booleano abaixoMaximo;
    abaixoMaximo = (valor < maximo);
    
    se (abaixoMaximo) {
        escreva("Valor dentro da faixa");
    } senao {
        escreva("Valor acima do máximo");
    }
} senao {
    escreva("Valor abaixo do mínimo");
}
```

**Saída:**
```
Valor dentro da faixa
```

---

### Exemplo 17: Sistema de Classificação

```java
// Sistema de classificação por pontos
inteiro pontos;
pontos = 850;

texto classificacao;

se (pontos > 900) {
    classificacao = "Ouro";
} senao {
    se (pontos > 700) {
        classificacao = "Prata";
    } senao {
        se (pontos > 500) {
            classificacao = "Bronze";
        } senao {
            classificacao = "Iniciante";
        }
    }
}

escreva("Pontos: ", pontos);
escreva("Classificação: ", classificacao);
```

**Saída:**
```
Pontos: 850
Classificação: Prata
```

---

## Exemplos de Erros

### Exemplo 18: Erro - Variável Não Declarada

```java
// ERRO: Variável não declarada
escreva(x);  // x não foi declarada
```

**Mensagem de Erro:**
```
Erro semântico: Variável 'x' não foi declarada!
```

---

### Exemplo 19: Erro - Declaração Duplicada

```java
// ERRO: Declaração duplicada
inteiro x;
x = 10;

inteiro x;  // x já foi declarada
x = 20;
```

**Mensagem de Erro:**
```
Erro semântico: Variável 'x' já foi declarada!
```

---

### Exemplo 20: Erro - Tipo Incompatível

```java
// ERRO: Tipo incompatível
inteiro numero;
numero = "texto";  // Tentando atribuir texto a inteiro
```

**Mensagem de Erro:**
```
Erro semântico: Tipo incompatível para variável 'numero'
```

---

### Exemplo 21: Erro - Divisão por Zero

```java
// ERRO: Divisão por zero
inteiro x;
x = 10;

inteiro y;
y = 0;

inteiro resultado;
resultado = x / y;  // Divisão por zero
```

**Mensagem de Erro:**
```
Erro de execução: Divisão por zero!
```

---

### Exemplo 22: Erro - Condição Não Booleana

```java
// ERRO: Condição deve ser booleana
inteiro x;
x = 10;

se (x) {  // x é inteiro, não booleano
    escreva("Teste");
}
```

**Mensagem de Erro:**
```
Erro semântico: Expressão condicional deve ser do tipo booleano
```

---

## 📝 Notas Importantes

### Boas Práticas

1. **Sempre declare variáveis antes de usar**
2. **Use nomes descritivos para variáveis**
3. **Adicione comentários para explicar lógica complexa**
4. **Use parênteses para deixar precedência clara**
5. **Teste divisões para evitar divisão por zero**

### Convenções de Nomenclatura

- **Variáveis:** `camelCase` (ex: `minhaVariavel`, `numeroTotal`)
- **Constantes:** `MAIUSCULAS` (ex: `MAXIMO`, `MINIMO`)
- **Descritivo:** Use nomes que descrevam o propósito

### Formatação

- **Indentação:** 4 espaços ou 1 tab
- **Chaves:** Sempre use `{` `}` em blocos, mesmo com um comando
- **Espaçamento:** Use espaços ao redor de operadores

---

## 🚀 Próximos Passos

Experimente modificar estes exemplos e criar seus próprios programas! Consulte a [Especificação Completa](ESPECIFICACAO_COMPLETA.md) para mais detalhes sobre a linguagem.

---

**Desenvolvido para a linguagem "éle" v2.0**

