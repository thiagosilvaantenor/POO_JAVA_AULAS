package edu.curso.Empresa;

public class Funcionario {
    String cargo;
    Float salario;

    public Funcionario(String cargo, Float salario){
        this.cargo = cargo;
        this.salario = salario;
    }
    
    public Funcionario() {
        super();
    }

    public void trabalhar(){
        System.out.println("Estou trabalhando, por favor, puxe conversa");
    }


}
