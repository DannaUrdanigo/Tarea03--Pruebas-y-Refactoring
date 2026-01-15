package edu.espol.dominio;

public class CategoriaPronostico {
    private String nombre;
    private String tipo;
    private int puntuacionBase;
    
    public CategoriaPronostico(String nombre, String tipo, int puntuacionBase) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.puntuacionBase = puntuacionBase;
    }
    
    // Getters
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public int getPuntuacionBase() { return puntuacionBase; }
    
    @Override
    public String toString() {
        return nombre + " - " + tipo + " (" + puntuacionBase + " pts base)";
    }
}