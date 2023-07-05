package Main;

import Entidades.Alquiler;
import Entidades.Pelicula;
import Service.AlquilerService;
import Service.PeliculaService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Ingresa la cantidad de películas que planeas ingresar");
        int cantidad = sc.nextInt();

        Pelicula[] arregloP = new Pelicula[cantidad];
        Alquiler[] arregloA = new Alquiler[cantidad];

        PeliculaService ps = new PeliculaService();
        AlquilerService as = new AlquilerService();

        int opcion;

        do {

            System.out.println("Escoge alguna de las siguientes opciones");
            System.out.println("1 - Ingresar película");
            System.out.println("2 - Crear alquiler");
            System.out.println("3 - Listar peliculas disponibles");
            System.out.println("4 - Listar peliculas alquiladas");
            System.out.println("5 - Buscar por titulo");
            System.out.println("6 - Buscar por genero");
            System.out.println("7 - Buscar alquiler por fecha");
            System.out.println("8 - Devolver película y calcular el ingreso");
            System.out.println("9 - Salir");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1 -> ps.crearPelicula(arregloP, cantidad);
                case 2 -> as.crearAlquiler(arregloP, arregloA, cantidad);
                case 3 -> ps.listarPeliculasD(arregloP, cantidad);
                case 4 -> ps.listarPeliculasA(arregloP, cantidad);
                case 5 -> ps.buscarTitulo(arregloP, cantidad);
                case 6 -> ps.buscarGenero(arregloP, cantidad);
                case 7 -> as.buscarAlquiler(arregloA, arregloP, cantidad);
                case 8 -> as.calcularIngreso(arregloP, arregloA, cantidad);
                case 9 -> System.out.println("Gracias por visitar el programa, chau!");
                default -> System.out.println("Opción inválida!");

            }

        } while (opcion != 9);

    }

}