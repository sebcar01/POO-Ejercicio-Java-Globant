package Servicios;

import Entidades.Cliente;
import java.util.ArrayList;
import java.util.Scanner;

public class ClienteServicio {
    
    Scanner input = new Scanner(System.in);
    ArrayList<Cliente> clientes = new ArrayList<>();
    
    public void registrarCliente() {
        
        System.out.println("Ingrese el ID:");
        int id = input.nextInt();
        input.nextLine();
        
        System.out.println("Ingrese el nombre:");
        String nombre = input.nextLine();
        
        System.out.println("Ingrese la edad:");
        int edad = input.nextInt();
        
        System.out.println("Ingrese la altura:");
        double altura = input.nextDouble();
        
        System.out.println("Ingrese el peso:");
        double peso = input.nextDouble();
        input.nextLine();
        
        System.out.println("Ingrese el objetivo");
        String objetivo = input.nextLine();
        
        Cliente clienteNuevo = new Cliente(id, nombre, edad, altura, peso, objetivo);
        clientes.add(clienteNuevo);
        
    }
    
    public void obtenerCliente() {
        
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(clientes.get(i));
        }
        
    }
    
    public int verificarCliente(int id) {
        
        int index = -1;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == id) {
                index = i;
            }
        }
        
        return index;
        
    }
    
    public void actualizarCliente() {
        
        System.out.println("Indique el ID a verificar:");
        int id = input.nextInt();
        input.nextLine();
        int index = verificarCliente(id);
        
        
        if (index >= 0) {
            
            Cliente clienteActualizar = clientes.get(index);
            
            System.out.println("Ingrese el nombre:");
            clienteActualizar.setNombre(input.nextLine());

            System.out.println("Ingrese la edad:");
            clienteActualizar.setEdad(input.nextInt());

            System.out.println("Ingrese la altura:");
            clienteActualizar.setAltura(input.nextDouble());

            System.out.println("Ingrese el peso:");
            clienteActualizar.setPeso(input.nextDouble());
            input.nextLine();

            System.out.println("Ingrese el objetivo");
            clienteActualizar.setObjetivo(input.nextLine());
            
            clientes.set(index, clienteActualizar);
            
        } else {
            System.out.println("No hay un cliente con ese ID.");
        }
        
    }
    
    public void eliminarCliente() {
        
        System.out.println("Indique el ID a verificar:");
        int id = input.nextInt();
        input.nextLine();
        int index = verificarCliente(id);
        
        if (index >= 0) {
            
            clientes.remove(index);
            
        } else {
            System.out.println("No hay un cliente con ese ID.");
        }
        
    }
    
    
    
}
