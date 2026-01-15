package edu.espol.Patrones.estructurales;
import edu.espol.dominio.EventoDeportivo;

public interface Observador {
    void actualizar(EventoDeportivo evento, String mensaje);
}