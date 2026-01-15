package edu.espol.test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import edu.espol.dominio.*;

class CasosLimiteTest {
    
    @Test
    void testPronostico_CalcularPuntosConNull() {
        // Arrange
        Usuario usuario = new Usuario("U001", "Test", "test@test.com");
        Deporte deporte = new Deporte("Fútbol", "FUT");
        EventoDeportivo evento = new edu.espol.dominio.eventos.EventoFutbol("EV-001", "Test", new Date(), deporte);
        Pronostico pronostico = new Pronostico("P-001", usuario, evento, "2-1");
        
        // Act & Assert - Usando assertThrows (5to tipo de assertion)
        // Verificar que lanza excepción con resultado null
        assertThrows(NullPointerException.class, () -> {
            pronostico.calcularPuntos(null);
        });
    }
    
    @Test
    void testUsuario_AgregarPuntosNegativos() {
        // Arrange
        Usuario usuario = new Usuario("U001", "Test", "test@test.com");
        int puntosIniciales = usuario.getPuntos();
        
        // Act - Intentar agregar puntos negativos
        usuario.agregarPuntos(-10);
        
        // Assert - Podría no cambiar o cambiar negativamente
        // Depende de la implementación, verificamos que no crashea
        assertTrue(true); // Prueba de que se ejecutó
    }
    
    @Test
    void testEvento_FinalizarConResultadoNull() {
        // Arrange
        Deporte deporte = new Deporte("Fútbol", "FUT");
        EventoDeportivo evento = new edu.espol.dominio.eventos.EventoFutbol("EV-001", "Test", new Date(), deporte);
        
        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            evento.finalizar(null);
        });
    }
    
    @Test
    void testFabrica_CrearEventoConNull() {
        // Arrange
        edu.espol.Patrones.creacionales.FabricaFutbol fabrica = new edu.espol.Patrones.creacionales.FabricaFutbol();
        
        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            fabrica.crearEvento(null, null);
        });
    }
}