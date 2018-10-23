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
public class Plato extends BasicDBObject {

    private final String NOMBREP = "nombreplato";
    private final String CALORIAS = "calorias";
    private final String VALORREAL = "valorreal";
    private final String VALORCOMERCIAL = "valorcomercial";
    private final String RECETA = "receta";
    private final String INGREDIENTE = "ingrediente";

    private boolean partial;

    public Plato() {
        partial = false;
    }

    public Plato(String nombreplato, int calorias, double valorreal, double valorcomercial, String receta, LinkedList<Ingrediente> ingrediente) {
        this.put(NOMBREP, nombreplato);
        this.put(CALORIAS, calorias);
        this.put(VALORREAL, valorreal);
        this.put(VALORCOMERCIAL, valorcomercial);
        this.put(RECETA, receta);
        this.put(INGREDIENTE, ingrediente);
        this.markAsPartialObject();
    }

    @Override
    public void markAsPartialObject() {
        Set<String> set = keySet();
        set.remove("_id");

        Set<String> setThis = new HashSet<String>();
        setThis.add(NOMBREP);
        setThis.add(CALORIAS);
        setThis.add(VALORREAL);
        setThis.add(VALORCOMERCIAL);
        setThis.add(RECETA);
        setThis.add(INGREDIENTE);

        partial = !set.equals(setThis);
    }

    public boolean isPartialObject() {
        return partial;
    }

    public void setPartial(boolean partial) {
        this.partial = partial;
    }

    public String getNombrePlato() {
        return this.getString(NOMBREP);
    }

    public void setNombrePlato(String nombreplato) {
        this.put(NOMBREP, nombreplato);
    }

    public String getCalorias() {
        return this.getString(CALORIAS);
    }

    public void setCalorias(int calorias) {
        this.put(CALORIAS, calorias);
    }

    public String getValorReal() {
        return this.getString(VALORREAL);
    }

    public void setValorReal(double valorreal) {
        this.put(VALORREAL, valorreal);
    }

    public String getValorComercial() {
        return this.getString(VALORREAL);
    }

    public void setValorComercial(double valorcomercial) {
        this.put(VALORCOMERCIAL, valorcomercial);
    }

    public String getReceta() {
        return this.getString(RECETA);
    }

    public void setReceta(String receta) {
        this.put(RECETA, receta);
    }

    public String getIngrediente() {
        return this.getString(INGREDIENTE);
    }

    public void setIngrediente(LinkedList<Ingrediente> ingrediente) {
        this.put(INGREDIENTE, ingrediente);
    }

    @Override
    public String toString() {
        return "Plato{" + "NOMBREP=" + NOMBREP + ", CALORIAS=" + CALORIAS + ", VALORREAL=" + VALORREAL + ", VALORCOMERCIAL=" + VALORCOMERCIAL + ", RECETA=" + RECETA + ", INGREDIENTE=" + INGREDIENTE + ", partial=" + partial + '}';
    }

}
