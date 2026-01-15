package edu.espol.Patrones.comportamentales;


import java.util.HashMap;
import java.util.Map;

public class APIExternaBaloncestoAdapter implements FuenteEstadisticas {
    private ThirdPartyAPI apiCliente;
    private String apiKey;
    
    public APIExternaBaloncestoAdapter(String apiKey) {
        this.apiKey = apiKey;
        this.apiCliente = new ThirdPartyAPI(apiKey);
    }
    
    @Override
    public Map<String, Object> obtenerEstadisticasJugador(String jugadorId) {
        System.out.println("Adaptando estadísticas de baloncesto para jugador: " + jugadorId);
        
        Map<String, Object> rawData = apiCliente.getPlayerStats(jugadorId);
        return adaptarDatosBaloncesto(rawData);
    }
    
    @Override
    public Map<String, Object> obtenerEstadisticasEquipo(String equipoId) {
        System.out.println("Adaptando estadísticas de baloncesto para equipo: " + equipoId);
        
        Map<String, Object> rawData = apiCliente.getTeamStats(equipoId);
        return adaptarDatosBaloncesto(rawData);
    }
    
    private Map<String, Object> adaptarDatosBaloncesto(Map<String, Object> datosCrudos) {
        Map<String, Object> datosAdaptados = new HashMap<>();
        
        // Transformar para baloncesto
        if (datosCrudos.containsKey("player_id")) {
            datosAdaptados.put("idJugador", datosCrudos.get("player_id"));
            datosAdaptados.put("partidosJugados", datosCrudos.get("matches_played"));
            // Conversión específica para baloncesto
            int goles = (int) datosCrudos.get("goals");
            int asistencias = (int) datosCrudos.get("assists");
            datosAdaptados.put("puntosPorPartido", goles * 2); // Asumiendo goles = canastas
            datosAdaptados.put("asistenciasPorPartido", asistencias);
            datosAdaptados.put("rebotes", goles / 2); // Estimación
            datosAdaptados.put("deporte", "Baloncesto");
        } 
        else if (datosCrudos.containsKey("team_id")) {
            datosAdaptados.put("idEquipo", datosCrudos.get("team_id"));
            datosAdaptados.put("victorias", datosCrudos.get("wins"));
            datosAdaptados.put("derrotas", datosCrudos.get("losses"));
            // Conversión para baloncesto
            int golesFavor = (int) datosCrudos.get("goals_for");
            int golesContra = (int) datosCrudos.get("goals_against");
            datosAdaptados.put("puntosPorPartido", golesFavor * 2);
            datosAdaptados.put("puntosContraPorPartido", golesContra * 2);
            datosAdaptados.put("diferenciaPuntos", (golesFavor - golesContra) * 2);
            datosAdaptados.put("deporte", "Baloncesto");
        }
        
        // Agregar metadatos
        datosAdaptados.put("fuente", "API Baloncesto Adaptada");
        datosAdaptados.put("formato", "Sistema SportsPredictor");
        
        return datosAdaptados;
    }
}