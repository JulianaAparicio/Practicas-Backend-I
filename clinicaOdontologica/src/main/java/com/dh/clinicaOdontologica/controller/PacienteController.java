package com.dh.clinicaOdontologica.controller;

import com.dh.clinicaOdontologica.dto.PacienteDTO;
import com.dh.clinicaOdontologica.exceptions.BadRequestException;
import com.dh.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.dh.clinicaOdontologica.service.IPacienteService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private IPacienteService pacienteService;

    @PostMapping()
    public ResponseEntity<?> crearPaciente(@RequestBody PacienteDTO pacienteDTO) throws BadRequestException {
        pacienteService.crearPaciente(pacienteDTO);
        return ResponseEntity.ok("El paciente se ha creado exitosamente.");
    }

    @GetMapping("/{id}")
    public PacienteDTO buscarPacientePorId(@PathVariable Long id) throws ResourceNotFoundException {
        return pacienteService.buscarPacientePorId(id);
    }

    @GetMapping
    public Collection<PacienteDTO> listarTodosLosPacientes() {
        return pacienteService.listarTodosLosPacientes();
    }

    @PutMapping
    public ResponseEntity<?> modificarPaciente(@RequestBody PacienteDTO pacienteDTO) throws BadRequestException {
        pacienteService.modificarPaciente(pacienteDTO);
        return ResponseEntity.ok("El paciente ha sido modificado.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id) throws ResourceNotFoundException {
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.ok("El paciente ha sido eliminado.");
    }

    @GetMapping("/buscarPorEmail/{email}")
    public PacienteDTO buscarPacientePorEmail(@PathVariable String email) throws ResourceNotFoundException {
        return pacienteService.buscarPacientePorEmail(email);
    }

    @ExceptionHandler({ ServiceException.class})
    public ResponseEntity<String> handleException(ServiceException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }


}
