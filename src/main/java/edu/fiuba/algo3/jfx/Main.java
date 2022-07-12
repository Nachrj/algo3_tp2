package edu.fiuba.algo3.jfx;
import edu.fiuba.algo3.model.Calle;
import edu.fiuba.algo3.model.Jugador;
import edu.fiuba.algo3.model.Tablero;
import edu.fiuba.algo3.model.coordenada.*;
import edu.fiuba.algo3.model.vehiculo.Auto;
import edu.fiuba.algo3.model.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.model.vehiculo.Moto;
import edu.fiuba.algo3.model.vehiculo.Vehiculo;
import edu.fiuba.algo3.view.JugadorGrafico;
import edu.fiuba.algo3.view.MarcadorGrafico;
import edu.fiuba.algo3.view.PantallaInicio;
import edu.fiuba.algo3.view.TableroGrafico;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main extends Application implements EventHandler<KeyEvent>{
    public static void main(String[] args) {
        launch(args);
    }

    Tablero tablero;
    private String nombre = "";
    private int columnas = 0;
    private int filas = 0;

    private double posXJugador;
    private TableroGrafico tableroGrafico;
    private MarcadorGrafico marcadorGrafico = new MarcadorGrafico();
    private double posYJugador;
    private String nombreVehiculo;
    private Vehiculo vehiculo;
    private Map<String, Direccion> direcciones = new HashMap<String,Direccion>();
    private Map<String, String> rutas = new HashMap<String,String>();
    private Jugador jugador;

    @Override
    public void start(Stage stage) throws Exception {
        this.crearDirecciones();
        this.rutasImagenes();
        stage.setTitle("TP2 ALGO3 GPS");

        PantallaInicio pantalla = new PantallaInicio();
        Scene escenaJuego = pantalla.crearPantallaInicial(this);
        stage.setScene(escenaJuego);
        escenaJuego.setOnKeyPressed(this);
        stage.show();
    }

    public void crearDirecciones(){
        direcciones.put("A", new Izquierda());
        direcciones.put("D", new Derecha());
        direcciones.put("W", new Arriba());
        direcciones.put("S", new Abajo());
        direcciones.put("LEFT", new Izquierda());
        direcciones.put("RIGHT", new Derecha());
        direcciones.put("UP", new Arriba());
        direcciones.put("DOWN", new Abajo());
    }

    public void rutasImagenes(){
        rutas.put("SorpresaFavorable", "sorpresa.png");
        rutas.put("SorpresaDesfavorable", "sorpresa.png");
        rutas.put("CambioDeVehiculo", "sorpresa.png");
        rutas.put("Pozo", "pozo.png");
        rutas.put("Piquete", "piquete.png");
        rutas.put("Control", "control.png");
        rutas.put("Meta", "meta.png");

    }
    @Override
    public void handle(KeyEvent event){
        String tecla = event.getCode().toString();
        moverJugadoryFondo(tecla);
    }

    public void moverJugadoryFondo(String tecla) {
        int posAntx = jugador.obtenerPosicion().x();
        int posAnty = jugador.obtenerPosicion().y();
        Direccion dir = direcciones.get(tecla);
        Vehiculo vehiculoAnterior = jugador.obtenerVehiculo();
        if(!tablero.moverJugador(dir)){
            return;
        }
        // Conseguir movimientos y los dibujamos
        marcadorGrafico.actualizarMarcador(jugador.obtenerMovimientos());

        if(posAntx == jugador.obtenerPosicion().x() && posAnty == jugador.obtenerPosicion().y()){
            return;
        }
        if(!vehiculoAnterior.equals(jugador.obtenerVehiculo())){
            tableroGrafico.cambiarImagen();
        }
        int altoUnidad = tableroGrafico.obtenerMetricasTableroAlto();
        int anchoUnidad = tableroGrafico.obtenerMetricasTableroAncho();

        double newX = 0;
        double newY = 0;
        switch(tecla) {
            case "W":
                newY -= altoUnidad*1.5;
                break;
            case "A":
                newX -= anchoUnidad*1.5;
                break;
            case "D":
                newX += anchoUnidad*1.5;
                break;
            case "S":
                newY += anchoUnidad*1.5;
                break;
            case "UP":
                newY -= altoUnidad*1.5;
                break;
            case "LEFT":
                newX -= anchoUnidad*1.5;
                break;
            case "RIGHT":
                newX += anchoUnidad*1.5;
                break;
            case "DOWN":
                newY += anchoUnidad*1.5;
                break;
        }
        tableroGrafico.actualizarPosicionesJugador(newX, newY);
    }

    public void pasarPantalla(Pane pane, Scene escena){
        TextField inputNombre = (TextField)pane.getChildren().get(0);
        TextField inputColumnas = (TextField)pane.getChildren().get(1);
        TextField inputFilas = (TextField)pane.getChildren().get(2);
        ComboBox inputVehiculo = (ComboBox)pane.getChildren().get(4);
        nombreVehiculo = inputVehiculo.getValue().toString();

        tableroGrafico = new TableroGrafico();

        //Temporal
        vehiculo = new Moto(new Coordenada(Math.round((float) 2/2),0));
        if(nombreVehiculo.equals("Moto")){
            vehiculo = new Moto(new Coordenada(Math.round((float) 2/2),0));
        }

        if(nombreVehiculo.equals("Auto")){
            vehiculo = new Auto(new Coordenada(Math.round((float) 2/2),0));
        }

        if(nombreVehiculo.equals("4x4")){
            vehiculo = new CuatroXCuatro(new Coordenada(Math.round((float) 2/2),0));
        }

        nombre = inputNombre.getText();
        columnas = Integer.valueOf(inputColumnas.getText());
        filas = Integer.valueOf(inputFilas.getText());
        escena.setRoot(tableroGrafico.crearEscena(columnas, filas, nombreVehiculo, marcadorGrafico));
        int anchoUnidad = tableroGrafico.obtenerMetricasTableroAncho();
        int altoUnidad = tableroGrafico.obtenerMetricasTableroAlto();

        jugador = new Jugador("-", this.vehiculo);
        tablero = new Tablero(filas, columnas, jugador);

        String path = "file:" + System.getProperty("user.dir") + "/sprites/";
        ArrayList<String> nombreObstaculos = new ArrayList<>();
        ArrayList<String> nombreSorpresas = new ArrayList<>();
        ArrayList<Coordenada> posiciones = new ArrayList<>();
        ArrayList<Boolean> esHorizontal = new ArrayList<>();

        tablero.cargarDatosCalles(nombreObstaculos, nombreSorpresas, posiciones, esHorizontal);
        Coordenada posicionElemento;

        for(int i = 0; i < posiciones.size(); i++){
            if(esHorizontal.get(i)){
                posicionElemento = obtenerPosicionObstaculoCalleHorizontal(posiciones.get(i), altoUnidad, anchoUnidad);
                tableroGrafico.dibujarObstaculoNuevo(posicionElemento.x(),posicionElemento.y(), path + rutas.get(nombreObstaculos.get(i)));

                posicionElemento = obtenerPosicionSorpresaCalleHorizontal(posiciones.get(i), altoUnidad, anchoUnidad);
                tableroGrafico.dibujarObstaculoNuevo(posicionElemento.x(),posicionElemento.y(), path+rutas.get(nombreSorpresas.get(i)));
            }
            else {
                posicionElemento = obtenerPosicionObstaculoCalleVertical(posiciones.get(i), altoUnidad, anchoUnidad);
                tableroGrafico.dibujarObstaculoNuevo(posicionElemento.x(),posicionElemento.y(), path+rutas.get(nombreObstaculos.get(i)));

                posicionElemento = obtenerPosicionSorpresaCalleVertical(posiciones.get(i), altoUnidad, anchoUnidad);
                tableroGrafico.dibujarObstaculoNuevo(posicionElemento.x(),posicionElemento.y(), path+rutas.get(nombreSorpresas.get(i)));
            }
        }
        posicionElemento = obtenerPosicionSorpresaCalleVertical(tablero.obtenerPosicionMeta(), altoUnidad, anchoUnidad);
        tableroGrafico.dibujarObstaculoNuevo(posicionElemento.x(),posicionElemento.y(),path+rutas.get("Meta"));
        tableroGrafico.dibujarFondoNegro();

    }
    private Coordenada obtenerPosicionSorpresaCalleHorizontal(Coordenada posicion, int altoUnidad, int anchoUnidad) {
        int posX = posicion.y()/2*altoUnidad*3/2 + anchoUnidad*5/6;
        int posY = anchoUnidad/3+(posicion.x()/2)*(anchoUnidad*3/2);
        return new Coordenada(posX, posY);
    }

    private Coordenada obtenerPosicionObstaculoCalleHorizontal(Coordenada posicion, int altoUnidad, int anchoUnidad) {
        int posX = posicion.y()/2 * (altoUnidad*3/2) + anchoUnidad*3/2;
        int posY = anchoUnidad/3 + (posicion.x()/2) * (anchoUnidad*3/2);
        return new Coordenada(posX, posY);
    }
    private Coordenada obtenerPosicionSorpresaCalleVertical(Coordenada posicion, int altoUnidad, int anchoUnidad) {
        int posX = (posicion.y()/2)*(altoUnidad*3/2) + anchoUnidad*2/5;
        int posY = anchoUnidad/4+(posicion.x()/2)*(anchoUnidad*3/2)+ altoUnidad*3/4;
        return new Coordenada(posX, posY);
    }

    private Coordenada obtenerPosicionObstaculoCalleVertical(Coordenada posicion, int altoUnidad, int anchoUnidad) {
        int posX = (posicion.y()/2)*(altoUnidad*3/2) + anchoUnidad*2/5;
        int posY = anchoUnidad/4+(posicion.x()/2)*(anchoUnidad*3/2)+ altoUnidad*5/4;
        return new Coordenada(posX, posY);
    }
}
