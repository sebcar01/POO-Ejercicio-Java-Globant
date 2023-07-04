package Entidades;

import java.time.LocalDate;

public class Persona {

    private String nombre;
    private LocalDate fechaDeNacimiento;

    public Persona() {
    }

    public Persona(String nombre, LocalDate fechaDeNacimiento) {
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", fechaDeNacimiento=" + fechaDeNacimiento +
                '}';
    }
}
