package Entidades;

public class Rutina {
    
    private int id;
    private String nombre;
    private double tiempo;
    private String dificultad;
    private String descripcion;

    public Rutina() {
    }

    public Rutina(int id, String nombre, double tiempo, String dificultad,
            String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.tiempo = tiempo;
        this.dificultad = dificultad;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Rutina{" + "id=" + id + ", nombre=" + nombre + ", tiempo=" + tiempo + ", dificultad=" + dificultad + ", descripcion=" + descripcion + '}';
    }
    
}
