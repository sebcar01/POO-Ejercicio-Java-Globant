import java.text.DecimalFormat;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("#.##");
        double[] a = new double[50];

        arregloA(a, df);
        arregloB(a, df);

    }

    public static void arregloA(double[] array, DecimalFormat df) {
        int conteo = 0;

        System.out.println("Original");

        for (int i = 0; i <= 49; i++) {

            array[i] = Math.random() * 100;
            conteo += 1;

            if (conteo <= 9) {

                System.out.print(df.format(array[i]) + " ");

            } else {

                System.out.println(df.format(array[i]));
                conteo = 0;

            }

        }

        System.out.println("Ordenado");

        Arrays.sort(array);

        for (int i = 0; i <= 49; i++) {

            conteo += 1;

            if (conteo <= 9) {

                System.out.print(df.format(array[i]) + " ");

            } else {

                System.out.println(df.format(array[i]));
                conteo = 0;

            }

        }

    }

    public static void arregloB(double[] a, DecimalFormat df) {
        double[] b = Arrays.copyOf(a, 20);
        int conteo = 0;
        Arrays.fill(b , 10, 20, 0.5);

        System.out.println("---------------------------------------");

        for (int i = 0; i <= 19; i++) {

            conteo += 1;

            if (conteo <= 9) {

                System.out.print(df.format(b[i]) + " ");

            } else {

                System.out.println(df.format(b[i]));
                conteo = 0;

            }

        }



    }

}
