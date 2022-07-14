package edu.fiuba.algo3.model;

public interface SubjectTablero {
    void registrarObservador(ObserverTablero observador);
    void eliminarObservador(ObserverTablero observador);
    void notificarObservadoresDatosJugador();
    void notificarObservadoresDatosTablero();
}
