/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fiuba.algo3.model.sorpresa;

import edu.fiuba.algo3.model.Jugador;

public class SorpresaDesfavorable implements Sorpresa {
    @Override
    public void activar(Jugador j1){
        j1.modificarPorcentajeMovimientos((float) 1.25);
    }
    public String obtenerNombre(){
        return "SorpresaDesfavorable";
    }
}
