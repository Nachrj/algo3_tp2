package edu.fiuba.algo3.model;

import edu.fiuba.algo3.model.coordenada.Direccion;
import edu.fiuba.algo3.model.meta.Final;
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
    int calleActual = 0;
    Jugador jug;
    public TableroFalso(int filas, int columnas, Jugador jugador){
        jug = jugador;
        calles[0] = crearCalle(new Pozo(), new SorpresaFavorable());
        calles[1] = crearCalle(new ControlPolicial(), new SorpresaDesfavorable());
        calles[2] = crearCalle(new Piquete(), new CambioDeVehiculo());
        calles[3] = new Calle(new Meta());
    }

    public Calle crearCalle(Obstaculo obs, Sorpresa sor){
        return new Calle(obs, sor);
    }

    public boolean moverJugador(Direccion direc){
        if(calles[calleActual].transitar(jug, direc)){
            return true;
        }
        calleActual+=1;
        return false;
    }


}
