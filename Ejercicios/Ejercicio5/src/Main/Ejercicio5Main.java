package Main;

import Entidades.Cuenta;
import Service.CuentaService;

import java.util.Scanner;

public class Ejercicio5Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        CuentaService cs = new CuentaService();
        Cuenta c = cs.crearCuenta();
        int opcion;

        do {

            System.out.println("Escoge alguna de las siguientes opciones");
            System.out.println("1 - Ingresar dinero");
            System.out.println("2 - Retirar dinero");
            System.out.println("3 - Extracción rápida");
            System.out.println("4 - Consultar Saldo");
            System.out.println("5 - Consultar datos");
            System.out.println("6 - Salir");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1 -> cs.ingresar(c);
                case 2 -> cs.retirar(c);
                case 3 -> cs.extraccionRapida(c);
                case 4 -> System.out.println("Tu saldo actual es de $: " + cs.consultarSaldo(c));
                case 5 -> cs.consultarDatos(c);
                case 6 -> System.out.println("Gracias por visitar el programa, chau!");
                default -> System.out.println("Opción inválida!");

            }

        } while (opcion != 6);

    }

}
