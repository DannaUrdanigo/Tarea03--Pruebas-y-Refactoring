package edu.espol;

import edu.espol.Patrones.creacionales.*;
import java.text.SimpleDateFormat;

public class ConfiguradorSistema {
    
    public static FabricaDeporte[] crearFabricasDeportes() {
        return new FabricaDeporte[] {
            new FabricaFutbol(),
            new FabricaBaloncesto(),
            new FabricaTenis()
        };
    }

    public static SimpleDateFormat obtenerFormatoFecha() {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm");
    }
}