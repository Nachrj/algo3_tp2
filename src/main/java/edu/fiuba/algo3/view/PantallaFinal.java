package edu.fiuba.algo3.view;

import edu.fiuba.algo3.jfx.Main;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class PantallaFinal extends Pane{
    public Scene crearPantallaFinal(int cantidadMovimientos) {
        Pane inicio = new Pane();

        Label titulo = new Label("Felicitaciones ganaste!\nPuntaje: " + cantidadMovimientos );
        titulo.relocate(100, 100);

        Scene escena = new Scene(inicio, 400, 200);

        inicio.getChildren().add(titulo);
        return escena;
    }
}
