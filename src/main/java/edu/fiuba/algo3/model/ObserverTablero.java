package edu.fiuba.algo3.model;

import edu.fiuba.algo3.model.coordenada.Coordenada;

import java.util.ArrayList;

public interface ObserverTablero {
    void actualizarDatosTablero(ArrayList<String> nombreObstaculos, ArrayList<String> nombreSorpresas,
                                ArrayList<Coordenada> posiciones, ArrayList<Boolean> esHorizontal);

    void actualizarDatosJugador(Coordenada posicionJugador, int cantidadMovimientos, String nombreVehiculo, Boolean alcanzoMeta,  Coordenada posicionMeta);
}
