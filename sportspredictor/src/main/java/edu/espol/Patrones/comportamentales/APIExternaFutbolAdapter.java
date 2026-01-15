package edu.espol.Patrones.comportamentales;


import java.util.HashMap;
import java.util.Map;

public class APIExternaFutbolAdapter implements FuenteEstadisticas {
    private ThirdPartyAPI apiCliente;
    private String apiKey;
    
    public APIExternaFutbolAdapter(String apiKey) {
        this.apiKey = apiKey;
        this.apiCliente = new ThirdPartyAPI(apiKey);
    }
    
    @Override
    public Map<String, Object> obtenerEstadisticasJugador(String jugadorId) {
        System.out.println("Adaptando estadísticas de fútbol para jugador: " + jugadorId);
        
        // Obtener datos crudos de la API externa
        Map<String, Object> rawData = apiCliente.getPlayerStats(jugadorId);
        
        // Adaptar al formato interno del sistema
        return adaptarDatosFutbol(rawData);
    }
    
    @Override
    public Map<String, Object> obtenerEstadisticasEquipo(String equipoId) {
        System.out.println("Adaptando estadísticas de fútbol para equipo: " + equipoId);
        
        Map<String, Object> rawData = apiCliente.getTeamStats(equipoId);
        return adaptarDatosFutbol(rawData);
    }
    
    private Map<String, Object> adaptarDatosFutbol(Map<String, Object> datosCrudos) {
        Map<String, Object> datosAdaptados = new HashMap<>();
        
        // Transformar nombres de campos al formato interno
        if (datosCrudos.containsKey("player_id")) {
            datosAdaptados.put("idJugador", datosCrudos.get("player_id"));
            datosAdaptados.put("partidosJugados", datosCrudos.get("matches_played"));
            datosAdaptados.put("goles", datosCrudos.get("goals"));
            datosAdaptados.put("asistencias", datosCrudos.get("assists"));
            datosAdaptados.put("calificacion", datosCrudos.get("rating"));
            datosAdaptados.put("deporte", "Fútbol");
        } 
        else if (datosCrudos.containsKey("team_id")) {
            datosAdaptados.put("idEquipo", datosCrudos.get("team_id"));
            datosAdaptados.put("victorias", datosCrudos.get("wins"));
            datosAdaptados.put("derrotas", datosCrudos.get("losses"));
            datosAdaptados.put("empates", datosCrudos.get("draws"));
            datosAdaptados.put("golesFavor", datosCrudos.get("goals_for"));
            datosAdaptados.put("golesContra", datosCrudos.get("goals_against"));
            datosAdaptados.put("deporte", "Fútbol");
        }
        
        // Agregar metadatos de adaptación
        datosAdaptados.put("fuente", "API Externa Adaptada");
        datosAdaptados.put("formato", "Sistema SportsPredictor");
        
        return datosAdaptados;
    }
}