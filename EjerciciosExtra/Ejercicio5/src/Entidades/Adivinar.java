package Entidades;

import java.util.Arrays;

public class Adivinar {

    private String[] meses;

    public Adivinar() {
    }

    public Adivinar(String[] meses) {
        this.meses = meses;
    }

    public String[] getMeses() {
        return meses;
    }

    public void setMeses(String[] meses) {
        this.meses = meses;
    }

    @Override
    public String toString() {
        return "Adivinar{" +
                "meses=" + Arrays.toString(meses) +
                '}';
    }
}
