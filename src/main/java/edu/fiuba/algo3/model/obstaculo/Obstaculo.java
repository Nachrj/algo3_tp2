/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fiuba.algo3.model.obstaculo;

import edu.fiuba.algo3.model.vehiculo.Auto;
import edu.fiuba.algo3.model.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.model.vehiculo.Moto;


public interface Obstaculo {
    int chocar(Auto auto);

    int chocar(CuatroXCuatro cuatroXCuatro);

    int chocar(Moto moto);

    String obtenerNombre();

}
