package edu.espol.test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import edu.espol.dominio.*;
import edu.espol.dominio.eventos.EventoFutbol;

class PronosticoTest {
    private Pronostico pronostico;
    private Usuario usuario;
    private EventoDeportivo evento;
    private Date fecha;
    
    @BeforeEach
    void setUp() {
        fecha = new Date();
        usuario = new Usuario("U001", "Test User", "test@test.com");
        Deporte futbol = new Deporte("Fútbol", "FUT");
        evento = new EventoFutbol("EV-001", "Test Match", fecha, futbol);
        pronostico = new Pronostico("PRON-001", usuario, evento, "2-1");
    }
    
    @Test
    void testCalcularPuntos_AciertaPronostico() {
        // Arrange
        int puntosIniciales = usuario.getPuntos();
        
        // Act
        int puntosGanados = pronostico.calcularPuntos("2-1");
        
        // Assert
        assertEquals(10, puntosGanados);
        assertEquals(puntosIniciales + 10, usuario.getPuntos());
        assertEquals("ACERTADO", pronostico.getEstado());
    }
    
    @Test
    void testCalcularPuntos_FallaPronostico() {
        // Arrange
        int puntosIniciales = usuario.getPuntos();
        
        // Act
        int puntosGanados = pronostico.calcularPuntos("1-2");
        
        // Assert
        assertEquals(0, puntosGanados);
        assertEquals(puntosIniciales, usuario.getPuntos());
        assertEquals("FALLIDO", pronostico.getEstado());
    }
    
    @Test
    void testValidar_PrediccionCorrecta() {
        // Act & Assert
        assertTrue(pronostico.validar("2-1"));  // Usando assertTrue
    }
    
    @Test
    void testValidar_PrediccionIncorrecta() {
        // Act & Assert
        assertFalse(pronostico.validar("1-2"));  // Usando assertFalse
    }
    
    @Test
    void testCambiarEstado_ActualizaEstado() {
        // Act
        pronostico.cambiarEstado("EN REVISIÓN");
        
        // Assert
        assertEquals("EN REVISIÓN", pronostico.getEstado());
    }
    
    @Test
    void testConstructor_InicializaValoresCorrectamente() {
        // Assert
        assertEquals("PRON-001", pronostico.getId());
        assertEquals(usuario, pronostico.getUsuario());
        assertEquals(evento, pronostico.getEvento());
        assertEquals("2-1", pronostico.getPrediccion());
        assertEquals("PENDIENTE", pronostico.getEstado());
        assertNotNull(pronostico.getFechaCreacion());
    }
    
    @Test
    void testGetters_RetornanValoresCorrectos() {
        // Assert
        assertEquals("2-1", pronostico.getPrediccion());
        assertEquals("PENDIENTE", pronostico.getEstado());
    }
}