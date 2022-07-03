package edu.fiuba.algo3;

import edu.fiuba.algo3.coordenada.*;
import edu.fiuba.algo3.obstaculo.Piquete;
import edu.fiuba.algo3.obstaculo.Pozo;
import edu.fiuba.algo3.sorpresa.CambioDeVehiculo;
import edu.fiuba.algo3.sorpresa.SorpresaDesfavorable;
import edu.fiuba.algo3.sorpresa.SorpresaFavorable;
import edu.fiuba.algo3.vehiculo.Auto;
import edu.fiuba.algo3.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.vehiculo.Moto;
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
        Jugador j = new Jugador("-", new Moto(new Coordenada(0, 0)));
        Calle calle = new Calle( posicionJugador, c, new Pozo());
        Direccion d = new Derecha();
        Tablero mockedTablero = mock(Tablero.class);
        when(mockedTablero.mover(d)).thenReturn(calle.transitar(j, d));

        j.avanzar(d, mockedTablero );

        assertEquals( 4, j.obtenerMovimientos());
    }

    @Test
    public void test02AutoChocaConPozoYEsPenalizadoPor3Movimientos(){
        Jugador j = new Jugador("-", new Auto(new Coordenada(0, 0)));
        Calle calle = new Calle( posicionJugador, c, new Pozo());
        Direccion d = new Derecha();
        Tablero mockedTablero = mock(Tablero.class);
        when(mockedTablero.mover(d)).thenReturn(calle.transitar(j, d));

        j.avanzar( d, mockedTablero );

        assertEquals( 4, j.obtenerMovimientos());
    }

    @Test
    public void test034x4ChocaConPrimerPozoYNoEsPenalizado(){
        Jugador j = new Jugador("-", new CuatroXCuatro(new Coordenada(0, 0)));
        Calle calle = new Calle( posicionJugador, c, new Pozo());
        Direccion d = new Derecha();
        Tablero mockedTablero = mock(Tablero.class);
        when(mockedTablero.mover(d)).thenReturn(calle.transitar(j, d));

        j.avanzar( d, mockedTablero );

        assertEquals( 1, j.obtenerMovimientos());
    }

    @Test
    public void test04MotoEncuentraPiquetePenalizado2Movimientos(){
        Jugador j = new Jugador("x", new Moto(new Coordenada(0, 0)) );
        Calle calle = new Calle( new Coordenada(0,0), c, new Piquete());
        Direccion d = new Derecha();
        Tablero mockedTablero = mock(Tablero.class);
        when(mockedTablero.mover(d)).thenReturn(calle.transitar(j, d));

        j.avanzar( d, mockedTablero );

        assertEquals( 3, j.obtenerMovimientos());
    }
    @Test
    public void test054x4ChocaConCuartoPozoYEsPenalizado2Movimientos(){
        CuatroXCuatro camioneta = new CuatroXCuatro(new Coordenada(Math.round((float) 2/2),0));
        Jugador j = new Jugador("-", camioneta );
        Calle calle = new Calle( posicionJugador, c, new Pozo());
        Tablero t = new Tablero(2, 2, j, calle);

        j.avanzar(new Derecha(), t);
        j.avanzar(new Arriba(), t);
        j.avanzar(new Izquierda(), t);
        j.avanzar(new Abajo(), t);

        assertEquals( 6, j.obtenerMovimientos());
    }
    @Test
    public void test06AutoEncuentraSorpresaFavorable(){
        Jugador j = new Jugador("x", new Auto(new Coordenada(0, 0)));
        Calle calle = new Calle( posicionJugador, c, new SorpresaFavorable());
        Direccion d = new Derecha();
        Tablero mockedTablero = mock(Tablero.class);
        when(mockedTablero.mover(d)).thenReturn(calle.transitar(j, d));

        j.avanzar(d, mockedTablero);
        assertEquals(Math.round(1 * 0.8), j.obtenerMovimientos());
    }

    @Test
    public void test07AutoEncuentraSorpresaDesfavorable(){
        Jugador j = new Jugador("-", new Auto(new Coordenada(0, 0)));
        Calle calle = new Calle( posicionJugador, c, new SorpresaDesfavorable());
        Direccion d = new Derecha();
        Tablero mockedTablero = mock(Tablero.class);
        when(mockedTablero.mover(d)).thenReturn(calle.transitar(j, d));

        j.avanzar(d, mockedTablero);
        assertEquals(Math.round(1 * 1.25), j.obtenerMovimientos());
    }

    @Test
    public void test08JugadorConAutoEncuentraUnaSorpresaCambioVehiculoYPasaATenerUna4x4() {
        Calle calle = new Calle( posicionJugador, c, new CambioDeVehiculo());
        Auto m = new Auto(new Coordenada(0, 0));
        Jugador j = new Jugador("-", m);
        Direccion d = new Derecha();
        Tablero mockedTablero = mock(Tablero.class);
        when(mockedTablero.mover(d)).thenReturn(calle.transitar(j, d));

        j.avanzar(d, mockedTablero);

        assertEquals(CuatroXCuatro.class, j.obtenerVehiculo().getClass());
    }

    @Test
    public void test09JugadorConMotoEncuentraUnaSorpresaCambioVehiculoYPasaATenerUnAuto() {
        Calle calle = new Calle( posicionJugador, c, new CambioDeVehiculo());
        Moto m = new Moto(new Coordenada(0, 0));
        Jugador j = new Jugador("-", m);
        Direccion d = new Derecha();
        Tablero mockedTablero = mock(Tablero.class);
        when(mockedTablero.mover(d)).thenReturn(calle.transitar(j, d));

        j.avanzar(d, mockedTablero);

        assertEquals(Auto.class, j.obtenerVehiculo().getClass());
    }

    @Test
    public void test10JugadorCon4x4EncuentraUnaSorpresaCambioVehiculoYPasaATenerUnaMoto() {
        Calle calle = new Calle( posicionJugador, c, new CambioDeVehiculo());
        CuatroXCuatro v = new CuatroXCuatro(new Coordenada(0, 0));
        Direccion d = new Derecha();
        Jugador j = new Jugador("-", v);
        Tablero mockedTablero = mock(Tablero.class);
        when(mockedTablero.mover(d)).thenReturn(calle.transitar(j, d));

        j.avanzar(d, mockedTablero);

        assertEquals(Moto.class, j.obtenerVehiculo().getClass());
    }


    @Test
    public void test11AutoEncuentraUnPozoYUnaSorpresaFavorableEnMismaCalle() {
        Jugador j = new Jugador("-", new Auto(new Coordenada(0, 0)));
        Direccion d = new Derecha();
        // Creamos una calle sin obs. ni sorp. para aumentar movimiento totales
        Calle calleVacia = new Calle( posicionJugador, c);
        Tablero mockedTablero = mock(Tablero.class);
        when(mockedTablero.mover(d)).thenReturn(calleVacia.transitar(j, d));
        for(int i = 0; i < 20; i++) {
            j.avanzar(d, mockedTablero);
            // Como no verificamos sentido, podemos hacer 5 a la derecha con una calle
        }
        Calle calle = new Calle( posicionJugador, new Coordenada(1,0), new Pozo(), new SorpresaFavorable());
        when(mockedTablero.mover(d)).thenReturn(calle.transitar(j, d));

        j.avanzar(d, mockedTablero);
        assertEquals((Math.round( 20 * 0.8)) + 4, j.obtenerMovimientos());
    }
}
