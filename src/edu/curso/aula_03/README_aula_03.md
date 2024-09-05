# Aula 03

## Polimorfismo

Ad-hoc - Coerção: transformação do tipo de variaveis, ex: int a = 10; String a = "numero:" + a; o compilador vai transformar o numero inteiro em texto.


Ad-hoc - Sobrecarga (Overload): Reescrita de metodos, alterando seus parametros, ao ser chamado o metodo o compilador vai decidir qual chamar, de acordo com os argumentos/parametros utilizados
Ex: `int somaNumeros(int n1, int n2)  &&  int somaNumeros(int n1, int n2, int n3)`

Universal - Override: comportamentos de metodos de classes mae e filha, podem ser diferentes mesmo que tenham a mesma assinatura;
ex: Pessoa e Atleta podem ter o metodo public void andar(), embora tenham a mesma assinatura o comportamento será diferente.
- O tipo de retorno tem que ser o mesmo, ou subtipo
- Sem reducao de visibilidade (public, private, protected)
- Não pode lançar mais ou menos excpetions
- Sem final ou static
- A subclasse precisa conseguir acessar o metodo
- Opcional, embora recomendado para uma melhor leitura do codigo, usar a anotação `@Override` em cima da assinatura do metodo na subclasse
<br>
## Parametrizacao Generics:
Utilizando o `T` ou `<T>` permite criaççao de metodos com tipos de parametros genericos, porém na hora de utilizaça, exemplo: na chamada de um metodo, ele aceitara qualquer tipo exceto o T

## Modificadores:

- default(package)
    - Acessível apenas no mesmo pacote
    - Classes, metodos e variaveis de instâncias
    - Opção padrão, caso não seja escolhido nenhum outro modificador esta sera a opção escolhida
- public
    - aberto a todos
- private
    - Visivel apenas aquela classe
    - apenas metodos e variaveis de instâncias
    - dependendo do caso é necessario um método get
- protected
    - Parecido com o package, garante a herança dos filhos mesmo que esteja em outro pacote
    - Metodos e variaveis de instância
    - Visivel apenas aqueles que estão no mesmo pacote ou que sejam filhos