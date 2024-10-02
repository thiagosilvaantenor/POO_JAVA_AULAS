package edu.curso.aula_05;

public class Pessoa {
    public String cpf;
    public String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }
    
    public void andar(){
        System.out.printf("Pessoa %s andando...", this.nome);
    }
}
