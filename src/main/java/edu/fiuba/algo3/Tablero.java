/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fiuba.algo3;

/**
 *
 * @author Agustín, putear por wpp cualquier cosa
 */
public class Tablero {
    int filas;
    int columnas;
    Jugador jugador;
    Coordenada posicionJugador;
    Calle calle;

    public Tablero( Calle calleUsuario, Coordenada c){
        calle = calleUsuario;
        posicionJugador = c;
    }

    private boolean posicionFueraDeRango(Coordenada destino ){
        // ¿Muchos if? ¿Tell Don't Ask?
        if(destino.x() > filas || destino.x() < 0){
            return true;
        }
        return destino.y() > columnas || destino.y() < 0;
    }

    public Coordenada obtenerPosicionJugador(){
       return this.posicionJugador;
    }

    public int obtenerCostoDeAvance(Vehiculo vehiculo, Coordenada destino ){
        if (this.posicionFueraDeRango(destino)){ return 0; }
        return -1;
    }

    public void mover(Coordenada destino){
        if (this.posicionFueraDeRango(destino)){ return; }
        posicionJugador.sumar_coordenadas(destino);
    }

}
