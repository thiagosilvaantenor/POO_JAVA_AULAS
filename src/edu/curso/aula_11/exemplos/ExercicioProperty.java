package edu.curso.aula_11.exemplos;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class ExercicioProperty {
    
    public static void main(String[] args) {
        //Property de integer é o SimpleIntegerProperty ou sua interface IntegerProperty
        IntegerProperty idade = new SimpleIntegerProperty();
        //Adiciona um assinate, informando alteração da variavel idade
        idade.addListener((obj, antigo, novo) -> {
            if (novo.intValue() >= 18)
                System.out.printf("é maior de idade: %d%n", novo.intValue());
            else
                System.out.printf("é menor de idade: %d%n", novo.intValue());
        });
        //Altera a variavel idade
        idade.set(10);
        idade.set(19);

    }
}
