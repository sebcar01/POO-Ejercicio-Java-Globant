package Main;

import Entidad.Movil;
import Service.MovilService;

import java.util.Scanner;

public class Ejercicio14Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        MovilService ms = new MovilService();
        Movil m = ms.cargarCelular();

    }

}
