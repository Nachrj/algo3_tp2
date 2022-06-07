/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fiuba.algo3;

/**
 *
 * @author bruno
 */
public class Coordenada {
    int posX,posY;

    public Coordenada(int x, int y){
        posX = x;
        posY = y;
    }

    public void sumar_coordenadas(Coordenada coordenada){
        posX += coordenada.posX;
        posY += coordenada.posY;
    }

    public int x(){
        return posX;
    }

    public int y(){
        return posY;
    }
}
