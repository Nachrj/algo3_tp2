/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fiuba.algo3;

import edu.fiuba.algo3.coordenada.Coordenada;
import edu.fiuba.algo3.coordenada.Direccion;

public class Tablero {
    private final int filas;
    private final int columnas;
    private final Jugador jugador;
    private final Calle[][] mapa;
    private final char[][] mapaPrueba;

    private boolean posicionFueraDeRango(Coordenada destino ){
        if(destino.x() > filas || destino.x() < 0){
            return true;
        }
        return destino.y() > columnas || destino.y() < 0;
    }

    public Coordenada obtenerPosicionJugador(){
       return this.jugador.obtenerPosicion();
    }

    public void mostrarMapaPrueba(){
        mapaPrueba[2* jugador.obtenerPosicion().x()][2* jugador.obtenerPosicion().y()] = 'J';
        for(int i = 0; i <= 2*(filas - 1); i++ ) {
            for (int j = 0; j <= 2 * (columnas - 1); j++) {
                System.out.print(mapaPrueba[i][j]);
            }
            System.out.print('\n');
        }
        System.out.print('\n');
    }

    public Tablero(int fil, int col, Jugador jugador){
        //ToDo -> ver que hacer si los parametros son 0 o negativos
        this.filas = fil;
        this.columnas = col;
        this.jugador = jugador;
        //posicionJugador = new Coordenada(Math.round((float) fil/2),0);

        ConstructorCalle c = new ConstructorCalle();
        mapa = new Calle[2*filas - 1][2*columnas -1];
        mapaPrueba = new char[2*filas - 1][2*columnas -1];
        for(int i = 0; i <= 2*(filas - 1); i++ ){
            for(int j = 0; j <= 2*(columnas - 1); j++){
                if( (i % 2 == 0 && j % 2 != 0) || (i % 2 != 0 && j % 2 == 0) ){
                    mapa[i][j] = c.construirCalleAleatoria();
                    mapaPrueba[i][j] = 'C';
                }
                else mapaPrueba[i][j] = '-';
            }
        }
        mostrarMapaPrueba();
    }

    //Crea al tablero con todas las calles iguales para hacer tests
    public Tablero(int fil, int col, Jugador jugador, Calle calle){
        this.filas = fil;
        this.columnas = col;
        this.jugador = jugador;
        // ToDo -> lanzar excepción si el tablero recibe el vehículo con una posición inválida
        /* this.posicionJugador = jugador.obtenerPosicion();
         * this.posicionJugador = new Coordenada(Math.round((float) fil/2),0);
        */
        mapa = new Calle[2*filas - 1][2*columnas -1];
        mapaPrueba = new char[2*filas - 1][2*columnas -1];
        for(int i = 0; i <= 2*(filas - 1); i++ ){
            for(int j = 0; j <= 2*(columnas - 1); j++){
                if( (i % 2 == 0 && j % 2 != 0) || (i % 2 != 0 && j % 2 == 0) ){
                    mapa[i][j] = calle;
                    mapaPrueba[i][j] = 'C';
                }
                else mapaPrueba[i][j] = '-';
            }
        }
        mostrarMapaPrueba();
    }

    public int mover(Direccion d){
        Coordenada coordenadaMapa = new Coordenada(2* jugador.obtenerPosicion().x(), 2* jugador.obtenerPosicion().y());
        coordenadaMapa.sumarCoordenadas(d.mover());
        jugador.obtenerPosicion().sumarCoordenadas(d.mover());

        if(posicionFueraDeRango(jugador.obtenerPosicion())){
            jugador.obtenerPosicion().sumarCoordenadas(d.direccionOpuesta().mover());
            return 0;
        }
        mostrarMapaPrueba();
        return mapa[coordenadaMapa.x()][coordenadaMapa.y()].transitar(this.jugador, d);
    }
}
