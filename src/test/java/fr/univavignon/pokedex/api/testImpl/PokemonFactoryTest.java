package fr.univavignon.pokedex.api.testImpl;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

import fr.univavignon.pokedex.api.IPokemonFactoryTest;
import fr.univavignon.pokedex.api.impl.PokemonFactory;

public class PokemonFactoryTest extends IPokemonFactoryTest{
	
	@Before
	public void setUp() {
		this.iPokemonFactory = new PokemonFactory(); // TODO new instance
	}
	
	@Test
	public void ivStaminaCalculator() {
		PokemonFactory pokemonFactory = new PokemonFactory();
		
		List<String> result = pokemonFactory.ivCalculator("Gengar", 1459, 77, 2500);
		
		Gson gson = new Gson();
		
		System.out.println(gson.toJson(result, List.class));
	}
}
