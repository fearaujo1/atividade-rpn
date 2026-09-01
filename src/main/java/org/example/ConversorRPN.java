package org.example;

public class ConversorRPN {

    public String converter(String expressao) {

        Pilha<String> operadores = new Pilha<>();
        StringBuilder saida = new StringBuilder();

        String[] elementos = tokenizar(expressao);

        for (String elemento : elementos) {

            if (ehNumero(elemento)) {
                saida.append(elemento).append(" ");
            }

            else if (elemento.equals("(")) {
                operadores.push(elemento);
            }

            else if (elemento.equals(")")) {

                while (!operadores.isEmpty()
                        && !operadores.peek().equals("(")) {

                    saida.append(operadores.pop()).append(" ");
                }

                if (operadores.isEmpty()) {
                    throw new IllegalArgumentException(
                            "Parênteses desbalanceados."
                    );
                }

                operadores.pop();
            }

            else if (ehOperador(elemento)) {

                while (!operadores.isEmpty()
                        && !operadores.peek().equals("(")
                        && precedencia(operadores.peek()) >= precedencia(elemento)) {

                    saida.append(operadores.pop()).append(" ");
                }

                operadores.push(elemento);
            }

            else {
                throw new IllegalArgumentException(
                        "Elemento inválido: " + elemento
                );
            }
        }

        while (!operadores.isEmpty()) {

            if (operadores.peek().equals("(")) {
                throw new IllegalArgumentException(
                        "Parênteses desbalanceados."
                );
            }

            saida.append(operadores.pop()).append(" ");
        }

        return saida.toString().trim();
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

    private int precedencia(String operador) {

        if (operador.equals("*") || operador.equals("/")) {
            return 2;
        }

        if (operador.equals("+") || operador.equals("-")) {
            return 1;
        }

        return 0;
    }

    private String[] tokenizar(String expressao) {

        StringBuilder numero = new StringBuilder();
        java.util.List<String> elementos = new java.util.ArrayList<>();

        for (int i = 0; i < expressao.length(); i++) {

            char caractere = expressao.charAt(i);

            if (Character.isDigit(caractere) || caractere == '.') {

                numero.append(caractere);

            } else if (caractere == ' '
                    || caractere == '\t') {

                if (numero.length() > 0) {
                    elementos.add(numero.toString());
                    numero.setLength(0);
                }

            } else if (caractere == '+'
                    || caractere == '-'
                    || caractere == '*'
                    || caractere == '/'
                    || caractere == '('
                    || caractere == ')') {

                if (numero.length() > 0) {
                    elementos.add(numero.toString());
                    numero.setLength(0);
                }

                elementos.add(String.valueOf(caractere));

            } else {

                throw new IllegalArgumentException(
                        "Caractere inválido: " + caractere
                );
            }
        }

        if (numero.length() > 0) {
            elementos.add(numero.toString());
        }

        return elementos.toArray(new String[0]);
    }
}