package Service;

import Entidades.Persona;

import java.util.Scanner;

public class PersonaService {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    public Persona crearPersona(){
        char sexo;
        String sxo;

        System.out.println("Ingresa tu nombre");
        String nombre = sc.next();

        System.out.println("Ingresa tu edad");
        int edad = sc.nextInt();

        do {

            System.out.println("Ingresa tu sexo. Elige entre H, M, O");
            sexo = sc.next().charAt(0);
            sxo = Character.toString(sexo);

            if (!sxo.equalsIgnoreCase("h") && !sxo.equalsIgnoreCase("m") && !sxo.equalsIgnoreCase("o")) {

                System.out.println("Opción inválida");

            }

        } while (!sxo.equalsIgnoreCase("h") && !sxo.equalsIgnoreCase("m") && !sxo.equalsIgnoreCase("o"));

        sexo = sxo.charAt(0);

        System.out.println("Ingresa tu peso en KG");
        double peso = sc.nextDouble();

        System.out.println("Ingresa tu altura en cm, en formato decimal, ejemplo: 1.76" );
        double altura = sc.nextDouble();

        return new Persona(nombre, edad, sexo, peso, altura);
    }

    public int calcularIMC(Persona ps) {

        double calculoIMC = ps.getPeso() / (Math.pow(ps.getAltura(), 2));
        ps.setImc(calculoIMC);

        if (calculoIMC < 20) {

            return -1;

        }

        if (calculoIMC >= 20 && calculoIMC <= 25) {

            return 0;

        } else {

            return 1;

        }

    }

    public boolean esMayorDeEdad(Persona ps) {

        return ps.getEdad() > 18;

    }

}
