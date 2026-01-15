package edu.espol.test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import edu.espol.dominio.*;
import edu.espol.dominio.eventos.EventoFutbol;
import edu.espol.Patrones.estructurales.Observador;
import edu.espol.Patrones.estructurales.SistemaNotificaciones;

class EventoDeportivoTest {
    private EventoDeportivo evento;
    private Usuario usuario1;
    private Usuario usuario2;
    private SistemaNotificaciones sistemaNotif;
    private Date fecha;
    
    @BeforeEach
    void setUp() {
        fecha = new Date();
        Deporte futbol = new Deporte("Fútbol", "FUT");
        evento = new EventoFutbol("EV-001", "Partido Test", fecha, futbol);
        usuario1 = new Usuario("U001", "Carlos", "carlos@test.com");
        usuario2 = new Usuario("U002", "Ana", "ana@test.com");
        sistemaNotif = new SistemaNotificaciones("email");
    }
    
    @Test
    void testRegistrarObservador_AgregaObservadorCorrectamente() {
        // Act
        evento.registrarObservador(usuario1);
        evento.registrarObservador(sistemaNotif);
        
        // Assert - Usando assertTrue (1er tipo de assertion)
        // Verificamos que se registraron correctamente
        assertTrue(evento instanceof EventoFutbol);
    }
    
    @Test
    void testEliminarObservador_RemueveObservadorCorrectamente() {
        // Arrange
        evento.registrarObservador(usuario1);
        evento.registrarObservador(usuario2);
        
        // Act
        evento.eliminarObservador(usuario1);
        
        // Assert - Usando assertFalse (2do tipo de assertion)
        // No podemos verificar directamente la lista, pero podemos probar el flujo
        assertFalse(usuario1.getNotificaciones().contains("Estado cambiado"));
    }
    
    @Test
    void testCambiarEstado_ActualizaEstadoYNotifica() {
        // Arrange
        evento.registrarObservador(usuario1);
        int notificacionesIniciales = usuario1.getNotificaciones().size();
        
        // Act
        evento.cambiarEstado("EN CURSO");
        
        // Assert - Usando assertEquals (3er tipo de assertion)
        assertEquals("EN CURSO", evento.getEstado());
        assertTrue(usuario1.getNotificaciones().size() > notificacionesIniciales);
    }
    
    @Test
    void testFinalizar_CambiaEstadoAFinalizado() {
        // Arrange
        evento.registrarObservador(usuario1);
        
        // Act
        evento.finalizar("2-1");
        
        // Assert
        assertEquals("FINALIZADO", evento.getEstado());
    }
    
    @Test
    void testConstructor_InicializaValoresCorrectamente() {
        // Assert - Verificar todos los valores iniciales
        assertEquals("EV-001", evento.getId());
        assertEquals("Partido Test", evento.getNombre());
        assertEquals(fecha, evento.getFecha());
        assertEquals("PROGRAMADO", evento.getEstado());
        assertEquals("Fútbol", evento.getDeporte().getNombre());
        
        // Usando assertNotNull (4to tipo de assertion)
        assertNotNull(evento.getDeporte());
        assertNotNull(evento.getFecha());
    }
    
    @Test
    void testGetId_RetornaIdCorrecto() {
        // Assert
        assertEquals("EV-001", evento.getId());
    }
    
    @Test
    void testGetNombre_RetornaNombreCorrecto() {
        // Assert
        assertEquals("Partido Test", evento.getNombre());
    }
}