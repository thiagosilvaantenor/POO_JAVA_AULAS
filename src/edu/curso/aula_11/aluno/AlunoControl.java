package edu.curso.aula_11.aluno;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AlunoControl {
    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty ra = new SimpleStringProperty("");
    private IntegerProperty idade= new SimpleIntegerProperty(0);
    private List<Aluno> alunos = new ArrayList<>();


    public StringProperty nomeProperty() {
        return nome;
    }

    public StringProperty raProperty() {
        return ra;
    }

    public IntegerProperty idadeProperty() {
        return idade;
    }


    public Aluno paraEntidade() {
        Aluno a = new Aluno();
        a.setNome(nome.get());
        a.setRa(ra.get());
        a.setIdade(idade.get());

        return a;
    }

    public void paraTela(Aluno a) {
        nome.set(a.getNome());
        ra.set(a.getRa());
        idade.set(a.getIdade());
    }

    public void salvar() {
       Aluno a = paraEntidade();
       alunos.add(a);
    }

    public void pesquisar() {
        for(Aluno a :alunos) {
            if(a.getNome().contains(nome.get())) {
                paraTela(a);
                break;
            }
        }
    }

    public void limpar() {
       nome.set("");
       ra.set("");
       idade.set(0);
    }
}
