package edu.fiuba.algo3.obstaculo;

import edu.fiuba.algo3.coordenada.Direccion;
import edu.fiuba.algo3.vehiculo.Vehiculo;

public class Piquete implements Obstaculo {
    @Override
    public int chocar(Vehiculo v1, Direccion d){
        return v1.chocarConPiquete(d);
    }
}