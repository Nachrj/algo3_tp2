package edu.fiuba.algo3;
import edu.fiuba.algo3.model.Jugador;
import edu.fiuba.algo3.model.Tablero;
import edu.fiuba.algo3.model.TableroFalso;
import edu.fiuba.algo3.model.coordenada.*;
import edu.fiuba.algo3.model.meta.Meta;
import edu.fiuba.algo3.model.obstaculo.ControlPolicial;
import edu.fiuba.algo3.model.obstaculo.Piquete;
import edu.fiuba.algo3.model.obstaculo.Pozo;
import edu.fiuba.algo3.model.vehiculo.Auto;
import edu.fiuba.algo3.model.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.model.vehiculo.Moto;
import edu.fiuba.algo3.model.vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FuncionalidadTests {
    // moto
    // 1 calle que tiene pozo y sorpresa favorable
    // 1 calle que tiene control policial y sorpesa desfavorable
    // 1 calle que tiene piquete y cambio de vehiculo
    // 9 -> auto da la vuelta 10

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




    @Test
    public void testIntegradorMoto(){
        Moto moto = new Moto();
        Jugador j = new Jugador("j", moto);
        TableroFalso tablero = new TableroFalso(1,4,j);
        boolean gano = false;
        for (int i = 0; i<3; i++){
            if(tablero.moverJugador(new Derecha())){
                gano = true;
            }
        }
        assertTrue(gano);
        assertEquals(10, j.obtenerMovimientos());
    }

    @Test
    public void testIntegradorAuto(){
        Auto auto = new Auto();
        Jugador j = new Jugador("j", auto);
        TableroFalso tablero = new TableroFalso(1,4,j);
        boolean gano = false;
        for (int i = 0; i<3; i++){
            if(tablero.moverJugador(new Derecha())){
                gano = true;
            }
        }
        assertTrue(gano);
        assertEquals(10, j.obtenerMovimientos());
    }

    @Test
    public void testIntegrador4x4(){
        CuatroXCuatro cuatroXCuatro = new CuatroXCuatro();
        Jugador j = new Jugador("j", cuatroXCuatro);
        TableroFalso tablero = new TableroFalso(1,4,j);
        boolean gano = false;
        for (int i = 0; i<3; i++){
            if(tablero.moverJugador(new Derecha())){
                gano = true;
            }
        }
        assertTrue(gano);
        assertEquals(8, j.obtenerMovimientos());
    }
}
