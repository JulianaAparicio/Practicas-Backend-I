package com.dh.clinicaOdontologica.service.impl;

import com.dh.clinicaOdontologica.model.Odontologo;
import com.dh.clinicaOdontologica.model.Paciente;
import com.dh.clinicaOdontologica.dto.OdontologoDTO;
import com.dh.clinicaOdontologica.dto.PacienteDTO;
import com.dh.clinicaOdontologica.dto.TurnoDTO;
import com.dh.clinicaOdontologica.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnit4.class)
@SpringBootTest
class TurnoServiceImplTest {

    @Autowired
    private ITurnoService turnoService;

    @Autowired
    ObjectMapper mapper;

    @Test
    public void deberiaCrearUnTurno(){

        // Dado:
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setApellido("Apellido Odontologo Test");
        odontologoDTO.setNombre("Nombre Odontologo Test");
        Odontologo odontologoTest = mapper.convertValue(odontologoDTO,Odontologo.class);

        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setApellido("Apellido Paciente Test");
        pacienteDTO.setNombre("Nombre Paciente Test");
        Paciente pacienteTest = mapper.convertValue(pacienteDTO,Paciente.class);



        TurnoDTO turnoDTO = new TurnoDTO();
        turnoDTO.setPaciente(pacienteTest);
        turnoDTO.setOdontologo(odontologoTest);
        turnoDTO.setFecha(LocalDate.ofEpochDay(2022-6-29));
        turnoDTO.setHora("15:00");


        // Cuando:
        turnoService.crearTurno(turnoDTO);
        TurnoDTO turnoTest = turnoService.buscarTurnoPorId(1L);

        // Entonces:
        assertNotNull(turnoTest);

    }
}
