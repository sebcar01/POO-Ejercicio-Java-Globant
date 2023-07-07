package Service;

import Entidades.Adivinar;

import java.util.Scanner;

public class AdivinarService {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    public Adivinar crearAdivinar() {

        String[] meses = new String[12];

        meses[0] = "enero";
        meses[1] = "febrero";
        meses[2] = "marzo";
        meses[3] = "abril";
        meses[4] = "mayo";
        meses[5] = "junio";
        meses[6] = "julio";
        meses[7] = "agosto";
        meses[8] = "septiembre";
        meses[9] = "octubre";
        meses[10] = "noviembre";
        meses[11] = "diciembre";

        return new Adivinar(meses);

    }

    public void iniciarJuego(Adivinar a) {

        String mesSecreto = a.getMeses()[3];
        boolean verificacion = false;

        do {

            System.out.println("Ingresa el nombre del mes");
            String respuesta = sc.next().toLowerCase();

            for (int i = 0; i <= 11; i++) {

                if(respuesta.equals(mesSecreto)) {

                    verificacion = true;

                }

            }

            System.out.println(!verificacion ? "No acertaste! Intenta de nuevo." : "Adivinaste el mes! Chau");

        } while (!verificacion);

    }

}
