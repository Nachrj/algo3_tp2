package edu.fiuba.algo3.model;

import edu.fiuba.algo3.model.coordenada.Coordenada;
import edu.fiuba.algo3.model.coordenada.Direccion;

import java.util.ArrayList;

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
        mapaPrueba[posicionJugador.x()*2][posicionJugador.y()*2] = 'J';

        for(int i = 0; i <= 2*(filas - 1); i++ ) {
            for (int j = 0; j <= 2 * (columnas - 1); j++) {
                System.out.print(mapaPrueba[i][j]);
            }
            System.out.print('\n');
        }
        System.out.print('\n');
        mapaPrueba[posicionJugador.x()*2][posicionJugador.y()*2] = '-';
    }

    public void transitarCalle(Jugador jugador, Coordenada posicion, Direccion direc){
        Coordenada coordenadaMapa = new Coordenada(2* posicion.x(), 2* posicion.y());
        coordenadaMapa.sumarCoordenadas(direc);
        jugador.avanzar(direc);
        mapa[coordenadaMapa.x()][coordenadaMapa.y()].transitar(jugador);
    }

    private boolean posicionTieneCalleHorizontal(int fila, int columna){
        return (fila % 2 == 0 && columna % 2 != 0);
    }

    private boolean posicionTieneCalleVertical(int fila, int columna){
        return (fila % 2 != 0 && columna % 2 == 0);
    }
    public void cargarDatosCalles(ArrayList<String> nombreObstaculos, ArrayList<String> nombreSorpresas, ArrayList<Coordenada> posiciones, ArrayList<Boolean> esHorizontal){
        for(int fila = 0; fila <= 2*(filas - 1); fila++ ){
            for(int columna = 0; columna <= 2*(columnas - 1); columna++){

                if(posicionTieneCalleHorizontal(fila, columna) || posicionTieneCalleVertical(fila, columna)){
                    nombreObstaculos.add(mapa[fila][columna].obtenerNombreObstaculo());
                    nombreSorpresas.add(mapa[fila][columna].obtenerNombreSorpresa());
                    posiciones.add(new Coordenada(fila, columna));
                    esHorizontal.add(posicionTieneCalleHorizontal(fila,columna));
                }
            }
        }
    }
}
