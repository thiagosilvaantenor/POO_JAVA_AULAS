package edu.curso.aula_10.pizzaria;

public class PizzaMussarela extends Pizza{
    public PizzaMussarela(){
        this.sabor = "Mussarela";
    }
    @Override
    public void preparar() {
        System.out.printf("Preparando pizza com sabor %s.%n", this.sabor);
        System.out.println("Colocar molho e queijo mussarella");
    }

    @Override
    public void assar() {
        System.out.printf("Assando pizza com sabor %s.%n", this.sabor);
        System.out.println("Assar por 4 minutos");
        System.out.println("Adicionar oregano e azeitonas");
    }
}
