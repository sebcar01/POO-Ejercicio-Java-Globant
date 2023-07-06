package Service;

import Entidades.Ahorcado;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AhorcadoService {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    public Ahorcado crearJuego(){

        System.out.println("Ingresa la palabra a adivinar");
        String palabra = sc.next();

        System.out.println("Ingresa la cantidad de intentos máximos");
        int intentos = sc.nextInt();

        String[] arreglo = new String[palabra.length()];

        for (int i = 0; i <= palabra.length() - 1; i++) {

            arreglo[i] = palabra.substring(i, i + 1);

        }

        System.out.println("Juego creado!");
        return new Ahorcado(arreglo, 0, palabra.length(), intentos);

    }

    public void longitud(Ahorcado a) {

        System.out.println("La longitud de la palabra es: " + a.getPalabraABuscar().length);

    }

    public void buscar(Ahorcado a) {
        int encontradas = 0;
        System.out.println("Ingresa una letra a buscar");
        String letra = sc.next();

        for (int i = 0; i <= a.getPalabraABuscar().length - 1; i++) {

            if (letra.equalsIgnoreCase(a.getPalabraABuscar()[i])) {

                encontradas += 1;

            }

        }

        System.out.println(encontradas > 0 ? "La letra pertenece a la palabra" : "La letra no pertenece a la palabra");

    }

    public boolean encontradas(Ahorcado a) {
        int encontradas = 0;
        System.out.println("Ingresa una letra a buscar");
        String letra = sc.next();

        for (int i = 0; i <= a.getPalabraABuscar().length - 1; i++) {

            if (letra.equalsIgnoreCase(a.getPalabraABuscar()[i])) {

                a.setEncontradas(a.getEncontradas() + 1);
                encontradas += 1;

            }

        }

        boolean estaONo = encontradas > 0;

        if (!estaONo) {

            a.setIntentos(a.getIntentos() - 1);

        } else {

            a.setFaltantes(a.getFaltantes() - encontradas);

        }

        System.out.println(encontradas > 0 ? "Letra encontrada!" : "Letra no encontrada :(");
        System.out.println("Número de letras (encontradas, faltantes): " + a.getEncontradas() + ", " + a.getFaltantes());

        if (a.getIntentos() == 0) {

            System.out.println("No te quedan oportunidades, chau!");
            return false;

        } else if (a.getIntentos() > 0 && a.getEncontradas() == a.getPalabraABuscar().length) {

            System.out.println("Encontraste la palabra! Felicidades!");
            return false;

        } else {

            System.out.println("Número de oportunidades restantes: " + a.getIntentos());
            return true;

        }

    }

    public void intentos(Ahorcado a) {

        System.out.println("Número de oportunidades restantes: " + a.getIntentos());

    }

    public void juego() {
        boolean verificacion = true;
        int opcion;
        Ahorcado a = crearJuego();

        do {

            try {

                System.out.println("Ingresa una de las siguientes opciones");
                System.out.println("1 - Verificar longitud de la palabra");
                System.out.println("2 - Buscar letra");
                System.out.println("3 - Encontrar letra");
                System.out.println("4 - Intentos restantes");
                opcion = sc.nextInt();

                switch (opcion) {

                    case 1 -> longitud(a);
                    case 2 -> buscar(a);
                    case 3 -> verificacion = encontradas(a);
                    case 4 -> intentos(a);

                }

            } catch (InputMismatchException e) {

                sc.next();
                System.out.println("Solo se permiten números!");

            }

        } while (verificacion);

    }

}
