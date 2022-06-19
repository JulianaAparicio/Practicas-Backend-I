package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.model.dto.TurnoDto;
import com.example.clinicaOdontologica.persistence.dao.Dao;
import com.example.clinicaOdontologica.service.serviceException.ServiceException;

import java.util.List;

public class TurnoService {
    private Dao<TurnoDto> turnoDao;

    public TurnoService(Dao<TurnoDto> turnoDao) {
        this.turnoDao = turnoDao;
    }

    public TurnoDto registrarTurno(TurnoDto turno){
        return turnoDao.crear(turno);
    }
    public List<TurnoDto> listarTodosLosTurnos(){
        return turnoDao.consultarTodos();
    }
    public TurnoDto consultarTurnoPorId(long id) {
        return turnoDao.consultarPorId(id);
    }

    public void eliminarTurno(long id){
        turnoDao.eliminar(id);
    }

    public TurnoDto editarTurno(TurnoDto t) throws ServiceException {
        return turnoDao.editar(t);
    }

}
