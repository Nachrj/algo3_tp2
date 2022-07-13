/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fiuba.algo3.model;

import edu.fiuba.algo3.model.coordenada.Direccion;
import edu.fiuba.algo3.model.coordenada.Coordenada;
import edu.fiuba.algo3.model.obstaculo.Obstaculo;
import edu.fiuba.algo3.model.vehiculo.Vehiculo;

public class Jugador {
    String nombre;
    private int movimientos;
    private Vehiculo vehiculo;

    public Jugador (String n, Vehiculo v) {
        nombre = n;
        vehiculo = v;
        movimientos = 0;
    }
    public void avanzar(Direccion d){
        this.vehiculo.mover(d);
    }
    public void reversa(){
        this.vehiculo.reversa();
    }
    public void sumarMovimiento(){
        movimientos++;
    }
    public Coordenada obtenerPosicion(){
        return this.vehiculo.obtenerPosicion();
    }

    public void cambiarVehiculo(){
        this.vehiculo = this.vehiculo.cambiar();
    }
    public void chocar(Obstaculo obs){
        movimientos += vehiculo.chocarObstaculo(obs);
    }
    public void modificarPorcentajeMovimientos(float porcentaje) {
        this.movimientos = Math.round(this.movimientos * porcentaje);
    }
    public int obtenerMovimientos(){
        return this.movimientos;
    }
    public Vehiculo obtenerVehiculo(){
        return this.vehiculo;
    }
}
