package com.dh.clinicaOdontologica.service.impl;

import com.dh.clinicaOdontologica.model.Odontologo;
import com.dh.clinicaOdontologica.model.Paciente;
import com.dh.clinicaOdontologica.model.dto.TurnoDTO;
import com.dh.clinicaOdontologica.service.ITurnoService;
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

    @Test
    public void deberiaCrearUnTurno(){

        TurnoDTO turnoDTO = new TurnoDTO();
        turnoDTO.setPaciente(new Paciente());
        turnoDTO.setOdontologo(new Odontologo());
        turnoDTO.setFecha(LocalDate.ofEpochDay(2022-6-29));
        turnoDTO.setHora("15:00");
        turnoService.crearTurno(turnoDTO);

        TurnoDTO turnoTest = turnoService.buscarTurnoPorId(1L);

        assertNotNull(turnoTest);

    }
}
