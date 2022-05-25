package com.main;
/*Te proponemos resolver la siguiente actividad: Crear una aplicación donde tengamos dos clases:
León y com.company.Tigre.

Cada una debe tener dos atributos:
        nombre String
        edad int

        y para la clase León vamos a agregar el atributo:
        esAlfa boolean

        Para los dos animales vamos a crear un método correr, que va a loguear un info de que está corriendo y
        vamos a crear otro método que calcule si es mayor a 10 años y ser alfa, en caso de serlo, deberá loguear
        un info con la información.
        También deberemos arrojar una Exception si la edad del animal es menor a cero y agregar un log de error.
        Creamos una clase main, donde creamos leones y tigres que cumplan que al correr y esMayorA10 ejecutan los
        métodos:

public void correr()
public void esMayorA10()

        También debemos chequear que los logs existan.*/

import org.apache.log4j.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Leon simba = new Leon("Simba",-2,true);
        simba.correr();
        simba.esMayorA10();
        Leon bom = new Leon("Bom",100000,false);
        bom.correr();
        bom.esMayorA10();
        Leon scar = new Leon("Scar",11,true);
        scar.esMayorA10();
        Leon mufasa = new Leon("Mufasa", 5,false);
        mufasa.esMayorA10();

        Tigre golden = new Tigre("Golden",15);
        golden.correr();
        golden.esMayorA10();
        Tigre ShereKhan = new Tigre("Shere Khan",-10);
        ShereKhan.esMayorA10();
        Tigre silver = new Tigre("Silver",50000000);
        silver.esMayorA10();
    }

}
