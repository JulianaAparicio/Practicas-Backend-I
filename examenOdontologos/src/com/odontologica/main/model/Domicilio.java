package com.odontologica.main.model;

public class Domicilio {
    private String calle;
    private int id;

    public Domicilio(){

    }

    public Domicilio(int id, String calle) {
        this.id = id;
        this.setCalle(calle);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }
}
