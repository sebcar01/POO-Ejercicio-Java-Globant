package Servicios;


import Entidades.Rutina;
import java.util.ArrayList;
import java.util.Scanner;

public class RutinaServicio {
    
    Scanner input = new Scanner(System.in);
    ArrayList<Rutina> rutinas = new ArrayList<>();
    
    public void registrarRutina() {
        
        System.out.println("Ingrese el ID:");
        int id = input.nextInt();
        input.nextLine();
        
        System.out.println("Ingrese el nombre:");
        String nombre = input.nextLine();
        
        System.out.println("Ingrese la duración:");
        double tiempo = input.nextDouble();
        input.nextLine();
        
        System.out.println("Ingrese la dificultad:");
        String dificultad = input.nextLine();
        
        System.out.println("Ingrese la descripción:");
        String descripcion = input.nextLine();
        
        Rutina rutinaNueva = new Rutina(id, nombre, tiempo, dificultad, descripcion);
        rutinas.add(rutinaNueva);
        
    }
    
    public void obtenerRutina() {
        
        for (int i = 0; i < rutinas.size(); i++) {
            System.out.println(rutinas.get(i));
        }
        
    }
    
    public int verificarRutina(int id) {
        
        int index = -1;
        for (int i = 0; i < rutinas.size(); i++) {
            if (rutinas.get(i).getId() == id) {
                index = i;
            }
        }
        
        return index;
        
    }
    
    public void actualizarRutina() {
        
        System.out.println("Indique el ID a verificar:");
        int id = input.nextInt();
        input.nextLine();
        int index = verificarRutina(id);
        
        
        if (index >= 0) {
            
            Rutina rutinaActualizar = rutinas.get(index);

            System.out.println("Ingrese el nombre:");
            rutinaActualizar.setNombre(input.nextLine());

            System.out.println("Ingrese la duración:");
            rutinaActualizar.setTiempo(input.nextDouble());
            input.nextLine();

            System.out.println("Ingrese la dificultad:");
            rutinaActualizar.setDificultad(input.nextLine());

            System.out.println("Ingrese la descripción:");
            rutinaActualizar.setDescripcion(input.nextLine());

            rutinas.set(index, rutinaActualizar);
            
        } else {
            System.out.println("No hay una rutina con ese ID.");
        }
        
    }
    
    public void eliminarRutina() {
        
        System.out.println("Indique el ID a verificar:");
        int id = input.nextInt();
        input.nextLine();
        int index = verificarRutina(id);
        
        if (index >= 0) {
            
            rutinas.remove(index);
            
        } else {
            System.out.println("No hay una rutina con ese ID.");
        }
        
    }
    
}
