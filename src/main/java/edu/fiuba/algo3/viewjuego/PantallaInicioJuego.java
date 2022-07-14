package edu.fiuba.algo3.viewjuego;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class PantallaInicioJuego extends Pane{
    public Pane crearPantallaInicial(){
        Pane inicio = new Pane();

        Label titulo = new Label("GPS Challenge");
        titulo.relocate(210, 150);

        crearInput(inicio, 210, 200, "Ingresa tu nombre", "NombreUsuario");
        crearInputNumerico(inicio, 210, 250, "Elegir tamaño del mapa", "TamañoMapa");
        crearBoton(inicio,210,350,"Iniciar juego", "IniciarJuego");
        crearBoton(inicio, 210, 450, "Como Jugar", "ComoJugar");
        ObservableList<String> opciones = FXCollections.observableArrayList("Moto", "Auto", "4x4");
        desplegable(inicio, 210, 400, opciones, "VehiculoElegido");

        inicio.getChildren().add(titulo);
        return inicio;
    }

    public void crearInput(Pane pane, int posX, int posY, String promptText, String id){
        TextField textField = new TextField();
        textField.relocate(posX, posY);
        textField.setPromptText(promptText);
        textField.setFocusTraversable(false);
        textField.setId(id);
        pane.getChildren().add(textField);
    }

    public void crearInputNumerico(Pane pane, int posX, int posY, String promptText, String id){
        TextField textField = new TextField();
        textField.relocate(posX, posY);
        textField.setPromptText(promptText);
        textField.setFocusTraversable(false);
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                textField.setText(newValue.replaceAll("\\D", ""));
            }
        });
        textField.setId(id);
        pane.getChildren().add(textField);
    }

    public void crearBoton(Pane pane, int posX, int posY, String texto, String id){
        Button button = new Button(texto);
        button.relocate(posX, posY);
        button.setId(id);
        pane.getChildren().add(button);
    }

    public void desplegable(Pane pane, int posX, int posY, ObservableList<String> opciones, String id){
        ComboBox<String> desplegable = new ComboBox<>(opciones);
        desplegable.getSelectionModel().selectFirst();
        desplegable.relocate(posX, posY);
        desplegable.setId(id);
        pane.getChildren().add(desplegable);
    }
}
