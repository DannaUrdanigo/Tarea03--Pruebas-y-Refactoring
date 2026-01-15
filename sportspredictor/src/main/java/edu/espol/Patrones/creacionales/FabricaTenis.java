package edu.espol.Patrones.creacionales;

import java.util.Date;

import edu.espol.dominio.CategoriaPronostico;
import edu.espol.dominio.Deporte;
import edu.espol.dominio.EventoDeportivo;
import edu.espol.dominio.eventos.EventoTenis;


public class FabricaTenis extends FabricaDeporte {
    
    public FabricaTenis() {
        super(new Deporte("Tenis", "TEN"));
    }
    
    @Override
    public EventoDeportivo crearEvento(String nombre, Date fecha) {
        return new EventoTenis(
            "EV-TEN-" + System.currentTimeMillis(),
            nombre,
            fecha,
            getDeporte()
        );
    }
    
    @Override
    public CategoriaPronostico crearCategoria(String nombre, String tipo) {
        int puntuacionBase = calcularPuntuacionBase(tipo);
        return new CategoriaPronostico(nombre, tipo, puntuacionBase);
    }
    
    
    public void configurarEvento(EventoDeportivo evento) {
        if (evento instanceof EventoTenis) {
            EventoTenis eventoTenis = (EventoTenis) evento;
            // Configuración específica de tenis
            eventoTenis.setDetalles("Jugador 1", "Jugador 2", "Cancha Central", "Arcilla");
        }
    }
    
    private int calcularPuntuacionBase(String tipo) {
        switch (tipo) {
            case "Resultado Exacto": return 30;
            case "Número de Sets": return 18;
            case "Ganador":
            default: return 12;
        }
    }
    
    public EventoDeportivo crearEventoTorneo(String nombreTorneo, Date fecha, String superficie) {
        EventoTenis evento = (EventoTenis) crearEvento(nombreTorneo, fecha);
        evento.setSuperficie(superficie);
        return evento;
    }
}

