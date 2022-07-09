package edu.fiuba.algo3.model;

import edu.fiuba.algo3.model.coordenada.Coordenada;
import edu.fiuba.algo3.model.coordenada.Direccion;

public class Mapa {
    int filas;
    int columnas;
    private final Calle[][] mapa;
    private final char[][] mapaPrueba;

    private void inicializarMapa(Calle calle){
        ConstructorCalle c = new ConstructorCalle();

        for(int i = 0; i <= 2*(filas - 1); i++ ){
            for(int j = 0; j <= 2*(columnas - 1); j++){
                if( (i % 2 == 0 && j % 2 != 0) || (i % 2 != 0 && j % 2 == 0) ){

                    if(calle == null) {
                        mapa[i][j] = c.construirCalleAleatoria();
                    }
                    else mapa[i][j] = calle;

                    mapaPrueba[i][j] = 'C';
                }
                else mapaPrueba[i][j] = '-';
            }
        }
    }

    // Mapa generado de forma aleatoria
    public Mapa(int filas, int columnas){
        this.filas = filas;
        this.columnas = columnas;

        mapa = new Calle[2*filas - 1][2*columnas -1];
        mapaPrueba = new char[2*filas - 1][2*columnas -1];

        inicializarMapa(null);
    }

    // Mapa generado con todas las calles iguales a la pasada por parámetro
    public Mapa(int filas, int columnas, Calle calle){
        this.filas = filas;
        this.columnas = columnas;

        mapa = new Calle[2*filas - 1][2*columnas -1];
        mapaPrueba = new char[2*filas - 1][2*columnas -1];

        inicializarMapa(calle);
    }

    public void mostrarMapaPrueba(Coordenada posicionJugador){
        mapaPrueba[posicionJugador.x()][posicionJugador.y()] = 'J';

        for(int i = 0; i <= 2*(filas - 1); i++ ) {
            for (int j = 0; j <= 2 * (columnas - 1); j++) {
                System.out.print(mapaPrueba[i][j]);
            }
            System.out.print('\n');
        }
        System.out.print('\n');
        mapaPrueba[posicionJugador.x()][posicionJugador.y()] = '-';
    }

    public void transitarCalle(Jugador jugador, Coordenada posicion, Direccion direc){
        Coordenada coordenadaMapa = new Coordenada(2* posicion.x(), 2* posicion.y());
        coordenadaMapa.sumarCoordenadas(direc);

        mapa[coordenadaMapa.x()][coordenadaMapa.y()].transitar(jugador, direc);
    }

    public Calle[][] obtenerMapa(){
        return mapa;
    }

}
