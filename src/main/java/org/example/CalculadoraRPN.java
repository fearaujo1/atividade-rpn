package org.example;

public class CalculadoraRPN {

    public double calcular(String expressaoRPN) {

        Pilha<Double> valores = new Pilha<>();

        String[] elementos = expressaoRPN.trim().split("\\s+");

        for (String elemento : elementos) {

            if (ehNumero(elemento)) {

                valores.push(Double.parseDouble(elemento));

            } else if (ehOperador(elemento)) {

                if (valores.size() < 2) {
                    throw new IllegalArgumentException(
                            "Expressão RPN inválida."
                    );
                }

                double segundoOperando = valores.pop();
                double primeiroOperando = valores.pop();

                double resultado = realizarOperacao(
                        primeiroOperando,
                        segundoOperando,
                        elemento
                );

                valores.push(resultado);

            } else {

                throw new IllegalArgumentException(
                        "Elemento inválido: " + elemento
                );
            }
        }

        if (valores.size() != 1) {
            throw new IllegalArgumentException(
                    "Expressão RPN inválida."
            );
        }

        return valores.pop();
    }

    private boolean ehNumero(String elemento) {

        try {
            Double.parseDouble(elemento);
            return true;

        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean ehOperador(String elemento) {

        return elemento.equals("+")
                || elemento.equals("-")
                || elemento.equals("*")
                || elemento.equals("/");
    }

    private double realizarOperacao(
            double primeiro,
            double segundo,
            String operador) {

        switch (operador) {

            case "+":
                return primeiro + segundo;

            case "-":
                return primeiro - segundo;

            case "*":
                return primeiro * segundo;

            case "/":

                if (segundo == 0) {
                    throw new ArithmeticException(
                            "Não é possível dividir por zero."
                    );
                }

                return primeiro / segundo;

            default:
                throw new IllegalArgumentException(
                        "Operador inválido: " + operador
                );
        }
    }
}