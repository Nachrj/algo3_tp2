package edu.fiuba.algo3;

import edu.fiuba.algo3.model.Calle;
import edu.fiuba.algo3.model.Jugador;
import edu.fiuba.algo3.model.Tablero;
import edu.fiuba.algo3.model.coordenada.*;
import edu.fiuba.algo3.model.obstaculo.Piquete;
import edu.fiuba.algo3.model.obstaculo.Pozo;
import edu.fiuba.algo3.model.sorpresa.CambioDeVehiculo;
import edu.fiuba.algo3.model.sorpresa.SorpresaDesfavorable;
import edu.fiuba.algo3.model.sorpresa.SorpresaFavorable;
import edu.fiuba.algo3.model.vehiculo.Auto;
import edu.fiuba.algo3.model.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.model.vehiculo.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JugadorTests {
    @Test
    public void test01MotoChocaConPozoYEsPenalizadoPor3Movimientos(){
        Jugador j = new Jugador("-", new Moto(new Coordenada(0, 0)));
        Calle calle = new Calle(new Pozo());

        Tablero tablero = new Tablero(1, 2, j, calle);

        tablero.moverJugador(new Derecha());

        assertEquals( 4, j.obtenerMovimientos());
    }

    @Test
    public void test02AutoChocaConPozoYEsPenalizadoPor3Movimientos(){
        Jugador j = new Jugador("-", new Auto(new Coordenada(0, 0)));
        Calle calle = new Calle(new Pozo());

        Tablero tablero = new Tablero(1, 2, j, calle);

        tablero.moverJugador(new Derecha());

        assertEquals( 4, j.obtenerMovimientos());
    }

    @Test
    public void test034x4ChocaConPrimerPozoYNoEsPenalizado(){
        Jugador j = new Jugador("-", new CuatroXCuatro(new Coordenada(0, 0)));
        Calle calle = new Calle(new Pozo());

        Tablero tablero = new Tablero(1, 2, j, calle);

        tablero.moverJugador(new Derecha());

        assertEquals( 1, j.obtenerMovimientos());
    }

    @Test
    public void test04MotoEncuentraPiquetePenalizado2Movimientos(){
        Jugador j = new Jugador("x", new Moto(new Coordenada(0, 0)) );
        Calle calle = new Calle(new Piquete());

        Tablero tablero = new Tablero(1, 2, j, calle);

        tablero.moverJugador(new Derecha());

        assertEquals( 3, j.obtenerMovimientos());
    }
    @Test
    public void test054x4ChocaConCuartoPozoYEsPenalizado2Movimientos(){
        CuatroXCuatro camioneta = new CuatroXCuatro(new Coordenada(Math.round((float) 2/2),0));
        Jugador j = new Jugador("-", camioneta );
        Calle calle = new Calle(new Pozo());
        Tablero tablero = new Tablero(2, 2, j, calle);

        tablero.moverJugador(new Derecha());
        tablero.moverJugador(new Arriba());
        tablero.moverJugador(new Izquierda());
        tablero.moverJugador(new Abajo());

        assertEquals( 6, j.obtenerMovimientos());
    }
    @Test
    public void test06AutoEncuentraSorpresaFavorable(){
        Jugador j = new Jugador("x", new Auto(new Coordenada(0, 0)));
        Calle calle = new Calle(new SorpresaFavorable());

        Tablero tablero = new Tablero(1, 2, j, calle);

        tablero.moverJugador(new Derecha());

        assertEquals(Math.round(1 * 0.8), j.obtenerMovimientos());
    }

    @Test
    public void test07AutoEncuentraSorpresaDesfavorable(){
        Jugador j = new Jugador("-", new Auto(new Coordenada(0, 0)));
        Calle calle = new Calle(new SorpresaDesfavorable());

        Tablero tablero = new Tablero(1, 2, j, calle);

        tablero.moverJugador(new Derecha());

        assertEquals(Math.round(1 * 1.25), j.obtenerMovimientos());
    }

    @Test
    public void test08JugadorConAutoEncuentraUnaSorpresaCambioVehiculoYPasaATenerUna4x4() {
        Jugador j = new Jugador("-", new Auto(new Coordenada(0, 0)));
        Calle calle = new Calle(new CambioDeVehiculo());

        Tablero tablero = new Tablero(1, 2, j, calle);

        tablero.moverJugador(new Derecha());

        assertEquals(CuatroXCuatro.class, j.obtenerVehiculo().getClass());
    }

    @Test
    public void test09JugadorConMotoEncuentraUnaSorpresaCambioVehiculoYPasaATenerUnAuto() {
        Jugador j = new Jugador("-", new Moto(new Coordenada(0, 0)));
        Calle calle = new Calle(new CambioDeVehiculo());

        Tablero tablero = new Tablero(1, 2, j, calle);

        tablero.moverJugador(new Derecha());

        assertEquals(Auto.class, j.obtenerVehiculo().getClass());
    }

    @Test
    public void test10JugadorCon4x4EncuentraUnaSorpresaCambioVehiculoYPasaATenerUnaMoto() {
        Jugador j = new Jugador("-", new CuatroXCuatro(new Coordenada(0, 0)));
        Calle calle = new Calle(new CambioDeVehiculo());

        Tablero tablero = new Tablero(1, 2, j, calle);

        tablero.moverJugador(new Derecha());

        assertEquals(Moto.class, j.obtenerVehiculo().getClass());
    }


    @Test
    public void test11AutoEncuentraUnPozoYUnaSorpresaFavorableEnMismaCalle() {
        Jugador j = new Jugador("-", new Auto(new Coordenada(0, 0)));
        Calle calle = new Calle(new Pozo(), new SorpresaFavorable());
        Tablero tablero = new Tablero(1, 2, j, calle);

        for(int i = 0; i < 20; i++) {
            j.sumarMovimiento();
        }
        tablero.moverJugador(new Derecha());

        assertEquals((Math.round( 24 * 0.8)), j.obtenerMovimientos());
    }
}
