package edu.espol.Patrones.comportamentales;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ThirdPartyAPI {
    private String apiKey;
    private Random random;
    
    public ThirdPartyAPI(String apiKey) {
        this.apiKey = apiKey;
        this.random = new Random();
    }
    
    // Método de API externa con formato específico
    public Map<String, Object> getPlayerStats(String playerId) {
        // Simulando llamada a API externa
        System.out.println("Llamando a API externa para estadísticas de jugador: " + playerId);
        
        Map<String, Object> rawData = new HashMap<>();
        rawData.put("player_id", playerId);
        rawData.put("matches_played", random.nextInt(50));
        rawData.put("goals", random.nextInt(30));
        rawData.put("assists", random.nextInt(20));
        rawData.put("rating", 6.5 + random.nextDouble() * 3.5);
        
        return rawData;
    }
    
    // Otro método con formato diferente
    public Map<String, Object> getTeamStats(String teamId) {
        System.out.println("Llamando a API externa para estadísticas de equipo: " + teamId);
        
        Map<String, Object> rawData = new HashMap<>();
        rawData.put("team_id", teamId);
        rawData.put("wins", random.nextInt(20));
        rawData.put("losses", random.nextInt(20));
        rawData.put("draws", random.nextInt(10));
        rawData.put("goals_for", random.nextInt(60));
        rawData.put("goals_against", random.nextInt(40));
        
        return rawData;
    }
    
    public boolean authenticate() {
        return apiKey != null && !apiKey.isEmpty();
    }
}
