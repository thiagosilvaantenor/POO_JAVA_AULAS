package edu.curso.aula_05;

public class Cobrador<T> {


    public void cobrarDinheiro(T objeto) {
        System.out.printf("Cobrando dinheiro da: %s.%n", objeto.getClass().getName());
    }
}
