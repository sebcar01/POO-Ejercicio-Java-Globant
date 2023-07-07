package Service;

import Entidades.Puntos;

import java.util.Scanner;

public class PuntosService {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public Puntos crearPuntos(){

        System.out.println("Ingresa el valor de x1");
        double x1 = sc.nextDouble();
        System.out.println("Ingresa el valor de x2");
        double x2 = sc.nextDouble();
        System.out.println("Ingresa el valor de y1");
        double y1 = sc.nextDouble();
        System.out.println("Ingresa el valor de y2");
        double y2 = sc.nextDouble();

        return new Puntos(x1, x2, y1, y2);

    }

    public double calcularDistancia(Puntos p) {

        return Math.sqrt( Math.pow( (p.getX2() - p.getX1()), 2 ) + Math.pow( (p.getY2() - p.getY1()), 2 ) );

    }

}
