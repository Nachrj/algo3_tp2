package edu.fiuba.algo3.view;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JugadorGrafico {
    //cambiar a vehiculografico¿?

    String tipo; //"Moto", "4x4", "Auto"
    private double posXJugador;
    private double posYJugador;
    private ImageView personaje;
    private ImageView fondoNegroDePersonaje;
    private final int tamanoImagenFondoNegro = 4000;
    private int vehiculoActual = 0;
    ArrayList<String> arr = new ArrayList<>(3);

    Map<String, String> rutas = new HashMap<>();
    private int columnas;
    private int filas;

    public void dibujarPersonaje(Pane juego, String nombreVehiculo, int col, int fil, int altoUnidad){
        rutas.put("Moto", "moto.png");
        rutas.put("Auto", "auto.png");
        rutas.put("4x4","4x4.png");
        arr.add("Moto");
        arr.add("Auto");
        arr.add("4x4");
        vehiculoActual = arr.indexOf(nombreVehiculo);
        tipo = nombreVehiculo;
        columnas = col;
        filas = fil;
        String path = "file:"+System.getProperty("user.dir")+"/sprites/" + rutas.get(nombreVehiculo);

        Image imagen = new Image(path, 300d/(columnas),300d/(filas), true, true);

        posXJugador = 0;
        posYJugador = altoUnidad*columnas/30d+altoUnidad*3/2d;
        personaje = new ImageView(imagen);
        personaje.setTranslateX(posXJugador);
        personaje.setTranslateY(posYJugador);
        juego.getChildren().add(personaje);
    }

    public void dibujarFondo(Pane juego){
        String path = "file:"+System.getProperty("user.dir") + "/sprites/fondo_negro_circulo.png";
        Image imagenFondoNegro = new Image(path, tamanoImagenFondoNegro,tamanoImagenFondoNegro, true, true);

        fondoNegroDePersonaje = new ImageView(imagenFondoNegro);
        fondoNegroDePersonaje.setTranslateX(-(tamanoImagenFondoNegro/2d));
        fondoNegroDePersonaje.setTranslateY(-(tamanoImagenFondoNegro/2d));

        juego.getChildren().add(fondoNegroDePersonaje);
    }

    public void cambiarImagen(){
        System.out.println("Entro");
        vehiculoActual = (vehiculoActual+1)%3;
        String path = "file:" + System.getProperty("user.dir")+"/sprites/" + rutas.get(arr.get(vehiculoActual));
        System.out.println(vehiculoActual);
        Image imagen = new Image(path, 300d/(columnas),300d/(filas), true, true);
        personaje.setImage(imagen);
    }

    // ToDo -> la posicion del personaje se debería actualizar siempre con la posición que devuelva el tablero, mismo con la del fondo negro
    public void actualizarPersonaje(double unaPosXJugador, double unaPosYJugador){
        posXJugador += unaPosXJugador;
        posYJugador += unaPosYJugador;
        fondoNegroDePersonaje.setTranslateX(posXJugador-(tamanoImagenFondoNegro/2d));
        fondoNegroDePersonaje.setTranslateY(posYJugador-(tamanoImagenFondoNegro/2d));
        personaje.setTranslateX(posXJugador);
        personaje.setTranslateY(posYJugador);
    }
}