package com.main;

import org.apache.log4j.Logger;

public class Leon {
    private String nombre;
    private int edad;
    private boolean esAlfa;

    private static final Logger logger = Logger.getLogger(Leon.class);

    public Leon(String nombre, int edad, boolean esAlfa) {
        this.nombre = nombre;
        this.edad = edad;
        this.esAlfa = esAlfa;
    }

    public void correr(){
        logger.info("El León " + nombre + " está corriendo.");
    }

    public void esMayorA10(){
        try {
            if (edad > 10 && esAlfa && edad < 25){
                logger.info("Es mayor de 10 años y es Alfa");
            }
            else if(edad > 10 && edad < 25) {
                logger.info("Es mayor de 10 años pero no es Alfa.");
            }
            else if (edad < 0){
                Exception e1 = new Exception();
                logger.error("La edad no puede ser negativa.",e1);
            }
            else if (edad >= 25){
                Exception e2 = new Exception();
                logger.error("La edad del León " + nombre + " es incorrecta.",e2);
            }
            else if(esAlfa){
                logger.info("La edad es menor o igual 10 años y es Alfa.");
            }
            else {
                logger.info("La edad es menor o igual 10 años y no es Alfa.");
            }
        }
        catch (Exception e3){
            logger.error("Error en el programa.",e3);
        }
        logger.debug("Fin del programa con éxito.");
    }


}
