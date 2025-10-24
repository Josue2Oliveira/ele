# Como Executar o Compilador ELE

## Pré-requisitos

- Java 11 ou superior
- Maven 3.6 ou superior

## Passo 1: Compilar o Projeto

Primeiro, compile o projeto com Maven:

```bash
mvn clean compile
```

Ou, se preferir gerar o JAR:

```bash
mvn clean package
```

## Passo 2: Executar o Compilador

Existem **3 formas** de executar o compilador:

### Opção 1: Usando o Script (Mais Fácil) ⭐

```bash
./compilar.sh teste.ele
```

### Opção 2: Usando Java Diretamente

```bash
java -cp "target/classes:$HOME/.m2/repository/com/github/vbmacher/java-cup-runtime/11b-20160615/java-cup-runtime-11b-20160615.jar" \
    com.github.josue2oliveira.ele.Main teste.ele
```

### Opção 3: Usando Maven Exec Plugin

Adicione ao `pom.xml` na seção `<build><plugins>`:

```xml
<plugin>
    <groupId>org.codehaus.mojo</groupId>
    <artifactId>exec-maven-plugin</artifactId>
    <version>3.1.0</version>
    <configuration>
        <mainClass>com.github.josue2oliveira.ele.Main</mainClass>
        <arguments>
            <argument>${arquivo}</argument>
        </arguments>
    </configuration>
</plugin>
```

E execute:

```bash
mvn exec:java -Darquivo=teste.ele
```

## Exemplos de Arquivos .ele

### Exemplo 1: Declarações e Expressões Simples

```java
int x = 10;
int y = 20;
int z = x + y;
```

### Exemplo 2: Estruturas Condicionais

```java
int idade = 18;

if (idade >= 18) {
    Print("Maior de idade");
}
```

### Exemplo 3: Expressões Complexas

```java
int a = 5;
int b = 10;
int c = 15;

if (a < b && b < c) {
    Print(a + b + c);
}
```

### Exemplo 4: Tipos Diferentes

```java
int numero = 42;
float pi = 3.14;
boolean ativo = true;
```

## Saída Esperada

Quando o arquivo é compilado com sucesso, você verá:

```
=== Compilador ELE ===
✅ Compilação concluída sem erros de sintaxe!
```

Se houver erros de sintaxe, o compilador mostrará mensagens de erro indicando o problema.

## Estrutura do Projeto

```
compilador-ele/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/github/josue2oliveira/ele/
│       │       └── Main.java
│       ├── jflex/
│       │   └── ele.flex
│       └── cup/
│           └── parser.cup
├── target/
│   ├── classes/
│   └── generated-sources/
│       ├── jflex/
│       └── cup/
├── pom.xml
├── compilar.sh
└── teste.ele
```

## Tokens Suportados

O compilador reconhece os seguintes elementos:

### Palavras-chave ELE
- `where`, `until`, `begin`, `end`, `X`, `Y`, `Print`

### Palavras-chave Java (compatibilidade)
- `if`, `else`, `for`, `while`, `do`
- `class`, `public`, `private`, `protected`
- `int`, `float`, `boolean`, `return`, `void`

### Operadores
- Aritméticos: `+`, `-`, `*`, `/`, `%`
- Relacionais: `==`, `!=`, `<`, `>`, `<=`, `>=`
- Lógicos: `&&`, `||`, `!`
- Atribuição: `=`

### Literais
- Inteiros: `42`, `0`, `1000`
- Ponto flutuante: `3.14`, `0.5`
- Booleanos: `true`, `false`
- Strings: `"texto"`
- Null: `null`

## Troubleshooting

### Erro: "cannot find symbol: class Parser"

Execute `mvn clean compile` novamente. O plugin antrun deve renomear automaticamente a classe.

### Erro: "invalid target release: 17"

Verifique se o Java 11 está instalado e configurado no `pom.xml`:
```xml
<maven.compiler.source>11</maven.compiler.source>
<maven.compiler.target>11</maven.compiler.target>
```

### Erro: "comando não encontrado: ./compilar.sh"

Torne o script executável:
```bash
chmod +x compilar.sh
```

