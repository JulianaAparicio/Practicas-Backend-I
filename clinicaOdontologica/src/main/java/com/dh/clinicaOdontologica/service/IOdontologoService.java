package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.dto.OdontologoDTO;
import com.dh.clinicaOdontologica.exceptions.BadRequestException;
import com.dh.clinicaOdontologica.exceptions.ResourceNotFoundException;

import java.util.Set;

public interface IOdontologoService {
    void crearOdontologo(OdontologoDTO odontologoDTO) throws BadRequestException;
    OdontologoDTO buscarOdontologoPorId(Long id) throws ResourceNotFoundException;
    void modificarOdontologo(OdontologoDTO odontologoDTO);
    void eliminarOdontologo(Long id) throws ResourceNotFoundException;
    Set<OdontologoDTO> listarTodosLosOdontologos();
    OdontologoDTO buscarOdontologoPorMatricula(String matricula) throws ResourceNotFoundException;
    void invocarMetodoConError();
}
