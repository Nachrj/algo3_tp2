package edu.fiuba.algo3;


import edu.fiuba.algo3.model.coordenada.Coordenada;
import edu.fiuba.algo3.model.coordenada.Derecha;
import edu.fiuba.algo3.model.obstaculo.Pozo;
import edu.fiuba.algo3.model.vehiculo.Auto;
import edu.fiuba.algo3.model.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.model.vehiculo.Moto;
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

        assertEquals(3, p.chocar(mockedMoto, new Derecha()));
    }

    @Test
    public void test02AutoChocaConPozoYPenalizaCon3Movimientos(){
        Auto mockedAuto = mock(Auto.class);

        assertEquals(3, p.chocar(mockedAuto, new Derecha()));
    }

    @Test
    public void test034x4ChocaConPrimerPozoYNoPenaliza(){
        CuatroXCuatro mocked4x4 = mock(CuatroXCuatro.class);

        assertEquals(0, p.chocar(mocked4x4, new Derecha()));
    }

    @Test
    public void test04Una4x4ChocaConCuartoPozoYPenalizaCon2Movimientos(){
        CuatroXCuatro c = new CuatroXCuatro(new Coordenada(0, 0));
        for(int i = 1; i <= 3; i++){
            p.chocar(c, new Derecha());
        }
        assertEquals(2, p.chocar(c, new Derecha()));
    }
}
