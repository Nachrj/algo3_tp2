package edu.fiuba.algo3.viewjuego;

import edu.fiuba.algo3.model.ObserverTablero;
import edu.fiuba.algo3.model.coordenada.Coordenada;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PantallaJuego extends Pane implements ObserverTablero {
    private int tamanioMapa;
    private int largoCuadra;
    private Pane juego;

    private ImageView jugador = null;
    private final Map<String, String> rutas = new HashMap<>();

    private void inicializarRutas(){
        rutas.put("SorpresaFavorable", "sorpresa.png");
        rutas.put("SorpresaDesfavorable", "sorpresa.png");
        rutas.put("CambioDeVehiculo", "sorpresa.png");
        rutas.put("Pozo", "pozo.png");
        rutas.put("Piquete", "piquete.png");
        rutas.put("Control", "control.png");
        rutas.put("Meta", "meta.png");
        rutas.put("Moto", "moto.png");
        rutas.put("Auto", "auto.png");
        rutas.put("CuatroXCuatro","4x4.png");
    }
    public Pane iniciarPantallaJuego(int tamanioMapa){
        inicializarRutas();
        juego = new Pane();
        this.tamanioMapa = tamanioMapa;
        largoCuadra = (int)(600/(tamanioMapa*1.5+0.5));

        for(int i = 0; i < (tamanioMapa-1); i++) {
            for(int j = 0; j < (tamanioMapa-1); j++) {
                Rectangle rectangle = new Rectangle(largoCuadra, largoCuadra, Color.GREY);
                rectangle.relocate((largoCuadra+(largoCuadra/2d))*j + largoCuadra*3/4d, (largoCuadra + (largoCuadra/2d))*i + largoCuadra*3/4d);
                juego.getChildren().add(rectangle);
            }
        }
        return juego;
    }

    @Override
    public void actualizarDatosJugador(Coordenada posicionJugador, int cantidadMovimientos, String nombreVehiculo, Boolean alcanzoMeta){
        String path = "file:"+System.getProperty("user.dir")+"/sprites/" + rutas.get(nombreVehiculo);

        Image imagen = new Image(path, 300d/(tamanioMapa),300d/(tamanioMapa), true, true);

        double posXJugador = posicionJugador.y()*largoCuadra*1.5;
        double posYJugador = posicionJugador.x()*largoCuadra*1.5 + largoCuadra/3d;

        if(jugador == null) {
            jugador = new ImageView(imagen);
            juego.getChildren().add(jugador);
        }
        jugador.setImage(imagen);
        jugador.relocate(posXJugador, posYJugador);
    }

    @Override
    public void actualizarDatosTablero(ArrayList<String> nombreObstaculos, ArrayList<String> nombreSorpresas,
                                       ArrayList<Coordenada> posiciones, ArrayList<Boolean> esHorizontal, Coordenada posicionMeta) {

        String path = "file:" + System.getProperty("user.dir") + "/sprites/";

        Coordenada posicionElemento;

        for(int i = 0; i < posiciones.size(); i++){
            if(esHorizontal.get(i)){
                posicionElemento = obtenerPosicionObstaculoCalleHorizontal(posiciones.get(i));
                dibujarElementoCalle(posicionElemento.x(),posicionElemento.y(), path + rutas.get(nombreObstaculos.get(i)));

                posicionElemento = obtenerPosicionSorpresaCalleHorizontal(posiciones.get(i));
                dibujarElementoCalle(posicionElemento.x(),posicionElemento.y(), path + rutas.get(nombreSorpresas.get(i)));
            }
            else {
                posicionElemento = obtenerPosicionObstaculoCalleVertical(posiciones.get(i));
                dibujarElementoCalle(posicionElemento.x(),posicionElemento.y(), path + rutas.get(nombreObstaculos.get(i)));

                posicionElemento = obtenerPosicionSorpresaCalleVertical(posiciones.get(i));
                dibujarElementoCalle(posicionElemento.x(),posicionElemento.y(), path + rutas.get(nombreSorpresas.get(i)));
            }
        }
        //tableroGrafico.dibujarFondoNegro();

        //marcadorGrafico.moverAdelante();

        //posicionElemento = obtenerPosicionMeta(tablero.obtenerPosicionMeta(), altoUnidad, anchoUnidad);
        //tableroGrafico.dibujarObstaculoNuevo(posicionElemento.x(),posicionElemento.y(),path+rutas.get("Meta"));*/
    }

    private Coordenada obtenerPosicionSorpresaCalleHorizontal(Coordenada posicion) {
        int posX = posicion.y()/2*largoCuadra*3/2 + largoCuadra*5/6;
        int posY = largoCuadra/3+(posicion.x()/2)*(largoCuadra*3/2);
        return new Coordenada(posX, posY);
    }

    private Coordenada obtenerPosicionMeta(Coordenada posicion) {
        int posX = (posicion.y()*(largoCuadra*3/2)+largoCuadra/4);
        int posY = (largoCuadra*tamanioMapa/30+largoCuadra*3/2)+((posicion.x())*(largoCuadra*3/2));
        return new Coordenada(posX,posY);
    }

    private Coordenada obtenerPosicionObstaculoCalleHorizontal(Coordenada posicion) {
        int posX = posicion.y()/2 * (largoCuadra*3/2) + largoCuadra*3/2;
        int posY = largoCuadra/3 + (posicion.x()/2) * (largoCuadra*3/2);
        return new Coordenada(posX, posY);
    }
    private Coordenada obtenerPosicionSorpresaCalleVertical(Coordenada posicion) {
        int posX = (posicion.y()/2)*(largoCuadra*3/2) + largoCuadra*2/5;
        int posY = largoCuadra/4+(posicion.x()/2)*(largoCuadra*3/2)+ largoCuadra*3/4;
        return new Coordenada(posX, posY);
    }

    private Coordenada obtenerPosicionObstaculoCalleVertical(Coordenada posicion) {
        int posX = (posicion.y()/2)*(largoCuadra*3/2) + largoCuadra*2/5;
        int posY = largoCuadra/4+(posicion.x()/2)*(largoCuadra*3/2)+ largoCuadra*5/4;
        return new Coordenada(posX, posY);
    }

    public void dibujarElementoCalle(double posX, double posY, String ruta){
        ImageView dibujo = new ImageView(new Image(ruta));
        dibujo.setFitHeight(largoCuadra/3d);
        dibujo.setFitWidth(largoCuadra/3d);
        dibujo.relocate(posX, posY);
        juego.getChildren().add(dibujo);
    }
}
