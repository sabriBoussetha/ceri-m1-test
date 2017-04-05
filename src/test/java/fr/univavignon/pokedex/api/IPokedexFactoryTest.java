package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;

public class IPokedexFactoryTest {

	protected IPokedexFactory iPokedexFactory;
	protected static IPokemonMetadataProvider iPokemonMetadataProvider;
	protected static IPokemonFactory iPokemonFactory;

	@Before
	public void setUp() {
		this.iPokedexFactory = setUpMock();
	}

	@Test
	public void createPokedexTest() {
		Pokemon p = new Pokemon(4, "Four", 4, 4, 4, 4, 4, 4, 4, 4);
		Pokemon mockP = iPokedexFactory.createPokedex(iPokemonMetadataProvider, iPokemonFactory).createPokemon(4, 4, 4, 4, 4);

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

	// On a décidé de faire une méthode de qui configue le mock de chaque class et la retourne
	// comme ça on n'a pas à configurer les mocks chaque fois dans toutes les autres classes de tests
	public static IPokedexFactory setUpMock() {
		IPokedexFactory iPokedexFactory = mock(IPokedexFactory.class);// TODO mock ou instance
		iPokemonMetadataProvider = IPokemonMetadataProviderTest.setUpMoke();
		iPokemonFactory = IPokemonFactoryTest.setUpMock();
		IPokedex ipokedex = IPokedexTest.setUpMock();
		when(iPokedexFactory.createPokedex(iPokemonMetadataProvider, iPokemonFactory)).thenReturn(ipokedex);

		return iPokedexFactory;
	}
}
