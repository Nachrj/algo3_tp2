package edu.fiuba.algo3;

public class GeneradorNumeros {
    // incluye a los valores min y max
    public int obtenerNumeroAleatorio(int min, int max){
        return (int) ((Math.random() * ((max+1) - min)) + min);
    }
}
