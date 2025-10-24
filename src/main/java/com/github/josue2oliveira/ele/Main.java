package com.github.josue2oliveira.ele;

import com.github.josue2oliveira.ele.parser.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Compilador ELE ===");

        if (args.length == 0) {
            System.out.println("Uso: compilador-ele <arquivo.ele>");
            System.out.println("Exemplo: compilador-ele teste.ele");
            return;
        }

        String caminhoArquivo = args[0];
        System.out.println("Compilando: " + caminhoArquivo);

        try (BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivo))) {

            Lexer lexer = new Lexer(leitor);
            Parser parser = new Parser(lexer);

            // Faz o parsing (análise sintática)
            parser.parse();
            
            System.out.println("✅ Compilação concluída sem erros de sintaxe!");
            System.out.println("\n=== Executando o programa ===\n");
            
            // Executa o programa (AST)
            parser.getProgram().execute(parser.getSymbolTable(), parser.getInterpreter());
            
            // Mostra a tabela de símbolos
            System.out.println("\n" + parser.getSymbolTable().toString());

        } catch (FileNotFoundException e) {
            System.err.println("❌ Erro: Arquivo '" + caminhoArquivo + "' não encontrado!");
        } catch (Exception e) {
            System.err.println("❌ Erro durante a compilação:");
            e.printStackTrace();
        }
    }
}