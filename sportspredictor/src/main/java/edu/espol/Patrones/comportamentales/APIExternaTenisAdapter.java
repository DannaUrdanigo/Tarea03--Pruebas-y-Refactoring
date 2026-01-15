package edu.espol.Patrones.comportamentales;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class APIExternaTenisAdapter implements FuenteEstadisticas {
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
        System.out.println("Adaptando estadísticas de tenis para jugador: " + jugadorId);
        
        Map<String, Object> rawData = apiCliente.getPlayerStats(jugadorId);
        return adaptarDatosTenis(rawData);
    }
    
    @Override
    public Map<String, Object> obtenerEstadisticasEquipo(String equipoId) {
        // En tenis no hay equipos, pero mantenemos la interfaz
        System.out.println("Tenis: No aplica estadísticas de equipo, retornando datos de jugador");
        return obtenerEstadisticasJugador(equipoId);
    }
    
    private Map<String, Object> adaptarDatosTenis(Map<String, Object> datosCrudos) {
        Map<String, Object> datosAdaptados = new HashMap<>();
        
        // Transformar para tenis
        if (datosCrudos.containsKey("player_id")) {
            datosAdaptados.put("idJugador", datosCrudos.get("player_id"));
            datosAdaptados.put("partidosJugados", datosCrudos.get("matches_played"));
            
            // Conversión específica para tenis
            int goles = (int) datosCrudos.get("goals");
            int asistencias = (int) datosCrudos.get("assists");
            
            // Estadísticas específicas de tenis
            datosAdaptados.put("acesPorPartido", goles % 20); // Ejemplo
            datosAdaptados.put("dobleFaltas", asistencias % 10);
            datosAdaptados.put("porcentajePrimerServicio", 60 + random.nextInt(20));
            datosAdaptados.put("puntosGanadosRed", goles % 30);
            datosAdaptados.put("deporte", "Tenis");
            
            // Ranking específico
            datosAdaptados.put("rankingATP", random.nextInt(100) + 1);
            datosAdaptados.put("titulos", random.nextInt(20));
        }
        
        // Agregar metadatos
        datosAdaptados.put("fuente", "API Tenis Adaptada");
        datosAdaptados.put("formato", "Sistema SportsPredictor");
        
        return datosAdaptados;
    }
}
