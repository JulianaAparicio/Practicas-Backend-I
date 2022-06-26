package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.model.PacienteDTO;

import java.util.Set;

public interface IPacienteService {

    void crearPaciente(PacienteDTO pacienteDTO);
    PacienteDTO buscarPaciente(Long id);
    void modificarPaciente(PacienteDTO pacienteDTO);
    void eliminarPaciente(Long id);
    Set<PacienteDTO> listarTodosLosPacientes();
}
