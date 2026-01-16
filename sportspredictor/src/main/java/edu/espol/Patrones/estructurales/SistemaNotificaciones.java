package edu.espol.Patrones.estructurales;
import edu.espol.dominio.EventoDeportivo;
import java.util.ArrayList;
import java.util.List;
public class SistemaNotificaciones implements Observador {
private List<CanalNotificacion> canales;
private int notificacionesEnviadas;
public SistemaNotificaciones() {
this.canales = new ArrayList<>();
this.notificacionesEnviadas = 0;
}
public void agregarCanal(CanalNotificacion canal) {
canales.add(canal);
}
@Override
public void actualizar(EventoDeportivo evento, String mensaje) {
notificacionesEnviadas++;
String notificacionCompleta = "[" + evento.getNombre() + "] " + mensaje;
for (CanalNotificacion canal : canales) {
canal.enviar(evento, notificacionCompleta);
}
}
// Método para configuración común
public static SistemaNotificaciones crearSistemaCompleto() {
SistemaNotificaciones sistema = new SistemaNotificaciones();
sistema.agregarCanal(new CanalEmail());
sistema.agregarCanal(new CanalPush());
sistema.agregarCanal(new CanalSMS());
return sistema;
}
}
