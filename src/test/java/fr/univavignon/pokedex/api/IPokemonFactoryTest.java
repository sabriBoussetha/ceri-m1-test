package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class IPokemonFactoryTest {

	protected IPokemonFactory iPokemonFactory;

	@Before
	public void setUp() {
		this.iPokemonFactory = setUpMock();

	}

	
	@Test
	public void createPokemonTest() {
		Pokemon pokemon1 = new Pokemon(93, "Gengar", 204, 156, 10, 1459, 77, 2500, 100, 84.4);
		Pokemon pokemon2 = iPokemonFactory.createPokemon(93, 1459, 77, 2500, 100);
		
		assertNotNull(pokemon2);
		assertEquals(pokemon2.getIndex(), pokemon1.getIndex());
		assertEquals(pokemon2.getName(), pokemon1.getName());
		assertEquals(pokemon2.getAttack(), pokemon1.getAttack());
		assertEquals(pokemon2.getCandy(), pokemon1.getCandy());
		assertEquals(pokemon2.getCp(), pokemon1.getCp());
		assertEquals(pokemon2.getDefense(), pokemon1.getDefense());
		assertEquals(pokemon2.getDust(), pokemon1.getDust());
		assertEquals(pokemon2.getHp(), pokemon1.getHp());
		assertEquals(pokemon2.getStamina(), pokemon1.getStamina());
	}

	public static IPokemonFactory setUpMock() {
		IPokemonFactory iPokemonFactory = mock(IPokemonFactory.class);
		when(iPokemonFactory.createPokemon(93, 1459, 77, 2500, 100)).thenAnswer(new Answer<Pokemon>() {

			@Override
			public Pokemon answer(InvocationOnMock invocation) throws Throwable {
				return new Pokemon(93, "Gengar", 204, 156, 10, 1459, 77, 2500, 100, 84.4);
			}
		});
		return iPokemonFactory;
	}

}
