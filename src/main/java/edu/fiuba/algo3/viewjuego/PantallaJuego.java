package edu.fiuba.algo3.viewjuego;

import edu.fiuba.algo3.controlador.JuegoController;
import edu.fiuba.algo3.model.ObserverTablero;
import edu.fiuba.algo3.model.coordenada.Coordenada;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PantallaJuego extends Pane implements ObserverTablero {
    private int tamanioMapa;
    private int largoCuadra;
    private Pane juego;
    private ImageView jugador = null;
    private ImageView imagenFondoNegro = null;
    private final Map<String, String> rutas = new HashMap<>();
    private JuegoController controlador;

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
    public Pane iniciarPantallaJuego(int tamanioMapa, JuegoController controlador){
        this.controlador = controlador;
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

        actualizarFondoNegro(posXJugador, posYJugador);
        actualizarMarcador(cantidadMovimientos);

        if(alcanzoMeta){
            controlador.mostrarPantallaFinal(cantidadMovimientos);
        }
    }

    private void actualizarFondoNegro(double posX, double posY){
        if(imagenFondoNegro == null){
            String path = "file:"+System.getProperty("user.dir") + "/sprites/fondo_negro_circulo.png";
            Image imagen = new Image(path, 4000-tamanioMapa*200, 4000-tamanioMapa*200, true, true);
            imagenFondoNegro = new ImageView(imagen);
            juego.getChildren().add(imagenFondoNegro);
        }
        imagenFondoNegro.relocate(posX-((4000-tamanioMapa*200)/2d) + largoCuadra/2d, posY-((4000-tamanioMapa*200)/2d));
    }

    private void actualizarMarcador(int cantidadMovimientos){
        Label marcador = new Label();
        // Este if es necesario porque sino cuando bajas de 10 movimientos a 9, te queda el 0 al final y parece 90
        if(cantidadMovimientos<10){
            marcador.setText("Numero de movimientos: " + cantidadMovimientos + "  ");
        }else{
            marcador.setText("Numero de movimientos: " + cantidadMovimientos);
        }
        marcador.relocate(40, largoCuadra*1.5*(tamanioMapa-0.25) );
        marcador.setMinWidth(70);
        marcador.setMinHeight(10);
        marcador.setFont(new Font("Arial", 15));
        marcador.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, null, null)));

        juego.getChildren().add(marcador);
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

        double posXMeta = posicionMeta.y()*largoCuadra*1.5 + largoCuadra/2d;
        double posYMeta = posicionMeta.x()*largoCuadra*1.5 + largoCuadra/3d;
        dibujarElementoCalle(posXMeta, posYMeta,path+rutas.get("Meta"));
    }

    private Coordenada obtenerPosicionSorpresaCalleHorizontal(Coordenada posicion) {
        int posX = posicion.y()/2*largoCuadra*3/2 + largoCuadra*5/6;
        int posY = largoCuadra/3+(posicion.x()/2)*(largoCuadra*3/2);
        return new Coordenada(posX, posY);
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
