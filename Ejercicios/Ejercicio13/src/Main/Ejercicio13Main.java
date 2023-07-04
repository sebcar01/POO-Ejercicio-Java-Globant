package Main;

import Entidades.Curso;
import Service.CursoService;

import java.util.Scanner;

public class Ejercicio13Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        CursoService cs = new CursoService();
        Curso c = cs.crearCurso();
        cs.gananciaSemanal(c);

    }

}
