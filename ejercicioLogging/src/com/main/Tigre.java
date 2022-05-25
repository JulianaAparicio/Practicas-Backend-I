package com.main;

import org.apache.log4j.Logger;

public class Tigre {
    private String nombre;
    private int edad;

    private static final Logger logger = Logger.getLogger(Tigre.class);

    public Tigre(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public void correr(){
        logger.info("El Tigre "+ nombre + " está corriendo.");
    }

    public void esMayorA10(){
        try {
            if (edad > 10 && edad < 20){
                logger.info("Es mayor de 10 años.");
            }
            else if (edad >= 20){
                Exception e2 = new Exception();
                logger.error("La edad del Tigre " + nombre + " es incorrecta.",e2);
            }
            else if (edad < 0) {
                Exception e1 = new Exception();
                logger.error("La edad no puede ser negativa.",e1);
            }
            else {
                logger.info("La edad es menor o igual a 10 años.");
            }
        } catch (Exception e3){
                logger.error("Error en el programa.",e3);
        }
        logger.debug("Fin del programa con éxito.");
    }
}
