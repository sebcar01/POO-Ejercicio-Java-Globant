package Entidad;
public class Persona {

    public String nombre;

    public int edad;
    private String genero;

    public Persona() {
    }

    public Persona(String nombre, int edad, String genero) {

        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}

