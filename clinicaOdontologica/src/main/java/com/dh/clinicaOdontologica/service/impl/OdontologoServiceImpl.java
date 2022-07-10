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
            throw new BadRequestException("El odontólogo que está intentando crear es nulo.");
        } else {
            logger.debug("Creando odontólogo...");
            guardarOdontologo(odontologoDTO);
        }
    }

    @Override
    public OdontologoDTO buscarOdontologoPorId(Long id) throws ResourceNotFoundException {
        logger.debug("Buscando odontólogo con id: " + id);
            Optional<Odontologo> odontologo = odontologoRepository.findById(id);
            if(odontologo.isPresent()){
                return mapper.convertValue(odontologo,OdontologoDTO.class);
            } else {
                throw new ResourceNotFoundException("El odontólogo con id: " + id + " no existe.");
            }
        }

    private void guardarOdontologo(OdontologoDTO odontologoDTO){
        logger.debug("Guardando odontólogo");
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(odontologo);
    }

    @Override
    public void modificarOdontologo(OdontologoDTO odontologoDTO) throws BadRequestException {
        if (odontologoDTO == null){
            throw new BadRequestException("Los datos del odontólogo no pueden estar vacíos.");
        } else {
            logger.debug("Modificando odontólogo");
            guardarOdontologo(odontologoDTO);
        }
    }

    @Override
    public void eliminarOdontologo(Long id) throws ResourceNotFoundException {
        if (odontologoRepository.findById(id).isEmpty()){
            throw new ResourceNotFoundException("No existe un odontólogo con id: " + id);
        } else {
            logger.debug("Eliminando el odontólogo con id: " + id);
            odontologoRepository.delete(odontologoRepository.findById(id).get());
        }
    }

    @Override
    public Set<OdontologoDTO> listarTodosLosOdontologos() throws ServiceException {
        List<Odontologo> odontologos = odontologoRepository.findAll();

        if (odontologos.isEmpty()) {
            throw new ServiceException("No hay odontólogos para listar.");
        } else {
            Set<OdontologoDTO> odontologosDTO = new HashSet<>();
            for (Odontologo odontologo : odontologos) {
                odontologosDTO.add(mapper.convertValue(odontologo, OdontologoDTO.class));
            }
            logger.debug("Listando todos los odontólogos");
            return odontologosDTO;
        }
    }

    @Override
    public OdontologoDTO buscarOdontologoPorMatricula(String matricula) throws ResourceNotFoundException {
        if (odontologoRepository.buscarOdontologoPorMatricula(matricula) == null){
            throw new ResourceNotFoundException("No existe un odontólogo con matrícula: " + matricula);
        } else {
            logger.debug("Buscando odontólogo con matrícula: " + matricula);
            Odontologo odontologo = odontologoRepository.buscarOdontologoPorMatricula(matricula);
            OdontologoDTO odontologoDTO;
            odontologoDTO = mapper.convertValue(odontologo,OdontologoDTO.class);
            return odontologoDTO;
        }
    }
}
