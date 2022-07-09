package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.dto.PacienteDTO;
import com.dh.clinicaOdontologica.exceptions.BadRequestException;
import com.dh.clinicaOdontologica.exceptions.ResourceNotFoundException;

import java.util.Set;

public interface IPacienteService {

    void crearPaciente(PacienteDTO pacienteDTO) throws BadRequestException;
    PacienteDTO buscarPacientePorId(Long id) throws ResourceNotFoundException;
    void modificarPaciente(PacienteDTO pacienteDTO) throws BadRequestException;
    void eliminarPaciente(Long id)throws ResourceNotFoundException;
    Set<PacienteDTO> listarTodosLosPacientes();
    PacienteDTO buscarPacientePorEmail(String email) throws ResourceNotFoundException;

}
