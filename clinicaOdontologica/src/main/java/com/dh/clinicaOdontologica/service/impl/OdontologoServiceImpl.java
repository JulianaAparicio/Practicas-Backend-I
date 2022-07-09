package com.dh.clinicaOdontologica.service.impl;

import com.dh.clinicaOdontologica.exceptions.BadRequestException;
import com.dh.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.dh.clinicaOdontologica.model.Odontologo;
import com.dh.clinicaOdontologica.dto.OdontologoDTO;
import com.dh.clinicaOdontologica.repository.IOdontologoRepository;
import com.dh.clinicaOdontologica.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoServiceImpl implements IOdontologoService {

    private final IOdontologoRepository odontologoRepository;
    private final Logger logger = Logger.getLogger(OdontologoServiceImpl.class);


    @Autowired
    ObjectMapper mapper;


    @Autowired
    public OdontologoServiceImpl(IOdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    @Override
    public void crearOdontologo(OdontologoDTO odontologoDTO) throws BadRequestException {
        if (odontologoDTO == null){
            throw new BadRequestException("El odontólogo que está intentando crear está vacío.");
        } else {
            logger.debug("Creando odontólogo...");
            guardarOdontologo(odontologoDTO);
        }
    }

    @Override
    public OdontologoDTO buscarOdontologoPorId(Long id) throws ResourceNotFoundException {
        logger.debug("Buscando odontologo con id: " + id);
            Optional<Odontologo> odontologo = odontologoRepository.findById(id);
            if(odontologo.isPresent()){
                return mapper.convertValue(odontologo,OdontologoDTO.class);
            } else {
                throw new ResourceNotFoundException("El odontólogo con id: " + id + " no existe.");
            }
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

    @Override
    public OdontologoDTO buscarOdontologoPorMatricula(String matricula) throws ResourceNotFoundException {
        if (odontologoRepository.buscarOdontologoPorMatricula(matricula) == null){
            throw new ResourceNotFoundException("No existe un odontólogo con matrícula: " + matricula);
        } else {
            logger.debug("Buscando odontologo con matrícula: " + matricula);
            Odontologo odontologo = odontologoRepository.buscarOdontologoPorMatricula(matricula);
            OdontologoDTO odontologoDTO;
            odontologoDTO = mapper.convertValue(odontologo,OdontologoDTO.class);
            return odontologoDTO;
        }
    }

    public void invocarMetodoConError() throws ServiceException {
        throw new ServiceException("Ha ocurrido un error en la capa de servicio");
    }
}
