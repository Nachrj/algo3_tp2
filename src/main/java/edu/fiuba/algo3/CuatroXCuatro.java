/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fiuba.algo3;

/**
 *
 * @author bruno
 */
public class CuatroXCuatro implements Vehiculo{
    int choquesConPozos = 0;
    public void chocarConPozo(){
        this.choquesConPozos++;
    }

    public int obtenerChoquesConPozos(){
        return this.choquesConPozos;
    }
}
