package Service;

import Entidades.Rectangulo;

import java.util.Scanner;

public class RectanguloService {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public Rectangulo crearRectangulo(){

        System.out.println("Ingresa la base");
        int base = sc.nextInt();
        System.out.println("Ingresa la altura");
        int altura = sc.nextInt();

        return new Rectangulo(base, altura);

    }

    public double area(Rectangulo re) {

        return (re.getBase() * re.getAltura());

    }

    public double perimetro(Rectangulo re) {

        return (re.getBase() + re.getAltura()) * 2;

    }

    public void dibujarRectangulo(Rectangulo re) {

        for (int i = re.getAltura(); i >= 1 ; i--) {

            for (int j = re.getBase(); j >= 1; j--) {

                if (i == re.getAltura() || i == 1) {

                    System.out.print("*");

                } else {

                    if (j == re.getBase() || j == 1) {

                        System.out.print("*");

                    } else {

                        System.out.print(" ");

                    }

                }

            }

            System.out.println();

        }

    }

}
