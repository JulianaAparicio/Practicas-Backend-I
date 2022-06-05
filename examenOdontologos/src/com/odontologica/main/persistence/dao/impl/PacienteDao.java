package com.odontologica.main.persistence.dao.impl;

import com.odontologica.main.model.Domicilio;
import com.odontologica.main.model.Paciente;
import com.odontologica.main.persistence.dao.Dao;
import com.odontologica.main.persistence.dao.util.ConfiguracionJDBC;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PacienteDao implements Dao<Paciente> {

    private Logger logger = Logger.getLogger(PacienteDao.class);

    private ConfiguracionJDBC jdbcPacientes = new ConfiguracionJDBC();

    @Override
    public List<Paciente> consultarTodos() {
        List<Paciente> resultado = new ArrayList<>();

        //[1a] Cargar el controlador
        // Renombré el jdbc para que quede con el nombre de la tabla:
        jdbcPacientes.cargarElControlador();

        //[1b]
        //[2] Crear el statement
        try(Connection conn = jdbcPacientes.conectarConBaseDeDatos();
            Statement stmt = conn.createStatement()){

            //[3] Ejecutamos el statement
            ResultSet rs = stmt.executeQuery("SELECT * FROM pacientes");

            //[4] Procesar el ResultSet
            while(rs.next()){
                Paciente p = new Paciente();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));

                Domicilio d = new Domicilio(rs.getInt("id_domicilio"), null);
                p.setDomicilio(d);

                resultado.add(p);
            }

        } catch (SQLException ex) {
            logger.error("Ha ocurrido en error al consultar los pacientes." + ex.getMessage());
        }

        //[5] Retornar el resultado de la búsqueda
        return resultado;
    }

    @Override
    public Paciente consultarPorId(int id) {
        return null;
    }

    @Override
    public Paciente crear(Paciente entidad) {
        return null;
    }

    @Override
    public Paciente guardar(Paciente entidad) {
        return null;
    }
}
