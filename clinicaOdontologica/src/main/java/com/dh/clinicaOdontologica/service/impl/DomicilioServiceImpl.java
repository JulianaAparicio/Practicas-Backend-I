package com.dh.clinicaOdontologica.service.impl;

import com.dh.clinicaOdontologica.model.Domicilio;
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
    public void crearDomicilio(Domicilio domicilio) {

    }

    @Override
    public Domicilio buscarDomicilio(Long id) {
        return null;
    }

    @Override
    public void modificarDomicilio(Domicilio domicilio) {

    }

    @Override
    public boolean eliminarDomicilio(Long id) {
        return false;
    }

    @Override
    public Set<Domicilio> listarTodosLosDomicilios() {
        return null;
    }
}
