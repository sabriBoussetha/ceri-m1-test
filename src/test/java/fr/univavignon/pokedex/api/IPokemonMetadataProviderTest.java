package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;

public class IPokemonMetadataProviderTest {
	
	protected IPokemonMetadataProvider iPokemonMetadataProvider;
	
	@Before
	protected void setUp(){
		this.iPokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
	}

	@Test
	public void firstTest() {
		System.out.println("IPokemonMetadataProviderTest.firstTest()");
	}
}
