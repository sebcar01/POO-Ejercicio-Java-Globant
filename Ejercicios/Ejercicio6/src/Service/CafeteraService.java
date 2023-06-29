package Service;

import Entidades.Cafetera;

import java.util.Scanner;

public class CafeteraService {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");

    /**
     * Instancia la cafetera, pida la capacidad maxima y la deja vacia por defecto
     * @return Cafetera con cantidadActual 0, capicidadMaxima n
     */
    public Cafetera crearCafetera() {

        System.out.println("Ingresa la capacidad máxima de la cafetera");
        int cm = sc.nextInt();

        return new Cafetera(cm,0);

    }

    public void llenarCafetera(Cafetera cftr) {

        cftr.setCantidadActual(cftr.getCapacidadMaxima());
        System.out.println("Cafetera totalmente llena");

    }

    public void servirTaza(Cafetera cftr) {

        System.out.println("Ingresa el tamaño de la taza");
        int tamanoTaza = sc.nextInt();

        System.out.println("------------------");
        System.out.println("Sirviendo taza...");
        System.out.println("------------------");

        int nuevaCantidad = cftr.getCantidadActual() - tamanoTaza;

        if (nuevaCantidad < 0) {

            System.out.println("La taza no se pudo llenar completamente");
            System.out.println("Se pudieron llenar " + cftr.getCantidadActual() + " unidades de las " + tamanoTaza + " solicitadas");
            cftr.setCantidadActual(0);

        } else {

            System.out.println("La taza se llenó completamente");
            cftr.setCantidadActual(nuevaCantidad);

        }


    }

    public void vaciarCafetera(Cafetera cftr) {

        cftr.setCantidadActual(0);
        System.out.println("Cafetera totalmente vacía");

    }

    public void agregarCafe(Cafetera cftr) {

        System.out.println("Ingresa la cantidad de café a agregar");
        int nuevaCantidad = sc.nextInt();

        if (nuevaCantidad + cftr.getCantidadActual() > cftr.getCapacidadMaxima()) {

            System.out.println("La cantidad agregada excede la capacidad máxima de la cafetera");
            agregarCafe(cftr);

        } else {

            cftr.setCantidadActual(cftr.getCantidadActual() + nuevaCantidad);
            System.out.println("Cantidad agregada");

        }

    }

    public int consultarCantidadActual(Cafetera cftr) {

        return cftr.getCantidadActual();

    }
}
