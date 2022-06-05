package com.odontologica.main.service;

import com.odontologica.main.model.Domicilio;
import com.odontologica.main.model.Paciente;
import com.odontologica.main.persistence.dao.Dao;
import com.odontologica.main.persistence.dao.impl.DomicilioDao;
import com.odontologica.main.persistence.dao.impl.PacienteDao;

import java.util.Collection;
import java.util.List;

public class PacienteService {

    Dao<Paciente> pacienteDao;
    Dao<Domicilio> domicilioDao;

    public PacienteService() {
        pacienteDao = new PacienteDao();
        domicilioDao = new DomicilioDao();
    }

    public Collection<Paciente> consultarTodosLosPacientes() {
        List<Paciente> pacientes = pacienteDao.consultarTodos();

        for(Paciente p : pacientes){
            Domicilio d = domicilioDao.consultarPorId(p.getDomicilio().getId());
            p.setDomicilio(d);
        }

        return pacientes;

    }
}
