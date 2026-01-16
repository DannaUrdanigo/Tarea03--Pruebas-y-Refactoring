package edu.espol.dominio;
public class Pronostico {
public ResultadoCalculoPuntos calcularPuntos(String resultadoReal) {
boolean acerto = prediccion.equals(resultadoReal);
if (acerto) {
this.estado = EstadoPronostico.ACERTADO;
} else {
this.estado = EstadoPronostico.FALLIDO;
}
return new ResultadoCalculoPuntos(acerto,
acerto ? ConstantesSistema.PUNTOS_BASE_ACIERTO : 0);
}
// Clase interna para resultado
public static class ResultadoCalculoPuntos {
private final boolean acertado;
private final int puntos;
public ResultadoCalculoPuntos(boolean acertado, int puntos) {
this.acertado = acertado;
this.puntos = puntos;
}
public boolean isAcertado() { return acertado; }
public int getPuntos() { return puntos; }
}
}
