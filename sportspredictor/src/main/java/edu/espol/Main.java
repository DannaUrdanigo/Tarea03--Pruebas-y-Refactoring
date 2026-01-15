package edu.espol;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import edu.espol.Patrones.comportamentales.APIExternaBaloncestoAdapter;
import edu.espol.Patrones.comportamentales.APIExternaFutbolAdapter;
import edu.espol.Patrones.comportamentales.APIExternaTenisAdapter;
import edu.espol.Patrones.comportamentales.FuenteEstadisticas;
import edu.espol.Patrones.creacionales.FabricaBaloncesto;
import edu.espol.Patrones.creacionales.FabricaDeporte;
import edu.espol.Patrones.creacionales.FabricaFutbol;
import edu.espol.Patrones.creacionales.FabricaTenis;
import edu.espol.Patrones.estructurales.SistemaNotificaciones;
import edu.espol.dominio.EventoDeportivo;
import edu.espol.dominio.Pronostico;
import edu.espol.dominio.Usuario;
import edu.espol.dominio.eventos.EventoBaloncesto;
import edu.espol.dominio.eventos.EventoFutbol;
import edu.espol.dominio.eventos.EventoTenis;



public class Main {
    public static void main(String[] args) {
        System.out.println("=== SPORTSPREDICTOR ===");
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date fecha = new Date();
        
        System.out.println("=".repeat(50));
        
        // Crear las 3 fábricas
        FabricaDeporte fabricaFutbol = new FabricaFutbol();
        FabricaDeporte fabricaBaloncesto = new FabricaBaloncesto();
        FabricaDeporte fabricaTenis = new FabricaTenis();
        
        // Crear eventos para cada deporte
        EventoDeportivo[] eventos = new EventoDeportivo[3];
        
        // Fútbol
        eventos[0] = fabricaFutbol.crearEvento("Barcelona vs Real Madrid", fecha);
        fabricaFutbol.configurarEvento(eventos[0]);
        if (eventos[0] instanceof EventoFutbol) {
            ((EventoFutbol) eventos[0]).setDetalles("FC Barcelona", "Real Madrid", "Camp Nou");
        }
        
        // Baloncesto
        eventos[1] = fabricaBaloncesto.crearEvento("Lakers vs Warriors", fecha);
        fabricaBaloncesto.configurarEvento(eventos[1]);
        if (eventos[1] instanceof EventoBaloncesto) {
            ((EventoBaloncesto) eventos[1]).setDetalles("Los Angeles Lakers", "Golden State Warriors", "Staples Center");
        }
        
        // Tenis
        eventos[2] = fabricaTenis.crearEvento("Roland Garros Final", fecha);
        fabricaTenis.configurarEvento(eventos[2]);
        if (eventos[2] instanceof EventoTenis) {
            ((EventoTenis) eventos[2]).setDetalles("Rafael Nadal", "Novak Djokovic", "Court Philippe-Chatrier", "Arcilla");
        }
        
        // Mostrar eventos creados
        for (int i = 0; i < eventos.length; i++) {
            System.out.println("\nDeporte: " + eventos[i].getDeporte().getNombre());
            System.out.println("Evento: " + eventos[i].getNombre());
            System.out.println("Fecha: " + sdf.format(eventos[i].getFecha()));
            
            // Mostrar detalles específicos de cada tipo
            if (eventos[i] instanceof EventoFutbol) {
                EventoFutbol ef = (EventoFutbol) eventos[i];
                System.out.println("Detalles: " + ef.getDetallesPartido());
            } else if (eventos[i] instanceof EventoBaloncesto) {
                EventoBaloncesto eb = (EventoBaloncesto) eventos[i];
                System.out.println("Detalles: " + eb.getDetallesPartido());
            } else if (eventos[i] instanceof EventoTenis) {
                EventoTenis et = (EventoTenis) eventos[i];
                System.out.println("Detalles: " + et.getDetallesPartido());
            }
        }
        
        System.out.println("=".repeat(50));
        
        FuenteEstadisticas[] adapters = new FuenteEstadisticas[3];
        adapters[0] = new APIExternaFutbolAdapter("API_KEY_FUTBOL");
        adapters[1] = new APIExternaBaloncestoAdapter("API_KEY_BALONCESTO");
        adapters[2] = new APIExternaTenisAdapter("API_KEY_TENIS");
        
        String[] jugadores = {"MESSI_10", "LEBRON_23", "NADAL_1"};
        
        for (int i = 0; i < adapters.length; i++) {
            System.out.println("\nObteniendo estadísticas para " + jugadores[i] + ":");
            Map<String, Object> stats = adapters[i].obtenerEstadisticasJugador(jugadores[i]);
            
            System.out.println("Estadísticas obtenidas (" + stats.get("deporte") + "):");
            System.out.println("  - Fuente: " + stats.get("fuente"));
            System.out.println("  - Datos disponibles: " + stats.size() + " campos");
            
            // Mostrar algún dato específico
            if (stats.containsKey("rankingATP")) {
                System.out.println("  - Ranking ATP: " + stats.get("rankingATP"));
            }
            if (stats.containsKey("puntosPorPartido")) {
                System.out.println("  - Puntos por partido: " + stats.get("puntosPorPartido"));
            }
        }
        

        System.out.println("=".repeat(50));
        
        // Crear usuarios
        Usuario usuario1 = new Usuario("U001", "Carlos", "carlos@email.com");
        Usuario usuario2 = new Usuario("U002", "Ana", "ana@email.com");
        

        // Crear sistemas de notificación
        SistemaNotificaciones sistemaEmail = new SistemaNotificaciones("email");
        SistemaNotificaciones sistemaPush = new SistemaNotificaciones("push");
        
        System.out.println("\n=== Simulación detorneo con los 3 deportes ===");
        System.out.println("=".repeat(50));

        
        // Registrar observadores a todos los eventos
        for (EventoDeportivo evento : eventos) {
            evento.registrarObservador(usuario1);
            evento.registrarObservador(usuario2);
            evento.registrarObservador(sistemaEmail);
            evento.registrarObservador(sistemaPush);
           

            // Simular cambios de estado
            evento.cambiarEstado("EN CURSO");
            
            
            // Usuario realiza pronóstico
            Pronostico pronostico = usuario1.realizarPronostico(evento, "Victoria Local");
            System.out.println(usuario1.getNombre() + " pronosticó: " + pronostico.getPrediccion() + " para " + evento.getNombre());
            
            // Finalizar evento
            evento.finalizar("Victoria Local");
            
            // Validar pronóstico
            pronostico.calcularPuntos("Victoria Local");
        }
        
        System.out.println("=".repeat(50));
        System.out.println("=== RESUMEN FINAL ===");
        System.out.println("=".repeat(50));
        
        System.out.println("\nPuntos acumulados por " + usuario1.getNombre() + ":");
        System.out.println(" Total: " + usuario1.getPuntos() + " puntos");
        
        System.out.println("\nNotificaciones recibidas:");
        for (String notif : usuario1.getNotificaciones()) {
            System.out.println(notif);
        }
        
        System.out.println("\nEventos creados:");
        System.out.println("  1. Fútbol: " + ((EventoFutbol)eventos[0]).getDetallesPartido());
        System.out.println("  2. Baloncesto: " + ((EventoBaloncesto)eventos[1]).getDetallesPartido());
        System.out.println("  3. Tenis: " + ((EventoTenis)eventos[2]).getDetallesPartido());
        
        System.out.println("\n DEMOSTRACIÓN COMPLETADA - LOS 3 DEPORTES IMPLEMENTADOS");
    }
}