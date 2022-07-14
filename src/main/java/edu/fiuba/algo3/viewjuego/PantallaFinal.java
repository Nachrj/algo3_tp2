package edu.fiuba.algo3.viewjuego;

import edu.fiuba.algo3.controlador.JuegoController;
import edu.fiuba.algo3.manejoarchivos.ManejoDeArchivos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class PantallaFinal extends Pane{

    public Scene crearPantallaFinal(int cantidadMovimientos, String nombreJugador, JuegoController controlador, int dimensiones) {
        Pane inicio = new Pane();

        Label titulo = new Label("Felicitaciones ganaste!\nPuntaje: " + cantidadMovimientos );
        titulo.relocate(100, 100);
        crearBoton(inicio, 145,150, "Volver a Jugar", "ReiniciarJuego");

        ManejoDeArchivos ma = new ManejoDeArchivos();
        ma.guardarDatos(nombreJugador, cantidadMovimientos, dimensiones);

        Scene escena = new Scene(inicio, 400, 200);

        crearBoton(inicio, 145, 180,"Ver Highscores", "highscores");
        Button mostrarHighscores = (Button) inicio.lookup("#highscores");
        mostrarHighscores.setOnAction(e -> {
            controlador.mostrarPantallaHighscores(ma);
        });
        inicio.getChildren().add(titulo);
        return escena;
    }

    public void crearBoton(Pane pane, int posX, int posY, String texto, String id){
        Button button = new Button(texto);
        button.relocate(posX, posY);
        button.setId(id);
        pane.getChildren().add(button);
    }
}
