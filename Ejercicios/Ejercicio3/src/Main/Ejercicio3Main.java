package Main;

import Entidades.Operacion;
import Service.OperacionService;

import java.util.Scanner;

public class Ejercicio3Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        OperacionService OpsSvs = new OperacionService();
        Operacion op = OpsSvs.crearOperacion();

        System.out.println("Escoge alguna de las siguientes opciones");
        System.out.println("1 - Suma");
        System.out.println("2 - Resta");
        System.out.println("3 - Multiplicación");
        System.out.println("4 - División");
        int opcion = sc.nextInt();

        switch (opcion) {

            case 1 -> System.out.println("El resultado de la suma es " + OpsSvs.sumar(op));
            case 2 -> System.out.println("El resultado de la resta es " + OpsSvs.restar(op));
            case 3 -> System.out.println(OpsSvs.multiplicar(op) == 0 ? "Uno de los números es 0, por lo tanto el resultado es 0" : "El resultado de la multiplicación es: " + OpsSvs.multiplicar(op));
            case 4 -> System.out.println(OpsSvs.dividir(op) == 0 ? "Uno de los números es 0, por lo tanto el resultado es 0" : "El resultado de la división es: " + OpsSvs.dividir(op));
            default -> System.out.println("Opción inválida, chau!");

        }

    }

}
