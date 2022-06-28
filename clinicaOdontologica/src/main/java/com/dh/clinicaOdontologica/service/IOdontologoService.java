package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.model.dto.OdontologoDTO;

import java.util.Set;

public interface IOdontologoService {
    void crearOdontologo(OdontologoDTO odontologoDTO);
    OdontologoDTO buscarOdontologoPorId(Long id);
    void modificarOdontologo(OdontologoDTO odontologoDTO);
    void eliminarOdontologo(Long id);
    Set<OdontologoDTO> listarTodosLosOdontologos();
}
