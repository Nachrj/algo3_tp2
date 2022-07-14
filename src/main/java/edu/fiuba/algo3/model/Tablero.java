/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fiuba.algo3.model;

import edu.fiuba.algo3.model.coordenada.Coordenada;
import edu.fiuba.algo3.model.coordenada.Direccion;

import java.util.ArrayList;

public class Tablero implements SubjectTablero{
    private final ArrayList<ObserverTablero> observers = new ArrayList<>();
    private final int filas;
    private final int columnas;
    private final Jugador jugador;
    private final Mapa mapa;
    private final Coordenada posMeta;

    private boolean posicionFueraDeRango(Coordenada destino ){
        return (destino.x() >= filas || destino.x() < 0) || (destino.y() >= columnas || destino.y() < 0);
    }

    public Coordenada obtenerPosicionJugador(){
       return this.jugador.obtenerPosicion();
    }

    public void mostrarMapaPrueba(){
        mapa.mostrarMapaPrueba(jugador.obtenerPosicion());
    }

    public Tablero(int fil, int col, Jugador jugador){
        this.filas = fil;
        this.columnas = col;
        this.jugador = jugador;
        posMeta = new Coordenada((fil/2),col-1);
        this.mapa = new Mapa(filas, columnas);
    }

    public Tablero(int fil, int col, Jugador jugador, Calle calle){
        this.filas = fil;
        this.columnas = col;
        this.jugador = jugador;
        posMeta = new Coordenada((fil/2),col-1);
        mapa = new Mapa(filas, columnas, calle);
    }

    public void moverJugador(Direccion direc){
        Coordenada posicionJugador = jugador.obtenerPosicion();
        posicionJugador.sumarCoordenadas(direc);
        if(posicionFueraDeRango(posicionJugador)){
            return;
        }

        mapa.transitarCalle(jugador, jugador.obtenerPosicion(), direc);
        jugador.sumarMovimiento();

        mostrarMapaPrueba();

        notificarObservadoresDatosJugador();
    }

    public boolean terminoJuego(){
        return jugador.obtenerPosicion().equals(posMeta);
    }

    @Override
    public void registrarObservador(ObserverTablero observador) {
        observers.add(observador);
    }

    @Override
    public void eliminarObservador(ObserverTablero observador) {
        observers.remove(observador);
    }

    @Override
    public void notificarObservadoresDatosJugador() {
        for (ObserverTablero observer : observers)
            observer.actualizarDatosJugador(jugador.obtenerPosicion(), jugador.obtenerMovimientos(), jugador.obtenerNombreVehiculo(), terminoJuego());
    }

    @Override
    public void notificarObservadoresDatosTablero() {
        ArrayList<String> nombreObstaculos = new ArrayList<>();
        ArrayList<String> nombreSorpresas = new ArrayList<>();
        ArrayList<Coordenada> posiciones = new ArrayList<>();
        ArrayList<Boolean> esHorizontal = new ArrayList<>();
        mapa.cargarDatosCalles(nombreObstaculos, nombreSorpresas, posiciones, esHorizontal);

        for(ObserverTablero observer : observers)
            observer.actualizarDatosTablero(nombreObstaculos, nombreSorpresas, posiciones, esHorizontal, posMeta);
    }
}
