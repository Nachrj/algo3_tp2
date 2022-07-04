package edu.fiuba.algo3.view;

import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class JugadorGrafico {
    //cambiar a vehiculografico¿?

    String tipo; //"Moto", "4x4", "Auto"
    private double posXJugador;
    private double posYJugador;

    public Image dibujarPersonaje(TableroGrafico tablero, String nombreVehiculo, int columnas, int filas){

        Map<String, String> rutas = new HashMap<String,String>();
        rutas.put("Moto", "moto.png");
        rutas.put("Auto", "auto.png");
        rutas.put("4x4","4x4.png");
        String url = "auto.png";
        String path = "file:"+System.getProperty("user.dir")+"/sprites/" + rutas.get(nombreVehiculo);

        Image imagen = new Image(path, 200/(columnas+1),200/(filas+1), true, true);

        tablero.setearPosicionesJugador(0,0);

        return imagen;
    }
    public void setearPosicionesJugador(double unaPosXJugador, double unaPosYJugador){
        posXJugador = unaPosXJugador;
        posYJugador = unaPosYJugador;
    }
}
