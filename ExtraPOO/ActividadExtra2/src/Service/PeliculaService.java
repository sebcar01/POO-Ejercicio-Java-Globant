package Service;

import Entidades.Pelicula;

import java.util.Scanner;

public class PeliculaService {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public void crearPelicula(Pelicula[] p, int cantidad){

        System.out.println("Ingresa el título");
        String titulo = sc.next();
        System.out.println("Ingresa el género");
        String genero = sc.next();
        System.out.println("Ingresa el año");
        int anio = sc.nextInt();
        System.out.println("Ingresa la duración");
        int duracion = sc.nextInt();

        for (int i = 0; i <= cantidad - 1; i++) {

            if(p[i] == null) {

                p[i] = new Pelicula(titulo, genero, anio, duracion, false);
                break;

            }

        }

    }

    public void listarPeliculasD(Pelicula[] p, int cantidad) {
        boolean verificacion = false;

        for (int i = 0; i <= cantidad - 1; i++) {

            if(p[i] == null) {

                continue;

            } else if (!p[i].isAlquiladaONo()) {

                System.out.println(p[i].getTitulo() + " está disponible.");
                verificacion = true;

            }

        }

        if (!verificacion) {

            System.out.println("No hay ninguna película disponible.");

        }

    }

    public void listarPeliculasA(Pelicula[] p, int cantidad) {
        boolean verificacion = false;

        for (int i = 0; i <= cantidad - 1; i++) {

            if(p[i] == null) {

                continue;

            } else if (p[i].isAlquiladaONo()) {

                System.out.println(p[i].getTitulo() + " está alquilada.");
                verificacion = true;

            }

        }

        if (!verificacion) {

            System.out.println("No hay ninguna película alquilada.");

        }

    }

    public void buscarTitulo(Pelicula[] arreglo, int cantidad) {
        boolean verificacion = false;

        System.out.println("Ingresa el nombre de la pelicula a buscar");
        String nombre = sc.next();

        for (int i = 0; i <= cantidad - 1; i++) {

            if (arreglo[i] == null) {

                continue;

            } else if (arreglo[i].getTitulo().equalsIgnoreCase(nombre)) {

                verificacion = true;

            }

        }

        System.out.println(verificacion ? "La película existe" : "La película no existe");

    }

    public void buscarGenero(Pelicula[] arreglo, int cantidad) {
        boolean verificacion = false;

        System.out.println("Ingresa el nombre del género");
        String nombre = sc.next();

        System.out.println("Películas del género " + nombre);

        for (int i = 0; i <= cantidad - 1; i++) {

            if (arreglo[i] == null) {

                continue;

            } else if (arreglo[i].getGenero().equalsIgnoreCase(nombre)) {

                System.out.println(arreglo[i].getTitulo());
                verificacion = true;

            }

        }

        if(!verificacion) {

            System.out.println("No existe ninguna película del género " + nombre);

        }

    }

}
