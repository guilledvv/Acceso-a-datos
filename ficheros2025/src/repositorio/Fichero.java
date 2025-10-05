package repositorio;

import modelo.Incidencia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Fichero {

    private String ruta;

    public Fichero(String ruta) {
        this.ruta = ruta;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    @Override
    public String toString() {
        return "Fichero{" +
                "ruta='" + ruta + '\'' +
                '}';
    }

    //metodos para todas las funcionalidades
    public String addDato(String dato){

        //añadir la linea al fichero
        return "";

    }
    //metodos para todas las funcionalidades
    public String buscarDato(String dato,int coulmna){

        return "";

    }
    //metodos para todas las funcionalidades
    public String buscarDato(LocalDate fechaInicial,LocalDate fechaFinal){

        FileReader fichero=null;
        BufferedReader lector=null;

        try {
            fichero = new FileReader("datos/incidnecia.txt");
            lector = new BufferedReader(fichero);
        }catch (FileNotFoundException e){
            System.out.println("No encuentro la ruta");
        }catch (IOException e){
            System.out.println("Error de lectura");
        }catch (Exception e){
            System.out.println("Error inesperado");
            e.printStackTrace();
        }


        return "";

    }

    //metodos para todas las funcionalidades
    public ArrayList<String> leerFichero(String dato){

        return null;
    }


}
