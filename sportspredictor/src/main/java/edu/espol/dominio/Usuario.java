package edu.espol.dominio;
public class Usuario {
public int procesarPronostico(Pronostico pronostico, String resultadoReal) {
Pronostico.ResultadoCalculoPuntos resultado =
pronostico.calcularPuntos(resultadoReal);
if (resultado.isAcertado()) {
this.agregarPuntos(resultado.getPuntos());
}
return resultado.getPuntos();
}
}
