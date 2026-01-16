package edu.espol.dominio;

public class Pronostico {
    // Asegúrate de tener definidos los atributos prediccion, estado y usuario
    
    public int calcularPuntos(String resultadoReal) {
        if (prediccion.equals(resultadoReal)) {
            this.estado = EstadoPronostico.ACERTADO; // Usa el Enum de la Refactor 3
            int puntos = ConstantesSistema.PUNTOS_BASE_ACIERTO; // Refactor 7: Sin números mágicos
            usuario.agregarPuntos(puntos);
            return puntos;
        } else {
            this.estado = EstadoPronostico.FALLIDO;
            return 0;
        }
    }
}
