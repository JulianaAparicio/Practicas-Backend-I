package com.example.clinicaOdontologica.persistence.dao;

import com.example.clinicaOdontologica.model.dto.TurnoDto;
import org.apache.log4j.Logger;


import java.util.ArrayList;
import java.util.List;

public class TurnoDao implements Dao<TurnoDto> {
    private List<TurnoDto> turnos;
    private Logger logger = Logger.getLogger(TurnoDao.class);


    public TurnoDao() {
        turnos = new ArrayList<>();
    }

    @Override
    public TurnoDto crear(TurnoDto turno) {
        turnos.add(turno);
        turno.setId((long) turnos.size());
        return turno;
    }

    @Override
    public TurnoDto consultarPorId(long id) {
        for(TurnoDto turno : turnos){
            if(turno.getId().equals(id)){
                return turno;
            }
        }
        return null;
    }

    @Override
    public void eliminar(long id) {
        for(TurnoDto turno : turnos){
            if(turno.getId().equals(id)){
                turnos.remove(turno);
                return;
            }
        }

    }

    @Override
    public List<TurnoDto> consultarTodos() {
        logger.debug("Buscando todos los turnos");

        return turnos;
    }

    @Override
    public TurnoDto editar(TurnoDto turno) {
        eliminar(turno.getId());
        turnos.add(turno);
        return turno;
    }
}
