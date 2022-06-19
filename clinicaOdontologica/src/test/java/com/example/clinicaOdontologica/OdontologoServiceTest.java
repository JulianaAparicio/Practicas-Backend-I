package com.example.clinicaOdontologica;


import com.example.clinicaOdontologica.model.Odontologo;
import com.example.clinicaOdontologica.persistence.dao.OdontologoDao;
import com.example.clinicaOdontologica.service.OdontologoService;
import com.example.clinicaOdontologica.service.serviceException.ServiceException;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OdontologoServiceTest {

//    private OdontologoService sujetoPrueba = new OdontologoService(new OdontologoDao());
//
//    @Test
//    public void _01_deberiaConsultarExitosamenteTodosLosOdontologos(){
//        //DADOS
//
//        //CUANDO
//        Collection<Odontologo> resultado = sujetoPrueba.consultarTodosLosOdontologos();
//
//        //ENTONCES
//        //Agregar assertions
//        assertTrue(resultado.size() > 0 );
//
//    }
//
//    @Test
//    public void _02_deberiaConsultarExitosamenteOdontologoPorId(){
//        //DADOS
//
//        //CUANDO
//        Odontologo resultado = sujetoPrueba.consultarOdontologoPorId(45);
//
//        //ENTONCES
//        //Agregar assertions
//        assertTrue(resultado != null);
//    }
//
//    @Test
//    public void _03_deberiaCrearExitosamenteRegistroDeOdontologo(){
//
//        //DADOS
//        Odontologo odontologo1 = new Odontologo("Moreno", "Pablo", "1991");
//
//        //CUANDO
//        sujetoPrueba.crearOdontologo(odontologo1);
//
//        //ENTONCES
//        //Agregar assertions
//        assertTrue(odontologo1 != null);
//    }
//
//    @Test
//    public void _04_deberiaEditarExitosamenteOdontologoPorId() throws ServiceException {
//        //DADOS
//        Odontologo o = new Odontologo("Torrez", "Juan", "ASD123");
//        //CUANDO
//        sujetoPrueba.editarOdontologo(o);
//
//        //ENTONCES
//        //Agregar assertions
//        //assertTrue(resultado.getApellido() == "Cortez");
//
//    }
//
//    @Test
//    public void _05_deberiaEliminarExitosamenteOdontologoPorId(){
//        //DADOS
//
//        //CUANDO
//        sujetoPrueba.eliminarOdontologo(45);
//
//        //ENTONCES
//        //Agregar assertions
//        assertNull(sujetoPrueba.consultarOdontologoPorId(45));
//    }



}
