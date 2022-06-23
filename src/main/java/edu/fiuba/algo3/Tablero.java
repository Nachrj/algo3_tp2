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
    private int filas;
    private int columnas;
    private Jugador jugador;
    private Coordenada posicionJugador;
    private Calle[][] mapa;

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

    public Tablero(int fil, int col, Jugador jugador){
        //ToDo -> ver que hacer si los parametros son 0 o negativos
        this.filas = fil;
        this.columnas = col;
        this.jugador = jugador;
        posicionJugador = new Coordenada(Math.round((float) fil/2),0);

        ConstructorCalle c = new ConstructorCalle();
        mapa = new Calle[2*filas - 1][2*columnas -1];
        for(int i = 0; i <= 2*(filas - 1); i++ ){
            for(int j = 0; j <= 2*(columnas - 1); j++){
                if( (i % 2 == 0 && j % 2 != 0) || (i % 2 != 0 && j % 2 == 0) ){
                    mapa[i][j] = c.construirCalleAleatoria();
                    System.out.print('C');
                }
                else System.out.print('-');
            }
            System.out.print('\n');
        }
        System.out.print('\n');
    }
    //ToDo -> ver como hacer si se choca con piquete (tiene que volver para atrás)
    public int mover(Direccion d){
        Coordenada coordenadaMapa = new Coordenada(2*posicionJugador.x(), 2*posicionJugador.y());
        coordenadaMapa.sumarCoordenadas(d.mover());
        posicionJugador.sumarCoordenadas(d.mover());

        if(posicionFueraDeRango(posicionJugador)){
            posicionJugador.sumarCoordenadas(d.direccionOpuesta().mover());
            return 0;
        }
        return mapa[coordenadaMapa.x()][coordenadaMapa.y()].transitar(jugador);
    }
}
