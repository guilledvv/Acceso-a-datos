package servicio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import modelo.Incidencia;
import repositorio.Fichero;


//pasa a texo el objeto incidencia
public class ServicioFichero {

    //Guarda la incidencia en el archivo incidencias.txt en formato: fecha;hora;excepcion;usuario
    public static void guardarIncidencia(LocalDate fecha, LocalTime hora, String excepcion, String usuario) {
        //crea una linea con los datos separados con  = ;
        String linea = fecha + ";" + hora + ";" + excepcion + ";" + usuario + System.lineSeparator();
        try {
            Fichero fichero = new Fichero("datos/incidencias.txt"); // Crea una instancia con la ruta correcta
            fichero.addDato(linea); // Llama al metodo de instancia
        } catch (IOException e) {
            //muestra el mensaje en caso de error de escritura
            System.out.println("Error al guardar la incidencia: " + e.getMessage());
        }
    }

    public static ArrayList<String> buscarPorUsuario(String usuario, ArrayList<Incidencia> lista) {//filtra las incidencia q so de un usuario
        ArrayList<String> listaFiltradaPorUsuario = new ArrayList<>();
        for (Incidencia linea : lista) {//recorre la listaa de incidencias
            //si el usuario coincide mete la incidencia a la lista
            if (linea.getUsuario().equalsIgnoreCase(usuario)) {
                listaFiltradaPorUsuario.add(linea.toString());
            }
        }
        return listaFiltradaPorUsuario;
    }

    public static ArrayList<String> buscarPorFecha(LocalDate fechaInicial, LocalDate fechaFinal, ArrayList<Incidencia> lista) {
        //crea una lista vacia que se almacena la incidencia que cumple el criterio de fechas
        ArrayList<String> listaFiltradaPorFecha = new ArrayList<>();
        //Recorre los Obejtos Incidencia  de l lista
        for (Incidencia linea : lista) {
            //Compruebo si la fecha esta dentro del rango "incluido"
            if ((linea.getFecha().isAfter(fechaInicial) || linea.getFecha().isEqual(fechaInicial)) &&
                    (linea.getFecha().isBefore(fechaFinal) || linea.getFecha().isEqual(fechaFinal))) {
                //si se cumple pasa la incidencia a String con el toStrng y la añade a la lista
                listaFiltradaPorFecha.add(linea.toString());
            }
        }
        return listaFiltradaPorFecha;
    }


    public static ArrayList<Incidencia> leerIncidencias() {
        //leo las incidencias guardadas y las hago objeto de tipo INcidencia
        ArrayList<Incidencia> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("datos/incidencias.txt"))) {
            String linea;
            //lee linea x linea
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");// separamos por = ;
                //aqui compruebo q la linea tiene 4 apartados
                if (partes.length == 4) {
                    LocalDate fecha = LocalDate.parse(partes[0]);
                    LocalTime hora = LocalTime.parse(partes[1]);
                    String excepcion = partes[2];
                    String usuario = partes[3];

                    
                    Incidencia incidencia = new Incidencia(fecha, hora, excepcion, usuario);//creo nueva incidencai con los datos
                    lista.add(incidencia);//agrego la incidencia a la lista
                }
            }
        } catch (Exception e) {
            //aqi capturo los errores de lectura o parseo
            System.out.println("Error leyendo incidencias: " + e.getMessage());
        }
        return lista;
    }

}
