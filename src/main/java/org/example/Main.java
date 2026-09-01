package org.example;

public class Main {

    public static void main(String[] args) {

        Pilha<Double> pilha = new Pilha<>();

        pilha.push(10.0);
        pilha.push(20.0);
        pilha.push(30.0);

        System.out.println("Topo: " + pilha.peek());
        System.out.println("Tamanho: " + pilha.size());

        System.out.println("Removido: " + pilha.pop());
        System.out.println("Novo topo: " + pilha.peek());
        System.out.println("Tamanho: " + pilha.size());
    }
}