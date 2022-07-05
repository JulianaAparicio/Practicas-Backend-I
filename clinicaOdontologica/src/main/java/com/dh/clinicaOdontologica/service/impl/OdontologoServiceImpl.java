package com.dh.clinicaOdontologica.service.impl;

import com.dh.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.dh.clinicaOdontologica.model.Odontologo;
import com.dh.clinicaOdontologica.dto.OdontologoDTO;
import com.dh.clinicaOdontologica.repository.IOdontologoRepository;
import com.dh.clinicaOdontologica.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoServiceImpl implements IOdontologoService {

    @Autowired
    private IOdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    private final Logger logger = Logger.getLogger(OdontologoServiceImpl.class);

    @Override
    public void crearOdontologo(OdontologoDTO odontologoDTO) {
        if (odontologoDTO != null) {
            logger.debug("Creando odontologo...");
            guardarOdontologo(odontologoDTO);
        }
    }

    @Override
    public OdontologoDTO buscarOdontologoPorId(Long id) {
        logger.debug("Buscando odontologo con id: " + id);
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = null;
        if(odontologo.isPresent()){
            odontologoDTO = mapper.convertValue(odontologo,OdontologoDTO.class);
        }
        return odontologoDTO;
    }

    private void guardarOdontologo(OdontologoDTO odontologoDTO){
        logger.debug("Guardando odontologo");
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(odontologo);
    }

    @Override
    public void modificarOdontologo(OdontologoDTO odontologoDTO) {
        if(odontologoDTO != null) {
            logger.debug("Modificando odontologo");
            guardarOdontologo(odontologoDTO);
        }
    }

    @Override
    public void eliminarOdontologo(Long id) throws ResourceNotFoundException {
        Optional<Odontologo> busqueda = odontologoRepository.findById(id);
        if(busqueda.isPresent()){
            logger.debug("Eliminando el odontologo con id: " + id);
            odontologoRepository.delete(busqueda.get());
        } else {
            throw new ResourceNotFoundException("El id N° " + id + " no existe.");
        }
    }

    @Override
    public Set<OdontologoDTO> listarTodosLosOdontologos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologosDTO = new HashSet<>();

        for (Odontologo odontologo : odontologos){
            odontologosDTO.add(mapper.convertValue(odontologo,OdontologoDTO.class));
        }
        logger.debug("Listando todos los odontologos");
        return odontologosDTO;
    }
}
