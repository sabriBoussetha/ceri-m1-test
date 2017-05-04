package fr.univavignon.pokedex.api.testImpl;

import org.junit.Before;

import fr.univavignon.pokedex.api.IPokemonMetadataProviderTest;
import fr.univavignon.pokedex.api.impl.PokemonMetadataProvider;

public class PokemonMetadataProviderTest extends IPokemonMetadataProviderTest{

	@Before
	public void setUp(){
		System.out.println("PokemonMetadataProviderTest.setUp()");
		this.iPokemonMetadataProvider = new PokemonMetadataProvider();
	}
}
