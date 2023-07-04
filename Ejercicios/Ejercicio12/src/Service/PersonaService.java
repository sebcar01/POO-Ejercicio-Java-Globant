package Service;

import Entidades.Persona;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PersonaService {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public Persona crearPersona() {

        System.out.println("Ingresa tu nombre");
        String nombre = sc.next();

        System.out.println("Ingresa tu fecha de nacimiento");
        System.out.println("Día");
        int dia = sc.nextInt();
        System.out.println("Mes");
        int mes = sc.nextInt();
        System.out.println("Año");
        int anio = sc.nextInt();

        LocalDate dob = LocalDate.of(anio, mes, dia);

        return new Persona(nombre, dob);

    }

    public void calcularEdad(Persona ps) {

        System.out.println("Tu edad es: " + LocalDate.now().compareTo(ps.getFechaDeNacimiento()) + " años.");

    }

    public void menorQue(Persona ps) {

        System.out.println("Ingresa otra edad");
        int nuevaEdad = sc.nextInt();

        int edadUsuario = LocalDate.now().compareTo(ps.getFechaDeNacimiento());

        System.out.println(edadUsuario < nuevaEdad ? "El usuario guardado es menor" : "El usuario nuevo es menor");

    }

    public void mostrarPersona(Persona ps) {

        System.out.println("Nombre: " + ps.getNombre());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("Fecha de nacimiento: " + formatter.format(ps.getFechaDeNacimiento()));

    }

}
