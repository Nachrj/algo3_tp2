package edu.fiuba.algo3;

public class NoSorpresa extends Sorpresa{

    private static NoSorpresa no_sorpresa_instancia = null;

    public static NoSorpresa conseguirInstancia() {
        if (no_sorpresa_instancia == null) {
            no_sorpresa_instancia = new NoSorpresa();
        }
        return no_sorpresa_instancia;
    }
    @Override
    public void activar(Jugador j1){
        return;
    }
}