package com.sdz.museonumismatica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Mikayel Mardanyan Petrosyan
 *
 * Implementacion de la clase para los proveedores
 */
@Entity
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String cif;
    private String name;
    private int postalCode;
    private String email;
    private int phoneNumber;

    public Supplier() { }

    public Supplier(String cif, String name, int postalCode, String email, int phoneNumber) {
        this.cif = cif;
        this.name = name;
        this.postalCode = postalCode;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Supplier(Long id, String cif, String name, int postalCode, String email, int phoneNumber) {
        this.id = id;
        this.cif = cif;
        this.name = name;
        this.postalCode = postalCode;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "CIF='" + cif + '\'' + ", nombre='" + name + '\'' +
                ", codigo postal=" + postalCode + ", e-mail='" + email + '\'' +
                ", número de telefono=" + phoneNumber + '}';
    }
}
