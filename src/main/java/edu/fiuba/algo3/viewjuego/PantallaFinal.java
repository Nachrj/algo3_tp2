package edu.fiuba.algo3.viewjuego;

import edu.fiuba.algo3.manejoarchivos.ManejoDeArchivos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class PantallaFinal extends Pane{
    public Scene crearPantallaFinal(int cantidadMovimientos, String nombreJugador) {
        Pane inicio = new Pane();

        Label titulo = new Label("Felicitaciones ganaste!\nPuntaje: " + cantidadMovimientos );
        titulo.relocate(100, 100);

        ManejoDeArchivos ma = new ManejoDeArchivos();
        ma.guardarDatos(nombreJugador, cantidadMovimientos);

        Scene escena = new Scene(inicio, 400, 200);

        inicio.getChildren().add(titulo);
        return escena;
    }
}
