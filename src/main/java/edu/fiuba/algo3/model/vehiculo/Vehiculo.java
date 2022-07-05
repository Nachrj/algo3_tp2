/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fiuba.algo3.model.vehiculo;

import edu.fiuba.algo3.model.coordenada.Coordenada;
import edu.fiuba.algo3.model.coordenada.Direccion;
import edu.fiuba.algo3.model.obstaculo.Obstaculo;

/**
 *
 * @author bruno
 * Avanzable (para reemplazar coomportamiento)
 */

public abstract class Vehiculo {
    protected Coordenada posicion;
    public void mover(Direccion d){
        posicion.sumarCoordenadas(d.mover());
    }
    public Coordenada obtenerPosicion(){
        return this.posicion;
    }
    public abstract Vehiculo cambiar();

    public abstract int chocarObstaculo(Obstaculo obstaculo, Direccion d);
}
