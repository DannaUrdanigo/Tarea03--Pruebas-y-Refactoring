package edu.espol.Patrones.comportamentales;

import java.util.Map;

public class APIExternaBaloncestoAdapter extends APIExternaAdapterBase {
    
    public APIExternaBaloncestoAdapter(String apiKey) {
        super(apiKey, "Baloncesto");
    }
    
    @Override
    protected Map<String, Object> adaptarDatos(Map<String, Object> datosCrudos, String tipo) {
        Map<String, Object> datosAdaptados = crearMapaBase();
        
        if ("jugador".equals(tipo)) {
            datosAdaptados.put("idJugador", datosCrudos.get("player_id"));
            datosAdaptados.put("partidosJugados", datosCrudos.get("matches_played"));
            
            int goles = (int) datosCrudos.get("goals"); 
            int asistencias = (int) datosCrudos.get("assists");
            datosAdaptados.put("puntosPorPartido", goles * 2); 
            datosAdaptados.put("asistenciasPorPartido", asistencias);
            datosAdaptados.put("rebotes", goles / 2); 
        } 
        else if ("equipo".equals(tipo)) {
            datosAdaptados.put("idEquipo", datosCrudos.get("team_id"));
            datosAdaptados.put("victorias", datosCrudos.get("wins"));
            datosAdaptados.put("derrotas", datosCrudos.get("losses"));
            
            int golesFavor = (int) datosCrudos.get("goals_for");
            int golesContra = (int) datosCrudos.get("goals_against");
            datosAdaptados.put("puntosPorPartido", golesFavor * 2);
            datosAdaptados.put("puntosContraPorPartido", golesContra * 2);
            datosAdaptados.put("diferenciaPuntos", (golesFavor - golesContra) * 2);
        }
        
        return datosAdaptados;
    }
}