package edu.fiuba.algo3.model.vehiculo;

import edu.fiuba.algo3.model.coordenada.Coordenada;
import edu.fiuba.algo3.model.obstaculo.Obstaculo;

public class Auto extends Vehiculo {
    public Auto(){
        this.posicion = new Coordenada(0,0);
    }
    public Auto(Coordenada c){
        this.posicion = c;
    }
    @java.lang.Override
    public Vehiculo cambiar(){
        return new CuatroXCuatro(this.posicion);
    }
    @Override
    public int chocarObstaculo(Obstaculo obstaculo){
        return obstaculo.chocar(this);
    }
}
