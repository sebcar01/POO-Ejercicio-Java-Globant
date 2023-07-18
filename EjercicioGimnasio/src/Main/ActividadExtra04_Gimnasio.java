package actividadextra04_gimnasio;

import Servicios.ClienteServicio;
import Servicios.RutinaServicio;

public class ActividadExtra04_Gimnasio {

    
    public static void main(String[] args) {
        
        ClienteServicio servCliente = new ClienteServicio();
        RutinaServicio servRutina = new RutinaServicio();
        
        // CLIENTES
        
        // Crear cliente #1
        servCliente.registrarCliente();
        // Crear cliente #2
        servCliente.registrarCliente();
        servCliente.obtenerCliente();
        servCliente.actualizarCliente();
        servCliente.obtenerCliente();
        servCliente.eliminarCliente();
        servCliente.obtenerCliente();
        
        
//        // RUTINAS
//        
//        // Crear cliente #1
//        servRutina.registrarRutina();
//        // Crear cliente #2
//        servRutina.registrarRutina();
//        servRutina.obtenerRutina();
//        servRutina.actualizarRutina();
//        servRutina.obtenerRutina();
//        servRutina.eliminarRutina();
//        servRutina.obtenerRutina();
        
    }
    
}
