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
            controlador.pasarPantalla(inicio, escena);
        });
        inicio.getChildren().add(label);
        return escena;
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

    public Button crearBoton(Pane pane, int posx, int posy, String texto){
        Button button = new Button(texto);
        button.setTranslateX(posx);
        button.setTranslateY(posy);
        pane.getChildren().add(button);
        return button;
    }

    public void desplegable(Pane pane, int posx, int posy, ObservableList<String> opciones){
        ComboBox desplegable = new ComboBox(opciones);
        desplegable.setTranslateX(posx);
        desplegable.setTranslateY(posy);
        pane.getChildren().add(desplegable);
    }
}
