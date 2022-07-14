package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.model.Jugador;
import edu.fiuba.algo3.model.Tablero;
import edu.fiuba.algo3.model.coordenada.Coordenada;
import edu.fiuba.algo3.model.vehiculo.Auto;
import edu.fiuba.algo3.model.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.model.vehiculo.Moto;
import edu.fiuba.algo3.model.vehiculo.Vehiculo;
import edu.fiuba.algo3.viewjuego.PantallaInicioJuego;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class JuegoController {
    private final Stage pantalla;
    private Tablero tablero;

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
        tablero.mostrarMapaPrueba();
    }

    public JuegoController(Stage pantalla){
        this.pantalla = pantalla;
    }
    public void iniciarMenuJuego(){
        Pane pantallaInicio = new PantallaInicioJuego().crearPantallaInicial();
        Scene menuInicio = new Scene(pantallaInicio, 600, 600);
        pantalla.setScene(menuInicio);
        pantalla.show();

        Button botonIniciar = (Button) pantallaInicio.lookup("#IniciarJuego");

        botonIniciar.setOnAction(e->{
            TextField inputNombre = (TextField) pantallaInicio.lookup("#NombreUsuario");
            String nombreUsuario = inputNombre.getText();

            TextField inputTamanioMapa = (TextField) pantallaInicio.lookup("#TamañoMapa");
            int tamanio = Integer.parseInt(inputTamanioMapa.getText());

            @SuppressWarnings("unchecked")
            ComboBox<String> inputVehiculo = (ComboBox<String>) pantallaInicio.lookup("#VehiculoElegido");
            String nombreVehiculo = inputVehiculo.getValue();
            if(nombreVehiculo == null)
                nombreVehiculo = "";

            inicializarTablero(nombreUsuario, nombreVehiculo, tamanio);
            pantalla.close();
        });
    }

}
