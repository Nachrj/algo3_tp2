package edu.fiuba.algo3;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Pane;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    private String nombre = "";
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Prueba");

        // Creamos el diseño del tablero
        Pane juego = new Pane();

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                Rectangle rectangle = new Rectangle(40, 40, Color.GREY);
                rectangle.setTranslateX((40+15)*j+30);
                rectangle.setTranslateY((40+15)*i+30);
                juego.getChildren().add(rectangle);
            }
        }

        // Creamos el diseño del inicio
        Pane inicio = new Pane();

        // Titulo
        Label label = new Label("GPS Challenge");
        label.setTranslateX(210);
        label.setTranslateY(200);

        TextField field = new TextField();
        field.setTranslateX(210);
        field.setTranslateY(250);
        // Seteamos placeholder
        field.setPromptText("Ingresa tu nombre");
        field.setFocusTraversable(false);

        Button button = new Button();
        button.setText("Iniciar juego");
        button.setTranslateX(210);
        button.setTranslateY(300);

        inicio.getChildren().add(label);
        inicio.getChildren().add(field);
        inicio.getChildren().add(button);

        Scene scene = new Scene(inicio, 600, 600);
        stage.setScene(scene);

        button.setOnAction(e->{
            scene.setRoot(juego);
            nombre = field.getText();
            System.out.println(nombre);
        });

        stage.show();
    }
}
