# Aula 16 - Padrão Singleton e Redirecionamento de Telas em JavaFX

## Singleton
- Em vez de fazer uma Connection em cada classe que implementa um DAO, utilizar apenas uma conexão ao banco, criando um `new Conexão` apenas dentro da classe Conexão
- Para isso, se usa uma instância de conexão estatica, só uma para a classe inteira, ou seja é uma agregação da classe, classe Conexão tem como atributo `private Conexão instância`, além de ter um `private Connection con`
- Construtor da classe é privado e para buscar a instância se usa um get, e outro get para Conection

## Redirecionamento de Telas JAVAFX
- Basta criar uma interface com um método de retorno de um painel `Pane renderizar()` a exemplo uma interface chamada `Tela`
- As Boundarys deveram implementar esta interface, não herdam mais de Application e deixam de ter o método main()
- Também é criado uma classe boundary para servir de Tela principal, esta terá um `HashMap<String, Tela>` contendo todas as boundarys que implementam a interface e as identificando com uma string para seu nome
- É usado: `MenuBar, Menu, MenuItem` para criar o menu de escolha de telas, em cada MenuItem estará contido uma boundary
- Em cada MenuItem é usado um método observador `setOnAction`, para quando clicado na opção seja feito o redirecionamento para a boundary desejada

## Necessário
- Driver do mariadb
- MYSQL instalado e seu serviço rodando
- Rodar o script do arquivo ./persistence/database.sql
- Executar o seguinte comando no terminal: `compilar_16.bat edu.curso.aula_16.view.ContatoBoundary`