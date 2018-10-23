/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import com.mongodb.BasicDBObject;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Alejo
 */
public class Persona extends BasicDBObject {

    protected final String NOMBRE = "nombre";
    protected final String APELLIDO = "apellido";
    protected final String IDENTIFICACION = "identificacion";

    private boolean partial;

    public Persona() {
        partial = false;
    }

    public Persona(String nombre, String apellido, String identificacion) {
        this.put(NOMBRE, nombre);
        this.put(APELLIDO, apellido);
        this.put(IDENTIFICACION, identificacion);
        this.markAsPartialObject();
    }

    @Override
    public void markAsPartialObject() {
        Set<String> set = keySet();
        set.remove("_id");

        Set<String> setThis = new HashSet<String>();
        setThis.add(NOMBRE);
        setThis.add(APELLIDO);
        setThis.add(IDENTIFICACION);

        partial = !set.equals(setThis);
    }

    public boolean isPartialObject() {
        return partial;
    }

    public void setPartial(boolean partial) {
        this.partial = partial;
    }

    /**
     * Get the value of identificacion
     *
     * @return the value of identificacion
     */
    public String getIdentificacion() {
        return this.getString(IDENTIFICACION);
    }

    /**
     * Set the value of identificacion
     *
     * @param identificacion new value of identificacion
     */
    public void setIdentificacion(String identificacion) {
        this.put(IDENTIFICACION, identificacion) ;
    }

    /**
     * Get the value of apellido
     *
     * @return the value of apellido
     */
    public String getApellido() {
        return this.getString(APELLIDO);
    }

    /**
     * Set the value of apellido
     *
     * @param apellido new value of apellido
     */
    public void setApellido(String apellido) {
        this.put(APELLIDO, apellido) ;
    }

    /**
     * Get the value of nombre
     *
     * @return the value of nombre
     */
    public String getNombre() {
        return this.getString(NOMBRE);
    }

    /**
     * Set the value of nombre
     *
     * @param nombre new value of nombre
     */
    public void setNombre(String nombre) {
        this.put(NOMBRE, nombre) ;
    }

    @Override
    public String toString() {
        return "nombre=" + NOMBRE + ", apellido=" + APELLIDO + ", identificacion=" + IDENTIFICACION;
    }

}
