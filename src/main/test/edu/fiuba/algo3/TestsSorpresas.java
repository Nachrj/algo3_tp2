package edu.fiuba.algo3;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestsSorpresas {
    @Test
    public void test01JugadorAbreSorpresaFavorableYPierdeEl20PorcientoDeSusMovimientos(){
        Moto mockedMoto = mock(Moto.class);
        Jugador j = new Jugador("x", mockedMoto);
        Tablero mockedTablero = mock(Tablero.class);
        when(mockedTablero.mover(mockedMoto)).thenReturn(10);
        SorpresaFavorable s = new SorpresaFavorable();

        j.avanzar("arriba", mockedTablero);
        s.activar(j);

        assertEquals(8, j.obtenerMovimientos() );
    }

    @Test
    public void test02JugadorAbreSorpresaDesfavorableYSumaEl25PorcientoDeSusMovimientos(){
        Moto mockedMoto = mock(Moto.class);
        Jugador j = new Jugador("x", mockedMoto);
        Tablero mockedTablero = mock(Tablero.class);
        when(mockedTablero.mover(mockedMoto)).thenReturn(8);
        SorpresaDesfavorable s = new SorpresaDesfavorable();

        j.avanzar("arriba", mockedTablero);
        s.activar(j);

        assertEquals(10, j.obtenerMovimientos() );
    }

    @Test
    public void test03JugadorAbreSorpresaCambioDeVehiculoCuandoTieneMotoYPasaATenerAuto(){
        Moto m = new Moto();
        Jugador j = new Jugador("x", m);
        CambioDeVehiculo s = new CambioDeVehiculo();

        s.activar(j);

        assertEquals(Auto.class, j.obtenerVehiculo().getClass());
    }

    @Test
    public void test04JugadorAbreSorpresaCambioDeVehiculoCuandoTieneAutoYPasaATener4x4(){
        Auto m = new Auto();
        Jugador j = new Jugador("x", m);
        CambioDeVehiculo s = new CambioDeVehiculo();

        s.activar(j);

        assertEquals(CuatroXCuatro.class, j.obtenerVehiculo().getClass());
    }

    @Test
    public void test05JugadorAbreSorpresaCambioDeVehiculoCuandoTiene4x4YPasaATenerMoto(){
        CuatroXCuatro m = new CuatroXCuatro();
        Jugador j = new Jugador("x", m);
        CambioDeVehiculo s = new CambioDeVehiculo();

        s.activar(j);

        assertEquals(Moto.class, j.obtenerVehiculo().getClass());
    }
}
