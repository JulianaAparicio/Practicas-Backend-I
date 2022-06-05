package com.odontologica.test.service;

import com.odontologica.main.model.Odontologo;
import com.odontologica.main.service.OdontologoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class OdontologoServiceTest {
    private OdontologoService sujetoDePrueba = new OdontologoService();

    @Test
    public void _01_deberiaConsultarExitosamenteTodosLosOdontologosDeLaBaseDeDatos(){
        // DADOS

        // CUANDO
        List<Odontologo> resultado = sujetoDePrueba.consultarTodosLosOdontologos();

        // ENTONCES
        Assertions.assertTrue(resultado.size() > 0);
    }

    @Test
    public void _02_deberiaTraerUnOdontologoPorId(){
        Odontologo odontologo = sujetoDePrueba.consultarPorId(1);
        Assertions.assertNotNull(odontologo);
    }

}
