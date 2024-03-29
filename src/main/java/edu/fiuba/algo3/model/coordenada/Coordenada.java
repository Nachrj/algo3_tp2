/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fiuba.algo3.model.coordenada;

/**
 *
 * @author bruno
 */
public class Coordenada {
    private int posX,posY;

    public Coordenada(int x, int y){
        posX = x;
        posY = y;
    }

    public Coordenada(Coordenada coordenada){
        this.posX = coordenada.posX;
        this.posY = coordenada.posY;
    }

    public void sumarCoordenadas(Coordenada coordenada){
        posX += coordenada.posX;
        posY += coordenada.posY;
    }

    public void sumarCoordenadas(Direccion direccion){
        this.sumarCoordenadas(direccion.mover());
    }


    public int x(){
        return posX;
    }

    public int y(){
        return posY;
    }

    public Boolean equals(Coordenada c){
        return( posX == c.x() && posY == c.y() );
    }
}
