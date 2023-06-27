package Service;

import Entidades.Mascota;

import java.util.Scanner;

public class MascotaService {

    private Scanner sc = new Scanner(System.in).useDelimiter("\n");
    public Mascota crearMascota() {

        System.out.println("Ingresa el nombre");
        String nombre = sc.nextLine();
        System.out.println("Ingresa el apodo");
        String apodo = sc.nextLine();
        System.out.println("Ingresa el tipo");
        String tipo = sc.nextLine();

        return new Mascota(nombre, apodo, tipo);

    }

}
