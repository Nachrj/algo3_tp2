package edu.fiuba.algo3;


import edu.fiuba.algo3.obstaculo.Pozo;
import edu.fiuba.algo3.vehiculo.Auto;
import edu.fiuba.algo3.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.vehiculo.Moto;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

public class PozoTests {
    Pozo p;
    @BeforeEach
    public void init() {
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

    @Test
    public void test04Una4x4ChocaConCuartoPozoYPenalizaCon2Movimientos(){
        CuatroXCuatro c = new CuatroXCuatro();
        for(int i = 1; i <= 3; i++){
            c.chocarConPozo();
        }
        assertEquals(2, c.chocarConPozo());
    }
}
