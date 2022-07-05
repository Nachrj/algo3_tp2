package edu.fiuba.algo3;

import edu.fiuba.algo3.model.coordenada.Derecha;
import edu.fiuba.algo3.model.coordenada.Direccion;
import edu.fiuba.algo3.model.coordenada.Coordenada;
import edu.fiuba.algo3.model.Jugador;
import edu.fiuba.algo3.model.Tablero;
import edu.fiuba.algo3.model.sorpresa.CambioDeVehiculo;
import edu.fiuba.algo3.model.sorpresa.SorpresaDesfavorable;
import edu.fiuba.algo3.model.sorpresa.SorpresaFavorable;
import edu.fiuba.algo3.model.vehiculo.Auto;
import edu.fiuba.algo3.model.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.model.vehiculo.Moto;
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
        when(mockedTablero.mover(d)).thenReturn(10);
        SorpresaFavorable s = new SorpresaFavorable();

        j.avanzar(d, mockedTablero);
        s.activar(j);

        assertEquals(8, j.obtenerMovimientos() );
    }

    @Test
    public void test02JugadorAbreSorpresaDesfavorableYSumaEl25PorcientoDeSusMovimientos(){
        Moto mockedMoto = mock(Moto.class);
        Jugador j = new Jugador("-", mockedMoto);
        Direccion d = new Derecha();
        Tablero mockedTablero = mock(Tablero.class);
        when(mockedTablero.mover(d)).thenReturn(8);
        SorpresaDesfavorable s = new SorpresaDesfavorable();

        j.avanzar(d, mockedTablero);
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
