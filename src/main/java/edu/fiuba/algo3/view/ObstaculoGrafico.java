package edu.fiuba.algo3.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ObstaculoGrafico {
    public void dibujar(Pane juego, double posX, double posY, String ruta, int anchuraUnidad, int alturaUnidad ){
        //System.out.println("Quiero dibujar" + posx + posy + ruta);
        ImageView dibujo = new ImageView(new Image(ruta));
        dibujo.setFitHeight(alturaUnidad/3d);
        dibujo.setFitWidth(anchuraUnidad/3d);
        dibujo.relocate(posX, posY);
        juego.getChildren().add(dibujo);
    }
}
