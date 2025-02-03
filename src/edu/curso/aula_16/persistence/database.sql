CREATE DATABASE agendadb;

USE agendadb;

CREATE TABLE contatos ( 
    id INT AUTO_INCREMENT,
    nome VARCHAR(100),
    email VARCHAR(100),
    telefone CHAR(30),
    nascimento DATE,
    PRIMARY KEY (id)
);

INSERT INTO contatos (nome, email, telefone, nascimento) 
 VALUES ('Joao Silva', 'joao@teste.com', '(11) 1111-1111', '2000-05-23');

CREATE TABLE enderecos (
    id INT AUTO_INCREMENT,
    logradouro VARCHAR(100),
    numero INT,
    complemento VARCHAR(100),
    bairro VARCHAR(100),
    cidade VARCHAR(100),
    estado VARCHAR(100),
    cep VARCHAR(8)
    PRIMARY KEY (id)
);
