package com.dh.clinicaOdontologica.service.impl;

import com.dh.clinicaOdontologica.model.DomicilioDTO;
import com.dh.clinicaOdontologica.repository.IDomicilioRepository;
import com.dh.clinicaOdontologica.service.IDomicilioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class DomicilioServiceImpl implements IDomicilioService {

    @Autowired
    private IDomicilioRepository domicilioRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void crearDomicilio(DomicilioDTO domicilioDTO) {

    }

    @Override
    public DomicilioDTO buscarDomicilio(Long id) {
        return null;
    }

    @Override
    public void modificarDomicilio(DomicilioDTO domicilioDTO) {

    }

    @Override
    public boolean eliminarDomicilio(Long id) {
        return false;
    }

    @Override
    public Set<DomicilioDTO> listarTodosLosDomicilios() {
        return null;
    }
}
