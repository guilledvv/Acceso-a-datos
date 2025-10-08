package servicio;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import repositorio.Fichero;


//pasa a texo el objeto incidencia
public class ServicioFichero {

    //arreglar esto


    public static void guardarIncidencia(LocalDate fecha, LocalTime hora, String excepcion, String usuario) {
    String linea = fecha + ";" + hora + ";" + excepcion + ";" + usuario + System.lineSeparator();
    try {
        Fichero fichero = new Fichero("datos/incidencias.txt"); // Crea una instancia con la ruta correcta
        fichero.addDato(linea); // Llama al metodo de instancia
    } catch (IOException e) {
        System.out.println("Error al guardar la incidencia: " + e.getMessage());
    }
}
    
    public static void leerIncidencia(LocalDate fecha, LocalTime hora, String excepcion, String usuario) {
        
    
    }

   //public static void
}
