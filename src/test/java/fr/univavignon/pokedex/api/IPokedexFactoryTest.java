package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
public class IPokedexFactoryTest {
	
	protected IPokedexFactory iPokedexFactory;
	protected static IPokemonMetadataProvider iPokemonMetadataProvider;
	@Before
	protected void setUp() {
		setUpMock(this.iPokedexFactory);
		IPokemonMetadataProviderTest.configureMoke(iPokemonMetadataProvider);
	}
	
	@Test
	public void firstTest() {
		assertEquals(iPokedexFactory, null);
		System.out.println("IPokedexFactoryTest.firstTest()");
	}
	
	public static void setUpMock(IPokedexFactory iPokedexFactory){
		iPokedexFactory = mock(IPokedexFactory.class);// TODO mock ou instance
		when(iPokedexFactory.createPokedex(iPokemonMetadataProvider, null)).thenReturn(null);
	}
}
