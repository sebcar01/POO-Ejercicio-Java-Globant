package Main;

import Entidades.Circunferencia;
import Service.CircunferenciaService;

public class Main {

    public static void main(String[] args) {

        CircunferenciaService circunferenciaSvs = new CircunferenciaService();
        Circunferencia c1 = circunferenciaSvs.crearCircunferencia();

        System.out.println("El área de la circunferencia es: " + circunferenciaSvs.area(c1));

        System.out.println("El perímetro de la circunferencia es: " + circunferenciaSvs.perimetro(c1));

    }

}
