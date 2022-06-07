/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fiuba.algo3;

/**
 *
 * @author bruno
 */
public class Jugador {
    String nombre;
    int movimientos;
    Vehiculo vehiculo = new Vehiculo();
    Coordenada coordenada;

    public Jugador (String n, Vehiculo v, Coordenada c) {
        nombre = n;
        vehiculo = v;
        coordenada = c;
        movimientos = 0;
    }

    public void avanzar (String direccion, Tablero tablero) {
        /*
        switch (direccion) {
            case "arriba":
                Coordenada coord_a_sumar = new Coordenada(1,0);
                coordenada.mover(coord_a_sumar);
            case "abajo":
                Coordenada coord_a_sumar = new Coordenada(1,0);
                coordenada.mover(coord_a_sumar);
            case "izquierda":
                Coordenada coord_a_sumar = new Coordenada(1,0);
                coordenada.mover(coord_a_sumar);
            case "derecha":
                Coordenada coord_a_sumar = new Coordenada(1,0);
                coordenada.mover(coord_a_sumar);
        }*/
        
    }
}
