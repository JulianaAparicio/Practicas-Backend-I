package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.model.DomicilioDTO;

import java.util.Set;

public interface IDomicilioService {
    void crearDomicilio(DomicilioDTO domicilioDTO);
    DomicilioDTO buscarDomicilio(Long id);
    void modificarDomicilio(DomicilioDTO domicilioDTO);
    boolean eliminarDomicilio(Long id);
    Set<DomicilioDTO> listarTodosLosDomicilios();
}
