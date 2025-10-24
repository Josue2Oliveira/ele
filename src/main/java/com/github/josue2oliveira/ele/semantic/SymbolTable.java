package com.github.josue2oliveira.ele.semantic;

import java.util.HashMap;
import java.util.Map;

/**
 * Tabela de Símbolos para armazenar variáveis e seus valores
 */
public class SymbolTable {
    
    // Armazena o tipo de cada variável
    private Map<String, String> types = new HashMap<>();
    
    // Armazena o valor de cada variável
    private Map<String, Object> values = new HashMap<>();
    
    /**
     * Declara uma nova variável
     */
    public void declare(String name, String type) {
        if (types.containsKey(name)) {
            throw new RuntimeException("Erro semântico: Variável '" + name + "' já foi declarada!");
        }
        types.put(name, type);
        // Inicializa com valor padrão
        switch (type) {
            case "int":
                values.put(name, 0);
                break;
            case "float":
                values.put(name, 0.0);
                break;
            case "boolean":
                values.put(name, false);
                break;
            default:
                values.put(name, null);
        }
    }
    
    /**
     * Atribui um valor a uma variável
     */
    public void assign(String name, Object value) {
        if (!types.containsKey(name)) {
            throw new RuntimeException("Erro semântico: Variável '" + name + "' não foi declarada!");
        }
        
        String type = types.get(name);
        
        // Verificação de tipo
        if (!checkType(type, value)) {
            throw new RuntimeException("Erro semântico: Tipo incompatível para variável '" + name + 
                                     "'. Esperado: " + type + ", Recebido: " + getTypeName(value));
        }
        
        values.put(name, value);
    }
    
    /**
     * Obtém o valor de uma variável
     */
    public Object getValue(String name) {
        if (!types.containsKey(name)) {
            throw new RuntimeException("Erro semântico: Variável '" + name + "' não foi declarada!");
        }
        return values.get(name);
    }
    
    /**
     * Obtém o tipo de uma variável
     */
    public String getType(String name) {
        if (!types.containsKey(name)) {
            throw new RuntimeException("Erro semântico: Variável '" + name + "' não foi declarada!");
        }
        return types.get(name);
    }
    
    /**
     * Verifica se uma variável foi declarada
     */
    public boolean isDeclared(String name) {
        return types.containsKey(name);
    }
    
    /**
     * Verifica se o tipo do valor é compatível com o tipo esperado
     */
    private boolean checkType(String expectedType, Object value) {
        if (value == null) {
            return true; // null é compatível com qualquer tipo
        }
        
        switch (expectedType) {
            case "int":
                return value instanceof Integer;
            case "float":
                return value instanceof Double || value instanceof Float;
            case "boolean":
                return value instanceof Boolean;
            default:
                return true;
        }
    }
    
    /**
     * Obtém o nome do tipo de um valor
     */
    private String getTypeName(Object value) {
        if (value == null) return "null";
        if (value instanceof Integer) return "int";
        if (value instanceof Double || value instanceof Float) return "float";
        if (value instanceof Boolean) return "boolean";
        if (value instanceof String) return "string";
        return value.getClass().getSimpleName();
    }
    
    /**
     * Limpa a tabela de símbolos
     */
    public void clear() {
        types.clear();
        values.clear();
    }
    
    /**
     * Retorna uma representação em string da tabela
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Tabela de Símbolos ===\n");
        for (String name : types.keySet()) {
            sb.append(name).append(": ")
              .append(types.get(name)).append(" = ")
              .append(values.get(name)).append("\n");
        }
        return sb.toString();
    }
}

