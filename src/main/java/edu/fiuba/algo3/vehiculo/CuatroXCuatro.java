/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fiuba.algo3.vehiculo;

import edu.fiuba.algo3.coordenada.Coordenada;
import edu.fiuba.algo3.coordenada.Direccion;
import edu.fiuba.algo3.obstaculo.Obstaculo;

public class CuatroXCuatro extends Vehiculo {
    int choquesConPozos;
    public CuatroXCuatro(){
        this.posicion = new Coordenada(0,0);
        this.choquesConPozos = 0;
    }
    public CuatroXCuatro(Coordenada c){
        this.posicion = c;
        this.choquesConPozos = 0;
    }
    @java.lang.Override
    public Vehiculo cambiar(){
        return new Moto(this.posicion);
    }

    public void chocarConPozo() {
        this.choquesConPozos++;
    }

    public int choquesConPozos(){
        return this.choquesConPozos;
    }

    @Override
    public int chocarObstaculo(Obstaculo obstaculo, Direccion d){
        this.ultimoMovimiento = d;
        return obstaculo.chocar(this);
    }
}
