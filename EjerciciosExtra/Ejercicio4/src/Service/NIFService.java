package Service;

import Entidades.NIF;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NIFService {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public NIF crearNIF() {
        boolean verificacion;
        long DNI = 0;
        String DNIs = "";
        int resultado;
        String[] letras = new String[23];
        String letra = "";

        do {

            try {

                System.out.println("Ingresa el DNI. Tiene que ser de 10 dígitos");
                DNI = sc.nextLong();
                DNIs = String.valueOf(DNI);
                verificacion = true;

            } catch (InputMismatchException e) {

                sc.next();
                verificacion = false;
                System.out.println("Solo puedes ingresar números!");

            }

        } while (DNIs.length() != 10 || !verificacion);

        resultado = (int) DNI % 23;

        letras[0] = "-T";
        letras[1] = "-R";
        letras[2] = "-W";
        letras[3] = "-A";
        letras[4] = "-G";
        letras[5] = "-M";
        letras[6] = "-Y";
        letras[7] = "-F";
        letras[8] = "-P";
        letras[9] = "-D";
        letras[10] = "-X";
        letras[11] = "-B";
        letras[12] = "-N";
        letras[13] = "-J";
        letras[14] = "-Z";
        letras[15] = "-S";
        letras[16] = "-Q";
        letras[17] = "-V";
        letras[18] = "-H";
        letras[19] = "-L";
        letras[20] = "-C";
        letras[21] = "-K";
        letras[22] = "-E";

        for (int i = 0; i <= 22; i++) {

            if (resultado == i) {

                letra = letras[i];
                break;

            }

        }

        return new NIF(DNI, letra);

    }

    public void mostrar(NIF n) {

        System.out.println("El NIF es: " + n.getDNI() + n.getLetra());

    }

}
