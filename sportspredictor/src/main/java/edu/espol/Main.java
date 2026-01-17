package edu.espol;

import java.util.Date;
import edu.espol.Patrones.creacionales.FabricaDeporte;
import edu.espol.dominio.EventoDeportivo;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SPORTSPREDICTOR ===");
        
        FabricaDeporte[] fabricas = ConfiguradorSistema.crearFabricasDeportes();
        
        Date fecha = new Date();
        EventoDeportivo[] eventos = SimuladorTorneo.crearEventosTorneo(fabricas, fecha);
        
        System.out.println("Simulación inicializada correctamente.");
    }
}