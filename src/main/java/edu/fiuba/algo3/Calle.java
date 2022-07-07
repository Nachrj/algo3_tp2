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
    Sorpresa sorpresa;
    Obstaculo obstaculo;

    public Calle(){
        this.sorpresa = NoSorpresa.conseguirInstancia();
        this.obstaculo = NoObstaculo.conseguirInstancia();
    }
    public Calle (Obstaculo obs) {
        this.obstaculo = obs;
        this.sorpresa = NoSorpresa.conseguirInstancia();
    }
    
    public Calle (Sorpresa sor) {
        this.sorpresa = sor;
        this.obstaculo = NoObstaculo.conseguirInstancia();
    }
    
    public Calle (Obstaculo obs,Sorpresa sor) {
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
