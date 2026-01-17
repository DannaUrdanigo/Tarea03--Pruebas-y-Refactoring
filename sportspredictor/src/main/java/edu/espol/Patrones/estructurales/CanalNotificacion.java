package edu.espol.Patrones.estructurales;

import edu.espol.dominio.EventoDeportivo;

public interface CanalNotificacion {
    void enviar(EventoDeportivo evento, String mensaje);
    String getNombreCanal();
}