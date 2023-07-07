package Main;

import Entidades.Raices;
import Service.RaicesService;

import java.util.Scanner;

public class Ejercicio3Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        RaicesService rs = new RaicesService();

        Raices r = rs.crearRaices();
        System.out.println("El discriminante es: " + rs.getDiscriminante(r));
        System.out.println("Tiene dos raices? - " + rs.tieneRaices(r));
        System.out.println("Tiene una raíz? - " + rs.tieneRaiz(r));
        rs.obtenerRaices(r);
        rs.obtenerRaiz(r);
        rs.calcular(r);

    }

}
