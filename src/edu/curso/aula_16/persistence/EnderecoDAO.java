package edu.curso.aula_16.persistence;

import java.util.List;

import edu.curso.aula_16.model.AgendaException;
import edu.curso.aula_16.model.Endereco;

public interface EnderecoDAO {
    void inserir(Endereco e) throws AgendaException;

    void atualizar(Endereco e) throws AgendaException;

    void excluir(Endereco e) throws AgendaException;

    List<Endereco> pesquisarTodos() throws AgendaException;

    List<Endereco> pesquisarPorLogradouro(String logradouro) throws AgendaException;
}
