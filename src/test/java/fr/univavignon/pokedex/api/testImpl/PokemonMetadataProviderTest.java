package fr.univavignon.pokedex.api.testImpl;

import org.junit.Before;
import fr.univavignon.pokedex.api.IPokemonMetadataProviderTest;

public class PokemonMetadataProviderTest extends IPokemonMetadataProviderTest{

	@Before
	protected void setUp(){
		this.iPokemonMetadataProvider = null; //TODO new instance
	}
}