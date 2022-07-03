package edu.fiuba.algo3.coordenada;

import edu.fiuba.algo3.coordenada.Coordenada;
import edu.fiuba.algo3.coordenada.Derecha;
import edu.fiuba.algo3.coordenada.Direccion;

public class Izquierda implements Direccion {
    @Override
    public Coordenada mover(){
        return new Coordenada(0,-1 );
    }

    @Override
    public Direccion direccionOpuesta(){
        return new Derecha();
    }

}
