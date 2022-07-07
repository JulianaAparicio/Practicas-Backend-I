package com.dh.clinicaOdontologica.controller;

import com.dh.clinicaOdontologica.dto.PacienteDTO;
import com.dh.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.dh.clinicaOdontologica.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private IPacienteService pacienteService;

    @PostMapping()
    public ResponseEntity<?> crearPaciente(@RequestBody PacienteDTO pacienteDTO){
    pacienteService.crearPaciente(pacienteDTO);
    return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PacienteDTO buscarPacientePorId(@PathVariable Long id) throws ResourceNotFoundException {
        return pacienteService.buscarPacientePorId(id);
    }

    @GetMapping
    public Collection<PacienteDTO> listarTodosLosPacientes(){
        return pacienteService.listarTodosLosPacientes();
    }

    @PutMapping
    public ResponseEntity<?> modificarPaciente(@RequestBody PacienteDTO pacienteDTO){
        pacienteService.modificarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id) throws ResourceNotFoundException {
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.ok("Eliminado");
    }

    @GetMapping("/buscarPorEmail/{email}")
    public PacienteDTO buscarPacientePorEmail(@PathVariable String email) throws ResourceNotFoundException {
        return pacienteService.buscarPacientePorEmail(email);
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> procesarErrorNotFound(ResourceNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }




}
