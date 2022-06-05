package com.odontologica.main.service;

import com.odontologica.main.model.Odontologo;
import com.odontologica.main.persistence.dao.Dao;
import com.odontologica.main.persistence.dao.impl.OdontologoDao;

import java.util.List;

public class OdontologoService {

    Dao<Odontologo> odontologoDao;

    public OdontologoService() {
        odontologoDao = new OdontologoDao();
    }

    public Dao<Odontologo> getOdontologoDao() {
        return odontologoDao;
    }

    public void setOdontologoDao(Dao<Odontologo> odontologoDao) {
        this.odontologoDao = odontologoDao;
    }

    public List<Odontologo> consultarTodosLosOdontologos(){
        return odontologoDao.consultarTodos();
    }

    public Odontologo guardarOdontologo(Odontologo odontologo){
        odontologoDao.guardar(odontologo);
        return odontologo;
    }

    public Odontologo consultarPorId(int id){
        return odontologoDao.consultarPorId(id);
    }

}
