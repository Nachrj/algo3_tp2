package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class TestsPozo{
    @Test
    public void test01MotoChocaConPozoYPenalizaCon3Movimientos(){
        Pozo p = new Pozo();
        assertEquals(3, p.chocar(new Moto()));
    }

    @Test
    public void test02AutoChocaConPozoYPenalizaCon3Movimientos(){
        Pozo p = new Pozo();
        assertEquals(3, p.chocar(new Auto()));
    }

    @Test
    public void test034x4ChocaConPrimerPozoYNoPenaliza(){
        Pozo p = new Pozo();
        assertEquals(0, p.chocar(new CuatroXCuatro()));
    }
}
