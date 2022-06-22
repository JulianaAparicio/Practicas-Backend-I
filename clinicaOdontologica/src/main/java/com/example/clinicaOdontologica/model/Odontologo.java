package com.example.clinicaOdontologica.model;

public class Odontologo {

    private Long id;
    private String apellido;
    private String nombre;
    private String matricula;

    public Odontologo() {
    }

    public Odontologo(String nombre, String apellido, String matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString(){
        return "Id: '" + getId() + "', Apellido: '" + getApellido() + "', Nombre: '" + getNombre() + "'" +
                ", Matrícula: '" + getMatricula() + "'" ;
    }

}
