package com.odontologica.main;


import com.odontologica.main.model.Odontologo;
import com.odontologica.main.persistence.dao.Dao;
import com.odontologica.main.persistence.dao.impl.OdontologoDao;
import com.odontologica.main.service.OdontologoService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Dao h2 = new OdontologoDao();

        OdontologoService odontologoService = new OdontologoService();
        odontologoService.setOdontologoDao(h2);

        Odontologo odontologo = odontologoService.consultarPorId(1);

        System.out.println(odontologo.toString());

    }
}