/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fiuba.algo3.model.obstaculo;

import edu.fiuba.algo3.model.coordenada.Direccion;
import edu.fiuba.algo3.model.vehiculo.*;

public interface Obstaculo {
    int chocar(Vehiculo vehiculo, Direccion d);

    int chocar(Auto auto, Direccion d);

    int chocar(CuatroXCuatro cuatroXCuatro, Direccion d);

    int chocar(Moto moto, Direccion d);


}
