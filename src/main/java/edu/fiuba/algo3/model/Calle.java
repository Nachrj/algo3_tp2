/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fiuba.algo3.model;

import edu.fiuba.algo3.model.coordenada.Direccion;
import edu.fiuba.algo3.model.obstaculo.NoObstaculo;
import edu.fiuba.algo3.model.obstaculo.Obstaculo;
import edu.fiuba.algo3.model.sorpresa.NoSorpresa;
import edu.fiuba.algo3.model.sorpresa.Sorpresa;

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

    public void transitar(Jugador j){
        System.out.println(this.obstaculo.getClass());
        System.out.println(this.sorpresa.getClass());

        j.chocar(this.obstaculo);
        this.sorpresa.activar(j);
    }
    
    public void agregarSopresa(Sorpresa sor){
        this.sorpresa = sor;
    }
    
    public void agregarObstaculo(Obstaculo obs){
        this.obstaculo = obs;
    }

    public String obtenerNombreObstaculo(){
        return obstaculo.obtenerNombre();
    }
    public String obtenerNombreSorpresa(){
        return sorpresa.obtenerNombre();
    }
}
