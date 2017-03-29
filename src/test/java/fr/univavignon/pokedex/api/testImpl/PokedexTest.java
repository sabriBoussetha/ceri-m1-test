package fr.univavignon.pokedex.api.testImpl;

import org.junit.Before;
import fr.univavignon.pokedex.api.IPokedexTest;

public class PokedexTest extends IPokedexTest{

	@Before
	protected void setUp(){
		this.iPokedex = null; //TODO new instance
	}
}
