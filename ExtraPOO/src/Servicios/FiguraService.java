package Servicios;

import Entidad.Figura;

import java.util.Scanner;

public class FiguraService {

    Scanner sc = new Scanner(System.in);

    public Figura crearFigura() {

        Figura fig1 = new Figura();
        System.out.println("Ingresa el tipo de figura");
        fig1.setTipo(sc.nextLine());
        return fig1;

    }

    public void cuadrado(){

        System.out.println("Ingresa el tamaño del lado");
        int lado = sc.nextInt();
        System.out.println("El area del cuadrado es:" + (lado * lado));
        System.out.println("El perimetro del cuadrado es:" + (lado * 4));

    }

    public void rectangulo(){

        System.out.println("Ingresa la altura");
        int altura = sc.nextInt();
        System.out.println("Ingresa la base");
        int base = sc.nextInt();
        System.out.println("El area del rectangulo es:" + (base * altura));
        System.out.println("El perimetro del rectangulo es:" + (base + altura) * 2);

    }

    public void triangulo(){

        System.out.println("Ingresa el tamaño del lado 1");
        int lado1 = sc.nextInt();
        System.out.println("Ingresa el tamaño del lado 2");
        int lado2 = sc.nextInt();
        System.out.println("Ingresa el tamaño del lado 3");
        int lado3 = sc.nextInt();
        System.out.println("Ingresa la altura");
        int altura = sc.nextInt();
        System.out.println("El area del triangulo es:" + (lado1 * altura) / 2);
        System.out.println("El perimetro del triangulo es:" + (lado1 + lado2 + lado3));

    }

    public void circulo(){

        System.out.println("Ingresa el radio");
        int radio = sc.nextInt();
        System.out.println("El area del circulo es:" + (Math.pow(radio * Math.PI, 2)));
        System.out.println("El perimetro del circulo es:" + (2 * Math.PI * radio));

    }

    public void hexagono(){

        System.out.println("Ingresa el tamaño de los lados");
        int lados = sc.nextInt();
        System.out.println("Ingresa el apotema");
        int apotema = sc.nextInt();
        double perimetro = lados * 6;
        System.out.println("El area del hexagono es:" + ((perimetro * apotema)/ 2));
        System.out.println("El perimetro del hexagono es:" + perimetro);

    }

    public void pentagono(){

        System.out.println("Ingresa el tamaño de los lados");
        int lados = sc.nextInt();
        System.out.println("Ingresa el apotema");
        int apotema = sc.nextInt();
        double perimetro = lados * 5;
        System.out.println("El area del pentagono es:" + ((perimetro * apotema) / 2));
        System.out.println("El perimetro del pentagono es:" + perimetro);

    }

    public void rombo(){

        System.out.println("Ingresa el tamaño de los lados");
        int lados = sc.nextInt();
        System.out.println("Ingresa el tamaño de la diagonal mayor");
        int dma = sc.nextInt();
        System.out.println("Ingresa el tamaño de la diagonal menor");
        int dme = sc.nextInt();
        double perimetro = lados * 4;
        System.out.println("El area del rombo es:" + ((dme * dma) * 2));
        System.out.println("El perimetro del rombo es:" + perimetro);

    }

}
