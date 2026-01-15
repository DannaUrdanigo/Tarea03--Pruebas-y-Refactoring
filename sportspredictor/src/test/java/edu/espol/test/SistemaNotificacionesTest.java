package edu.espol.test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import edu.espol.dominio.*;
import edu.espol.dominio.eventos.EventoFutbol;
import edu.espol.Patrones.estructurales.SistemaNotificaciones;

class SistemaNotificacionesTest {
    private SistemaNotificaciones sistemaEmail;
    private SistemaNotificaciones sistemaPush;
    private EventoDeportivo evento;
    private Date fecha;
    
    @BeforeEach
    void setUp() {
        sistemaEmail = new SistemaNotificaciones("email");
        sistemaPush = new SistemaNotificaciones("push");
        fecha = new Date();
        Deporte futbol = new Deporte("Fútbol", "FUT");
        evento = new EventoFutbol("EV-001", "Test Match", fecha, futbol);
    }
    
    @Test
    void testActualizar_Email() {
        // Arrange
        int notificacionesIniciales = sistemaEmail.getNotificacionesEnviadas();
        
        // Act
        sistemaEmail.actualizar(evento, "Mensaje de prueba");
        
        // Assert
        assertEquals(notificacionesIniciales + 1, sistemaEmail.getNotificacionesEnviadas());
    }
    
    @Test
    void testActualizar_Push() {
        // Arrange
        int notificacionesIniciales = sistemaPush.getNotificacionesEnviadas();
        
        // Act
        sistemaPush.actualizar(evento, "Mensaje de prueba");
        
        // Assert
        assertEquals(notificacionesIniciales + 1, sistemaPush.getNotificacionesEnviadas());
    }
    
    @Test
    void testGetCanal_RetornaCanalCorrecto() {
        // Assert
        assertEquals("email", sistemaEmail.getCanal());
        assertEquals("push", sistemaPush.getCanal());
    }
    
    @Test
    void testEnviarEmail_Simulacion() {
        // Act - Debería ejecutarse sin excepciones
        sistemaEmail.enviarEmail("test@test.com", "Asunto", "Cuerpo del email");
        
        // Assert - Verificar que no lanza excepciones
        assertTrue(true);
    }
    
    @Test
    void testEnviarPush_Simulacion() {
        // Act
        sistemaPush.enviarPush("device-token", "Título", "Mensaje");
        
        // Assert
        assertTrue(true);
    }
    
    @Test
    void testEnviarSMS_Simulacion() {
        // Act
        sistemaEmail.enviarSMS("+593991234567", "Mensaje SMS de prueba");
        
        // Assert
        assertTrue(true);
    }
}