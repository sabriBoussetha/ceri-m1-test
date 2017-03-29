package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import static org.mockito.Mockito.*;

public class IPokemonMetadataProviderTest {

	protected IPokemonMetadataProvider iPokemonMetadataProvider;

	@Before
	protected void setUp() throws PokedexException {
		this.iPokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
		when(iPokemonMetadataProvider.getPokemonMetadata(anyInt())).thenAnswer(new Answer<PokemonMetadata>() {

			@Override
			public PokemonMetadata answer(InvocationOnMock invocation) throws Throwable {
				return new PokemonMetadata(1, "PokeName", 50, 50, 50);
			}

		});
	}

	@Test
	public void firstTest() {
		System.out.println("IPokemonMetadataProviderTest.firstTest()");
	}

	public static IPokemonMetadataProvider setUpMoke() {
		IPokemonMetadataProvider iPokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
		try {
			when(iPokemonMetadataProvider.getPokemonMetadata(anyInt())).thenAnswer(new Answer<PokemonMetadata>() {

				@Override
				public PokemonMetadata answer(InvocationOnMock invocation) throws Throwable {
					return new PokemonMetadata((int) invocation.getArguments()[0], "PokeName", 50, 50, 50);
				}

			});
		} catch (PokedexException e) {
			e.printStackTrace();
		}
		
		return iPokemonMetadataProvider;
	}
}
