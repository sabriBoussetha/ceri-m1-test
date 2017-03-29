package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.BeforeClass;
import org.junit.Test;
public class IPokedexFactoryTest {
	
	protected IPokedexFactory iPokedexFactory;
	
	@BeforeClass
	protected void setUp() {
		iPokedexFactory = mock(IPokedexFactory.class);// TODO mock ou instance
		when(iPokedexFactory.createPokedex(null, null)).thenReturn(null);
	}
	@Test
	public void firstTest() {
		assertEquals(iPokedexFactory, null);
		System.out.println("IPokedexFactoryTest.firstTest()");
	}
}
