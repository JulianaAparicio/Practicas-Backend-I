package com.example.clinicaOdontologica.persistence.dao;

import com.example.clinicaOdontologica.service.serviceException.ServiceException;

import java.util.List;

public interface Dao<T> {

    //CONSULTA TODOS LOS REGISTROS
    List<T> consultarTodos();

    //CREA REGISTRO
    T crear(T entidad);

    //CONSULTA POR ID
    T consultarPorId(long id);

    //EDITA REGISTRO
    T editar(T entidad) throws ServiceException;

    //ELIMINA REGISTRO
    void eliminar(long id);


}
