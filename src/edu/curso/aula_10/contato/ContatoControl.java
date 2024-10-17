package edu.curso.aula_10.contato;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ContatoControl {
    private StringProperty nome = new SimpleStringProperty();
    //private StringProperty email = new SimpleStringProperty();
    //private StringProperty telefone = new SimpleStringProperty();

    public StringProperty nomeProperty() {
        return nome;
    }

    public void mostrar() {
        System.out.println("Valor atual do nome: " + nome.get());
        nome.set("Nome em branco");
    }
}
