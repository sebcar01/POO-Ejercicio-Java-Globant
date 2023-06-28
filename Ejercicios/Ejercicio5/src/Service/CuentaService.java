package Service;

import Entidades.Cuenta;

import java.util.Scanner;

public class CuentaService {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    public Cuenta crearCuenta() {

        System.out.println("Ingresa el número de cuenta");
        int nc = sc.nextInt();
        System.out.println("Ingresa el DNI");
        long dni = sc.nextLong();
        System.out.println("Ingresa el saldo actual");
        int sact = sc.nextInt();

        return new Cuenta(nc, dni, sact);

    }

    public void ingresar(Cuenta cb) {

        System.out.println("Ingresa la cantidad a agregar a tu cuenta");
        double nuevoSaldo = sc.nextDouble();

        double saldoTotal = cb.getSaldoActual() + nuevoSaldo;
        cb.setSaldoActual((int) saldoTotal);

    }

    public void retirar(Cuenta cb) {

        System.out.println("Ingresa la cantidad a retirar");
        double retiro = sc.nextDouble();

        double saldoTotal = cb.getSaldoActual() - retiro;

        if (saldoTotal < 0) {

            cb.setSaldoActual(0);

        } else {

            cb.setSaldoActual((int) saldoTotal);

        }

    }

    public void extraccionRapida(Cuenta cb) {

        System.out.println("Ingresa la cantidad a retirar");
        double retiro = sc.nextDouble();

        if (retiro > (cb.getSaldoActual() * 0.20)) {

            System.out.println("La cantidad que deseas retirar supera el 20%");
            extraccionRapida(cb);

        } else {

            double saldoNuevo = cb.getSaldoActual() - retiro;

            cb.setSaldoActual((int) saldoNuevo);

        }



    }

    public int consultarSaldo(Cuenta cb) {

        return cb.getSaldoActual();

    }

    public void consultarDatos(Cuenta cb) {

        System.out.println("Tus datos a continuación");
        System.out.println("Número de cuenta: " + cb.getNumeroCuenta());
        System.out.println("DNI: " + cb.getDNI());
        System.out.println("Saldo Actual: $" + cb.getSaldoActual());

    }

}
