package edu.espol.Patrones.creacionales;
import java.util.Date;

import edu.espol.dominio.CategoriaPronostico;
import edu.espol.dominio.Deporte;
import edu.espol.dominio.EventoDeportivo;

public abstract class FabricaDeporte {
    protected Deporte deporte;
    
    public FabricaDeporte(Deporte deporte) {
        this.deporte = deporte;
    }
    
    // Factory Method: Cada subclase implementa cómo crear el evento
    public abstract EventoDeportivo crearEvento(String nombre, Date fecha);
    
    public abstract CategoriaPronostico crearCategoria(String nombre, String tipo);
    
    // Método hook opcional
    public void configurarEvento(EventoDeportivo evento) {
        // Puede ser sobrescrito por subclases
    }
    
    public Deporte getDeporte() {
        return deporte;
    }
}