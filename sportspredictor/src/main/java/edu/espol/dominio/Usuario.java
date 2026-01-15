package edu.espol.dominio;

import java.util.ArrayList;
import java.util.List;

import edu.espol.Patrones.estructurales.Observador;

public class Usuario implements Observador {
    private String id;
    private String nombre;
    private String email;
    private int puntos;
    private List<Pronostico> historialPronosticos;
    private List<String> notificaciones;

    public Usuario(String id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.puntos = 0;
        this.historialPronosticos = new ArrayList<>();
        this.notificaciones = new ArrayList<>();
    }

    // Factory Method: Usuario crea pronósticos
    public Pronostico realizarPronostico(EventoDeportivo evento, String prediccion) {
        Pronostico pronostico = new Pronostico(
            "PRON-" + System.currentTimeMillis(),
            this,
            evento,
            prediccion
        );
        historialPronosticos.add(pronostico);
        return pronostico;
    }

    // Observer Pattern: Recibe actualizaciones
    public void actualizar(EventoDeportivo evento, String mensaje) {
        String notificacion = "[" + evento.getNombre() + "] " + mensaje;
        notificaciones.add(notificacion);
        System.out.println("Usuario " + nombre + " notificado: " + notificacion+ "\n");
    }

    public void agregarPuntos(int cantidad) {
        this.puntos += cantidad;
        System.out.println(nombre + " ganó " + cantidad + " puntos. Total: " + puntos+ "\n");
    }

    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public int getPuntos() { return puntos; }
    public List<Pronostico> getHistorialPronosticos() { return historialPronosticos; }
    public List<String> getNotificaciones() { return notificaciones; }
}