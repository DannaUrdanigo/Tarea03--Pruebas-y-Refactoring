package edu.espol.Patrones.estructurales;

import edu.espol.dominio.EventoDeportivo;

public class SistemaNotificaciones implements Observador {
    private String canal;
    private int notificacionesEnviadas;
    
    public SistemaNotificaciones(String canal) {
        this.canal = canal;
        this.notificacionesEnviadas = 0;
    }
    
    @Override
    public void actualizar(EventoDeportivo evento, String mensaje) {
        notificacionesEnviadas++;
        String notificacionCompleta = "[" + canal.toUpperCase() + "] " + mensaje;
        
        System.out.println("Sistema de notificaciones (" + canal + "): " + notificacionCompleta + "\n");
        
        // Simular envío por diferentes canales
        switch (canal.toLowerCase()) {
            case "email":
                enviarEmail("usuario@sportspredictor.com", "Actualización de evento", notificacionCompleta+ "\n");
                break;
            case "push":
                enviarPush("device-token-123", "SportsPredictor", notificacionCompleta+ "\n");
                break;
            case "sms":
                enviarSMS("+593991234567", notificacionCompleta+ "\n");
                break;
        }
    }
    
    public void enviarEmail(String destinatario, String asunto, String cuerpo) {
        System.out.println("Email enviado a " + destinatario + ": " + asunto+ "\n" );
        // Lógica real de envío de email
    }
    
    public void enviarPush(String token, String titulo, String mensaje) {
        System.out.println("Push enviado a dispositivo " + token.substring(0, 10) + "...: " + titulo + "\n");
        // Lógica real de push notification
    }
    
    public void enviarSMS(String numero, String mensaje) {
        System.out.println("SMS enviado a " + numero + ": " + mensaje.substring(0, Math.min(20, mensaje.length())) + "..." + "\n");
        // Lógica real de SMS
    }
    
    public int getNotificacionesEnviadas() {
        return notificacionesEnviadas;
    }
    
    public String getCanal() {
        return canal;
    }
}