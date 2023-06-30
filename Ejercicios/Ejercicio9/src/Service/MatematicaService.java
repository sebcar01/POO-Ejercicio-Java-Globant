package Service;

import Entidades.Matematica;

import java.text.DecimalFormat;

public class MatematicaService {

    DecimalFormat df = new DecimalFormat("#.##");
    public Matematica crearMatematica() {

        return new Matematica((Math.random() * 100), (Math.random() * 100));

    }

    public void devolverMayor(Matematica mt) {

        System.out.println(mt.getNum1() > mt.getNum2()
                ? df.format(mt.getNum1()) + " el primer número es mayor que " + df.format(mt.getNum2())
                : df.format(mt.getNum2()) + " el segundo número es mayor que " + df.format(mt.getNum1()));

    }

    public void calcularPotencia(Matematica mt) {
        double num1;
        double num2;
        String num;

        if (mt.getNum1() > mt.getNum2()) {

            num1 = Math.round(mt.getNum1());
            num2 = Math.round(mt.getNum2());

        } else {

            num1 = Math.round(mt.getNum2());
            num2 = Math.round(mt.getNum1());

        }

        num = df.format(Math.pow(num1, num2)).substring(0,10);

        System.out.println("El número mayor elevado al número menor es: " + num + "...");

    }

    public void calcularRaiz(Matematica mt) {

        double num = mt.getNum1() < mt.getNum2() ? Math.ceil(mt.getNum1()) : Math.ceil(mt.getNum2()) ;

        System.out.println("La raíz cuadrada de " + df.format(num) + " que es el número menor es: " + df.format(Math.sqrt(num)));

    }

}
