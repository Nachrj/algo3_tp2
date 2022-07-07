/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fiuba.algo3.obstaculo;

import edu.fiuba.algo3.vehiculo.*;

public class Pozo implements Obstaculo {
    @Override
    public int chocar(Auto auto){
        return 3;
    }
    @Override
    public int chocar(CuatroXCuatro cuatroXCuatro){
        cuatroXCuatro.chocarConPozo();
        if (cuatroXCuatro.choquesConPozos() > 3)
            return 2;
        return 0;
    }
    @Override
    public int chocar(Moto moto){
        return 3;
    }


    public String obtenerNombre(){
        return "Pozo";
    }
}
