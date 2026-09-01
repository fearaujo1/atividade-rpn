package org.example;

public class Main {

    public static void main(String[] args) {

        ConversorRPN conversor = new ConversorRPN();

        String expressao = "( 10.5 + 2.5 ) * 2";

        String rpn = conversor.converter(expressao);

        System.out.println("Expressão original: " + expressao);
        System.out.println("Expressão RPN: " + rpn);
    }
}