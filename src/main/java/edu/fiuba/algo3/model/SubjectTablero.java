package edu.fiuba.algo3.model;

public interface SubjectTablero {
    void registrarObservador(ObserverTablero observador);

    void eliminarObservador();
    void notificarObservadoresDatosJugador();

    void notificarObservadoresDatosTablero();
}
