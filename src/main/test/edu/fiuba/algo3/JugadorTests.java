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
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class JugadorTests {
    @Test
    public void test01MotoChocaConPozoYEsPenalizadoPor3Movimientos(){
        Jugador j = new Jugador("-", new Moto(new Coordenada(0, 0)));
        Calle calle = new Calle(new Pozo());

        Tablero tablero = new Tablero(1, 2, j, calle);

        j.avanzar(new Derecha(), tablero );

        assertEquals( 4, j.obtenerMovimientos());
    }

    @Test
    public void test02AutoChocaConPozoYEsPenalizadoPor3Movimientos(){
        Jugador j = new Jugador("-", new Auto(new Coordenada(0, 0)));
        Calle calle = new Calle(new Pozo());

        Tablero tablero = new Tablero(1, 2, j, calle);

        j.avanzar(new Derecha(), tablero );

        assertEquals( 4, j.obtenerMovimientos());
    }

    @Test
    public void test034x4ChocaConPrimerPozoYNoEsPenalizado(){
        Jugador j = new Jugador("-", new CuatroXCuatro(new Coordenada(0, 0)));
        Calle calle = new Calle(new Pozo());

        Tablero tablero = new Tablero(1, 2, j, calle);

        j.avanzar(new Derecha(), tablero );

        assertEquals( 1, j.obtenerMovimientos());
    }

    @Test
    public void test04MotoEncuentraPiquetePenalizado2Movimientos(){
        Jugador j = new Jugador("x", new Moto(new Coordenada(0, 0)) );
        Calle calle = new Calle(new Piquete());

        Tablero tablero = new Tablero(1, 2, j, calle);

        j.avanzar(new Derecha(), tablero );

        assertEquals( 3, j.obtenerMovimientos());
    }
    @Test
    public void test054x4ChocaConCuartoPozoYEsPenalizado2Movimientos(){
        CuatroXCuatro camioneta = new CuatroXCuatro(new Coordenada(Math.round((float) 2/2),0));
        Jugador j = new Jugador("-", camioneta );
        Calle calle = new Calle(new Pozo());
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
        Calle calle = new Calle(new SorpresaFavorable());

        Tablero tablero = new Tablero(1, 2, j, calle);

        j.avanzar(new Derecha(), tablero );

        assertEquals(Math.round(1 * 0.8), j.obtenerMovimientos());
    }

    @Test
    public void test07AutoEncuentraSorpresaDesfavorable(){
        Jugador j = new Jugador("-", new Auto(new Coordenada(0, 0)));
        Calle calle = new Calle(new SorpresaDesfavorable());

        Tablero tablero = new Tablero(1, 2, j, calle);

        j.avanzar(new Derecha(), tablero );

        assertEquals(Math.round(1 * 1.25), j.obtenerMovimientos());
    }

    @Test
    public void test08JugadorConAutoEncuentraUnaSorpresaCambioVehiculoYPasaATenerUna4x4() {
        Jugador j = new Jugador("-", new Auto(new Coordenada(0, 0)));
        Calle calle = new Calle(new CambioDeVehiculo());

        Tablero tablero = new Tablero(1, 2, j, calle);

        j.avanzar(new Derecha(), tablero );

        assertEquals(CuatroXCuatro.class, j.obtenerVehiculo().getClass());
    }

    @Test
    public void test09JugadorConMotoEncuentraUnaSorpresaCambioVehiculoYPasaATenerUnAuto() {
        Jugador j = new Jugador("-", new Moto(new Coordenada(0, 0)));
        Calle calle = new Calle(new CambioDeVehiculo());

        Tablero tablero = new Tablero(1, 2, j, calle);

        j.avanzar(new Derecha(), tablero );

        assertEquals(Auto.class, j.obtenerVehiculo().getClass());
    }

    @Test
    public void test10JugadorCon4x4EncuentraUnaSorpresaCambioVehiculoYPasaATenerUnaMoto() {
        Jugador j = new Jugador("-", new CuatroXCuatro(new Coordenada(0, 0)));
        Calle calle = new Calle(new CambioDeVehiculo());

        Tablero tablero = new Tablero(1, 2, j, calle);

        j.avanzar(new Derecha(), tablero );

        assertEquals(Moto.class, j.obtenerVehiculo().getClass());
    }


    @Test
    public void test11AutoEncuentraUnPozoYUnaSorpresaFavorableEnMismaCalle() {
        Jugador j = new Jugador("-", new Auto(new Coordenada(0, 0)));
        Direccion d = new Derecha();
        Tablero mockedTablero = mock(Tablero.class);
        when(mockedTablero.mover(d)).thenReturn(1);
        Calle calle = new Calle(new Pozo(), new SorpresaFavorable());
        Tablero tablero = new Tablero(1, 2, j, calle);

        for(int i = 0; i < 20; i++) {
            j.avanzar(d, mockedTablero);
        }
        j.avanzar(d, tablero);

        assertEquals((Math.round( 20 * 0.8)) + 4, j.obtenerMovimientos());
    }
}
