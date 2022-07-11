package com.dh.clinicaOdontologica.service.impl;

import com.dh.clinicaOdontologica.exceptions.BadRequestException;
import com.dh.clinicaOdontologica.exceptions.ServiceException;
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

    private final IPacienteRepository pacienteRepository;
    private final Logger logger = Logger.getLogger(PacienteServiceImpl.class);

    @Autowired
    ObjectMapper mapper;

    @Autowired
    public PacienteServiceImpl(IPacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public void crearPaciente(PacienteDTO pacienteDTO) throws BadRequestException {
        if (pacienteDTO == null){
            throw new BadRequestException("El paciente que está intentando crear es nulo.");
        } else {
            logger.debug("Creando paciente...");
            guardarPaciente(pacienteDTO);
        }
    }

    @Override
    public PacienteDTO buscarPacientePorId(Long id) throws ResourceNotFoundException {
        logger.debug("Buscando paciente con id: " + id);
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if(paciente.isPresent()){
            return mapper.convertValue(paciente, PacienteDTO.class);
        } else {
            throw new ResourceNotFoundException("El paciente con id: " + id + " no existe.");
        }
    }

    private void guardarPaciente(PacienteDTO pacienteDTO){
        logger.debug("Guardando paciente");
        Paciente paciente = mapper.convertValue(pacienteDTO,Paciente.class);
        pacienteRepository.save(paciente);
    }

    @Override
    public void modificarPaciente(PacienteDTO pacienteDTO) throws BadRequestException {
        if (pacienteDTO.getId() == null) {
            throw new BadRequestException("El paciente que está intentando modificar no existe.");
        } else {
            logger.debug("Modificando paciente");
            guardarPaciente(pacienteDTO);
        }
    }

    @Override
    public void eliminarPaciente(Long id) throws ResourceNotFoundException {
        if (pacienteRepository.findById(id).isEmpty()){
            throw new ResourceNotFoundException("No existe un paciente con id: " + id);
        } else {
            logger.debug("Eliminando el paciente con id: " + id);
            pacienteRepository.delete(pacienteRepository.findById(id).get());
        }
    }

    @Override
    public Set<PacienteDTO> listarTodosLosPacientes() throws ServiceException {
        List<Paciente> pacientes = pacienteRepository.findAll();

        if (pacientes.isEmpty()){
            throw new ServiceException("No hay pacientes para listar.");
        } else {
            Set<PacienteDTO> pacientesDTO = new HashSet<>();
            for (Paciente paciente : pacientes){
                pacientesDTO.add(mapper.convertValue(paciente,PacienteDTO.class));
            }
            logger.debug("Listando todos los pacientes");
            return pacientesDTO;
        }
    }

    @Override
    public PacienteDTO buscarPacientePorEmail(String email) throws ResourceNotFoundException {
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
