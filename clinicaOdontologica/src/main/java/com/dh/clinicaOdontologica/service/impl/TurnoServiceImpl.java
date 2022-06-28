package com.dh.clinicaOdontologica.service.impl;

import com.dh.clinicaOdontologica.model.Turno;
import com.dh.clinicaOdontologica.model.dto.TurnoDTO;
import com.dh.clinicaOdontologica.repository.ITurnoRepository;
import com.dh.clinicaOdontologica.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Autowired
    ObjectMapper mapper;

    @Override
    public void crearTurno(TurnoDTO turnoDTO) {
        guardarTurno(turnoDTO);
    }

    @Override
    public TurnoDTO buscarTurno(Long id) {
        Optional<Turno> turno = turnoRepository.findById(id);
        TurnoDTO turnoDTO = null;
        if(turno.isPresent()){
            turnoDTO = mapper.convertValue(turno,TurnoDTO.class);
        }
        return turnoDTO;
    }

    private void guardarTurno(TurnoDTO turnoDTO){
        Turno turno = mapper.convertValue(turnoDTO,Turno.class);
        turnoRepository.save(turno);
    }

    @Override
    public void modificarTurno(TurnoDTO turnoDTO) {
        guardarTurno(turnoDTO);
    }

    @Override
    public boolean eliminarTurno(Long id) {
        boolean resultado = false;
        Optional<Turno> busqueda = turnoRepository.findById(id);
        if(busqueda.isPresent()){
            turnoRepository.delete(busqueda.get());
            resultado = true;
        }
        return resultado;
    }

    @Override
    public Set<TurnoDTO> listarTodosLosTurnos() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDTO> turnosDTO = new HashSet<>();

        for (Turno turno : turnos){
            turnosDTO.add(mapper.convertValue(turno,TurnoDTO.class));
        }
        return turnosDTO;
    }
}
