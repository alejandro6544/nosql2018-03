/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Alejo
 */
public class Estudiante extends Persona {

    private final String CODIGOESTUDIANTE = "codigoestudiante";
    private final String CORREOESTUDIANTE = "correoestudiante";
    private final String CARRERA = "carrera";

    public Estudiante() {
    }

    public Estudiante(String codigoEstudiante, String correoestudiante, String carrera, String nombre, String apellido, String identificacion) {
        super(nombre, apellido, identificacion);
        this.put(CODIGOESTUDIANTE, codigoEstudiante);
        this.put(CORREOESTUDIANTE, correoestudiante);
        this.put(CARRERA, carrera);
    }

    @Override
    public void markAsPartialObject() {
        Set<String> set = keySet();
        set.remove("_id");

        Set<String> setThis = new HashSet<String>();
        setThis.add(NOMBRE);
        setThis.add(APELLIDO);
        setThis.add(IDENTIFICACION);
        setThis.add(CODIGOESTUDIANTE);
        setThis.add(CORREOESTUDIANTE);
        setThis.add(CARRERA);

        setPartial(!set.equals(setThis));
    }

    public String getCORREOESTUDIANTE() {
        return this.getString(CORREOESTUDIANTE);
    }

    public void setCorreoEstudiante(String correoestudiante) {
        this.put(CORREOESTUDIANTE, correoestudiante);
    }

    /**
     * Get the value of codigoEstudiante
     *
     * @return the value of codigoEstudiante
     */
    public String getCodigoEstudiante() {

        return this.getString(CODIGOESTUDIANTE);
    }

    public String getCarrera() {

        return this.getString(CARRERA);
    }
    /**
     * Set the value of codigoEstudiante
     *
     * @param codigoEstudiante new value of codigoEstudiante
     */
    public void setCodigoEstudiante(String codigoEstudiante) {
        this.put(CODIGOESTUDIANTE, codigoEstudiante);
    }

    @Override
    public String toString() {
        return "Estudiante{" + super.toString() + "codigoEstudiante=" + CODIGOESTUDIANTE + "correo estudiante="+ CORREOESTUDIANTE+'}';
    }

}
