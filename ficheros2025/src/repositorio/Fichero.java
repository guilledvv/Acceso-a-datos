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




   /* public String buscarDato(LocalDate fechaInicial, LocalDate fechaFinal) {
        try (BufferedReader lector = new BufferedReader(new FileReader(ruta))) {
            // Aquí puedes implementar la lógica de búsqueda por fecha si lo necesitas
        } catch (FileNotFoundException e) {
            System.out.println("No encuentro la ruta");
        } catch (Exception e) {
            System.out.println("Error inesperado");
        }
        return "";
    }*/


    


}
