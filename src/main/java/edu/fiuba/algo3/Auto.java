package edu.fiuba.algo3;

import java.util.Random;

public class Auto implements Vehiculo{
    @java.lang.Override
    public Vehiculo cambiar(){
        return new CuatroXCuatro();
    }
    @java.lang.Override
    public int chocarConPozo() {
        return 3;
    }
    @java.lang.Override
    public int chocarConPiquete() {
        // Dar la vuelta
        return 0;
    }
    @java.lang.Override
    public int chocarConControl() {
        Random random = new Random();
        int max = 11;
        int min = 1;
        int rand = random.nextInt(max + min) + min;
        if(rand > 5){
            return 3;
        }
        return 0;
    }
}
