package com.odontologica.main.model;

public class Paciente {
    private String apellido;
    private String nombre;
    private int id;
    private Domicilio domicilio;

    public Paciente(){

    }

    public Paciente(String apellido, String nombre) {
        this.setApellido(apellido);
        this.setNombre(nombre);
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }
}
