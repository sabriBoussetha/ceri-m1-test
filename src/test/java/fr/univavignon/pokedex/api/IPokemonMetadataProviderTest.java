package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import static org.mockito.Mockito.*;

public class IPokemonMetadataProviderTest {

	protected IPokemonMetadataProvider iPokemonMetadataProvider;

	@Before
	public void setUp() throws PokedexException {
		iPokemonMetadataProvider = setUpMoke();
	}

	@Test
	public void getPokemonMetaData() {
		try {
			System.out.println("IPokemonMetadataProviderTest.getPokemonMetaData()");
			PokemonMetadata metaData = new PokemonMetadata(1, "Bulbasaur", 126, 126, 90);
			PokemonMetadata mockMetaData = iPokemonMetadataProvider.getPokemonMetadata(1);
			
			assertEquals(mockMetaData.getAttack(), metaData.getAttack());
			assertEquals(mockMetaData.getDefense(), metaData.getDefense());
			assertEquals(mockMetaData.getIndex(), metaData.getIndex());
			assertEquals(mockMetaData.getName(), metaData.getName());
			assertEquals(mockMetaData.getStamina(), metaData.getStamina());
		} catch (PokedexException e) {
			e.printStackTrace();
		}
	}

	public static IPokemonMetadataProvider setUpMoke() {
		IPokemonMetadataProvider iPokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
		try {
			when(iPokemonMetadataProvider.getPokemonMetadata(1)).thenAnswer(new Answer<PokemonMetadata>() {

				@Override
				public PokemonMetadata answer(InvocationOnMock invocation) throws Throwable {
					return new PokemonMetadata(1, "Bulbasaur", 126, 126, 90);
				}

			});
			
		} catch (PokedexException e) {
			e.printStackTrace();
		}
		
		return iPokemonMetadataProvider;
	}
}
