package Main;

import Entidades.Puntos;
import Service.PuntosService;

import java.util.Scanner;

public class Ejercicio2Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        PuntosService ps = new PuntosService();

        Puntos p = ps.crearPuntos();

        System.out.println("La distancia entre las coordenadas ingresadas es: " + ps.calcularDistancia(p));

    }

}
