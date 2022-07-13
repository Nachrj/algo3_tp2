package edu.fiuba.algo3.view;

import edu.fiuba.algo3.jfx.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class PantallaInicio extends Pane {

    public Scene crearPantallaInicial(Main controlador){
        Pane inicio = new Pane();

        Label titulo = new Label("GPS Challenge");
        titulo.relocate(210, 150);

        Scene escena = new Scene(inicio, 600, 600);
        crearInput(inicio, 210, 200, "Ingresa tu nombre");
        crearInputNumerico(inicio, 210, 250, "Elegir cantidad columnas");
        crearInputNumerico(inicio, 210, 300, "Elegir cantidad filas");
        Button continuar = crearBoton(inicio,210,350,"Iniciar juego");

        ObservableList<String> opciones = FXCollections.observableArrayList("Moto", "Auto", "4x4");
        desplegable(inicio, 210, 400, opciones);

        continuar.setOnAction(e->{
            controlador.pasarPantalla(inicio, escena);
        });
        inicio.getChildren().add(titulo);
        return escena;
    }

    public void crearInput(Pane pane, int posX, int posY, String promptText){
        TextField textField = new TextField();
        textField.relocate(posX, posY);
        textField.setPromptText(promptText);
        textField.setFocusTraversable(false);
        pane.getChildren().add(textField);
    }

    public void crearInputNumerico(Pane pane, int posX, int posY, String promptText){
        TextField textField = new TextField();
        textField.relocate(posX, posY);
        textField.setPromptText(promptText);
        textField.setFocusTraversable(false);
        textField.textProperty().addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    textField.setText(newValue.replaceAll("\\D", ""));
                }
            }
        });
        pane.getChildren().add(textField);
    }

    public Button crearBoton(Pane pane, int posX, int posY, String texto){
        Button button = new Button(texto);
        button.relocate(posX, posY);
        pane.getChildren().add(button);
        return button;
    }

    public void desplegable(Pane pane, int posX, int posY, ObservableList<String> opciones){
        ComboBox<String> desplegable = new ComboBox<>(opciones);
        desplegable.relocate(posX, posY);
        pane.getChildren().add(desplegable);
    }
}