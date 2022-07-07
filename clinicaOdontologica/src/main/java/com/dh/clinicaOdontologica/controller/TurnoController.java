package com.dh.clinicaOdontologica.controller;

import com.dh.clinicaOdontologica.dto.TurnoDTO;
import com.dh.clinicaOdontologica.exceptions.BadRequestException;
import com.dh.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.dh.clinicaOdontologica.service.ITurnoService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    private ITurnoService turnoService;

    @PostMapping
    public ResponseEntity<?> crearTurno(@RequestBody TurnoDTO turnoDTO) throws BadRequestException {
        turnoService.crearTurno(turnoDTO);
        return ResponseEntity.ok("creado");
    }

    @GetMapping("/{id}")
    public TurnoDTO buscarTurnoPorId(@PathVariable Long id){
        return turnoService.buscarTurnoPorId(id);
    }

    @GetMapping
    public Collection<TurnoDTO> listarTodosLosTurnos(){
        return turnoService.listarTodosLosTurnos();
    }

    @PutMapping
    public ResponseEntity<?> modificarTurno(@RequestBody TurnoDTO turnoDTO){
        turnoService.modificarTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable Long id) throws ResourceNotFoundException {
        turnoService.eliminarTurno(id);
        return ResponseEntity.ok("Eliminado");
    }

    @ExceptionHandler({ ServiceException.class})
    public ResponseEntity<String> handleException(ServiceException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }


}
