package com.dh.clinicaOdontologica;

import com.dh.clinicaOdontologica.dto.OdontologoDTO;
import com.dh.clinicaOdontologica.dto.PacienteDTO;
import com.dh.clinicaOdontologica.model.Domicilio;
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


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class IntegracionPacienteTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void crearPaciente() throws Exception {
        PacienteDTO paciente = new PacienteDTO("Maria Pia","Aparicio","pia_aparicio@digital.com","32279584", new Domicilio());
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/pacientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(Jsons.asJsonString(paciente)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
    }

}
