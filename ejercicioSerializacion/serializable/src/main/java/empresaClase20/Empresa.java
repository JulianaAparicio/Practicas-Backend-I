package empresaClase20;

import java.io.*;
import java.util.ArrayList;

/*
Desafío 1
        Se desea persistir una empresa la cual tiene un CUIT y razón social junto con su listado de empleados
        en un archivo. Los empleados tienen un nombre, apellido, legajo y sueldo.
        Probar en el método main de instanciar una empresa con sus 4 empleados y persistir en un archivo a la
        empresa. Luego, recuperar del archivo la empresa, la cual deberá tener también sus 4 empleados.
*/

public class Empresa {

    private String cuit;
    private String razonSocial;
    private static ArrayList<Empleado> empresa;

    public static void main(String[] args) {

        Empleado e1 = new Empleado("Juan","Perez", "75022", 50000.0);
        Empleado e2 = new Empleado("Juan","Lopez", "750454", 60000.0);
        Empleado e3 = new Empleado("Juan","Diaz", "7545445", 70000.0);
        Empleado e4 = new Empleado("Juan","Rodriguez", "7544545", 80000.0);

        empresa.add(e1);
        empresa.add(e2);
        empresa.add(e3);
        empresa.add(e4);

        try{
            FileOutputStream fil = new FileOutputStream("empresa.dat");
            ObjectOutputStream archi = new ObjectOutputStream(fil);

            archi.writeObject(empresa);

            archi.close();

            FileInputStream filIn = new FileInputStream("empresa.dat");
            ObjectInputStream archiIn = new ObjectInputStream(filIn);

            ArrayList<Empleado> empresaLectura;

            empresaLectura = (ArrayList<Empleado>) archiIn.readObject();
            // Casteo porque requiere un ArrayList no un Objeto

            for (Empleado e: empresaLectura
                 ) {
                System.out.println(e);
            }

            archiIn.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
