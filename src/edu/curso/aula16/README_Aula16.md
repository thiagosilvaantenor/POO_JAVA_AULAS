# Aula 16
## Padrão Singleton
- Em vez de fazer uma Connection em cada classe que implementa um DAO, utilizar apenas uma conexão ao banco, criando um `new Conexão` apenas dentro da classe Conexão
- Para isso, se usa uma instância de conexão estatica, só uma para a classe inteira, ou seja é uma agregação da classe, classe Conexão tem como atributo `private Conexão instância`, além de ter um `private Connection con`
- Construtor da classe é privado e para buscar a instância se usa um get, e outro get para Conection