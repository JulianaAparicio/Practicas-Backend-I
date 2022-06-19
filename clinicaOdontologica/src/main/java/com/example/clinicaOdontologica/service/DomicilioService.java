package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.model.Domicilio;
import com.example.clinicaOdontologica.persistence.dao.Dao;
import com.example.clinicaOdontologica.service.serviceException.ServiceException;

import java.util.List;

public class DomicilioService {
    private Dao<Domicilio> domicilioDao;

    public DomicilioService(Dao<Domicilio> domicilioDao) {
        this.domicilioDao = domicilioDao;
    }

    public Domicilio crearDomicilio(Domicilio d){
        return domicilioDao.crear(d);
    }

    public Domicilio buscarDomicilio(long id){
        return domicilioDao.consultarPorId(id);
    }

    public List<Domicilio> buscarTodosLosDomicilios(){
        return domicilioDao.consultarTodos();
    }

    public void eliminarDomicilio(long id){
        domicilioDao.eliminar(id);
    }

    public Domicilio actualizarDomicilio(Domicilio d) throws ServiceException {
        return domicilioDao.editar(d);
    }


    public Dao<Domicilio> getDomicilioDao() {
        return domicilioDao;
    }

    public void setDomicilioDao(Dao<Domicilio> domicilioIDao) {
        this.domicilioDao = domicilioIDao;
    }
}
