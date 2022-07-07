package com.dh.clinicaOdontologica.service.impl;

import com.dh.clinicaOdontologica.exceptions.BadRequestException;
import com.dh.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.dh.clinicaOdontologica.model.Turno;
import com.dh.clinicaOdontologica.dto.TurnoDTO;
import com.dh.clinicaOdontologica.repository.ITurnoRepository;
import com.dh.clinicaOdontologica.service.ITurnoService;
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
public class TurnoServiceImpl implements ITurnoService {

    @Autowired
    private ITurnoRepository turnoRepository;

    private final Logger logger = Logger.getLogger(TurnoServiceImpl.class);

    @Autowired
    ObjectMapper mapper;

    @Override
    public void crearTurno(TurnoDTO turnoDTO) throws BadRequestException {
        if (turnoDTO.getPaciente().getId() != null || turnoDTO.getOdontologo().getId() != null){
            throw new BadRequestException("El turno que está intentando crear no posse un paciente u odontólogo.");
        } else {
            logger.debug("Creando turno...");
            guardarTurno(turnoDTO);
        }
    }

    @Override
    public TurnoDTO buscarTurnoPorId(Long id) {
        logger.debug("Buscando turno con id: " + id);
        Optional<Turno> turno = turnoRepository.findById(id);
        TurnoDTO turnoDTO = null;
        if(turno.isPresent()){
            turnoDTO = mapper.convertValue(turno,TurnoDTO.class);
        }
        return turnoDTO;
    }

    private void guardarTurno(TurnoDTO turnoDTO){
        logger.debug("Guardando turno");
        Turno turno = mapper.convertValue(turnoDTO,Turno.class);
        turnoRepository.save(turno);
    }

    @Override
    public void modificarTurno(TurnoDTO turnoDTO) {
        if (turnoDTO != null) {
            logger.debug("Modificando turno");
            guardarTurno(turnoDTO);
        }
    }

    @Override
    public void eliminarTurno(Long id) throws ResourceNotFoundException {
        Optional<Turno> busqueda = turnoRepository.findById(id);
        if(busqueda.isPresent()){
            logger.debug("Eliminando el turno con id: " + id);
            turnoRepository.delete(busqueda.get());
        } else {
            throw new ResourceNotFoundException("El id N° " + id + " no existe.");
        }
    }

    @Override
    public Set<TurnoDTO> listarTodosLosTurnos() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDTO> turnosDTO = new HashSet<>();

        for (Turno turno : turnos){
            turnosDTO.add(mapper.convertValue(turno,TurnoDTO.class));
        }
        logger.debug("Listando todos los turnos");
        return turnosDTO;
    }

    public void invocarMetodoConError() throws ServiceException {
        throw new ServiceException("Ha ocurrido un error en la capa de servicio");
    }
}
