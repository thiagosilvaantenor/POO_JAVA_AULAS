package edu.curso.aula_05;

public class Empresa {
    public static void main(String[] args) {
        Trabalhador t1 = new Trabalhador("Wesker", 10);
        Trabalhador t2 = new Trabalhador("Jill", 150);
        Trabalhador t3 = new Trabalhador("Leon", 150);
        Trabalhador t4 = new Trabalhador("Chris", 100);
        
        Pagamentos rh = new PagamentoMelhor();
        rh.fazPagamento(t1);
        rh.fazPagamento(t2);
        rh.fazPagamento(t3);
        rh.fazPagamento(t4);
    }
}
