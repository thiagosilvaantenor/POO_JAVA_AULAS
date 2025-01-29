package edu.curso.aula_16;

import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EnderecoControl {

    private ObservableList<Endereco> lista = FXCollections.observableArrayList();
    private LongProperty id = new SimpleLongProperty(0l);
    private StringProperty logradouro = new SimpleStringProperty("");
    private IntegerProperty numero = new SimpleIntegerProperty(0);
    private StringProperty complemento = new SimpleStringProperty();
    private StringProperty bairro = new SimpleStringProperty("");
    private StringProperty cidade = new SimpleStringProperty("");
    private StringProperty estado = new SimpleStringProperty("");
    private StringProperty cep = new SimpleStringProperty("");

    private EnderecoDAO enderecoDAO = new EnderecoDAOImpl();

    private Long contador = 0l;

    public EnderecoControl() {

    }

    public void limparTudo(){
        id.set(0l);
        logradouro.set("");
        numero.set(0);
        bairro.set("");
        cidade.set("");
        estado.set("");
        cep.set("");

    }

    public void pesquisarTodos() throws AgendaException {
        List<Endereco> listaEnd = enderecoDAO.pesquisarTodos();
        lista.clear();
        lista.addAll(listaEnd);
    }

    public void pesquisarPorLogradouro() throws AgendaException {
        List<Endereco> listaEnd = enderecoDAO.pesquisarPorLogradouro(logradouro.get());
        lista.clear();
        lista.addAll(listaEnd);
    }

    public void gravar() throws AgendaException {
        //Captura tudo que esta na tela e coloca em uma entidade
        Endereco e = new Endereco();
        e.setLogradouro(logradouro.get());
        e.setNumero(numero.get());
        e.setComplemento(complemento.get());
        e.setCidade(cidade.get());
        e.setEstado(estado.get());
        e.setCep(cep.get());
        if (id.get() == 0) {
            contador += 1;
            e.setId(id.get());
            enderecoDAO.inserir(e);
        } else {
            
        }
        pesquisarTodos();
        limparTudo();
    }


    public void entidadeParaTela(Endereco e) { 
        if (e!=null) {
            this.id.set( e.getId() );
            this.logradouro.set(e.getLogradouro());
            this.numero.set(e.getNumero());
            this.bairro.set(e.getBairro());
            this.cidade.set(e.getCidade());
            this.estado.set(e.getEstado());
            this.cep.set(e.getCep());
        }
    }

    public LongProperty idProperty(){
        return id;
    }

    public StringProperty logradouroProperty() {
        return logradouro;
    }

    public IntegerProperty numeroProperty() {
        return numero;
    }

    public StringProperty bairroProperty() {
        return bairro;
    }

    public StringProperty cidadeProperty() {
        return cidade;
    }

    public StringProperty estadoProperty() {
        return estado;
    }
    public StringProperty cepProperty() {
        return cep;
    }
}
