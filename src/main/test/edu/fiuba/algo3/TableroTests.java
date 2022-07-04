package edu.fiuba.algo3;

import edu.fiuba.algo3.coordenada.Coordenada;
import edu.fiuba.algo3.coordenada.Izquierda;
import edu.fiuba.algo3.model.Jugador;
import edu.fiuba.algo3.model.Tablero;
import edu.fiuba.algo3.model.vehiculo.Moto;
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
        Jugador j = new Jugador("-", new Moto() );
        Tablero t = new Tablero(3,3, j);

        t.mover(new Izquierda());

        assertEquals(0, j.obtenerMovimientos());
    }
}
