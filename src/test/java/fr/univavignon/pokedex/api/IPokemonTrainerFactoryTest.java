package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;

public class IPokemonTrainerFactoryTest {

	protected IPokemonTrainerFactory iPokemonTrainerFactory;
	
	@Before
	protected void setUp() {
		iPokemonTrainerFactory = mock(IPokemonTrainerFactory.class);
		when(iPokemonTrainerFactory.createTrainer("default", "default team", IPokedexFactory.setUpMock())).thenAnswer(new Answer<PokemonTrainer> ()  {

			@Override
			public PokemonTrainer answer(InvocationOnMock invocation) throws Throwable {
				return new PokemonTrainer((String)invocation.getArguments()[0], (Team)invocation.getArguments()[1], (IPokedex)invocation.getArguments()[2]);
			}
		});
	}
	
	@Test
	public void firstTest() {
		System.out.println("IPokemonTrainerFactoryTest.firstTest()");
	}
}
