package fr.univavignon.pokedex.api.testImpl;

import org.junit.Before;
import fr.univavignon.pokedex.api.IPokedexFactoryTest;

public class PokemonFactoryTest extends IPokedexFactoryTest{

	@Before
	protected void setUp(){
		this.iPokedexFactory = null; //TODO new instance
	}
}
