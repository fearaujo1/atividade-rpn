package org.example;

import java.util.ArrayList;
import java.util.List;

public class Pilha<T> {

    private final List<T> elementos;

    // Cria a pilha
    public Pilha() {
        elementos = new ArrayList<>();
    }

    // Adiciona elemento na pilha
    public void push(T elemento) {
        elementos.add(elemento);
    }

    // Consulta e remove elemento da pilha
    public T pop() {
        if (isEmpty()) {
            throw new IllegalArgumentException("A pilha está vazia.");
        }

        return elementos.remove(elementos.size() - 1);
    }


    // Consulta elemento
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia.");
        }

        return elementos.get(elementos.size() - 1);
    }

    // Retorna true se tiver elementos vazios - não pode ter
    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    // Retorna quantos elementos tem - tamanho da pilja
    public int size() {
        return elementos.size();
    }
}
