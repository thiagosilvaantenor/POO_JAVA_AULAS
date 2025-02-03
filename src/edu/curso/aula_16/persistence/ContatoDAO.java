package edu.curso.aula_16.persistence;

import java.sql.SQLException;
import java.util.List;

import edu.curso.aula_16.model.AgendaException;
import edu.curso.aula_16.model.Contato;

public interface ContatoDAO {

    void inserir(Contato c) throws AgendaException;
    void atualizar(Contato c) throws AgendaException;
    void remover(Contato c) throws AgendaException;
    List<Contato> pesquisarPorNome(String nome) throws AgendaException;
    List<Contato> pesquisarTodos() throws AgendaException;
    
}
