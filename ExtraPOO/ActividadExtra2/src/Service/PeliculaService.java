package Service;

import Entidades.Pelicula;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PeliculaService {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public void crearPelicula(Pelicula[] p, int cantidad){
        int anio = 0;
        String verificacion = "";
        String genero = "";
        int opcionGenero = 0;
        int duracion = 0;
        boolean excepcion = false;
        LocalDate fh = LocalDate.now();

        System.out.println("Ingresa el título");
        String titulo = sc.next();

        do {

            do {

                try {

                    System.out.println("Selecciona el género");
                    System.out.println("1 - Acción");
                    System.out.println("2 - Aventura");
                    System.out.println("3 - Ciencia Ficción");
                    System.out.println("4 - Comedia");
                    System.out.println("5 - Drama");
                    System.out.println("6 - Documental");
                    System.out.println("7 - Fantasía");
                    System.out.println("8 - Musical");
                    System.out.println("9 - Terror");
                    System.out.println("10 - Familiar");
                    System.out.println("11 - Otro");
                    opcionGenero = sc.nextInt();
                    excepcion = false;

                } catch (InputMismatchException e) {

                    sc.next();
                    excepcion = true;
                    System.out.println("Solo puedes ingresar números!");

                }

            } while (excepcion);

            switch (opcionGenero) {

                case 1 -> genero = "Accion";
                case 2 -> genero = "Aventura";
                case 3 -> genero = "Ciencia Ficcion";
                case 4 -> genero = "Comedia";
                case 5 -> genero = "Drama";
                case 6 -> genero = "Documental";
                case 7 -> genero = "Fantasia";
                case 8 -> genero = "Musical";
                case 9 -> genero = "Terror";
                case 10 -> genero = "Familiar";
                case 11 -> genero = "Otro";
                default -> System.out.println("Opción inválida!");

            }

        } while (opcionGenero < 1 || opcionGenero > 11);

        do {

            do {

                try {

                    System.out.println("Ingresa el año. Tiene que ser de 4 dígitos. No puede estar en el futuro.");
                    anio = sc.nextInt();
                    verificacion = String.valueOf(anio);
                    excepcion = false;

                } catch (InputMismatchException e) {

                    sc.next();
                    excepcion = true;
                    System.out.println("Solo puedes ingresar números!");

                }

            } while (excepcion);

        } while (verificacion.length() != 4 || anio < 1895 || anio > fh.getYear() );

        do {

            do {

                try {

                    System.out.println("Ingresa la duración en horas. Máximo dos dígitos.");
                    duracion = sc.nextInt();
                    verificacion = String.valueOf(duracion);
                    excepcion = false;

                } catch (InputMismatchException e) {

                    sc.next();
                    excepcion = true;
                    System.out.println("Solo puedes ingresar números!");

                }

            } while (excepcion);

        } while (verificacion.length() > 2 || duracion < 1);

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

            System.out.println("No hay ninguna película disponible para alquilar.");

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
        String genero = "";
        int opcionGenero = 0;
        boolean excepcion = false;

        do {

            do {

                try {

                    System.out.println("Selecciona el género");
                    System.out.println("1 - Acción");
                    System.out.println("2 - Aventura");
                    System.out.println("3 - Ciencia Ficción");
                    System.out.println("4 - Comedia");
                    System.out.println("5 - Drama");
                    System.out.println("6 - Documental");
                    System.out.println("7 - Fantasía");
                    System.out.println("8 - Musical");
                    System.out.println("9 - Terror");
                    System.out.println("10 - Familiar");
                    System.out.println("11 - Otro");
                    opcionGenero = sc.nextInt();
                    excepcion = false;

                } catch (InputMismatchException e) {

                    sc.next();
                    excepcion = true;
                    System.out.println("Solo puedes ingresar números!");

                }

            } while (excepcion);

            switch (opcionGenero) {

                case 1 -> genero = "Accion";
                case 2 -> genero = "Aventura";
                case 3 -> genero = "Ciencia Ficcion";
                case 4 -> genero = "Comedia";
                case 5 -> genero = "Drama";
                case 6 -> genero = "Documental";
                case 7 -> genero = "Fantasia";
                case 8 -> genero = "Musical";
                case 9 -> genero = "Terror";
                case 10 -> genero = "Familiar";
                case 11 -> genero = "Otro";
                default -> System.out.println("Opción inválida!");

            }

        } while (opcionGenero < 1 || opcionGenero > 11);

        System.out.println("Películas del género " + genero);

        for (int i = 0; i <= cantidad - 1; i++) {

            if (arreglo[i] == null) {

                continue;

            } else if (arreglo[i].getGenero().equalsIgnoreCase(genero)) {

                System.out.println(arreglo[i].getTitulo());

            }

        }

    }

}
