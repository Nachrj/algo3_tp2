package edu.fiuba.algo3;

import edu.fiuba.algo3.coordenada.*;
import org.junit.jupiter.api.Test;

public class DireccionTests {
    //para las coordenadas se cuenta como las cuentan las matrices
    //La fila (x) aumenta hacia abajo e 'y' es la columna
    @Test
    public void test01moverArribaDejaACoordenadaUnaPosicionMenosEnEjeX(){
        Coordenada c = new Coordenada(4, 6);

        c.sumarCoordenadas((new Arriba()).mover());

        assert((new Coordenada(3,6)).equals(c));
    }

    @Test
    public void test02moverAbajoDejaACoordenadaUnaPosicionMasEnEjeX(){
        Coordenada c = new Coordenada(4, 6);

        c.sumarCoordenadas((new Abajo()).mover());

        assert((new Coordenada(5,6)).equals(c));
    }

    @Test
    public void test03moverIzquierdaDejaACoordenadaUnaPosicionMenosEnEjeY(){
        Coordenada c = new Coordenada(4, 6);

        c.sumarCoordenadas((new Izquierda()).mover());

        assert((new Coordenada(4,5)).equals(c));
    }

    @Test
    public void test04moverDerechaDejaACoordenadaUnaPosicionMasEnEjeY(){
        Coordenada c = new Coordenada(4, 6);

        c.sumarCoordenadas((new Derecha()).mover());

        assert((new Coordenada(4,7)).equals(c));
    }

    @Test
    public void test05OpuestoDeArribaEsAbajo(){
        Coordenada c = new Coordenada(0, 0);

        c.sumarCoordenadas((new Arriba()).direccionOpuesta().mover());

        assert((new Coordenada(1,0)).equals(c));
    }

    @Test
    public void test06OpuestoDeAbajoEsArriba(){
        Coordenada c = new Coordenada(0, 0);

        c.sumarCoordenadas((new Abajo()).direccionOpuesta().mover());

        assert((new Coordenada(-1,0)).equals(c));
    }

    @Test
    public void test07OpuestoDeIzquierdaEsDerecha(){
        Coordenada c = new Coordenada(0, 0);

        c.sumarCoordenadas((new Izquierda()).direccionOpuesta().mover());

        assert((new Coordenada(0,1)).equals(c));
    }

    @Test
    public void test05OpuestoDeDerechaEsIzquierda(){
        Coordenada c = new Coordenada(0, 0);

        c.sumarCoordenadas((new Derecha()).direccionOpuesta().mover());

        assert((new Coordenada(0,-1)).equals(c));
    }

}
