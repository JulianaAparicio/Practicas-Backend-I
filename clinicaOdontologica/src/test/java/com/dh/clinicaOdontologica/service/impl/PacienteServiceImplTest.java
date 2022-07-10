package com.dh.clinicaOdontologica.service.impl;

import com.dh.clinicaOdontologica.dto.PacienteDTO;
import com.dh.clinicaOdontologica.exceptions.BadRequestException;
import com.dh.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.dh.clinicaOdontologica.exceptions.ServiceException;
import com.dh.clinicaOdontologica.service.IPacienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnit4.class)
@SpringBootTest
class PacienteServiceImplTest {

    @Autowired
    private IPacienteService pacienteService;


    @Test
    @Before
    public void deberiaCrearUnPaciente() throws BadRequestException, ResourceNotFoundException {
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

    @Test
    public void deberiaModificarUnPaciente() throws BadRequestException {

        // Ver cómo se hace el test de modificar:

        // Dado
        PacienteDTO pacienteDTO1 = new PacienteDTO();
        pacienteDTO1.setApellido("Apellido Paciente Test 1");
        pacienteDTO1.setNombre("Nombre Paciente Test 1");

        PacienteDTO pacienteDTO2 = new PacienteDTO();
        pacienteDTO2.setApellido("Apellido Paciente Test 2");
        pacienteDTO2.setNombre("Nombre Paciente Test 2");

        // Cuando
        pacienteService.modificarPaciente(pacienteDTO2);

        // Entonces
        assertEquals(pacienteDTO2,pacienteDTO1);
    }

    @Test
    public void deberiaEliminarUnPaciente() throws ResourceNotFoundException {
        // Dado

        // Cuando
        pacienteService.eliminarPaciente(1L);

        // Entonces
        Assert.assertNull(pacienteService.buscarPacientePorId(1L));
    }

    @Test
    public void deberiaListarTodosLosPacientes() throws ServiceException {
        // Dado
        PacienteDTO pacienteDTO = new PacienteDTO();

        Set<PacienteDTO> pacientes = null;
        pacientes.add(pacienteDTO);

        // Cuando
        pacienteService.listarTodosLosPacientes();

        // Entonces
        Assert.assertFalse(pacientes.isEmpty());
        Assert.assertEquals(1, pacientes.size());
    }


}