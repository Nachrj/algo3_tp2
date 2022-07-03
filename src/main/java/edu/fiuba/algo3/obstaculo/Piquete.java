package edu.fiuba.algo3.obstaculo;

import edu.fiuba.algo3.vehiculo.Vehiculo;

public class Piquete implements Obstaculo {

    public Piquete(){
    }
    @Override
    public int chocar(Vehiculo v1){
        return v1.chocarConPiquete();
    }
}