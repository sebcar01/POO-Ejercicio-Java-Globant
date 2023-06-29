package Main;

import Entidades.Persona;
import Service.PersonaService;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Ejercicio7Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingresa el total de personas");
        int totalPersonas = sc.nextInt();
        PersonaService ps = new PersonaService();
        Persona[] personas = new Persona[totalPersonas];
        int[] imc = new int[3];
        int[] edad = new int[2];

        personas(ps, personas, imc, edad, totalPersonas);

        System.out.println(imc[0] == 0 ? "No hay ninguna persona debajo de su peso ideal" : "El porcentaje de personas debajo de su peso ideal es: " + ((imc[0] * 100) / totalPersonas) + "%");
        System.out.println(imc[1] == 0 ? "No hay ninguna persona con peso ideal" : "El porcentaje de personas con peso ideal es: " + ((imc[1] * 100) / totalPersonas) + "%");
        System.out.println(imc[2] == 0 ? "No hay ninguna persona con sobrepeso" : "El porcentaje de personas con sobrepreso es: " + ((imc[2] * 100) / totalPersonas) + "%");

        System.out.println(edad[0] == 0 ? "No hay ninguna persona mayor de edad" : "El porcentaje de personas mayores de edad es: " + ((edad[0] * 100) / totalPersonas) + "%");
        System.out.println(edad[1] == 0 ? "No hay ninguna persona menor de edad" : "El porcentaje de personas menores de edad es: " + ((edad[1] * 100) / totalPersonas) + "%");

    }
    public static void validarIMC(PersonaService ps, Persona p, int[] imc) {
        DecimalFormat df = new DecimalFormat("#.##");

        if (ps.calcularIMC(p) == -1) {

            imc[0] += 1;

        }

        if (ps.calcularIMC(p) == 0) {

            imc[1] += 1;

        }

        if (ps.calcularIMC(p) == 1) {

            imc[2] += 1;

        }

        System.out.println("IMC = " + df.format(p.getImc()));

    }

    public static void validarEdad(PersonaService ps, Persona p, int[] edad) {

        if (ps.esMayorDeEdad(p)) {

            edad[0] += 1;
            System.out.println("Eres mayor de edad");

        }

        if (!ps.esMayorDeEdad(p)) {

            edad[1] += 1;
            System.out.println("Eres menor de edad");

        }

    }

    public static void personas(PersonaService ps, Persona[] p, int[] imc, int[] edad, int totalPersonas) {

        for (int i = 0; i <= totalPersonas - 1; i++) {

            System.out.println("Ingresa los datos de la persona " + (i + 1));
            p[i] = ps.crearPersona();
            validarIMC(ps, p[i],imc);
            validarEdad(ps, p[i],edad);

        }

    }

}
