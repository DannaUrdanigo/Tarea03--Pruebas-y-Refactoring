package edu.espol.dominio.eventos;

import java.util.Date;

import edu.espol.dominio.Deporte;
import edu.espol.dominio.EventoDeportivo;

public class EventoBaloncesto extends EventoDeportivo {
    private String equipoLocal;
    private String equipoVisitante;
    private String pabellon;
    
    public EventoBaloncesto(String id, String nombre, Date fecha, Deporte deporte) {
        super(id, nombre, fecha, deporte);
    }
    
    public void setDetalles(String local, String visitante, String pabellon) {
        this.equipoLocal = local;
        this.equipoVisitante = visitante;
        this.pabellon = pabellon;
    }
    
    public String getDetallesPartido() {
        return equipoLocal + " vs " + equipoVisitante + " en " + pabellon;
    }
    
    // Métodos específicos de baloncesto
    public String getEquipoLocal() { return equipoLocal; }
    public String getEquipoVisitante() { return equipoVisitante; }
    public String getPabellon() { return pabellon; }
}
