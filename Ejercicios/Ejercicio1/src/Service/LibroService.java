package Service;

import Entidades.Libro;

import java.util.Scanner;

public class LibroService {

    private Scanner sc = new Scanner(System.in).useDelimiter("\n");

    Libro l = new Libro();

    public void llenarLibro(){

        System.out.println("Ingresa el Titulo");
        l.titulo = sc.nextLine();

        System.out.println("Ingresa el Autor");
        l.autor = sc.nextLine();

        System.out.println("Ingresa el número de páginas");
        l.paginas = sc.nextInt();

        System.out.println("Ingresa el ISBN");
        l.isbn = sc.nextInt();

    }

    public void mostrarLibro(){

        System.out.println("El título del libro es: " + l.titulo);
        System.out.println("El Autor del libro es: " + l.autor);
        System.out.println("El número de páginas del libro es: " + l.paginas);
        System.out.println("El ISBN del libro es: " + l.isbn);

    }

}
