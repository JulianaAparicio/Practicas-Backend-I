package com.dh.clinicaOdontologica.service.impl;

import com.dh.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.dh.clinicaOdontologica.model.Paciente;
import com.dh.clinicaOdontologica.dto.PacienteDTO;
import com.dh.clinicaOdontologica.repository.IPacienteRepository;
import com.dh.clinicaOdontologica.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteServiceImpl implements IPacienteService {

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;

    private final Logger logger = Logger.getLogger(PacienteServiceImpl.class);

    @Override
    public void crearPaciente(PacienteDTO pacienteDTO) {
        if (pacienteDTO != null){
            logger.debug("Creando paciente...");
            guardarPaciente(pacienteDTO);
        }
    }


    // Corregí cosas ver si sigue funcionando:

    @Override
    public PacienteDTO buscarPacientePorId(Long id) throws ResourceNotFoundException {
        logger.debug("Buscando paciente con id: " + id);
        if (pacienteRepository.findById(id).isEmpty()){
            throw new ResourceNotFoundException("No existe un paciente con id: " + id);
        } else {
            Optional<Paciente> paciente = pacienteRepository.findById(id);
            PacienteDTO pacienteDTO;
            pacienteDTO = mapper.convertValue(paciente,PacienteDTO.class);
            return pacienteDTO;
        }
    }

    private void guardarPaciente(PacienteDTO pacienteDTO){
        logger.debug("Guardando paciente");
        Paciente paciente = mapper.convertValue(pacienteDTO,Paciente.class);
        pacienteRepository.save(paciente);
    }

    @Override
    public void modificarPaciente(PacienteDTO pacienteDTO) {
        if (pacienteDTO != null){
            logger.debug("Modificando paciente");
            guardarPaciente(pacienteDTO);
        }
    }

    @Override
    public void eliminarPaciente(Long id) throws ResourceNotFoundException {
        if (pacienteRepository.findById(id).isEmpty()){
            throw new ResourceNotFoundException("No existe un paciente con id: " + id);
        }
        logger.debug("Eliminando el paciente con id: " + id);
        pacienteRepository.delete(pacienteRepository.findById(id).get());
    }

    @Override
    public Set<PacienteDTO> listarTodosLosPacientes() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDTO> pacientesDTO = new HashSet<>();

        for (Paciente paciente : pacientes){
            pacientesDTO.add(mapper.convertValue(paciente,PacienteDTO.class));
        }
        logger.debug("Listando todos los pacientes");
        return pacientesDTO;
    }

    @Override
    public PacienteDTO buscarPacientePorEmail(String email) throws ResourceNotFoundException {
        /*Paciente paciente = pacienteRepository.buscarPacientePorEmail(email);
        PacienteDTO pacienteDTO = null;*/
        logger.debug("Buscando paciente con email: " + email);
        /*if(paciente != null){
            pacienteDTO = mapper.convertValue(paciente,PacienteDTO.class);
        }
        return pacienteDTO;*/

        if (pacienteRepository.buscarPacientePorEmail(email) == null){
            throw new ResourceNotFoundException("No existe un paciente con email: " + email);
        } else {
            Paciente paciente = pacienteRepository.buscarPacientePorEmail(email);
            PacienteDTO pacienteDTO;
            pacienteDTO = mapper.convertValue(paciente,PacienteDTO.class);
            return pacienteDTO;
        }
    }


}
