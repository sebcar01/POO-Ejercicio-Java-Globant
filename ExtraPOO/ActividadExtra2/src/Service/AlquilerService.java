package Service;

import Entidades.Alquiler;
import Entidades.Pelicula;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AlquilerService {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    public void crearAlquiler(Pelicula[] p, Alquiler[] a, int cantidad){
        boolean verificacion = false;
        int indice = 0;

        System.out.println("Ingresa el nombre de la película que quieres alquilar");
        String nombre = sc.next();

        for (int i = 0; i <= cantidad - 1; i++) {

            if (p[i] == null) {

                continue;

            } else if (p[i].getTitulo().equalsIgnoreCase(nombre)) {

                verificacion = true;
                p[i].setAlquiladaONo(true);
                indice = i;

            }

        }

        if (verificacion) {

            System.out.println("Ingresa la fecha de inicio");
            System.out.println("Ingresa el día");
            int dia = sc.nextInt();
            System.out.println("Ingresa el mes");
            int mes = sc.nextInt();
            System.out.println("Ingresa el año");
            int anio = sc.nextInt();

            LocalDate fi = LocalDate.of(anio, mes, dia);

            a[indice] = new Alquiler(true, fi, 10);

        } else {

            System.out.println("La película que quieres alquilar no existe.");

        }

    }

    public void calcularIngreso(Pelicula[] p, Alquiler[] a, int cantidad) {

        System.out.println("Ingresa el nombre de la película a devolver");
        String nombre = sc.next();

        for (int i = 0; i <= cantidad - 1; i++) {

            if (p[i] == null) {

                continue;

            } else if (p[i].getTitulo().equalsIgnoreCase(nombre)) {

                System.out.println("Ingresa la fecha de devolución");
                System.out.println("Ingresa el día");
                int dia = sc.nextInt();
                System.out.println("Ingresa el mes");
                int mes = sc.nextInt();
                System.out.println("Ingresa el año");
                int anio = sc.nextInt();

                LocalDate ff = LocalDate.of(anio, mes, dia);

                a[i].setFechaFin(ff);
                p[i].setAlquiladaONo(false);

                int dias = a[i].getFechaFin().compareTo(a[i].getFechaInicio());
                System.out.println(dias);

                if (dias > 3) {

                    double calculo = (10 + (dias - 2) * 0.10);
                    a[i].setPrecio(calculo);
                    System.out.println("El ingreso total del alquiler fue: $" + a[i].getPrecio());

                }

            } else {

                System.out.println("La película ingresada no existe.");

            }

        }

    }

    public void buscarAlquiler(Alquiler[] a, Pelicula[] p, int cantidad) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd - MM - yyyy");
        int verificacion = 0;

        System.out.println("Ingresa la fecha de inicio o fin a buscar");
        System.out.println("Ingresa el día");
        int dia = sc.nextInt();
        System.out.println("Ingresa el mes");
        int mes = sc.nextInt();
        System.out.println("Ingresa el año");
        int anio = sc.nextInt();

        LocalDate fecha = LocalDate.of(anio, mes, dia);

        for (int i = 0; i <= cantidad - 1; i++) {

            if (a[i] == null) {

                continue;

            } else if (fecha.equals(a[i].getFechaFin()) || fecha.equals(a[i].getFechaInicio())) {

                verificacion = 1;

                System.out.println("El alquiler existe, a continuación los datos");
                System.out.println("Nombre película: " + p[i].getTitulo());

                if (fecha.equals(a[i].getFechaInicio())) {

                    System.out.println("Fecha de inicio del alquiler: " + format.format(a[i].getFechaInicio()));
                    System.out.println("Fecha de finalización del alquiler: Se encuentra alquilada actualmente");

                } else {

                    System.out.println("Fecha de inicio del alquiler: " + format.format(a[i].getFechaInicio()));
                    System.out.println("Fecha de finalización del alquiler: " + format.format(a[i].getFechaFin()));

                }

            }

        }

        if (verificacion == 0) {

            System.out.println("No existe ningún alquiler que inicie o finalice con la fecha ingresada");

        }

    }

}
