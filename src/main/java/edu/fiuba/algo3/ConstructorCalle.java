package edu.fiuba.algo3;

import java.util.HashMap;
import java.util.Random;

public class ConstructorCalle {
    private Calle calle;
    private final HashMap<Integer, Runnable> sorpresas = new HashMap<>();
    private final HashMap<Integer, Runnable > obstaculos = new HashMap<>();

    public ConstructorCalle(){
        sorpresas.put(1, () -> calle.agregarSopresa(new SorpresaDesfavorable()));
        sorpresas.put(2, () -> calle.agregarSopresa(new SorpresaFavorable()));
        sorpresas.put(3, () -> calle.agregarSopresa(new CambioDeVehiculo()));

        obstaculos.put(1, () -> calle.agregarObstaculo(new Piquete()));
        obstaculos.put(2, () -> calle.agregarObstaculo(new Pozo()));

    }

    private void agregarSorpresaAleatoria(){
        Random random = new Random();
        int min = 1, max = 3;
        int rand = random.nextInt(max + min) + min;
        sorpresas.get(rand).run();
    }

    private void agregarObstaculoAleatorio(){
        Random random = new Random();
        int min = 1, max = 3;
        int rand = random.nextInt(max + min) + min;
        obstaculos.get(rand).run();
    }

    public Calle construirCalleAleatoria(){
        calle = new Calle();
        Random random = new Random();
        int max = 100, min = 0;
        int rand = random.nextInt(max + min) + min;
        //ToDo -> determinar las probabilidades de que se construya o no una sorpresa/obstaculo
        if( rand >= 50){
            rand = random.nextInt(max + min) + min;
            if( rand <= 75) {
                agregarSorpresaAleatoria();
            }
            if( 25 <= rand) {
                agregarObstaculoAleatorio();
            }
        }
        return calle;
    }
}
