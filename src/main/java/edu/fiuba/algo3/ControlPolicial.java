package edu.fiuba.algo3;

public class ControlPolicial implements Obstaculo{
    @Override
    public int chocar(Vehiculo v1){
        return v1.chocarConControl();
    }
}
