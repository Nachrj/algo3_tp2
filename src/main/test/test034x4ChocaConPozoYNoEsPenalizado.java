@Test
public void test034x4ChocaConPozoYNoEsPenalizado{
	Jugador j = new Jugador(new CuatroxCuatro(), new Coordenada(0,0) );
	Calle calle = new Calle( new Coordenada(0,0), new Coordenada(0,1), new Pozo(), "None" );
	Tablero t = new Tablero( calle );

	j.avanzar( "derecha", tablero );

	assertEquals( 1, j.obtenerMovimientos())
}