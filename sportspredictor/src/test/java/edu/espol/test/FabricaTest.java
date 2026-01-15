package edu.espol.test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import edu.espol.dominio.*;
import edu.espol.dominio.eventos.*;
import edu.espol.Patrones.creacionales.*;

class FabricaTest {
    private FabricaFutbol fabricaFutbol;
    private FabricaBaloncesto fabricaBaloncesto;
    private FabricaTenis fabricaTenis;
    private Date fecha;
    
    @BeforeEach
    void setUp() {
        fabricaFutbol = new FabricaFutbol();
        fabricaBaloncesto = new FabricaBaloncesto();
        fabricaTenis = new FabricaTenis();
        fecha = new Date();
    }
    
    @Test
    void testFabricaFutbol_CrearEvento() {
        // Act
        EventoDeportivo evento = fabricaFutbol.crearEvento("Clásico", fecha);
        
        // Assert
        assertNotNull(evento);
        assertTrue(evento instanceof EventoFutbol);
        assertEquals("Fútbol", evento.getDeporte().getNombre());
        assertTrue(evento.getId().startsWith("EV-FUT-"));
    }
    
    @Test
    void testFabricaFutbol_CrearCategoria() {
        // Act
        CategoriaPronostico categoria = fabricaFutbol.crearCategoria("Marcador Exacto", "Marcador Exacto");
        
        // Assert
        assertNotNull(categoria);
        assertEquals("Marcador Exacto", categoria.getNombre());
        assertEquals("Marcador Exacto", categoria.getTipo());
        assertEquals(25, categoria.getPuntuacionBase());
    }
    
    @Test
    void testFabricaBaloncesto_CrearEvento() {
        // Act
        EventoDeportivo evento = fabricaBaloncesto.crearEvento("NBA Final", fecha);
        
        // Assert
        assertNotNull(evento);
        assertTrue(evento instanceof EventoBaloncesto);
        assertEquals("Baloncesto", evento.getDeporte().getNombre());
    }
    
    @Test
    void testFabricaTenis_CrearEvento() {
        // Act
        EventoDeportivo evento = fabricaTenis.crearEvento("Wimbledon", fecha);
        
        // Assert
        assertNotNull(evento);
        assertTrue(evento instanceof EventoTenis);
        assertEquals("Tenis", evento.getDeporte().getNombre());
    }
    
    @Test
    void testFabricaTenis_CrearEventoTorneo() {
        // Act
        EventoDeportivo evento = fabricaTenis.crearEventoTorneo("Roland Garros", fecha, "Arcilla");
        
        // Assert
        assertNotNull(evento);
        assertTrue(evento instanceof EventoTenis);
        EventoTenis eventoTenis = (EventoTenis) evento;
        assertEquals("Arcilla", eventoTenis.getSuperficie());
    }
    
    @Test
    void testConfigurarEvento() {
        // Arrange
        EventoDeportivo eventoFutbol = fabricaFutbol.crearEvento("Test", fecha);
        EventoDeportivo eventoTenis = fabricaTenis.crearEvento("Test", fecha);
        
        // Act
        fabricaFutbol.configurarEvento(eventoFutbol);
        fabricaTenis.configurarEvento(eventoTenis);
        
        // Assert - Verificar que no lanza excepciones
        assertTrue(true); // Prueba de que se ejecutó sin errores
    }
}