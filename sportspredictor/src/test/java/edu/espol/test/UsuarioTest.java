package edu.espol.test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import edu.espol.dominio.*;
import edu.espol.dominio.eventos.EventoFutbol;

class UsuarioTest {
    private Usuario usuario;
    private EventoDeportivo evento;
    private Date fecha;
    
    @BeforeEach
    void setUp() {
        usuario = new Usuario("U001", "Carlos Pérez", "carlos@email.com");
        fecha = new Date();
        Deporte futbol = new Deporte("Fútbol", "FUT");
        evento = new EventoFutbol("EV-001", "Barcelona vs Madrid", fecha, futbol);
    }
    
    @Test
    void testRealizarPronostico_CreaPronosticoCorrectamente() {
        // Act
        Pronostico pronostico = usuario.realizarPronostico(evento, "2-1");
        
        // Assert
        assertNotNull(pronostico);
        assertEquals(usuario, pronostico.getUsuario());
        assertEquals(evento, pronostico.getEvento());
        assertEquals("2-1", pronostico.getPrediccion());
        assertEquals("PENDIENTE", pronostico.getEstado());
        assertNotNull(pronostico.getFechaCreacion());
        
        // Verificar que se agregó al historial
        assertEquals(1, usuario.getHistorialPronosticos().size());
    }
    
    @Test
    void testActualizar_AgregaNotificacion() {
        // Arrange
        int notificacionesIniciales = usuario.getNotificaciones().size();
        
        // Act
        usuario.actualizar(evento, "Estado cambiado a EN CURSO");
        
        // Assert
        assertEquals(notificacionesIniciales + 1, usuario.getNotificaciones().size());
        assertTrue(usuario.getNotificaciones().get(0).contains("Estado cambiado"));
    }
    
    @Test
    void testAgregarPuntos_IncrementaPuntosCorrectamente() {
        // Arrange
        int puntosIniciales = usuario.getPuntos();
        
        // Act
        usuario.agregarPuntos(10);
        
        // Assert
        assertEquals(puntosIniciales + 10, usuario.getPuntos());
    }
    
    @Test
    void testAgregarPuntos_MultiplesVeces() {
        // Act
        usuario.agregarPuntos(5);
        usuario.agregarPuntos(15);
        usuario.agregarPuntos(10);
        
        // Assert
        assertEquals(30, usuario.getPuntos());
    }
    
    @Test
    void testConstructor_InicializaValoresCorrectamente() {
        // Assert
        assertEquals("U001", usuario.getId());
        assertEquals("Carlos Pérez", usuario.getNombre());
        assertEquals("carlos@email.com", usuario.getEmail());
        assertEquals(0, usuario.getPuntos());
        assertNotNull(usuario.getHistorialPronosticos());
        assertNotNull(usuario.getNotificaciones());
        assertTrue(usuario.getHistorialPronosticos().isEmpty());
    }
    
    @Test
    void testGetters_RetornanValoresCorrectos() {
        // Assert
        assertEquals("Carlos Pérez", usuario.getNombre());
        assertEquals("carlos@email.com", usuario.getEmail());
    }
}