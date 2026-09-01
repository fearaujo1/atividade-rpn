package org.example;

public class Main {

    public static void main(String[] args) {

        CalculadoraRPN calculadora = new CalculadoraRPN();

        String expressaoRPN = "10 5 2 * +";

        double resultado = calculadora.calcular(expressaoRPN);

        System.out.println("RPN: " + expressaoRPN);
        System.out.println("Resultado: " + resultado);
    }
}