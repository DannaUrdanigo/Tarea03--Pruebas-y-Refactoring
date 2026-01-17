package edu.espol.Patrones.estructurales;

public class CanalSMS implements CanalNotificacion {
    @Override
    public void enviar(EventoDeportivo evento, String mensaje) {
        System.out.println("💬 Enviando SMS: " + mensaje);
        // Aquí iría la lógica de Twilio, etc.
    }

    @Override
    public String getNombreCanal() {
        return "SMS";
    }
}