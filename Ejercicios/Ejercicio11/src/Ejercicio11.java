import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ejercicio11 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        int dia;
        int mes;
        int anio;

        do {

            System.out.println("Ingresa el dia. Tiene que ser mayor a 0 y menor o igual a 31");
            dia = sc.nextInt();

        } while (dia < 0 || dia > 31);

        do {

            System.out.println("Ingresa el mes. Tiene que ser mayor a 0 y menor o igual a 12");
            mes = sc.nextInt();

        } while (mes < 0 || mes > 12);


        System.out.println("Ingresa el año");
        anio = sc.nextInt();

        LocalDate fechaUsuario = LocalDate.of(anio, mes, dia);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd - MM - yyyy");
        System.out.println(format.format(fechaUsuario));
        System.out.println("Los años entre la fecha ingresada y la fecha actual son: " + LocalDate.now().compareTo(fechaUsuario));

    }

}
