package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.model.Paciente;
import com.example.clinicaOdontologica.service.PacienteService;
import com.example.clinicaOdontologica.service.serviceException.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private PacienteService pacienteService = new PacienteService();

    @RequestMapping(method = RequestMethod.GET, path = "todos")
    public List<Paciente> listarTodosLosPacientes(){
        return pacienteService.listarTodosLosPacientes();
    }

    @GetMapping("/pacientePorId")
    public String buscarPacientePorId (@RequestParam Long id){

        return pacienteService.buscarPacientePorId(id).toString();
    }

    @GetMapping("/pacientePorEmail")
    public String buscarPacientePorEmail(@RequestParam String email){

        return pacienteService.buscarPacientePorEmail(email).toString();
    }

    @PostMapping(path = "/crear")
    public ResponseEntity<Paciente> crearPaciente(@RequestBody Paciente p){

        ResponseEntity respuesta = null;
        respuesta = ResponseEntity.ok(pacienteService.crearPaciente(p));

        return respuesta;
    }

    @PutMapping("/modificar")
    public ResponseEntity<Paciente> actualizarPaciente(@RequestBody Paciente p) throws ServiceException {

        ResponseEntity respuesta = null;
        if(p.getId() != null){
            respuesta = ResponseEntity.ok().body(pacienteService.actualizarPaciente(p));
        }else{
            respuesta = ResponseEntity.badRequest().body(p);
        }

        return respuesta;
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Paciente> eliminarPacientePorId(@PathVariable Long id){
        ResponseEntity response = null;

        if(pacienteService.buscarPacientePorId(id) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            pacienteService.eliminarPaciente(id);
            response = new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return response;
    }

}
