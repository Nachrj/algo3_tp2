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
public class Pozo implements Obstaculo{
    public Pozo(){

    }
    
    @Override
    public int chocar(Vehiculo v1){
        return v1.chocarConPozo();
    }
}
