package Service;

import Entidades.Circunferencia;

import java.util.Scanner;

public class CircunferenciaService {

    private Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public Circunferencia crearCircunferencia(){

        System.out.println("Ingresa el radio");
        return new Circunferencia(sc.nextDouble());

    }

    public double area(Circunferencia c1) {

        return (Math.PI * Math.pow(c1.getRadio(), 2));

    }

    public double perimetro(Circunferencia c1) {

       return (2 * Math.PI * c1.getRadio());

    }



}
