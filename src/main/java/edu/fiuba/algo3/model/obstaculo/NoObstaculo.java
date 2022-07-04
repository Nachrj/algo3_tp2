package edu.fiuba.algo3.model.obstaculo;

import edu.fiuba.algo3.coordenada.Direccion;
import edu.fiuba.algo3.model.vehiculo.*;

public class NoObstaculo implements Obstaculo {

    private static NoObstaculo no_obstaculo_instancia = null;

    public static NoObstaculo conseguirInstancia() {
        if (no_obstaculo_instancia == null) {
            no_obstaculo_instancia = new NoObstaculo();
        }
        return no_obstaculo_instancia;
    }

    @Override
    public int chocar(Vehiculo vehiculo, Direccion d){
        return 0;
    }
    @Override
    public int chocar(Auto auto, Direccion d){
        return 0;
    }
    @Override
    public int chocar(CuatroXCuatro cuatroXCuatro, Direccion d){
        return 0;
    }
    @Override
    public int chocar(Moto moto, Direccion d){
        return 0;
    }
}
