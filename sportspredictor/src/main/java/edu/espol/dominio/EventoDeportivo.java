package edu.espol.dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import edu.espol.Patrones.estructurales.Observador;
import edu.espol.Patrones.estructurales.SujetoObservable;

public abstract class EventoDeportivo implements SujetoObservable {
    protected String id;
    protected String nombre;
    protected Date fecha;
    protected EstadoEvento estado;
    protected Deporte deporte;
    protected List<Observador> observadores;
    
    public EventoDeportivo(String id, String nombre, Date fecha, Deporte deporte) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.deporte = deporte;
        this.estado = EstadoEvento.PROGRAMADO;
        this.observadores = new ArrayList<>();
    }
    
    public void registrarObservador(Observador observador) {
        observadores.add(observador);
    }
    
    public void eliminarObservador(Observador observador) {
        observadores.remove(observador);
    }
    
    public void notificarObservadores(String mensaje) {
        for (Observador observador : observadores) {
            observador.actualizar(this, mensaje);
        }
    }
    
    public void cambiarEstado(EstadoEvento nuevoEstado) {
        this.estado = nuevoEstado;
        String mensaje = "Estado cambiado a: " + nuevoEstado; 
        notificarObservadores(mensaje);
    }
    
    public void finalizar(String resultado) {
        this.estado = EstadoEvento.FINALIZADO;
        String mensaje = "Evento finalizado. Resultado: " + resultado;
        notificarObservadores(mensaje);
        System.out.println("Evento " + nombre + " finalizado.");
    }
    
    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public Date getFecha() { return fecha; }
    public EstadoEvento getEstado() { return estado; }
    public Deporte getDeporte() { return deporte; }
}