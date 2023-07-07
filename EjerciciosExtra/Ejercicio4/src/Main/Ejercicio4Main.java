package Main;

import Entidades.NIF;
import Service.NIFService;

import java.util.Scanner;

public class Ejercicio4Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        NIFService ns = new NIFService();

        NIF n = ns.crearNIF();
        ns.mostrar(n);

    }

}
