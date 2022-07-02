package com.dh.clinicaOdontologica.service.impl;

import com.dh.clinicaOdontologica.model.Odontologo;
import com.dh.clinicaOdontologica.model.dto.OdontologoDTO;
import com.dh.clinicaOdontologica.repository.IOdontologoRepository;
import com.dh.clinicaOdontologica.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.Logger;
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

    private Logger logger;

    @Override
    public void crearOdontologo(OdontologoDTO odontologoDTO) {
        if (odontologoDTO != null) {
            logger.info("Creando odontologo...");
            guardarOdontologo(odontologoDTO);
        }
    }

    @Override
    public OdontologoDTO buscarOdontologoPorId(Long id) {
        logger.info("Buscando odontologo con id: " + id);
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = null;
        if(odontologo.isPresent()){
            odontologoDTO = mapper.convertValue(odontologo,OdontologoDTO.class);
        }
        return odontologoDTO;
    }

    private void guardarOdontologo(OdontologoDTO odontologoDTO){
        logger.info("Guardando odontologo");
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(odontologo);
    }

    @Override
    public void modificarOdontologo(OdontologoDTO odontologoDTO) {
        if(odontologoDTO != null) {
            logger.info("Modificando odontologo");
            guardarOdontologo(odontologoDTO);
        }
    }

    @Override
    public void eliminarOdontologo(Long id) {
        Optional<Odontologo> busqueda = odontologoRepository.findById(id);
        if(busqueda.isPresent()){
            logger.info("Eliminando el odontologo con id: " + id);
            odontologoRepository.delete(busqueda.get());
        }
    }

    @Override
    public Set<OdontologoDTO> listarTodosLosOdontologos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologosDTO = new HashSet<>();

        for (Odontologo odontologo : odontologos){
            odontologosDTO.add(mapper.convertValue(odontologo,OdontologoDTO.class));
        }
        logger.info("Listando todos los odontologos");
        return odontologosDTO;
    }
}
