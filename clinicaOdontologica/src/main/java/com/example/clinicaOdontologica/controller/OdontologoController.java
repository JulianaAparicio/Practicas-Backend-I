package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.model.Odontologo;
import com.example.clinicaOdontologica.persistence.dao.OdontologoDao;
import com.example.clinicaOdontologica.service.OdontologoService;
import com.example.clinicaOdontologica.service.serviceException.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    private OdontologoService odontologoService = new OdontologoService(new OdontologoDao());

    @GetMapping
    public ResponseEntity<List<Odontologo>> listarTodosLosOdontologos(){
        return ResponseEntity.ok(odontologoService.listarTodosLosOdontologos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarOdontologoPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(odontologoService.buscarOdontologoPorId(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<Odontologo> crearOdontologo(@RequestBody Odontologo o){
        return ResponseEntity.ok(odontologoService.crearOdontologo(o));
    }

    @PutMapping("/modificar")
    public ResponseEntity<Odontologo> actualizarOdontologo(@RequestBody Odontologo o){
        ResponseEntity<Odontologo> response = null;

        if (o.getId() != null && odontologoService.buscarOdontologoPorId(o.getId()) != null) {
            try {
                response = ResponseEntity.ok(odontologoService.actualizarOdontologo(o));
            } catch (ServiceException ex) {
                response = ResponseEntity.badRequest().body(null);
            }
        }
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarOdontologoPorId(@PathVariable("id") Long id){
        odontologoService.eliminarOdontologoPorId(id);
    }

}
