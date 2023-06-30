package Main;

import Entidades.Matematica;
import Service.MatematicaService;

import java.util.Scanner;

public class Ejercicio9Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        MatematicaService ms = new MatematicaService();
        Matematica mt = ms.crearMatematica();

        int opcion;

        do {

            System.out.println("Escoge alguna de las siguientes opciones");
            System.out.println("1 - Devolver mayor");
            System.out.println("2 - Calcular potencia");
            System.out.println("3 - Calcular raíz");
            System.out.println("4 - Salir");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1 -> ms.devolverMayor(mt);
                case 2 -> ms.calcularPotencia(mt);
                case 3 -> ms.calcularRaiz(mt);
                case 4 -> System.out.println("Gracias por visitar el programa, chau!");
                default -> System.out.println("Opción inválida!");

            }

        } while (opcion != 4);

    }

}
