package com.example.clinicaOdontologica.persistence.dao;


import com.example.clinicaOdontologica.model.Domicilio;

import com.example.clinicaOdontologica.persistence.util.ConfiguracionJDBC;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class DomicilioDao implements Dao<Domicilio> {

    private ConfiguracionJDBC jdbc = new ConfiguracionJDBC();
    private Logger logger = Logger.getLogger(Domicilio.class);


    // TODOS LOS DOMICILIOS
    @Override
    public List<Domicilio> consultarTodos() {
        List<Domicilio> resultado = new ArrayList<>();
        String query = "SELECT * FROM domicilios";

        // 1 - Cargar el controlador
        jdbc.cargarElControlador();

        // 2 - Conectar y Crear el Statement
        try (Connection conexion = jdbc.conectarConBaseDeDatos();
             PreparedStatement pstat = conexion.prepareStatement(query)) {

            // 3 - Ejecutar el statement
            ResultSet rs = pstat.executeQuery();

            //  4- Procesar el ResultSet
            while (rs.next()) {

                Domicilio d = new Domicilio();

                d.setId(rs.getLong("id"));
                d.setCalle(rs.getString("calle"));
                d.setNumero(rs.getString("numero"));
                d.setLocalidad(rs.getString("localidad"));
                d.setProvincia(rs.getString("provincia"));

                System.out.println(d.toString());
                resultado.add(d);
            }
            System.out.println(resultado.toString());
            logger.info("Se consultaron todos los registros de la tabla Domicilios");

        } catch (SQLException e) {
            logger.error("Ha ocurrido un error en consultar los domicilios" + e);
        }
        // 5 - Resultado de la búsqueda

        return resultado;
    }

    @Override
    public Domicilio crear(Domicilio d) {

        // 1 - Cargar el controlador
        jdbc.cargarElControlador();

        String query = "INSERT INTO domicilios(calle,numero,localidad,provincia) VALUES(?,?,?,?)";

        // 2 - Conectar y Crear el Statement
        try (Connection conexion = jdbc.conectarConBaseDeDatos();
             PreparedStatement pstat = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            pstat.setString(1, d.getCalle());
            pstat.setString(2, d.getNumero());
            pstat.setString(3, d.getLocalidad());
            pstat.setString(4, d.getProvincia());

            pstat.executeUpdate();

            ResultSet rs = pstat.getGeneratedKeys();
            if (rs.next()) {
                d.setId(rs.getLong(1));
            }

            logger.info("Se creó exitosamente el registro del domicilio con id: " + d.getId());


        } catch (SQLException e) {
            logger.error("Ha ocurrido un error al crear nuevo domicilio: " + e);
        }

        return d;
    }

    // CONSULTA DOMICILIO POR ID
    @Override
    public Domicilio consultarPorId(long id) {

        Domicilio resultado = null;

        // 1 - Cargar el controlador
        jdbc.cargarElControlador();

        // 2 - Conectar y Crear el Statement
        try (Connection conexion = jdbc.conectarConBaseDeDatos();
             PreparedStatement pstat = conexion.prepareStatement("SELECT * FROM domicilios WHERE id = ?")) {

            pstat.setLong(1, id);

            // 3 - Ejecutar el statement
            ResultSet rs = pstat.executeQuery();

            //  4- Procesar el ResultSet
            if (rs.next()) {
                resultado = new Domicilio();
                resultado.setId(rs.getLong("id"));
                resultado.setCalle(rs.getString("calle"));
            }

        } catch (SQLException e) {
            logger.error("Ha ocurrido un error en consultar el domicilio: " + id);
        }
        // 5 - Retornar el resultado de la búsqueda

        return resultado;

    }

    // EDITAR REGISTRO DE DOMICILIO, POR ID
    @Override
    public Domicilio editar(Domicilio d) {
        String query = "UPDATE domicilios SET calle = ?, numero = ?, localidad = ?, provincia = ? WHERE id = ?";

        // 1 - Cargar el controlador
        jdbc.cargarElControlador();

        // 2 - Conectar y Crear el Statement
        try (Connection conexion = jdbc.conectarConBaseDeDatos();
             PreparedStatement pstat = conexion.prepareStatement(query)) {

            pstat.setString(1, d.getCalle());
            pstat.setString(2, d.getNumero());
            pstat.setString(3, d.getLocalidad());
            pstat.setString(4, d.getProvincia());
            pstat.setLong(5, d.getId());

            // 3 - Ejecutar el statement

            pstat.executeUpdate();

            logger.info("Se editó al domicilio con id: " + d.getId());

        } catch (SQLException e) {
            logger.debug("Ha ocurrido un error al editar al domicilio con id: " + d.getId());
        }

        return d;
    }

    // ELIMINA REGISTRO DE DOMICILIO, POR ID
    @Override
    public void eliminar(long id) {
        Domicilio resultado = null;
        String query = "DELETE * FROM domicilios WHERE id = ?";

        // 1 - Cargar el controlador
        jdbc.cargarElControlador();


        // 2 - Conectar y Crear el Statement
        try (Connection conexion = jdbc.conectarConBaseDeDatos();
             PreparedStatement pstat = conexion.prepareStatement(query)) {

            pstat.setLong(1, id);

            // 3 - Ejecutar el statement
            ResultSet rs = pstat.executeQuery();


        } catch (SQLException e) {
            logger.error("Ha ocurrido un error al intentar borrar el domicilio con id: " + id);
        }

        // 5 - Retornar el resultado de la búsqueda
        System.out.println("El domicilio eliminado es: " + resultado.toString());
    }
}

