package edu.fiuba.algo3.jfx;

import edu.fiuba.algo3.model.Jugador;
import edu.fiuba.algo3.model.Tablero;
import edu.fiuba.algo3.coordenada.*;
import edu.fiuba.algo3.model.vehiculo.*;
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
    private int anchoUnidad;
    private int altoUnidad;

    private double posXJugador;

    private double posYJugador;
    private String nombreVehiculo;
    private Vehiculo vehiculo;
    private TableroGrafico tableroGrafico;

    private Pane juego;
    private Map<String, Direccion> direcciones = new HashMap<String,Direccion>();
    @Override
    public void start(Stage stage) throws Exception {

        this.crearDirecciones();
        stage.setTitle("Prueba");

        PantallaInicio pantallaInicio = new PantallaInicio();
        Scene escenaJuego = pantallaInicio.crearPantallaInicial(this); //viola el encapsulamiento¿?
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
    @Override
    public void handle(KeyEvent event){
        String tecla = event.getCode().toString();
        mover_jugador(tecla);
    }

    public void mover_jugador(String tecla) {
        int newX = 0;
        int newY = 0;
        switch(tecla) {
            case "W":
                newY -= altoUnidad;
                posYJugador += (newY*(1.5));
                break;
            case "A":
                newX -= anchoUnidad;
                posXJugador += (newX*(1.5));
                break;
            case "D":
                newX += anchoUnidad;
                posXJugador += (newX*(1.5));
                break;
            case "S":
                newY += anchoUnidad;
                posYJugador += (newY*(1.5));
                break;
        }
        tableroGrafico.setearPosicionesJugador(posXJugador,posYJugador);
        tablero.mover(direcciones.get(tecla));
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
        escena.setRoot(tableroGrafico.crearEscena(columnas, filas, nombreVehiculo));
        Jugador j = new Jugador("-", this.vehiculo);
        tablero = new Tablero(filas,columnas, j);
    }
}
