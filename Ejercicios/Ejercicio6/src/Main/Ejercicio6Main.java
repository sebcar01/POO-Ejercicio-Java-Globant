package Main;

import Entidades.Cafetera;
import Service.CafeteraService;

import java.util.Scanner;

public class Ejercicio6Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        CafeteraService cs = new CafeteraService();

        Cafetera cf = cs.crearCafetera();

        int opcion;

        do {

            System.out.println("Elige una de las siguientes opciones");
            System.out.println("1 - Llenar cafetera");
            System.out.println("2 - Servir taza");
            System.out.println("3 - Vaciar cafetera");
            System.out.println("4 - Agregar café");
            System.out.println("5 - Consultar cantidad actual");
            System.out.println("6 - Salir");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1 -> cs.llenarCafetera(cf);
                case 2 -> cs.servirTaza(cf);
                case 3 -> cs.vaciarCafetera(cf);
                case 4 -> cs.agregarCafe(cf);
                case 5 -> System.out.println("La cantidad actual de café es: " + cs.consultarCantidadActual(cf));
                case 6 -> System.out.println("Gracias por visitar el programa, chau!");
                default -> System.out.println("Opción inválida!");

            }

        } while (opcion != 6);

    }

}
