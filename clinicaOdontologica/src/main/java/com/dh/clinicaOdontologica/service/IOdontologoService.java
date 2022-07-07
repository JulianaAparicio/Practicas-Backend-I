package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.dto.OdontologoDTO;
import com.dh.clinicaOdontologica.exceptions.ResourceNotFoundException;

import java.util.Set;

public interface IOdontologoService {
    void crearOdontologo(OdontologoDTO odontologoDTO);
    OdontologoDTO buscarOdontologoPorId(Long id) throws ResourceNotFoundException;
    void modificarOdontologo(OdontologoDTO odontologoDTO);
    void eliminarOdontologo(Long id) throws ResourceNotFoundException;
    Set<OdontologoDTO> listarTodosLosOdontologos();
}
