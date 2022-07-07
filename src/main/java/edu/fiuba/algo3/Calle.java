/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fiuba.algo3;

import edu.fiuba.algo3.coordenada.Coordenada;
import edu.fiuba.algo3.coordenada.Direccion;
import edu.fiuba.algo3.obstaculo.NoObstaculo;
import edu.fiuba.algo3.obstaculo.Obstaculo;
import edu.fiuba.algo3.sorpresa.NoSorpresa;
import edu.fiuba.algo3.sorpresa.Sorpresa;

/**
 *
 * @author bruno
 */
public class Calle {
    Coordenada pos_inicio;
    Coordenada pos_final;
    Sorpresa sorpresa;
    Obstaculo obstaculo;

    public Calle(){
        this.sorpresa = NoSorpresa.conseguirInstancia();
        this.obstaculo = NoObstaculo.conseguirInstancia();
    }
    public Calle (Coordenada c1, Coordenada c2) {
        this.pos_inicio = c1;
        this.pos_final = c2;
        this.sorpresa = NoSorpresa.conseguirInstancia();
        this.obstaculo = NoObstaculo.conseguirInstancia();
    }
    
    public Calle (Coordenada c1, Coordenada c2, Obstaculo obs) {
        this.pos_inicio = c1;
        this.pos_final = c2;
        this.obstaculo = obs;
        this.sorpresa = NoSorpresa.conseguirInstancia();
    }
    
    public Calle (Coordenada c1, Coordenada c2, Sorpresa sor) {
        this.pos_inicio = c1;
        this.pos_final = c2;
        this.sorpresa = sor;
        this.obstaculo = NoObstaculo.conseguirInstancia();
    }
    
    public Calle (Coordenada c1, Coordenada c2, Obstaculo obs,Sorpresa sor) {
        this.pos_inicio = c1;
        this.pos_final = c2;
        this.obstaculo = obs;
        this.sorpresa = sor;
    }

    public void transitar(Jugador j, Direccion d){
        this.sorpresa.activar(j);
        j.chocar(this.obstaculo, d);
    }
    
    public void agregarSopresa(Sorpresa sor){
        this.sorpresa = sor;
    }
    
    public void agregarObstaculo(Obstaculo obs){
        this.obstaculo = obs;
    }

    public Obstaculo obtenerObstaculo(){
        return this.obstaculo;
    }
    public Sorpresa obtenerSorpresa(){
        return this.sorpresa;
    }
}
