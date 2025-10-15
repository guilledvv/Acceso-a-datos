package repositorio;

import java.io.*;

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

    public void addDato(String dato) throws IOException {
        try (FileWriter fichero = new FileWriter(ruta, true)) {
            fichero.write(dato);
        } catch (IOException e) {
            System.out.println(" No se añadió.");
            throw e;
        }
    }

    private static void escribirFichero(String dato){
        FileWriter fichero = null;

        try{
            fichero= new FileWriter("datos/incidencias.txt", true);
            fichero.write(dato);
        }catch (IOException e){

        }
    }





}
