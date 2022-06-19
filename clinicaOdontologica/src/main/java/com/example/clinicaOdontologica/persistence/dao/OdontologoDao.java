package com.example.clinicaOdontologica.persistence.dao;


import com.example.clinicaOdontologica.model.Odontologo;
import com.example.clinicaOdontologica.persistence.util.ConfiguracionJDBC;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDao implements Dao<Odontologo>{

    private ConfiguracionJDBC jdbc = new ConfiguracionJDBC();
    private Logger logger = Logger.getLogger(OdontologoDao.class);

    @Override
    public List<Odontologo> consultarTodos() {
        logger.debug("Buscando todos los odontologos");
        List<Odontologo> resultado = new ArrayList<>();
        String query = "SELECT * FROM odontologos";

        // 1 - Carga de controlador
        jdbc.cargarElControlador();

        // 2 - Conección y creación del Statement
        try(Connection conexion = jdbc.conectarConBaseDeDatos();
            PreparedStatement pstat = conexion.prepareStatement(query)){

            // 3 - Ejecución del Statement
            ResultSet rs = pstat.executeQuery();

            //  4- Proceso del ResultSet
            while(rs.next()){

                Odontologo odontologo = new Odontologo();

                odontologo.setId(rs.getLong("id"));
                odontologo.setMatricula(rs.getString("numero_matricula"));
                odontologo.setNombre(rs.getString("nombre"));
                odontologo.setApellido(rs.getString("apellido"));

                resultado.add(odontologo);
            }

            logger.info("Se consultaron todos los registros de la tabla Odontólogos");

        }catch (SQLException e){
            logger.error("Ha ocurrido un error en consultar los odontólogos" + e);
        }

        return resultado;

    }

    @Override
    public Odontologo crear(Odontologo odontologo){

        // 1 - Carga de controlador
        jdbc.cargarElControlador();

        // 2 - Conección y creación del Statement
        String query = "INSERT INTO odontologos VALUES(DEFAULT, ?,?,?)";

        try(Connection conexion = jdbc.conectarConBaseDeDatos();
            PreparedStatement pstat = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

            pstat.setString(1, odontologo.getMatricula());
            pstat.setString(2, odontologo.getNombre());
            pstat.setString(3, odontologo.getApellido());

            pstat.executeUpdate();

            ResultSet rs = pstat.getGeneratedKeys();
            if(rs.next()){
                odontologo.setId(rs.getLong("id"));
            }

            logger.info("Se creó exitosamente el registro del odontólogo: " + odontologo.getApellido()+ ". Matrícula Nº "+ odontologo.getMatricula());


        }catch (SQLException e){
            logger.error("Ha ocurrido un error al crear nuevo odontologo: "+ e);
        }

        return odontologo;
    }

    @Override
    public Odontologo consultarPorId(long id) {
        logger.debug("Buscando al odontologo con id = " + id);

        Odontologo resultado = null;
        String query = "SELECT * FROM odontologos where id = ?";

        // 1 - Carga de controlador
        jdbc.cargarElControlador();


        // 2 - Conección y creación del Statement
        try(Connection conexion = jdbc.conectarConBaseDeDatos();
            PreparedStatement pstat = conexion.prepareStatement(query)){

            pstat.setLong(1, id);

            // 3 - Ejecución del Statement
            ResultSet rs = pstat.executeQuery();

            //  4- Proceso del ResultSet
            //4 Obtener resultados
            while (rs.next()) {
                String matricula = rs.getString("numero_matricula");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");

                resultado = new Odontologo(id, nombre,apellido,matricula);
            }

            System.out.println("El odontólogo buscado es: "+ resultado);
            logger.info("Se hizo una consulta por el odontólogo con id: " + id);

        }catch (SQLException e){
            logger.error("Ha ocurrido un error en consultar el odontologo: "+ id);
        }

        return resultado;

    }

    @Override
    public Odontologo editar(Odontologo o) {

        String query = "UPDATE odontologos SET numero_matricula = ?, nombre = ?, apellido = ? WHERE id = ?";

        // 1 - Cargar el controlador
        jdbc.cargarElControlador();

        // 2 - Conectar y Crear el Statement
        try(Connection conexion = jdbc.conectarConBaseDeDatos();
            PreparedStatement pstat = conexion.prepareStatement(query)){

            pstat.setString(1, o.getMatricula());
            pstat.setString(2, o.getNombre());
            pstat.setString(3, o.getApellido());
            pstat.setLong(4, o.getId());

            // 3 - Ejecutar el statement

           pstat.executeUpdate();

           logger.info("Se editó al odontólogo: " + o.getApellido());

        }catch (SQLException e){
            logger.debug("Ha ocurrido un error al editar el odontologo: "+ o.getApellido());
        }

        return o;
    }

    @Override
    public void eliminar(long id) {

        String query = "DELETE FROM odontologos WHERE id = ?";

        // 1 - Cargar el controlador
        jdbc.cargarElControlador();

        // 2 - Conectar y Crear el Statement
        try(Connection conexion = jdbc.conectarConBaseDeDatos();
            PreparedStatement pstat = conexion.prepareStatement(query)){

            pstat.setLong(1, id);

            // 3 - Ejecutar el statement
            pstat.executeUpdate();

            logger.info("Se eliminó al odontólogo con id: " + id);

        }catch (SQLException e){
            logger.error("Ha ocurrido un error al intentar borrar el odontologo con id: "+ id + e);
        }

    }

}
