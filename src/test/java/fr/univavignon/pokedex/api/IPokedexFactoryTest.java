package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
<<<<<<< Updated upstream
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Before;
=======
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.BeforeClass;
>>>>>>> Stashed changes
import org.junit.Test;
public class IPokedexFactoryTest {
	
	protected IPokedexFactory iPokedexFactory;
<<<<<<< Updated upstream
	
=======
<<<<<<< Updated upstream
	protected static IPokemonMetadataProvider iPokemonMetadataProvider;
=======
	
>>>>>>> Stashed changes
>>>>>>> Stashed changes
	@Before
	protected void setUp() {
		this.iPokedexFactory = setUpMock();
	}
	
	@Test
	public void firstTest() {
		assertEquals(iPokedexFactory, null);
		System.out.println("IPokedexFactoryTest.firstTest()");
	}
	
	
	// On a décidé de faire une méthode de qui configue le mock de chaque class et la retourne
	// comme ça on n'a pas à configurer les mocks chaque fois dans toutes les autres classes de tests
	public static IPokedexFactory setUpMock(){
		IPokedexFactory iPokedexFactory = mock(IPokedexFactory.class);// TODO mock ou instance
		IPokemonMetadataProvider iPokemonMetadataProvider;
		iPokemonMetadataProvider = IPokemonMetadataProviderTest.setUpMoke();
		when(iPokedexFactory.createPokedex(iPokemonMetadataProvider, null)).thenReturn(null);
		
		return iPokedexFactory;
	}
}
