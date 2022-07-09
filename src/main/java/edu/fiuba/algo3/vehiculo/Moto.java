/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fiuba.algo3.vehiculo;

import edu.fiuba.algo3.coordenada.Coordenada;
import edu.fiuba.algo3.obstaculo.Obstaculo;

public class Moto extends Vehiculo {
    public Moto(){
        this.posicion = new Coordenada(0,0);
    }
    public Moto(Coordenada c){
        this.posicion = c;
    }
    @java.lang.Override
    public Vehiculo cambiar(){
        return new Auto(this.posicion);
    }

    @Override
    public int chocarObstaculo(Obstaculo obstaculo){
        return obstaculo.chocar(this);
    }
}
