package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.model.dto.PacienteDTO;
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

        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setApellido("Arriola");
        pacienteDTO.setNombre("Florencia");
        pacienteService.crearPaciente(pacienteDTO);
        // Cambiar antes de ejecutar:
        PacienteDTO pacienteTest = pacienteService.buscarPacientePorId(1L);

        assertNotNull(pacienteTest);
    }

}