# Compilador da Linguagem "éle"

![Status](https://img.shields.io/badge/status-funcional-brightgreen)
![Versão](https://img.shields.io/badge/versão-2.0-blue)
![Testes](https://img.shields.io/badge/testes-12%2F12%20passando-success)
![Java](https://img.shields.io/badge/Java-11-orange)

Compilador completo para a linguagem de programação "éle" - uma linguagem imperativa, estruturada e com tipagem estática, desenvolvida como projeto acadêmico da disciplina de Compiladores.

---

## 📋 Sobre a Linguagem "éle"

**"éle"** é uma linguagem de programação de propósito geral, inspirada na sintaxe de Java e C, projetada para fins educacionais. O compilador implementa todas as fases de compilação: análise léxica, sintática, semântica e execução/interpretação.

### Características

- ✅ **Imperativa e Estruturada**
- ✅ **Tipagem Estática**
- ✅ **Sintaxe Inspirada em Java/C**
- ✅ **Análise Semântica Completa**
- ✅ **Execução Imediata (Interpretador)**

---

## 🚀 Quick Start

### Pré-requisitos

- Java 11 ou superior
- Maven 3.x
- Git

### Instalação

```bash
# Clonar o repositório
git clone https://github.com/seu-usuario/compilador-ele.git
cd compilador-ele

# Compilar o projeto
mvn clean compile

# Executar um exemplo
./compilar.sh exemplo.ele
```

### Primeiro Programa

Crie um arquivo `ola.ele`:

```java
// Meu primeiro programa em éle
inteiro numero;
numero = 42;

se (numero > 40) {
    escreva("O número é maior que 40!");
} senao {
    escreva("O número é menor ou igual a 40.");
}
```

Execute:

```bash
./compilar.sh ola.ele
```

**Saída:**
```
=== Compilador ELE ===
Compilando: ola.ele
✅ Compilação concluída sem erros de sintaxe!

=== Executando o programa ===
O número é maior que 40!

=== Tabela de Símbolos ===
numero: inteiro = 42
```

---

## 📖 Especificação da Linguagem

### Tipos de Dados

| Tipo | Descrição | Exemplo |
|------|-----------|---------|
| `inteiro` | Números inteiros de 32 bits | `42`, `-10`, `0` |
| `texto` | Sequência de caracteres imutável | `"Olá, mundo!"` |
| `booleano` | Valores lógicos | `verdadeiro`, `falso` |

### Palavras-Chave

```
inteiro    texto      booleano
se         senao      escreva
verdadeiro falso
```

### Operadores

**Aritméticos:** `+`, `-`, `*`, `/`  
**Relacionais:** `==`, `!=`, `>`, `<`  
**Atribuição:** `=`

### Sintaxe Básica

#### Declaração de Variáveis

```java
inteiro idade;
texto nome;
booleano ativo;
```

#### Atribuição

```java
idade = 25;
nome = "João";
ativo = verdadeiro;
```

#### Expressões Aritméticas

```java
inteiro a;
a = 10;

inteiro b;
b = (a + 5) * 2;  // b = 30
```

#### Estrutura Condicional

```java
se (idade > 18) {
    escreva("Maior de idade");
} senao {
    escreva("Menor de idade");
}
```

#### Comando de Saída

```java
escreva("Olá, mundo!");
escreva("O valor é: ", numero);
escreva("a = ", a, ", b = ", b);
```

#### Comentários

```java
// Este é um comentário de linha única
inteiro x;  // Comentário após código
```

---

## 🏗️ Arquitetura do Compilador

### Componentes Principais

```
┌─────────────────────────────────────────────┐
│           Código Fonte (.ele)               │
└─────────────────┬───────────────────────────┘
                  │
                  ▼
┌─────────────────────────────────────────────┐
│      Análise Léxica (JFlex)                 │
│      - Reconhecimento de tokens             │
│      - Palavras-chave, identificadores      │
└─────────────────┬───────────────────────────┘
                  │
                  ▼
┌─────────────────────────────────────────────┐
│      Análise Sintática (CUP)                │
│      - Validação da gramática               │
│      - Construção da AST                    │
└─────────────────┬───────────────────────────┘
                  │
                  ▼
┌─────────────────────────────────────────────┐
│      Análise Semântica                      │
│      - Verificação de tipos                 │
│      - Verificação de escopo                │
│      - Tabela de símbolos                   │
└─────────────────┬───────────────────────────┘
                  │
                  ▼
┌─────────────────────────────────────────────┐
│      Interpretação/Execução                 │
│      - Avaliação de expressões              │
│      - Execução de comandos                 │
│      - Saída de resultados                  │
└─────────────────────────────────────────────┘
```

### Estrutura do Projeto

```
compilador-ele/
├── src/main/
│   ├── jflex/
│   │   └── ele.flex              # Especificação do Lexer
│   ├── cup/
│   │   └── parser.cup            # Especificação do Parser
│   └── java/com/github/josue2oliveira/ele/
│       ├── Main.java             # Ponto de entrada
│       ├── ast/                  # Árvore Sintática Abstrata
│       │   ├── ASTNode.java
│       │   ├── Program.java
│       │   ├── Expression.java
│       │   ├── BinaryExpression.java
│       │   ├── UnaryExpression.java
│       │   ├── LiteralExpression.java
│       │   ├── VariableExpression.java
│       │   ├── DeclStatement.java
│       │   ├── AssignStatement.java
│       │   ├── IfStatement.java
│       │   ├── PrintStatement.java
│       │   └── BlockStatement.java
│       ├── semantic/
│       │   └── SymbolTable.java  # Tabela de Símbolos
│       └── interpreter/
│           └── Interpreter.java  # Interpretador
├── pom.xml                       # Configuração Maven
├── compilar.sh                   # Script de execução
├── criar_testes.sh               # Criação de testes
├── executar_testes.sh            # Execução de testes
└── README.md                     # Este arquivo
```

---

## 🧪 Testes

### Executar Todos os Testes

```bash
# Criar arquivos de teste
./criar_testes.sh

# Executar suíte completa
./executar_testes.sh
```

### Resultados dos Testes

| # | Teste | Status |
|---|-------|--------|
| 1 | Declaração e Atribuição Separadas | ✅ PASSOU |
| 2 | Expressões Aritméticas | ✅ PASSOU |
| 3 | Expressões Relacionais | ✅ PASSOU |
| 4 | If-Else (bloco if) | ✅ PASSOU |
| 5 | If-Else (bloco else) | ✅ PASSOU |
| 6 | Tipos Diferentes | ✅ PASSOU |
| 7 | Operadores Lógicos | ✅ PASSOU |
| 8 | Exemplo Completo | ✅ PASSOU |
| 9 | Variável Não Declarada (erro) | ✅ PASSOU |
| 10 | Declaração Duplicada (erro) | ✅ PASSOU |
| 11 | Tipo Incompatível (erro) | ✅ PASSOU |
| 12 | Divisão por Zero (erro) | ✅ PASSOU |

**Taxa de Sucesso: 12/12 (100%)** ✅

---

## 📚 Documentação

- [Especificação da Linguagem](docs/especificacao.md)
- [Guia de Instalação](docs/GUIA_INSTALACAO.md)
- [Guia de Uso](docs/COMO_EXECUTAR.md)
- [Guia de Testes](docs/GUIA_DE_TESTES.md)
- [Relatório Técnico](docs/Relatorio_Compilador_ELE.pdf)

---

## 🎯 Funcionalidades Implementadas

### ✅ Análise Léxica
- Reconhecimento de palavras-chave em português
- Identificadores e literais
- Operadores aritméticos e relacionais
- Comentários de linha única

### ✅ Análise Sintática
- Validação da gramática EBNF
- Construção de AST
- Tratamento de precedência de operadores
- Blocos de comandos aninhados

### ✅ Análise Semântica
- Tabela de símbolos
- Verificação de tipos estática
- Verificação de escopo
- Detecção de variáveis não declaradas
- Detecção de redeclaração

### ✅ Interpretação/Execução
- Avaliação de expressões aritméticas
- Avaliação de expressões relacionais
- Execução de estruturas condicionais
- Comando de saída (escreva)
- Tratamento de erros de execução

---

## 🔄 Roadmap

### Versão 2.0 (Atual) ✅
- [x] Análise léxica completa
- [x] Análise sintática completa
- [x] Análise semântica
- [x] Interpretador funcional
- [x] Suporte a comentários
- [x] Testes automatizados

### Versão 3.0 (Planejado)
- [ ] Estruturas de repetição (`enquanto`, `para`)
- [ ] Funções definidas pelo usuário
- [ ] Arrays e strings manipuláveis
- [ ] Operadores lógicos (`e`, `ou`, `nao`)

### Versão 4.0 (Futuro)
- [ ] Geração de código intermediário
- [ ] Otimizações de código
- [ ] Suporte a módulos/imports
- [ ] Sistema de tipos mais rico

---

## 🛠️ Tecnologias Utilizadas

- **Java 11** - Linguagem de implementação
- **JFlex 1.9.1** - Gerador de analisadores léxicos
- **CUP 11b** - Gerador de analisadores sintáticos
- **Maven 3.x** - Gerenciamento de build e dependências
- **JUnit** - Framework de testes (planejado)

---

## 📝 Exemplos de Código

### Exemplo 1: Calculadora Simples

```java
// Calculadora simples
inteiro a;
a = 10;

inteiro b;
b = 5;

inteiro soma;
soma = a + b;

inteiro multiplicacao;
multiplicacao = a * b;

escreva("Soma: ", soma);
escreva("Multiplicação: ", multiplicacao);
```

### Exemplo 2: Verificação de Maioridade

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

### Exemplo 3: Comparação de Números

```java
// Comparação de números
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

---

## 🤝 Contribuindo

Contribuições são bem-vindas! Para contribuir:

1. Fork o projeto
2. Crie uma branch para sua feature (`git checkout -b feature/MinhaFeature`)
3. Commit suas mudanças (`git commit -m 'Adiciona MinhaFeature'`)
4. Push para a branch (`git push origin feature/MinhaFeature`)
5. Abra um Pull Request

---

## 👥 Autores

- **Josué Lima de Oliveira** - Desenvolvedor Principal
- **João Colombo** - Colaborador

---

## 👩‍🏫 Orientação

- **Professora:** Luciana Correia
- **Disciplina:** Compiladores
- **Curso:** Engenharia de Computação

---

## 📄 Licença

Este projeto é um trabalho acadêmico desenvolvido para fins educacionais.

---

## 🙏 Agradecimentos

- Professora Luciana Correia pela orientação
- Comunidade JFlex e CUP pela documentação
- Autores dos livros de referência em compiladores

---

## 📞 Contato

Para dúvidas ou sugestões, abra uma issue no GitHub.

---

## 📊 Estatísticas do Projeto

- **Linhas de Código:** ~3.000
- **Classes Java:** 17
- **Testes Automatizados:** 12
- **Taxa de Cobertura:** 100%
- **Tempo de Desenvolvimento:** 2 meses

---

**Desenvolvido com ❤️ para a disciplina de Compiladores**

