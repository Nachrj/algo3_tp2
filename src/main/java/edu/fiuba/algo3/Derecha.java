package edu.fiuba.algo3;

public class Derecha implements Direccion{
    @Override
    public Coordenada mover(){
        return new Coordenada( 0,1);
    }

    @Override
    public Direccion direccionOpuesta(){
        return new Izquierda();
    }
}
