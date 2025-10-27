package vista;

import java.util.Scanner;

public class Escaner {

    private static final Scanner sc = new Scanner(System.in);

    // Pide un número entre 1 y 20
    public static int pedirInt(String mensaje) {
        System.out.print(mensaje + " ");
        int numero = sc.nextInt();
        sc.nextLine(); // limpiar el salto de línea
        return numero;
    }
}
