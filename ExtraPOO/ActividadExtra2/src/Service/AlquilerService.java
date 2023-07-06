package Service;

import Entidades.Alquiler;
import Entidades.Pelicula;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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
        Year anio1;
        String verificacion1 = "";

        System.out.println("Ingresa el nombre de la película que quieres alquilar");
        String nombre = sc.next();

        for (int i = 0; i <= cantidad - 1; i++) {

            if (p[i] == null) {

                continue;

            } else if (p[i].getTitulo().equalsIgnoreCase(nombre)) {

                if (p[i].isAlquiladaONo()) {

                    verificacion = false;

                } else {

                    verificacion = true;
                    p[i].setAlquiladaONo(true);
                    indice = i;

                }

            }

        }

        if (verificacion) {

            System.out.println("Ingresa la fecha de inicio");

            do {

                do {

                    try {

                        System.out.println("Ingresa el año. No puede estar en el futuro.");
                        anio = sc.nextInt();
                        verificacion1 = String.valueOf(anio);
                        excepcion = false;

                    } catch (InputMismatchException e) {

                        sc.next();
                        excepcion = true;
                        System.out.println("Solo puedes ingresar números!");

                    }

                } while (excepcion);

            } while (verificacion1.length() != 4 || anio > fa.getYear());

            anio1 = Year.of(anio);

            if (anio != fa.getYear()) {

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

            } else {

                do {

                    do {

                        try {

                            System.out.println("Ingresa el mes. No puede ser mayor al mes actual.");
                            mes = sc.nextInt();
                            excepcion = false;

                        } catch (InputMismatchException e) {

                            sc.next();
                            excepcion = true;
                            System.out.println("Solo puedes ingresar números!");

                        }

                    } while (excepcion);


                } while (mes < 1 || mes > fa.getMonthValue());

            }

            boolean meses31 = mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12;
            boolean meses30 = mes == 4 || mes == 6 || mes == 9 || mes == 11;

            if (mes == fa.getMonthValue() && anio == fa.getYear()) {

                do {

                    do {

                        try {

                            System.out.println("Ingresa el día. No puede ser mayor al día actual.");
                            dia = sc.nextInt();
                            excepcion = false;

                        } catch (InputMismatchException e) {

                            sc.next();
                            excepcion = true;
                            System.out.println("Solo puedes ingresar números!");

                        }

                    } while (excepcion);

                } while (dia < 1 || dia > fa.getDayOfMonth());

            } else if (meses30) {

                do {

                    do {

                        try {

                            System.out.println("Ingresa el día. Máximo 31.");
                            dia = sc.nextInt();
                            excepcion = false;

                        } catch (InputMismatchException e) {

                            sc.next();
                            excepcion = true;
                            System.out.println("Solo puedes ingresar números!");

                        }

                    } while (excepcion);

                } while (dia < 1 || dia > 31);

            } else if (meses31) {

                do {

                    do {

                        try {

                            System.out.println("Ingresa el día. Máximo 30.");
                            dia = sc.nextInt();
                            excepcion = false;

                        } catch (InputMismatchException e) {

                            sc.next();
                            excepcion = true;
                            System.out.println("Solo puedes ingresar números!");

                        }

                    } while (excepcion);

                } while (dia < 1 || dia > 30);

            } else {

                if(anio1.isLeap()) {

                    do {

                        do {

                            try {

                                System.out.println("Ingresa el día. Escogiste Febrero y es un año bisiesto, máximo 29.");
                                dia = sc.nextInt();
                                excepcion = false;

                            } catch (InputMismatchException e) {

                                sc.next();
                                excepcion = true;
                                System.out.println("Solo puedes ingresar números!");

                            }

                        } while (excepcion);

                    } while (dia < 1 || dia > 29);

                } else {

                    do {

                        do {

                            try {

                                System.out.println("Ingresa el día. Escogiste Febrero y no es un año bisiesto, máximo 28.");
                                dia = sc.nextInt();
                                excepcion = false;

                            } catch (InputMismatchException e) {

                                sc.next();
                                excepcion = true;
                                System.out.println("Solo puedes ingresar números!");

                            }

                        } while (excepcion);

                    } while (dia < 1 || dia > 28);

                }

            }

            LocalDate fi = LocalDate.of(anio, mes, dia);

            a[indice] = new Alquiler(nombre, fi, 10);

        } else {

            System.out.println("La película que quieres alquilar no existe o ya se encuentra alquilada.");

        }

    }

    public void calcularIngreso(Pelicula[] p, Alquiler[] a, int cantidad) {
        int validacion = 0;
        int dia = 0;
        int mes = 0;
        int anio = 0;
        boolean excepcion = false;
        LocalDate fa = LocalDate.now();
        Year anio1;
        String verificacion = "";

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

                            System.out.println("Ingresa el año. No puede estar en el futuro, ni puede ser menor al año de la fecha de inicio");
                            System.out.println("Año de inicio del alquiler: " + a[i].getFechaInicio().getYear());
                            anio = sc.nextInt();
                            verificacion = String.valueOf(anio);
                            excepcion = false;

                        } catch (InputMismatchException e) {

                            sc.next();
                            excepcion = true;
                            System.out.println("Solo puedes ingresar números!");

                        }

                    } while (excepcion);

                } while (verificacion.length() != 4 || anio > fa.getYear() || anio < a[i].getFechaInicio().getYear());

                anio1 = Year.of(anio);

                if (anio == fa.getYear() && anio == a[i].getFechaInicio().getYear()) { // La pelicula se renta y devuelve en el año actual

                    do {

                        do {

                            try {

                                System.out.println("Ingresa el mes. Debido a que el año seleccionado es el año actual, el mes no puede ser mayor al mes actual ni puede ser menor al mes de la fecha de inicio.");
                                System.out.println("Mes de la fecha de inicio del alquiler: " + a[i].getFechaInicio().getMonthValue());
                                mes = sc.nextInt();
                                excepcion = false;

                            } catch (InputMismatchException e) {

                                sc.next();
                                excepcion = true;
                                System.out.println("Solo puedes ingresar números!");

                            }

                        } while (excepcion);

                    } while (mes < a[i].getFechaInicio().getMonthValue() || mes > fa.getMonthValue());

                    boolean meses31 = mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12;
                    boolean meses30 = mes == 4 || mes == 6 || mes == 9 || mes == 11;

                    if (mes == a[i].getFechaInicio().getMonthValue() && mes == fa.getMonthValue()) { // Año actual, mes de inicio y fin iguales, mes actual

                        do {

                            do {

                                try {

                                    System.out.println("Ingresa el día. Debido a que es el mes y año actuales, no puede ser mayor al día actual ni menor al día de inicio del alquiler.");
                                    System.out.println("Día de inicio del alquiler: " + a[i].getFechaInicio().getDayOfMonth());
                                    dia = sc.nextInt();
                                    excepcion = false;

                                } catch (InputMismatchException e) {

                                    sc.next();
                                    excepcion = true;
                                    System.out.println("Solo puedes ingresar números!");

                                }

                            } while (excepcion);

                        } while (dia < a[i].getFechaInicio().getDayOfMonth() || dia > fa.getDayOfMonth());

                    } else if (mes != a[i].getFechaInicio().getMonthValue() && mes == fa.getMonthValue()) { // Año actual, mes de inicio fin diferentes, mes actual

                        do {

                            do {

                                try {

                                    System.out.println("Ingresa el día. Debido a que es los meses son diferentes dentro del año actual, no puede ser mayor al día actual.");
                                    System.out.println("Día de inicio del alquiler: " + a[i].getFechaInicio().getDayOfMonth());
                                    dia = sc.nextInt();
                                    excepcion = false;

                                } catch (InputMismatchException e) {

                                    sc.next();
                                    excepcion = true;
                                    System.out.println("Solo puedes ingresar números!");

                                }

                            } while (excepcion);

                        } while (dia < 1 || dia > fa.getDayOfMonth());

                    } else if (mes == a[i].getFechaInicio().getMonthValue() && mes != fa.getMonthValue()) { // Año actual, mismo mes, no es el mes actual

                        if (meses31) {

                            do {

                                do {

                                    try {

                                        System.out.println("Ingresa el día. Debido a que es el mismo mes de inicio y fin en el mismo año, el día tiene que ser mayor al día de la fecha de inicio. Máximo 31.");
                                        System.out.println("Día de inicio del alquiler: " + a[i].getFechaInicio().getDayOfMonth());
                                        dia = sc.nextInt();
                                        excepcion = false;

                                    } catch (InputMismatchException e) {

                                        sc.next();
                                        excepcion = true;
                                        System.out.println("Solo puedes ingresar números!");

                                    }

                                } while (excepcion);

                            } while (dia < a[i].getFechaInicio().getDayOfMonth() || dia > 31);

                        } else if (meses30) {

                            do {

                                do {

                                    try {

                                        System.out.println("Ingresa el día. Debido a que es el mismo mes de inicio y fin en el mismo año, el día tiene que ser mayor al día de la fecha de inicio. Máximo 30.");
                                        System.out.println("Día de inicio del alquiler: " + a[i].getFechaInicio().getDayOfMonth());
                                        dia = sc.nextInt();
                                        excepcion = false;

                                    } catch (InputMismatchException e) {

                                        sc.next();
                                        excepcion = true;
                                        System.out.println("Solo puedes ingresar números!");

                                    }

                                } while (excepcion);

                            } while (dia < a[i].getFechaInicio().getDayOfMonth() || dia > 30);

                        } else {

                            if (anio1.isLeap()) {

                                do {

                                    do {

                                        try {

                                            System.out.println("Ingresa el día. Debido a que es Febrero del mismo año (bisiesto), el día tiene que ser mayor al día de la fecha de inicio. Máximo 29.");
                                            System.out.println("Día de inicio del alquiler: " + a[i].getFechaInicio().getDayOfMonth());
                                            dia = sc.nextInt();
                                            excepcion = false;

                                        } catch (InputMismatchException e) {

                                            sc.next();
                                            excepcion = true;
                                            System.out.println("Solo puedes ingresar números!");

                                        }

                                    } while (excepcion);

                                } while (dia < a[i].getFechaInicio().getDayOfMonth() || dia > 29);

                            } else {

                                do {

                                    do {

                                        try {

                                            System.out.println("Ingresa el día. Debido a que es Febrero del mismo año (bisiesto), el día tiene que ser mayor al día de la fecha de inicio. Máximo 28.");
                                            System.out.println("Día de inicio del alquiler: " + a[i].getFechaInicio().getDayOfMonth());
                                            dia = sc.nextInt();
                                            excepcion = false;

                                        } catch (InputMismatchException e) {

                                            sc.next();
                                            excepcion = true;
                                            System.out.println("Solo puedes ingresar números!");

                                        }

                                    } while (excepcion);

                                } while (dia < a[i].getFechaInicio().getDayOfMonth() || dia > 28);

                            }

                        }

                    } else { // Mismo año, meses diferentes, no es el mes actual

                        if (meses31) {

                            do {

                                do {

                                    try {

                                        System.out.println("Ingresa el día. Debido a que el mes de inicio y fin son diferentes, puedes ingresar cualquier día. Máximo 31.");
                                        dia = sc.nextInt();
                                        excepcion = false;

                                    } catch (InputMismatchException e) {

                                        sc.next();
                                        excepcion = true;
                                        System.out.println("Solo puedes ingresar números!");

                                    }

                                } while (excepcion);

                            } while (dia < 1 || dia > 31);

                        } else if (meses30) {

                            do {

                                do {

                                    try {

                                        System.out.println("Ingresa el día. Debido a que el mes de inicio y fin son diferentes, puedes ingresar cualquier día. Máximo 30.");
                                        dia = sc.nextInt();
                                        excepcion = false;

                                    } catch (InputMismatchException e) {

                                        sc.next();
                                        excepcion = true;
                                        System.out.println("Solo puedes ingresar números!");

                                    }

                                } while (excepcion);

                            } while (dia < 1 || dia > 30);

                        } else {

                            if (anio1.isLeap()) {

                                do {

                                    do {

                                        try {

                                            System.out.println("Ingresa el día. Debido a que es Febrero del mismo año (bisiesto) y es diferente al mes de inicio, puede ser cualquier día. Máximo 29.");
                                            dia = sc.nextInt();
                                            excepcion = false;

                                        } catch (InputMismatchException e) {

                                            sc.next();
                                            excepcion = true;
                                            System.out.println("Solo puedes ingresar números!");

                                        }

                                    } while (excepcion);

                                } while (dia < 1 || dia > 29);

                            } else {

                                do {

                                    do {

                                        try {

                                            System.out.println("Ingresa el día. Debido a que es Febrero del mismo año (bisiesto) y es diferente al mes de inicio, puede ser cualquier día. Máximo 28.");
                                            dia = sc.nextInt();
                                            excepcion = false;

                                        } catch (InputMismatchException e) {

                                            sc.next();
                                            excepcion = true;
                                            System.out.println("Solo puedes ingresar números!");

                                        }

                                    } while (excepcion);

                                } while (dia < 1 || dia > 28);

                            }

                        }

                    }

                } else if (anio == a[i].getFechaInicio().getYear()) { // La pelicula se renta el mismo año pero ese año no es el actual

                    do {

                        do {

                            try {

                                System.out.println("Ingresa el mes. Debido a que es el mismo año de la fecha de inicio, no puede ser menor a ese mes.");
                                System.out.println("Mes de la fecha de inicio del alquiler: " + a[i].getFechaInicio().getMonthValue());
                                mes = sc.nextInt();
                                excepcion = false;

                            } catch (InputMismatchException e) {

                                sc.next();
                                excepcion = true;
                                System.out.println("Solo puedes ingresar números!");

                            }

                        } while (excepcion);

                    } while (mes < a[i].getFechaInicio().getMonthValue() || mes > 12);

                    boolean meses31 = mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12;
                    boolean meses30 = mes == 4 || mes == 6 || mes == 9 || mes == 11;

                    if (mes == a[i].getFechaInicio().getMonthValue()) { // Mes de inicio y fin es el mismo

                        if (meses31) {

                            do {

                                do {

                                    try {

                                        System.out.println("Ingresa el día. Debido a que es el mismo mes de inicio y fin en el mismo año, el día tiene que ser mayor al día de la fecha de inicio. Máximo 31.");
                                        System.out.println("Día de inicio del alquiler: " + a[i].getFechaInicio().getDayOfMonth());
                                        dia = sc.nextInt();
                                        excepcion = false;

                                    } catch (InputMismatchException e) {

                                        sc.next();
                                        excepcion = true;
                                        System.out.println("Solo puedes ingresar números!");

                                    }

                                } while (excepcion);

                            } while (dia < a[i].getFechaInicio().getDayOfMonth() || dia > 31);

                        } else if (meses30) {

                            do {

                                do {

                                    try {

                                        System.out.println("Ingresa el día. Debido a que es el mismo mes de inicio y fin en el mismo año, el día tiene que ser mayor al día de la fecha de inicio. Máximo 30.");
                                        System.out.println("Día de inicio del alquiler: " + a[i].getFechaInicio().getDayOfMonth());
                                        dia = sc.nextInt();
                                        excepcion = false;

                                    } catch (InputMismatchException e) {

                                        sc.next();
                                        excepcion = true;
                                        System.out.println("Solo puedes ingresar números!");

                                    }

                                } while (excepcion);

                            } while (dia < a[i].getFechaInicio().getDayOfMonth() || dia > 30);

                        } else {

                            if (anio1.isLeap()) {

                                do {

                                    do {

                                        try {

                                            System.out.println("Ingresa el día. Debido a que es Febrero del mismo año (bisiesto), el día tiene que ser mayor al día de la fecha de inicio. Máximo 29.");
                                            System.out.println("Día de inicio del alquiler: " + a[i].getFechaInicio().getDayOfMonth());
                                            dia = sc.nextInt();
                                            excepcion = false;

                                        } catch (InputMismatchException e) {

                                            sc.next();
                                            excepcion = true;
                                            System.out.println("Solo puedes ingresar números!");

                                        }

                                    } while (excepcion);

                                } while (dia < a[i].getFechaInicio().getDayOfMonth() || dia > 29);

                            } else {

                                do {

                                    do {

                                        try {

                                            System.out.println("Ingresa el día. Febrero del mismo año (no bisiesto), el día tiene que ser mayor al día de la fecha de inicio. Máximo 28.");
                                            System.out.println("Día de inicio del alquiler: " + a[i].getFechaInicio().getDayOfMonth());
                                            dia = sc.nextInt();
                                            excepcion = false;

                                        } catch (InputMismatchException e) {

                                            sc.next();
                                            excepcion = true;
                                            System.out.println("Solo puedes ingresar números!");

                                        }

                                    } while (excepcion);

                                } while (dia < a[i].getFechaInicio().getDayOfMonth() || dia > 28);

                            }

                        }

                    } else { // Meses diferentes, mismo año, no es el año actual

                        if (meses31) {

                            do {

                                do {

                                    try {

                                        System.out.println("Ingresa el día. Meses diferentes de inicio y fin en el mismo año. Máximo 31.");
                                        dia = sc.nextInt();
                                        excepcion = false;

                                    } catch (InputMismatchException e) {

                                        sc.next();
                                        excepcion = true;
                                        System.out.println("Solo puedes ingresar números!");

                                    }

                                } while (excepcion);

                            } while (dia < 1 || dia > 31);

                        } else if (meses30) {

                            do {

                                do {

                                    try {

                                        System.out.println("Ingresa el día. Meses diferentes de inicio y fin en el mismo año. Máximo 30.");
                                        dia = sc.nextInt();
                                        excepcion = false;

                                    } catch (InputMismatchException e) {

                                        sc.next();
                                        excepcion = true;
                                        System.out.println("Solo puedes ingresar números!");

                                    }

                                } while (excepcion);

                            } while (dia < 1 || dia > 30);

                        } else {

                            if (anio1.isLeap()) {

                                do {

                                    do {

                                        try {

                                            System.out.println("Ingresa el día. El mes es Febrero del mismo año (bisiesto). Máximo 29.");
                                            dia = sc.nextInt();
                                            excepcion = false;

                                        } catch (InputMismatchException e) {

                                            sc.next();
                                            excepcion = true;
                                            System.out.println("Solo puedes ingresar números!");

                                        }

                                    } while (excepcion);

                                } while (dia < 1 || dia > 29);

                            } else {

                                do {

                                    do {

                                        try {

                                            System.out.println("Ingresa el día. El mes es Febrero del mismo año (no bisiesto). Máximo 28.");
                                            dia = sc.nextInt();
                                            excepcion = false;

                                        } catch (InputMismatchException e) {

                                            sc.next();
                                            excepcion = true;
                                            System.out.println("Solo puedes ingresar números!");

                                        }

                                    } while (excepcion);

                                } while (dia < 1 || dia > 28);

                            }

                        }

                    }

                } else if (anio == fa.getYear() && anio != a[i].getFechaInicio().getYear()) { // La pelicula se renta un año X, y se regresa en el año actual

                    do {

                        do {

                            try {

                                System.out.println("Ingresa el mes. Debido a que el año seleccionado es el año actual, el mes no puede ser mayor al mes actual.");
                                mes = sc.nextInt();
                                excepcion = false;

                            } catch (InputMismatchException e) {

                                sc.next();
                                excepcion = true;
                                System.out.println("Solo puedes ingresar números!");

                            }

                        } while (excepcion);

                    } while (mes < 1 || mes > fa.getMonthValue());

                    boolean meses31 = mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12;
                    boolean meses30 = mes == 4 || mes == 6 || mes == 9 || mes == 11;

                    if (mes == fa.getMonthValue()) { // Se devuelve en el mes actual

                        do {

                            do {

                                try {

                                    System.out.println("Ingresa el día. Debido a que es los meses son diferentes, no puede ser mayor al día actual.");
                                    dia = sc.nextInt();
                                    excepcion = false;

                                } catch (InputMismatchException e) {

                                    sc.next();
                                    excepcion = true;
                                    System.out.println("Solo puedes ingresar números!");

                                }

                            } while (excepcion);

                        } while (dia < 1 || dia > fa.getDayOfMonth());

                    } else { // Se devuelve un mes diferente al actual en este año

                        if (meses31) {

                            do {

                                do {

                                    try {

                                        System.out.println("Ingresa el día. Mes diferente de inicio y fin en distintos años. Máximo 31.");
                                        dia = sc.nextInt();
                                        excepcion = false;

                                    } catch (InputMismatchException e) {

                                        sc.next();
                                        excepcion = true;
                                        System.out.println("Solo puedes ingresar números!");

                                    }

                                } while (excepcion);

                            } while (dia < 1 || dia > 31);

                        } else if (meses30) {

                            do {

                                do {

                                    try {

                                        System.out.println("Ingresa el día. Mes diferente de inicio y fin en distintos años. Máximo 30.");
                                        dia = sc.nextInt();
                                        excepcion = false;

                                    } catch (InputMismatchException e) {

                                        sc.next();
                                        excepcion = true;
                                        System.out.println("Solo puedes ingresar números!");

                                    }

                                } while (excepcion);

                            } while (dia < 1 || dia > 30);

                        } else {

                            if (anio1.isLeap()) {

                                do {

                                    do {

                                        try {

                                            System.out.println("Ingresa el día. El mes es Febrero de otro año (bisiesto). Máximo 29.");
                                            dia = sc.nextInt();
                                            excepcion = false;

                                        } catch (InputMismatchException e) {

                                            sc.next();
                                            excepcion = true;
                                            System.out.println("Solo puedes ingresar números!");

                                        }

                                    } while (excepcion);

                                } while (dia < 1 || dia > 29);

                            } else {

                                do {

                                    do {

                                        try {

                                            System.out.println("Ingresa el día. El mes es Febrero de otro año (no bisiesto). Máximo 28.");
                                            dia = sc.nextInt();
                                            excepcion = false;

                                        } catch (InputMismatchException e) {

                                            sc.next();
                                            excepcion = true;
                                            System.out.println("Solo puedes ingresar números!");

                                        }

                                    } while (excepcion);

                                } while (dia < 1 || dia > 28);

                            }

                        }

                    }

                } else { // La pelicula se renta en año X y se regresa en otro año distinto al año que se rento y al actual

                    do {

                        do {

                            try {

                                System.out.println("Ingresa el mes.");
                                mes = sc.nextInt();
                                excepcion = false;

                            } catch (InputMismatchException e) {

                                sc.next();
                                excepcion = true;
                                System.out.println("Solo puedes ingresar números!");

                            }

                        } while (excepcion);

                    } while (mes < 1 || mes > 12);

                    boolean meses31 = mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12;
                    boolean meses30 = mes == 4 || mes == 6 || mes == 9 || mes == 11;

                    if (meses31) {

                        do {

                            do {

                                try {

                                    System.out.println("Ingresa el día. Mes diferente de inicio y fin en distintos años. Máximo 31.");
                                    dia = sc.nextInt();
                                    excepcion = false;

                                } catch (InputMismatchException e) {

                                    sc.next();
                                    excepcion = true;
                                    System.out.println("Solo puedes ingresar números!");

                                }

                            } while (excepcion);

                        } while (dia < 1 || dia > 31);

                    } else if (meses30) {

                        do {

                            do {

                                try {

                                    System.out.println("Ingresa el día. Mes diferente de inicio y fin en distintos años. Máximo 30.");
                                    dia = sc.nextInt();
                                    excepcion = false;

                                } catch (InputMismatchException e) {

                                    sc.next();
                                    excepcion = true;
                                    System.out.println("Solo puedes ingresar números!");

                                }

                            } while (excepcion);

                        } while (dia < 1 || dia > 30);

                    } else {

                        if (anio1.isLeap()) {

                            do {

                                do {

                                    try {

                                        System.out.println("Ingresa el día. El mes es Febrero de otro año (bisiesto). Máximo 29.");
                                        dia = sc.nextInt();
                                        excepcion = false;

                                    } catch (InputMismatchException e) {

                                        sc.next();
                                        excepcion = true;
                                        System.out.println("Solo puedes ingresar números!");

                                    }

                                } while (excepcion);

                            } while (dia < 1 || dia > 29);

                        } else {

                            do {

                                do {

                                    try {

                                        System.out.println("Ingresa el día. El mes es Febrero de otro año (no bisiesto). Máximo 28.");
                                        dia = sc.nextInt();
                                        excepcion = false;

                                    } catch (InputMismatchException e) {

                                        sc.next();
                                        excepcion = true;
                                        System.out.println("Solo puedes ingresar números!");

                                    }

                                } while (excepcion);

                            } while (dia < 1 || dia > 28);

                        }

                    }

                }

                LocalDate ff = LocalDate.of(anio, mes, dia);

                a[i].setFechaFin(ff);
                p[i].setAlquiladaONo(false);

                long dias = a[i].getFechaInicio().until(a[i].getFechaFin(), ChronoUnit.DAYS);

                if (dias > 3) {

                    double calculo = (a[i].getPrecio() + ((dias - 2) * 0.10));
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
