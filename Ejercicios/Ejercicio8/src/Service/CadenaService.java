package Service;

import Entidades.Cadena;

import java.util.Scanner;

public class CadenaService {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    public Cadena crearCadena() {

        System.out.println("Ingresa la palabra o frase");
        String frase = sc.next();

        int longitud = frase.length();

        return new Cadena(frase, longitud);

    }

    public void mostrarVocales(Cadena c) {
        int conteo = 0;

        for (int i = 0; i <= c.getLongitud() - 1; i++) {

            if (c.getFrase().substring(i,i+1).equalsIgnoreCase("a") ||
                    c.getFrase().substring(i,i+1).equalsIgnoreCase("e") ||
                    c.getFrase().substring(i,i+1).equalsIgnoreCase("i") ||
                    c.getFrase().substring(i,i+1).equalsIgnoreCase("o") ||
                    c.getFrase().substring(i,i+1).equalsIgnoreCase("u")) {

                conteo += 1;

            }

        }

        System.out.println("Cantidad de vocales en tu palabra o frase: " + conteo);

    }

    public void invertirFrase(Cadena c) {
        String[] frase = new String[c.getLongitud()];
        String palabraInvertida = "";

        for (int i = 0; i <= c.getLongitud() - 1; i++) {

            frase[i] = c.getFrase().substring(i,i+1);

        }

        for (int i = c.getLongitud() - 1; i >= 0; i--) {

            palabraInvertida = palabraInvertida.concat(frase[i]);

        }

        System.out.println("Tu palabra o frase invertida es: " + palabraInvertida);

    }

    public void vecesRepetido(Cadena c) {
        int conteo = 0;
        String letra;

        do {

            System.out.println("Ingresa una sola letra");
            letra = sc.next();

        } while (letra.length() > 1);

        for (int i = 0; i <= c.getLongitud() - 1; i++) {

            if (c.getFrase().substring(i,i+1).equalsIgnoreCase(letra)) {

                conteo += 1;

            }

        }

        System.out.println(conteo == 1 ? letra + " se repite " + conteo + " vez."
                : letra + " se repite " + conteo + " veces.");

    }

    public void compararLongitud(Cadena c) {

        System.out.println("Ingresa una nueva palabra o frase");
        String frase = sc.next();

        System.out.println(frase.length() == c.getLongitud() ? "Las dos palabras o frases tienen la misma longitud, " + frase.length() + " caracteres."
                : "Las palabras o frases tienen una longitud diferente.");

    }

    public void unirFrases(Cadena c) {

        System.out.println("Ingresa una nueva palabra o frase");
        String frase = sc.next();

        frase = frase.concat(c.getFrase());

        System.out.println("La nueva frase es: " + frase);

    }

    public void reemplazar(Cadena c) {
        String[] frase = new String[c.getLongitud()];
        String nuevaPalabra = "";
        String letra;

        do {

            System.out.println("Ingresa una sola letra");
            letra = sc.next();

        } while (letra.length() > 1);

        for (int i = 0; i <= c.getLongitud() - 1; i++) {

            frase[i] = c.getFrase().substring(i,i+1);

            if (frase[i].equalsIgnoreCase("a")) {

                frase[i] = letra;

            }

            nuevaPalabra = nuevaPalabra.concat(frase[i]);

        }

        System.out.println("Tu nueva palabra o frase es: " + nuevaPalabra);

    }

    public void contiene(Cadena c) {
        String[] frase = new String[c.getLongitud()];
        String letra;
        boolean validacion = false;

        do {

            System.out.println("Ingresa una sola letra");
            letra = sc.next();

        } while (letra.length() > 1);

        for (int i = 0; i <= c.getLongitud() - 1; i++) {

            frase[i] = c.getFrase().substring(i,i+1);

            if (frase[i].equalsIgnoreCase(letra)) {

                validacion = true;

            }

        }

        System.out.println(validacion ? "La letra " + letra + " se encuentra dentro de la frase"
                : "La letra " + letra + " no se encuentra dentro de la frase");

    }

}
