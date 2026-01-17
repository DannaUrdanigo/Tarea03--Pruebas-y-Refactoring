package edu.espol.Patrones.estructurales;

public class CanalEmail implements CanalNotificacion {
    @Override
    public void enviar(EventoDeportivo evento, String mensaje) {
        System.out.println("📧 Enviando Email: " + mensaje);
        // Aquí iría la lógica real de JavaMail, etc.
    }

    @Override
    public String getNombreCanal() {
        return "Email";
    }
}