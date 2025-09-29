import controlador.ControladorIncidencias;
import modelo.Incidencia;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ControladorIncidencias.iniciar();
        //generar un metodo para cualquier excepcion
        //en el switch try and catch con la funcion de generar la exception y la excepcion q se genere la meta al fichero

       /*String cadena="2025-08-18;16:01:44;excepción test 3;usuario1";
        String[] datos=cadena.split( ";");
        datos=cadena.split(";");

        System.out.println(Arrays.toString(datos));
        */
    }
}