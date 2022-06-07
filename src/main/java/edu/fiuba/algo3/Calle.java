/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fiuba.algo3;

/**
 *
 * @author bruno
 */
public class Calle {
    Coordenada pos_inicio;
    Coordenada pos_final;
    Sorpresa sorpresa;
    Obstaculo obstaculo;
    
    public Calle (Coordenada c1, Coordenada c2) {
        pos_inicio = c1;
        pos_final = c2;
    }
    
    public Calle (Coordenada c1, Coordenada c2, Obstaculo obs) {
        pos_inicio = c1;
        pos_final = c2;
        obstaculo = obs;
    }
    
    public Calle (Coordenada c1, Coordenada c2, Sorpresa sor) {
        pos_inicio = c1;
        pos_final = c2;
        sorpresa = sor;
    }
    
    public Calle (Coordenada c1, Coordenada c2, Obstaculo obs,Sorpresa sor) {
        pos_inicio = c1;
        pos_final = c2;
        obstaculo = obs;
        sorpresa = sor;
    }
}
