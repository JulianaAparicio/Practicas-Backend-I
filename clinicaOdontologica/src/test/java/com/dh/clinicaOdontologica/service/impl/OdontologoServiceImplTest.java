package com.dh.clinicaOdontologica.service.impl;

import com.dh.clinicaOdontologica.dto.OdontologoDTO;
import com.dh.clinicaOdontologica.service.IOdontologoService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnit4.class)
@SpringBootTest
class OdontologoServiceImplTest {

    @Autowired
    private IOdontologoService odontologoService;

    @Test
    public void deberiaCrearUnOdontologo(){

        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setApellido("Apellido Odontologo Test");
        odontologoDTO.setNombre("Nombre Odontologo Test");
        odontologoService.crearOdontologo(odontologoDTO);
        // Cambiar antes de ejecutar:
        OdontologoDTO odontologoTest = odontologoService.buscarOdontologoPorId(1L);

        assertNotNull(odontologoTest);
    }

}