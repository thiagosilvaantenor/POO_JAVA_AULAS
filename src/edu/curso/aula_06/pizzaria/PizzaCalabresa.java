package edu.curso.aula_06.pizzaria;

public class PizzaCalabresa extends Pizza{
    public PizzaCalabresa(){
        this.sabor = "Calabresa";
    }
    @Override
    public void preparar() {
        System.out.printf("Preparando pizza com sabor %s.%n", this.sabor);
        System.out.println("Molho, linguiça calabresa fatiada e cebola");
    }

    @Override
    public void assar() {
        System.out.printf("Assando pizza com sabor %s.%n", this.sabor);
        System.out.println("Deixando assar por 6 minutos");
    }
}
