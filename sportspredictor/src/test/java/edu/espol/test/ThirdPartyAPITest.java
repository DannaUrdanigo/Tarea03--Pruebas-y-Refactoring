package edu.espol.test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;
import edu.espol.Patrones.comportamentales.ThirdPartyAPI;

class ThirdPartyAPITest {
    private ThirdPartyAPI api;
    
    @BeforeEach
    void setUp() {
        api = new ThirdPartyAPI("TEST_API_KEY");
    }
    
    @Test
    void testAuthenticate_ApiKeyValida() {
        // Act & Assert
        assertTrue(api.authenticate());  // Usando assertTrue
    }
    
    @Test
    void testGetPlayerStats_RetornaMapaConDatos() {
        // Act
        Map<String, Object> stats = api.getPlayerStats("PLAYER_123");
        
        // Assert
        assertNotNull(stats);
        assertTrue(stats.containsKey("player_id"));
        assertTrue(stats.containsKey("matches_played"));
        assertTrue(stats.containsKey("goals"));
        assertTrue(stats.containsKey("assists"));
        assertTrue(stats.containsKey("rating"));
        assertEquals("PLAYER_123", stats.get("player_id"));
        
        // Verificar tipos de datos
        assertTrue(stats.get("matches_played") instanceof Integer);
        assertTrue(stats.get("rating") instanceof Double);
    }
    
    @Test
    void testGetTeamStats_RetornaMapaConDatosEquipo() {
        // Act
        Map<String, Object> stats = api.getTeamStats("TEAM_456");
        
        // Assert
        assertNotNull(stats);
        assertTrue(stats.containsKey("team_id"));
        assertTrue(stats.containsKey("wins"));
        assertTrue(stats.containsKey("losses"));
        assertTrue(stats.containsKey("draws"));
        assertEquals("TEAM_456", stats.get("team_id"));
    }
    
    @Test
    void testGetPlayerStats_DiferentesLlamadas() {
        // Act
        Map<String, Object> stats1 = api.getPlayerStats("PLAYER_1");
        Map<String, Object> stats2 = api.getPlayerStats("PLAYER_2");
        
        // Assert - Verificar que son diferentes (debido al random)
        // No podemos comparar valores exactos pero sí la estructura
        assertEquals(stats1.keySet(), stats2.keySet());
    }
}