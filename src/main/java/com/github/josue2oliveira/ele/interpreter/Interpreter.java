package com.github.josue2oliveira.ele.interpreter;

import com.github.josue2oliveira.ele.semantic.SymbolTable;

/**
 * Interpretador para executar o código ELE
 */
public class Interpreter {
    
    private SymbolTable symbolTable;
    
    public Interpreter(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }
    
    /**
     * Executa o comando Print
     */
    public void executePrint(Object value) {
        if (value == null) {
            System.out.println("null");
        } else {
            System.out.println(value);
        }
    }
    
    /**
     * Avalia uma operação binária
     */
    public Object evaluateBinary(Object left, String operator, Object right) {
        // Converte para tipos numéricos se necessário
        Number leftNum = toNumber(left);
        Number rightNum = toNumber(right);
        
        switch (operator) {
            // Operadores aritméticos
            case "+":
                if (isInteger(left) && isInteger(right)) {
                    return leftNum.intValue() + rightNum.intValue();
                }
                return leftNum.doubleValue() + rightNum.doubleValue();
                
            case "-":
                if (isInteger(left) && isInteger(right)) {
                    return leftNum.intValue() - rightNum.intValue();
                }
                return leftNum.doubleValue() - rightNum.doubleValue();
                
            case "*":
                if (isInteger(left) && isInteger(right)) {
                    return leftNum.intValue() * rightNum.intValue();
                }
                return leftNum.doubleValue() * rightNum.doubleValue();
                
            case "/":
                if (isInteger(left) && isInteger(right)) {
                    if (rightNum.intValue() == 0) {
                        throw new RuntimeException("Erro de execução: Divisão por zero!");
                    }
                    return leftNum.intValue() / rightNum.intValue();
                }
                if (rightNum.doubleValue() == 0.0) {
                    throw new RuntimeException("Erro de execução: Divisão por zero!");
                }
                return leftNum.doubleValue() / rightNum.doubleValue();
                
            case "%":
                if (!isInteger(left) || !isInteger(right)) {
                    throw new RuntimeException("Erro de execução: Operador % só funciona com inteiros!");
                }
                if (rightNum.intValue() == 0) {
                    throw new RuntimeException("Erro de execução: Módulo por zero!");
                }
                return leftNum.intValue() % rightNum.intValue();
                
            // Operadores relacionais
            case "==":
                return compareValues(left, right) == 0;
                
            case "!=":
                return compareValues(left, right) != 0;
                
            case "<":
                return compareValues(left, right) < 0;
                
            case ">":
                return compareValues(left, right) > 0;
                
            case "<=":
                return compareValues(left, right) <= 0;
                
            case ">=":
                return compareValues(left, right) >= 0;
                
            // Operadores lógicos
            case "&&":
                return toBoolean(left) && toBoolean(right);
                
            case "||":
                return toBoolean(left) || toBoolean(right);
                
            default:
                throw new RuntimeException("Operador desconhecido: " + operator);
        }
    }
    
    /**
     * Avalia uma operação unária
     */
    public Object evaluateUnary(String operator, Object operand) {
        switch (operator) {
            case "!":
                return !toBoolean(operand);
                
            case "-":
                Number num = toNumber(operand);
                if (isInteger(operand)) {
                    return -num.intValue();
                }
                return -num.doubleValue();
                
            default:
                throw new RuntimeException("Operador unário desconhecido: " + operator);
        }
    }
    
    /**
     * Converte um valor para número
     */
    private Number toNumber(Object value) {
        if (value instanceof Number) {
            return (Number) value;
        }
        if (value instanceof String) {
            try {
                return Double.parseDouble((String) value);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Erro de execução: Não é possível converter '" + value + "' para número!");
            }
        }
        throw new RuntimeException("Erro de execução: Tipo incompatível para operação numérica: " + value.getClass().getSimpleName());
    }
    
    /**
     * Converte um valor para booleano
     */
    private boolean toBoolean(Object value) {
        if (value instanceof Boolean) {
            return (Boolean) value;
        }
        if (value instanceof Number) {
            return ((Number) value).doubleValue() != 0;
        }
        if (value instanceof String) {
            return !((String) value).isEmpty();
        }
        return value != null;
    }
    
    /**
     * Verifica se um valor é inteiro
     */
    private boolean isInteger(Object value) {
        return value instanceof Integer;
    }
    
    /**
     * Compara dois valores
     */
    private int compareValues(Object left, Object right) {
        if (left instanceof Number && right instanceof Number) {
            double leftVal = ((Number) left).doubleValue();
            double rightVal = ((Number) right).doubleValue();
            return Double.compare(leftVal, rightVal);
        }
        
        if (left instanceof Boolean && right instanceof Boolean) {
            return Boolean.compare((Boolean) left, (Boolean) right);
        }
        
        if (left instanceof String && right instanceof String) {
            return ((String) left).compareTo((String) right);
        }
        
        // Comparação genérica
        if (left == null && right == null) return 0;
        if (left == null) return -1;
        if (right == null) return 1;
        
        return left.equals(right) ? 0 : -1;
    }
}

