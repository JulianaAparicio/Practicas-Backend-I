package com.dh.clinicaOdontologica.service.impl;

import com.dh.clinicaOdontologica.model.dto.PacienteDTO;
import com.dh.clinicaOdontologica.service.IPacienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PacienteServiceImplTest {

    @Autowired
    private IPacienteService pacienteService;

    @Test
    public void deberiaCrearUnPaciente(){
        // Dado
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setApellido("Apellido Paciente Test");
        pacienteDTO.setNombre("Nombre Paciente Test");
        // Cuando
        pacienteService.crearPaciente(pacienteDTO);
        PacienteDTO pacienteTest = pacienteService.buscarPacientePorId(1L);
        // Entonces
        assertNotNull(pacienteTest);
    }

}