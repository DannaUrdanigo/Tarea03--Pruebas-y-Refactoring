package edu.espol.test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;
import edu.espol.Patrones.comportamentales.*;

class AdapterTest {
    private APIExternaFutbolAdapter adapterFutbol;
    private APIExternaBaloncestoAdapter adapterBaloncesto;
    private APIExternaTenisAdapter adapterTenis;
    
    @BeforeEach
    void setUp() {
        adapterFutbol = new APIExternaFutbolAdapter("API_KEY_FUTBOL");
        adapterBaloncesto = new APIExternaBaloncestoAdapter("API_KEY_BALONCESTO");
        adapterTenis = new APIExternaTenisAdapter("API_KEY_TENIS");
    }
    
    @Test
    void testAdapterFutbol_ObtenerEstadisticasJugador() {
        // Act
        Map<String, Object> stats = adapterFutbol.obtenerEstadisticasJugador("MESSI_10");
        
        // Assert - Usando assertNotNull (ya es el 4to tipo)
        assertNotNull(stats);
        assertTrue(stats.containsKey("idJugador"));
        assertTrue(stats.containsKey("deporte"));
        assertEquals("Fútbol", stats.get("deporte"));
        assertEquals("API Externa Adaptada", stats.get("fuente"));
    }
    
    @Test
    void testAdapterFutbol_ObtenerEstadisticasEquipo() {
        // Act
        Map<String, Object> stats = adapterFutbol.obtenerEstadisticasEquipo("FCB_01");
        
        // Assert
        assertNotNull(stats);
        assertTrue(stats.containsKey("idEquipo"));
        assertEquals("Fútbol", stats.get("deporte"));
    }
    
    @Test
    void testAdapterBaloncesto_ObtenerEstadisticasJugador() {
        // Act
        Map<String, Object> stats = adapterBaloncesto.obtenerEstadisticasJugador("LEBRON_23");
        
        // Assert
        assertNotNull(stats);
        assertEquals("Baloncesto", stats.get("deporte"));
        assertTrue(stats.containsKey("puntosPorPartido"));
    }
    
    @Test
    void testAdapterTenis_ObtenerEstadisticasJugador() {
        // Act
        Map<String, Object> stats = adapterTenis.obtenerEstadisticasJugador("NADAL_1");
        
        // Assert
        assertNotNull(stats);
        assertEquals("Tenis", stats.get("deporte"));
        assertTrue(stats.containsKey("rankingATP"));
        assertTrue(stats.containsKey("porcentajePrimerServicio"));
    }
    
    @Test
    void testAdapterTenis_ObtenerEstadisticasEquipo_TenisNoTieneEquipos() {
        // Act
        Map<String, Object> stats = adapterTenis.obtenerEstadisticasEquipo("NADAL_1");
        
        // Assert - Debería retornar estadísticas de jugador
        assertNotNull(stats);
        assertEquals("Tenis", stats.get("deporte"));
    }
}