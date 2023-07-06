package Main;

import Service.AhorcadoService;

import java.util.Scanner;

public class Ejercicio6Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        AhorcadoService as = new AhorcadoService();

        as.juego();

    }

}
