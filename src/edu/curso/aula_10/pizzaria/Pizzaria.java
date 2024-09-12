package edu.curso.aula_10.pizzaria;

public class Pizzaria {

    public static void main(String[] args){
        //Pizza p0 = new Pizza();
        Pizza p1 = new PizzaCalabresa();
        Pizza p2 = new PizzaMussarela();
        p1.preparar();
        p1.assar();
        p1.cortar();

        p2.preparar();
        p2.assar();
        p2.cortar();

    }
}
