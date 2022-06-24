package edu.fiuba.algo3;

import java.util.HashMap;

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
        obstaculos.put(3, () -> calle.agregarObstaculo(new ControlPolicial()));

    }

    private int obtenerNumeroAleatorio(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }

    private void agregarSorpresaAleatoria(){
        int rand = obtenerNumeroAleatorio(0, 100);
        if(rand >= 25)
            sorpresas.get(obtenerNumeroAleatorio(1, 4)).run();
    }

    private void agregarObstaculoAleatorio(){
        int rand = obtenerNumeroAleatorio(0, 100);
        if(rand >= 25)
            obstaculos.get(obtenerNumeroAleatorio(1, 4)).run();
    }

    public Calle construirCalleAleatoria(){
        calle = new Calle();
        int max = 100, min = 0;
        int rand = obtenerNumeroAleatorio(min, max);
        //ToDo -> determinar las probabilidades de que se construya o no una sorpresa/obstaculo
        if( rand >= 50){
            agregarSorpresaAleatoria();
            agregarObstaculoAleatorio();
        }
        return calle;
    }
}
