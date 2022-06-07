package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class TestsJugador {
    @Test
    public void test01MotoChocaConPozoYEsPenalizadoPor3Movimientos(){
        Jugador j = new Jugador("x", new Moto(), new Coordenada(0,0) );
        Calle calle = new Calle( new Coordenada(0,0), new Coordenada(0,1), new Pozo(), null );
        Tablero tablero = new Tablero( calle );

        j.avanzar( "derecha", tablero );

        assertEquals( 4, j.obtenerMovimientos());
    }

    @Test
    public void test02AutoChocaConPozoYEsPenalizadoPor3Movimientos(){
        Jugador j = new Jugador("x", new Auto(), new Coordenada(0,0) );
        Calle calle = new Calle( new Coordenada(0,0), new Coordenada(0,1), new Pozo(), null );
        Tablero tablero = new Tablero( calle );

        j.avanzar( "derecha", tablero );

        assertEquals( 4, j.obtenerMovimientos());
    }

    @Test
    public void test034x4ChocaConPozoYNoEsPenalizado(){
        Jugador j = new Jugador("x", new CuatroxCuatro(), new Coordenada(0,0) );
        Calle calle = new Calle( new Coordenada(0,0), new Coordenada(0,1), new Pozo(), null );
        Tablero tablero = new Tablero( calle );

        j.avanzar( "derecha", tablero );

        assertEquals( 1, j.obtenerMovimientos());
    }

    @Test
    public void test04MotoEncuentraPiquetePenalizado2Movimientos(){
        Jugador j = new Jugador("x", new Moto(), new Coordenada(0,0) );
        Calle calle = new Calle( new Coordenada(0,0), new Coordenada(0,1), new Piquete(), null );
        Tablero tablero = new Tablero( calle );

        j.avanzar( "derecha", tablero );

        assertEquals( 3, j.obtenerMovimientos());
    }

    @Test
    public void test05AutoEncuentraPiqueteNoSeMueve(){
        Jugador j = new Jugador("x", new Moto(), new Coordenada(0,0) );
        Calle calle = new Calle( new Coordenada(0,0), new Coordenada(0,1), new Piquete(), "None" );
        Tablero tablero = new Tablero( calle );

        j.avanzar( "derecha", tablero );
        assertEquals( 1, j.obtenerMovimientos());
        Coordenada coordenada = new Coordenada(0,0);
        assertEquals(true, coordenada.equals(tablero.obtenerCoordenada()));
    }
}
