package com.odontologica.main.persistence.dao.impl;

import com.odontologica.main.model.Domicilio;
import com.odontologica.main.persistence.dao.Dao;
import com.odontologica.main.persistence.dao.util.ConfiguracionJDBC;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

public class DomicilioDao implements Dao<Domicilio> {

    private ConfiguracionJDBC jdbc = new ConfiguracionJDBC();

    private Logger logger = Logger.getLogger(Domicilio.class);

    @Override
    public List<Domicilio> consultarTodos() {
        return null;
    }

    @Override
    public Domicilio consultarPorId(int id) {
        Domicilio resultado = null;

        //[1a] Cargar el controlador
        jdbc.cargarElControlador();

        //[1b]
        //[2] Crear el statement
        try(Connection conn = jdbc.conectarConBaseDeDatos();
            Statement stmt = conn.createStatement()){

        //[3] Ejecutamos el statement
            ResultSet rs = stmt.executeQuery("SELECT * FROM domicilios WHERE id = " + id);

        //[4] Procesar el ResultSet
            if(rs.next()){
                resultado = new Domicilio();
                resultado.setId(rs.getInt("id"));
                resultado.setCalle(rs.getString("calle"));
            }

        } catch (SQLException e) {
            logger.error("Ha ocurrido en error al consultar el domicilio: " + id);
        }

        //[5] Retornar el resultado de la búsqueda
        return resultado;
    }

    @Override
    public Domicilio crear(Domicilio entidad) {
        return null;
    }

    @Override
    public Domicilio guardar(Domicilio entidad) {
        return null;
    }
}
