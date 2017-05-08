package fr.univavignon.pokedex.api.testImpl;

import org.junit.Before;

import fr.univavignon.pokedex.api.IPokemonFactoryTest;
import fr.univavignon.pokedex.api.impl.PokemonFactory;

public class PokemonFactoryTest extends IPokemonFactoryTest{
	@Before
	public void setUp() {
		this.iPokemonFactory = new PokemonFactory(); 
	}
}
