package edu.fiuba.algo3.obstaculo;

import edu.fiuba.algo3.vehiculo.*;

public class NoObstaculo implements Obstaculo {

    private static NoObstaculo no_obstaculo_instancia = null;

    public static NoObstaculo conseguirInstancia() {
        if (no_obstaculo_instancia == null) {
            no_obstaculo_instancia = new NoObstaculo();
        }
        return no_obstaculo_instancia;
    }
    @Override
    public int chocar(Auto auto){
        return 0;
    }
    @Override
    public int chocar(CuatroXCuatro cuatroXCuatro){
        return 0;
    }
    @Override
    public int chocar(Moto moto){
        return 0;
    }


    public String obtenerNombre(){
        return "";
    }
}
