package edu.espol.dominio;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Estadistica {
    private String id;
    private String jugador;
    private String equipo;
    private Map<String, Object> datos;
    private Date fechaActualizacion;
    
    public Estadistica(String id, String jugador, String equipo) {
        this.id = id;
        this.jugador = jugador;
        this.equipo = equipo;
        this.datos = new HashMap<>();
        this.fechaActualizacion = new Date();
    }
    
    public Map<String, Object> getDatos() {
        return new HashMap<>(datos); // Retorna copia para proteger encapsulamiento
    }
    
    public void actualizarDatos(Map<String, Object> nuevosDatos) {
        this.datos.putAll(nuevosDatos);
        this.fechaActualizacion = new Date();
    }
    
    public void agregarDato(String clave, Object valor) {
        datos.put(clave, valor);
        fechaActualizacion = new Date();
    }
    
    // Getters
    public String getId() { return id; }
    public String getJugador() { return jugador; }
    public String getEquipo() { return equipo; }
    public Date getFechaActualizacion() { return fechaActualizacion; }
    
    @Override
    public String toString() {
        return "Estadística de " + jugador + " (" + equipo + "): " + datos.size() + " datos";
    }
}
