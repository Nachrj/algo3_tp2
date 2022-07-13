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
    private int tamanoImagenFondoNegro = 4000;
    private int vehiculoActual = 0;
    private String[] vehiculos = new String[3];
    ArrayList<String> arr = new ArrayList<String>(3);

    Map<String, String> rutas = new HashMap<String,String>();
    private int columnas;
    private int filas;

    public void dibujarPersonaje(Pane juego, String nombreVehiculo, int col, int fil, int altoUnidad, int anchoUnidad){
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

        Image imagen = new Image(path, 300/(columnas),300/(filas), true, true);

        posXJugador = 0;
        posYJugador = altoUnidad*columnas/30+altoUnidad*3/2;
        personaje = new ImageView(imagen);
        personaje.setTranslateX(posXJugador);
        personaje.setTranslateY(posYJugador);
        juego.getChildren().add(personaje);
    }

    public void dibujarFondo(Pane juego){
        String path = "file:"+System.getProperty("user.dir") + "/sprites/fondo_negro_circulo.png";
        Image imagenFondoNegro = new Image(path, tamanoImagenFondoNegro,tamanoImagenFondoNegro, true, true);

        fondoNegroDePersonaje = new ImageView(imagenFondoNegro);
        fondoNegroDePersonaje.setTranslateX(-(tamanoImagenFondoNegro/2));
        fondoNegroDePersonaje.setTranslateY(-(tamanoImagenFondoNegro/2));

        juego.getChildren().add(fondoNegroDePersonaje);
    }

    public void cambiarImagen(){
        System.out.println("Entro");
        vehiculoActual = (vehiculoActual+1)%3;
        String path = "file:"+System.getProperty("user.dir")+"/sprites/" + rutas.get(arr.get(vehiculoActual));
        System.out.println(vehiculoActual);
        Image imagen = new Image(path, 300/(columnas),300/(filas), true, true);
        personaje.setImage(imagen);
    }

    public void actualizarPersonaje(double unaPosXJugador, double unaPosYJugador){
        posXJugador += unaPosXJugador;
        posYJugador += unaPosYJugador;
        fondoNegroDePersonaje.setTranslateX(posXJugador-(tamanoImagenFondoNegro/2));
        fondoNegroDePersonaje.setTranslateY(posYJugador-(tamanoImagenFondoNegro/2));
        personaje.setTranslateX(posXJugador);
        personaje.setTranslateY(posYJugador);
    }
}