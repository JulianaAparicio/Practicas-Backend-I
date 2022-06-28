package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.model.Domicilio;

import java.util.Set;

public interface IDomicilioService {
    void crearDomicilio(Domicilio domicilio);
    Domicilio buscarDomicilio(Long id);
    void modificarDomicilio(Domicilio domicilio);
    boolean eliminarDomicilio(Long id);
    Set<Domicilio> listarTodosLosDomicilios();
}
