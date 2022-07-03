package com.dh.clinicaOdontologica.service.impl;

import com.dh.clinicaOdontologica.model.Turno;
import com.dh.clinicaOdontologica.dto.TurnoDTO;
import com.dh.clinicaOdontologica.repository.ITurnoRepository;
import com.dh.clinicaOdontologica.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
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

    private Logger logger = Logger.getLogger(TurnoServiceImpl.class);

    @Autowired
    ObjectMapper mapper;

    @Override
    public void crearTurno(TurnoDTO turnoDTO) {
        if (turnoDTO != null){
            logger.info("Creando turno...");
            guardarTurno(turnoDTO);
        }
    }

    @Override
    public TurnoDTO buscarTurnoPorId(Long id) {
        logger.info("Buscando turno con id: " + id);
        Optional<Turno> turno = turnoRepository.findById(id);
        TurnoDTO turnoDTO = null;
        if(turno.isPresent()){
            turnoDTO = mapper.convertValue(turno,TurnoDTO.class);
        }
        return turnoDTO;
    }

    private void guardarTurno(TurnoDTO turnoDTO){
        logger.info("Guardando turno");
        Turno turno = mapper.convertValue(turnoDTO,Turno.class);
        turnoRepository.save(turno);
    }

    @Override
    public void modificarTurno(TurnoDTO turnoDTO) {
        if (turnoDTO != null) {
            logger.info("Modificando turno");
            guardarTurno(turnoDTO);
        }
    }

    @Override
    public void eliminarTurno(Long id) {
        Optional<Turno> busqueda = turnoRepository.findById(id);
        if(busqueda.isPresent()){
            logger.info("Eliminando el turno con id: " + id);
            turnoRepository.delete(busqueda.get());
        }
    }

    @Override
    public Set<TurnoDTO> listarTodosLosTurnos() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDTO> turnosDTO = new HashSet<>();

        for (Turno turno : turnos){
            turnosDTO.add(mapper.convertValue(turno,TurnoDTO.class));
        }
        logger.info("Listando todos los turnos");
        return turnosDTO;
    }
}
