package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.model.TurnoDTO;

import java.util.Set;

public interface ITurnoService {
    void crearTurno(TurnoDTO turnoDTO);
    TurnoDTO buscarTurno(Long id);
    void modificarTurno(TurnoDTO turnoDTO);
    void eliminarTurno(Long id);
    Set<TurnoDTO> listarTodosLosTurnos();
}