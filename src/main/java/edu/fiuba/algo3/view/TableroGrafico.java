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
    private Pane juego;


    public Pane crearEscena(int columnas, int filas, String nombreVehiculo){
        juego = new Pane();
        anchoUnidad = (int)(600/(columnas*1.5+0.5));
        altoUnidad = (int)(600/(filas*1.5+0.5));

        jugador = new JugadorGrafico();
        jugador.dibujarPersonaje(juego ,nombreVehiculo , columnas, filas, altoUnidad, anchoUnidad);

        for(int i = 0; i < filas; i++) {
            for(int j = 0; j < columnas; j++) {
                Rectangle rectangle = new Rectangle(anchoUnidad, altoUnidad, Color.GREY);
                rectangle.setTranslateX((anchoUnidad+(int)(anchoUnidad/2))*j+30);
                rectangle.setTranslateY((altoUnidad+(int)(altoUnidad/2))*i+30);
                juego.getChildren().add(rectangle);
            }
        }
        return juego;
    }

    public void dibujarFondoNegro(){
        jugador.dibujarFondo(juego);
    }

    public void dibujarObstaculoNuevo(int posx, int posy, String ruta){
        ObstaculoGrafico obstaculo = new ObstaculoGrafico();
        obstaculo.dibujar(juego, posx, posy, ruta);
    }
    public void actualizarPosicionesJugador(double unaPosXJugador, double unaPosYJugador){
        jugador.actualizarPersonaje(unaPosXJugador, unaPosYJugador);
    }

    public int obtenerMetricasTableroAncho(){
        return anchoUnidad;
    }
    public int obtenerMetricasTableroAlto(){
        return altoUnidad;
    }

}
