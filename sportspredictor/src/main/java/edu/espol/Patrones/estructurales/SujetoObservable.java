package edu.espol.Patrones.estructurales;

public interface SujetoObservable {
    void registrarObservador(Observador observador);
    void eliminarObservador(Observador observador);
    void notificarObservadores(String mensaje);
}