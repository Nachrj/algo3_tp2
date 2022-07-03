package edu.fiuba.algo3.obstaculo;

import edu.fiuba.algo3.coordenada.Direccion;
import edu.fiuba.algo3.vehiculo.*;

import java.util.Random;

public class ControlPolicial implements Obstaculo {
    @Override
    public int chocar(Vehiculo vehiculo, Direccion d){
        return vehiculo.chocarObstaculo(this, d);
    }
    @Override
    public int chocar(Auto auto, Direccion d){
        Random random = new Random();
        int min = 1, max = 11;
        int rand = random.nextInt(max + min) + min;
        if(rand > 5){
            return 3;
        }
        return 0;
    }
    @Override
    public int chocar(CuatroXCuatro cuatroXCuatro, Direccion d){
        Random random = new Random();
        int min = 1, max = 11;
        int rand = random.nextInt(max + min) + min;
        if(rand > 3){
            return 3;
        }
        return 0;
    }
    @Override
    public int chocar(Moto moto, Direccion d){
        Random random = new Random();
        int min = 1, max = 11;
        int rand = random.nextInt(max + min) + min;
        if(rand > 8){
            return 3;
        }
        return 0;
    }
}
