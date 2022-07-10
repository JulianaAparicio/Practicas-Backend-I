package com.dh.clinicaOdontologica.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OdontologoDTO {
    private Long id;
    private String apellido;
    private String nombre;
    private String matricula;

    public OdontologoDTO(String apellido, String nombre, String matricula) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.matricula = matricula;
    }
}
