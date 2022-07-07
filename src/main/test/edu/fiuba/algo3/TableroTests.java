package edu.fiuba.algo3;

import edu.fiuba.algo3.coordenada.Coordenada;
import edu.fiuba.algo3.coordenada.*;
import edu.fiuba.algo3.vehiculo.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TableroTests {
    @Test
    public void test01SeCreaTableroJugadorAvanzaHaciaIzquierdaYNoEscapaDelTablero(){
        Moto moto = new Moto(new Coordenada(Math.round((float) 2/2),0));
        Jugador j = new Jugador("-", moto);
        Tablero t = new Tablero(3,3, j);
        Coordenada posicionInicial = new Coordenada(Math.round((float) 2/2),0);

        t.mover(new Izquierda());

        assertTrue(posicionInicial.equals(t.obtenerPosicionJugador()));
    }

    @Test
    public void test02SeCreaTableroJugadorIntentaEscaparDelTableroYNoSumaMovimientos(){
        Jugador j = new Jugador("-", new Moto(new Coordenada(Math.round((float) 2/2),0)));
        Tablero t = new Tablero(3,3, j, new Calle());

        j.avanzar(new Izquierda(), t);

        assertEquals(0, j.obtenerMovimientos());
    }

    @Test
    public void test03SeCreaTableroJugadorAvanzaHaciaDerechaYNoEscapaDelTablero(){
        Moto moto = new Moto(new Coordenada(Math.round((float) 8/2),0));
        Jugador j = new Jugador("-", moto);
        Tablero t = new Tablero(8,8, j, new Calle());
        Coordenada posicionFinal = new Coordenada(Math.round((float) 8/2),7);

        for(int i = 0; i < 20; i++) {
            t.mover(new Derecha());
        }

        assertTrue(posicionFinal.equals(t.obtenerPosicionJugador()));
    }

    @Test
    public void test04SeCreaTableroJugadorAvanzaHaciaAbajoYNoEscapaDelTablero(){
        Moto moto = new Moto(new Coordenada(Math.round((float) 5/2),0));
        Jugador j = new Jugador("-", moto);
        Tablero t = new Tablero(5,5, j);
        Coordenada posicionFinal = new Coordenada(4,0);

        for(int i = 0; i < 20; i++) {
            t.mover(new Abajo());
        }

        assertTrue(posicionFinal.equals(t.obtenerPosicionJugador()));
    }

    @Test
    public void test05SeCreaTableroJugadorAvanzaHaciaArribaYNoEscapaDelTablero(){
        Moto moto = new Moto(new Coordenada(Math.round((float) 12/2),0));
        Jugador j = new Jugador("-", moto);
        Tablero t = new Tablero(12,12, j);
        Coordenada posicionFinal = new Coordenada(0, 0);


        for(int i = 0; i < 20; i++) {
            t.mover(new Arriba());
        }

        assertTrue(posicionFinal.equals(t.obtenerPosicionJugador()));
    }
}
