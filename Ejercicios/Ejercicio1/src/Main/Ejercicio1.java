package Main;

import Service.LibroService;

public class Ejercicio1 {

    public static void main(String[] args) {

        LibroService ls = new LibroService();

        ls.llenarLibro();
        ls.mostrarLibro();

    }

}
