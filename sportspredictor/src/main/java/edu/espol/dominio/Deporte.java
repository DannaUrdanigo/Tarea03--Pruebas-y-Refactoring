package edu.espol.dominio;

public class Deporte {
    private String nombre;
    private String codigo;
    
    public Deporte(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }
    
    // Getters
    public String getNombre() { return nombre; }
    public String getCodigo() { return codigo; }
    
    @Override
    public String toString() {
        return nombre + " (" + codigo + ")";
    }
}