package edu.fiuba.algo3.jfx;
import edu.fiuba.algo3.Jugador;
import edu.fiuba.algo3.Tablero;
import edu.fiuba.algo3.coordenada.*;
import edu.fiuba.algo3.vehiculo.Auto;
import edu.fiuba.algo3.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.vehiculo.Moto;
import edu.fiuba.algo3.vehiculo.Vehiculo;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.function.Function;

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
    private String nombreVehiculo;
    private Vehiculo vehiculo;
    private Map<String, Direccion> direcciones = new HashMap<String,Direccion>();
    @Override
    public void start(Stage stage) throws Exception {

        this.crearDirecciones();
        stage.setTitle("Prueba");

        Scene escenaJuego = this.crearScreenInicial();
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
        tablero.mover(direcciones.get(tecla));
    }

    public Scene crearScreenInicial(){
        // Creamos el diseño del inicio
        Pane inicio = new Pane();

        // Titulo
        Label label = new Label("GPS Challenge");
        label.setTranslateX(210);
        label.setTranslateY(150);
        Scene escena = new Scene(inicio, 600, 600);
        crearInput(inicio, 210, 200, "Ingresa tu nombre");
        crearInputNumerico(inicio, 210, 250, "Elegir cantidad columnas");
        crearInputNumerico(inicio, 210, 300, "Elegir cantidad filas");
        Button continuar = crearBoton(inicio,210,350,"Iniciar juego");
        ObservableList<String> opciones =
                FXCollections.observableArrayList(
                        "Moto",
                            "Auto",
                        "4x4"
                );
        desplegable(inicio, 210, 400, opciones);
        continuar.setOnAction(e->{
            pasarPantalla(inicio, escena);
        });
        inicio.getChildren().add(label);
        return escena;
    }

    public Pane crearEscenaPrincipal(int columnas, int filas){
        Pane juego = new Pane();
        anchoUnidad = (int)(600/(columnas*1.5 + 0.5));
        altoUnidad = (int) (600/(filas*1.5 + 0.5));
        for(int i = 0; i < filas; i++) {
            for(int j = 0; j < columnas; j++) {
                Rectangle rectangle = new Rectangle(anchoUnidad, altoUnidad, Color.GREY);
                rectangle.setTranslateX((anchoUnidad+(int)(anchoUnidad/2))*j+30);
                rectangle.setTranslateY((altoUnidad+(int)(altoUnidad/2))*i+30);
                juego.getChildren().add(rectangle);
            }
        }

        dibujarPersonaje(juego);
        return juego;
    }
    public void dibujarPersonaje(Pane pane){
        Map<String, String> rutas = new HashMap<String,String>();
        rutas.put("Moto", "moto.png");
        rutas.put("Auto", "auto.png");
        rutas.put("4x4","4x4.png");
        String url = "auto.png";
        String path = "file:"+System.getProperty("user.dir")+"/sprites/" + rutas.get(nombreVehiculo);
        Image imagen = new Image(path, 600/(columnas+1),600/(filas+1), true, true);

        pane.getChildren().add(new ImageView(imagen));
        System.out.println("Vehiculo creado");


    }
    public Button crearBoton(Pane pane, int posx, int posy, String texto){
        Button button = new Button(texto);
        button.setTranslateX(posx);
        button.setTranslateY(posy);
        pane.getChildren().add(button);


        return button;
    }

    public void crearInput(Pane pane, int posx, int posy, String placeholder){
        TextField field = new TextField();
        field.setTranslateX(posx);
        field.setTranslateY(posy);
        // Seteamos placeholder
        field.setPromptText(placeholder);
        field.setFocusTraversable(false);
        pane.getChildren().add(field);
    }

    public void crearInputNumerico(Pane pane, int posx, int posy, String placeholder){
        TextField field = new TextField();
        field.setTranslateX(posx);
        field.setTranslateY(posy);
        // Seteamos placeholder
        field.setPromptText(placeholder);
        field.setFocusTraversable(false);
        field.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue,
                            String newValue) {
                if (!newValue.matches("\\d*")) {
                    field.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        pane.getChildren().add(field);
    }

    public void desplegable(Pane pane, int posx, int posy, ObservableList<String> opciones){
        ComboBox desplegable = new ComboBox(opciones);
        desplegable.setTranslateX(posx);
        desplegable.setTranslateY(posy);
        pane.getChildren().add(desplegable);
    }

    public void pasarPantalla(Pane pane, Scene escena){
        TextField inputNombre = (TextField)pane.getChildren().get(0);
        TextField inputColumnas = (TextField)pane.getChildren().get(1);
        TextField inputFilas = (TextField)pane.getChildren().get(2);
        ComboBox inputVehiculo = (ComboBox)pane.getChildren().get(4);
        nombreVehiculo = inputVehiculo.getValue().toString();

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
        escena.setRoot(crearEscenaPrincipal(columnas, filas));
        Jugador j = new Jugador("-", this.vehiculo);
        tablero = new Tablero(filas,columnas, j);
        System.out.println(vehiculo.getClass());
    }
}
