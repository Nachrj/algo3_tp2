package edu.fiuba.algo3;

import edu.fiuba.algo3.model.GeneradorNumeros;
import edu.fiuba.algo3.model.Jugador;
import edu.fiuba.algo3.model.TableroFalso;
import edu.fiuba.algo3.model.coordenada.Derecha;
import edu.fiuba.algo3.model.obstaculo.ControlPolicial;
import edu.fiuba.algo3.model.vehiculo.Auto;
import edu.fiuba.algo3.model.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.model.vehiculo.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FuncionalidadTests {
    // moto
    // 1 calle que tiene pozo y sorpresa favorable
    // 1 calle que tiene control policial y sorpesa desfavorable
    // 1 calle que tiene piquete y cambio de vehiculo
    // 9 -> auto da la vuelta 12

    // auto
    // 1 calle que tiene pozo y sorpresa favorable
    // 1 calle que tiene control policial y sorpesa desfavorable
    // 1 calle que tiene piquete y cambio de vehiculo
    // 9 -> 4x4 da la vuelta 10

    // 4x4
    // 1 calle que tiene pozo y sorpresa favorable
    // 1 calle que tiene control policial y sorpesa desfavorable
    // 1 calle que tiene piquete y cambio de vehiculo
    // 5 -> moto 7

    GeneradorNumeros mockedGenerador = mock(GeneradorNumeros.class);

    @Test
    public void testIntegradorMoto(){
        Moto moto = new Moto();
        Jugador j = new Jugador("j", moto);
        TableroFalso tablero = new TableroFalso(1,4,j, mockedGenerador);
        int cantidadMovimientosSinObstaculos = 0;
        boolean gano = false;
        for (int i = 0; i<3; i++){
            if(tablero.moverJugador(new Derecha())){
                gano = true;
            }
            cantidadMovimientosSinObstaculos += 1;
        }
        assertTrue(gano);
        assertEquals(12, j.obtenerMovimientos());
        assertEquals(3, cantidadMovimientosSinObstaculos);//pasó por 3 calles
    }

    @Test
    public void testIntegradorAuto(){
        Auto auto = new Auto();
        Jugador j = new Jugador("j", auto);
        TableroFalso tablero = new TableroFalso(1,4,j, mockedGenerador);
        int cantidadMovimientosSinObstaculos = 0;
        boolean gano = false;
        for (int i = 0; i<3; i++){
            if(tablero.moverJugador(new Derecha())){
                gano = true;
            }
            cantidadMovimientosSinObstaculos += 1;
        }
        assertTrue(gano);
        assertEquals(10, j.obtenerMovimientos());
        assertEquals(3, cantidadMovimientosSinObstaculos);
    }

    @Test
    public void testIntegrador4x4(){
        CuatroXCuatro cuatroXCuatro = new CuatroXCuatro();
        Jugador j = new Jugador("j", cuatroXCuatro);
        TableroFalso tablero = new TableroFalso(1,4,j, mockedGenerador);
        int cantidadMovimientosSinObstaculos = 0;
        boolean gano = false;
        for (int i = 0; i<3; i++){
            System.out.println("Antes "+ j.obtenerMovimientos());
            if(tablero.moverJugador(new Derecha())){
                gano = true;
            }
            System.out.println(j.obtenerMovimientos());
            cantidadMovimientosSinObstaculos += 1;
        }
        assertTrue(gano);
        assertEquals(7, j.obtenerMovimientos());
        assertEquals(3, cantidadMovimientosSinObstaculos);
    }
}
