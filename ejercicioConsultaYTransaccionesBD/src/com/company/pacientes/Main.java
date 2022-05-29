package com.company.pacientes;

/*
¡Vamos a practicar!
        Luego de recorrer el contenido de la clase de hoy, llegó tu turno de poner en práctica lo visto.
        Tenemos que crear una entidad que se llame Pacientes en la base de datos H2 que tenga los siguientes
        campos: nombre, apellido, domicilio, DNI, fecha de alta, usuario y password.

        ¿Qué debés hacer?

        1- Crear una connection a la base de datos e insertar una fila paciente.

        2- Luego, abrir una transacción (setAutocommit(false)) y asignar otro password con una sentencia update y,
        paso siguiente, generar una excepción (throw new Exception).

        3- Por último, corroborar con una consulta que el paciente existe y que el campo password mantuvo su valor
        inicial del punto 1.
*/

import com.company.model.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;

public class Main {

    public static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {

        Paciente paciente1 = new Paciente("Juliana","Aparicio", "Calle falsa 123",
                35821141, "2022-5-29", "juliAparicio", "123456");

        // Información para la conexión a la base de datos:

        String URL = "jdbc:h2:~/test";
        String USER = "sa";
        String PASS = "";

        // Cargamos el controlador:

        try {
            Class.forName("org.h2.Driver").newInstance();;
        }
        catch(ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            logger.error("Error: no se pudo cargar el controlador!");
            System.exit(1);
        }

        final String SQL_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS PACIENTE (dni INT PRIMARY KEY, nombre VARCHAR(255), apellido VARCHAR(255), domicilio VARCHAR(255), fechaDeAlta DATE, usuario VARCHAR (15), contrasenia VARCHAR(10))";
        final String SQL_INSERT = "INSERT INTO PACIENTE VALUES(dni, nombre, apellido, domicilio, fechaDeAlta, usuario, contrasenia) VALUES (?, ?, ?, ?, ?, ?, ?)";
        final String SQL_UPDATE = "UPDATE PACIENTE SET contrasenia=? WHERE dni=?";

        // Establecemos la conexión a la Base de Datos, creamos la tabla e insertamos una fila:

        Statement stmt = null;

        try (Connection connection = DriverManager.getConnection(URL, USER, PASS)){
            stmt = connection.createStatement();

            logger.info("Creando tabla en la base de datos...");
            stmt.execute(SQL_TABLE_CREATE);

            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);

            // Insertamos el paciente 1:

            psInsert.setInt(1,paciente1.getDNI());
            psInsert.setString(2, paciente1.getNombre());
            psInsert.setString(3, paciente1.getApellido());
            psInsert.setString(4, paciente1.getDomicilio());
            psInsert.setString(5, paciente1.getFechaDeAlta());
            psInsert.setString(6, paciente1.getUsuario());
            psInsert.setString(7, paciente1.getContrasenia());

            psInsert.execute();

            // Hacemos la transacción:

            connection.setAutoCommit(false);

           // Update de contrasenia (generamos la excepción):

            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);

            psUpdate.setString(1,paciente1.cambiarContrasenia("Juliana654321"));
            psUpdate.setInt(2,paciente1.getDNI());

            psUpdate.execute();

            connection.commit();

            connection.setAutoCommit(true);

            // Comprobamos que la contrasenia siga igual a la de antes:

            String queryDePrueba = "SELECT * FROM PACIENTE";
            Statement statement = connection.createStatement();
            ResultSet rd = statement.executeQuery(queryDePrueba);
            while(rd.next()){
                logger.info(rd.getInt(1) + rd.getString(2) + rd.getString(3) +
                        rd.getString(4) + rd.getString(5) + rd.getString(6) +
                        rd.getString(7));
            }
        } catch (SQLException ex){
            logger.error(ex.getMessage());
            logger.info("Se hará un rollback de la información...");
        }
    }
}
