package Service;

import Entidades.Raices;

import java.util.Scanner;

public class RaicesService {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    public Raices crearRaices() {

        System.out.println("Ingresa el coeficiente 1");
        double a = sc.nextInt();
        System.out.println("Ingresa el coeficiente 2");
        double b = sc.nextInt();
        System.out.println("Ingresa el coeficiente 3");
        double c = sc.nextInt();

        return new Raices(a,b,c);

    }

    public double getDiscriminante(Raices r) {
        double discriminante;

        discriminante = (Math.pow(r.getB(), 2) - (4 * r.getA() * r.getC()) );

        return discriminante;

    }

    public boolean tieneRaices(Raices r) {

        return getDiscriminante(r) >= 0; // Si el resultado es mayor o igual a 0, entonces hay 2 soluciones

    }

    public boolean tieneRaiz(Raices r) {

        return getDiscriminante(r) == 0; // Si el resultado es 0, tiene una unica solucion

    }

    public void obtenerRaices(Raices r)  {

        boolean resultado = tieneRaices(r);

        double solucion1 = ( (-r.getB() + Math.sqrt( getDiscriminante(r) )) / (2 * r.getA() ) );
        double solucion2 = ( (-r.getB() - Math.sqrt( getDiscriminante(r) )) / (2 * r.getA() ) );

        if (resultado){

            System.out.println("Primer solución " + solucion1);
            System.out.println("Segunda solución " + solucion2);

        } else {

            System.out.println("No tiene dos soluciones");

        }

    }

    public void obtenerRaiz(Raices r)  {

        boolean resultado = tieneRaiz(r);

        double ecuacionSegundoGrado = ( (-r.getB() + Math.sqrt( getDiscriminante(r) )) / (2 * r.getA() ) );
        double ecuacionSegundoGrado1 = ( (-r.getB() - Math.sqrt( getDiscriminante(r) )) / (2 * r.getA() ) );

        if (resultado){

            System.out.println("Solución: " + ecuacionSegundoGrado);

        } else {

            System.out.println("No tiene solución");

        }

    }

    public void calcular(Raices r) {

        boolean raices = tieneRaices(r);
        boolean raiz = tieneRaiz(r);

        if (raices) {

            obtenerRaices(r);

        } else if (raiz) {

            obtenerRaiz(r);

        } else {

            System.out.println("No hay soluciones");

        }

    }

}
