package com.odontologica.test.service;

import com.odontologica.main.model.Paciente;
import com.odontologica.main.service.PacienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;

public class PacienteServiceTest {

    private PacienteService sujetoDePrueba = new PacienteService();

    @Test
    public void _01_deberiaConsultarExitosamenteTodosLosPacientesDeLaBaseDeDatos(){
        //DADOS

        //CUANDO
        Collection<Paciente> resultado = sujetoDePrueba.consultarTodosLosPacientes();

        //ENTONCES
        Assertions.assertTrue(resultado.size() > 0);
    }

}
