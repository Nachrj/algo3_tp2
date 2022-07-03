/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fiuba.algo3;

import edu.fiuba.algo3.coordenada.Direccion;
import edu.fiuba.algo3.coordenada.Coordenada;
import edu.fiuba.algo3.vehiculo.Vehiculo;

/**
 *
 * @author bruno
 */
public class Jugador {
    String nombre;
    private int movimientos;
    private Vehiculo vehiculo;

    public Jugador (String n, Vehiculo v) {
        nombre = n;
        vehiculo = v;
        movimientos = 0;
    }
    
    public void avanzar (Direccion d, Tablero tablero) {
        this.movimientos += tablero.mover(d);
    }

    public int obtenerMovimientos(){
        return this.movimientos;
    }

    public Coordenada obtenerPosicion(){
        return this.vehiculo.obtenerPosicion();
    }
    public void cambiarVehiculo(){
        this.vehiculo = this.vehiculo.cambiar();
    }

    public Vehiculo obtenerVehiculo(){
        return this.vehiculo;
    }

    public void modificarPorcentajeMovimientos(float porcentaje) {
        this.movimientos = Math.round(this.movimientos * porcentaje);
    }
}
