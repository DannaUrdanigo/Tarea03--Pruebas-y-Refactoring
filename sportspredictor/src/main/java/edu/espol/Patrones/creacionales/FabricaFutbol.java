package edu.espol.Patrones.creacionales;


import java.util.Date;

import edu.espol.dominio.CategoriaPronostico;
import edu.espol.dominio.Deporte;
import edu.espol.dominio.EventoDeportivo;
import edu.espol.dominio.eventos.EventoFutbol;

public class FabricaFutbol extends FabricaDeporte {
    
    public FabricaFutbol() {
        super(new Deporte("Fútbol", "FUT"));
    }
    
    @Override
    public EventoDeportivo crearEvento(String nombre, Date fecha) {
        // SOLID: La fábrica solo crea, no define la clase
        return new EventoFutbol(
            "EV-FUT-" + System.currentTimeMillis(),
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

    @Override
    public void configurarEvento(EventoDeportivo evento) {
        if (evento instanceof EventoFutbol) {
            EventoFutbol eventoFutbol = (EventoFutbol) evento;
            // Configuración específica de fútbol
            eventoFutbol.setDetalles("Equipo Local", "Equipo Visitante", "Estadio");
        }
    }
    
    private int calcularPuntuacionBase(String tipo) {
        switch (tipo) {
            case "Marcador Exacto": return 25;
            case "Ambas Marcas": return 15;
            case "Ganador": 
            default: return 10;
        }
    }
}