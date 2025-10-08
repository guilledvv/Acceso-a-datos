package servicio;

import modelo.Incidencia;
import modelo.ListaIncidencia;
import repositorio.Fichero;

import java.time.LocalDate;
import java.time.LocalTime;


//pasa a texo el objeto incidencia
public class ServicioFichero {

    //arreglar esto


    public static void guardarIncidencia(LocalDate fecha,LocalTime hora,String excepcion, String usuario){
        Incidencia miIncidencia=new Incidencia(fecha, hora,excepcion, usuario);
        Fichero archivo=new Fichero("datos/incidencia.txt");
        archivo.addDato(miIncidencia.toString());
    }
    //public static void leerIncidencia(LocalDate fecha,LocalTime hora,String excepcion, String usuario){
    //
    // }

   //public static void
}
