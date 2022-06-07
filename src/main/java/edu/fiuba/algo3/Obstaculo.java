/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fiuba.algo3;
import java.util.Map;
/**
 *
 * @author bruno
 */
public abstract class Obstaculo {
    Map diccionarioPenalizaciones;
    
    public Obstaculo(Map dic){
        diccionarioPenalizaciones = dic;
    }
    
    public abstract int Chocar(Vehiculo v1);
}
