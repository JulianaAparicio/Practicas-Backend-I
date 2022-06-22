package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.model.Odontologo;
import com.example.clinicaOdontologica.persistence.dao.Dao;
import com.example.clinicaOdontologica.service.serviceException.ServiceException;


import java.util.List;

public class OdontologoService {

       private Dao<Odontologo> odontologoDao;

    // CONSTRUCTOR
    public OdontologoService(Dao<Odontologo> odontologoDao) {
        this.odontologoDao = odontologoDao;
    }

    //MÉTODOS

    public List<Odontologo> listarTodosLosOdontologos() {
            return odontologoDao.consultarTodos();

//       List<Odontologo> odontologos= getOdontologoDao().consultarTodos();
//        return odontologos;
    }

    public Odontologo crearOdontologo(Odontologo o) {
         return odontologoDao.crear(o);

//        odontologo = getOdontologoDao().crear(odontologo);
//        return odontologo;
    }

    public Odontologo buscarOdontologoPorId(Long id){
        return odontologoDao.consultarPorId(id);
//        Odontologo odontologoBuscado = getOdontologoDao().consultarPorId(id);
//        return  odontologoBuscado;
    }

    public Odontologo actualizarOdontologo(Odontologo o) throws ServiceException {
        return odontologoDao.editar(o);
//        Odontologo odontologoEditado = getOdontologoDao().editar(o);
//        return  odontologoEditado;
    }

    public String eliminarOdontologoPorId(Long id){
        if(odontologoDao.consultarPorId(id) != null){
            odontologoDao.eliminar(id);
            return "El odontólogo con id " + id + " fue eliminado.";
        }
        return "El odontólogo con id " + id + " no existe.";
    }

    //GETTER Y SETTER
    public Dao<Odontologo> getOdontologoDao() { return odontologoDao;}
    public void setOdontologoDao(Dao<Odontologo> odontologoDao) {this.odontologoDao = odontologoDao;}
}
