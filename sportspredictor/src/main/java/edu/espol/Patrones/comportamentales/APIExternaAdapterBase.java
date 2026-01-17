package edu.espol.Patrones.comportamentales;

import java.util.HashMap;
import java.util.Map;

public abstract class APIExternaAdapterBase implements FuenteEstadisticas {
    protected ThirdPartyAPI apiCliente;
    protected String apiKey;
    protected String nombreDeporte;

    public APIExternaAdapterBase(String apiKey, String nombreDeporte) {
        this.apiKey = apiKey;
        this.nombreDeporte = nombreDeporte;
        this.apiCliente = new ThirdPartyAPI(apiKey);
    }

    @Override
    public Map<String, Object> obtenerEstadisticasJugador(String jugadorId) {
        System.out.println("Adaptando estadísticas de " + nombreDeporte + " para jugador: " + jugadorId);
        Map<String, Object> rawData = apiCliente.getPlayerStats(jugadorId);
        return adaptarDatos(rawData, "jugador");
    }

    @Override
    public Map<String, Object> obtenerEstadisticasEquipo(String equipoId) {
        System.out.println("Adaptando estadísticas de " + nombreDeporte + " para equipo: " + equipoId);
        Map<String, Object> rawData = apiCliente.getTeamStats(equipoId);
        return adaptarDatos(rawData, "equipo");
    }

    protected abstract Map<String, Object> adaptarDatos(Map<String, Object> datosCrudos, String tipo);

    protected Map<String, Object> crearMapaBase() {
        Map<String, Object> base = new HashMap<>();
        base.put("deporte", nombreDeporte);
        base.put("fuente", "API " + nombreDeporte + " Adaptada");
        base.put("formato", "Sistema SportsPredictor");
        return base;
    }
}