package edu.fiuba.algo3.model;

import edu.fiuba.algo3.model.obstaculo.ControlPolicial;
import edu.fiuba.algo3.model.obstaculo.Piquete;
import edu.fiuba.algo3.model.obstaculo.Pozo;
import edu.fiuba.algo3.model.sorpresa.CambioDeVehiculo;
import edu.fiuba.algo3.model.sorpresa.SorpresaDesfavorable;
import edu.fiuba.algo3.model.sorpresa.SorpresaFavorable;

import java.util.HashMap;

public class ConstructorCalle {
    private Calle calle;
    private final HashMap<Integer, Runnable> sorpresas = new HashMap<>();
    private final HashMap<Integer, Runnable > obstaculos = new HashMap<>();
    private final GeneradorNumeros generador = new GeneradorNumeros();

    public ConstructorCalle(){
        sorpresas.put(1, () -> calle.agregarSopresa(new SorpresaDesfavorable()));
        sorpresas.put(2, () -> calle.agregarSopresa(new SorpresaFavorable()));
        sorpresas.put(3, () -> calle.agregarSopresa(new CambioDeVehiculo()));

        obstaculos.put(1, () -> calle.agregarObstaculo(new Piquete()));
        obstaculos.put(2, () -> calle.agregarObstaculo(new Pozo()));
        obstaculos.put(3, () -> calle.agregarObstaculo(new ControlPolicial()));
    }
    private void agregarSorpresaAleatoria(){
        int rand = generador.obtenerNumeroAleatorio(0, 100);
        if(rand >= 25)
            sorpresas.get(generador.obtenerNumeroAleatorio(1, 3)).run();
    }

    private void agregarObstaculoAleatorio(){
        int rand = generador.obtenerNumeroAleatorio(0, 100);
        if(rand >= 25)
            obstaculos.get(generador.obtenerNumeroAleatorio(1, 3)).run();
    }

    public Calle construirCalleAleatoria(){
        calle = new Calle();
        int min = 0, max = 100;
        int rand = generador.obtenerNumeroAleatorio(min, max);
        //ToDo -> determinar las probabilidades de que se construya o no una sorpresa/obstaculo
        if( rand >= 50){
            agregarSorpresaAleatoria();
            agregarObstaculoAleatorio();
        }
        return calle;
    }
}
