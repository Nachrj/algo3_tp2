package edu.fiuba.algo3.jfx;
import edu.fiuba.algo3.model.Calle;
import edu.fiuba.algo3.model.Jugador;
import edu.fiuba.algo3.model.Tablero;
import edu.fiuba.algo3.model.coordenada.*;
import edu.fiuba.algo3.model.obstaculo.ControlPolicial;
import edu.fiuba.algo3.model.obstaculo.Pozo;
import edu.fiuba.algo3.model.sorpresa.SorpresaFavorable;
import edu.fiuba.algo3.model.vehiculo.Auto;
import edu.fiuba.algo3.model.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.model.vehiculo.Moto;
import edu.fiuba.algo3.model.vehiculo.Vehiculo;
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
    private double posXJugador;
    private TableroGrafico tableroGrafico;
    private double posYJugador;
    private String nombreVehiculo;
    private Vehiculo vehiculo;
    private Map<String, Direccion> direcciones = new HashMap<String,Direccion>();
    private Map<String, String> rutas = new HashMap<String,String>();

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
        Direccion dir = direcciones.get(tecla);
        if(!tablero.moverJugador(dir)){
            return;
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
        }
        //tablero.moverJugador(dir);
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
        escena.setRoot(tableroGrafico.crearEscena(columnas, filas, nombreVehiculo));
        int anchoUnidad = tableroGrafico.obtenerMetricasTableroAncho();
        int altoUnidad = tableroGrafico.obtenerMetricasTableroAlto();

        Jugador jugador = new Jugador("-", this.vehiculo);
        Calle callePrueba = new Calle(new ControlPolicial(), new SorpresaFavorable());
        tablero = new Tablero(filas, columnas, jugador);
        Calle[][] calle = tablero.obtenerMapa();

        // ToDo -> que mapa tenga una funcion para obtener el nombre de la calle directamente y busca la forma en que no necesite
        // ToDo -> saber la logica del for (sacar el 2*fila - 1)
        String path = "file:" + System.getProperty("user.dir") + "/sprites/";

        for(int fila = 0; fila <= 2*(filas - 1); fila++ ){
            for(int columna = 0; columna <= 2*(columnas - 1); columna++){
                //filas par
                if( (fila % 2 == 0 && columna % 2 != 0) ){
                    System.out.println("Fila par");

                    String nombre = calle[columna][fila].obtenerObstaculo().obtenerNombre();
                    tableroGrafico.dibujarObstaculoNuevo((columna/2)*(altoUnidad*3/2) + anchoUnidad/6*5,anchoUnidad/3+(fila/2)*(anchoUnidad*3/2), path+rutas.get(nombre));

                    String nombreSorpresa = calle[fila][columna].obtenerSorpresa().obtenerNombre();
                    tableroGrafico.dibujarObstaculoNuevo((columna/2)*(altoUnidad*3/2) + anchoUnidad/6*9,anchoUnidad/3+(fila/2)*(anchoUnidad*3/2), path+rutas.get(nombreSorpresa));
                }
                //filas impar
                if(fila % 2 != 0 && columna % 2 == 0){
                    System.out.println("Fila impar");
                    String nombre = calle[columna][fila].obtenerObstaculo().obtenerNombre();
                    tableroGrafico.dibujarObstaculoNuevo((columna/2)*(altoUnidad*3/2) + anchoUnidad*2/5,anchoUnidad/4+(fila/2)*(anchoUnidad*3/2)+ altoUnidad*3/4, path+rutas.get(nombre));

                    String nombreSorpresa = calle[fila][columna].obtenerSorpresa().obtenerNombre();
                    tableroGrafico.dibujarObstaculoNuevo((columna/2)*(altoUnidad*3/2) + anchoUnidad*2/5,anchoUnidad/4+(fila/2)*(anchoUnidad*3/2)+ altoUnidad*5/4, path+rutas.get(nombreSorpresa));
                    System.out.println("Hay una sorpresa en la calle fila: " + fila + " columna: " + columna);
                }
            }
        }
        //tableroGrafico.dibujarFondoNegro(); //esto va ultimo para que la imagen quede arriba de todo
    }
}
