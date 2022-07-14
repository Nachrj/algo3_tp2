package edu.fiuba.algo3.model;

import edu.fiuba.algo3.model.coordenada.Coordenada;
import edu.fiuba.algo3.model.coordenada.Direccion;
import edu.fiuba.algo3.model.obstaculo.ControlPolicial;
import edu.fiuba.algo3.model.obstaculo.Obstaculo;
import edu.fiuba.algo3.model.obstaculo.Piquete;
import edu.fiuba.algo3.model.obstaculo.Pozo;
import edu.fiuba.algo3.model.sorpresa.CambioDeVehiculo;
import edu.fiuba.algo3.model.sorpresa.Sorpresa;
import edu.fiuba.algo3.model.sorpresa.SorpresaDesfavorable;
import edu.fiuba.algo3.model.sorpresa.SorpresaFavorable;

public class TableroFalso {
    Calle[] calles = new Calle[4];
    Jugador jugador;
    int calleActual = 0;
    int filas;
    int columnas;
    GeneradorNumeros generadorFalso;

    Coordenada posMapa = new Coordenada(0,3);
    public TableroFalso(int unasFilas, int unasColumnas, Jugador jugador, GeneradorNumeros genMocked){
        generadorFalso = genMocked;
        filas = unasFilas;
        columnas = unasColumnas;
        this.jugador = jugador;
        calles[0] = crearCalle(new Pozo(), new SorpresaFavorable());
        calles[1] = crearCalle(new ControlPolicial(genMocked), new SorpresaDesfavorable());
        calles[2] = crearCalle(new Piquete(), new CambioDeVehiculo());
    }

    public Calle crearCalle(Obstaculo obs, Sorpresa sor){
        return new Calle(obs, sor);
    }

    private boolean posicionFueraDeRango(Coordenada destino ){
        return (destino.x() >= filas || destino.x() < 0) || (destino.y() >= columnas || destino.y() < 0);
    }

    public boolean moverJugador(Direccion direc){
        jugador.avanzar(direc);
        if(posicionFueraDeRango(jugador.obtenerPosicion())){
            jugador.reversa();
            return false;
        }
        jugador.reversa();
        calles[calleActual].transitar(jugador);
        jugador.avanzar(direc);

        jugador.sumarMovimiento();

        calleActual+=1;
        return true;
    }


    public Coordenada obtenerPosicionJugador() {
        return jugador.obtenerPosicion();
    }
}
