/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Alejo
 */
import driven.MongoHandler;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        MongoHandler mongoHandler = null;
        LinkedList<Estudiante> listaEstudiantes = null;
        try {
            mongoHandler = new MongoHandler("mynosqlbd");

            mongoHandler.insert(new Estudiante("4477", "dac@uao.edu.co","Ingenieria Mecanica","Pedro", "Pastrana", "1139"));
            //listaEstudiantes = (LinkedList<Estudiante>) mongoHandler.findAll(Estudiante.class);

        } catch (Exception e) {
        }

//        if (!listaEstudiantes.isEmpty()) {
//            for (Estudiante estudianteAux : listaEstudiantes) {
//                System.out.println("datos de los estudiantes " + estudianteAux.getNombre()+" "+estudianteAux.getApellido()+" "+estudianteAux.getIdentificacion()+" "+estudianteAux.getCodigoEstudiante()+" "+estudianteAux.getCORREOESTUDIANTE()+ " "+estudianteAux.getCarrera()+ "\n");
//            }
//        }
    }

}
