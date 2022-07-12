package com.dh.clinicaOdontologica;

import com.dh.clinicaOdontologica.dto.TurnoDTO;
import com.dh.clinicaOdontologica.model.Domicilio;
import com.dh.clinicaOdontologica.model.Odontologo;
import com.dh.clinicaOdontologica.model.Paciente;
import com.dh.clinicaOdontologica.util.Jsons;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class IntegracionTurnoTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void crearTurno() throws Exception {
        Paciente paciente = new Paciente("Maria Pia","Aparicio","32279584",new Domicilio(),"pia_aparicio@digital.com", LocalDate.now());
        Odontologo odontologo = new Odontologo("Esposito", "Marta", "HGA571");
        TurnoDTO turno = new TurnoDTO(paciente,odontologo,"2022-07-11","15:00");
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/turnos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Jsons.asJsonString(turno)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
    }

    @Test
    public void crearTurnoConError() throws Exception {
        TurnoDTO turno = new TurnoDTO(new Paciente(),new Odontologo(),"2022-07-11","15:00");
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/turnos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(Jsons.asJsonString(turno)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest()).andReturn();

        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
    }



}
