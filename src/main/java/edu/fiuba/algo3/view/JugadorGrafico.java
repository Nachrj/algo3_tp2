package edu.fiuba.algo3.view;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.HashMap;
import java.util.Map;

public class JugadorGrafico {
    //cambiar a vehiculografico¿?

    String tipo; //"Moto", "4x4", "Auto"
    private double posXJugador;
    private double posYJugador;

    public Image dibujarPersonaje(Pane tablero, String nombreVehiculo, int columnas, int filas, int altoUnidad, int anchoUnidad){

        Map<String, String> rutas = new HashMap<String,String>();
        rutas.put("Moto", "moto.png");
        rutas.put("Auto", "auto.png");
        rutas.put("4x4","4x4.png");
        String url = "auto.png";
        String path = "file:"+System.getProperty("user.dir")+"/sprites/" + rutas.get(nombreVehiculo);

        Image imagen = new Image(path, 300/(columnas),300/(filas), true, true);

        setearPosicionesJugador(0,altoUnidad*columnas/30);
        ImageView personaje = new ImageView(imagen);
        personaje.setTranslateX(posXJugador);
        personaje.setTranslateY(posYJugador);
        tablero.getChildren().add(personaje);
        return imagen;
    }
    public void setearPosicionesJugador(double unaPosXJugador, double unaPosYJugador){
        posXJugador = unaPosXJugador;
        posYJugador = unaPosYJugador;
    }
}
