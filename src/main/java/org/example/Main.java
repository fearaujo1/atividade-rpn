package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ConversorRPN conversor = new ConversorRPN();
        CalculadoraRPN calculadora = new CalculadoraRPN();

        System.out.println("=================================");
        System.out.println("       CALCULADORA RPN");
        System.out.println("=================================");

        System.out.print("Digite uma expressão matemática: ");

        String expressao = scanner.nextLine();

        try {

            String expressaoRPN = conversor.converter(expressao);

            double resultado = calculadora.calcular(expressaoRPN);

            System.out.println();
            System.out.println("Expressão original: " + expressao);
            System.out.println("Expressão RPN: " + expressaoRPN);
            System.out.println("Resultado: " + resultado);

        } catch (IllegalArgumentException | ArithmeticException e) {

            System.out.println();
            System.out.println("Erro: " + e.getMessage());
        }

        scanner.close();
    }
}
