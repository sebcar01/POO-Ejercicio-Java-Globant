package Entidades;
public class Mascota {

    private String nombre;
    private String apodo;
    private String tipo; // Perro, gato, loro, etc
    private String color;
    private String raza;
    private int edad;
    private boolean cola;
    private int energia;

    public Mascota() {

        energia = 1000;

    }
    public Mascota(String nombre, String apodo, String tipo){

        this.nombre = nombre;
        this.apodo = apodo;
        this.tipo = tipo;
        energia = 1000;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isCola() {
        return cola;
    }

    public void setCola(boolean cola) {
        this.cola = cola;
    }

    /**
     * Funcion que retorna la energia despues de N vueltas ingresadas por el usuario
     *
     * @param energiaRestar
     * @param vueltas
     * @return energia
     */

    public int pasear(int energiaRestar, int vueltas) {

        for (int i = 0; i <= vueltas; i++) {

            energia -= energiaRestar;

        }

        return energia;

    }

    @Override
    public String toString() {
        return "Mascota{" +
                "nombre='" + nombre + '\'' +
                ", apodo='" + apodo + '\'' +
                ", tipo='" + tipo + '\'' +
                ", color='" + color + '\'' +
                ", raza='" + raza + '\'' +
                ", edad=" + edad +
                ", cola=" + cola +
                ", energia=" + energia +
                '}';
    }
}
