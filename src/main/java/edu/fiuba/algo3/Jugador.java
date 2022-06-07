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
    Coordenada coordenada;
    Map<String, Tupla> posiciones = new HashMap<>();

    public Jugador (String n, Vehiculo v, Coordenada c) {
        nombre = n;
        vehiculo = v;
        coordenada = c;
        movimientos = 0;
        
        posiciones.put("Arriba", new Tupla(0,1));
        posiciones.put("Abajo", new Tupla(0,-1));
        posiciones.put("Derecha", new Tupla(1,0));
        posiciones.put("Izquierda", new Tupla(-1,0));
    }
    
    public int avanzar (String direccion, Tablero tablero) {
        Coordenada coord_a_sumar = new Coordenada(posiciones.get(direccion).a(), posiciones.get(direccion).b());
        
        vehiculo.avanzar(coord_a_sumar);
    }

    public int obtenerMovimientos(){
        return this.movimientos;
    }
}
