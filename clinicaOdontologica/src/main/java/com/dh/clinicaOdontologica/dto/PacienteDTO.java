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

}
