package vista;

import java.util.Scanner;

public class Escaner {
    private static Scanner sc = new Scanner(System.in);

    // Pedir String
    public static String pedirString(String pregunta) {
        Consola.mostrarString(pregunta);
        return sc.nextLine();
    }

    // Pedir int
    public static int pedirInt(String pregunta) {
        Consola.mostrarString(pregunta);
        return Integer.parseInt(sc.nextLine());
    }
}
