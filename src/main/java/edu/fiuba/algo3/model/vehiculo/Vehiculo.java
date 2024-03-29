/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fiuba.algo3.model.vehiculo;

import edu.fiuba.algo3.model.coordenada.Coordenada;
import edu.fiuba.algo3.model.coordenada.Direccion;
import edu.fiuba.algo3.model.obstaculo.Obstaculo;

public abstract class Vehiculo {
    protected Coordenada posicion;

    protected Direccion ultimoMovimiento = null;

    public void mover(Direccion d){
        ultimoMovimiento = d;
        posicion.sumarCoordenadas(d.mover());
    }

    public void reversa(){
        if(ultimoMovimiento != null){
            posicion.sumarCoordenadas(ultimoMovimiento.direccionOpuesta());
        }
    }

    public Coordenada obtenerPosicion(){
        return new Coordenada(posicion);
    }

    public abstract Vehiculo cambiar();

    public abstract int chocarObstaculo(Obstaculo obstaculo);
}
