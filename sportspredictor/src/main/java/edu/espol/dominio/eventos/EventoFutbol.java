package edu.espol.dominio.eventos;

import java.util.Date;

import edu.espol.dominio.Deporte;
import edu.espol.dominio.EventoDeportivo;

public class EventoFutbol extends EventoDeportivo {
    private String equipoLocal;
    private String equipoVisitante;
    private String estadio;
    
    public EventoFutbol(String id, String nombre, Date fecha, Deporte deporte) {
        super(id, nombre, fecha, deporte);
    }
    
    public void setDetalles(String local, String visitante, String estadio) {
        this.equipoLocal = local;
        this.equipoVisitante = visitante;
        this.estadio = estadio;
    }
    
    public String getDetallesPartido() {
        return equipoLocal + " vs " + equipoVisitante + " en " + estadio;
    }
    
    // Métodos específicos de fútbol
    public String getEquipoLocal() { return equipoLocal; }
    public String getEquipoVisitante() { return equipoVisitante; }
    public String getEstadio() { return estadio; }
}
