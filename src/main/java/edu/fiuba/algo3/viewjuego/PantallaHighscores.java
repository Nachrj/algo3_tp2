package edu.fiuba.algo3.viewjuego;

import edu.fiuba.algo3.manejoarchivos.ManejoDeArchivos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class PantallaHighscores extends Pane{
    public Scene crearPantallaHighscores(ManejoDeArchivos ma, int dimensiones){
        Pane root = new Pane();
        Scene scene = new Scene(root, 300, 600);
        String texto = "";
        ArrayList<ArrayList> datos = ma.cargarDatos(dimensiones);
        for(int i = 0; i < datos.get(0).size(); i++) {
            texto+= (datos.get(0).get(i) + "," + datos.get(1).get(i)+ "\n");

        }
        crearBoton(root, 50, 10, "Volver", "SalirPantallaHighScore");
        Text text = new Text(texto);
        text.setTranslateX(50);
        text.setTranslateY(100);
        text.wrappingWidthProperty().bind(scene.widthProperty());
        root.getChildren().add(text);
        return scene;
    }

    public void crearBoton(Pane pane, int posX, int posY, String texto, String id){
        Button button = new Button(texto);
        button.relocate(posX, posY);
        button.setId(id);
        pane.getChildren().add(button);
    }
}

