package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;

public class IPokemonFactoryTest {
	
	protected IPokemonFactory iPokemonFactory;
	
	@Before
	protected void setUp(){
		this.iPokemonFactory = mock(IPokemonFactory.class);
	}
	
	@Test
	public void firstTest() {
		System.out.println("IPokemonFactoryTest.firstTest()");
	}
}
