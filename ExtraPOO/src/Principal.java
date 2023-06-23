import Entidad.Figura;
import Servicios.FiguraService;

public class Principal {

    public static void main(String[] args) {

        Figura fig1 = new Figura();
        FiguraService figServicio = new FiguraService();

        fig1 = figServicio.crearFigura();

        switch (fig1.getTipo()) {

            case "cuadrado" -> figServicio.cuadrado();
            case "rectangulo" -> figServicio.rectangulo();
            case "triangulo" -> figServicio.triangulo();
            case "circulo" -> figServicio.circulo();
            case "hexagono" -> figServicio.hexagono();
            case "pentagono" -> figServicio.pentagono();
            case "rombo" -> figServicio.rombo();
            default -> System.out.println("Valor invalido");

        }

    }

}
