import Entidad.Persona;

public class Ejercicio1 {

    public static void main(String[] args) {

        Persona primeraPersona = new Persona("Ramon", 22, "Masculino");
        primeraPersona.setEdad(42);
        System.out.println(primeraPersona.getEdad());

    }

}
