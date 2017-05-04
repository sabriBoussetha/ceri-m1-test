package fr.univavignon.pokedex.api.testImpl;

import org.junit.Before;
import fr.univavignon.pokedex.api.IPokedexTest;
import fr.univavignon.pokedex.api.impl.Pokedex;

public class PokedexTest extends IPokedexTest{

	@Before
	public void setUp(){
		this.iPokedex = new Pokedex();
	}
}
