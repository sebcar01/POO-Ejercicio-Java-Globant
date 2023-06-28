package Main;

import Entidades.Rectangulo;
import Service.RectanguloService;

public class Ejercicio4Main {

    public static void main(String[] args) {

        RectanguloService rs = new RectanguloService();
        Rectangulo rect = rs.crearRectangulo();

        System.out.println("El área del rectángulo es: " + rs.area(rect));
        System.out.println("El perímetro del rectángulo es: " + rs.perimetro(rect));

        System.out.println();

        rs.dibujarRectangulo(rect);

    }

}
