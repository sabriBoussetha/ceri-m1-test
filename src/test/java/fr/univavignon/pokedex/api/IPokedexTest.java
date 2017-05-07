package fr.univavignon.pokedex.api;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
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
	public void sizeTest() {
		int pIndex = iPokedex.size();
		assertNotNull(pIndex);
		assertEquals(pIndex, 2);
	}
	
	@Test
	public void getPokemonMetadataTest() {
		PokemonMetadata pokemonMetadata = new PokemonMetadata(4, "Charmeleon", 160, 140, 116);
		PokemonMetadata mockPokemonMetaData;
		try {
			mockPokemonMetaData = iPokedex.getPokemonMetadata(4);
			assertNotNull(mockPokemonMetaData);

			assertEquals(mockPokemonMetaData.getName(), pokemonMetadata.getName());
			assertEquals(mockPokemonMetaData.getDefense(), pokemonMetadata.getDefense());
			assertEquals(mockPokemonMetaData.getAttack(), pokemonMetadata.getAttack());
			assertEquals(mockPokemonMetaData.getIndex(), pokemonMetadata.getIndex());
			assertEquals(mockPokemonMetaData.getStamina(), pokemonMetadata.getStamina());
		} catch (PokedexException e) {
			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void createPokemonTest() throws PokedexException {
		Pokemon pokemon1 = new Pokemon(4, "Charmeleon", 160, 140, 116, 54, 15, 95, 70, 55);
		Pokemon pokemon2 = iPokedex.createPokemon(4, 54, 15, 95, 70);
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

	@Test
	public void getPokemonTest() throws PokedexException {
		Pokemon p = new Pokemon(1, "Bulbasaur", 126, 126, 90, 40, 50, 60, 70, 55);
		Pokemon mockP = iPokedex.getPokemon(1);
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
		assertEquals(4, pIndex);
	}
	
	@Test
	public void getAllPokemons(){
		List<Pokemon> pokemons = iPokedex.getPokemons();
		
		assertEquals(3, pokemons.size());
	}

	public static IPokedex setUpMock() {
		IPokedex iPokedex = mock(IPokedex.class);
		try {
			when(iPokedex.getPokemon(1)).thenAnswer(new Answer<Pokemon>() {

				@Override
				public Pokemon answer(InvocationOnMock invocation) throws Throwable {
					return new Pokemon(1, "Bulbasaur", 126, 126, 90, 40, 50, 60, 70, 55);
				}
			});

			pokemon = new Pokemon(4, "Charmeleon", 160, 140, 116, 54, 15, 95, 70, 55);
			when(iPokedex.addPokemon(pokemon)).thenAnswer(new Answer<Integer>() {

				@Override
				public Integer answer(InvocationOnMock invocation) throws Throwable {
					System.out.println("IPokedexTest.setUpMock().new Answer() {...}.answer()");
					return 4;
				}
			});
			when(iPokedex.createPokemon(4, 54, 15, 95, 70)).thenAnswer(new Answer<Pokemon>() {

				@Override
				public Pokemon answer(InvocationOnMock invocation) throws Throwable {
					return pokemon;
				}
			});

			when(iPokedex.size()).thenReturn(3);

			when(iPokedex.getPokemonMetadata(4)).thenAnswer(new Answer<PokemonMetadata>() {

				@Override
				public PokemonMetadata answer(InvocationOnMock invocation) throws Throwable {
					return new PokemonMetadata(4, "Charmeleon", 160, 140, 116);
				}
			});
			
			when(iPokedex.getPokemons()).thenAnswer(new Answer<List<Pokemon>>() {

				@Override
				public List<Pokemon> answer(InvocationOnMock invocation) throws Throwable {
					Pokemon pokemon1 = new Pokemon(1, "Bulbasaur", 126, 126, 90, 40, 50, 60, 70, 55);
					Pokemon pokemon2 = new Pokemon(4, "Charmeleon", 160, 140, 116, 54, 15, 95, 70, 55);
					Pokemon pokemon3 = new Pokemon(2, "Ivysaur", 156, 158, 120, 54, 95, 74, 194, 45);
					
					List<Pokemon> list = new ArrayList<>();
					list.add(pokemon1);
					list.add(pokemon2);
					list.add(pokemon3);
					
					return list;
				}
			});

		} catch (PokedexException e) {
			e.printStackTrace();
		}

		return iPokedex;
	}
}
