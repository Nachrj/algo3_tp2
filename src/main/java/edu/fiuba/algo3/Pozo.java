/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fiuba.algo3;
import java.util.HashMap;
/**
 *
 * @author bruno
 */
public class Pozo extends Obstaculo{
    public Pozo(){
        this.diccionario = new HashMap<>();
        diccionario.put(Auto.class, 3);
        diccionario.put(Moto.class, 3);
        diccionario.put(CuatroXCuatro.class, 0);
        //Definicion del diccionario hardcodeado;
        
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
        if( CuatroXCuatro.class == v1.getClass()){
            ((CuatroXCuatro) v1).chocarConPozo();
           if( ((CuatroXCuatro) v1).obtenerChoquesConPozos() > 3)
               return 2;
           else return 0;
        }
        else return diccionario.get(v1.getClass());
    }
}
