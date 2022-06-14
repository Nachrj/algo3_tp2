/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fiuba.algo3;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author bruno
 */
public class Jugador {
    String nombre;
    private int movimientos;
    private Vehiculo vehiculo;
    private Map<String, Tupla> posiciones = new HashMap<>();

    public Jugador (String n, Vehiculo v) {
        nombre = n;
        vehiculo = v;
        movimientos = 0;
        
        posiciones.put("Arriba", new Tupla(0,1));
        posiciones.put("Abajo", new Tupla(0,-1));
        posiciones.put("Derecha", new Tupla(1,0));
        posiciones.put("Izquierda", new Tupla(-1,0));
    }
    
    public void avanzar (String direccion, Tablero tablero) {
        int suma = tablero.mover(this);
        this.movimientos += suma;
    }

    public int obtenerMovimientos(){
        return this.movimientos;
    }

    public void cambiarVehiculo(){
        this.vehiculo = this.vehiculo.cambiar();
    }
    public Vehiculo obtenerVehiculo(){
        return this.vehiculo;
    }
    public void modificarPorcentajeMovimientos(float porcentaje) {
        this.movimientos = (int) Math.round(this.movimientos * porcentaje);
    }
}
