package repositorio;

import java.io.*;
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



    public static void addDato(String dato) throws IOException{
        FileWriter fichero = null;
        String incidencia;
        //añadir la linea al fichero

        try{
            fichero= new FileWriter("datos/incidencia.txt", true);
            fichero.write(dato);
        }catch (IOException e){
            System.out.println(" No se añadio.");
        }finally {
            fichero.close();
        }



        }




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


    public ArrayList<String> leerFichero(String dato){

        return null;
    }


}
