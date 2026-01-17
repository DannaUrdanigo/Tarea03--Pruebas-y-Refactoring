package edu.espol.Patrones.comportamentales;

import java.util.Map;
import java.util.Random;

public class APIExternaTenisAdapter extends APIExternaAdapterBase {
    private Random random;
    
    public APIExternaTenisAdapter(String apiKey) {
        super(apiKey, "Tenis");
        this.random = new Random();
    }
    
    @Override
    protected Map<String, Object> adaptarDatos(Map<String, Object> datosCrudos, String tipo) {
        Map<String, Object> datosAdaptados = crearMapaBase();
        
        if ("jugador".equals(tipo)) {
            datosAdaptados.put("idJugador", datosCrudos.get("player_id"));
            datosAdaptados.put("partidosJugados", datosCrudos.get("matches_played"));
            
            int goles = (int) datosCrudos.get("goals");
            int asistencias = (int) datosCrudos.get("assists");
            
            datosAdaptados.put("acesPorPartido", goles % 20);
            datosAdaptados.put("dobleFaltas", asistencias % 10);
            datosAdaptados.put("porcentajePrimerServicio", 60 + random.nextInt(20));
            datosAdaptados.put("puntosGanadosRed", goles % 30);
            datosAdaptados.put("rankingATP", random.nextInt(100) + 1);
            datosAdaptados.put("titulos", random.nextInt(20));
        }
        
        return datosAdaptados;
    }
}