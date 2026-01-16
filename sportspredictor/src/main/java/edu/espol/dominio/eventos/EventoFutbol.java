package edu.espol.dominio.eventos;

import edu.espol.dominio.DetallesPartido;
import edu.espol.dominio.EventoDeportivo;

public class EventoFutbol extends EventoDeportivo {
    private DetallesPartido detalles;

    public void setDetalles(DetallesPartido detalles) {
        this.detalles = detalles;
    }

    public String getDetallesPartido() {
        return detalles != null ? detalles.toString() : "Detalles no configurados";
    }

    // Refactorización 9: Implementación del método abstracto
    @Override
    public String obtenerDetallesParaDisplay() {
        return getDetallesPartido(); 
    }

    // Método de conveniencia
    public void setDetallesFutbol(String local, String visitante, String estadio) {
        this.detalles = DetallesPartido.paraFutbol(local, visitante, estadio);
    }
}
