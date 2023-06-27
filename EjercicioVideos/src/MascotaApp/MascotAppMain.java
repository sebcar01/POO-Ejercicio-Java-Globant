package MascotaApp;

import Service.MascotaService;

public class MascotAppMain {

    public static void main(String[] args) {

        MascotaService m1 = new MascotaService();
        System.out.println(m1.crearMascota());

    }

}
