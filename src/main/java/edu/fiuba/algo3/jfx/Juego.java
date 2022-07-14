package edu.fiuba.algo3.jfx;

import edu.fiuba.algo3.manejoarchivos.ManejoDeArchivos;
import javafx.application.Application;
import javafx.stage.Stage;

import edu.fiuba.algo3.controlador.JuegoController;

public class Juego extends Application {
    public static void main(String[] args){
        launch();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("TP2 ALGO3 GPS");
        JuegoController controlador = new JuegoController(stage);
        controlador.iniciarMenuJuego();
    }
}
