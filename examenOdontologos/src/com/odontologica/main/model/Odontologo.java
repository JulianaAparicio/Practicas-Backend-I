package com.odontologica.main.model;

public class Odontologo {
    private String numeroMatricula;
    private String nombre;
    private String apellido;
    private int id;

    public Odontologo(){

    }

    public Odontologo(String numeroMatricula, String nombre, String apellido) {
        this.setNumeroMatricula(numeroMatricula);
        this.setNombre(nombre);
        this.setApellido(apellido);
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Odontólogo{" +
                "id=" + id +
                ", Nombre='" + nombre + '\'' +
                ", Apellido='" + apellido + '\'' +
                ", Matrícula N°='" + numeroMatricula + '\'' +
                "}";
    }

}
