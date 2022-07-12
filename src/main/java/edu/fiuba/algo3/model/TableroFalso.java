package edu.fiuba.algo3.model;

import edu.fiuba.algo3.model.coordenada.Coordenada;
import edu.fiuba.algo3.model.coordenada.Direccion;
import edu.fiuba.algo3.model.meta.Meta;
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
    public TableroFalso(int unasFilas, int unasColumnas, Jugador jugador){

        filas = unasFilas;
        columnas = unasColumnas;
        this.jugador = jugador;
        calles[0] = crearCalle(new Pozo(), new SorpresaFavorable());
        calles[1] = crearCalle(new ControlPolicial(), new SorpresaDesfavorable());
        calles[2] = crearCalle(new Piquete(), new CambioDeVehiculo());
        calles[3] = new Calle(new Meta());
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

        if(calles[calleActual].transitar(jugador, direc)){
            return true;
        }
        calleActual+=1;
        return false;
    }


    public Coordenada obtenerPosicionJugador() {
        return jugador.obtenerPosicion();
    }
}
