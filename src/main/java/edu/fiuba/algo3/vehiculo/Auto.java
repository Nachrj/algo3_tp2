package edu.fiuba.algo3.vehiculo;

import edu.fiuba.algo3.coordenada.Coordenada;
import edu.fiuba.algo3.coordenada.Direccion;

import java.util.Random;

public class Auto extends Vehiculo {
    public Auto(){
        this.posicion = new Coordenada(0,0);
    }
    public Auto(Coordenada c){
        this.posicion = c;
    }
    @java.lang.Override
    public Vehiculo cambiar(){
        return new CuatroXCuatro(this.posicion);
    }
    @java.lang.Override
    public int chocarConPozo() {
        return 3;
    }
    @java.lang.Override
    public int chocarConPiquete(Direccion d) {
        this.posicion.sumarCoordenadas(d.direccionOpuesta().mover());
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
