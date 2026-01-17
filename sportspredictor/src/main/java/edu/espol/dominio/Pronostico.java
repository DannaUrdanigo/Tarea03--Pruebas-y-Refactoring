package edu.espol.dominio;

import java.util.Date;

public class Pronostico {
    private String id;
    private Usuario usuario;
    private EventoDeportivo evento;
    private String prediccion;
    private EstadoPronostico estado;
    private Date fechaCreacion;
    
    public Pronostico(String id, Usuario usuario, EventoDeportivo evento, String prediccion) {
        this.id = id;
        this.usuario = usuario;
        this.evento = evento;
        this.prediccion = prediccion;
        this.estado = EstadoPronostico.PENDIENTE;
        this.fechaCreacion = new Date();
        
        evento.registrarObservador(usuario);
    }
    
    public int calcularPuntos(String resultadoReal) {
        if (prediccion.equals(resultadoReal)) {
            this.estado = EstadoPronostico.ACERTADO;
            int puntos = 10; 
            usuario.agregarPuntos(puntos);
            return puntos;
        } else {
            this.estado = EstadoPronostico.FALLIDO;
            return 0;
        }
    }
    
    public void cambiarEstado(EstadoPronostico nuevoEstado) {
        this.estado = nuevoEstado;
    }
    
    public boolean validar(String resultadoReal) {
        return prediccion.equals(resultadoReal);
    }
    
    public String getId() { return id; }
    public Usuario getUsuario() { return usuario; }
    public EventoDeportivo getEvento() { return evento; }
    public String getPrediccion() { return prediccion; }
    public EstadoPronostico getEstado() { return estado; }
    public Date getFechaCreacion() { return fechaCreacion; }
}