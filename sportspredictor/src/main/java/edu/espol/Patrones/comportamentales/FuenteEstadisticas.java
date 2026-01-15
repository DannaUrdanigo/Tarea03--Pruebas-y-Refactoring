package edu.espol.Patrones.comportamentales;

import java.util.Map;

public interface FuenteEstadisticas {
    Map<String, Object> obtenerEstadisticasJugador(String jugadorId);
    Map<String, Object> obtenerEstadisticasEquipo(String equipoId);
}
