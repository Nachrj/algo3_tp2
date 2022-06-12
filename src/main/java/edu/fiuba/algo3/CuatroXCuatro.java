/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fiuba.algo3;

import java.util.Random;

/**
 *
 * @author bruno
 */
public class CuatroXCuatro implements Vehiculo{
    int choquesConPozos = 0;
    @java.lang.Override
    public Vehiculo cambiar(){
        return new Moto();
    }

    @java.lang.Override
    public int chocarConPozo() {
        this.choquesConPozos++;
        if (this.choquesConPozos > 3)
            return 2;
        return 0;
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
        if(rand > 3){
            return 3;
        }
        return 0;
    }
}
