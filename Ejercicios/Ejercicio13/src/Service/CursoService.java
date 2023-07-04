package Service;

import Entidades.Curso;

import java.util.Scanner;

public class CursoService {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public String[] cargarAlumnos() {

        String[] arreglo = new String[5];

        for (int i = 0; i <= 4; i++) {

            System.out.println("Ingresa el nombre del alumno " + (i + 1));
            arreglo[i] = sc.next();

        }

        return arreglo;

    }
    public Curso crearCurso(){

        System.out.println("Ingresa el nombre del curso");
        String nombreCurso = sc.next();
        System.out.println("Ingresa las horas por día");
        int horasDias = sc.nextInt();
        System.out.println("Ingresa los días por semana");
        int diasSemana = sc.nextInt();
        System.out.println("Ingresa el turno");
        String turno = sc.next();
        System.out.println("Ingresa el precio por hora");
        double precio = sc.nextDouble();

        return new Curso(nombreCurso, horasDias, diasSemana, turno, precio, cargarAlumnos());

    }

    public void gananciaSemanal(Curso cr) {

        double gananciaDia = cr.getCantidadHorasPorDia() * cr.getPrecioPorHora();
        double gananciaSemana = gananciaDia * cr.getCantidadDiasPorSemana();
        double gananciaTotal = gananciaSemana * cr.getAlumnos().length;
        System.out.println("La ganancia semanal para el curso " + cr.getNombreCurso() + " es: " + gananciaTotal);

    }

}
