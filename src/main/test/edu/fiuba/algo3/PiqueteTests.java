package edu.fiuba.algo3;

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
        Moto mockedMoto = mock(Moto.class);
        when(mockedMoto.chocarConPiquete()).thenReturn(2);
        assertEquals(2, p.chocar(mockedMoto));
    }

    @Test
    public void test02AutoChocaConPiqueteYNoPenaliza(){
        Auto mockedAuto = mock(Auto.class);
        when(mockedAuto.chocarConPiquete()).thenReturn(0);
        assertEquals(0, p.chocar(mockedAuto));
    }

    @Test
    public void test034x4ChocaConPiqueteYNoPenaliza(){
        CuatroXCuatro mocked4x4 = mock(CuatroXCuatro.class);
        when(mocked4x4.chocarConPiquete()).thenReturn(0);
        assertEquals(0, p.chocar(mocked4x4));
    }
}

