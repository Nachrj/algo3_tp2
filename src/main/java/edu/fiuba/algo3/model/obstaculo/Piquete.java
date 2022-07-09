package edu.fiuba.algo3.model.obstaculo;

import edu.fiuba.algo3.model.vehiculo.Auto;
import edu.fiuba.algo3.model.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.model.vehiculo.Moto;

public class Piquete implements Obstaculo {
    @Override
    public int chocar(Auto auto){
        auto.reversa();
        return 0;
    }
    @Override
    public int chocar(CuatroXCuatro cuatroXCuatro){
        cuatroXCuatro.reversa();
        return 0;
    }
    @Override
    public int chocar(Moto moto){
        return 2;
    }

    public String obtenerNombre(){
        return "Piquete";
    }
}