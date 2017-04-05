package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;

public class IPokemonTrainerFactoryTest {

	protected IPokemonTrainerFactory iPokemonTrainerFactory;
	protected static IPokedexFactory iPokedexFactory;
	
	@Before
	public void setUp() {
		iPokemonTrainerFactory = setUpMock();
	}
	
	@Test
	public void createTrainerTest() {
		IPokedex iPokedex = IPokedexTest.setUpMock();
		PokemonTrainer pokemonTrainer = new PokemonTrainer("default", Team.INSTINCT, iPokedex);
		PokemonTrainer mockPokemonTrainer = iPokemonTrainerFactory.createTrainer("default", Team.INSTINCT, iPokedexFactory);
		assertNotNull(iPokedexFactory);
		assertNotNull(mockPokemonTrainer);
		assertEquals(mockPokemonTrainer.getName(), pokemonTrainer.getName());
		assertEquals(mockPokemonTrainer.getTeam(), pokemonTrainer.getTeam());
		assertNotNull(pokemonTrainer.getPokedex());
	}
	
	@Test
	public void test1() {
		assertNotNull(IPokedexFactoryTest.setUpMock());
	}
	
	public static IPokemonTrainerFactory setUpMock(){
		IPokemonTrainerFactory iPokemonTrainerFactory = mock(IPokemonTrainerFactory.class);
		iPokedexFactory= IPokedexFactoryTest.setUpMock();
		
		IPokemonMetadataProvider iPokemonMetadataProvider = IPokemonMetadataProviderTest.setUpMoke();
		IPokemonFactory iPokemonFactory = IPokemonFactoryTest.setUpMock();
		when(iPokemonTrainerFactory.createTrainer("default", Team.INSTINCT, iPokedexFactory)).thenAnswer(new Answer<PokemonTrainer> ()  {

			@Override
			public PokemonTrainer answer(InvocationOnMock invocation) throws Throwable {
				return new PokemonTrainer("default", Team.INSTINCT, iPokedexFactory.createPokedex(iPokemonMetadataProvider, iPokemonFactory));
			}
		});
		
		return iPokemonTrainerFactory;
	}
}
