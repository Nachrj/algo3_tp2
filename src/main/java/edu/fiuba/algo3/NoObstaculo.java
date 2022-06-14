package edu.fiuba.algo3;

public class NoObstaculo implements Obstaculo{

    private static NoObstaculo no_obstaculo_instancia = null;

    public static NoObstaculo conseguirInstancia() {
        if (no_obstaculo_instancia == null) {
            no_obstaculo_instancia = new NoObstaculo();
        }
        return no_obstaculo_instancia;
    }

    @Override
    public int chocar(Vehiculo v1){
        return 0;
    }
}
