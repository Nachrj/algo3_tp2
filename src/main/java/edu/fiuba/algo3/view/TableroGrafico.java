package edu.fiuba.algo3.view;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class TableroGrafico extends Pane{
    private int altoUnidad;
    private int anchoUnidad;
    private JugadorGrafico jugador;

    public Pane crearEscena(int columnas, int filas, String nombreVehiculo){
        Pane juego = new Pane();
        anchoUnidad = (int)(600/(columnas*1.5+0.5));
        altoUnidad = (int)(600/(filas*1.5+0.5));

        jugador = new JugadorGrafico();
        Image imagen = jugador.dibujarPersonaje(this, nombreVehiculo , columnas, filas);

        for(int i = 0; i < filas; i++) {
            for(int j = 0; j < columnas; j++) {
                Rectangle rectangle = new Rectangle(anchoUnidad, altoUnidad, Color.GREY);
                rectangle.setTranslateX((anchoUnidad+(int)(anchoUnidad/2))*j+30);
                rectangle.setTranslateY((altoUnidad+(int)(altoUnidad/2))*i+30);
                juego.getChildren().add(rectangle);
            }
        }
        this.getChildren().add(new ImageView(imagen));
        return juego;
    }

    public void setearPosicionesJugador(double unaPosXJugador, double unaPosYJugador){
        jugador.setearPosicionesJugador(unaPosXJugador, unaPosYJugador);
    }
}
