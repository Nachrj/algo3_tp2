package edu.fiuba.algo3;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestsPozo{

    @Test
    public void test01MotoChocaConPozoYPenalizaCon3Movimientos(){
        Pozo mockedPozo = mock(Pozo.class);
        Moto m = new Moto();
        when(mockedPozo.chocar(m)).thenReturn(3);
        assertEquals(3, mockedPozo.chocar(m));
    }

    @Test
    public void test02AutoChocaConPozoYPenalizaCon3Movimientos(){
        Pozo mockedPozo = mock(Pozo.class);
        Auto a = new Auto();
        when(mockedPozo.chocar(a)).thenReturn(3);
        assertEquals(3, mockedPozo.chocar(a));
    }

    @Test
    public void test034x4ChocaConPrimerPozoYNoPenaliza(){
        Pozo mockedPozo = mock(Pozo.class);
        CuatroXCuatro c = new CuatroXCuatro();
        when(mockedPozo.chocar(c)).thenReturn(0);
        assertEquals(0, mockedPozo.chocar(c));
    }
}
