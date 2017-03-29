package fr.univavignon.pokedex.api;

import static org.mockito.Mockito.mock;
import org.junit.Before;
import org.junit.Test;

public class IPokedexTest {
	
	protected IPokedex iPokedex;
	
	@Before
	protected void setUp(){
		this.iPokedex = mock(IPokedex.class);
	}
	
	@Test
	public void firstTest() {
		System.out.println("IPokedexTest.firstTest()");
	}
}
