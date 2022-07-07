package com.dh.clinicaOdontologica.controller;

import com.dh.clinicaOdontologica.dto.OdontologoDTO;
import com.dh.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.dh.clinicaOdontologica.service.IOdontologoService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
    private IOdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<?> crearOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        odontologoService.crearOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public OdontologoDTO buscarOdontologoPorId(@PathVariable Long id) throws ResourceNotFoundException{
        return odontologoService.buscarOdontologoPorId(id);
    }

    @GetMapping
    public Collection<OdontologoDTO> listarTodosLosOdontologos(){
        return odontologoService.listarTodosLosOdontologos();
    }

    @PutMapping
    public ResponseEntity<?> modificarOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        odontologoService.modificarOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id) throws ResourceNotFoundException {
        odontologoService.eliminarOdontologo(id);
        return ResponseEntity.ok("Eliminado");
    }

    @GetMapping("/dispararError")
    public ResponseEntity<OdontologoDTO> lanzarError(@PathVariable Integer id) throws ServiceException {
        odontologoService.invocarMetodoConError();

        return ResponseEntity.ok(null);
    }

    @ExceptionHandler({ ServiceException.class})
    public ResponseEntity<String> handleException(ServiceException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }


}
