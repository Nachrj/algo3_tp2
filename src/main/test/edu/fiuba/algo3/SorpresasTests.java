package edu.fiuba.algo3;

import edu.fiuba.algo3.coordenada.Derecha;
import edu.fiuba.algo3.coordenada.Direccion;
import edu.fiuba.algo3.coordenada.Coordenada;
import edu.fiuba.algo3.sorpresa.CambioDeVehiculo;
import edu.fiuba.algo3.sorpresa.SorpresaDesfavorable;
import edu.fiuba.algo3.sorpresa.SorpresaFavorable;
import edu.fiuba.algo3.vehiculo.Auto;
import edu.fiuba.algo3.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.vehiculo.Moto;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

public class SorpresasTests {
    @Test
    public void test01JugadorAbreSorpresaFavorableYPierdeEl20PorcientoDeSusMovimientos(){
        Moto mockedMoto = mock(Moto.class);
        Jugador j = new Jugador("-", mockedMoto);
        Direccion d = new Derecha();
        Tablero mockedTablero = mock(Tablero.class);
        when(mockedTablero.mover(d)).thenReturn(1);
        SorpresaFavorable s = new SorpresaFavorable();

        for(int i = 0; i < 10; i++) {
            j.avanzar(d, mockedTablero);
        }

        s.activar(j);

        assertEquals(8, j.obtenerMovimientos());
    }

    @Test
    public void test02JugadorAbreSorpresaDesfavorableYSumaEl25PorcientoDeSusMovimientos(){
        Moto mockedMoto = mock(Moto.class);
        Jugador j = new Jugador("-", mockedMoto);
        Direccion d = new Derecha();
        Tablero mockedTablero = mock(Tablero.class);
        when(mockedTablero.mover(d)).thenReturn(1);
        SorpresaDesfavorable s = new SorpresaDesfavorable();

        for(int i = 0; i < 8; i++) {
            j.avanzar(d, mockedTablero);
        }

        s.activar(j);

        assertEquals(10, j.obtenerMovimientos() );
    }

    @Test
    public void test03JugadorAbreSorpresaCambioDeVehiculoCuandoTieneMotoYPasaATenerAuto(){
        Moto m = new Moto(new Coordenada(0, 0));
        Jugador j = new Jugador("x", m);
        CambioDeVehiculo s = new CambioDeVehiculo();

        s.activar(j);

        assertEquals(Auto.class, j.obtenerVehiculo().getClass());
    }

    @Test
    public void test04JugadorAbreSorpresaCambioDeVehiculoCuandoTieneAutoYPasaATener4x4(){
        Auto a = new Auto(new Coordenada( 0, 0));
        Jugador j = new Jugador("-", a);
        CambioDeVehiculo s = new CambioDeVehiculo();

        s.activar(j);

        assertEquals(CuatroXCuatro.class, j.obtenerVehiculo().getClass());
    }

    @Test
    public void test05JugadorAbreSorpresaCambioDeVehiculoCuandoTiene4x4YPasaATenerMoto(){
        CuatroXCuatro m = new CuatroXCuatro(new Coordenada(0, 0));
        Jugador j = new Jugador("x", m);
        CambioDeVehiculo s = new CambioDeVehiculo();

        s.activar(j);

        assertEquals(Moto.class, j.obtenerVehiculo().getClass());
    }
}
