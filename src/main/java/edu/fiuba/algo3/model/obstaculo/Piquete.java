package edu.fiuba.algo3.model.obstaculo;

import edu.fiuba.algo3.coordenada.Direccion;
import edu.fiuba.algo3.model.vehiculo.*;

public class Piquete implements Obstaculo {
    @Override
    public int chocar(Vehiculo vehiculo, Direccion d){
        return vehiculo.chocarObstaculo(this, d);
    }
    @Override
    public int chocar(Auto auto, Direccion d){
        auto.mover(d.direccionOpuesta());
        return 0;
    }
    @Override
    public int chocar(CuatroXCuatro cuatroXCuatro, Direccion d){
        cuatroXCuatro.mover(d.direccionOpuesta());
        return 0;
    }
    @Override
    public int chocar(Moto moto, Direccion d){
        return 2;
    }
}