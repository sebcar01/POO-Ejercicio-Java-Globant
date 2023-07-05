package Entidades;

import java.time.LocalDate;

public class Alquiler {
    private boolean peliculaAlquilada;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double precio;

    public Alquiler() {
    }

    public Alquiler(boolean peliculaAlquilada, LocalDate fechaInicio, double precio) {
        this.peliculaAlquilada = peliculaAlquilada;
        this.fechaInicio = fechaInicio;
        this.precio = precio;
    }

    public Alquiler(int precio) {
        this.precio = precio;
    }

    public boolean getPeliculaAlquilada() {
        return peliculaAlquilada;
    }

    public void setPeliculaAlquilada(boolean peliculaAlquilada) {
        this.peliculaAlquilada = peliculaAlquilada;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Alquiler{" +
                "peliculaAlquilada='" + peliculaAlquilada + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", precio=" + precio +
                '}';
    }
}
