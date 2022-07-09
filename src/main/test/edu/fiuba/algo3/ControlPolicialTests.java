package edu.fiuba.algo3;

import edu.fiuba.algo3.model.GeneradorNumeros;
import edu.fiuba.algo3.model.obstaculo.ControlPolicial;
import edu.fiuba.algo3.model.vehiculo.Auto;
import edu.fiuba.algo3.model.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.model.vehiculo.Moto;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

public class ControlPolicialTests {
    GeneradorNumeros mockedGenerador = mock(GeneradorNumeros.class);
    ControlPolicial control = new ControlPolicial(mockedGenerador);

    @Test
    public void test01MotoChocaConControlPolicialYSeGeneranNumerosEntre1y8YSuma3MovimientosPorCadaChoque(){
        when(mockedGenerador.obtenerNumeroAleatorio(1, 10)).thenReturn(1,2, 3, 4, 5, 6, 7, 8 );
        Moto moto = new Moto();
        int contador = 0;

        for(int i = 1; i <= 8; i++){
            contador += control.chocar(moto);
        }

        assertEquals(contador, 8*3);
    }

    @Test
    public void test02MotoChocaConControlPolicialYSeGeneranNumerosEntre9y10YNoSumaMovimientosPorCadaChoque(){
        when(mockedGenerador.obtenerNumeroAleatorio(1, 10)).thenReturn(9,10 );
        Moto moto = new Moto();
        int contador = 0;

        for(int i = 9; i <= 10; i++){
            contador += control.chocar(moto);
        }

        assertEquals(contador, 0);
    }

    @Test
    public void test03AutoChocaConControlPolicialYSeGeneranNumerosEntre1y5YSuma3MovimientosPorCadaChoque(){
        when(mockedGenerador.obtenerNumeroAleatorio(1, 10)).thenReturn(1,2, 3, 4, 5 );
        Auto auto = new Auto();
        int contador = 0;

        for(int i = 1; i <= 5; i++){
            contador += control.chocar(auto);
        }

        assertEquals(contador, 5*3);
    }

    @Test
    public void test04AutoChocaConControlPolicialYSeGeneranNumerosEntre6y10YNoSumaMovimientosPorCadaChoque(){
        when(mockedGenerador.obtenerNumeroAleatorio(1, 10)).thenReturn( 6, 7, 8, 9, 10 );
        Auto auto = new Auto();
        int contador = 0;

        for(int i = 6; i <= 10; i++){
            contador += control.chocar(auto);
        }

        assertEquals(contador, 0);
    }

    @Test
    public void test054x4ChocaConControlPolicialYSeGeneranNumerosEntre1y3YSuma3MovimientosPorCadaChoque(){
        when(mockedGenerador.obtenerNumeroAleatorio(1, 10)).thenReturn(1,2, 3 );
        CuatroXCuatro camioneta = new CuatroXCuatro();
        int contador = 0;

        for(int i = 1; i <= 3; i++){
            contador += control.chocar(camioneta);
        }

        assertEquals(contador, 3*3);
    }

    @Test
    public void test06MotoChocaConControlPolicialYSeGeneranNumerosEntre4y10YNoSuma3MovimientosPorCadaChoque(){
        when(mockedGenerador.obtenerNumeroAleatorio(1, 10)).thenReturn( 4, 5, 6, 7, 8, 9, 10 );
        CuatroXCuatro camioneta = new CuatroXCuatro();
        int contador = 0;

        for(int i = 4; i <= 10; i++){
            contador += control.chocar(camioneta);
        }

        assertEquals(contador, 0);
    }
}
