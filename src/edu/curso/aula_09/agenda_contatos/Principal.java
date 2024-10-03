package edu.curso.aula_09.agenda_contatos;

public class Principal {
    public static void main(String[] args) {
    /*
        Contato c1 = new Contato();
        c1.setNome("Joao Silva");
        c1.setTelefone("(11) 1111-1111");
        c1.setEmail("joao.silva@email.com");
        System.out.println(c1);
    */
        ContatoBoundary.launch(ContatoBoundary.class,args);
    }
}
