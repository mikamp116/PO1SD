package com.sdz.museonumismatica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Victor Fernandez
 *
 *  Esta clase representa el modelo de monedas que se guardará en la base de datos
 */

@Entity
public class CoinModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private float faceValue;
    private String currency;
    private float diameter; // en milimetros
    private float weight; // en gramos
    private TreeSet<String> metals;
    private String description;

    public void coinModel(){}

    public void coinModel(float faceValue, String currency, int diameter, int weight, TreeSet<String> metals, String description){
        this.faceValue = faceValue;
        this.currency = currency;
        this.diameter = diameter;
        this.weight = weight;
        this.metals = metals;
        this.description = description;
    }

    public void coinModel(float faceValue, String currency, int diameter, int weight, String metal, String description){
        this.faceValue = faceValue;
        this.currency = currency;
        this.diameter = diameter;
        this.weight = weight;
        this.metals = new TreeSet<>();
        this.metals.add(metal);
        this.description = description;
    }

    public float getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(float faceValue) {
        this.faceValue = faceValue;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public float getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Set<String> getMetals() {
        return metals;
    }

    public void setMetals(TreeSet<String> metals) {
        this.metals = metals;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
