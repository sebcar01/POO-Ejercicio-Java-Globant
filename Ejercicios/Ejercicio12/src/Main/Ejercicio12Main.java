package Main;

import Entidades.Persona;
import Service.PersonaService;

import java.util.Scanner;

public class Ejercicio12Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        PersonaService ps = new PersonaService();
        Persona p = ps.crearPersona();
        int opcion;

        do {

            System.out.println("Escoge alguna de las siguientes opciones");
            System.out.println("1 - Calcular edad");
            System.out.println("2 - Menor que");
            System.out.println("3 - Mostrar persona");
            System.out.println("4 - Salir");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1 -> ps.calcularEdad(p);
                case 2 -> ps.menorQue(p);
                case 3 -> ps.mostrarPersona(p);
                case 4 -> System.out.println("Gracias por visitar el programa, chau!");
                default -> System.out.println("Opción inválida!");

            }

        } while (opcion != 4);

    }

}
