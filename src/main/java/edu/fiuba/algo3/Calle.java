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
        this.pos_inicio = c1;
        this.pos_final = c2;
    }
    
    public Calle (Coordenada c1, Coordenada c2, Obstaculo obs) {
        this.pos_inicio = c1;
        this.pos_final = c2;
        this.obstaculo = obs;
    }
    
    public Calle (Coordenada c1, Coordenada c2, Sorpresa sor) {
        this.pos_inicio = c1;
        this.pos_final = c2;
        this.sorpresa = sor;
    }
    
    public Calle (Coordenada c1, Coordenada c2, Obstaculo obs,Sorpresa sor) {
        this.pos_inicio = c1;
        this.pos_final = c2;
        this.obstaculo = obs;
        this.sorpresa = sor;
    }

    public int transitar(Vehiculo v){
       return (1 + this.obstaculo.chocar(v));
    }
    
    public void agregarSopresa(Sorpresa sor){
        this.sorpresa = sor;
    }
    
    public void agregarObstaculo(Obstaculo obs){
        this.obstaculo = obs;
    }
}
