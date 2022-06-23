package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TableroTests {
    @Test
    public void test01SeCreaTableroJugadorAvanzaHaciaIzquierdaYNoEscapaDelTablero(){
        Jugador j = new Jugador("-", new Moto() );
        Tablero t = new Tablero(3,3, j);
        Coordenada posicionInicial = t.obtenerPosicionJugador();

        t.mover(new Izquierda());

        assertEquals(posicionInicial, t.obtenerPosicionJugador());
    }

    @Test
    public void test02SeCreaTableroJugadorIntentaEscaparDelTableroYNoSumaMovimientos(){
        Jugador j = new Jugador("-", new Moto() );
        Tablero t = new Tablero(3,3, j);

        t.mover(new Izquierda());

        assertEquals(0, j.obtenerMovimientos());
    }


}
