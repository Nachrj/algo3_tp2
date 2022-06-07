@Test
public void test05AutoEncuentraPiqueteNoSeMueve {
    Jugador j = new Jugador(new Moto(), new Coordenada(0,0) );
	Calle calle = new Calle( new Coordenada(0,0), new Coordenada(0,1), new Piquete(), "None" );
	Tablero t = new Tablero( calle );

	j.avanzar( "derecha", tablero );
    assertEquals( 1, j.obtenerMovimientos())
    Coordenada coordenada = new Coordenada(0,0);
    assertEquals(true, coordenada.equals(t.obtenerCoordenada()));
}