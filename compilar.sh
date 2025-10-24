#!/bin/bash

# Script para executar o Compilador ELE

if [ -z "$1" ]; then
    echo "Uso: ./compilar.sh <arquivo.ele>"
    echo "Exemplo: ./compilar.sh teste.ele"
    exit 1
fi

ARQUIVO=$1

if [ ! -f "$ARQUIVO" ]; then
    echo "❌ Erro: Arquivo '$ARQUIVO' não encontrado!"
    exit 1
fi

echo "🔧 Compilando $ARQUIVO..."
echo ""

java -cp "target/classes:$HOME/.m2/repository/com/github/vbmacher/java-cup-runtime/11b-20160615/java-cup-runtime-11b-20160615.jar" \
    com.github.josue2oliveira.ele.Main "$ARQUIVO"

