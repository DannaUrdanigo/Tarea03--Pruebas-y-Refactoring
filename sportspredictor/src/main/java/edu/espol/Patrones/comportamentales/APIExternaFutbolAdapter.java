package edu.espol.Patrones.comportamentales;

import java.util.Map;

public class APIExternaFutbolAdapter extends APIExternaAdapterBase {
    
    public APIExternaFutbolAdapter(String apiKey) {
        super(apiKey, "Fútbol");
    }
    
    @Override
    protected Map<String, Object> adaptarDatos(Map<String, Object> datosCrudos, String tipo) {
        Map<String, Object> datosAdaptados = crearMapaBase();
        
        if ("jugador".equals(tipo)) {
            datosAdaptados.put("idJugador", datosCrudos.get("player_id"));
            datosAdaptados.put("partidosJugados", datosCrudos.get("matches_played"));
            datosAdaptados.put("goles", datosCrudos.get("goals"));
            datosAdaptados.put("asistencias", datosCrudos.get("assists"));
            datosAdaptados.put("calificacion", datosCrudos.get("rating"));
        } 
        else if ("equipo".equals(tipo)) {
            datosAdaptados.put("idEquipo", datosCrudos.get("team_id"));
            datosAdaptados.put("victorias", datosCrudos.get("wins"));
            datosAdaptados.put("derrotas", datosCrudos.get("losses"));
            datosAdaptados.put("empates", datosCrudos.get("draws"));
            datosAdaptados.put("golesFavor", datosCrudos.get("goals_for"));
            datosAdaptados.put("golesContra", datosCrudos.get("goals_against"));
        }
        
        return datosAdaptados;
    }
}