package edu.curso.aula_05;

public class TestePessoa {
    public static void main(String[] args) {
        Passageiro p1 = new Passageiro("Joao");
        p1.andar();
        
        //Override
        Pessoa p2 = new Pessoa("Maria");
        p2.andar();
        System.out.println();

        Pessoa p3 = new Passageiro("Alberto");
        p3.andar();

        //Passageiro p4 = new Pessoa("Leoncio");
        //p4.andar();

        //Generics:
        Cobrador<Passageiro> cobradorPassageiro = new Cobrador<>();
        cobradorPassageiro.cobrarDinheiro(p1);

        Cobrador<Pessoa> cobradorPessoa = new Cobrador<>();
        cobradorPessoa.cobrarDinheiro(p3);

        Cobrador<String> cobradorString = new Cobrador<>();
        cobradorString.cobrarDinheiro("");
        
    }
}
