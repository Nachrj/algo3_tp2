/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fiuba.algo3.obstaculo;

import edu.fiuba.algo3.coordenada.Direccion;
import edu.fiuba.algo3.vehiculo.Vehiculo;

/**
 *
 * @author bruno
 */
public class Pozo implements Obstaculo {
    @Override
    public int chocar(Vehiculo v1, Direccion d){
        return v1.chocarConPozo();
    }
}