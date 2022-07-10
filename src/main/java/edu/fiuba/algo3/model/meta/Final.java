package edu.fiuba.algo3.model.meta;

public class Final {
    public boolean meta(){
        return false;
    }

    public static Final conseguirInstancia(){
        return new Final();
    }
}
