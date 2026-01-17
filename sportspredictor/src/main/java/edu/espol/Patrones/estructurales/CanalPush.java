package edu.espol.Patrones.estructurales;

public class CanalPush implements CanalNotificacion {
    @Override
    public void enviar(EventoDeportivo evento, String mensaje) {
        System.out.println("📲 Enviando Push Notification: " + mensaje);
        // Aquí iría la lógica de Firebase/APNS
    }

    @Override
    public String getNombreCanal() {
        return "Push";
    }
}