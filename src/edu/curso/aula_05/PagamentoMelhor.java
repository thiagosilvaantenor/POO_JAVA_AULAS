package edu.curso.aula_05;

public class PagamentoMelhor extends Pagamentos {
    //Indica que sera feita uma sobreescrita
    @Override
    public void fazPagamento(Trabalhador t) {
        double total = t.getHoras() * 30 + 100.0;
        t.receberSalario(total);
    }
}
