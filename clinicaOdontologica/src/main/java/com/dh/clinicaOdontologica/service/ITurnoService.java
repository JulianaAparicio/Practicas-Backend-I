package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.dto.TurnoDTO;
import com.dh.clinicaOdontologica.exceptions.BadRequestException;
import com.dh.clinicaOdontologica.exceptions.ResourceNotFoundException;

import java.util.Set;

public interface ITurnoService {
    void crearTurno(TurnoDTO turnoDTO) throws BadRequestException;
    TurnoDTO buscarTurnoPorId(Long id);
    void modificarTurno(TurnoDTO turnoDTO);
    void eliminarTurno(Long id) throws ResourceNotFoundException;
    Set<TurnoDTO> listarTodosLosTurnos();
}
