package edu.espol.dominio.eventos;

import java.util.Date;

import edu.espol.dominio.Deporte;
import edu.espol.dominio.EventoDeportivo;

public class EventoTenis extends EventoDeportivo {
    private String jugador1;
    private String jugador2;
    private String cancha;
    private String superficie; // césped, arcilla, dura
    
    public EventoTenis(String id, String nombre, Date fecha, Deporte deporte) {
        super(id, nombre, fecha, deporte);
    }
    
    public void setDetalles(String jugador1, String jugador2, String cancha, String superficie) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.cancha = cancha;
        this.superficie = superficie;
    }
    
    public String getDetallesPartido() {
        return jugador1 + " vs " + jugador2 + " en " + cancha + " (" + superficie + ")";
    }
    
    // Métodos específicos de tenis
    public String getJugador1() { return jugador1; }
    public String getJugador2() { return jugador2; }
    public String getCancha() { return cancha; }
    public String getSuperficie() { return superficie; }
    
    public void setSuperficie(String superficie) {
        this.superficie = superficie;
    }
}
