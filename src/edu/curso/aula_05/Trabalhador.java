package edu.curso.aula_05;

public class Trabalhador {
    public String nome;
    private int horas;

    public Trabalhador(String nome, int horas) {
        this.nome = nome;
        this.horas = horas;
    }

    public int getHoras() {
        return horas;
    }
    
    public void receberSalario(double salario) {
        System.out.printf("Trabalhador %s recebeu %7.2f%n", this.nome, salario);
    }
}
