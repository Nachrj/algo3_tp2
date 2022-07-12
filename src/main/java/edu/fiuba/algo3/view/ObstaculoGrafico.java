package edu.fiuba.algo3.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ObstaculoGrafico {
    public void dibujar(Pane juego, int posx, int posy, String ruta){
        //System.out.println("Quiero dibujar" + posx + posy + ruta);
        ImageView dibujo = new ImageView(new Image(ruta));
        dibujo.setFitHeight(25);
        dibujo.setFitWidth(25);
        dibujo.setTranslateX(posx);
        dibujo.setTranslateY(posy);
        juego.getChildren().add(dibujo);
    }
}
