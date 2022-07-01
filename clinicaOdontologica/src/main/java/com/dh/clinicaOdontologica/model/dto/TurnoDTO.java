package com.dh.clinicaOdontologica.model.dto;

import com.dh.clinicaOdontologica.model.Odontologo;
import com.dh.clinicaOdontologica.model.Paciente;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TurnoDTO {
    private Long id;
    private Paciente paciente;
    private Odontologo odontologo;
    private LocalDate fecha;
    private String hora;

}
