package edu.espol.Patrones.creacionales;


import java.util.Date;

import edu.espol.dominio.CategoriaPronostico;
import edu.espol.dominio.Deporte;
import edu.espol.dominio.EventoDeportivo;
import edu.espol.dominio.eventos.EventoBaloncesto;

public class FabricaBaloncesto extends FabricaDeporte {
    
    public FabricaBaloncesto() {
        super(new Deporte("Baloncesto", "BAS"));
    }
    
    @Override
    public EventoDeportivo crearEvento(String nombre, Date fecha) {
        return new EventoBaloncesto(
            "EV-BAS-" + System.currentTimeMillis(),
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
        if (evento instanceof EventoBaloncesto) {
            EventoBaloncesto eventoBaloncesto = (EventoBaloncesto) evento;
            eventoBaloncesto.setDetalles("Equipo Local", "Equipo Visitante", "Pabellón");
        }
    }
    
    private int calcularPuntuacionBase(String tipo) {
        switch (tipo) {
            case "Diferencia Exacta": return 20;
            case "Over/Under": return 12;
            case "Ganador":
            default: return 8;
        }
    }
}
