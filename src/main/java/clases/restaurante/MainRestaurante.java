/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.restaurante;

import clases.Estudiante;
import driven.MongoHandler;
import java.util.LinkedList;

/**
 *
 * @author dacastro
 */
public class MainRestaurante {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         MongoHandler mongoHandler = null;
         LinkedList<Ingrediente> li=new LinkedList<>();
         li.add(new Ingrediente("Tomates", 3, 0));
         li.add(new Ingrediente("Cebolla", 1, 0));
         li.add(new Ingrediente("Aceite", 1, 100));
        try {
            mongoHandler = new MongoHandler("myres");
            mongoHandler.insert(new Plato("Ensalada", 150, 5000, 7500, "picar tomates y cebolla y agregar aceite", li));
            //listaEstudiantes = (LinkedList<Estudiante>) mongoHandler.findAll(Estudiante.class);

        } catch (Exception e) {
        }
        
        
    }
    
}
