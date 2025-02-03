package edu.curso.aula_16.control;

import edu.curso.aula_16.model.AgendaException;
import edu.curso.aula_16.model.Endereco;
import edu.curso.aula_16.persistence.EnderecoDAO;
import edu.curso.aula_16.persistence.EnderecoDAOImpl;
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

    private EnderecoDAO enderecoDAO;

    private Long contador = 0l;

    public EnderecoControl() throws AgendaException {
        enderecoDAO = new EnderecoDAOImpl();
    }

    public void entidadeParaTela(Endereco e) {
        if (e != null) {
            this.id.set(e.getId());
            this.logradouro.set(e.getLogradouro());
            this.numero.set(e.getNumero());
            this.bairro.set(e.getBairro());
            this.cidade.set(e.getCidade());
            this.estado.set(e.getEstado());
            this.cep.set(e.getCep());
        }
    }

    public void limparTudo() {
        id.set(0);
        logradouro.set("");
        numero.set(0);
        bairro.set("");
        cidade.set("");
        estado.set("");
        cep.set("");

    }

    public void pesquisarTodos() throws AgendaException {
        lista.clear();
        lista.addAll(enderecoDAO.pesquisarTodos());
    }

    public void pesquisarPorLogradouro() throws AgendaException {
        lista.clear();
        lista.addAll(enderecoDAO.pesquisarPorLogradouro(logradouro.get()));
    }

    public void gravar() throws AgendaException {
        // Captura tudo que esta na tela e coloca em uma entidade
        Endereco e = new Endereco();
        e.setLogradouro(this.logradouro.get());
        e.setNumero(this.numero.get());
        e.setComplemento(this.complemento.get());
        e.setCidade(this.cidade.get());
        e.setEstado(this.estado.get());
        e.setCep(this.cep.get());

        if (id.get() == 0) {
            contador += 1l;
            e.setId(contador);
            enderecoDAO.inserir(e);
        } else {
            e.setId(id.get());
            enderecoDAO.atualizar(e);
        }
        pesquisarTodos();
        limparTudo();
        System.out.println("Lista tamanho: " + lista.size());
    }

    public void excluir(Endereco endereco) throws AgendaException {
        System.out.println("Excluindo endereco com logradouro: " + endereco.getLogradouro());
        enderecoDAO.excluir(endereco);
        pesquisarTodos();
    }

    public ObservableList<Endereco> getLista() {
        return lista;
    }

    public LongProperty idProperty() {
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

    public StringProperty complementoProperty() {
        return complemento;
    }
}
