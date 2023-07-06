package Entidades;

import java.util.Arrays;

public class Ahorcado {

    private String[] palabraABuscar;
    private int encontradas;
    private int faltantes;
    private int intentos;

    public Ahorcado() {
    }

    public Ahorcado(String[] palabraABuscar, int encontradas, int faltantes, int intentos) {
        this.palabraABuscar = palabraABuscar;
        this.encontradas = encontradas;
        this.faltantes = faltantes;
        this.intentos = intentos;
    }

    public String[] getPalabraABuscar() {
        return palabraABuscar;
    }

    public void setPalabraABuscar(String[] palabraABuscar) {
        this.palabraABuscar = palabraABuscar;
    }

    public int getEncontradas() {
        return encontradas;
    }

    public void setEncontradas(int encontradas) {
        this.encontradas = encontradas;
    }

    public int getFaltantes() {
        return faltantes;
    }

    public void setFaltantes(int faltantes) {
        this.faltantes = faltantes;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    @Override
    public String toString() {
        return "Ahorcado{" +
                "palabraABuscar=" + Arrays.toString(palabraABuscar) +
                ", encontradas=" + encontradas +
                ", faltantes=" + faltantes +
                ", intentos=" + intentos +
                '}';
    }
}
