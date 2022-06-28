package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.model.dto.PacienteDTO;

import java.util.Set;

public interface IPacienteService {

    void crearPaciente(PacienteDTO pacienteDTO);
    PacienteDTO buscarPacientePorId(Long id);
    void modificarPaciente(PacienteDTO pacienteDTO);
    void eliminarPaciente(Long id);
    Set<PacienteDTO> listarTodosLosPacientes();
    PacienteDTO buscarPacientePorEmail(String email);
}
