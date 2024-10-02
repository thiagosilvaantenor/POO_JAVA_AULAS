package edu.curso.aula_06.zoologico;

import javafx.scene.image.Image;

public abstract class Animal {
    public void respirar(){
        System.out.println("Puxando e soltando ar...");
    }

    public abstract void fazerSom();
    public abstract String getDescricao();
    public abstract Image getImage();
}
