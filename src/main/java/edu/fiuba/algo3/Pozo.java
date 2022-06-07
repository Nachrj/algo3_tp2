/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fiuba.algo3;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author bruno
 */
public class Pozo extends Obstaculo{
    public Pozo(){
        Map<String, Integer> diccionario = new HashMap<>();
        diccionario.put("Auto", 3);
        diccionario.put("Moto", 3);
        diccionario.put("4x4", 0);
        //Definicion del diccionario hardcodeado;
        
    }
    
    @Override
    public int Chocar(Vehiculo v1){
        /*
        Si el vehiculo es un auto o una moto no hace nada extra y devuelve 3
        Si el vehiculo es un 4x4 y es su primer o segundo pozo no hago nada 
        devuelvo 0
        Si el vehiculo es un 4x4 y es su tercer pozo devuelvo 2
        */
        //return diccionario.get(v1);
        return -1;
    }
}
