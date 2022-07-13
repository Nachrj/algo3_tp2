package edu.fiuba.algo3.view;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public class MarcadorGrafico {
    private final Label marcador = new Label();
    private int numero_movimientos = 0;

    public void dibujarMarcador(Pane juego) {
        marcador.setText("Numero de movimientos:" + numero_movimientos);
        marcador.setTextFill(Color.GREY);
        juego.getChildren().add(marcador);
    }

    public void moverAdelante() {
        marcador.toFront();
    }

    public void actualizarMarcador(int movimientos) {
        numero_movimientos = movimientos;
        marcador.setText("Numero de movimientos:" + numero_movimientos);

        System.out.println(numero_movimientos);
    }
}
