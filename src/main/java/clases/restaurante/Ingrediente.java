/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.restaurante;

import com.mongodb.BasicDBObject;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author dacastro
 */
public class Ingrediente extends BasicDBObject {

    private final String NOMBREI = "nombreingrediente";
    private final String CANTIDAD = "cantidad";
    private final String MEDIDA = "medida";

    private boolean partial;

    public Ingrediente() {
        partial = false;
    }

    public Ingrediente(String nombreingrediente, double cantidad, double medida) {
        this.put(NOMBREI, nombreingrediente);
        this.put(CANTIDAD, cantidad);
        this.put(MEDIDA, medida);

        this.markAsPartialObject();
    }

    @Override
    public void markAsPartialObject() {
        Set<String> set = keySet();
        set.remove("_id");

        Set<String> setThis = new HashSet<String>();
        setThis.add(NOMBREI);
        setThis.add(CANTIDAD);
        setThis.add(MEDIDA);
        partial = !set.equals(setThis);
    }

    public boolean isPartialObject() {
        return partial;
    }

    public void setPartial(boolean partial) {
        this.partial = partial;
    }
    public String getNombreIngrediente() {
        return this.getString(NOMBREI);
    }

    public void setNombrePlato(String nombreingrediente) {
        this.put(NOMBREI, nombreingrediente);
    }
    public String getCantidad() {
        return this.getString(CANTIDAD);
    }

    public void setCantidad(double cantidad) {
        this.put(CANTIDAD, cantidad);
    }
    public String getMedida() {
        return this.getString(MEDIDA);
    }

    public void setMedida(double medida) {
        this.put(MEDIDA, medida);
    }

    @Override
    public String toString() {
        return "Ingrediente{" + "NOMBREI=" + NOMBREI + ", CANTIDAD=" + CANTIDAD + ", MEDIDA=" + MEDIDA + ", partial=" + partial + '}';
    }
    
}
