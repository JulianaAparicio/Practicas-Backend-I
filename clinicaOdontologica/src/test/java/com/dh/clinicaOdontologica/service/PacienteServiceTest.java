package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.model.PacienteDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PacienteServiceTest {

    @Autowired
    private IPacienteService pacienteService;

    @Test
    public void deberiaCrearUnPaciente(){

        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setApellido("Aparicio");
        pacienteDTO.setNombre("Juliana");
        pacienteService.crearPaciente(pacienteDTO);
        PacienteDTO pacienteTest = pacienteService.buscarPaciente(1L);

        assertNotNull(pacienteTest);
    }

}