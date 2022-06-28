package com.dh.clinicaOdontologica.model.dto;

import com.dh.clinicaOdontologica.model.Domicilio;

public class PacienteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private Domicilio domicilio;

    public Long getId() {
        return id;
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

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }
}
