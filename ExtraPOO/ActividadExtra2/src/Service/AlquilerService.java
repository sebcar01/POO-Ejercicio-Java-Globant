package Service;

import Entidades.Alquiler;
import Entidades.Pelicula;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AlquilerService {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    public void crearAlquiler(Pelicula[] p, Alquiler[] a, int cantidad){
        boolean verificacion = false;
        int indice = 0;
        int dia = 0;
        int mes = 0;
        int anio = 0;
        boolean excepcion = false;
        LocalDate fa = LocalDate.now();

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

            do {

                do {

                    try {

                        System.out.println("Ingresa el día");
                        dia = sc.nextInt();
                        excepcion = false;

                    } catch (InputMismatchException e) {

                        sc.next();
                        excepcion = true;
                        System.out.println("Solo puedes ingresar números!");

                    }

                } while (excepcion);

            } while (dia < 1 || dia > fa.getDayOfMonth());

            do {

                do {

                    try {

                        System.out.println("Ingresa el mes");
                        mes = sc.nextInt();
                        excepcion = false;

                    } catch (InputMismatchException e) {

                        sc.next();
                        excepcion = true;
                        System.out.println("Solo puedes ingresar números!");

                    }

                } while (excepcion);

            } while (mes < 1 || mes > 12);

            do {

                do {

                    try {

                        System.out.println("Ingresa el año");
                        anio = sc.nextInt();
                        excepcion = false;

                    } catch (InputMismatchException e) {

                        sc.next();
                        excepcion = true;
                        System.out.println("Solo puedes ingresar números!");

                    }

                } while (excepcion);

            } while (anio > fa.getYear());

            LocalDate fi = LocalDate.of(anio, mes, dia);

            a[indice] = new Alquiler(nombre, fi, 10);

        } else {

            System.out.println("La película que quieres alquilar no existe.");

        }

    }

    public void calcularIngreso(Pelicula[] p, Alquiler[] a, int cantidad) {
        int validacion = 0;
        int dia = 0;
        int mes = 0;
        int anio = 0;
        boolean excepcion = false;
        LocalDate fa = LocalDate.now();

        System.out.println("Ingresa el nombre de la película a devolver");
        String nombre = sc.next();

        for (int i = 0; i <= cantidad - 1; i++) {

            if (a[i] == null) {

                continue;

            } else if (a[i].getPeliculaAlquilada().equalsIgnoreCase(nombre)) {

                validacion = 1;
                System.out.println("Ingresa la fecha de devolución");

                do {

                    do {

                        try {

                            System.out.println("Ingresa el día");
                            dia = sc.nextInt();
                            excepcion = false;

                        } catch (InputMismatchException e) {

                            sc.next();
                            excepcion = true;
                            System.out.println("Solo puedes ingresar números!");

                        }

                    } while (excepcion);

                } while (dia < 1 || dia > fa.getDayOfMonth());

                do {

                    do {

                        try {

                            System.out.println("Ingresa el mes");
                            mes = sc.nextInt();
                            excepcion = false;

                        } catch (InputMismatchException e) {

                            sc.next();
                            excepcion = true;
                            System.out.println("Solo puedes ingresar números!");

                        }

                    } while (excepcion);

                } while (mes < 1 || mes > 12);

                do {

                    do {

                        try {

                            System.out.println("Ingresa el año");
                            anio = sc.nextInt();
                            excepcion = false;

                        } catch (InputMismatchException e) {

                            sc.next();
                            excepcion = true;
                            System.out.println("Solo puedes ingresar números!");

                        }

                    } while (excepcion);

                } while (anio > fa.getYear());

                LocalDate ff = LocalDate.of(anio, mes, dia);

                a[i].setFechaFin(ff);
                p[i].setAlquiladaONo(false);

                int dias = a[i].getFechaFin().compareTo(a[i].getFechaInicio());

                if (dias > 3) {

                    double calculo = (10 + (dias - 2) * 0.10);
                    a[i].setPrecio(calculo);
                    System.out.println("El ingreso total del alquiler fue: $" + a[i].getPrecio());

                } else {

                    System.out.println("El ingreso total del alquiler fue : $" + a[i].getPrecio());

                }

            }

        }

        if (validacion == 0) {

            System.out.println("La película ingresada no existe, o no se encuentra alquilada.");

        }

    }

    public void buscarAlquiler(Alquiler[] a, Pelicula[] p, int cantidad) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd - MM - yyyy");
        int verificacion = 0;
        boolean excepcion = false;
        int dia = 0;
        int mes = 0;
        int anio = 0;
        LocalDate fa = LocalDate.now();

        System.out.println("Ingresa la fecha de inicio o fin a buscar");

        do {

            do {

                try {

                    System.out.println("Ingresa el día");
                    dia = sc.nextInt();
                    excepcion = false;

                } catch (InputMismatchException e) {

                    sc.next();
                    excepcion = true;
                    System.out.println("Solo puedes ingresar números!");

                }

            } while (excepcion);

        } while (dia < 1 || dia > 31);

        do {

            do {

                try {

                    System.out.println("Ingresa el mes");
                    mes = sc.nextInt();
                    excepcion = false;

                } catch (InputMismatchException e) {

                    sc.next();
                    excepcion = true;
                    System.out.println("Solo puedes ingresar números!");

                }

            } while (excepcion);

        } while (mes < 1 || mes > 12);

        do {

            do {

                try {

                    System.out.println("Ingresa el año");
                    anio = sc.nextInt();
                    excepcion = false;

                } catch (InputMismatchException e) {

                    sc.next();
                    excepcion = true;
                    System.out.println("Solo puedes ingresar números!");

                }

            } while (excepcion);

        } while (anio > fa.getYear());

        LocalDate fecha = LocalDate.of(anio, mes, dia);

        for (int i = 0; i <= cantidad - 1; i++) {

            if (a[i] == null) {

                continue;

            } else if (fecha.equals(a[i].getFechaFin()) || fecha.equals(a[i].getFechaInicio())) {

                verificacion = 1;

                System.out.println("El alquiler existe, a continuación los datos");
                System.out.println("Nombre película: " + a[i].getPeliculaAlquilada());

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
