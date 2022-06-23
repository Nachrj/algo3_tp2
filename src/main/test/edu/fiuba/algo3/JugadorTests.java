package edu.fiuba.algo3;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class JugadorTests {

    Coordenada posicionJugador;
    Coordenada c;
    @BeforeEach
    public void init() {
        this.posicionJugador = new Coordenada(0, 0);
        this.c = new Coordenada(1, 0);
    }

    @Test
    public void test01MotoChocaConPozoYEsPenalizadoPor3Movimientos(){
        Jugador j = new Jugador("-", new Moto());
        Calle calle = new Calle( posicionJugador, c, new Pozo());
        Direccion d = new Derecha();
        Tablero mockedTablero = mock(Tablero.class);
        when(mockedTablero.mover(d)).thenReturn(calle.transitar(j));

        j.avanzar(d, mockedTablero );

        assertEquals( 4, j.obtenerMovimientos());
    }

    @Test
    public void test02AutoChocaConPozoYEsPenalizadoPor3Movimientos(){
        Jugador j = new Jugador("-", new Auto());
        Calle calle = new Calle( posicionJugador, c, new Pozo());
        Direccion d = new Derecha();
        Tablero mockedTablero = mock(Tablero.class);
        when(mockedTablero.mover(d)).thenReturn(calle.transitar(j));

        j.avanzar( d, mockedTablero );

        assertEquals( 4, j.obtenerMovimientos());
    }

    @Test
    public void test034x4ChocaConPrimerPozoYNoEsPenalizado(){
        Jugador j = new Jugador("-", new CuatroXCuatro() );
        Calle calle = new Calle( posicionJugador, c, new Pozo());
        Direccion d = new Derecha();
        Tablero mockedTablero = mock(Tablero.class);
        when(mockedTablero.mover(d)).thenReturn(calle.transitar(j));

        j.avanzar( d, mockedTablero );

        assertEquals( 1, j.obtenerMovimientos());
    }

    @Test
    public void test04MotoEncuentraPiquetePenalizado2Movimientos(){
        Jugador j = new Jugador("x", new Moto() );
        Calle calle = new Calle( new Coordenada(0,0), c, new Piquete());
        Direccion d = new Derecha();
        Tablero mockedTablero = mock(Tablero.class);
        when(mockedTablero.mover(d)).thenReturn(calle.transitar(j));

        j.avanzar( d, mockedTablero );

        assertEquals( 3, j.obtenerMovimientos());
    }

    /*@Test
    public void test054x4ChocaConCuartoPozoYEsPenalizado2Movimientos(){
        Jugador j = new Jugador("-", new CuatroXCuatro() );
        Calle calle = new Calle( posicionJugador, c, new Pozo());
        Direccion d = new Derecha();
        // ToDo-> por alguna razón no pasa la prueba con el mockedTablero
        Tablero mockedTablero = mock(Tablero.class);
        when(mockedTablero.mover(d)).thenReturn(calle.transitar(j), calle.transitar(j), calle.transitar(j), calle.transitar(j));

        for(int i = 1; i <= 3; i++){
            j.avanzar( d, mockedTablero );
        }

        assertEquals( 6, j.obtenerMovimientos());
    }*/

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
        Direccion d = new Derecha();
        Tablero mockedTablero = mock(Tablero.class);
        when(mockedTablero.mover(d)).thenReturn(calle.transitar(j));

        j.avanzar(d, mockedTablero);
        assertEquals(Math.round(1 * 0.8), j.obtenerMovimientos());
    }

    @Test
    public void test07AutoEncuentraSorpresaDesfavorable(){
        Jugador j = new Jugador("-", new Auto());
        Calle calle = new Calle( posicionJugador, c, new SorpresaDesfavorable());
        Direccion d = new Derecha();
        Tablero mockedTablero = mock(Tablero.class);
        when(mockedTablero.mover(d)).thenReturn(calle.transitar(j));

        j.avanzar(d, mockedTablero);
        assertEquals(Math.round(1 * 1.25), j.obtenerMovimientos());
    }

    @Test
    public void test08JugadorConAutoEncuentraUnaSorpresaCambioVehiculoYPasaATenerUna4x4() {
        Calle calle = new Calle( posicionJugador, c, new CambioDeVehiculo());
        Auto m = new Auto();
        Jugador j = new Jugador("-", m);
        Direccion d = new Derecha();
        Tablero mockedTablero = mock(Tablero.class);
        when(mockedTablero.mover(d)).thenReturn(calle.transitar(j));

        j.avanzar(d, mockedTablero);

        assertEquals(CuatroXCuatro.class, j.obtenerVehiculo().getClass());
    }

    @Test
    public void test09JugadorConMotoEncuentraUnaSorpresaCambioVehiculoYPasaATenerUnAuto() {
        Calle calle = new Calle( posicionJugador, c, new CambioDeVehiculo());
        Moto m = new Moto();
        Jugador j = new Jugador("-", m);
        Direccion d = new Derecha();
        Tablero mockedTablero = mock(Tablero.class);
        when(mockedTablero.mover(d)).thenReturn(calle.transitar(j));

        j.avanzar(d, mockedTablero);

        assertEquals(Auto.class, j.obtenerVehiculo().getClass());
    }

    @Test
    public void test10JugadorCon4x4EncuentraUnaSorpresaCambioVehiculoYPasaATenerUnaMoto() {
        Calle calle = new Calle( posicionJugador, c, new CambioDeVehiculo());
        CuatroXCuatro v = new CuatroXCuatro();
        Direccion d = new Derecha();
        Jugador j = new Jugador("-", v);
        Tablero mockedTablero = mock(Tablero.class);
        when(mockedTablero.mover(d)).thenReturn(calle.transitar(j));

        j.avanzar(d, mockedTablero);

        assertEquals(Moto.class, j.obtenerVehiculo().getClass());
    }


    @Test
    public void test11AutoEncuentraUnPozoYUnaSorpresaFavorableEnMismaCalle() {
        Jugador j = new Jugador("-", new Auto());
        Direccion d = new Derecha();
        // Creamos una calle sin obs. ni sorp. para aumentar movimiento totales
        Calle calleVacia = new Calle( posicionJugador, c);
        Tablero mockedTablero = mock(Tablero.class);
        when(mockedTablero.mover(d)).thenReturn(calleVacia.transitar(j));
        for(int i = 0; i < 20; i++) {
            j.avanzar(d, mockedTablero);
            // Como no verificamos sentido, podemos hacer 5 a la derecha con una calle
        }
        Calle calle = new Calle( posicionJugador, new Coordenada(1,0), new Pozo(), new SorpresaFavorable());
        when(mockedTablero.mover(d)).thenReturn(calle.transitar(j));

        j.avanzar(d, mockedTablero);
        assertEquals((Math.round( 20 * 0.8)) + 4, j.obtenerMovimientos());
    }
}
