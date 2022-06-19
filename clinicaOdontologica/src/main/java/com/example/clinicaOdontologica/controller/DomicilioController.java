package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.persistence.dao.DomicilioDao;
import com.example.clinicaOdontologica.service.DomicilioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {

    private DomicilioService domicilioService = new DomicilioService(new DomicilioDao());



}
