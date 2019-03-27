package com.sdz.museonumismatica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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
    @NotNull
    private float faceValue;
    @NotNull
    private String currency;
    @NotNull
    private float diameter; // en milimetros
    @NotNull
    private float weight; // en gramos
    private TreeSet<String> metals;
    private String description;

    public CoinModel(){}

    public CoinModel(long id, float faceValue, String currency, float diameter, float weight, TreeSet<String> metals, String description){
        this.id = id;
        this.faceValue = faceValue;
        this.currency = currency;
        this.diameter = diameter;
        this.weight = weight;
        this.metals = metals;
        this.description = description;
    }

    public CoinModel(long id, float faceValue, String currency, float diameter, float weight, String metals, String description){
        this.id = id;
        this.faceValue = faceValue;
        this.currency = currency;
        this.diameter = diameter;
        this.weight = weight;
        this.metals = new TreeSet<>();
        this.metals.add(metals);
        this.description = description;
    }

    public CoinModel(float faceValue, String currency, float diameter, float weight, TreeSet<String> metals, String description){
        this.faceValue = faceValue;
        this.currency = currency;
        this.diameter = diameter;
        this.weight = weight;
        this.metals = metals;
        this.description = description;
    }

    public CoinModel(float faceValue, String currency, float diameter, float weight, String metal, String description){
        this.faceValue = faceValue;
        this.currency = currency;
        this.diameter = diameter;
        this.weight = weight;
        this.metals = new TreeSet<>();
        this.metals.add(metal);
        this.description = description;
    }

    public long getId(){
        return id;
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

    public void setDiameter(float diameter) {
        this.diameter = diameter;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
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

    @Override
    public String toString() {
        return "Modelo de moneda{" + "Valor monetario=" + faceValue + ", moneda='" + currency + '\'' +
                ", diametro =" + diameter + ", peso =" + weight + ", metales =" + metals +
                ", descripcion='" + description + '\'' + '}';
    }
}
