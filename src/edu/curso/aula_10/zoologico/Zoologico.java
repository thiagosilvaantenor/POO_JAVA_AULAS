package edu.curso.aula_10.zoologico;

import edu.curso.aula_10.zoologico.Cachorro;
import edu.curso.aula_10.zoologico.PicaPau;

public class Zoologico {
    public static void main(String[] args){
        //Classe abstrata não pode ser instânciada
        //  Animal a1 = new Animal();
        Cachorro c1 = new Cachorro();
        //Passarinho p1 = new Passarinho();
        PicaPau p2 = new PicaPau();
        c1.respirar();
        c1.fazerSom();
        c1.getDescricao();
        c1.getImage();
    }
}
