package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.model.DomicilioDTO;
import com.dh.clinicaOdontologica.repository.IDomicilioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class DomicilioService implements IDomicilioService{

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
    public void eliminarDomicilio(Long id) {

    }

    @Override
    public Set<DomicilioDTO> listarTodosLosDomicilios() {
        return null;
    }
}
