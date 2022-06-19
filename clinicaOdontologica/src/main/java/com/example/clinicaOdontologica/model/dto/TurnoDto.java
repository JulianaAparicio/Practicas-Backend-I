package com.example.clinicaOdontologica.model.dto;

import com.example.clinicaOdontologica.model.Odontologo;
import com.example.clinicaOdontologica.model.Paciente;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnoDto {
    private Long id;
    private Paciente paciente;
    private Odontologo odontologo;

    public TurnoDto(){
    }

    public Long getId() {return id; }
    public void setId(Long id) {this.id = id; }

    public Paciente getPaciente() {return paciente;}
    public void setPaciente(Paciente paciente) {this.paciente = paciente;}

    public Odontologo getOdontologo() {return odontologo;}
    public void setOdontologo(Odontologo odontologo) {this.odontologo = odontologo;}
}
