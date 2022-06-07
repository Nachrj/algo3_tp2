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
    int movimientos;
    Vehiculo vehiculo;
    Map<String, Tupla> posiciones = new HashMap<>();

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
        this.movimientos += tablero.mover(this.vehiculo);
    }

    public int obtenerMovimientos(){
        return this.movimientos;
    }
}
