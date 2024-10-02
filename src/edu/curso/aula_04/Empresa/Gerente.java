package edu.curso.aula_04.Empresa;

public class Gerente extends Funcionario {
    int qntFuncionario;

    public void liderarEquipe(){
        System.out.println("FAÇAM COISAS!!!!");
    }

    public Gerente(String cargo, 
    Float salario, int qntFuncionario) {
        this.cargo = cargo;
        this.salario = salario;
        this.qntFuncionario = qntFuncionario;
    }

    public Gerente(){
        super();
    }
}
