package edu.curso.Escola;

import java.time.LocalDate;

import edu.curso.Animal;

public class Pessoa extends Animal{
    String cpf = "";
    String nome = "";
    LocalDate nascimento = LocalDate.now();

    public Pessoa(String nome) {
        super();
        this.nome = nome;
        System.out.printf("Instânciando Pessoa (Nome: %s)%n", this.nome);
    }

}
