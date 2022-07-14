package edu.fiuba.algo3.viewjuego;

import edu.fiuba.algo3.manejoarchivos.ManejoDeArchivos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class PantallaExplicacion extends Pane{
    public Scene crearPantallaExplicacion(){
        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 600);
        String path = "file:"+System.getProperty("user.dir")+"/sprites/";

        crearImagen(path+"moto.png", 80, 80, root);
        crearLabel("Esto es una moto ta rota", 150, 100, root);
        crearImagen(path+"auto.png", 80, 150, root);
        crearLabel("Esto es un auto", 150, 150, root);
        crearImagen(path+"4x4.png", 80, 200, root);
        crearLabel("Esto es un 4x4 no ta rota", 150, 200, root);

        crearImagen(path+"sorpresa.png", 80, 250, root);
        crearLabel("Esto es una sorpresa, puede ser favorable desfavorable o cambiar de vehiculo", 150, 250, root);

        crearImagen(path+"control.png", 80, 300, root);
        crearLabel("Esto es un control, cada vehiculo tiene una probabilidad de ser penalizado", 150, 300, root);

        crearImagen(path+"pozo.png", 100, 350, root);
        crearLabel("Esto es un pozo, se puede pasar con penalizacion, el 4x4 es penalizado al tercer pozo", 150, 350, root);

        crearImagen(path+"piquete.png", 80, 380, root);
        crearLabel("Esto es un piquete, la moto puede pasar con 2 movimientos de penalizacion", 150, 400, root);


        return scene;
    }

    public void crearImagen(String path, int posx, int posy, Pane pane){
        Image imagen = new Image(path, 50,50, true, true);

        ImageView imageView = new ImageView(imagen);
        imageView.setTranslateX(posx);
        imageView.setTranslateY(posy);
        pane.getChildren().add(imageView);
    }

    public void crearLabel(String texto, int posx, int posy, Pane pane){
        Label label = new Label(texto);
        label.setTranslateX(posx);
        label.setTranslateY(posy);
        pane.getChildren().add(label);
    }

}
