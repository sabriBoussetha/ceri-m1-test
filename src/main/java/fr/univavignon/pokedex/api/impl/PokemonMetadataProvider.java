package fr.univavignon.pokedex.api.impl;

import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.PokemonMetadata;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		Pokedex pokedex = new Pokedex();
		return pokedex.getPokemonMetadata(index);
	}

}
