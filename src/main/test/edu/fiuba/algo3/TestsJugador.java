package edu.fiuba.algo3;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class TestsJugador {

    Coordenada posicionJugador;
    Coordenada c;
    @BeforeEach
    public void init() {
        this.posicionJugador = new Coordenada(0, 0);
        this.c = new Coordenada(1, 0);
    }

    @Test
    public void test01MotoChocaConPozoYEsPenalizadoPor3Movimientos(){
        Jugador j = new Jugador("x", new Moto());
        Calle calle = new Calle( posicionJugador, c, new Pozo());
        Tablero tablero = new Tablero( calle, posicionJugador );

        j.avanzar( "derecha", tablero );

        assertEquals( 4, j.obtenerMovimientos());
    }

    @Test
    public void test02AutoChocaConPozoYEsPenalizadoPor3Movimientos(){
        Jugador j = new Jugador("x", new Auto());
        Calle calle = new Calle( posicionJugador, c, new Pozo());
        Tablero tablero = new Tablero( calle, posicionJugador);

        j.avanzar( "derecha", tablero );

        assertEquals( 4, j.obtenerMovimientos());
    }

    @Test
    public void test034x4ChocaConPrimerPozoYNoEsPenalizado(){
        Jugador j = new Jugador("x", new CuatroXCuatro() );
        Calle calle = new Calle( posicionJugador, c, new Pozo());
        Tablero tablero = new Tablero( calle, posicionJugador );

        j.avanzar( "derecha", tablero );

        assertEquals( 1, j.obtenerMovimientos());
    }

    @Test
    public void test04MotoEncuentraPiquetePenalizado2Movimientos(){
        Jugador j = new Jugador("x", new Moto() );
        Calle calle = new Calle( new Coordenada(0,0), c, new Piquete());
        Tablero tablero = new Tablero( calle, posicionJugador );

        j.avanzar( "derecha", tablero );

        assertEquals( 3, j.obtenerMovimientos());
    }

    @Test
    public void test054x4ChocaConCuartoPozoYEsPenalizado2Movimientos(){
        Jugador j = new Jugador("x", new CuatroXCuatro() );
        Calle calle = new Calle( posicionJugador, c, new Pozo());
        Tablero tablero = new Tablero( calle, posicionJugador );
        for(int i = 0; i <= 3; i++){
            j.avanzar( "derecha", tablero );
        }

        assertEquals( 6, j.obtenerMovimientos());
    }

/*    @Test
    public void test05AutoEncuentraPiqueteNoSeMueve(){
        Jugador j = new Jugador("x", new Moto() );
        Coordenada posicionJugador = new Coordenada(0,0);
        Calle calle = new Calle( new Coordenada(0,0), new Coordenada(1,0), new Piquete());
        Tablero tablero = new Tablero( calle, posicionJugador );

        j.avanzar( "derecha", tablero );
        assertEquals( 1, j.obtenerMovimientos());
        Coordenada coordenada = new Coordenada(0,0);
        assertEquals(true, coordenada.equals(tablero.obtenerCoordenada()));
    }*/

    @Test
    public void test06AutoEncuentraSorpresaFavorable(){
        Jugador j = new Jugador("x", new Auto());
        Calle calle = new Calle( posicionJugador, c, new SorpresaFavorable());
        Tablero tablero = new Tablero( calle, posicionJugador );

        j.avanzar("derecha", tablero);
        assertEquals(Math.round(1 * 0.8), j.obtenerMovimientos());
    }

    @Test
    public void test07AutoEncuentraSorpresaDesfavorable(){
        Jugador j = new Jugador("x", new Auto());
        Calle calle = new Calle( posicionJugador, c, new SorpresaDesfavorable());
        Tablero tablero = new Tablero( calle, posicionJugador );

        j.avanzar("derecha", tablero);
        assertEquals(Math.round(1 * 1.25), j.obtenerMovimientos());
    }

    @Test
    public void test08JugadorConAutoEncuentraUnaSorpresaCambioVehiculoYPasaATenerUna4x4() {
        Calle calle = new Calle( posicionJugador, c, new CambioDeVehiculo());
        Tablero tablero = new Tablero( calle, posicionJugador);
        Auto m = new Auto();
        Jugador j = new Jugador("x", m);

        j.avanzar("derecha", tablero);

        assertEquals(CuatroXCuatro.class, j.obtenerVehiculo().getClass());
    }

    @Test
    public void test09JugadorConMotoEncuentraUnaSorpresaCambioVehiculoYPasaATenerUnAuto() {
        Calle calle = new Calle( posicionJugador, c, new CambioDeVehiculo());
        Tablero tablero = new Tablero( calle, posicionJugador);
        Moto m = new Moto();
        Jugador j = new Jugador("x", m);

        j.avanzar("derecha", tablero);

        assertEquals(Auto.class, j.obtenerVehiculo().getClass());
    }

    @Test
    public void test10JugadorCon4x4EncuentraUnaSorpresaCambioVehiculoYPasaATenerUnaMoto() {
        Calle calle = new Calle( posicionJugador, c, new CambioDeVehiculo());
        Tablero tablero = new Tablero( calle, posicionJugador);
        CuatroXCuatro v = new CuatroXCuatro();
        Jugador j = new Jugador("x", v);

        j.avanzar("derecha", tablero);

        assertEquals(Moto.class, j.obtenerVehiculo().getClass());
    }


    @Test
    public void test11AutoEncuentraUnPozoYUnaSorpresaFavorableEnMismaCalle() {
        Jugador j = new Jugador("x", new Auto());
        // Creamos una calle sin obs. ni sorp. para aumentar movimiento totales
        Calle calle_vacia = new Calle( posicionJugador, c);
        Tablero tablero_sin_nada = new Tablero( calle_vacia, posicionJugador);
        for(int i = 0; i < 20; i++) {
            j.avanzar("derecha", tablero_sin_nada);
            // Como no verificamos sentido, podemos hacer 5 a la derecha con una calle
        }

        Calle calle = new Calle( posicionJugador, new Coordenada(1,0), new Pozo(), new SorpresaFavorable());
        Tablero tablero = new Tablero( calle, posicionJugador );

        j.avanzar("derecha", tablero);
        assertEquals((Math.round( 20 * 0.8)) + 4, j.obtenerMovimientos());
    }

}
