package edu.espol.Patrones.estructurales;

import edu.espol.dominio.EventoDeportivo;
import java.util.ArrayList;
import java.util.List;

public class SistemaNotificaciones implements Observador {
    private List<CanalNotificacion> canales;
    private int notificacionesEnviadas;
    
    public SistemaNotificaciones() {
        this.canales = new ArrayList<>();
        this.notificacionesEnviadas = 0;
    }
    
    // Método para agregar canales dinámicamente (Open/Closed Principle)
    public void agregarCanal(CanalNotificacion canal) {
        canales.add(canal);
    }
    
    @Override
    public void actualizar(EventoDeportivo evento, String mensaje) {
        notificacionesEnviadas++;
        String notificacionCompleta = "[" + evento.getNombre() + "] " + mensaje;
        
        // POLIMORFISMO: Ya no hay switch. Cada canal sabe cómo enviarse.
        for (CanalNotificacion canal : canales) {
            canal.enviar(evento, notificacionCompleta);
        }
    }
    
    // Método Factory estático para crear un sistema configurado por defecto
    public static SistemaNotificaciones crearSistemaCompleto() {
        SistemaNotificaciones sistema = new SistemaNotificaciones();
        sistema.agregarCanal(new CanalEmail());
        sistema.agregarCanal(new CanalPush());
        sistema.agregarCanal(new CanalSMS());
        return sistema;
    }

    public int getNotificacionesEnviadas() {
        return notificacionesEnviadas;
    }
}