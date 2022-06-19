package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.model.Domicilio;
import com.example.clinicaOdontologica.model.Paciente;
import com.example.clinicaOdontologica.persistence.dao.Dao;
import com.example.clinicaOdontologica.persistence.dao.DomicilioDao;
import com.example.clinicaOdontologica.persistence.dao.PacienteDao;
import com.example.clinicaOdontologica.service.serviceException.ServiceException;

import java.util.List;

public class PacienteService {

    Dao<Paciente> pacienteDao;
    Dao<Domicilio> domicilioDao;



    public PacienteService() {

       pacienteDao = new PacienteDao();
       domicilioDao = new DomicilioDao();
    }

    // CONSULTA DE TODOS LOS PACIENTES
    public List<Paciente> listarTodosLosPacientes() {
        List<Paciente> pacientes = this.pacienteDao.consultarTodos();
        return pacientes;
    }



    // CONSULTA DE PACIENTE POR ID
    public Paciente buscarPacientePorId(long id) {
        return pacienteDao.consultarPorId(id);
    }

    // OBTENER PACIENTE POR EMAIL
    public Paciente buscarPacientePorEmail(String email){
        Paciente respuesta = null;

        for (Paciente p : this.pacienteDao.consultarTodos()) {
            if(p.getEmail().equals(email)){
                respuesta = p;
            }
        }
        return respuesta;
    }


    // CREAR REGISTRO DE PACIENTE
    public Paciente crearPaciente(Paciente p) {
        return pacienteDao.crear(p);
    }

    // EDITAR REGISTRO DE PACIENTE
    public Paciente actualizarPaciente(Paciente p) throws ServiceException {
        return pacienteDao.editar(p);
    }

    // ELIMINAR UN PACIENTE POR ID
    public void eliminarPaciente(long id){
        domicilioDao.eliminar(id);
    }
}
