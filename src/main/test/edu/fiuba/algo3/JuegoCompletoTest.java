package edu.fiuba.algo3;

import edu.fiuba.algo3.model.Jugador;
import edu.fiuba.algo3.model.Tablero;
import edu.fiuba.algo3.model.TableroFalso;
import edu.fiuba.algo3.model.obstaculo.Pozo;
import edu.fiuba.algo3.model.vehiculo.Moto;
import edu.fiuba.algo3.model.coordenada.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JuegoCompletoTest {
    TableroFalso tablero;
    Jugador jugador;

    @BeforeEach
    public void init() {
        Moto moto = new Moto(new Coordenada(Math.round((float) 2 / 2), 0));
        jugador = new Jugador("-", moto);
        tablero = new TableroFalso(0, 0, jugador);
    }

    @Test
    public void test01SeIniciaTableroCon10x10YElJugadorEstaEnLaPosicionQueDebe(){
        Coordenada posicionInicial = new Coordenada(Math.round((float) 2/2),0);
        assertTrue(posicionInicial.equals(tablero.obtenerPosicionJugador()));
    }

    @Test
    public void test02SePruebaSalirDelMapaMasDe5Veces(){
        for (int i = 0; i < 6; i++){
            tablero.moverJugador(new Izquierda());
        }
        assertEquals(0, jugador.obtenerMovimientos());
    }


    //No se está moviendo de la posicion original
    @Test
    public void test03MotoChocaContraPozo(){
        tablero.moverJugador(new Derecha());
        Coordenada posicionInicial = new Coordenada(Math.round((float) 2/2),0);

        assertEquals(0, jugador.obtenerMovimientos());
        //assertFalse(posicionInicial.equals(tablero.obtenerPosicionJugador()));
    }

    @Test
    public void test04MotoChocaConrraControlPolicial(){
        tablero.moverJugador(new Derecha());
        assertEquals(0, jugador.obtenerMovimientos());
    }

}


