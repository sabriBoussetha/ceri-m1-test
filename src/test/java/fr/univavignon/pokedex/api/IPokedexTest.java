package fr.univavignon.pokedex.api;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class IPokedexTest {

	protected IPokedex iPokedex;
	protected static Pokemon pokemon;

	@Before
	public void setUp() {
		iPokedex = setUpMock();
	}

	@Test
	public void createPokemonTest() throws PokedexException {
		Pokemon p = new Pokemon(4, "Four", 4, 4, 4, 4, 4, 4, 4, 4);
		Pokemon mockP = iPokedex.createPokemon(4, 4, 4, 4, 4);
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

	@Test
	public void getPokemonTest() throws PokedexException {
		Pokemon p = new Pokemon(4, "Four", 4, 4, 4, 4, 4, 4, 4, 4);
		Pokemon mockP = iPokedex.getPokemon(4);
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

	@Test
	public void addPokemonTest() {
		int pIndex = iPokedex.addPokemon(pokemon);
		assertNotNull(pIndex);
		assertEquals(pIndex, 4);
	}

	public static IPokedex setUpMock() {
		IPokedex iPokedex = mock(IPokedex.class);

		try {
			pokemon = new Pokemon(4, "Four", 4, 4, 4, 4, 4, 4, 4, 4);
			iPokedex = mock(IPokedex.class);
			when(iPokedex.getPokemon(4)).thenAnswer(new Answer<Pokemon>() {

				@Override
				public Pokemon answer(InvocationOnMock invocation) throws Throwable {
					return pokemon;
				}
			});

			when(iPokedex.addPokemon(pokemon)).thenReturn(4);

			when(iPokedex.createPokemon(4, 4, 4, 4, 4)).thenAnswer(new Answer<Pokemon>() {

				@Override
				public Pokemon answer(InvocationOnMock invocation) throws Throwable {
					return pokemon;
				}
			});

			when(iPokedex.size()).thenReturn(14);

			when(iPokedex.getPokemonMetadata(4)).thenAnswer(new Answer<PokemonMetadata>() {

				@Override
				public PokemonMetadata answer(InvocationOnMock invocation) throws Throwable {
					return new PokemonMetadata(4, "Four", 4, 4, 4);
				}
			});

		} catch (PokedexException e) {
			e.printStackTrace();
		}
	
		return iPokedex;
	}
}
