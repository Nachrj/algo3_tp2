/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fiuba.algo3.model;

import edu.fiuba.algo3.model.coordenada.Coordenada;
import edu.fiuba.algo3.model.coordenada.Direccion;

public class Tablero {
    private final int filas;
    private final int columnas;
    private final Jugador jugador;
    private final Mapa mapa;

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

        this.mapa = new Mapa(filas, columnas);
    }

    //Crea al tablero con todas las calles iguales para hacer tests
    public Tablero(int fil, int col, Jugador jugador, Calle calle){
        this.filas = fil;
        this.columnas = col;
        this.jugador = jugador;

        mapa = new Mapa(filas, columnas, calle);
    }

    public boolean moverJugador(Direccion direc){
        jugador.avanzar(direc);

        if(posicionFueraDeRango(jugador.obtenerPosicion())){
            jugador.reversa();
            return false;
        }

        jugador.reversa();
        mapa.transitarCalle(jugador, jugador.obtenerPosicion(), direc);
        jugador.avanzar(direc);

        jugador.sumarMovimiento();
        return true;
    }

    public Calle[][] obtenerMapa(){
        return this.mapa.obtenerMapa();
    }
}
