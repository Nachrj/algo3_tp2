package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.exceptions.DimensionDeTableroInvalidaException;
import edu.fiuba.algo3.manejoarchivos.ManejoDeArchivos;
import edu.fiuba.algo3.model.Jugador;
import edu.fiuba.algo3.model.Tablero;
import edu.fiuba.algo3.model.coordenada.*;
import edu.fiuba.algo3.model.vehiculo.Auto;
import edu.fiuba.algo3.model.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.model.vehiculo.Moto;
import edu.fiuba.algo3.model.vehiculo.Vehiculo;
import edu.fiuba.algo3.viewjuego.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class JuegoController {
    private final Stage pantalla;
    private Tablero tablero;
    private int tamanioMapa;
    private String nombreJugador;
    private final Map<String, Runnable> direcciones = new HashMap<>();

    private void inicializarDirecciones(){
        direcciones.put("A", () -> tablero.moverJugador(new Izquierda()));
        direcciones.put("D", () -> tablero.moverJugador(new Derecha()));
        direcciones.put("W", () -> tablero.moverJugador(new Arriba()));
        direcciones.put("S", () -> tablero.moverJugador(new Abajo()));
        direcciones.put("LEFT", () -> tablero.moverJugador(new Izquierda()));
        direcciones.put("RIGHT", () -> tablero.moverJugador(new Derecha()));
        direcciones.put("UP", () -> tablero.moverJugador(new Arriba()));
        direcciones.put("DOWN", () -> tablero.moverJugador(new Abajo()));
    }
    private void inicializarTablero(String nombreUsuario, String nombreVehiculo, int tamanioTablero){
        Vehiculo vehiculo;
        switch(nombreVehiculo){
            case "Moto":
            default:
                vehiculo = new Moto(new Coordenada(Math.round((float) (tamanioTablero-1)/2), 0));
                break;
            case "Auto":
                vehiculo = new Auto(new Coordenada(Math.round((float) (tamanioTablero-1)/2), 0));
                break;
            case "4x4":
                vehiculo = new CuatroXCuatro(new Coordenada(Math.round((float) tamanioTablero/2), 0));
                break;
        }

        Jugador jugador = new Jugador(nombreUsuario, vehiculo);
        tablero = new Tablero(tamanioTablero, tamanioTablero, jugador);
        tamanioMapa = tamanioTablero;
        tablero.mostrarMapaPrueba();
    }

    public JuegoController(Stage pantalla){
        this.pantalla = pantalla;
        inicializarDirecciones();
    }
    public void iniciarMenuJuego(){
        Pane pantallaInicio = new PantallaInicioJuego().crearPantallaInicial();
        Scene menuInicio = new Scene(pantallaInicio, 600, 600);
        pantalla.setScene(menuInicio);
        pantalla.show();

        Button botonIniciar = (Button) pantallaInicio.lookup("#IniciarJuego");

        botonIniciar.setOnAction(e->{
            TextField inputNombre = (TextField) pantallaInicio.lookup("#NombreUsuario");
            nombreJugador = inputNombre.getText();
            if (nombreJugador.isEmpty()) {
                return;
            }

            TextField inputTamanioMapa = (TextField) pantallaInicio.lookup("#TamañoMapa");
            int tamanio = Integer.parseInt(inputTamanioMapa.getText());
            if (tamanio < 2 || tamanio > 14) {
                inputTamanioMapa.setText("");
                return;
            }

            @SuppressWarnings("unchecked")
            ComboBox<String> inputVehiculo = (ComboBox<String>) pantallaInicio.lookup("#VehiculoElegido");
            String nombreVehiculo = inputVehiculo.getValue();

            inicializarTablero(nombreJugador, nombreVehiculo, tamanio);
            iniciarJuego(tamanioMapa);
        });

        Button comoJugar = (Button) pantallaInicio.lookup("#ComoJugar");
        comoJugar.setOnAction(e->{
            PantallaExplicacion explicacion = new PantallaExplicacion();
            Scene escenaJuego = explicacion.crearPantallaExplicacion();
            Button botonRetorno = (Button) escenaJuego.lookup("#VolverAMenuExplicacion");
            botonRetorno.setOnAction(f->{
                iniciarMenuJuego();
            });
            pantalla.setScene(escenaJuego);
        });

    }

    public void iniciarJuego(int tamanioMapa){
        PantallaJuego juego = new PantallaJuego();
        Pane pantallaJuego = juego.iniciarPantallaJuego(tamanioMapa,this);
        Scene escenaJuego = new Scene(pantallaJuego, 600, 600);
        escenaJuego.setRoot(pantallaJuego);
        pantalla.setScene(escenaJuego);

        tablero.registrarObservador(juego);
        tablero.notificarObservadoresDatosTablero();
        tablero.notificarObservadoresDatosJugador();

        pantalla.show();

        escenaJuego.setOnKeyPressed(this::keyPressed);
    }

    public void keyPressed(KeyEvent event){
        String tecla = event.getCode().toString();
        try {
        direcciones.get(tecla).run();
        } catch(Exception e) {
            System.out.println("Tecla incorrecta");
        }
    }

    public void mostrarPantallaFinal(int puntajeJugador) {
        PantallaFinal pantallaFinal = new PantallaFinal();
        Scene escenaJuego = pantallaFinal.crearPantallaFinal(puntajeJugador, nombreJugador, this, tamanioMapa);
        pantalla.setScene(escenaJuego);
        pantalla.show();
    }

    public void mostrarPantallaHighscores(ManejoDeArchivos ma, int cantidadMovimientos){
        PantallaHighscores pantallaHighscores = new PantallaHighscores();
        Scene escenaHighscore = pantallaHighscores.crearPantallaHighscores(ma, tamanioMapa);

        Button botonReinicio = (Button) escenaHighscore.lookup("#SalirPantallaHighScore");

        botonReinicio.setOnAction(e -> {
            mostrarPantallaFinal(cantidadMovimientos);
        });
        pantalla.setScene(escenaHighscore);
        pantalla.show();

    }
}
