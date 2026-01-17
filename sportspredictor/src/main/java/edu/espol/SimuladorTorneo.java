package edu.espol;

import edu.espol.dominio.*;
import edu.espol.dominio.eventos.*;
import edu.espol.Patrones.creacionales.FabricaDeporte;
import java.util.Date;

public class SimuladorTorneo {
    
    public static EventoDeportivo[] crearEventosTorneo(FabricaDeporte[] fabricas, Date fecha) {
        EventoDeportivo[] eventos = new EventoDeportivo[fabricas.length];
        
        // Fútbol
        eventos[0] = fabricas[0].crearEvento("Barcelona vs Real Madrid", fecha);

        if(eventos[0] instanceof EventoFutbol) {
             ((EventoFutbol) eventos[0]).setDetalles("FC Barcelona", "Real Madrid", "Camp Nou");
        }

        // Baloncesto
        eventos[1] = fabricas[1].crearEvento("Lakers vs Warriors", fecha);
        if(eventos[1] instanceof EventoBaloncesto) {
            ((EventoBaloncesto) eventos[1]).setDetalles("LA Lakers", "GS Warriors", "Staples Center");
        }

        // Tenis
        eventos[2] = fabricas[2].crearEvento("Roland Garros Final", fecha);
        if(eventos[2] instanceof EventoTenis) {
            ((EventoTenis) eventos[2]).setDetalles("Rafael Nadal", "Novak Djokovic", "Court Philippe-Chatrier", "Arcilla");
        }

        return eventos;
    }
}