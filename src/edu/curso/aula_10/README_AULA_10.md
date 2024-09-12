# Modificadores

## Abstract

- identifica o obj como incompleto
- Uma classe que não pode criar um objeto, não pode usar o new {nome classe}
- Metodos abstratos so tem assinatura e não tem implementação, se a classe tiver
pelo menos 1 método abstrato ela tem que ser abstrata
- Usado em Herança 
- ex: Animal(classe mae e abstrata): tem como métodos abastratos fazerSom(), String getDescricao(), Foto getFoto(). Tera como filhas a classe Cachorro e a classe PicaPau, ambas Concretas e que terão que implementar os métodos abstratos da mãe.
- Uma classe abstrata pode ter métodos não abstratos, métodos concretos com implementação.

## Final

- Representa o conceito de imutavel/constante, não modificavel;
- Pode ser usado em métodos, impedindo ele de ser sobrescrito
- Em classes impedindo de ser herdada, a exemplo a classe String
- Em variáveis, locais ou de instância, impedindo o valor de ser modificada e obrigando que elas sejam inicializadas.
- Final em classe pode ir contra o princípio de SOLID de "Aberto para herança e fechado para modificações"
- Ex: classe Funcionario tem como atributo: public final float pisoSalarial = 6000F;

## Static

- Determina que variavel instâncias ou método pertence a classe e não há vinculo com futuras instâncias
- `public static void main`

## Stricfp

- Usado com Números Float
- Força o método a utilizar números flutuantes e operações com números flutuantes aderentes ao padrão IEE 754
- Util quando for trabalhar com números flutuantes muito grandes, ou diferentes plataformas(Windows, Linux, etc) igualando o resultado em todas, porém a depender da plataforma perdendo a precisão
- Usado em classes e Metodos

## Synchronized

- Usado em métodos para indicar que só pode ser acessado por uma Thread por vez
- ``[modificador de acesso] synchronized <tipo> <nome>([parametros])``

## Volatile

- usado em variáveis locais e de instância indicando que elas sao acessadas diretamente da memoria principal, sem passar por caches locais das Threads
- ``[modificador de acesso] volatile <tipo> <nome> [= <valor inicial>]``

## Transient

- usado em variáveis de instância, indicando que ela não fará parte de um processo de serialização (transformar um objeto da mémoria em bits para salvar em outro lugar)
- Ou seja, é usado em atributos que não deseja ser serializado
- ``[modificador de acesso] transient <tipo> <nome>[= <valor inicial>]``

## Native

- Usado em métodos, indica que o método é dependente da plataforma.
- O corpo do método não deve ser implementado
- ``[modificador de acesso] native <tipo> <nome> ([parametros]);``
- Ex: ``public native void Serial(int ...num);``

# Interface

- Permite a abstração de comportamentos (métodos) especificos que podem ser aplicados a diferentes classes.
- Funciona como um contrato, onde quem assina (a classe que implementa) se compromete em usar a assinatura dos metodos da interface e implementa-los
- Nomes de interfaces devem ser adjetivos: ex: `public interface Imprimivel`
- Não se gasta herança ao implementar uma interface
- Interfaces podem ter métodos já implementados utilizando `default` (Apartir do Java 8) seus comportamentos podem ser sobreescritos
- Caso não seja utiliado `default`, automaticamene o método será `public abstract`
- Não pode ter variaveis apenas constantes (public static final)
- não pode ter ``native, strictfp ou final``
- Uma interface pode herdar de outra interface, mas não de uma classe
- Interface não pode implementar outra interface
- Não pode ser, diretamente, instânciada `Interface i = new Interface()`