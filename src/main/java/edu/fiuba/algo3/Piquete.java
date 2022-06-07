package edu.fiuba.algo3;
import java.util.HashMap;
import java.util.Map;

public class Piquete extends Obstaculo{

    public Piquete(){
        this.diccionario = new HashMap<>();
        diccionario.put(Moto.class, 2);
    }
    @Override
    public int chocar(Vehiculo v1){
        /*
        Si el vehiculo es un auto o una moto no hace nada extra y devuelve 3
        Si el vehiculo es un 4x4 y es su primer o segundo pozo no hago nada
        devuelvo 0
        Si el vehiculo es un 4x4 y es su tercer pozo devuelvo 2
        */
        //return diccionario.get(v1);
        return diccionario.get(v1.getClass());
    }
}