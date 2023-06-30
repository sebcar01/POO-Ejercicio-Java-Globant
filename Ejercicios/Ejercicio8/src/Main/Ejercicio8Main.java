package Main;

import Entidades.Cadena;
import Service.CadenaService;

import java.util.Scanner;

public class Ejercicio8Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        CadenaService cs = new CadenaService();
        Cadena cd = cs.crearCadena();
        int opcion;

        do {

            System.out.println("Escoge alguna de las siguientes opciones");
            System.out.println("1 - Mostrar vocales");
            System.out.println("2 - Invertir frase");
            System.out.println("3 - Veces repetido");
            System.out.println("4 - Comparar longitud");
            System.out.println("5 - Unir frases");
            System.out.println("6 - Reemplazar");
            System.out.println("7 - Contiene");
            System.out.println("8 - Salir");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1 -> cs.mostrarVocales(cd);
                case 2 -> cs.invertirFrase(cd);
                case 3 -> cs.vecesRepetido(cd);
                case 4 -> cs.compararLongitud(cd);
                case 5 -> cs.unirFrases(cd);
                case 6 -> cs.reemplazar(cd);
                case 7 -> cs.contiene(cd);
                case 8 -> System.out.println("Gracias por visitar el programa, chau!");
                default -> System.out.println("Opción inválida!");

            }

        } while (opcion != 8);

    }

}
