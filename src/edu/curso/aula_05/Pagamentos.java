package edu.curso.aula_05;

public class Pagamentos {

    public void fazPagamento(Trabalhador t){
        double total = t.getHoras() * 15.0 + 100.0;
        t.receberSalario(total);
    }


}
