package servicio;

import modelo.Incidencia;
import modelo.ListaIncidencia;
import repositorio.Fichero;

import java.time.LocalDate;
import java.time.LocalTime;

public class ServicioFichero {

    //arreglar todo esto

    public static void guardar(String excepcion, String usuario, LocalDate fecha,LocalTime hora){

        Incidencia miIncidencia=new Incidencia(fecha, hora, usuario, excepcion);
        Fichero archivo=new Fichero("datos/incidencia.txt");
        archivo.addDato(miIncidencia.toString());
    }


    public static void guardar(Incidencia miIncidencia){
        Fichero archivo=new Fichero("datos/incidencia.txt");
        archivo.addDato(archivo.toString());

    }
}
