package edu.fiuba.algo3;

public class Arriba implements Direccion{
    @Override
    public Coordenada mover(){
        return new Coordenada(-1,0 );
    }

    @Override
    public Direccion direccionOpuesta(){
        return new Abajo();
    }
}
