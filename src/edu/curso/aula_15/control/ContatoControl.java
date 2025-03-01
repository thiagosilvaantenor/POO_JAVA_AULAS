package edu.curso.aula_15.control;

import java.time.LocalDate;

import edu.curso.aula_15.model.Contato;
import edu.curso.aula_15.model.ContatoException;
import edu.curso.aula_15.persistence.ContatoDAO;
import edu.curso.aula_15.persistence.ContatoDAOImpl;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ContatoControl {

    private ObservableList<Contato> lista = FXCollections.observableArrayList();
    private IntegerProperty id = new SimpleIntegerProperty(0);
    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty email = new SimpleStringProperty("");
    private StringProperty telefone = new SimpleStringProperty("");
    private ObjectProperty<LocalDate> nascimento = new SimpleObjectProperty<>(LocalDate.now());

    private ContatoDAO contatoDAO;

    private int contador = 2;

    public ContatoControl() throws ContatoException{ 
        contatoDAO = new ContatoDAOImpl();
    }

    public void entidadeParaTela(Contato c) { 
        if (c!=null) {
            this.id.set( c.getId() );
            this.nome.set(c.getNome());
            this.telefone.set(c.getTelefone());
            this.email.set(c.getEmail());
            this.nascimento.set(c.getNascimento());
        }
    }

    public void excluir( Contato c )  throws ContatoException { 
        System.out.println("Excluido contato com nome: " + c.getNome());
        contatoDAO.remover(c);
        pesquisarTodos();
    }

    public void gravar() throws ContatoException { 
        Contato c = new Contato();
        c.setNome( this.nome.get() );
        c.setTelefone( this.telefone.get() );
        c.setEmail( this.email.get() );
        c.setNascimento( this.nascimento.get() );

        if (id.get() == 0) { 
            contador += 1;
            c.setId(contador);   
            contatoDAO.inserir(c);
        } else { 
            c.setId( id.get() );
            contatoDAO.atualizar(c);
        }
        pesquisarTodos();
        limparTudo();
        System.out.println("Lista tamanho: " + lista.size());
    }

    public void limparTudo() { 
        id.set(0);
        nome.set("");
        telefone.set("");
        email.set("");
        nascimento.set(LocalDate.now());
    }

    public void pesquisarPorNome()  throws ContatoException { 
        lista.clear();
        lista.addAll( contatoDAO.pesquisarPorNome( nome.get() ) );
    }

    public void pesquisarTodos()  throws ContatoException { 
        lista.clear();
        lista.addAll(contatoDAO.pesquisarTodos());
    }


    public ObservableList<Contato> getLista() { 
        return this.lista;
    }

    public IntegerProperty idProperty() { 
        return this.id;
    }
    public StringProperty nomeProperty() { 
        return this.nome;
    }
    public StringProperty emailProperty() { 
        return this.email;
    }
    public StringProperty telefoneProperty() { 
        return this.telefone;
    }
    public ObjectProperty<LocalDate> nascimentoProperty() { 
        return this.nascimento;
    }
}