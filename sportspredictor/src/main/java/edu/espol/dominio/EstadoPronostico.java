package edu.espol.dominio;

public enum EstadoPronostico {
    PENDIENTE("Pendiente"),
    ACERTADO("Acertado"),
    FALLIDO("Fallido"),
    EN_REVISION("En revisión");

    private final String descripcion;

    EstadoPronostico(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}