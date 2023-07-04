package Service;

import Entidad.Movil;

import java.util.Scanner;

public class MovilService {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    public Movil cargarCelular() {

        System.out.println("Ingresa la marca");
        String marca = sc.next();
        System.out.println("Ingresa el precio");
        int precio = sc.nextInt();
        System.out.println("Ingresa el modelo");
        String modelo = sc.next();
        System.out.println("Ingresa la memoria Ram");
        int memoria = sc.nextInt();
        System.out.println("Ingresa el almacenamiento");
        int almacenamiento = sc.nextInt();

        return new Movil(marca, precio, modelo, memoria, almacenamiento, ingresarCodigo());

    }

    public int[] ingresarCodigo() {

        int[] arreglo = new int[7];

        System.out.println("Ingresa el código");

        for (int i = 0; i <= 6; i++){

            arreglo[i] = sc.nextInt();

        }

        return arreglo;

    }

}
