package com.example.clinicaOdontologica.persistence.dao;

import com.example.clinicaOdontologica.model.Domicilio;
import com.example.clinicaOdontologica.model.Paciente;

import com.example.clinicaOdontologica.persistence.util.ConfiguracionJDBC;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDao implements Dao<Paciente>{

    private ConfiguracionJDBC jdbc = new ConfiguracionJDBC();
    private Logger logger = Logger.getLogger(PacienteDao.class);
    private DomicilioDao domicilioDao = new DomicilioDao();



    // CONSULTAR TODOS LOS PACIENTES
    @Override
    public List<Paciente> consultarTodos() {
        logger.debug("Buscando todos los pacientes");
        // El resultado va a ser una lista de pacientes
        List<Paciente> resultado = new ArrayList<>();

        // 1 - Cargar el controlador
        jdbc.cargarElControlador();

        // 2 - Conectar y Crear el Statement
        try(Connection conexion = jdbc.conectarConBaseDeDatos();
            PreparedStatement pstat = conexion.prepareStatement("SELECT * FROM pacientes")){

            //pstat.setInt(1, id);

            // 3 - Ejecutar el statement
            ResultSet rs = pstat.executeQuery();

            //  4- Procesar el ResultSet
            while(rs.next()){

                Paciente paciente = new Paciente();

                paciente.setId(rs.getLong("id"));
                paciente.setApellido(rs.getString("apellido"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setDomicilio((Domicilio) rs.getObject("id_domicilio"));

                resultado.add(paciente);
                logger.info("Se consultaron todos los pacientes exitosamente");
            }
        }catch (SQLException e){
            logger.error("Ha ocurrido un error en consultar los pacientes" + e);
        }
        return resultado;

    }

    // GUARDAR REGISTRO DE PACIENTE
    @Override
    public Paciente crear(Paciente paciente) {

        //Como primer paso primero debemos guardar el domicilio del paciente
        //ya que necesitamos el ID del domicilio que se generará en la base de datos para luego
        //insertar ese id en el campo domicilio_id de la tabla pacientes

        Domicilio domicilio = domicilioDao.crear(paciente.getDomicilio());
        paciente.getDomicilio().setId(domicilio.getId());


            // 1 - Carga del controlador
            jdbc.cargarElControlador();

            // 2 - Conectar y Crear el Statement
            String query = "INSERT INTO pacientes(nombre,apellido,dni,fecha_ingreso,id_domicilio) VALUES(?,?,?,?,?)";
            try(Connection conexion = jdbc.conectarConBaseDeDatos();
                PreparedStatement pstat = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

                pstat.setString(1, paciente.getApellido());
                pstat.setString(2, paciente.getNombre());
                pstat.setString(3, paciente.getDni());

                //Hay que convertir el Date en sql.Date ya que son dos clases diferentes en Java
                pstat.setDate(4, Date.valueOf(paciente.getFechaDeIngreso()));

                //Tenemos que pasarle la clave foranea del ID del domicilio es decir el campo domicilio_id
                pstat.setLong(5,paciente.getDomicilio().getId());

                // 3 - Ejecutar una sentencia SQL y obtener los ID que se autogeneraron en la base de datos:
                pstat.executeUpdate();

                ResultSet rs = pstat.getGeneratedKeys();

                if(rs.next()){
                    paciente.setId(rs.getLong(1));
                }

                logger.info("Se creó exitosamente el registro del paciente: " + paciente.getApellido());

            }catch (SQLException e){
                logger.error("Ha ocurrido un error al crear nuevo paciente: "+ e);
            }
            return paciente;
    }

    // CONSULTAR PACIENTE POR ID
    @Override
    public Paciente consultarPorId(long id) {
        Paciente resultado = null;
        String query = "SELECT * FROM pacientes WHERE id = ?";

        // 1 - Cargar el controlador
        jdbc.cargarElControlador();

        // 2 - Conectar y Crear el Statement
        try(Connection conexion = jdbc.conectarConBaseDeDatos();
            PreparedStatement pstat = conexion.prepareStatement(query)){

            pstat.setLong(1, id);

            // 3 - Ejecutar el statement
            ResultSet rs = pstat.executeQuery();

            //  4- Procesar el ResultSet
            if(rs.next()){
                resultado = new Paciente();
                resultado.setId(rs.getLong("id"));
                resultado.setApellido(rs.getString("apellido"));
                resultado.setNombre(rs.getString("nombre"));
                resultado.setDomicilio((Domicilio) rs.getObject("id_domicilio"));
            }

            System.out.println("El paciente buscado es: "+ resultado.toString());
            logger.info("Se hizo una consulta por el paciente con id: " + id);

        }catch (SQLException e){
            logger.error("Ha ocurrido un error en consultar el paciente: "+ id);
        }
        return resultado;

    }

    // EDITAR REGISTRO DE PACIENTE POR ID
    @Override
    public Paciente editar(Paciente p) {

        Domicilio domicilio = domicilioDao.editar(p.getDomicilio());

        String query = "UPDATE pacientes SET nombre=?, apellido=?, dni=?, fecha_ingreso=?, domicilio_id=?  WHERE id = ?";

        // 1 - Cargar el controlador
        jdbc.cargarElControlador();

        // 2 - Conectar y Crear el Statement
        try(Connection conexion = jdbc.conectarConBaseDeDatos();
            PreparedStatement pstat = conexion.prepareStatement(query)){

            pstat.setString(1, p.getNombre());
            pstat.setString(2, p.getApellido());
            pstat.setString(3, p.getDni());
            pstat.setDate(4, Date.valueOf(p.getFechaDeIngreso()));
            pstat.setLong(5,p.getDomicilio().getId());
            pstat.setLong(6,p.getId());

            // 3 - Ejecutar el statement

            pstat.executeUpdate();

            logger.info("Se editó al paciente: " + p.getApellido());

        }catch (SQLException e){
            logger.debug("Ha ocurrido un error al editar el paciente: "+ p.getApellido());
        }
        return p;
    }

    // ELIMINAR REGISTRO DE PACIENTE POR ID
    @Override
    public void eliminar(long id) {

        String query = "DELETE * FROM pacientes WHERE id = ?";

        // 1 - Cargar el controlador
        jdbc.cargarElControlador();

        // 2 - Conectar y Crear el Statement
        try(Connection conexion = jdbc.conectarConBaseDeDatos();
            PreparedStatement pstat = conexion.prepareStatement(query)){

            pstat.setLong(1, id);

            // 3 - Ejecutar el statement
            ResultSet rs = pstat.executeQuery();

            logger.info("Se ha elinado al paciente con id: " + id);

        }catch (SQLException e){
            logger.error("Ha ocurrido un error al intentar borrar el paciente con id: "+ id);
        }
    }
}