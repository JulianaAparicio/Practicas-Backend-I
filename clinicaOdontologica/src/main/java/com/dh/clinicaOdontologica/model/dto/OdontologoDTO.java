package com.dh.clinicaOdontologica.model.dto;

public class OdontologoDTO {
    private Long id;
    private String apellido;
    private String nombre;

    public Long getId() {
        return id;
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
}
