package com.github.josue2oliveira.ele;

import java.io.FileReader;
import java_cup.runtime.Symbol;
import com.github.josue2oliveira.ele.parser.Lexer;
import com.github.josue2oliveira.ele.parser.parser; // note 'parser' minúsculo, verifique o gerado

public class Main {
    public static void main(String[] args) {
        try {
            String file = args.length > 0 ? args[0] : "teste.ele";
            Lexer lexer = new Lexer(new FileReader(file));
            parser p = new parser(lexer);
            Symbol result = p.parse();
            System.out.println("Compilação concluída!");
            System.out.println("Resultado: " + result.value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}