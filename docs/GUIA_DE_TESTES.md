# Guia de Testes - Compilador ELE v2.0

## 🧪 Como Fazer os Testes

---

## Passo 1: Compilar o Projeto

Antes de testar, compile o projeto:

```bash
cd seu-projeto
mvn clean compile
```

**Resultado esperado:**
```
[INFO] BUILD SUCCESS
```

Se der erro, volte e verifique se todos os arquivos foram copiados corretamente.

---

## Passo 2: Executar os Testes

### 🎯 Teste 1: Declaração e Atribuição Separadas

**Criar arquivo:** `teste1.ele`

```java
int x;
x = 10;

int y;
y = 20;

int soma;
soma = x + y;

Print(soma);
```

**Executar:**
```bash
./compilar.sh teste1.ele
```

**Resultado esperado:**
```
=== Compilador ELE ===
Compilando: teste1.ele
✅ Compilação concluída sem erros de sintaxe!

=== Executando o programa ===
30

=== Tabela de Símbolos ===
x: int = 10
y: int = 20
soma: int = 30
```

**✅ PASSOU se:**
- Mostrou o número `30`
- Tabela de símbolos mostra as 3 variáveis

---

### 🎯 Teste 2: Expressões Aritméticas

**Criar arquivo:** `teste2.ele`

```java
int a = 10;
int b = 5;

int soma = a + b;
Print(soma);

int multiplicacao = a * b;
Print(multiplicacao);

int divisao = a / b;
Print(divisao);

int resto = a % b;
Print(resto);
```

**Executar:**
```bash
./compilar.sh teste2.ele
```

**Resultado esperado:**
```
=== Executando o programa ===
15
50
2
0
```

**✅ PASSOU se:**
- Mostrou: `15`, `50`, `2`, `0`

---

### 🎯 Teste 3: Expressões Relacionais e Booleanas

**Criar arquivo:** `teste3.ele`

```java
int a = 10;
int b = 20;

boolean maior = a > b;
Print(maior);

boolean menor = a < b;
Print(menor);

boolean igual = a == b;
Print(igual);

boolean diferente = a != b;
Print(diferente);
```

**Executar:**
```bash
./compilar.sh teste3.ele
```

**Resultado esperado:**
```
=== Executando o programa ===
false
true
false
true
```

**✅ PASSOU se:**
- Mostrou: `false`, `true`, `false`, `true`

---

### 🎯 Teste 4: If-Else (Teste Crítico!)

**Criar arquivo:** `teste4.ele`

```java
int x = 10;
int y = 20;

if (x < y) {
    Print(x);
} else {
    Print(y);
}
```

**Executar:**
```bash
./compilar.sh teste4.ele
```

**Resultado esperado:**
```
=== Executando o programa ===
10
```

**✅ PASSOU se:**
- Mostrou APENAS `10` (não mostrou `20`)
- Se mostrou ambos, o if-else está bugado!

---

### 🎯 Teste 5: If-Else (Bloco Else)

**Criar arquivo:** `teste5.ele`

```java
int x = 30;
int y = 20;

if (x < y) {
    Print(x);
} else {
    Print(y);
}
```

**Executar:**
```bash
./compilar.sh teste5.ele
```

**Resultado esperado:**
```
=== Executando o programa ===
20
```

**✅ PASSOU se:**
- Mostrou APENAS `20` (não mostrou `30`)
- O bloco else executou corretamente

---

### 🎯 Teste 6: Tipos Diferentes

**Criar arquivo:** `teste6.ele`

```java
int numero = 42;
Print(numero);

float decimal = 3.14;
Print(decimal);

boolean ativo = true;
Print(ativo);

boolean inativo = false;
Print(inativo);
```

**Executar:**
```bash
./compilar.sh teste6.ele
```

**Resultado esperado:**
```
=== Executando o programa ===
42
3.14
true
false
```

**✅ PASSOU se:**
- Mostrou todos os 4 valores corretamente

---

### 🎯 Teste 7: Operadores Lógicos

**Criar arquivo:** `teste7.ele`

```java
boolean a = true;
boolean b = false;

boolean e = a && b;
Print(e);

boolean ou = a || b;
Print(ou);

boolean nao = !a;
Print(nao);
```

**Executar:**
```bash
./compilar.sh teste7.ele
```

**Resultado esperado:**
```
=== Executando o programa ===
false
true
false
```

**✅ PASSOU se:**
- Mostrou: `false`, `true`, `false`

---

### 🎯 Teste 8: Exemplo Completo

**Criar arquivo:** `teste8.ele`

```java
int a;
a = 10;

int b;
b = 20;

int soma;
soma = a + b;
Print(soma);

boolean maior;
maior = a < b;

if (maior) {
    Print(a);
} else {
    Print(b);
}

float pi = 3.14;
Print(pi);
```

**Executar:**
```bash
./compilar.sh teste8.ele
```

**Resultado esperado:**
```
=== Executando o programa ===
30
10
3.14
```

**✅ PASSOU se:**
- Mostrou: `30`, `10`, `3.14`

---

## 🧪 Testes de Erro (Análise Semântica)

### 🔴 Teste 9: Variável Não Declarada

**Criar arquivo:** `teste_erro1.ele`

```java
Print(z);
```

**Executar:**
```bash
./compilar.sh teste_erro1.ele
```

**Resultado esperado:**
```
❌ Erro durante a compilação:
RuntimeException: Erro semântico: Variável 'z' não foi declarada!
```

**✅ PASSOU se:**
- Mostrou erro de variável não declarada

---

### 🔴 Teste 10: Declaração Duplicada

**Criar arquivo:** `teste_erro2.ele`

```java
int x = 10;
int x = 20;
```

**Executar:**
```bash
./compilar.sh teste_erro2.ele
```

**Resultado esperado:**
```
❌ Erro durante a compilação:
RuntimeException: Erro semântico: Variável 'x' já foi declarada!
```

**✅ PASSOU se:**
- Mostrou erro de declaração duplicada

---

### 🔴 Teste 11: Tipo Incompatível

**Criar arquivo:** `teste_erro3.ele`

```java
int x;
x = true;
```

**Executar:**
```bash
./compilar.sh teste_erro3.ele
```

**Resultado esperado:**
```
❌ Erro durante a compilação:
RuntimeException: Erro semântico: Tipo incompatível
```

**✅ PASSOU se:**
- Mostrou erro de tipo incompatível

---

### 🔴 Teste 12: Divisão por Zero

**Criar arquivo:** `teste_erro4.ele`

```java
int x = 10;
int y = 0;
int z = x / y;
Print(z);
```

**Executar:**
```bash
./compilar.sh teste_erro4.ele
```

**Resultado esperado:**
```
❌ Erro durante a compilação:
RuntimeException: Erro de execução: Divisão por zero!
```

**✅ PASSOU se:**
- Mostrou erro de divisão por zero

---

## 📊 Resumo dos Testes

### Testes Funcionais (8 testes)

| # | Teste | Status |
|---|-------|--------|
| 1 | Declaração e Atribuição Separadas | ⬜ |
| 2 | Expressões Aritméticas | ⬜ |
| 3 | Expressões Relacionais | ⬜ |
| 4 | If-Else (bloco if) | ⬜ |
| 5 | If-Else (bloco else) | ⬜ |
| 6 | Tipos Diferentes | ⬜ |
| 7 | Operadores Lógicos | ⬜ |
| 8 | Exemplo Completo | ⬜ |

### Testes de Erro (4 testes)

| # | Teste | Status |
|---|-------|--------|
| 9 | Variável Não Declarada | ⬜ |
| 10 | Declaração Duplicada | ⬜ |
| 11 | Tipo Incompatível | ⬜ |
| 12 | Divisão por Zero | ⬜ |

---

## 🚀 Script de Teste Automático

Criei um script que executa todos os testes automaticamente!

**Arquivo:** `executar_testes.sh`

```bash
#!/bin/bash

echo "=== Executando Testes do Compilador ELE v2.0 ==="
echo ""

TOTAL=0
PASSOU=0
FALHOU=0

# Função para executar teste
executar_teste() {
    local nome=$1
    local arquivo=$2
    local esperado=$3
    
    echo "🧪 Teste: $nome"
    TOTAL=$((TOTAL + 1))
    
    resultado=$(./compilar.sh "$arquivo" 2>&1)
    
    if echo "$resultado" | grep -q "$esperado"; then
        echo "   ✅ PASSOU"
        PASSOU=$((PASSOU + 1))
    else
        echo "   ❌ FALHOU"
        echo "   Esperado: $esperado"
        FALHOU=$((FALHOU + 1))
    fi
    echo ""
}

# Testes funcionais
executar_teste "Declaração e Atribuição" "teste1.ele" "30"
executar_teste "Expressões Aritméticas" "teste2.ele" "15"
executar_teste "If-Else (bloco if)" "teste4.ele" "10"
executar_teste "Tipos Diferentes" "teste6.ele" "3.14"
executar_teste "Exemplo Completo" "teste8.ele" "30"

# Testes de erro
executar_teste "Variável Não Declarada" "teste_erro1.ele" "não foi declarada"
executar_teste "Declaração Duplicada" "teste_erro2.ele" "já foi declarada"

echo "=== Resumo ==="
echo "Total: $TOTAL"
echo "Passou: $PASSOU ✅"
echo "Falhou: $FALHOU ❌"
echo ""

if [ $FALHOU -eq 0 ]; then
    echo "🎉 TODOS OS TESTES PASSARAM!"
else
    echo "⚠️ Alguns testes falharam. Verifique os erros acima."
fi
```

**Como usar:**

```bash
chmod +x executar_testes.sh
./executar_testes.sh
```

---

## 📝 Criar Todos os Arquivos de Teste de Uma Vez

Use este script para criar todos os arquivos de teste:

```bash
#!/bin/bash

# Teste 1
cat > teste1.ele << 'EOF'
int x;
x = 10;
int y;
y = 20;
int soma;
soma = x + y;
Print(soma);
EOF

# Teste 2
cat > teste2.ele << 'EOF'
int a = 10;
int b = 5;
int soma = a + b;
Print(soma);
int multiplicacao = a * b;
Print(multiplicacao);
int divisao = a / b;
Print(divisao);
int resto = a % b;
Print(resto);
EOF

# Teste 3
cat > teste3.ele << 'EOF'
int a = 10;
int b = 20;
boolean maior = a > b;
Print(maior);
boolean menor = a < b;
Print(menor);
boolean igual = a == b;
Print(igual);
boolean diferente = a != b;
Print(diferente);
EOF

# Teste 4
cat > teste4.ele << 'EOF'
int x = 10;
int y = 20;
if (x < y) {
    Print(x);
} else {
    Print(y);
}
EOF

# Teste 5
cat > teste5.ele << 'EOF'
int x = 30;
int y = 20;
if (x < y) {
    Print(x);
} else {
    Print(y);
}
EOF

# Teste 6
cat > teste6.ele << 'EOF'
int numero = 42;
Print(numero);
float decimal = 3.14;
Print(decimal);
boolean ativo = true;
Print(ativo);
boolean inativo = false;
Print(inativo);
EOF

# Teste 7
cat > teste7.ele << 'EOF'
boolean a = true;
boolean b = false;
boolean e = a && b;
Print(e);
boolean ou = a || b;
Print(ou);
boolean nao = !a;
Print(nao);
EOF

# Teste 8
cat > teste8.ele << 'EOF'
int a;
a = 10;
int b;
b = 20;
int soma;
soma = a + b;
Print(soma);
boolean maior;
maior = a < b;
if (maior) {
    Print(a);
} else {
    Print(b);
}
float pi = 3.14;
Print(pi);
EOF

# Testes de erro
cat > teste_erro1.ele << 'EOF'
Print(z);
EOF

cat > teste_erro2.ele << 'EOF'
int x = 10;
int x = 20;
EOF

cat > teste_erro3.ele << 'EOF'
int x;
x = true;
EOF

cat > teste_erro4.ele << 'EOF'
int x = 10;
int y = 0;
int z = x / y;
Print(z);
EOF

echo "✅ Todos os arquivos de teste foram criados!"
```

Salve como `criar_testes.sh` e execute:

```bash
chmod +x criar_testes.sh
./criar_testes.sh
```

---

## 🎯 Teste Rápido (1 minuto)

Se você só quer um teste rápido:

```bash
# Criar arquivo
cat > teste_rapido.ele << 'EOF'
int x;
x = 10;
Print(x);
EOF

# Executar
./compilar.sh teste_rapido.ele
```

**Se mostrar `10`, está funcionando!** ✅

---

## 🆘 Problemas Comuns

### Problema: "comando não encontrado: ./compilar.sh"

**Solução:**
```bash
chmod +x compilar.sh
```

### Problema: "BUILD FAILURE"

**Solução:** Você não copiou todos os arquivos. Revise o guia de atualização.

### Problema: Print não mostra valores

**Solução:** Você não substituiu o `Main.java` pelo novo.

### Problema: If-else executa ambos os blocos

**Solução:** Você não substituiu o `parser.cup` pelo novo.

---

## ✅ Conclusão

Execute os testes na ordem e marque os que passaram. Se todos passarem, **seu compilador está 100% funcional!** 🎉

