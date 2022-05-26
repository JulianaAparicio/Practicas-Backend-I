package com.company;

/* CLASE 11 - BACKEND I (CERTIFIED TECH DEVELOPER)

Para practicar lo que vimos hasta ahora, te proponemos crear una aplicación para guardar en una base de datos
la clase Empleado. Con este objetivo, debemos agregar cuatro atributos a esta clase:

 Nombre, edad, empresa y fecha que empezó a trabajar.

 ¡Atención! No nos olvidemos que el ID es obligatorio.

¿Qué debemos hacer?

1- Crear la conexión a la base de datos.

2- Crear la tabla mediante un Statement.

3- Insertar 3 filas con nombre de la empresa: Digital, Google y Facebook.

4- Mostrar los datos en un ResultSet por System.out.println.

*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {

    public static void main(String[] args) throws Exception {

        // 1
        Class.forName("org.h2.Driver").newInstance();
        Connection connection = DriverManager.getConnection("jdbc:h2:"+
                "./Database/my", "root", "myPassword");
        Statement stmt = connection.createStatement();

        // 2

        String createTable = "DROP TABLE IF EXISTS EMPLOYEE; CREATE TABLE EMPLOYEE(ID INT PRIMARY KEY, NAME VARCHAR(255), AGE INT, COMPANY VARCHAR(255),DATE_OF_ENTRY DATE)";
        stmt.execute(createTable);

        // 3

        String insertRow1 = "INSERT INTO EMPLOYEE VALUES(1, 'MICAELA PERANDO', 32, 'DIGITAL', '2015-03-15')";
        String insertRow2 = "INSERT INTO EMPLOYEE VALUES(2, 'MAU', 36, 'GOOGLE', '2018-11-03')";
        String insertRow3 = "INSERT INTO EMPLOYEE VALUES(3, 'JULI', 31, 'FACEBOOK', '2022-05-25')";

        stmt.execute(insertRow1);
        stmt.execute(insertRow2);
        stmt.execute(insertRow3);

        // 4

        String sql = "SELECT * FROM EMPLOYEE";
        ResultSet rd = stmt.executeQuery(sql);
        while (rd.next()){
            System.out.println(rd.getInt(1) + rd.getString(2) + rd.getInt(3) + rd.getString(4) + rd.getDate(5));
        }
    }
}
