package edu.espol.test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;
import edu.espol.dominio.*;

class DominioTest {
    
    @Test
    void testDeporte_ConstructorYToString() {
        // Act
        Deporte deporte = new Deporte("Fútbol", "FUT");
        
        // Assert
        assertEquals("Fútbol", deporte.getNombre());
        assertEquals("FUT", deporte.getCodigo());
        assertEquals("Fútbol (FUT)", deporte.toString());
    }
    
    @Test
    void testCategoriaPronostico_ConstructorYGetters() {
        // Act
        CategoriaPronostico categoria = new CategoriaPronostico("Ganador", "Ganador", 10);
        
        // Assert
        assertEquals("Ganador", categoria.getNombre());
        assertEquals("Ganador", categoria.getTipo());
        assertEquals(10, categoria.getPuntuacionBase());
        assertTrue(categoria.toString().contains("Ganador"));
        assertTrue(categoria.toString().contains("10"));
    }
    
    @Test
    void testEstadistica_ActualizarYGetDatos() {
        // Arrange
        Estadistica estadistica = new Estadistica("EST-001", "Jugador Test", "Equipo Test");
        Map<String, Object> nuevosDatos = new HashMap<>();
        nuevosDatos.put("goles", 15);
        nuevosDatos.put("asistencias", 8);
        
        // Act
        estadistica.actualizarDatos(nuevosDatos);
        Map<String, Object> datos = estadistica.getDatos();
        
        // Assert - Usando assertArrayEquals indirectamente para verificar mapas
        // Verificar que es una copia defensiva modificando el mapa original
        nuevosDatos.put("prueba", "valor");
        assertFalse(datos.containsKey("prueba"));
        
        // Verificar contenido
        assertTrue(datos.containsKey("goles"));
        assertEquals(15, datos.get("goles"));
    }
    
    @Test
    void testEstadistica_AgregarDato() {
        // Arrange
        Estadistica estadistica = new Estadistica("EST-001", "Jugador Test", "Equipo Test");
        
        // Act
        estadistica.agregarDato("nuevoCampo", "valor");
        
        // Assert
        assertTrue(estadistica.getDatos().containsKey("nuevoCampo"));
        assertEquals("valor", estadistica.getDatos().get("nuevoCampo"));
    }
    
    @Test
    void testEstadistica_Getters() {
        // Arrange
        Estadistica estadistica = new Estadistica("EST-001", "Jugador Test", "Equipo Test");
        
        // Assert
        assertEquals("EST-001", estadistica.getId());
        assertEquals("Jugador Test", estadistica.getJugador());
        assertEquals("Equipo Test", estadistica.getEquipo());
        assertNotNull(estadistica.getFechaActualizacion());
    }
}