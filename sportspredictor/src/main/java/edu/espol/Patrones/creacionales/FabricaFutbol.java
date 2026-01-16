package edu.espol.Patrones.creacionales;

import edu.espol.dominio.ConstantesSistema;

public class FabricaFutbol extends FabricaDeporte {
    
    private int calcularPuntuacionBase(String tipo) {
        switch (tipo) {
            case "Marcador Exacto":
                return ConstantesSistema.PUNTOS_MARCADOR_EXACTO;
            case "Ambas Marcas":
                return ConstantesSistema.PUNTOS_AMBAS_MARCAS;
            case "Ganador":
            default:
                return ConstantesSistema.PUNTOS_GANADOR;
        }
    }
}
