/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fiuba.algo3.vehiculo;

import java.util.Random;

/**
 *
 * @author bruno
 */
public class Moto implements Vehiculo {
    public Moto(){

    }
    @java.lang.Override
    public Vehiculo cambiar(){
        return new Auto();
    }
    @java.lang.Override
    public int chocarConPozo() {
        return 3;
    }
    @java.lang.Override
    public int chocarConPiquete() {
        return 2;
    }

    @java.lang.Override
    public int chocarConControl() {
        Random random = new Random();
        int max = 11;
        int min = 1;
        int rand = random.nextInt(max + min) + min;
        if(rand > 8){
            return 3;
        }
        return 0;
    }
}
