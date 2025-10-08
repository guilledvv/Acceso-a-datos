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
    public static ArrayList<String> buscarPorUsuario(String usuario, ArrayList<Incidencia> lista) {
        ArrayList<String> listaFiltradaPorUsuario = new ArrayList<>();
        for (Incidencia linea : lista) {
            if (linea.getUsuario().equalsIgnoreCase(usuario)) {
                listaFiltradaPorUsuario.add(linea.toString());
            }
        }
        return listaFiltradaPorUsuario;
    }

    public static ArrayList<String> buscarPorFecha(LocalDate fechaInicial, LocalDate fechaFinal, ArrayList<Incidencia> lista) {
        ArrayList<String> listaFiltradaPorFecha = new ArrayList<>();
        for (Incidencia linea : lista) {
            if ((linea.getFecha().isAfter(fechaInicial) || linea.getFecha().isEqual(fechaInicial)) &&
                    (linea.getFecha().isBefore(fechaFinal) || linea.getFecha().isEqual(fechaFinal))) {
                listaFiltradaPorFecha.add(linea.toString());
            }
        }
        return listaFiltradaPorFecha;
    }

    public static ArrayList<Incidencia> leerIncidencias() {
        ArrayList<Incidencia> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("datos/incidencias.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 4) {
                    LocalDate fecha = LocalDate.parse(partes[0]);
                    LocalTime hora = LocalTime.parse(partes[1]);
                    String excepcion = partes[2];
                    String usuario = partes[3];
                    Incidencia incidencia = new Incidencia(fecha, hora, excepcion, usuario);
                    lista.add(incidencia);
                }
            }
        } catch (Exception e) {
            System.out.println("Error leyendo incidencias: " + e.getMessage());
        }
        return lista;
    }

}
