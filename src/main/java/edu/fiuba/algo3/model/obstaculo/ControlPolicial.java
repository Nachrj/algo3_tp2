package edu.fiuba.algo3.model.obstaculo;

import edu.fiuba.algo3.model.coordenada.Direccion;
import edu.fiuba.algo3.model.vehiculo.*;
import edu.fiuba.algo3.model.GeneradorNumeros;

public class ControlPolicial implements Obstaculo {
    private final GeneradorNumeros generador;
    public ControlPolicial(){
        this.generador = new GeneradorNumeros();
    }
    public ControlPolicial(GeneradorNumeros generador){
        this.generador = generador;
    }

    @Override
    public int chocar(Vehiculo vehiculo, Direccion d){
        return vehiculo.chocarObstaculo(this, d);
    }
    @Override
    public int chocar(Auto auto, Direccion d){
        int min = 1, max = 10;
        int rand = generador.obtenerNumeroAleatorio(min, max);
        if(rand <= 5){
            return 3;
        }
        return 0;
    }
    @Override
    public int chocar(CuatroXCuatro cuatroXCuatro, Direccion d){
        int min = 1, max = 10;
        int rand = generador.obtenerNumeroAleatorio(min, max);
        if(rand <= 3){
            return 3;
        }
        return 0;
    }
    @Override
    public int chocar(Moto moto, Direccion d){
        int min = 1, max = 10;
        int rand = generador.obtenerNumeroAleatorio(min, max);
        if(rand <= 8){
            return 3;
        }
        return 0;
    }
}
