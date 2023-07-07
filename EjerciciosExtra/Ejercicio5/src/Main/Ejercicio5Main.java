package Main;

import Entidades.Adivinar;
import Service.AdivinarService;

import java.util.Scanner;

public class Ejercicio5Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        AdivinarService as = new AdivinarService();
        Adivinar a = as.crearAdivinar();

        as.iniciarJuego(a);

    }



}
