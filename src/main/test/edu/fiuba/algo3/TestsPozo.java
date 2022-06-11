package edu.fiuba.algo3;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestsPozo{
    Pozo p;
    @BeforeEach
    void init() {
        this.p = new Pozo();
    }
    @Test
    public void test01MotoChocaConPozoYPenalizaCon3Movimientos(){
        Moto mockedMoto = mock(Moto.class);
        when(mockedMoto.chocarConPozo()).thenReturn(3);
        assertEquals(3, p.chocar(mockedMoto));
    }

    @Test
    public void test02AutoChocaConPozoYPenalizaCon3Movimientos(){
        Auto mockedAuto = mock(Auto.class);
        when(mockedAuto.chocarConPozo()).thenReturn(3);
        assertEquals(3, p.chocar(mockedAuto));
    }

    @Test
    public void test034x4ChocaConPrimerPozoYNoPenaliza(){
        CuatroXCuatro mocked4x4 = mock(CuatroXCuatro.class);
        when(mocked4x4.chocarConPozo()).thenReturn(0);
        assertEquals(0, p.chocar(mocked4x4));
    }
}
