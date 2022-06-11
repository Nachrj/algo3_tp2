package edu.fiuba.algo3;
import java.util.HashMap;
import java.util.Map;

public class Piquete extends Obstaculo{

    public Piquete(){
    }
    @Override
    public int chocar(Vehiculo v1){
        return v1.chocarConPiquete();
    }
}