package fr.univavignon.pokedex.api.impl;

import java.net.URL;
import java.util.Comparator;
import java.util.List;

import org.jsoup.Jsoup;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.PokemonMetadata;

public class Pokedex implements IPokedex {

	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		System.out.println("Pokedex.getPokemonMetadata()");
		int defense = 0;
		int attack = 0;
		int stamina = 0;
		String name = null;
		if (DBUtils.rowExist(index)) {
			System.out.println("Pokedex.getPokemonMetadata() - exist");
			Pokemon pokemon = DBUtils.getRow(index);
			System.out.println(pokemon.getName());
			
			return new PokemonMetadata(pokemon.getIndex(), pokemon.getName(), pokemon.getAttack(), pokemon.getDefense(), pokemon.getStamina());
		} else {
			System.out.println("Pokedex.getPokemonMetadata() - not exist");
			try {
				URL url = new URL(
						"https://raw.githubusercontent.com/PokemonGo-Enhanced/node-pokemongo-data/master/data.json");

				String json = Jsoup.connect(url.toString()).ignoreContentType(true).execute().body();

				JsonArray array = new JsonParser().parse(json).getAsJsonArray();

				JsonObject object = array.get(index).getAsJsonObject();

				name = object.get("Identifier").getAsString();
				attack = object.get("BaseAttack").getAsInt();
				defense = object.get("BaseDefense").getAsInt();
				stamina = object.get("BaseStamina").getAsInt();

			} catch (Exception e) {
				e.printStackTrace();
			}
			return name != null ? new PokemonMetadata(index, name, attack, defense, stamina) : null;
		}
	}

	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		PokemonFactory pokemonFactory = new PokemonFactory();
		return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
	}

	@Override
	public int size() {
		return DBUtils.getRowsCount();
	}

	@Override
	public int addPokemon(Pokemon pokemon) {
		System.out.println("Pokedex.addPokemon()");
		DBUtils.addPokemonToDb(pokemon);
		return pokemon.getIndex();
	}

	@Override
	public Pokemon getPokemon(int id) throws PokedexException {
		return DBUtils.getRow(id);
	}

	@Override
	public List<Pokemon> getPokemons() {
		List<Pokemon> pokemons = DBUtils.getAllPokemons();
		return pokemons.size() > 0 ? pokemons : null;
	}

	@Override
	public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
		return null;
	}

}
