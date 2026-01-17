package edu.espol.Patrones.comportamentales;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class APIExternaTenisAdapter implements FuenteEstadisticasDeporte {
    private ThirdPartyAPI apiCliente;
    private String apiKey;
    private Random random;
    
    public APIExternaTenisAdapter(String apiKey) {
        this.apiKey = apiKey;
        this.apiCliente = new ThirdPartyAPI(apiKey);
        this.random = new Random();
    }
    
    @Override
    public Map<String, Object> obtenerEstadisticasJugador(String jugadorId) {
        // Mantenemos la lógica del jugador porque el tenis SÍ tiene jugadores
        Map<String, Object> rawData = apiCliente.getPlayerStats(jugadorId);
        return adaptarDatosTenis(rawData);
    }

    @Override
    public boolean soportaEstadisticasEquipo() {
        return false; // Aquí aplicas la Refactorización 10
    }
    
    // No implementas obtenerEstadisticasEquipo() -> Se usa el default de la interfaz

    private Map<String, Object> adaptarDatosTenis(Map<String, Object> datosCrudos) {
        // ... aquí va toda tu lógica de HashMap que ya tenías ...
        Map<String, Object> datosAdaptados = new HashMap<>();
        // (Mantén el resto de tu lógica de transformación de datos aquí)
        return datosAdaptados;
    }
}
