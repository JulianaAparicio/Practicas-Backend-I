package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.model.dto.TurnoDto;
import com.example.clinicaOdontologica.model.Odontologo;
import com.example.clinicaOdontologica.model.Paciente;
import com.example.clinicaOdontologica.persistence.dao.OdontologoDao;
import com.example.clinicaOdontologica.persistence.dao.TurnoDao;
import com.example.clinicaOdontologica.service.OdontologoService;
import com.example.clinicaOdontologica.service.PacienteService;
import com.example.clinicaOdontologica.service.TurnoService;
import com.example.clinicaOdontologica.service.serviceException.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private TurnoService turnoService = new TurnoService(new TurnoDao());
    private PacienteService pacienteService = new PacienteService();
    private OdontologoService odontologoService = new OdontologoService(new OdontologoDao());

    @PostMapping("/crear")
    public ResponseEntity<TurnoDto> crearTurno(@RequestBody TurnoDto turno) {

        ResponseEntity<TurnoDto> respuesta;

        Paciente p = pacienteService.buscarPacientePorId(turno.getPaciente().getId());
        Odontologo o = odontologoService.buscarOdontologoPorId(turno.getOdontologo().getId());

        if(p != null && o != null){
            turnoService.registrarTurno(turno);
            respuesta = ResponseEntity.ok(turno);
        }else{
            respuesta = ResponseEntity.badRequest().body(null);
        }
        System.out.println(respuesta);
        return respuesta;
    }

    @GetMapping
    public ResponseEntity<List<TurnoDto>> listarTodosLosTurnos() {
        return ResponseEntity.ok(turnoService.listarTodosLosTurnos());
    }

    @GetMapping("/turnoPorId/{id}")
    public ResponseEntity<TurnoDto> buscarTurnoPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(turnoService.consultarTurnoPorId(id));
    }

    @DeleteMapping ("/eliminar/{id}")
    public void eliminarTurnoPorId(@PathVariable("id") Long id){
        turnoService.eliminarTurno(id);
    }

    @PutMapping("modificar")
    public ResponseEntity<TurnoDto> actualizarTurno(@RequestBody TurnoDto t){
        ResponseEntity<TurnoDto> response = null;

        if (t.getId() != null && turnoService.consultarTurnoPorId(t.getId()) != null) {
            try {
                response = ResponseEntity.ok(turnoService.editarTurno(t));
            } catch (ServiceException ex) {
                response = ResponseEntity.badRequest().body(null);
            }
        }
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;

    }
}
