package edu.curso.aula_10.interfaces;

public class EntregadorLiberal extends Entregador
        implements Motorista {

    @Override
    public void dirigir() {
        System.out.println("Dirgindo bem rápido...");
    }

    @Override
    public void abrirPorta() {
        System.out.println("Abrindo porta...");
    }
}
