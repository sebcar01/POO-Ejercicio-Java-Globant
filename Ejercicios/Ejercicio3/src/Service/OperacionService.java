package Service;

import Entidades.Operacion;

import java.util.Scanner;

public class OperacionService {

    private Scanner sc = new Scanner(System.in).useDelimiter("\n");
    public Operacion crearOperacion() {

        System.out.println("Ingresa el primer número");
        double num1 = sc.nextDouble();

        System.out.println("Ingresa el segundo número");
        double num2 = sc.nextDouble();

        return new Operacion(num1, num2);

    }

    public double sumar(Operacion op) {

        return (op.getNumero1() + op.getNumero2());

    }

    public double restar(Operacion op) {

        return (op.getNumero1() - op.getNumero2());

    }

    public double multiplicar(Operacion op) {

        return (op.getNumero1() * op.getNumero2());

    }

    public double dividir(Operacion op) {

        if (op.getNumero1() == 0 || op.getNumero2() == 0) {

            return 0;

        }

        return (op.getNumero1() / op.getNumero2());

    }

}
