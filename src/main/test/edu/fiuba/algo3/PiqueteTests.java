package edu.fiuba.algo3;

import edu.fiuba.algo3.model.coordenada.Arriba;
import edu.fiuba.algo3.model.coordenada.Coordenada;
import edu.fiuba.algo3.model.coordenada.Derecha;
import edu.fiuba.algo3.model.Calle;
import edu.fiuba.algo3.model.Jugador;
import edu.fiuba.algo3.model.Tablero;
import edu.fiuba.algo3.model.obstaculo.Piquete;
import edu.fiuba.algo3.model.vehiculo.Auto;
import edu.fiuba.algo3.model.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.model.vehiculo.Moto;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

public class PiqueteTests {
    Piquete p;
    @BeforeEach
    public void init(){
        this.p = new Piquete();
    }

    @Test
    public void test01MotoChocaConPiqueteYPenalizaCon2Movimientos(){
        Derecha d = new Derecha();
        Moto mockedMoto = mock(Moto.class);

        assertEquals(2, p.chocar(mockedMoto, d));
    }

    @Test
    public void test02AutoChocaConPiqueteYNoPuedeAvanzar(){
        Auto auto = new Auto(new Coordenada(Math.round((float) 2/2),0));
        Jugador j = new Jugador("-", auto);
        Calle c = new Calle();
        c.agregarObstaculo(new Piquete());
        Tablero t = new Tablero(2, 2, j, c);

        Coordenada posicionFinalEsperada = new Coordenada(Math.round((float) 2/2),0);

        j.avanzar(new Derecha(), t);
        j.avanzar(new Arriba(), t);

        assertTrue(j.obtenerPosicion().equals(posicionFinalEsperada));
    }

    @Test
    public void test034x4ChocaConPiqueteYNoPuedeAvanzar(){
        CuatroXCuatro camioneta = new CuatroXCuatro(new Coordenada(Math.round((float) 2/2),0));
        Jugador j = new Jugador("-", camioneta);
        Calle c = new Calle();
        c.agregarObstaculo(new Piquete());
        Tablero t = new Tablero(2, 2, j, c);

        Coordenada posicionFinalEsperada = new Coordenada(Math.round((float) 2/2),0);

        j.avanzar(new Derecha(), t);
        j.avanzar(new Arriba(), t);

        assertTrue(j.obtenerPosicion().equals(posicionFinalEsperada));
    }

    @Test
    public void test04MotoChocaConPiqueteYPuedeAvanzar(){
        Moto moto = new Moto(new Coordenada(Math.round((float) 2/2),0));
        Jugador j = new Jugador("-", moto);
        Calle c = new Calle();
        c.agregarObstaculo(new Piquete());
        Tablero t = new Tablero(2, 2, j, c);

        Coordenada posicionFinalEsperada = new Coordenada(Math.round((float) 2/2),0);

        j.avanzar(new Derecha(), t);
        posicionFinalEsperada.sumarCoordenadas(new Derecha().mover());

        j.avanzar(new Arriba(), t);
        posicionFinalEsperada.sumarCoordenadas(new Arriba().mover());

        assertTrue(j.obtenerPosicion().equals(posicionFinalEsperada));
    }

    @Test
    public void test05AutoChocaConPiquete2vecesYJugadorSuma2Movimientos(){
        Auto auto = new Auto(new Coordenada(Math.round((float) 2/2),0));
        Jugador j = new Jugador("-", auto);
        Calle c = new Calle();
        c.agregarObstaculo(new Piquete());
        Tablero t = new Tablero(2, 2, j, c);

        j.avanzar(new Derecha(), t);
        j.avanzar(new Arriba(), t);

        assertEquals(2, j.obtenerMovimientos());
    }

    @Test
    public void test064x4ChocaConPiquete2vecesYJugadorSuma2Movimientos(){
        CuatroXCuatro camioneta = new CuatroXCuatro(new Coordenada(Math.round((float) 2/2),0));
        Jugador j = new Jugador("-", camioneta);
        Calle c = new Calle();
        c.agregarObstaculo(new Piquete());
        Tablero t = new Tablero(2, 2, j, c);

        j.avanzar(new Derecha(), t);
        j.avanzar(new Arriba(), t);

        assertEquals(2, j.obtenerMovimientos());
    }
}

