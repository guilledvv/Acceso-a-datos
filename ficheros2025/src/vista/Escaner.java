package vista;

import java.util.Scanner;

public class Escaner {

    private static final Scanner sc = new Scanner(System.in);

    // Pide un texto al usuario
    public static String pedirString(String mensaje) {
        System.out.print(mensaje + " ");
        return sc.nextLine();
    }

    // Pide un número entero al usuario
    public static int pedirInt(String mensaje) {
        System.out.print(mensaje + " ");
        int numero = sc.nextInt();
        sc.nextLine(); // limpiar el salto de línea
        return numero;
    }
}
