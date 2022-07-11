package com.dh.clinicaOdontologica.dto;

import com.dh.clinicaOdontologica.model.Domicilio;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String dni;
    private Domicilio domicilio;

    public PacienteDTO(String nombre, String apellido, String email, String dni, Domicilio domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.dni = dni;
        this.domicilio = domicilio;
    }
}
