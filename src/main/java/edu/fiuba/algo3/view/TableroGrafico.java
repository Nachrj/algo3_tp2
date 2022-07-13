package edu.fiuba.algo3.view;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class TableroGrafico extends Pane{
    private int altoUnidad;
    private int anchoUnidad;
    private JugadorGrafico jugador;
    private Pane juego;


    public Pane crearEscena(int columnas, int filas, String nombreVehiculo, MarcadorGrafico marcador){
        juego = new Pane();
        anchoUnidad = (int)(600/(columnas*1.5+0.5));
        altoUnidad = (int)(600/(filas*1.5+0.5));

        marcador.dibujarMarcador(juego);
        jugador = new JugadorGrafico();
        jugador.dibujarPersonaje(juego ,nombreVehiculo , columnas, filas, altoUnidad);

        for(int i = 0; i < (filas-1); i++) {
            for(int j = 0; j < (columnas-1); j++) {
                Rectangle rectangle = new Rectangle(anchoUnidad, altoUnidad, Color.GREY);
                rectangle.setTranslateX((anchoUnidad+(anchoUnidad/2))*j + anchoUnidad*3/4);
                rectangle.setTranslateY((altoUnidad + (altoUnidad/2))*i + altoUnidad*3/4);
                juego.getChildren().add(rectangle);
            }
        }
        return juego;
    }

    public void cambiarImagen(){
        jugador.cambiarImagen();
    }
    public void dibujarFondoNegro(){
        jugador.dibujarFondo(juego);
    }

    public void dibujarObstaculoNuevo(double posX, double posY, String ruta){
        ObstaculoGrafico obstaculo = new ObstaculoGrafico();
        obstaculo.dibujar(juego, posX, posY, ruta, anchoUnidad, altoUnidad);
    }
    // ToDo -> la posicion del personaje se debería actualizar siempre con la posición que devuelva el tablero, mismo con la del fondo negro
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
