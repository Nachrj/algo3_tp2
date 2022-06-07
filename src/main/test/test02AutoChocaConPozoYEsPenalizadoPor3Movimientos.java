@Test
public void test02AutoChocaConPozoYEsPenalizadoPor3Movimientos{
	Jugador j = new Jugador(new Auto(), new Coordenada(0,0) );
	Calle calle = new Calle( new Coordenada(0,0), new Coordenada(0,1), new Pozo(), "None" );
	Tablero t = new Tablero( calle );

	j.avanzar( "derecha", tablero );

	assertEquals( 4, j.obtenerMovimientos())
}