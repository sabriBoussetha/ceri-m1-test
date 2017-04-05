package fr.univavignon.pokedex.api;

import org.junit.Before;
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
		Pokemon p = new Pokemon(4, "Four", 4, 4, 4, 4, 4, 4, 4, 4);
		Pokemon mockP = iPokemonFactory.createPokemon(4, 4, 4, 4, 4);
		
		assertNotNull(mockP);
		assertEquals(mockP.getIndex(), p.getIndex());
		assertEquals(mockP.getName(), p.getName());
		assertEquals(mockP.getAttack(), p.getAttack());
		assertEquals(mockP.getCandy(), p.getCandy());
		assertEquals(mockP.getCp(), p.getCp());
		assertEquals(mockP.getDefense(), p.getDefense());
		assertEquals(mockP.getDust(), p.getDust());
		assertEquals(mockP.getHp(), p.getHp());
		assertEquals(mockP.getStamina(), p.getStamina());
	}

	public static IPokemonFactory setUpMock() {
		IPokemonFactory iPokemonFactory = mock(IPokemonFactory.class);
		when(iPokemonFactory.createPokemon(4, 4, 4, 4, 4)).thenAnswer(new Answer<Pokemon>() {

			@Override
			public Pokemon answer(InvocationOnMock invocation) throws Throwable {
				return new Pokemon(4, "Four", 4, 4, 4, 4, 4, 4, 4, 4);
			}
		});
		return iPokemonFactory;
	}

}
