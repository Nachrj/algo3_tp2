package edu.fiuba.algo3.model.coordenada;

public class Abajo implements Direccion {
    @Override
    public Coordenada mover(){
        return new Coordenada(1,0 );
    }

    @Override
    public Direccion direccionOpuesta(){
        return new Arriba();
    }
}
