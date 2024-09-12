package edu.curso.aula_10.interfaces;

import java.util.ArrayList;
import java.util.List;

public class Uber {
    private List<Motorista> motoristas = new ArrayList<>();

    public void contratarMotorista(Motorista m){
        motoristas.add(m);
        System.out.printf("Temos %d tantos motoristas na nossa empresa%n", motoristas.size());
    }

    public static void main(String[] args){
        Uber uber = new Uber();

        EstudanteFatec e1 = new EstudanteFatec();
        EstudanteFatec e2 = new EstudanteFatec();
        TrabalhadorAutonomo t1 = new TrabalhadorAutonomo();
        TrabalhadorAutonomo t2 = new TrabalhadorAutonomo();
        EntregadorLiberal ent1 = new EntregadorLiberal();

        uber.contratarMotorista(ent1);
        uber.contratarMotorista(e1);
        uber.contratarMotorista(e2);
        uber.contratarMotorista(t1);
        uber.contratarMotorista(t2);

        uber.alocarMotoristas();

    }

    public void alocarMotoristas() {
        for(Motorista m : motoristas) {
            System.out.println("----------------");
            m.abrirPorta();
            m.dirigir();
        }
    }

}
