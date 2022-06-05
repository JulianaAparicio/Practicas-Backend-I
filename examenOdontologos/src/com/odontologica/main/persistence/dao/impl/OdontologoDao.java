package com.odontologica.main.persistence.dao.impl;

import com.odontologica.main.model.Odontologo;
import com.odontologica.main.persistence.dao.Dao;
import com.odontologica.main.persistence.dao.util.ConfiguracionJDBC;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDao implements Dao<Odontologo> {

    // Creación del objeto logger:
    private Logger logger = Logger.getLogger(OdontologoDao.class);

    // Nombre de la tabla:
    private final static String TABLE = "odontologos";

    // Datos de Driver y conexión a BD:
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/db_odontologos;INIT=RUNSCRIPT FROM 'create.sql'";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";

    // Creación de variables para reutilizar en loggers:
    private final static String CARGA_EXITOSA = "Carga de controlador exitosa.";
    private final static String CONECTANDO_BD = "Conectando a la base de datos...";
    private final static String CONEXION_EXITOSA = "Conexión a base de datos exitosa.";
    private final static String EJECUTANDO_CONSULTA = "Ejecutando consulta a base de datos...";
    private final static String CARGANDO_RESULTADO = "Cargando resultado...";


    // Creación de nueva configuración para la BD:
    private ConfiguracionJDBC jdbcOdontologos = new ConfiguracionJDBC(DB_JDBC_DRIVER, DB_URL, DB_USER, DB_PASSWORD);


    // Métodos:

    @Override
    public List<Odontologo> consultarTodos() {
        List<Odontologo> resultado = new ArrayList<>();

        // Carga del controlador:
        jdbcOdontologos.cargarElControlador();
        logger.info(CARGA_EXITOSA);

        // Creación del statement:
        logger.info(CONECTANDO_BD);
        try (Connection conn = jdbcOdontologos.conectarConBaseDeDatos();
             Statement stmt = conn.createStatement()) {

            logger.info(CONEXION_EXITOSA);

            // Ejecución del statement:
            logger.info(EJECUTANDO_CONSULTA);
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLE);

            // Proceso del ResultSet
            logger.info(CARGANDO_RESULTADO);
            while (rs.next()) {
                Odontologo o = new Odontologo();
                o.setId(rs.getInt("id"));
                o.setNumeroMatricula(rs.getString("numero_matricula"));
                o.setNombre(rs.getString("nombre"));
                o.setApellido(rs.getString("apellido"));

                resultado.add(o);
            }

        } catch (SQLException ex) {
            logger.error("Ha ocurrido un error al consultar los odontólogos." + ex.getMessage());
        }

        return resultado;
    }

    @Override
    public Odontologo consultarPorId(int id) {
        Odontologo respuesta = null;

        // Carga del controlador:
        jdbcOdontologos.cargarElControlador();
        logger.info(CARGA_EXITOSA);

        // Creación del statement:
        logger.info(CONECTANDO_BD);

        try (Connection conn = jdbcOdontologos.conectarConBaseDeDatos();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + TABLE + " WHERE id = ?")) {

            logger.info(CONEXION_EXITOSA);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                respuesta = new Odontologo(rs.getString("número de matrícula"),
                        rs.getString("nombre"),
                        rs.getString("apellido"));
            }

        } catch (SQLException ex) {
            logger.error("Ha ocurrido un error al consultar el odontólogo." + ex.getMessage());
        }
        return respuesta;
    }


    @Override
    public Odontologo crear(Odontologo entidad) {
        return null;
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {

        // Carga del controlador:
        jdbcOdontologos.cargarElControlador();
        logger.info(CARGA_EXITOSA );

        // Creación del Prepared Statement:
        logger.info(CONECTANDO_BD);
        try(Connection conn = jdbcOdontologos.conectarConBaseDeDatos();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + TABLE + "VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);){

            logger.info(CONEXION_EXITOSA);

            // Carga de parámetros:
            ps.setString(1,odontologo.getNumeroMatricula());
            ps.setString(2,odontologo.getNombre());
            ps.setString(3,odontologo.getApellido());
            logger.info("Parámetros cargados con éxito.");

            // Ejecución del Prepared Statement:
            ps.executeUpdate();

        } catch (SQLException ex) {
            logger.error("Ha ocurrido un error al guardar el odontólogo." + ex.getMessage());
        }
        return odontologo;
    }
}
